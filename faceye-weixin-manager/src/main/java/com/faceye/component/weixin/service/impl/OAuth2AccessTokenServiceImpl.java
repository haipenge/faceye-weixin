package com.faceye.component.weixin.service.impl;

import java.util.Date;
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

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.OAuth2AccessToken;
import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.component.weixin.repository.mongo.OAuth2AccessTokenRepository;
import com.faceye.component.weixin.service.OAuth2AccessTokenService;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
 
import com.querydsl.core.types.Predicate;

@Service
public class OAuth2AccessTokenServiceImpl extends BaseMongoServiceImpl<OAuth2AccessToken, Long, OAuth2AccessTokenRepository> implements
		OAuth2AccessTokenService {

	@Autowired
	public OAuth2AccessTokenServiceImpl(OAuth2AccessTokenRepository dao) {
		super(dao);
	}

	@Override
<<<<<<< HEAD
	public Page<OAuth2AccessToken> getPage(Map<String, Object> searchParams, int page, int size)  {
=======
	public Page<OAuth2AccessToken> getPage(Map<String, Object> searchParams, int page, int size)   {
>>>>>>> f3c73da5e7c393cc77bf7755815c10b795080b6a
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<OAuth2AccessToken> entityPath = resolver.createPath(entityClass);
		// PathBuilder<OAuth2AccessToken> builder = new PathBuilder<OAuth2AccessToken>(entityPath.getType(), entityPath.getMetadata());
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
		Page<OAuth2AccessToken> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<OAuth2AccessToken>("id") {
			// })
			List<OAuth2AccessToken> items = (List) this.dao.findAll(predicate);
			res = new PageImpl<OAuth2AccessToken>(items);

		}
		return res;
	}

	@Override
	public OAuth2AccessToken saveOAuth2AccessToken(Account account, WeixinUser weixinUser,
			com.faceye.component.weixin.service.oauth2.response.OAuth2AccessToken oAuth2AccessToken) {
		OAuth2AccessToken accessToken = null;
		Map params = new HashMap();
		params.put("EQ|account.$id", account.getId());
		params.put("EQ|openid", oAuth2AccessToken.getOpenid());
		List<OAuth2AccessToken> accessTokens = this.getPage(params, 1, 0).getContent();
		if (CollectionUtils.isNotEmpty(accessTokens)) {
			accessToken = accessTokens.get(0);
		} else {
			accessToken = new OAuth2AccessToken();
			accessToken.setAccount(account);
			accessToken.setCreateDate(new Date());
		}
		accessToken.setOpenid(oAuth2AccessToken.getOpenid());
		accessToken.setAccessToken(oAuth2AccessToken.getAccess_token());
		accessToken.setExpiresIn(oAuth2AccessToken.getExpires_in());
		accessToken.setLastRefreshDate(new Date());
		accessToken.setWeixinUser(weixinUser);
		accessToken.setRefreshAccessToken(oAuth2AccessToken.getRefresh_token());
		accessToken.setUnionid(oAuth2AccessToken.getUnionid());
		this.save(accessToken);
		return accessToken;
	}

}
/**@generate-service-source@**/
