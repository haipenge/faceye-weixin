package com.faceye.component.weixin.service.message.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 加密类型消息
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月27日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class EncryptResponseMessage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8624933838546240565L;
	@XmlCDATA
	@XmlElement(name = "Encrypt")
	private String encrypt = "";
	@XmlCDATA
	@XmlElement(name = "Nonce")
	private String nonce = "";
	@XmlElement(name = "TimeStamp")
	private Long timeStamp = 0L;
	@XmlCDATA
	@XmlElement(name = "MsgSignature")
	private String msgSignature = "";

	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	// @XmlJavaTypeAdapter(value = CDATAAdapter.class)

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMsgSignature() {
		return msgSignature;
	}

	public void setMsgSignature(String msgSignature) {
		this.msgSignature = msgSignature;
	}

}
