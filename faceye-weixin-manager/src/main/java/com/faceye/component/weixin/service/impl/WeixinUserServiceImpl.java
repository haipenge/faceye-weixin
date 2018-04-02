package com.faceye.component.weixin.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.component.weixin.repository.mongo.WeixinUserRepository;
import com.faceye.component.weixin.service.WeixinUserService;
import com.faceye.component.weixin.service.oauth2.response.WeixinUserInfo;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
 
import com.querydsl.core.types.Predicate;

@Service
public class WeixinUserServiceImpl extends BaseMongoServiceImpl<WeixinUser, Long, WeixinUserRepository> implements WeixinUserService {

	@Autowired
	public WeixinUserServiceImpl(WeixinUserRepository dao) {
		super(dao);
	}

	@Override
<<<<<<< HEAD
	public Page<WeixinUser> getPage(Map<String, Object> searchParams, int page, int size) {
=======
	public Page<WeixinUser> getPage(Map<String, Object> searchParams, int page, int size)   {
>>>>>>> f3c73da5e7c393cc77bf7755815c10b795080b6a
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<WeixinUser> entityPath = resolver.createPath(entityClass);
		// PathBuilder<WeixinUser> builder = new PathBuilder<WeixinUser>(entityPath.getType(), entityPath.getMetadata());
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
		Page<WeixinUser> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<WeixinUser>("id") {
			// })
			List<WeixinUser> items = (List) this.dao.findAll(predicate);
			res = new PageImpl<WeixinUser>(items);

		}
		return res;
	}

	@Override
	public WeixinUser saveWeixinUser(Account account, WeixinUserInfo weixinUserInfo) {
		WeixinUser weixinUser = null;
		if (null != weixinUserInfo) {
			String openid = weixinUserInfo.getOpenid();
			weixinUser = this.dao.getWeixinUserByOpenid(openid);
		}
		if (weixinUser == null) {
			weixinUser = new WeixinUser();
		}
		weixinUser.setAccount(account);
		weixinUser.setOpenid(weixinUserInfo.getOpenid());
		weixinUser.setUnionid(weixinUserInfo.getOpenid());
		if (StringUtils.isNotEmpty(weixinUserInfo.getHeadimgurl())) {
			weixinUser.setHeadimgurl(weixinUserInfo.getHeadimgurl());
		}
		if (StringUtils.isNotEmpty(weixinUserInfo.getCity())) {
			weixinUser.setCity(weixinUserInfo.getCity());
		}
		if (StringUtils.isNotEmpty(weixinUserInfo.getCountry())) {
			weixinUser.setCountry(weixinUserInfo.getCountry());
		}
		weixinUser.setLanguage(weixinUserInfo.getLanguage());
		if (StringUtils.isNotEmpty(weixinUserInfo.getNickname())) {
			weixinUser.setNickname(weixinUserInfo.getNickname());
		}

		if (weixinUserInfo.getPrivilege() != null && weixinUserInfo.getPrivilege().length > 0) {
			weixinUser.setPrivilege(weixinUserInfo.getPrivilege());
		}
		if (StringUtils.isNotEmpty(weixinUserInfo.getProvince())) {
			weixinUser.setProvince(weixinUserInfo.getProvince());
		}
		if (StringUtils.isNotEmpty(weixinUserInfo.getSex())) {
			weixinUser.setSex(weixinUserInfo.getSex());
		}
		this.save(weixinUser);
		return weixinUser;
	}

	@Override
	public WeixinUser getWeixinUserByOpenid(String openid) {
		return this.dao.getWeixinUserByOpenid(openid);
	}

}
/** @generate-service-source@ **/
