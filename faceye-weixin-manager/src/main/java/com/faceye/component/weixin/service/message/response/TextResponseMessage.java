package com.faceye.component.weixin.service.message.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextResponseMessage extends ResponseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 文本消息内容
	 */
	@XmlElement(name = "Content")
	@XmlCDATA
	private String content = "";

	
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
