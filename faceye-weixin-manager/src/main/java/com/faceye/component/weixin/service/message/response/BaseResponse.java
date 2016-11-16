package com.faceye.component.weixin.service.message.response;

public class BaseResponse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1330975416837036680L;

	private String errcode = "";
	private String errmsg = "";

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
