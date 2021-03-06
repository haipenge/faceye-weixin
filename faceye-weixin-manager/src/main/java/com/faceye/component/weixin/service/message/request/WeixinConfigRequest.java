package com.faceye.component.weixin.service.message.request;

/**
 * 微信js-sdk wx.cofig 的请求参数
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年10月7日
 */
public class WeixinConfigRequest {
	private String noncestr = "";
	private String jsapi_ticket = "";
	private String timestamp = "";
	private String url = "";
	private String signature = "";

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getJsapi_ticket() {
		return jsapi_ticket;
	}

	public void setJsapi_ticket(String jsapi_ticket) {
		this.jsapi_ticket = jsapi_ticket;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
