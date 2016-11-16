package com.faceye.component.weixin.service.message.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 扫码 等待消息子对像
 * @author haipenge
 *
 */
//@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanCodeInfo {
	@XmlCDATA
	@XmlElement(name = "ScanType")
	private String scanType="";
	@XmlCDATA
	@XmlElement(name = "ScanResult")
	private String scanResult="";
	public String getScanType() {
		return scanType;
	}
	public void setScanType(String scanType) {
		this.scanType = scanType;
	}
	public String getScanResult() {
		return scanResult;
	}
	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}
	
	
}
