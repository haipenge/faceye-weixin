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

import com.faceye.component.weixin.entity.Msg;
import com.faceye.component.weixin.service.MsgService;
import com.faceye.test.feature.service.BaseServiceTestCase;


/**
 * Msg  服务层测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class MsgServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private MsgService msgService = null;
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
		Assert.isTrue(msgService != null);
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
		//this.msgService.removeAllInBatch();
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
		Msg entity = new Msg();
		this.msgService.save(entity);
		List<Msg> entites = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		Msg entity = new Msg();
		this.msgService.save(entity);
		List<Msg> entites = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			Msg entity = new Msg();
			this.msgService.save(entity);
		}
		List<Msg> entities = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		Msg entity = new Msg();
		this.msgService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		Msg e = this.msgService.get(entity.getId());
		Assert.isTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		Msg entity = new Msg();
		this.msgService.save(entity);
		this.msgService.remove(entity);
		List<Msg> entities = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			Msg entity = new Msg();
			this.msgService.save(entity);
		}
		List<Msg> entities = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.msgService.removeAllInBatch();
		entities = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			Msg entity = new Msg();
			this.msgService.save(entity);
		}
		this.msgService.removeAll();
		List<Msg> entities = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<Msg> entities = new ArrayList<Msg>();
		for (int i = 0; i < 5; i++) {
			Msg entity = new Msg();
			
			this.msgService.save(entity);
			entities.add(entity);
		}
		this.msgService.removeInBatch(entities);
		entities = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			Msg entity = new Msg();
			this.msgService.save(entity);
		}
		List<Msg> entities = this.msgService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			Msg entity = new Msg();
			this.msgService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<Msg> page = this.msgService.getPage(searchParams, 1, 5);
		Assert.isTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.msgService.getPage(searchParams, 1, 5);
		Assert.isTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.msgService.getPage(searchParams, 1, 5);

		Assert.isTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			Msg entity = new Msg();
			this.msgService.save(entity);
			id = entity.getId();
		}
		Msg e = this.msgService.get(id);
		Assert.isTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			Msg entity = new Msg();
			this.msgService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<Msg> entities = this.msgService.getAll(ids);
		Assert.isTrue(entities != null && entities.size() == 5);
	}
}
