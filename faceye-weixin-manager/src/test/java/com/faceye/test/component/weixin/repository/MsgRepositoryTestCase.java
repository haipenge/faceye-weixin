package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.entity.Msg;
import com.faceye.component.weixin.repository.mongo.MsgRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * Msg DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class MsgRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private MsgRepository msgRepository = null;

	@Before
	public void before() throws Exception {
		//this.msgRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		Msg entity = new Msg();
		this.msgRepository.save(entity);
		Iterable<Msg> entities = this.msgRepository.findAll();
		Assert.assertTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		Msg entity = new Msg();
		this.msgRepository.save(entity);
        this.msgRepository.deleteById(entity.getId());
        Iterable<Msg> entities = this.msgRepository.findAll();
		Assert.assertTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		Msg entity = new Msg();
		this.msgRepository.save(entity);
		Msg msg=this.msgRepository.findById(entity.getId()).get();
		Assert.assertTrue(msg!=null);
	}

	
}
