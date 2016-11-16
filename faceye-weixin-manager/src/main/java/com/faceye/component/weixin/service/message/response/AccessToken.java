package com.faceye.component.weixin.service.message.response;


/**
 * Access Token
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月18日
 */
public class AccessToken extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8879105479676617419L;

	private String access_token = "";
	private Long expires_in = 0L;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

}
