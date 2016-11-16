package com.faceye.component.weixin.service.pay.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 被扫支付响应数据
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月3日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayResponse implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1857590239586890979L;
	@XmlElement(name="return_code")
	@XmlCDATA
	private String returnCode="";
	
	@XmlElement(name="return_msg")
	@XmlCDATA
	private String returnMsg="";
	
	@XmlElement(name="appid")
	@XmlCDATA
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
	
	@XmlElement(name="result_code")
	@XmlCDATA
	private String resultCode="";
	
	@XmlElement(name="openid")
	@XmlCDATA
	private String openid="";
	
	@XmlElement(name="is_subscribe")
	@XmlCDATA
	private String isSubscribe="";
	
	@XmlElement(name="trade_type")
	@XmlCDATA
	private String tradeType="";
	
	@XmlElement(name="total_fee")
	private Integer totalFee=0;

	@XmlElement(name="coupon_fee")
	private Integer couponFee=0;
	
	@XmlElement(name="fee_type")
	@XmlCDATA
	private String feeType="";

	@XmlElement(name="transaction_id")
	@XmlCDATA
	private String transactionId="";
	
	@XmlElement(name="out_trade_no")
	@XmlCDATA
	private String outTradeNo="";
	
	@XmlElement(name="attach")
	@XmlCDATA
	private String attach="";
	
	@XmlElement(name="time_end")
	@XmlCDATA
	private String timeEnd="";
	
	@XmlElement(name="err_code")
	@XmlCDATA
	private String errCode="";

	@XmlElement(name="err_code_des")
	@XmlCDATA
	private String errCodeDes="";
	
	@XmlElement(name="bank_type")
	@XmlCDATA
	private String bankType="";

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	
	
}


