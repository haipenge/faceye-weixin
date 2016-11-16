package com.faceye.component.weixin.service.pay.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 关闭订单响应数据
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年11月8日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CloseOrderResponse {
	// 返回状态码.SUCCESS/FAIL
	@XmlElement(name = "return_code")
	@XmlCDATA
	private String return_code = "";
	// 返回信息，如非空，为错误原因
	// 签名失败
	// 参数格式校验错误
	@XmlElement(name = "return_msg")
	@XmlCDATA
	private String return_msg = "";

	// ////////////////////////////////////////////////////////////////////////////////////
	// 以下字段在return_code为SUCCESS的时候有返回
	// 微信分配的公众账号ID
	@XmlElement(name = "appid")
	@XmlCDATA
	private String appid = "";
	// 微信支付分配的商户号
	@XmlElement(name = "mch_id")
	@XmlCDATA
	private String mch_id = "";
	// 随机字符串，不长于32位
	@XmlElement(name = "nonce_str")
	@XmlCDATA
	private String nonce_str = "";
	// 签名
	@XmlElement(name = "sign")
	@XmlCDATA
	private String sign = "";
	@XmlElement(name = "err_code")
	@XmlCDATA
	private String err_code = "";
	@XmlElement(name = "err_code_des")
	@XmlCDATA
	private String err_code_des = "";

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

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

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

}
