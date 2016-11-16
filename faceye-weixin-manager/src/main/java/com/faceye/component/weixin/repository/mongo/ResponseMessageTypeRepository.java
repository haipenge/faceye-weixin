package com.faceye.component.weixin.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.faceye.component.weixin.entity.ResponseMessageType;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * ResponseMessageType 实体DAO<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface ResponseMessageTypeRepository extends BaseMongoRepository<ResponseMessageType,Long> {
	
	
}/**@generate-repository-source@**/
