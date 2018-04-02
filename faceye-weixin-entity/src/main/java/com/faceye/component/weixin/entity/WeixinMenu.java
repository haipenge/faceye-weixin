package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * WeixinMenu ORM 实体<br>
 * 数据库表:weixin_weixinMenu<br>
 * 
 * @author @haipenge <br>
 *         haipenge@gmail.com<br>
 *         Create Date:2014年5月21日<br>
 */
@Document(collection = "weixin_weixin_menu")
public class WeixinMenu implements Serializable {
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
	 * 说明:名称<br>
	 * 属性名: name<br>
	 * 类型: String<br>
	 * 数据库字段:name<br>
	 * 
	 * @author haipenge<br>
	 */
	@Size(min = 2, max = 7, message = "{weixin.weixinMenu.name.length.limit}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 说明:类型<br>
	 * 属性名: type<br>
	 * 类型: String<br>
	 * 数据库字段:type<br>
	 * 
	 * @author haipenge<br>
	 */
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 说明:Key<br>
	 * 属性名: key<br>
	 * 类型: String<br>
	 * 数据库字段:key<br>
	 * 
	 * @author haipenge<br>
	 */

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 说明:URL<br>
	 * 属性名: url<br>
	 * 类型: String<br>
	 * 数据库字段:url<br>
	 * 
	 * @author haipenge<br>
	 */

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 说明:Media ID<br>
	 * 属性名: mediaId<br>
	 * 类型: String<br>
	 * 数据库字段:media_id<br>
	 * 
	 * @author haipenge<br>
	 */

	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	private Date createDate = new Date();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 微信帐户
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
	 * 上级菜单Id
	 */
	// @DBRef
	// private WeixinMenu weixinMenu = null;
	//
	// public WeixinMenu getWeixinMenu() {
	// return weixinMenu;
	// }
	//
	// public void setWeixinMenu(WeixinMenu weixinMenu) {
	// this.weixinMenu = weixinMenu;
	// }
	private Long weixinMenuId = null;

	public Long getWeixinMenuId() {
		return weixinMenuId;
	}

	public void setWeixinMenuId(Long weixinMenuId) {
		this.weixinMenuId = weixinMenuId;
	}
	/**
	 * 菜单排序索引值，每一级 0-N，0排第1,默认新加的index自动加1
	 */
	private Integer orderIndex=0;

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	

}/** @generate-entity-source@ **/
