package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.entity.ResponseType;
import com.faceye.component.weixin.repository.mongo.ResponseTypeRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * ResponseType DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class ResponseTypeRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private ResponseTypeRepository responseTypeRepository = null;

	@Before
	public void before() throws Exception {
		//this.responseTypeRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		ResponseType entity = new ResponseType();
		this.responseTypeRepository.save(entity);
		Iterable<ResponseType> entities = this.responseTypeRepository.findAll();
		Assert.assertTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		ResponseType entity = new ResponseType();
		this.responseTypeRepository.save(entity);
        this.responseTypeRepository.deleteById(entity.getId());
        Iterable<ResponseType> entities = this.responseTypeRepository.findAll();
		Assert.assertTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		ResponseType entity = new ResponseType();
		this.responseTypeRepository.save(entity);
		ResponseType responseType=this.responseTypeRepository.findById(entity.getId()).get();
		Assert.assertTrue(responseType!=null);
	}

	
}
