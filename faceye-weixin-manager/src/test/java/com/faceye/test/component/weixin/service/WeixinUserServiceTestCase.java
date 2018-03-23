package com.faceye.test.component.weixin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.junit.Assert;

import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.component.weixin.service.WeixinUserService;
import com.faceye.test.feature.service.BaseServiceTestCase;


/**
 * WeixinUser  服务层测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class WeixinUserServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private WeixinUserService weixinUserService = null;
	/**
	 * 初始化
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@Before
	public void set() throws Exception {
		Assert.assertTrue(weixinUserService != null);
	}

	/**
	 * 清理
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@After
	public void after() throws Exception {
		//this.weixinUserService.removeAllInBatch();
	}

	/**
	 *  保存测试
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@Test
	public void testSave() throws Exception {
		WeixinUser entity = new WeixinUser();
		this.weixinUserService.save(entity);
		List<WeixinUser> entites = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		WeixinUser entity = new WeixinUser();
		this.weixinUserService.save(entity);
		List<WeixinUser> entites = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			WeixinUser entity = new WeixinUser();
			this.weixinUserService.save(entity);
		}
		List<WeixinUser> entities = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		WeixinUser entity = new WeixinUser();
		this.weixinUserService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		WeixinUser e = this.weixinUserService.get(entity.getId());
		Assert.assertTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		WeixinUser entity = new WeixinUser();
		this.weixinUserService.save(entity);
		this.weixinUserService.remove(entity);
		List<WeixinUser> entities = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			WeixinUser entity = new WeixinUser();
			this.weixinUserService.save(entity);
		}
		List<WeixinUser> entities = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.weixinUserService.removeAllInBatch();
		entities = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			WeixinUser entity = new WeixinUser();
			this.weixinUserService.save(entity);
		}
		this.weixinUserService.removeAll();
		List<WeixinUser> entities = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<WeixinUser> entities = new ArrayList<WeixinUser>();
		for (int i = 0; i < 5; i++) {
			WeixinUser entity = new WeixinUser();
			
			this.weixinUserService.save(entity);
			entities.add(entity);
		}
		this.weixinUserService.removeInBatch(entities);
		entities = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			WeixinUser entity = new WeixinUser();
			this.weixinUserService.save(entity);
		}
		List<WeixinUser> entities = this.weixinUserService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			WeixinUser entity = new WeixinUser();
			this.weixinUserService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<WeixinUser> page = this.weixinUserService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.weixinUserService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.weixinUserService.getPage(searchParams, 1, 5);

		Assert.assertTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			WeixinUser entity = new WeixinUser();
			this.weixinUserService.save(entity);
			id = entity.getId();
		}
		WeixinUser e = this.weixinUserService.get(id);
		Assert.assertTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			WeixinUser entity = new WeixinUser();
			this.weixinUserService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<WeixinUser> entities = this.weixinUserService.getAll(ids);
		Assert.assertTrue(entities != null && entities.size() == 5);
	}
}
