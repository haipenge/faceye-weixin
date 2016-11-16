package com.faceye.component.weixin.service.pay.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.JSAPITicket;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.component.weixin.service.api.MsgApi;
import com.faceye.component.weixin.service.message.request.WeixinConfigRequest;
import com.faceye.component.weixin.service.pay.PayBusinessReCallService;
import com.faceye.component.weixin.service.pay.WeixinPayService;
import com.faceye.component.weixin.service.pay.model.PayProductInfo;
import com.faceye.component.weixin.service.pay.request.CloseOrderRequest;
import com.faceye.component.weixin.service.pay.request.DownloadBillRequest;
import com.faceye.component.weixin.service.pay.request.JSAPIPayRequest;
import com.faceye.component.weixin.service.pay.request.OrderQueryRequest;
import com.faceye.component.weixin.service.pay.request.PayReCallRequest;
import com.faceye.component.weixin.service.pay.request.UnifiedOrderRequest;
import com.faceye.component.weixin.service.pay.response.CloseOrderResponse;
import com.faceye.component.weixin.service.pay.response.NotifyResponse;
import com.faceye.component.weixin.service.pay.response.OrderQueryResponse;
import com.faceye.component.weixin.service.pay.response.PayReCallResponse;
import com.faceye.component.weixin.service.pay.response.UnifiedOrderResponse;
import com.faceye.component.weixin.service.qrcode.QRCodeService;
import com.faceye.component.weixin.util.SignUtil;
import com.faceye.feature.service.PropertyService;
import com.faceye.feature.util.DateUtil;
import com.faceye.feature.util.JaxbMapper;
import com.faceye.feature.util.RandUtil;
import com.faceye.feature.util.SHAUtils;
import com.faceye.feature.util.XmlParseUtil;
import com.faceye.feature.util.bean.BeanContextUtil;
import com.faceye.feature.util.bean.BeanMapper;
import com.faceye.feature.util.http.Http;

/**
 * 微信支付
 * 
 * @author @haipenge
 * @联系:haipenge@gmail.com 创建时间:2015年7月3日
 */
@Service
public class WeixinPayServiceImpl implements WeixinPayService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private QRCodeService qrCodeService = null;
	@Autowired
	private AccountService accountService = null;
	@Autowired
	private MsgApi msgApi = null;

	// @Autowired
	// @Qualifier("payBusinessReCallServiceImpl")
//	private PayBusinessReCallService payBusinessReCallService = null;

	/**
	 * 扫码支付 weixin://wxpay/bizpayurl?sign=XXXXX&appid=XXXXX&mch_id=XXXXX&product_id=XXXXXX&time_stamp=XXXXXX&nonce_str=XXXXX
	 */
	@Override
	public PayReCallResponse scanPay(String xml) {
		// Account account = this.accountService.getAccountByAppId(appid);
		// 转换为回调请求参数
		PayReCallRequest payReCallRequest = JaxbMapper.fromXml(xml, PayReCallRequest.class);
		PayReCallResponse payReCallResponse = new PayReCallResponse();

		if (StringUtils.isNotEmpty(xml)) {
			// 解析xml,进行验签
			Map params = XmlParseUtil.toMap(xml);
			UnifiedOrderResponse unifiedOrderResponse = null;
			String appid = MapUtils.getString(params, "appid");
			String productId = MapUtils.getString(params, "product_id");
			Account account = this.accountService.getAccountByAppId(appid);
			boolean checkSignature = SignUtil.getInstance().checkSignature(params, account.getSecret());
			if (checkSignature) {
				// 验签成功，请求统一下单
				PayProductInfo payProductInfo = this.getPayBusinessReCallService().buildPayProductInfo(productId);
				unifiedOrderResponse = this.unifiedOrder(appid, payProductInfo, "");
				if (unifiedOrderResponse == null
						|| (!StringUtils.equals(unifiedOrderResponse.getResultCode(), "SUCCESS") || !StringUtils.equals(unifiedOrderResponse.getReturnCode(), "SUCCESS"))) {
					payReCallResponse.setResultCode("FAIL");
					payReCallResponse.setReturnCode("FAIL");
					payReCallResponse.setErrCodeDes("支付异常");
				} else {
					payReCallResponse.setResultCode("SUCCESS");
					payReCallResponse.setReturnCode("SUCCESS");
					payReCallResponse.setPrepayId(unifiedOrderResponse.getPrepayId());
					this.getPayBusinessReCallService().pay(productId);
				}
				payReCallResponse.setAppid(payReCallRequest.getAppid());
				payReCallResponse.setErrCodeDes("");
				payReCallResponse.setMchId(account.getMchId());
				payReCallResponse.setNonceStr(RandUtil.randString());
				String responseXml = JaxbMapper.toXml(payReCallResponse);
				Map responseParams = XmlParseUtil.toMap(responseXml);
				String sign = SignUtil.getInstance().sign(responseParams, account.getMchKey());
				payReCallResponse.setSign(sign);
			}

		}
		return payReCallResponse;

	}

	/**
	 * 生成二维码（产品或订单) 字符串 weixin://wxpay/bizpayurl?sign=XXXXX&appid=XXXXX&mch_id=XXXXX&product_id=XXXXXX&time_stamp=XXXXXX&nonce_str=XXXXX
	 * 
	 * @todo
	 * @param appid
	 * @param mchId
	 * @param productOrOrderId
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年7月7日
	 */
	public String generateQRCodeStr(String appid, String productOrOrderId) {
		Map params = new HashMap();
		Account account = this.accountService.getAccountByAppId(appid);
		params.put("appid", appid);
		params.put("mch_id", account.getMchId());
		// 标准北京时间，时区为东八区，自1970年1月1日 0点0分0秒以来的秒数。注意：部分系统取到的值为毫秒级，需要转换成秒(10位数字)。
		params.put("time_stamp", System.currentTimeMillis() / 1000);
		String randStr = RandUtil.randString();
		if (StringUtils.length(randStr) > 32) {
			randStr = StringUtils.substring(randStr, 0, 31);
		}
		params.put("nonce_str", randStr);
		params.put("product_id", productOrOrderId);
		String secret = account.getMchKey();
		String sortedKeyAndValues = SignUtil.getInstance().sortParams(params);
		String sign = SignUtil.getInstance().sign(sortedKeyAndValues, secret);
		String qrCodeStr = "weixin://wxpay/bizpayurl?" + sortedKeyAndValues + "&sign=" + sign;
		return qrCodeStr;
	}

	/**
	 * 微信统一下单接口 openid:trade_type=JSAPI，此参数必传,其它情况下,可不传递本参数 https://api.mch.weixin.qq.com/pay/unifiedorder
	 */
	@Override
	public UnifiedOrderResponse unifiedOrder(String appid, PayProductInfo payProductInfo, String tradeType) {
		UnifiedOrderResponse unifiedOrderResponse = null;
		if (StringUtils.isEmpty(tradeType)) {
			// 默认native支付,扫码支付
			tradeType = "NATIVE";
		}
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		Account account = this.accountService.getAccountByAppId(appid);
		UnifiedOrderRequest request = new UnifiedOrderRequest();
		request.setAppid(appid);
		request.setAttach(payProductInfo.getAttach());
		request.setBody(payProductInfo.getBody());
		request.setDetail(payProductInfo.getDetail());
		// 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
		request.setDeviceInfo("WEB");
		request.setFeeType("CNY");
		request.setGoodsTag(payProductInfo.getGoodsTag());
		request.setMchId(account.getMchId());
		request.setNonceStr(RandUtil.randString());
		request.setNotifyUrl(payProductInfo.getNotifyUrl());
		request.setOpenid(payProductInfo.getOpenid());
		request.setOutTradeNo(payProductInfo.getOutTradeNo());
		request.setProductId(payProductInfo.getProductId());
		request.setSpbillCreateIp(payProductInfo.getSpbillCreateIp());
		request.setTimeExpire(payProductInfo.getTimeExpire());
		request.setTimeStart(payProductInfo.getTimeStart());
		request.setTotalFee(payProductInfo.getTotalFee());
		request.setTradeType(tradeType);
		request.setOpenid(payProductInfo.getOpenid());
		String xml = JaxbMapper.toXml(request);
		Map params = XmlParseUtil.toMap(xml);
		String sign = SignUtil.getInstance().sign(params, account.getMchKey());
		request.setSign(sign);
		xml = JaxbMapper.toXml(request);
		// try {
		// xml=new String(xml.getBytes(),"UTF-8");
		// } catch (UnsupportedEncodingException e) {
		// logger.error(">>FaceYe throws Exception: --->",e);
		// }
		logger.debug(">>FaceYe unified request xml is:" + xml);
		try {
			xml = new String(xml.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
		String response = Http.getInstance().postXml(url, "UTF-8", xml);
		logger.debug(">>FaceYe unified response xml is :" + response);
		if (StringUtils.isNotEmpty(response)) {
			unifiedOrderResponse = JaxbMapper.fromXml(response, UnifiedOrderResponse.class);
		}
		return unifiedOrderResponse;
	}

	@Override
	public NotifyResponse payNotify(Boolean isPaySuccess, String msg) {
		NotifyResponse notifyResponse = new NotifyResponse();
		if (isPaySuccess) {
			notifyResponse.setReturn_code("SUCCESS");
			notifyResponse.setReturn_msg("OK");
		} else {
			notifyResponse.setReturn_code("FAIL");
			notifyResponse.setReturn_msg(msg);
		}
		return notifyResponse;
	}

	// /////////////////////////////JSAPI PAY///////////////////////////////////
	public WeixinConfigRequest buildWeixinConfigRequest(JSAPITicket jsapiTicket, String url) {
		WeixinConfigRequest weixinConfigRequest = new WeixinConfigRequest();
		String rand = RandUtil.randString();
		if (StringUtils.length(rand) > 32) {
			rand = StringUtils.substring(rand, 0, 31);
		}
		logger.debug(">>FaceYe pay page url is:" + url);
		weixinConfigRequest.setJsapi_ticket(jsapiTicket.getTicket());
		weixinConfigRequest.setNoncestr(rand);
		weixinConfigRequest.setTimestamp("" + System.currentTimeMillis() / 1000);
		weixinConfigRequest.setUrl(url.toString());
		Map configMap = BeanMapper.map(weixinConfigRequest, Map.class);
		String signStr = SignUtil.getInstance().sortParams(configMap);
		String weixinConfigSign = SHAUtils.sha(signStr);
		logger.debug(">>FaceYe weixin config sign is:" + weixinConfigSign);
		weixinConfigRequest.setSignature(weixinConfigSign);
		return weixinConfigRequest;
	}

	/**
	 * 构建 公众号支付js请求对像
	 * 
	 * @todo
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年10月7日
	 */
	public JSAPIPayRequest buildJSAPITicketRequest(Account account, UnifiedOrderResponse unifiedOrderResponse) {
		JSAPIPayRequest jsapiPayRequest = new JSAPIPayRequest();
		jsapiPayRequest.set_package("prepay_id=" + unifiedOrderResponse.getPrepayId());
		jsapiPayRequest.setAppId(unifiedOrderResponse.getAppid());
		String randStr = RandUtil.randString();
		if (StringUtils.length(randStr) > 32) {
			randStr = StringUtils.substring(randStr, 0, 31);
		}
		jsapiPayRequest.setNonceStr(randStr);
		jsapiPayRequest.setSignType("MD5");
		jsapiPayRequest.setTimeStamp("" + System.currentTimeMillis() / 1000);
		Map map = BeanMapper.map(jsapiPayRequest, Map.class);
		String _package = MapUtils.getString(map, "_package");
		map.remove("_package");
		map.put("package", _package);
		String sign = SignUtil.getInstance().sign(map, account.getMchKey());
		jsapiPayRequest.setPaySign(sign);
		return jsapiPayRequest;
	}

	/**
	 * 微信查单接口
	 * 
	 */
	@Override
	public OrderQueryResponse orderQuery(Account account, String transaction_id, String out_trade_no) {
		String url = "https://api.mch.weixin.qq.com/pay/orderquery";
		OrderQueryResponse orderQueryResponse = null;
		OrderQueryRequest orderQueryRequest = new OrderQueryRequest();
		orderQueryRequest.setAppid(account.getAppId());
		orderQueryRequest.setMch_id(account.getMchId());
		orderQueryRequest.setNonce_str(SignUtil.getInstance().randNonceStr());
		// 微信订单号优先
		if (StringUtils.isNotEmpty(transaction_id)) {
			orderQueryRequest.setTransaction_id(transaction_id);
		} else {
			orderQueryRequest.setOut_trade_no(out_trade_no);
		}
		Map map = BeanMapper.map(orderQueryRequest, Map.class);
		String sign = SignUtil.getInstance().sign(map, account.getMchKey());
		orderQueryRequest.setSign(sign);
		String xml = JaxbMapper.toXml(orderQueryRequest);
		String response = Http.getInstance().postXml(url, "UTF-8", xml);
		if (StringUtils.isNotEmpty(response)) {
			orderQueryResponse = JaxbMapper.fromXml(response, OrderQueryResponse.class);
		}
		return orderQueryResponse;
	}

	/**
	 * 微信关闭订单接口
	 */
	@Override
	public CloseOrderResponse closeOrder(Account account, String out_trade_no) {
		CloseOrderResponse closeOrderResponse = null;
		String url = "https://api.mch.weixin.qq.com/pay/closeorder";
		CloseOrderRequest closeOrderRequest = new CloseOrderRequest();
		closeOrderRequest.setAppid(account.getAppId());
		closeOrderRequest.setMch_id(account.getMchId());
		closeOrderRequest.setNonce_str(SignUtil.getInstance().randNonceStr());
		closeOrderRequest.setOut_trade_no(out_trade_no);
		Map map = BeanMapper.map(closeOrderRequest, Map.class);
		String sign = SignUtil.getInstance().sign(map, account.getMchKey());
		closeOrderRequest.setSign(sign);
		String xml = JaxbMapper.toXml(closeOrderRequest);
		String response = Http.getInstance().postXml(url, "UTF-8", xml);
		if (StringUtils.isNotEmpty(response)) {
			closeOrderResponse = JaxbMapper.fromXml(response, CloseOrderResponse.class);
		}
		return closeOrderResponse;
	}

	/**
	 * 特别说明： 1、微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致，bill_type为REVOKED； 2、微信在次日9点启动生成前一天的对账单，建议商户10点后再获取； 3、对账单中涉及金额的字段单位为“元”。 微信下载对帐单接口，返回数据描述如下：
	 * 成功时，数据以文本表格的方式返回，第一行为表头，后面各行为对应的字段内容，字段内容跟查询订单或退款结果一致，具体字段说明可查阅相应接口。 第一行为表头，根据请求下载的对账单类型不同而不同(由bill_type决定),目前有：
	 * 
	 * 当日所有订单 交易时间,公众账号ID,商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额,代金券或立减优惠金额,微信退款单号,商户退款单号,退款金额,代金券或立减优惠退款金额，退款类型，退款状态,商品名称,商户数据包,手续费,费率
	 * 
	 * 当日成功支付的订单 交易时间,公众账号ID,商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额,代金券或立减优惠金额,商品名称,商户数据包,手续费,费率
	 * 
	 * 当日退款的订单 交易时间,公众账号ID,商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额,代金券或立减优惠金额,退款申请时间,退款成功时间,微信退款单号,商户退款单号,退款金额,代金券或立减优惠退款金额,退款类型,退款状态,商品名称,商户数据包,手续费,费率
	 * 
	 * 从第二行起，为数据记录，各参数以逗号分隔，参数前增加`符号，为标准键盘1左边键的字符，字段顺序与表头一致。 倒数第二行为订单统计标题，最后一行为统计数据 总交易单数，总交易额，总退款金额，总代金券或立减优惠退款金额，手续费总金额 举例如下：
	 * 交易时间,公众账号ID,商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额,代金券或立减优惠金额,微信退款单号,商户退款单号,退款金额,代金券或立减优惠退款金额,退款类型,退款状态,商品名称,商户数据包,手续费,费率
	 * `2014-11-1016：33：45,`wx2421b1c4370ec43b,`10000100,`0,`1000,`1001690740201411100005734289,`1415640626,`085e9858e3ba5186aafcbaed1,`MICROPAY,`SUCCESS,`CFT,`CNY,`0.01,`0.0,`0,`0
	 * ,`0,`0,`,`,`被扫支付测试,`订单额外描述,`6e-05,`0.60%
	 * `2014-11-1016：46：14,`wx2421b1c4370ec43b,`10000100,`0,`1000,`1002780740201411100005729794,`1415635270,`085e9858e90ca40c0b5aee463,`MICROPAY,`SUCCESS,`CFT,`CNY,`0.01,`0.0,`0,`0
	 * ,`0,`0,`,`,`被扫支付测试,`订单额外描述,`6e-05,`0.60% 总交易单数,总交易额,总退款金额,总代金券或立减优惠退款金额,手续费总金额 `2,`0.02,`0.0,`0.0,`0.00012
	 */
	@Override
	public String downladBill(Account account, String bill_date, String bill_type, String device_info) {
		String url = "https://api.mch.weixin.qq.com/pay/downloadbill";
		DownloadBillRequest downloadBillRequest = new DownloadBillRequest();
		downloadBillRequest.setAppid(account.getAppId());
		downloadBillRequest.setMch_id(account.getMchId());
		if (StringUtils.isEmpty(bill_date)) {
			// 默认下载前一天的对帐单
			bill_date = DateUtil.formatDate(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000L), "yyyyMMdd");
		}
		downloadBillRequest.setBill_date(bill_date);
		if (StringUtils.isNotBlank(bill_type)) {
			downloadBillRequest.setBill_type(bill_type);
		}
		if (StringUtils.isNotEmpty(device_info)) {
			downloadBillRequest.setDevice_info(device_info);
		}
		downloadBillRequest.setNonce_str(SignUtil.getInstance().randNonceStr());
		Map map = BeanMapper.map(downloadBillRequest, Map.class);
		String sign = SignUtil.getInstance().sign(map, account.getMchKey());
		downloadBillRequest.setSign(sign);
		String xml = JaxbMapper.toXml(downloadBillRequest);
		String response = Http.getInstance().postXml(url, "UTF-8", xml);
		return response;
	}

	private PayBusinessReCallService getPayBusinessReCallService() {
		return BeanContextUtil.getInstance().getBean(BeanContextUtil.getInstance().getBean(PropertyService.class).get("weixin.pay.business.recall.bean.name"));
	}
}
