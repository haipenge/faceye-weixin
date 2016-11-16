package com.faceye.component.weixin.service.pay.request;

import com.faceye.component.weixin.service.message.request.WeixinConfigRequest;

/**
 * 对JSAPI Pay Request的包装，用于组装weixin.config对像与weixin pay 对像(wx.config,wx.pay)
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年10月7日
 */
public class JSAPIPayRequestObject {
	private WeixinConfigRequest weixinConfigRequest = null;
	private JSAPIPayRequest jsapiPayRequest = null;
	/**
	 * 支付成功跳转URL
	 */
	private String successRedirectUrl = "";
	/**
	 * 取消支付跳转URL
	 */
	private String cancelRedirectUrl = "";
	/**
	 * 支付失败跳转URLE
	 */
	private String failRedirectUrl = "";

	public WeixinConfigRequest getWeixinConfigRequest() {
		return weixinConfigRequest;
	}

	public void setWeixinConfigRequest(WeixinConfigRequest weixinConfigRequest) {
		this.weixinConfigRequest = weixinConfigRequest;
	}

	public JSAPIPayRequest getJsapiPayRequest() {
		return jsapiPayRequest;
	}

	public void setJsapiPayRequest(JSAPIPayRequest jsapiPayRequest) {
		this.jsapiPayRequest = jsapiPayRequest;
	}

	public String getSuccessRedirectUrl() {
		return successRedirectUrl;
	}

	public void setSuccessRedirectUrl(String successRedirectUrl) {
		this.successRedirectUrl = successRedirectUrl;
	}

	public String getCancelRedirectUrl() {
		return cancelRedirectUrl;
	}

	public void setCancelRedirectUrl(String cancelRedirectUrl) {
		this.cancelRedirectUrl = cancelRedirectUrl;
	}

	public String getFailRedirectUrl() {
		return failRedirectUrl;
	}

	public void setFailRedirectUrl(String failRedirectUrl) {
		this.failRedirectUrl = failRedirectUrl;
	}
	
	

}
