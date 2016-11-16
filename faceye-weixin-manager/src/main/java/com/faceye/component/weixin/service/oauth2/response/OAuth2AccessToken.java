package com.faceye.component.weixin.service.oauth2.response;

import com.faceye.component.weixin.service.message.response.BaseResponse;

/**
 * oauth2的access_token
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月3日
 */
public class OAuth2AccessToken extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1586223504844400919L;
	private String access_token = "";
	// 单位 s
	private Long expires_in = 0L;

	private String refresh_token = "";

	private String openid = "";

	private String scope = "";
	
	private String unionid="";

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

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}
