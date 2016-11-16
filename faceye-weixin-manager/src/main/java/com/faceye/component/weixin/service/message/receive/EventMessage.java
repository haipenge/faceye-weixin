package com.faceye.component.weixin.service.message.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventMessage implements java.io.Serializable,RMessage {
	/**
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月17日 下午7:23:20
	 */
	private static final long serialVersionUID = 3859808241846526802L;
	@XmlCDATA
	@XmlElement(name = "Event")
	private String event = "";
	@XmlCDATA
	@XmlElement(name = "EventKey")
	private String eventKey = "";
	@XmlCDATA
	@XmlElement(name = "Ticket")
	private String ticket = "";
	@XmlCDATA
	@XmlElement(name = "Latitude")
	private String latitude = "";
	@XmlCDATA
	@XmlElement(name = "Longitude")
	private String longitude = "";
	@XmlCDATA
	@XmlElement(name = "Precision")
	private String precision = "";

	/**
	 * 开发者微信号（接收消息)
	 */
	@XmlElement(name = "ToUserName")
	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String toUserName = "";
	/**
	 * 发送方帐号（一个OpenID）->接收消息时
	 */
	@XmlElement(name = "FromUserName")
	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)
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
	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)
	@XmlCDATA
	private String msgType = "";
	
	/**
	 * 扫描等待子对像
	 */
	@XmlElement(name = "ScanCodeInfo")
	private  ScanCodeInfo scanCodeInfo =null;

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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public ScanCodeInfo getScanCodeInfo() {
		return scanCodeInfo;
	}

	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}
	
	

}
