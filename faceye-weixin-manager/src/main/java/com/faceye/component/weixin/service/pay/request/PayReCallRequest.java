package com.faceye.component.weixin.service.pay.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 扫码支付回调请求数据
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月8日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayReCallRequest {
	@XmlElement(name = "appid")
	private String appid = "";
	@XmlElement(name = "openid")
	private String openid = "";
	@XmlElement(name = "mch_id")
	private String mchId = "";
	// 用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
	@XmlElement(name = "is_subscribe")
	private String isSubscribe = "";

	@XmlElement(name = "nonce_str")
	private String nonceStr = "";
	@XmlElement(name = "product_id")
	private String productId = "";

	@XmlElement(name = "sign")
	private String sign = "";

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
}
