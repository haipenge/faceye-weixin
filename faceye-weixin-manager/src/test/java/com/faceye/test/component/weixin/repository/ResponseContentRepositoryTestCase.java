package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.entity.ResponseContent;
import com.faceye.component.weixin.repository.mongo.ResponseContentRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * ResponseContent DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class ResponseContentRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private ResponseContentRepository responseContentRepository = null;

	@Before
	public void before() throws Exception {
		//this.responseContentRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		ResponseContent entity = new ResponseContent();
		this.responseContentRepository.save(entity);
		Iterable<ResponseContent> entities = this.responseContentRepository.findAll();
		Assert.assertTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		ResponseContent entity = new ResponseContent();
		this.responseContentRepository.save(entity);
        this.responseContentRepository.deleteById(entity.getId());
        Iterable<ResponseContent> entities = this.responseContentRepository.findAll();
		Assert.assertTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		ResponseContent entity = new ResponseContent();
		this.responseContentRepository.save(entity);
		ResponseContent responseContent=this.responseContentRepository.findById(entity.getId()).get();
		Assert.assertTrue(responseContent!=null);
	}

	
}
