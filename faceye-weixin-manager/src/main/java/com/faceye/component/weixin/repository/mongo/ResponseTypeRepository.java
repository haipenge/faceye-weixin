package com.faceye.component.weixin.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.faceye.component.weixin.entity.ResponseType;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * ResponseType 实体DAO<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface ResponseTypeRepository extends BaseMongoRepository<ResponseType,Long> {
	
	
}/**@generate-repository-source@**/
