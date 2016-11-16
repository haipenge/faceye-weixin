package com.faceye.component.weixin.service.pay;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.JSAPITicket;
import com.faceye.component.weixin.service.message.request.WeixinConfigRequest;
import com.faceye.component.weixin.service.pay.model.PayProductInfo;
import com.faceye.component.weixin.service.pay.request.JSAPIPayRequest;
import com.faceye.component.weixin.service.pay.response.CloseOrderResponse;
import com.faceye.component.weixin.service.pay.response.NotifyResponse;
import com.faceye.component.weixin.service.pay.response.OrderQueryResponse;
import com.faceye.component.weixin.service.pay.response.PayReCallResponse;
import com.faceye.component.weixin.service.pay.response.UnifiedOrderResponse;

/**
 * 微信支付
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月3日
 */
public interface WeixinPayService {

	/**
	 * 扫码支付
	 * @todo
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月7日
	 */
	public PayReCallResponse scanPay(String xml);

	/**
	 * 生成二维码（产品或订单) 字符串
	 * @todo
	 * @param appid
	 * @param mchId
	 * @param productOrOrderId
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月7日
	 */
	public String generateQRCodeStr(String appid, String productOrOrderId);

	/**
	 * 统一下单接口
	 * @todo
	 * @param appid
	 * @param productOrOrderId
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月7日
	 */
	public UnifiedOrderResponse unifiedOrder(String appid, PayProductInfo payProductInfo, String tradeType);

	/**
	 * 支付通知 商户-》通知微信 
	 * @todo
	 * @param isPaySuccess
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年9月26日
	 */
	public NotifyResponse payNotify(Boolean isPaySuccess, String msg);

	/**
	 * 构建weixin config 对像(js-sdk).wx.config()
	 * @todo
	 * @param jsapiTicket
	 * @param url
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月7日
	 */
	public WeixinConfigRequest buildWeixinConfigRequest(JSAPITicket jsapiTicket, String url);

	/**
	 * 构建weixin js pay 请求对像数据,wx.chooseWXPay()
	 * @todo
	 * @param account
	 * @param unifiedOrderResponse
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月7日
	 */
	public JSAPIPayRequest buildJSAPITicketRequest(Account account, UnifiedOrderResponse unifiedOrderResponse);

	/**
	 * 微信查单接口
	 * @todo
	 * @param account
	 * @param transaction_id
	 * @param out_trade_no
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年11月8日
	 */
	public OrderQueryResponse orderQuery(Account account, String transaction_id, String out_trade_no);

	/**
	 * 微信关闭订单接口
	 * @todo
	 * @param account
	 * @param out_trade_no，商户订单号（非微信订单号）
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年11月8日
	 */
	public CloseOrderResponse closeOrder(Account account, String out_trade_no);

	/**
	 * 微信下载对帐单接口
	 * @todo
	 * @param account
	 * @param bill_date，20151001
	 * @param bill_type，ALL
	 * @param device_info,""
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年11月8日
	 */
	public String downladBill(Account account, String bill_date, String bill_type, String device_info);
}
