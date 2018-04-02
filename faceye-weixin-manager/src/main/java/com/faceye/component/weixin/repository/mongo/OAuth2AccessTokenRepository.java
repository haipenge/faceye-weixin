package com.faceye.component.weixin.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.faceye.component.weixin.entity.OAuth2AccessToken;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * OAuth2AccessToken 实体DAO<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface OAuth2AccessTokenRepository extends BaseMongoRepository<OAuth2AccessToken,Long> {
	
	
}/**@generate-repository-source@**/
