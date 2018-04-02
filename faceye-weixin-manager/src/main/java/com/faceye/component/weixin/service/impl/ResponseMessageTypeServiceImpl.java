package com.faceye.component.weixin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.entity.ResponseMessageType;
import com.faceye.component.weixin.repository.mongo.ResponseMessageTypeRepository;
import com.faceye.component.weixin.service.ResponseMessageTypeService;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
import com.faceye.feature.util.ServiceException;
import com.querydsl.core.types.Predicate;
@Service
public class ResponseMessageTypeServiceImpl extends BaseMongoServiceImpl<ResponseMessageType, Long, ResponseMessageTypeRepository> implements ResponseMessageTypeService {

	@Autowired
	public ResponseMessageTypeServiceImpl(ResponseMessageTypeRepository dao) {
		super(dao);
	}
	
	
	@Override
	public Page<ResponseMessageType> getPage(Map<String, Object> searchParams, int page, int size)  {
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<ResponseMessageType> entityPath = resolver.createPath(entityClass);
		// PathBuilder<ResponseMessageType> builder = new PathBuilder<ResponseMessageType>(entityPath.getType(), entityPath.getMetadata());
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
		Page<ResponseMessageType> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<ResponseMessageType>("id") {
			// })
			List<ResponseMessageType> items = (List) this.dao.findAll(predicate);
			res = new PageImpl<ResponseMessageType>(items);

		}
		return res;
	}
	
}/**@generate-service-source@**/
