package com.faceye.component.weixin.service.pay;

import com.faceye.component.weixin.service.pay.model.PayProductInfo;

/**
 * 支付商品信息，用于生成统一订单，调用微信模块的项目，实现本接口
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月8日
 */

public interface PayBusinessReCallService {

	/**
	 * 构建支付商品信息
	 * @todo
	 * @param productOrOrderId,订单或产品编号，其中，payProductInfo 的openid 不需要填写。
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月8日
	 */
	public PayProductInfo buildPayProductInfo(String productOrOrderId);
	/**
	 * 支付
	 * 微位支付成功后的业务回调
	 * @todo
	 * @param productorOrderId
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月16日
	 */
	public boolean pay(String productOrderId);
}
