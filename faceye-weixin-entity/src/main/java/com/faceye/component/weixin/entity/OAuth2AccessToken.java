package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * OAuth2AccessToken ORM 实体<br>
 * 数据库表:weixin_oauth2AccessToken<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection = "weixin_oauth2_access_token")
public class OAuth2AccessToken implements Serializable {
	private static final long serialVersionUID = 8926119711730830203L;
	@Id
	private Long id = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 说明:微信帐户<br>
	 * 属性名: account<br>
	 * 类型: Account<br>
	 * 数据库字段:account_id<br>
	 * @author haipenge<br>
	 */
    @DBRef
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * Access token 所属微信用户
	 */
	@DBRef
	private WeixinUser weixinUser = null;

	public WeixinUser getWeixinUser() {
		return weixinUser;
	}

	public void setWeixinUser(WeixinUser weixinUser) {
		this.weixinUser = weixinUser;
	}

	/**
	    * 说明:Access Token<br>
	    * 属性名: accessToken<br>
	    * 类型: String<br>
	    * 数据库字段:access_token<br>
	    * @author haipenge<br>
	    */

	private String accessToken = "";

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 说明:RefreshAccessToken<br>
	 * 属性名: refreshAccessToken<br>
	 * 类型: String<br>
	 * 数据库字段:refresh_access_token<br>
	 * @author haipenge<br>
	 */

	private String refreshAccessToken = "";

	public String getRefreshAccessToken() {
		return refreshAccessToken;
	}

	public void setRefreshAccessToken(String refreshAccessToken) {
		this.refreshAccessToken = refreshAccessToken;
	}

	/**
	 * 说明:壗时时间(s)<br>
	 * 属性名: expiresIn<br>
	 * 类型: Long<br>
	 * 数据库字段:expires_in<br>
	 * @author haipenge<br>
	 */

	private Long expiresIn = 0L;

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * 说明:Unionid<br>
	 * 属性名: unionid<br>
	 * 类型: String<br>
	 * 数据库字段:unionid<br>
	 * @author haipenge<br>
	 */

	private String unionid;

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * 最后获取Token的时间
	 */
	private Date lastRefreshDate = new Date();

	public Date getLastRefreshDate() {
		return lastRefreshDate;
	}

	public void setLastRefreshDate(Date lastRefreshDate) {
		this.lastRefreshDate = lastRefreshDate;
	}

	/**
	 * 创建时间
	 */
	private Date createDate = new Date();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



   /**
    * 说明:Openid<br>
    * 属性名: openid<br>
    * 类型: String<br>
    * 数据库字段:openid<br>
    * @author haipenge<br>
    */
    
	private  String openid="";
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	

	
  
	
}/**@generate-entity-source@**/
	
