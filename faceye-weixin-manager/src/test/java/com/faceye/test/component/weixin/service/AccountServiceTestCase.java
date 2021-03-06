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

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.test.feature.service.BaseServiceTestCase;


/**
 * Account  服务层测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class AccountServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private AccountService accountService = null;
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
		Assert.assertTrue(accountService != null);
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
		//this.accountService.removeAllInBatch();
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
		Account entity = new Account();
		this.accountService.save(entity);
		List<Account> entites = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		Account entity = new Account();
		this.accountService.save(entity);
		List<Account> entites = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			Account entity = new Account();
			this.accountService.save(entity);
		}
		List<Account> entities = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		Account entity = new Account();
		this.accountService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		Account e = this.accountService.get(entity.getId());
		Assert.assertTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		Account entity = new Account();
		this.accountService.save(entity);
		this.accountService.remove(entity);
		List<Account> entities = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			Account entity = new Account();
			this.accountService.save(entity);
		}
		List<Account> entities = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.accountService.removeAllInBatch();
		entities = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			Account entity = new Account();
			this.accountService.save(entity);
		}
		this.accountService.removeAll();
		List<Account> entities = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<Account> entities = new ArrayList<Account>();
		for (int i = 0; i < 5; i++) {
			Account entity = new Account();
			
			this.accountService.save(entity);
			entities.add(entity);
		}
		this.accountService.removeInBatch(entities);
		entities = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			Account entity = new Account();
			this.accountService.save(entity);
		}
		List<Account> entities = this.accountService.getAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			Account entity = new Account();
			this.accountService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<Account> page = this.accountService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.accountService.getPage(searchParams, 1, 5);
		Assert.assertTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.accountService.getPage(searchParams, 1, 5);

		Assert.assertTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			Account entity = new Account();
			this.accountService.save(entity);
			id = entity.getId();
		}
		Account e = this.accountService.get(id);
		Assert.assertTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			Account entity = new Account();
			this.accountService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<Account> entities = this.accountService.getAll(ids);
		Assert.assertTrue(entities != null && entities.size() == 5);
	}
}
