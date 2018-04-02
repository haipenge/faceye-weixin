package com.faceye.test.component.weixin.repository;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.repository.mongo.AccountRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * Account DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class AccountRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private AccountRepository accountRepository = null;

	@Before
	public void before() throws Exception {
		//this.accountRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		Account entity = new Account();
		this.accountRepository.save(entity);
		Iterable<Account> entities = this.accountRepository.findAll();
		Assert.assertTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		Account entity = new Account();
		this.accountRepository.save(entity);
        this.accountRepository.deleteById(entity.getId());
        Iterable<Account> entities = this.accountRepository.findAll();
		Assert.assertTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		Account entity = new Account();
		this.accountRepository.save(entity);
		Account account=this.accountRepository.findById(entity.getId()).get();
		Assert.assertTrue(account!=null);
	}
	@Test
	public void testGetAll() throws Exception{
		List<Account> accounts=this.accountRepository.findAll();
		Assert.assertTrue(CollectionUtils.isNotEmpty(accounts));
	}

	
}
