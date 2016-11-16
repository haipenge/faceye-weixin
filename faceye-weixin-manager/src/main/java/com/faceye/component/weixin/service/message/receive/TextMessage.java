package com.faceye.component.weixin.service.message.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextMessage implements java.io.Serializable,RMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 703794196232572069L;

	/**
	 * 文本消息内容
	 */
	@XmlCDATA
	@XmlElement(name = "Content")
	private String content = "";

	// 消息id，64位整型
	@XmlElement(name = "MsgId")
	private Long msgId = 0L;
	
	
	/**
	 * 开发者微信号（接收消息)
	 */
	@XmlElement(name = "ToUserName")
//	@XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String toUserName = "";
	/**
	 * 发送方帐号（一个OpenID）->接收消息时
	 */
	@XmlElement(name = "FromUserName")
//	@XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String fromUserName = "";
	/**
	 * 消息创建时间 （整型）
	 */
	@XmlElement(name = "CreateTime")
	private Long createTime = 0L;
	/*
	 * 消息类型 :文本-》text
	 */
	@XmlElement(name = "MsgType")
//	@XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String msgType = "";
	


	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	
	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	
	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
}
