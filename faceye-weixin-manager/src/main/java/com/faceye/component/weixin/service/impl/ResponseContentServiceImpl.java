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

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.ResponseContent;
import com.faceye.component.weixin.entity.ResponseType;
import com.faceye.component.weixin.repository.mongo.ResponseContentRepository;
import com.faceye.component.weixin.service.ResponseContentService;
import com.faceye.component.weixin.service.ResponseTypeService;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
 
import com.querydsl.core.types.Predicate;

@Service
public class ResponseContentServiceImpl extends BaseMongoServiceImpl<ResponseContent, Long, ResponseContentRepository> implements
		ResponseContentService {

	@Autowired
	private ResponseTypeService responseTypeService = null;

	@Autowired
	public ResponseContentServiceImpl(ResponseContentRepository dao) {
		super(dao);
	}

	@Override
	public ResponseContent save(ResponseContent responseContent) {
		super.save(responseContent);
		// 同时只能有一条有效的回复，其它回复不可同时有效
		if (responseContent != null && responseContent.getIsEnabled()) {
			Map searchParams = new HashMap();
			searchParams.put("EQ|responseMessageType.$id", responseContent.getResponseMessageType().getId());
			searchParams.put("EQ|responseType.$id", responseContent.getResponseType().getId());
			searchParams.put("ISTRUE|isEnabled", Boolean.TRUE);
			searchParams.put("EQ|account.$id", responseContent.getAccount().getId());
			searchParams.put("NE|id", responseContent.getId());
			Page<ResponseContent> responseContents = this.getPage(searchParams, 1, 0);
			if (responseContents != null && CollectionUtils.isNotEmpty(responseContents.getContent())) {
				for (ResponseContent rc : responseContents.getContent()) {
					rc.setIsEnabled(false);
					super.save(rc);
				}
			}
		}
		return responseContent;
	}

	/**
	 * 取得响应消息
	 * @todo
	 * @param account
	 * @param responseMessageType
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月28日
	 */
	public ResponseContent getDefaultResponseContent(Account account) {
		ResponseContent responseContent = this.getResponseContent(account, "default");
		return responseContent;
	}

	/**
	 * 
	 * @todo
	 * @param account
	 * @param responseMessageTypeName -> default
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月28日
	 */
	public ResponseContent getResponseContent(Account account, String responseTypeCode) {
		Map searchParams = new HashMap();
		searchParams.put("EQ|code", responseTypeCode);
		Page<ResponseType> responseTypes = this.responseTypeService.getPage(searchParams, 1, 0);
		if (responseTypes == null || CollectionUtils.isEmpty(responseTypes.getContent())) {
			logger.debug(">>FaceYe --> ResponseType is empty.");
		}
		if (account == null) {
			logger.debug(">>FaceYe --> account is null.");
		}
		if (account.getId() == null) {
			logger.debug(">>FaceYe --> account id is null.");
		}
		ResponseType responseType = responseTypes.getContent().get(0);
		logger.debug(">>FaceYe --> Response type is:" + responseType.getName());
		searchParams = new HashMap();
		logger.debug(">>FaceYe --> Trace info --------------------------------------------------------> 1");
		searchParams.put("EQ|responseType.$id", responseType.getId());
		logger.debug(">>FaceYe --> Trace info --------------------------------------------------------> 2");
		searchParams.put("ISTRUE|isEnabled", Boolean.TRUE);
		logger.debug(">>FaceYe --> Trace info --------------------------------------------------------> 3");
		searchParams.put("EQ|account.$id", account.getId());
		logger.debug(">>FaceYe --> Trace info --------------------------------------------------------> 4");
		Page<ResponseContent> responseContents = this.getPage(searchParams, 1, 1);
		ResponseContent responseContent = null;
		if (responseContents != null && CollectionUtils.isNotEmpty(responseContents.getContent())) {
			responseContent = responseContents.getContent().get(0);
			logger.debug(">>FaceYe -->Trace Info -->6 got responseContent:"+responseContent.getName()+",content:"+responseContent.getContent());
		}else{
			logger.debug(">>FaceYe -->Trace Info ------------------------------------->5 response content is emtpy.");
		}
//		logger.debug(">>FaceYe --> Response content is:" + responseContent.getName());
		return responseContent;
	}

	@Override
	public Page<ResponseContent> getPage(Map<String, Object> searchParams, int page, int size)   {
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<ResponseContent> entityPath = resolver.createPath(entityClass);
		// PathBuilder<ResponseContent> builder = new PathBuilder<ResponseContent>(entityPath.getType(), entityPath.getMetadata());
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
		Page<ResponseContent> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<ResponseContent>("id") {
			// })
			List<ResponseContent> items = (List) this.dao.findAll(predicate);
			res = new PageImpl<ResponseContent>(items);

		}
		return res;
	}

}
/**@generate-service-source@**/
