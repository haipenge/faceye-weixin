package com.faceye.component.weixin.service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.JSAPITicket;
import com.faceye.feature.service.BaseService;
/**
 * JSAPITicket 服务接品<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface JSAPITicketService extends BaseService<JSAPITicket,Long>{

	/**
	 * 根据微信公众号取得js-sdk ticket
	 * @todo
	 * @param account
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月7日
	 */
	public JSAPITicket getJSAPITicketByAccount(Account account);
}/**@generate-service-source@**/
