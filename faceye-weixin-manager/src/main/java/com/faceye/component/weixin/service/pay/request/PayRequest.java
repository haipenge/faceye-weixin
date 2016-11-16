package com.faceye.component.weixin.service.pay.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 提交被扫支付 API
 * URL: https://api.mch.weixin.qq.com/pay/micropay 具体的post数据格式如:
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月3日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayRequest implements java.io.Serializable {

	@XmlElement(name = "appid")
	private String appid = "";

	@XmlElement(name = "attach")
	@XmlCDATA
	private String attach = "";

	@XmlElement(name = "auth_code")
	private String authCode = "";

	@XmlElement(name = "body")
	@XmlCDATA
	private String body = "";

	@XmlElement(name = "device_info")
	private String deviceInfo = "";

	@XmlElement(name = "goods_tag")
	private String goodsTag = "";

	@XmlElement(name = "mch_id")
	private String mchId = "";

	@XmlElement(name = "nonce_str")
	private String nonceStr = "";

	@XmlElement(name = "out_trade_no")
	private String outTradeNo = "";

	@XmlElement(name = "spbill_create_ip")
	private String spbillCreateIp = "";

	@XmlElement(name = "time_expire")
	private String timeExpire = "";

	@XmlElement(name = "time_start")
	private String timeStart = "";

	@XmlElement(name = "total_fee")
	private Integer totalFee = 0;

	@XmlElement(name = "sign")
	private String sign = "";

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
