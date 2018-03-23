package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.entity.ResponseMessageType;
import com.faceye.component.weixin.repository.mongo.ResponseMessageTypeRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * ResponseMessageType DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class ResponseMessageTypeRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private ResponseMessageTypeRepository responseMessageTypeRepository = null;

	@Before
	public void before() throws Exception {
		//this.responseMessageTypeRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		ResponseMessageType entity = new ResponseMessageType();
		this.responseMessageTypeRepository.save(entity);
		Iterable<ResponseMessageType> entities = this.responseMessageTypeRepository.findAll();
		Assert.assertTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		ResponseMessageType entity = new ResponseMessageType();
		this.responseMessageTypeRepository.save(entity);
        this.responseMessageTypeRepository.deleteById(entity.getId());
        Iterable<ResponseMessageType> entities = this.responseMessageTypeRepository.findAll();
		Assert.assertTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		ResponseMessageType entity = new ResponseMessageType();
		this.responseMessageTypeRepository.save(entity);
		ResponseMessageType responseMessageType=this.responseMessageTypeRepository.findById(entity.getId()).get();
		Assert.assertTrue(responseMessageType!=null);
	}

	
}
