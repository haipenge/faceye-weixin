package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ResponseContent ORM 实体<br>
 * 数据库表:weixin_responseContent<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection = "weixin_response_content")
public class ResponseContent implements Serializable {
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
	 * @author haipenge<br>
	 */

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 说明:响应内容<br>
	 * 属性名: content<br>
	 * 类型: String<br>
	 * 数据库字段:content<br>
	 * @author haipenge<br>
	 */

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 所属微信帐户
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
	 * 响应分类
	 */
	@DBRef
	private ResponseType responseType = null;

	public ResponseType getResponseType() {
		return responseType;
	}

	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	/**
	 * 响应消息类型
	 */
	@DBRef
	private ResponseMessageType responseMessageType = null;

	public ResponseMessageType getResponseMessageType() {
		return responseMessageType;
	}

	public void setResponseMessageType(ResponseMessageType responseMessageType) {
		this.responseMessageType = responseMessageType;
	}


   /**
    * 说明:是否有效<br>
    * 属性名: isEnabled<br>
    * 类型: Boolean<br>
    * 数据库字段:is_enabled<br>
    * @author haipenge<br>
    */
    
	private  Boolean isEnabled=false;
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	private Date createDate=new Date();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}/**@generate-entity-source@**/
	
