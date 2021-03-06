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
 * ResponseType ORM 实体<br>
 * 数据库表:weixin_responseType<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection="weixin_response_type")
public class ResponseType implements Serializable {
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
	

	
   /**
    * 说明:编码<br>
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
	
}/**@generate-entity-source@**/
	
