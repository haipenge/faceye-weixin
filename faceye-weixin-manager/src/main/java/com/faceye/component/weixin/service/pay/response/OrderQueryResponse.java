package com.faceye.component.weixin.service.pay.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 微信查单接口响应数据
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年11月8日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderQueryResponse {
	// SUCCESS/FAIL ,此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
	@XmlElement(name = "return_code")
	@XmlCDATA
	private String return_code = "";
	// 返回信息，如非空，为错误原因
	// 签名失败
	// 参数格式校验错误
	@XmlElement(name = "return_msg")
	@XmlCDATA
	private String return_msg = "";
	// ////////////////////////////////////////////////////////////////////////////////////
	// 以下字段在return_code为SUCCESS的时候有返回
	// 微信分配的公众账号ID
	@XmlElement(name = "appid")
	@XmlCDATA
	private String appid = "";
	// 微信支付分配的商户号
	@XmlElement(name = "mch_id")
	@XmlCDATA
	private String mch_id = "";
	// 随机字符串，不长于32位
	@XmlElement(name = "nonce_str")
	@XmlCDATA
	private String nonce_str = "";
	// 签名
	@XmlElement(name = "sign")
	@XmlCDATA
	private String sign = "";
	// SUCCESS/FAIL
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
	// ///////////////////////////////////////////////////////////////////////////////////////
	// 以下字段在return_code 和result_code都为SUCCESS的时候有返回///
	// 微信支付分配的终端设备号，
	@XmlElement(name = "device_info")
	@XmlCDATA
	private String device_info = "";
	// 用户在商户appid下的唯一标识
	@XmlElement(name = "openid")
	@XmlCDATA
	private String openid = "";
	// 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	@XmlElement(name = "is_subscribe")
	@XmlCDATA
	private String is_subscribe = "";
	// 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见
	@XmlElement(name = "trade_type")
	@XmlCDATA
	private String trade_type = "";
	// SUCCESS—支付成功
	// REFUND—转入退款
	// NOTPAY—未支付
	// CLOSED—已关闭
	// REVOKED—已撤销（刷卡支付）
	// USERPAYING--用户支付中
	// PAYERROR--支付失败(其他原因，如银行返回失败)
	@XmlElement(name = "trade_state")
	@XmlCDATA
	private String trade_state = "";
	// 银行类型，采用字符串类型的银行标识
	@XmlElement(name = "bank_type")
	@XmlCDATA
	private String bank_type = "";
	// 订单总金额，单位为分
	@XmlElement(name = "total_fee")
	@XmlCDATA
	private Integer total_fee = 0;
	// 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
	@XmlElement(name = "fee_type")
	@XmlCDATA
	private String fee_type = "";
	// 现金支付金额订单现金支付金额，详见
	@XmlElement(name = "cash_fee")
	@XmlCDATA
	private Integer cash_fee = 0;
	// 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见
	@XmlElement(name = "cash_fee_type")
	@XmlCDATA
	private String cash_fee_type = "";
	// “代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额
	@XmlElement(name = "coupon_fee")
	@XmlCDATA
	private Integer coupon_fee = 0;
	// 代金券或立减优惠使用数量
	@XmlElement(name = "coupon_count")
	@XmlCDATA
	private Integer coupon_count = 0;
	// 代金券或立减优惠批次ID ,$n为下标，从0开始编号
	@XmlElement(name = "coupon_batch_id_0")
	@XmlCDATA
	private String coupon_batch_id_0 = "";
	// 代金券或立减优惠ID, $n为下标，从0开始编号
	@XmlElement(name = "coupon_id_0")
	@XmlCDATA
	private String coupon_id_0 = "";
	// 单个代金券或立减优惠支付金额, $n为下标，从0开始编号
	@XmlElement(name = "coupon_fee_0")
	@XmlCDATA
	private Integer coupon_fee_0 = 0;
	// 微信支付订单号
	@XmlElement(name = "transaction_id")
	@XmlCDATA
	private String transaction_id = "";
	// 商户系统的订单号，与请求一致
	@XmlElement(name = "out_trade_no")
	@XmlCDATA
	private String out_trade_no = "";
	// 附加数据，原样返回
	@XmlElement(name = "attach")
	@XmlCDATA
	private String attach = "";
	// 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见
	@XmlElement(name = "time_end")
	@XmlCDATA
	private String time_end = "";
	// 对当前查询订单状态的描述和下一步操作的指引
	@XmlElement(name = "trade_state_desc")
	@XmlCDATA
	private String trade_state_desc = "";

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

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public Integer getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public Integer getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
	}

	public String getCoupon_batch_id_0() {
		return coupon_batch_id_0;
	}

	public void setCoupon_batch_id_0(String coupon_batch_id_0) {
		this.coupon_batch_id_0 = coupon_batch_id_0;
	}

	public String getCoupon_id_0() {
		return coupon_id_0;
	}

	public void setCoupon_id_0(String coupon_id_0) {
		this.coupon_id_0 = coupon_id_0;
	}

	public Integer getCoupon_fee_0() {
		return coupon_fee_0;
	}

	public void setCoupon_fee_0(Integer coupon_fee_0) {
		this.coupon_fee_0 = coupon_fee_0;
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

	public String getTrade_state_desc() {
		return trade_state_desc;
	}

	public void setTrade_state_desc(String trade_state_desc) {
		this.trade_state_desc = trade_state_desc;
	}

}
