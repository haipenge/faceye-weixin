package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.entity.ResponseContentItem;
import com.faceye.component.weixin.repository.mongo.ResponseContentItemRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * ResponseContentItem DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class ResponseContentItemRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private ResponseContentItemRepository responseContentItemRepository = null;

	@Before
	public void before() throws Exception {
		//this.responseContentItemRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		ResponseContentItem entity = new ResponseContentItem();
		this.responseContentItemRepository.save(entity);
		Iterable<ResponseContentItem> entities = this.responseContentItemRepository.findAll();
		Assert.assertTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		ResponseContentItem entity = new ResponseContentItem();
		this.responseContentItemRepository.save(entity);
        this.responseContentItemRepository.deleteById(entity.getId());
        Iterable<ResponseContentItem> entities = this.responseContentItemRepository.findAll();
		Assert.assertTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		ResponseContentItem entity = new ResponseContentItem();
		this.responseContentItemRepository.save(entity);
		ResponseContentItem responseContentItem=this.responseContentItemRepository.findById(entity.getId()).get();
		Assert.assertTrue(responseContentItem!=null);
	}

	
}
