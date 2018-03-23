package com.faceye.test.component.weixin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.entity.OAuth2AccessToken;
import com.faceye.component.weixin.repository.mongo.OAuth2AccessTokenRepository;
import com.faceye.test.feature.repository.BaseRepositoryTestCase;
/**
 * OAuth2AccessToken DAO 测试
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月26日
 */
public class OAuth2AccessTokenRepositoryTestCase extends BaseRepositoryTestCase {
	@Autowired
	private OAuth2AccessTokenRepository oauth2AccessTokenRepository = null;

	@Before
	public void before() throws Exception {
		//this.oauth2AccessTokenRepository.deleteAll();
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void testSave() throws Exception {
		OAuth2AccessToken entity = new OAuth2AccessToken();
		this.oauth2AccessTokenRepository.save(entity);
		Iterable<OAuth2AccessToken> entities = this.oauth2AccessTokenRepository.findAll();
		Assert.assertTrue(entities.iterator().hasNext());
	}

	@Test
	public void testDelete() throws Exception {
		OAuth2AccessToken entity = new OAuth2AccessToken();
		this.oauth2AccessTokenRepository.save(entity);
        this.oauth2AccessTokenRepository.deleteById(entity.getId());
        Iterable<OAuth2AccessToken> entities = this.oauth2AccessTokenRepository.findAll();
		Assert.assertTrue(!entities.iterator().hasNext());
	}

	@Test
	public void testFindOne() throws Exception {
		OAuth2AccessToken entity = new OAuth2AccessToken();
		this.oauth2AccessTokenRepository.save(entity);
		OAuth2AccessToken oauth2AccessToken=this.oauth2AccessTokenRepository.findById(entity.getId()).get();
		Assert.assertTrue(oauth2AccessToken!=null);
	}

	
}
