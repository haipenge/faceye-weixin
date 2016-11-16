package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.faceye.feature.service.PropertyService;
import com.faceye.feature.util.bean.BeanContextUtil;

/**
 * ResponseContentItem ORM 实体<br>
 * 数据库表:weixin_responseContentItem<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection = "weixin_response_content_item")
public class ResponseContentItem implements Serializable {
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
	 * 说明:备注<br>
	 * 属性名: remark<br>
	 * 类型: String<br>
	 * 数据库字段:remark<br>
	 * @author haipenge<br>
	 */

	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 说明:链接<br>
	 * 属性名: url<br>
	 * 类型: String<br>
	 * 数据库字段:url<br>
	 * @author haipenge<br>
	 */

	private String url;

	public String getUrl() {
//		String weixinHost=BeanContextUtil.getInstance().getBean(PropertyService.class).get("weixin.host");
//		if(StringUtils.isNotEmpty(url)&&StringUtils.isNotEmpty(weixinHost)){
//			url=weixinHost+url;
//		}
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 说明:图片链接<br>
	 * 属性名: picUrl<br>
	 * 类型: String<br>
	 * 数据库字段:pic_url<br>
	 * @author haipenge<br>
	 */

	private String picUrl;

	public String getPicUrl() {
		String weixinImgHost=BeanContextUtil.getInstance().getBean(PropertyService.class).get("weixin.img.host");
		if(StringUtils.isNotEmpty(picUrl)&& StringUtils.isNotEmpty(weixinImgHost)){
			picUrl=weixinImgHost+picUrl;
		}
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	/**
	 * 所属消息
	 */
	@DBRef
	private ResponseContent responseContent = null;

	public ResponseContent getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(ResponseContent responseContent) {
		this.responseContent = responseContent;
	}

	private Date createDate=new Date();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
	}
	
}
/**@generate-entity-source@**/

