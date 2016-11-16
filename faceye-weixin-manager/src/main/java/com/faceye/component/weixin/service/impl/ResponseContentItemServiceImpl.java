package com.faceye.component.weixin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.entity.ResponseContentItem;
import com.faceye.component.weixin.repository.mongo.ResponseContentItemRepository;
import com.faceye.component.weixin.service.ResponseContentItemService;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
import com.faceye.feature.util.ServiceException;
import com.querydsl.core.types.Predicate;
@Service
public class ResponseContentItemServiceImpl extends BaseMongoServiceImpl<ResponseContentItem, Long, ResponseContentItemRepository> implements ResponseContentItemService {

	@Autowired
	public ResponseContentItemServiceImpl(ResponseContentItemRepository dao) {
		super(dao);
	}
	
	
	@Override
	public Page<ResponseContentItem> getPage(Map<String, Object> searchParams, int page, int size) throws ServiceException {
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<ResponseContentItem> entityPath = resolver.createPath(entityClass);
		// PathBuilder<ResponseContentItem> builder = new PathBuilder<ResponseContentItem>(entityPath.getType(), entityPath.getMetadata());
		// Path path = entityPath.getRoot();
		// List<Predicate> predicates=DynamicSpecifications.buildPredicates(searchParams, entityClass);
		// Predicate predicate=DynamicSpecifications.builder(predicates);
		// NumberPath numberPath = new NumberPath(Number.class, path, "age");
		// predicates.add(numberPath.eq(15));
		Predicate predicate = DynamicSpecifications.builder(searchParams, entityClass);
		if (predicate != null) {
			logger.debug(">>FaceYe -->Query predicate is:" + predicate.toString());
		}
		Sort sort = new Sort(Direction.DESC, "id");
		Page<ResponseContentItem> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<ResponseContentItem>("id") {
			// })
			List<ResponseContentItem> items = (List) this.dao.findAll(predicate);
			res = new PageImpl<ResponseContentItem>(items);

		}
		return res;
	}


	@Override
	public ResponseContentItem getResponseContentItemByUrl(String url) {
		return this.dao.getResponseContentItemByUrl(url);
	}


	@Override
	public ResponseContentItem getResponseContentItemByResponseContentAndUrl(Long responseContentId, String url) {
		ResponseContentItem responseContentItem=null;
		Map searchParams=new HashMap();
		searchParams.put("EQ|url", url);
		searchParams.put("EQ|responseContent.$id", responseContentId);
		List<ResponseContentItem> responseContentItems=this.getPage(searchParams, 1, 0).getContent();
		if(CollectionUtils.isNotEmpty(responseContentItems)){
			responseContentItem=responseContentItems.get(0);
		}
		return responseContentItem;
	}
	
}/**@generate-service-source@**/
