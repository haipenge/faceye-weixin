package com.faceye.component.weixin.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.faceye.component.weixin.entity.ResponseContentItem;
import com.faceye.feature.repository.mongo.BaseMongoRepository;
/**
 * ResponseContentItem 实体DAO<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface ResponseContentItemRepository extends BaseMongoRepository<ResponseContentItem,Long> {
	
	public ResponseContentItem getResponseContentItemByUrl(String url);
}/**@generate-repository-source@**/
