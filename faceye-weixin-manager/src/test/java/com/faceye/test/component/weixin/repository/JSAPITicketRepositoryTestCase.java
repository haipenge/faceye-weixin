package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.entity.JSAPITicket;
import com.faceye.component.weixin.repository.mongo.JSAPITicketRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * JSAPITicket DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class JSAPITicketRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private JSAPITicketRepository jsapiTicketRepository = null;

	@Before
	public void before() throws Exception {
		//this.jsapiTicketRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		JSAPITicket entity = new JSAPITicket();
		this.jsapiTicketRepository.save(entity);
		Iterable<JSAPITicket> entities = this.jsapiTicketRepository.findAll();
		Assert.assertTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		JSAPITicket entity = new JSAPITicket();
		this.jsapiTicketRepository.save(entity);
        this.jsapiTicketRepository.deleteById(entity.getId());
        Iterable<JSAPITicket> entities = this.jsapiTicketRepository.findAll();
		Assert.assertTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		JSAPITicket entity = new JSAPITicket();
		this.jsapiTicketRepository.save(entity);
		JSAPITicket jsapiTicket=this.jsapiTicketRepository.findById(entity.getId()).get();
		Assert.assertTrue(jsapiTicket!=null);
	}

	
}
