package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.component.weixin.repository.mongo.WeixinUserRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * WeixinUser DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class WeixinUserRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private WeixinUserRepository weixinUserRepository = null;

	@Before
	public void before() throws Exception {
		//this.weixinUserRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		WeixinUser entity = new WeixinUser();
		this.weixinUserRepository.save(entity);
		Iterable<WeixinUser> entities = this.weixinUserRepository.findAll();
		Assert.isTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		WeixinUser entity = new WeixinUser();
		this.weixinUserRepository.save(entity);
        this.weixinUserRepository.delete(entity.getId());
        Iterable<WeixinUser> entities = this.weixinUserRepository.findAll();
		Assert.isTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		WeixinUser entity = new WeixinUser();
		this.weixinUserRepository.save(entity);
		WeixinUser weixinUser=this.weixinUserRepository.findOne(entity.getId());
		Assert.isTrue(weixinUser!=null);
	}

	
}
