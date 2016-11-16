package com.faceye.component.weixin.service.pay.model;

/**
 * 正在支付的商品或订单明细
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月8日
 */
public class PayProductInfo {
	// 商品描述
	private String body = "";
	// 商品名称明细列表
	private String detail = "";
	// 商户系统内部的订单号,32个字符内、可包含字母, 其他说明见
	// 商户支付的订单号由商户自定义生成，微信支付要求商户订单号保持唯一性
	// （建议根据当前系统时间加随机序列来生成订单号）。
	// 重新发起一笔支付要使用原订单号，避免重复支付；
	// 已支付过或已调用关单、撤销（请见后文的API列表）的订单号不能重新发起支付
	private String outTradeNo = "";
	// 总金额，只能为分
	private Integer totalFee = 0;
	// 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	private String attach = "";
	// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	private String spbillCreateIp = "";
	// 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
	private String timeStart = "";
	private String timeExpire = "";
	// 商品标记，代金券或立减优惠功能的参数，说明详见
	private String goodsTag = "";
	// rade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	private String productId = "";
	private String openid = "";

	// 异步通知URL
	private String notifyUrl = "";

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

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
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

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

}
