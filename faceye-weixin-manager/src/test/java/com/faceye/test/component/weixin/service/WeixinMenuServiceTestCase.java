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

import com.faceye.component.weixin.entity.WeixinMenu;
import com.faceye.component.weixin.service.WeixinMenuService;
import com.faceye.test.feature.service.BaseServiceTestCase;


/**
 * WeixinMenu  服务层测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class WeixinMenuServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private WeixinMenuService weixinMenuService = null;
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
		Assert.assertTrue(weixinMenuService != null);
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
		//this.weixinMenuService.removeAllInBatch();
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
		WeixinMenu entity = new WeixinMenu();
		this.weixinMenuService.save(entity);
		List<WeixinMenu> entites = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		WeixinMenu entity = new WeixinMenu();
		this.weixinMenuService.save(entity);
		List<WeixinMenu> entites = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			WeixinMenu entity = new WeixinMenu();
			this.weixinMenuService.save(entity);
		}
		List<WeixinMenu> entities = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		WeixinMenu entity = new WeixinMenu();
		this.weixinMenuService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		WeixinMenu e = this.weixinMenuService.get(entity.getId());
		Assert.assertTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		WeixinMenu entity = new WeixinMenu();
		this.weixinMenuService.save(entity);
		this.weixinMenuService.remove(entity);
		List<WeixinMenu> entities = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			WeixinMenu entity = new WeixinMenu();
			this.weixinMenuService.save(entity);
		}
		List<WeixinMenu> entities = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.weixinMenuService.removeAllInBatch();
		entities = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			WeixinMenu entity = new WeixinMenu();
			this.weixinMenuService.save(entity);
		}
		this.weixinMenuService.removeAll();
		List<WeixinMenu> entities = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<WeixinMenu> entities = new ArrayList<WeixinMenu>();
		for (int i = 0; i < 5; i++) {
			WeixinMenu entity = new WeixinMenu();
			
			this.weixinMenuService.save(entity);
			entities.add(entity);
		}
		this.weixinMenuService.removeInBatch(entities);
		entities = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			WeixinMenu entity = new WeixinMenu();
			this.weixinMenuService.save(entity);
		}
		List<WeixinMenu> entities = this.weixinMenuService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			WeixinMenu entity = new WeixinMenu();
			this.weixinMenuService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<WeixinMenu> page = this.weixinMenuService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.weixinMenuService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.weixinMenuService.getPage(searchParams, 1, 5);

		Assert.assertTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			WeixinMenu entity = new WeixinMenu();
			this.weixinMenuService.save(entity);
			id = entity.getId();
		}
		WeixinMenu e = this.weixinMenuService.get(id);
		Assert.assertTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			WeixinMenu entity = new WeixinMenu();
			this.weixinMenuService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<WeixinMenu> entities = this.weixinMenuService.getAll(ids);
		Assert.assertTrue(entities != null && entities.size() == 5);
	}
}
