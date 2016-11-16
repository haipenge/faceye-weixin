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
import org.springframework.util.Assert;

import com.faceye.component.weixin.entity.ResponseContent;
import com.faceye.component.weixin.service.ResponseContentService;
import com.faceye.test.feature.service.BaseServiceTestCase;


/**
 * ResponseContent  服务层测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class ResponseContentServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private ResponseContentService responseContentService = null;
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
		Assert.isTrue(responseContentService != null);
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
		//this.responseContentService.removeAllInBatch();
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
		ResponseContent entity = new ResponseContent();
		this.responseContentService.save(entity);
		List<ResponseContent> entites = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		ResponseContent entity = new ResponseContent();
		this.responseContentService.save(entity);
		List<ResponseContent> entites = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			ResponseContent entity = new ResponseContent();
			this.responseContentService.save(entity);
		}
		List<ResponseContent> entities = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		ResponseContent entity = new ResponseContent();
		this.responseContentService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		ResponseContent e = this.responseContentService.get(entity.getId());
		Assert.isTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		ResponseContent entity = new ResponseContent();
		this.responseContentService.save(entity);
		this.responseContentService.remove(entity);
		List<ResponseContent> entities = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			ResponseContent entity = new ResponseContent();
			this.responseContentService.save(entity);
		}
		List<ResponseContent> entities = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.responseContentService.removeAllInBatch();
		entities = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			ResponseContent entity = new ResponseContent();
			this.responseContentService.save(entity);
		}
		this.responseContentService.removeAll();
		List<ResponseContent> entities = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<ResponseContent> entities = new ArrayList<ResponseContent>();
		for (int i = 0; i < 5; i++) {
			ResponseContent entity = new ResponseContent();
			
			this.responseContentService.save(entity);
			entities.add(entity);
		}
		this.responseContentService.removeInBatch(entities);
		entities = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			ResponseContent entity = new ResponseContent();
			this.responseContentService.save(entity);
		}
		List<ResponseContent> entities = this.responseContentService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			ResponseContent entity = new ResponseContent();
			this.responseContentService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<ResponseContent> page = this.responseContentService.getPage(searchParams, 1, 5);
		Assert.isTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.responseContentService.getPage(searchParams, 1, 5);
		Assert.isTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.responseContentService.getPage(searchParams, 1, 5);

		Assert.isTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			ResponseContent entity = new ResponseContent();
			this.responseContentService.save(entity);
			id = entity.getId();
		}
		ResponseContent e = this.responseContentService.get(id);
		Assert.isTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			ResponseContent entity = new ResponseContent();
			this.responseContentService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<ResponseContent> entities = this.responseContentService.getAll(ids);
		Assert.isTrue(entities != null && entities.size() == 5);
	}
}
