package com.faceye.component.weixin.service.pay.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * 扫码支付回调响应
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月8日
 */
public class PayReCallResponse {
	//SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	@XmlElement(name = "return_code")
	private String returnCode = "";
	@XmlElement(name="return_msg")
	private String returnMsg="";
	
	@XmlElement(name="appid")
	private String appid="";
	
	@XmlElement(name="mch_id")
	private String mchId="";
	
	@XmlElement(name="nonce_str")
	private String nonceStr="";
	
	@XmlElement(name="prepay_id")
	private String prepayId="";
	
	//SUCCESS/FAIL
	@XmlElement(name="result_code")
	private String resultCode="";
	//当result_code为FAIL时，商户展示给用户的错误提
	@XmlElement(name="err_code_des")
	private String errCodeDes="";
	
	@XmlElement(name="sign")
	private String sign="";

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

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
	
}
