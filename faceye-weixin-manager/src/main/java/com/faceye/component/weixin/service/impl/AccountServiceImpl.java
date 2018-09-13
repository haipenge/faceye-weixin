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

import com.faceye.component.security.entity.User;
import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.repository.mongo.AccountRepository;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
 
import com.querydsl.core.types.Predicate;

@Service
public class AccountServiceImpl extends BaseMongoServiceImpl<Account, Long, AccountRepository> implements AccountService {

	@Autowired
	public AccountServiceImpl(AccountRepository dao) {
		super(dao);
	}

	@Override
	public Page<Account> getPage(Map<String, Object> searchParams, int page, int size)   {
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<Account> entityPath = resolver.createPath(entityClass);
		// PathBuilder<Account> builder = new PathBuilder<Account>(entityPath.getType(), entityPath.getMetadata());
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
		Page<Account> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<Account>("id") {
			// })
			List<Account> items = (List) this.dao.findAll(predicate);
			res = new PageImpl<Account>(items);

		}
		return res;
	}

	@Override
	public Account getAccountByWeixinName(String weixinName) {
		return dao.getAccountByWeixinName(weixinName);
	}

	@Override
	public Account getAccountByAppId(String appId) {
		return this.dao.getAccountByAppId(appId);
	}

	@Override
	public List<Account> getAccountsByUser(User user) {
		return this.dao.getAccountsByUser(user);
	}

	// @Override
	// public Account getAccountByUser(User user) {
	// Map searchParams=new HashMap();
	// Account account=null;
	// searchParams.put("EQ|user.$id", user.getId());
	// Page<Account> accounts=this.getPage(searchParams, 1, 0);
	// if(CollectionUtils.isNotEmpty(accounts.getContent())){
	// account=accounts.getContent().get(0);
	// }
	// return account;
	// }

}
/**@generate-service-source@**/
