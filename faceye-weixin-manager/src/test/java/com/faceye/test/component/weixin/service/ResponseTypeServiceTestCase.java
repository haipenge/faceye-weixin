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

import com.faceye.component.weixin.entity.ResponseType;
import com.faceye.component.weixin.service.ResponseTypeService;
import com.faceye.test.feature.service.BaseServiceTestCase;


/**
 * ResponseType  服务层测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class ResponseTypeServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private ResponseTypeService responseTypeService = null;
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
		Assert.assertTrue(responseTypeService != null);
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
		//this.responseTypeService.removeAllInBatch();
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
		ResponseType entity = new ResponseType();
		this.responseTypeService.save(entity);
		List<ResponseType> entites = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		ResponseType entity = new ResponseType();
		this.responseTypeService.save(entity);
		List<ResponseType> entites = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			ResponseType entity = new ResponseType();
			this.responseTypeService.save(entity);
		}
		List<ResponseType> entities = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		ResponseType entity = new ResponseType();
		this.responseTypeService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		ResponseType e = this.responseTypeService.get(entity.getId());
		Assert.assertTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		ResponseType entity = new ResponseType();
		this.responseTypeService.save(entity);
		this.responseTypeService.remove(entity);
		List<ResponseType> entities = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			ResponseType entity = new ResponseType();
			this.responseTypeService.save(entity);
		}
		List<ResponseType> entities = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.responseTypeService.removeAllInBatch();
		entities = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			ResponseType entity = new ResponseType();
			this.responseTypeService.save(entity);
		}
		this.responseTypeService.removeAll();
		List<ResponseType> entities = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<ResponseType> entities = new ArrayList<ResponseType>();
		for (int i = 0; i < 5; i++) {
			ResponseType entity = new ResponseType();
			
			this.responseTypeService.save(entity);
			entities.add(entity);
		}
		this.responseTypeService.removeInBatch(entities);
		entities = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			ResponseType entity = new ResponseType();
			this.responseTypeService.save(entity);
		}
		List<ResponseType> entities = this.responseTypeService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			ResponseType entity = new ResponseType();
			this.responseTypeService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<ResponseType> page = this.responseTypeService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.responseTypeService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.responseTypeService.getPage(searchParams, 1, 5);

		Assert.assertTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			ResponseType entity = new ResponseType();
			this.responseTypeService.save(entity);
			id = entity.getId();
		}
		ResponseType e = this.responseTypeService.get(id);
		Assert.assertTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			ResponseType entity = new ResponseType();
			this.responseTypeService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<ResponseType> entities = this.responseTypeService.getAll(ids);
		Assert.assertTrue(entities != null && entities.size() == 5);
	}
}
