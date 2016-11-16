package com.faceye.component.weixin.service.pay.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 统一下单接口响应数据
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月7日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedOrderResponse {
	//SUCCESS/FAIL
	//此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	@XmlCDATA
	@XmlElement(name="return_code")
	private String returnCode="";
	@XmlCDATA
	@XmlElement(name="return_msg")
	private String returnMsg="";
	//return_code == success时返回以下字段
	@XmlCDATA
	@XmlElement(name="appid")
	private String appid="";
	
	@XmlElement(name="mch_id")
	@XmlCDATA
	private String mchId="";
	
	@XmlElement(name="device_info")
	@XmlCDATA
	private String deviceInfo="";
	
	@XmlElement(name="nonce_str")
	@XmlCDATA
	private String nonceStr="";
	
	@XmlElement(name="sign")
	@XmlCDATA
	private String sign="";
	
	//SUCCESS/FAIL
	@XmlElement(name="result_code")
	@XmlCDATA
	private String resultCode="";
	
	@XmlElement(name="err_code")
	@XmlCDATA
	private String errCode="";
	
	@XmlElement(name="err_code_des")
	@XmlCDATA
	private String errorCodeDes="";
	
	//以下字段在return_code 和result_code都为SUCCESS的时候有返回
	//调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，详细说明见
	@XmlElement(name="trade_type")
	@XmlCDATA
	private String tradeType="";
	
	//微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	@XmlElement(name="prepay_id")
	@XmlCDATA
	private String prepayId="";
	//trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
	@XmlElement(name="code_url")
	@XmlCDATA
	private String codeUrl="";
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrorCodeDes() {
		return errorCodeDes;
	}
	public void setErrorCodeDes(String errorCodeDes) {
		this.errorCodeDes = errorCodeDes;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getPrepayId() {
		return prepayId;
	}
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	public String getCodeUrl() {
		return codeUrl;
	}
	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
	
	
}
