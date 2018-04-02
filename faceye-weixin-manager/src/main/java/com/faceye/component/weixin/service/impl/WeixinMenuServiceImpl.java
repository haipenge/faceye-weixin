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
import com.faceye.component.weixin.entity.WeixinMenu;
import com.faceye.component.weixin.repository.mongo.WeixinMenuRepository;
import com.faceye.component.weixin.service.WeixinMenuService;
import com.faceye.feature.repository.mongo.DynamicSpecifications;
import com.faceye.feature.service.impl.BaseMongoServiceImpl;
import com.faceye.feature.util.ServiceException;
import com.querydsl.core.types.Predicate;

@Service
public class WeixinMenuServiceImpl extends BaseMongoServiceImpl<WeixinMenu, Long, WeixinMenuRepository> implements WeixinMenuService {

	@Autowired
	public WeixinMenuServiceImpl(WeixinMenuRepository dao) {
		super(dao);
	}

	@Override
	public Page<WeixinMenu> getPage(Map<String, Object> searchParams, int page, int size)  {
		if (page != 0) {
			page = page - 1;
		}
		// SimpleEntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;
		// EntityPath<WeixinMenu> entityPath = resolver.createPath(entityClass);
		// PathBuilder<WeixinMenu> builder = new PathBuilder<WeixinMenu>(entityPath.getType(), entityPath.getMetadata());
		// Path path = entityPath.getRoot();
		// List<Predicate> predicates=DynamicSpecifications.buildPredicates(searchParams, entityClass);
		// Predicate predicate=DynamicSpecifications.builder(predicates);
		// NumberPath numberPath = new NumberPath(Number.class, path, "age");
		// predicates.add(numberPath.eq(15));
		Predicate predicate = DynamicSpecifications.builder(searchParams, entityClass);
		if (predicate != null) {
			logger.debug(">>FaceYe -->Query predicate is:" + predicate.toString());
		}
		Sort sort = new Sort(Direction.ASC, "orderIndex");
		Page<WeixinMenu> res = null;
		if (size != 0) {
			Pageable pageable = new PageRequest(page, size, sort);
			res = this.dao.findAll(predicate, pageable);
		} else {
			// OrderSpecifier<Comparable> orderPOrderSpecifier=new OrderSpecifier<Comparable>(new Order(), new NumberExpression<WeixinMenu>("id") {
			// })
			List<WeixinMenu> items = (List) this.dao.findAll(predicate,sort);
			res = new PageImpl<WeixinMenu>(items);

		}
		return res;
	}

	@Override
	public List<WeixinMenu> getWeixinMenusByAccountAndWeixinMenuIsNull(Account account) {
		Map searchParams = new HashMap();
		searchParams.put("EQ|account.$id", account.getId());
		searchParams.put("EQ|weixinMenuId", 0L);
		return this.getPage(searchParams, 1, 0).getContent();
	}

	@Override
	public List<WeixinMenu> getWeixinMenusByWeixinMenu(WeixinMenu weixinMenu) {
		Map searchParams = new HashMap();
		searchParams.put("EQ|weixinMenuId", weixinMenu.getId());
		return this.getPage(searchParams, 1, 0).getContent();
	}

	/**
	 * 删除微信菜单
	 */
	public void remove(WeixinMenu entity) {
		List<WeixinMenu> childrenMenu = this.getWeixinMenusByWeixinMenu(entity);
		if (CollectionUtils.isNotEmpty(childrenMenu)) {
			for (WeixinMenu child : childrenMenu) {
				super.remove(child);
			}
		}
		super.remove(entity);
	}

	/**
	 * 取得某一级工菜单的最大索引号节点
	 * 
	 * @param parentMenuId
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月24日 上午9:03:17
	 */
	public WeixinMenu getWeixinMenuWithMaxOrderIndex(Account account, Long parentMenuId) {
		WeixinMenu weixinMenu = null;
		if (parentMenuId == null) {
			parentMenuId = 0L;
		}
		Map searchParams = new HashMap();
		searchParams.put("EQ|weixinMenuId", parentMenuId);
		searchParams.put("EQ|account.$id", account.getId());
		Predicate predicate = DynamicSpecifications.builder(searchParams, entityClass);
		if (predicate != null) {
			logger.debug(">>FaceYe -->Query predicate is:" + predicate.toString());
		}
		Sort sort = new Sort(Direction.DESC, "orderIndex");
		List<WeixinMenu> weixinMenus = (List<WeixinMenu>) this.dao.findAll(predicate, sort);
		if (CollectionUtils.isNotEmpty(weixinMenus)) {
			weixinMenu = weixinMenus.get(0);
		}
		return weixinMenu;
	}
	@Override
	public WeixinMenu save(WeixinMenu weixinMenu){
		Integer orderIndex=0;
		if(weixinMenu.getId()==null){
			WeixinMenu weixinMenuWithMaxOrderIndex=this.getWeixinMenuWithMaxOrderIndex(weixinMenu.getAccount(), weixinMenu.getWeixinMenuId());
			if(weixinMenuWithMaxOrderIndex!=null){
				orderIndex=weixinMenuWithMaxOrderIndex.getOrderIndex()+1;
				weixinMenu.setOrderIndex(orderIndex);
			}
		}
		super.save(weixinMenu);
		return weixinMenu;
	}

}/** @generate-service-source@ **/
