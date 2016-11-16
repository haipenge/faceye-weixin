package com.faceye.component.weixin.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * WeixinUser 实体DAO<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface WeixinUserRepository extends BaseMongoRepository<WeixinUser,Long> {
	/**
	 * 根据oepn id 获取用户
	 * @todo
	 * @param openid
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月5日
	 */
	public WeixinUser getWeixinUserByOpenid(String openid);
}/**@generate-repository-source@**/
