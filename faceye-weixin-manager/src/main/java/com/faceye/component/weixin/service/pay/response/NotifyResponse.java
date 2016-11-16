package com.faceye.component.weixin.service.pay.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotifyResponse {
	// SUCCESS/FAIL
	// SUCCESS表示商户接收通知成功并校验成功
	@XmlElement(name = "return_code")
	@XmlCDATA
	private String return_code = "";
	// 返回信息，如非空，为错误原因：
	// 签名失败
	// 参数格式校验错误
	@XmlElement(name = "return_msg")
	@XmlCDATA
	private String return_msg = "";

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

}
