package com.faceye.component.weixin.service.pay.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 统一下单接口请求数据
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月7日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedOrderRequest {
	@XmlElement(name="appid")
	private String appid="";
	//商户ID
	@XmlElement(name="mch_id")
	private String mchId="";
	//设备号
	
	@XmlElement(name="device_info")
	private String deviceInfo="";
	
	@XmlElement(name="nonce_str")
	private String nonceStr="";

	@XmlElement(name="sign")
	private String sign="";
	//商品描述
	@XmlElement(name="body")
	private String body="";
	//商品详情
	@XmlElement(name="detail")
	private String detail="";
	//附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	@XmlElement(name="attach")
	private String attach="";
	//商户系统内部的订单号,32个字符内
	@XmlElement(name="out_trade_no")
	private String outTradeNo;
	
	//符合ISO 4217标准的三位字母代码，默认人民币：CNY
	@XmlElement(name="fee_type")
	private String feeType="CNY";
	
	//订单总金额，只能为整数(单位:分)
	@XmlElement(name="total_fee")
	private Integer totalFee=0;
	
	//APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
	@XmlElement(name="spbill_create_ip")
	private String spbillCreateIp="";
	//订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
	@XmlElement(name="time_start")
	private String timeStart="";
	//订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。注意：最短失效时间间隔必须大于5分钟
	@XmlElement(name="time_expire")
	private String timeExpire="";
	
	//商品标记，代金券或立减优惠功能的参数，说明详见
	@XmlElement(name="goods_tag")
	private String goodsTag="";
	
	//接收微信支付异步通知回调地址
	@XmlElement(name="notify_url")
	private String notifyUrl="";
	//取值如下：JSAPI，NATIVE，APP，WAP,
	@XmlElement(name="trade_type")
	private String tradeType="";
	
	//rade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	@XmlElement(name="product_id")
	private String productId="";
	//rade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。
	@XmlElement(name="openid")
	private String openid="";
	//no_credit--指定不能使用信用卡支付
	@XmlElement(name="limit_pay")
    private String limitPay="no_credit";
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public Integer getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeExpire() {
		return timeExpire;
	}
	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}
	public String getGoodsTag() {
		return goodsTag;
	}
	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getLimitPay() {
		return limitPay;
	}
	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}
	
}
