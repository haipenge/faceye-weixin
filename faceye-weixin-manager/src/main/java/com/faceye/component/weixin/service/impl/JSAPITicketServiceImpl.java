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

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.JSAPITicket;
import com.faceye.component.weixin.repository.mongo.JSAPITicketRepository;
import com.faceye.component.weixin.service.JSAPITicketService;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
 
import com.querydsl.core.types.Predicate;
@Service
public class JSAPITicketServiceImpl extends BaseMongoServiceImpl<JSAPITicket, Long, JSAPITicketRepository> implements JSAPITicketService {

	@Autowired
	public JSAPITicketServiceImpl(JSAPITicketRepository dao) {
		super(dao);
	}
	
	
	@Override
	public Page<JSAPITicket> getPage(Map<String, Object> searchParams, int page, int size)   {
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<JSAPITicket> entityPath = resolver.createPath(entityClass);
		// PathBuilder<JSAPITicket> builder = new PathBuilder<JSAPITicket>(entityPath.getType(), entityPath.getMetadata());
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
		Page<JSAPITicket> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<JSAPITicket>("id") {
			// })
			List<JSAPITicket> items = (List) this.dao.findAll(predicate);
			res = new PageImpl<JSAPITicket>(items);

		}
		return res;
	}


	@Override
	public JSAPITicket getJSAPITicketByAccount(Account account) {
		return this.dao.getJSAPITicketByAccount(account);
	}
	
}/**@generate-service-source@**/
