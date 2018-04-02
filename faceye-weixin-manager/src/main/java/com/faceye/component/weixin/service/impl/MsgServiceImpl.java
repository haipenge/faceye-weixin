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

import com.faceye.component.weixin.entity.Msg;
import com.faceye.component.weixin.repository.mongo.MsgRepository;
import com.faceye.component.weixin.service.MsgService;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
 
import com.querydsl.core.types.Predicate;
@Service
public class MsgServiceImpl extends BaseMongoServiceImpl<Msg, Long, MsgRepository> implements MsgService {

	@Autowired
	public MsgServiceImpl(MsgRepository dao) {
		super(dao);
	}
	
	
	@Override
<<<<<<< HEAD
	public Page<Msg> getPage(Map<String, Object> searchParams, int page, int size) {
=======
	public Page<Msg> getPage(Map<String, Object> searchParams, int page, int size)   {
>>>>>>> f3c73da5e7c393cc77bf7755815c10b795080b6a
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<Msg> entityPath = resolver.createPath(entityClass);
		// PathBuilder<Msg> builder = new PathBuilder<Msg>(entityPath.getType(), entityPath.getMetadata());
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
		Page<Msg> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<Msg>("id") {
			// })
			List<Msg> items = (List) this.dao.findAll(predicate);
			res = new PageImpl<Msg>(items);

		}
		return res;
	}
	
}/**@generate-service-source@**/
