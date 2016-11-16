package com.faceye.component.weixin.service.message.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 富文本
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月27日
 */
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class RichText implements java.io.Serializable {
	/**
	 * 
	 */
	@XmlTransient
	private static final long serialVersionUID = -2199442361652675675L;
	@XmlElement(name = "Title")
	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String title = "";
	@XmlElement(name = "Description")
	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String description = "";
	@XmlElement(name = "PicUrl")
	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String picUrl = "";
	@XmlElement(name = "Url")
	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String url = "";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
