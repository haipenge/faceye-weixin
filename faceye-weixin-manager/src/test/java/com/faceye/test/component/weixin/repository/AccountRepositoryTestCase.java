package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

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
		Assert.isTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		Account entity = new Account();
		this.accountRepository.save(entity);
        this.accountRepository.delete(entity.getId());
        Iterable<Account> entities = this.accountRepository.findAll();
		Assert.isTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		Account entity = new Account();
		this.accountRepository.save(entity);
		Account account=this.accountRepository.findOne(entity.getId());
		Assert.isTrue(account!=null);
	}

	
}
