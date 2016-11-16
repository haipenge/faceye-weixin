package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * OAuth2CodeHistory ORM 实体<br>
 * 数据库表:weixin_oauth2CodeHistory<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection="weixin_oauth2CodeHistory")
public class OAuth2CodeHistory implements Serializable {
	private static final long serialVersionUID = 8926119711730830203L;
	@Id
	private  Long id=null;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

   /**
    * 说明:授权码<br>
    * 属性名: code<br>
    * 类型: String<br>
    * 数据库字段:code<br>
    * @author haipenge<br>
    */
    
	private  String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

	
   /**
    * 说明:创建日期<br>
    * 属性名: createDate<br>
    * 类型: Date<br>
    * 数据库字段:create_date<br>
    * @author haipenge<br>
    */
    
	private  Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}/**@generate-entity-source@**/
	
