package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.faceye.component.security.entity.User;
import com.faceye.feature.service.PropertyService;
import com.faceye.feature.util.bean.BeanContextUtil;

/**
 * Account ORM 实体<br>
 * 数据库表:weixin_account<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection = "weixin_account")
public class Account implements Serializable {
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
	 * 说明:AppId<br>
	 * 属性名: appId<br>
	 * 类型: String<br>
	 * 数据库字段:app_id<br>
	 * @author haipenge<br>
	 */

	private String appId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 说明:应用密钥<br>
	 * 属性名: secret<br>
	 * 类型: String<br>
	 * 数据库字段:secret<br>
	 * @author haipenge<br>
	 */

	private String secret;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * 说明:最后一次获取Token时间<br>
	 * 属性名: lastGotAccessTokenDate<br>
	 * 类型: Date<br>
	 * 数据库字段:last_got_access_token_date<br>
	 * @author haipenge<br>
	 */

	private Date lastGotAccessTokenDate;

	public Date getLastGotAccessTokenDate() {
		return lastGotAccessTokenDate;
	}

	public void setLastGotAccessTokenDate(Date lastGotAccessTokenDate) {
		this.lastGotAccessTokenDate = lastGotAccessTokenDate;
	}

	/**
	 * 说明:帐户 类型<br>
	 * 属性名: accountType<br>
	 * 类型: Integer<br>
	 * 数据库字段:account_type<br>
	 * @author haipenge<br>
	 */

	private Integer accountType;

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	/**
	 * 说明:AccessToken<br>
	 * 属性名: accessToken<br>
	 * 类型: String<br>
	 * 数据库字段:access_token<br>
	 * @author haipenge<br>
	 */

	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 关联用户
	 */
	@DBRef
	private User user = null;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Token 是否过期
	 * @todo
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月18日
	 */
	public boolean isTokenExpire() {
		boolean isExpire = true;
		if (this.getLastGotAccessTokenDate() != null) {
			// 提前10分钟过期
			if (this.getLastGotAccessTokenDate().getTime() + 7200000L + 10 * 60 * 1000L <= System.currentTimeMillis()) {
				isExpire = true;
			} else {
				isExpire = false;
			}
		}
		return isExpire;
	}



   /**
    * 说明:微信帐户,开发者微信号<br>
    * 属性名: weixinName<br>
    * 类型: String<br>
    * 数据库字段:weixin_name<br>
    * @author haipenge<br>
    */
    
	private  String weixinName;
	public String getWeixinName() {
		return weixinName;
	}
	public void setWeixinName(String weixinName) {
		this.weixinName = weixinName;
	}
	

	
   /**
    * 说明:开发者 Token<br>
    * 属性名: token<br>
    * 类型: String<br>
    * 数据库字段:token<br>
    * @author haipenge<br>
    */
    
	private  String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

	
   /**
    * 说明:回密字符<br>
    * 属性名: encodingAesKey<br>
    * 类型: String<br>
    * 数据库字段:encoding_aes_key<br>
    * @author haipenge<br>
    */
    
	private  String encodingAesKey;
	public String getEncodingAesKey() {
		return encodingAesKey;
	}
	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}
	

	
   /**
    * 说明:商户ID<br>
    * 属性名: mchId<br>
    * 类型: String<br>
    * 数据库字段:mch_id<br>
    * @author haipenge<br>
    */
    
	private  String mchId;
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	

	
   /**
    * 说明:商户支付Key<br>
    * 属性名: mchKey<br>
    * 类型: String<br>
    * 数据库字段:mch_key<br>
    * @author haipenge<br>
    */
    
	private  String mchKey;
	public String getMchKey() {
		return mchKey;
	}
	public void setMchKey(String mchKey) {
		this.mchKey = mchKey;
	}
	

	
   /**
    * 说明:AppSecret(OpenId)<br>
    * 属性名: appSecret<br>
    * 类型: String<br>
    * 数据库字段:app_secret<br>
    * @author haipenge<br>
    */
    
	private  String appSecret;
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	

	
   /**
    * 说明:主机域名<br>
    * 属性名: host<br>
    * 类型: String<br>
    * 数据库字段:host<br>
    * @author haipenge<br>
    */
    
	private  String host="";
	public String getHost() {
		if(StringUtils.isEmpty(host)){
			String weixinHost=BeanContextUtil.getInstance().getBean(PropertyService.class).get("weixin.host");
			if(!StringUtils.contains(weixinHost, "$")){
				host=weixinHost;
			}
		}
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	

	
   /**
    * 说明:名称<br>
    * 属性名: name<br>
    * 类型: String<br>
    * 数据库字段:name<br>
    * @author haipenge<br>
    */
    
	private  String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}/**@generate-entity-source@**/
	
