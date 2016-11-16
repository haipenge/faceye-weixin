package com.faceye.component.weixin.repository.mongo;

import java.util.List;

import com.faceye.component.security.entity.User;
import com.faceye.component.weixin.entity.Account;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * Account 实体DAO<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface AccountRepository extends BaseMongoRepository<Account,Long> {
	
	public Account getAccountByWeixinName(String weixinName);
	
	public Account getAccountByAppId(String appId);
	
	public List<Account> getAccountsByUser(User user);
}/**@generate-repository-source@**/
