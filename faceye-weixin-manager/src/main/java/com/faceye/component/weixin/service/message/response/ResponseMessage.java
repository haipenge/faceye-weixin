package com.faceye.component.weixin.service.message.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 回复消息
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月27日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseMessage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -617190682134095987L;
	@XmlElement(name = "ToUserName")
	@XmlCDATA
	private String toUserName = "";
	@XmlElement(name = "FromUserName")
	@XmlCDATA
	private String fromUserName = "";
	@XmlElement(name = "CreateTime")
	private Long createTime = 0L;
	@XmlElement(name = "MsgType")
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
}
