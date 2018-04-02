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

import com.faceye.component.weixin.entity.JSAPITicket;
import com.faceye.component.weixin.service.JSAPITicketService;
import com.faceye.test.feature.service.BaseServiceTestCase;


/**
 * JSAPITicket  服务层测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class JSAPITicketServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private JSAPITicketService jsapiTicketService = null;
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
		Assert.assertTrue(jsapiTicketService != null);
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
		//this.jsapiTicketService.removeAllInBatch();
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
		JSAPITicket entity = new JSAPITicket();
		this.jsapiTicketService.save(entity);
		List<JSAPITicket> entites = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		JSAPITicket entity = new JSAPITicket();
		this.jsapiTicketService.save(entity);
		List<JSAPITicket> entites = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			JSAPITicket entity = new JSAPITicket();
			this.jsapiTicketService.save(entity);
		}
		List<JSAPITicket> entities = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		JSAPITicket entity = new JSAPITicket();
		this.jsapiTicketService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		JSAPITicket e = this.jsapiTicketService.get(entity.getId());
		Assert.assertTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		JSAPITicket entity = new JSAPITicket();
		this.jsapiTicketService.save(entity);
		this.jsapiTicketService.remove(entity);
		List<JSAPITicket> entities = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			JSAPITicket entity = new JSAPITicket();
			this.jsapiTicketService.save(entity);
		}
		List<JSAPITicket> entities = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.jsapiTicketService.removeAllInBatch();
		entities = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			JSAPITicket entity = new JSAPITicket();
			this.jsapiTicketService.save(entity);
		}
		this.jsapiTicketService.removeAll();
		List<JSAPITicket> entities = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<JSAPITicket> entities = new ArrayList<JSAPITicket>();
		for (int i = 0; i < 5; i++) {
			JSAPITicket entity = new JSAPITicket();
			
			this.jsapiTicketService.save(entity);
			entities.add(entity);
		}
		this.jsapiTicketService.removeInBatch(entities);
		entities = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			JSAPITicket entity = new JSAPITicket();
			this.jsapiTicketService.save(entity);
		}
		List<JSAPITicket> entities = this.jsapiTicketService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			JSAPITicket entity = new JSAPITicket();
			this.jsapiTicketService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<JSAPITicket> page = this.jsapiTicketService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.jsapiTicketService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.jsapiTicketService.getPage(searchParams, 1, 5);

		Assert.assertTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			JSAPITicket entity = new JSAPITicket();
			this.jsapiTicketService.save(entity);
			id = entity.getId();
		}
		JSAPITicket e = this.jsapiTicketService.get(id);
		Assert.assertTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			JSAPITicket entity = new JSAPITicket();
			this.jsapiTicketService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<JSAPITicket> entities = this.jsapiTicketService.getAll(ids);
		Assert.assertTrue(entities != null && entities.size() == 5);
	}
}
