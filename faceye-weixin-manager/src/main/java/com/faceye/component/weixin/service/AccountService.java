package com.faceye.component.weixin.service;

import java.util.List;

import com.faceye.component.security.entity.User;
import com.faceye.component.weixin.entity.Account;
import com.faceye.feature.service.BaseService;
/**
 * Account 服务接品<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface AccountService extends BaseService<Account,Long>{
	
	public Account getAccountByWeixinName(String weixinName);
	
	public Account getAccountByAppId(String appId);
	
	/**
	 * 取得用户的帐户
	 * @todo
	 * @param user
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月9日
	 */
	public List<Account> getAccountsByUser(User user);
	
}/**@generate-service-source@**/
