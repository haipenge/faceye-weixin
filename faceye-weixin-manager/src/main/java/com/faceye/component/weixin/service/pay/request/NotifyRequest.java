package com.faceye.component.weixin.service.pay.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 支付结果通知 请求，微信->商户
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年9月25日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotifyRequest {
	// 返回状态码
	@XmlElement(name = "return_code")
	@XmlCDATA
	private String return_code = "";
	// 返回信息
	@XmlElement(name = "return_msg")
	@XmlCDATA
	private String return_msg = "";
	// 公众账号ID
	@XmlElement(name = "appid")
	@XmlCDATA
	private String appid = "";
	// 商户号
	@XmlElement(name = "mch_id")
	@XmlCDATA
	private String mch_id = "";
	// 设备号
	@XmlElement(name = "device_info")
	@XmlCDATA
	private String device_info = "";
	// 随机字符串
	@XmlElement(name = "nonce_str")
	@XmlCDATA
	private String nonce_str = "";
	// 签名
	@XmlElement(name = "sign")
	@XmlCDATA
	private String sign = "";
	// 业务结果
	@XmlElement(name = "result_code")
	@XmlCDATA
	private String result_code = "";
	// 错误代码
	@XmlElement(name = "err_code")
	@XmlCDATA
	private String err_code = "";
	// 错误代码描述
	@XmlElement(name = "err_code_des")
	@XmlCDATA
	private String err_code_des = "";
	// 用户标识
	@XmlElement(name = "openid")
	@XmlCDATA
	private String openid = "";
	// 是否关注公众账号
	@XmlElement(name = "is_subscribe")
	@XmlCDATA
	private String is_subscribe = "";
	// 交易类型
	@XmlElement(name = "trade_type")
	@XmlCDATA
	private String trade_type = "";
	// 付款银行
	@XmlElement(name = "bank_type")
	@XmlCDATA
	private String bank_type = "";
	// 总金额
	@XmlElement(name = "total_fee")
	@XmlCDATA
	private String total_fee = "";
	// 货币种类
	@XmlElement(name = "fee_type")
	@XmlCDATA
	private String fee_type = "";
	// 现金支付金额
	@XmlElement(name = "cash_fee")
	@XmlCDATA
	private String cash_fee = "";
	// 现金支付货币类型
	@XmlElement(name = "cash_fee_type")
	@XmlCDATA
	private String cash_fee_type = "";
	// 代金券或立减优惠金额
	@XmlElement(name = "coupon_fee")
	@XmlCDATA
	private String coupon_fee = "";
	// 代金券或立减优惠使用数量
	@XmlElement(name = "coupon_count")
	@XmlCDATA
	private String coupon_count = "";
	// 代金券或立减优惠ID
	// 代金券或立减优惠ID,$n为下标，从0开始编号
	@XmlElement(name = "coupon_id_$n")
	@XmlCDATA
	private String coupon_id_$n = "";
	// 单个代金券或立减优惠支付金额,单个代金券或立减优惠支付金额,$n为下标，从0开始编号
	@XmlElement(name = "coupon_fee_$n")
	@XmlCDATA
	private String coupon_fee_$n = "";
	// 微信支付订单号
	@XmlElement(name = "transaction_id")
	@XmlCDATA
	private String transaction_id = "";
	// 商户订单号
	@XmlElement(name = "out_trade_no")
	@XmlCDATA
	private String out_trade_no = "";
	// 商家数据包
	@XmlElement(name = "attach")
	@XmlCDATA
	private String attach = "";
	// 支付完成时间
	@XmlElement(name = "time_end")
	@XmlCDATA
	private String time_end = "";

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

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

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public String getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public String getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(String coupon_count) {
		this.coupon_count = coupon_count;
	}

	public String getCoupon_id_$n() {
		return coupon_id_$n;
	}

	public void setCoupon_id_$n(String coupon_id_$n) {
		this.coupon_id_$n = coupon_id_$n;
	}

	public String getCoupon_fee_$n() {
		return coupon_fee_$n;
	}

	public void setCoupon_fee_$n(String coupon_fee_$n) {
		this.coupon_fee_$n = coupon_fee_$n;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

}