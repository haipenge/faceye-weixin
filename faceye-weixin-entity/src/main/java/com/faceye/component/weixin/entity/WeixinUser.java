package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * WeixinUser ORM 实体<br>
 * 数据库表:weixin_weixinUser<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection = "weixin_weixin_user")
public class WeixinUser implements Serializable {
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
	 * 说明:OpenId<br>
	 * 属性名: openid<br>
	 * 类型: String<br>
	 * 数据库字段:openid<br>
	 * @author haipenge<br>
	 */

	private String openid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 说明:昵称<br>
	 * 属性名: nickname<br>
	 * 类型: String<br>
	 * 数据库字段:nickname<br>
	 * @author haipenge<br>
	 */

	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 说明:性别<br>
	 * 属性名: sex<br>
	 * 类型: String<br>
	 * 数据库字段:sex<br>
	 * @author haipenge<br>
	 */

	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 说明:省<br>
	 * 属性名: province<br>
	 * 类型: String<br>
	 * 数据库字段:province<br>
	 * @author haipenge<br>
	 */

	private String province;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 说明:市<br>
	 * 属性名: city<br>
	 * 类型: String<br>
	 * 数据库字段:city<br>
	 * @author haipenge<br>
	 */

	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 说明:国家<br>
	 * 属性名: country<br>
	 * 类型: String<br>
	 * 数据库字段:country<br>
	 * @author haipenge<br>
	 */

	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 说明:头像地址<br>
	 * 属性名: headimgurl<br>
	 * 类型: String<br>
	 * 数据库字段:head_img_url<br>
	 * @author haipenge<br>
	 */

	private String headimgurl;

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	/**
	 * 说明:权限<br>
	 * 属性名: privilege<br>
	 * 类型: String []<br>
	 * 数据库字段:privilege<br>
	 * @author haipenge<br>
	 */

	private String[] privilege;

	public String[] getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
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
	 * 说明:语言<br>
	 * 属性名: language<br>
	 * 类型: String<br>
	 * 数据库字段:language<br>
	 * @author haipenge<br>
	 */

	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * 所属微信公众号
	 */
	@DBRef
	private Account account = null;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	    * 说明:创建时间<br>
	    * 属性名: createDate<br>
	    * 类型: Date<br>
	    * 数据库字段:create_date<br>
	    * @author haipenge<br>
	    */

	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}/**@generate-entity-source@**/

