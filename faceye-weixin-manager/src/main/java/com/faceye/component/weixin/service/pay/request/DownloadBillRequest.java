package com.faceye.component.weixin.service.pay.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 下载微信对帐单
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年11月8日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class DownloadBillRequest {
	// 微信分配的公众账号ID（企业号corpid即为此appId）
	@XmlElement(name = "appid")
	@XmlCDATA
	private String appid = "";
	// 微信支付分配的商户号
	@XmlElement(name = "mch_id")
	@XmlCDATA
	private String mch_id = "";
	// 微信支付分配的终端设备号，填写此字段，只下载该设备号的对账单
	@XmlElement(name = "device_info")
	@XmlCDATA
	private String device_info = "";
	// 随机字符串，不长于32位
	@XmlElement(name = "nonce_str")
	@XmlCDATA
	private String nonce_str = "";
	// sign
	@XmlElement(name = "sign")
	@XmlCDATA
	private String sign = "";
	// 下载对账单的日期，格式：20140603
	@XmlElement(name = "bill_date")
	@XmlCDATA
	private String bill_date = "";
	// 下载对账单的日期，格式：20140603
	// ALL，返回当日所有订单信息，默认值
	// SUCCESS，返回当日成功支付的订单
	// REFUND，返回当日退款订单
	// REVOKED，已撤销的订单
	@XmlElement(name = "bill_type")
	@XmlCDATA
	private String bill_type = "ALL";
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getBill_date() {
		return bill_date;
	}
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}
	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
	
	
}
