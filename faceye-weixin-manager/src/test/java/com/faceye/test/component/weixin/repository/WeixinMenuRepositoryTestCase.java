package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.faceye.component.weixin.entity.WeixinMenu;
import com.faceye.component.weixin.repository.mongo.WeixinMenuRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * WeixinMenu DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class WeixinMenuRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private WeixinMenuRepository weixinMenuRepository = null;

	@Before
	public void before() throws Exception {
		//this.weixinMenuRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		WeixinMenu entity = new WeixinMenu();
		this.weixinMenuRepository.save(entity);
		Iterable<WeixinMenu> entities = this.weixinMenuRepository.findAll();
		Assert.isTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		WeixinMenu entity = new WeixinMenu();
		this.weixinMenuRepository.save(entity);
        this.weixinMenuRepository.delete(entity.getId());
        Iterable<WeixinMenu> entities = this.weixinMenuRepository.findAll();
		Assert.isTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		WeixinMenu entity = new WeixinMenu();
		this.weixinMenuRepository.save(entity);
		WeixinMenu weixinMenu=this.weixinMenuRepository.findOne(entity.getId());
		Assert.isTrue(weixinMenu!=null);
	}

	
}
