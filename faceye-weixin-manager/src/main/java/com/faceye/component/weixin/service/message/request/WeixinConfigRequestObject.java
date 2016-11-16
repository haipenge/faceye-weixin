package com.faceye.component.weixin.service.message.request;

/**
 * 微信js-sdk wx.config({})请求对像包装
 * @author haipenge
 *
 */
public class WeixinConfigRequestObject {
	private String appId="";
	private String noncestr = "";
	private String jsapi_ticket = "";
	private String timestamp = "";
	private String signature = "";
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
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
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	
}
