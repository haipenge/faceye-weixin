package com.faceye.component.weixin.service.pay.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 微信关闭订单
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年11月8日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CloseOrderRequest {
	// 公众账号ID
	@XmlElement(name = "appid")
	@XmlCDATA
	private String appid = "";
	// 微信支付分配的商户号
	@XmlElement(name = "mch_id")
	@XmlCDATA
	private String mch_id = "";
	// 商户系统内部的订单号
	@XmlElement(name = "out_trade_no")
	@XmlCDATA
	private String out_trade_no = "";
	// 商户系统内部的订单号,32个字符内、可包含字母, 其
	@XmlElement(name = "nonce_str")
	@XmlCDATA
	private String nonce_str = "";
	// 签名
	@XmlElement(name = "sign")
	@XmlCDATA
	private String sign = "";

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
