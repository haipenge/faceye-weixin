package com.faceye.component.weixin.repository.mongo;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.JSAPITicket;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * JSAPITicket 实体DAO<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface JSAPITicketRepository extends BaseMongoRepository<JSAPITicket,Long> {
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
	
}/**@generate-repository-source@**/
