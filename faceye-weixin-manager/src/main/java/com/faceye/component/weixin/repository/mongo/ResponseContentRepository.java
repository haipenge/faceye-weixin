package com.faceye.component.weixin.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.faceye.component.weixin.entity.ResponseContent;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * ResponseContent 实体DAO<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface ResponseContentRepository extends BaseMongoRepository<ResponseContent,Long> {
	
	
}/**@generate-repository-source@**/
