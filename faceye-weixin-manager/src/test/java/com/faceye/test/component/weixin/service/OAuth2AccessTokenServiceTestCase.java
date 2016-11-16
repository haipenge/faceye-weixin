package com.faceye.test.component.weixin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

import com.faceye.component.weixin.entity.OAuth2AccessToken;
import com.faceye.component.weixin.service.OAuth2AccessTokenService;
import com.faceye.test.feature.service.BaseServiceTestCase;


/**
 * OAuth2AccessToken  服务层测试用例
 * 
 * @author @haipenge haipenge@gmail.com Create Date:2014年5月20日
 */
public class OAuth2AccessTokenServiceTestCase extends BaseServiceTestCase {
	@Autowired
	private OAuth2AccessTokenService oauth2AccessTokenService = null;
	/**
	 * 初始化
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@Before
	public void set() throws Exception {
		Assert.isTrue(oauth2AccessTokenService != null);
	}

	/**
	 * 清理
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@After
	public void after() throws Exception {
		//this.oauth2AccessTokenService.removeAllInBatch();
	}

	/**
	 *  保存测试
	 * @todo
	 * @throws Exception
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月20日
	 */
	@Test
	public void testSave() throws Exception {
		OAuth2AccessToken entity = new OAuth2AccessToken();
		this.oauth2AccessTokenService.save(entity);
		List<OAuth2AccessToken> entites = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testSaveAndFlush() throws Exception {
		OAuth2AccessToken entity = new OAuth2AccessToken();
		this.oauth2AccessTokenService.save(entity);
		List<OAuth2AccessToken> entites = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entites));
	}

	@Test
	public void testMultiSave() throws Exception {
		for (int i = 0; i < 5; i++) {
			OAuth2AccessToken entity = new OAuth2AccessToken();
			this.oauth2AccessTokenService.save(entity);
		}
		List<OAuth2AccessToken> entities = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testRemoveById() throws Exception {
		OAuth2AccessToken entity = new OAuth2AccessToken();
		this.oauth2AccessTokenService.save(entity);
		logger.debug(">>Entity id is:" + entity.getId());
		OAuth2AccessToken e = this.oauth2AccessTokenService.get(entity.getId());
		Assert.isTrue(e != null);
	}

	@Test
	public void testRemoveEntity() throws Exception {
		OAuth2AccessToken entity = new OAuth2AccessToken();
		this.oauth2AccessTokenService.save(entity);
		this.oauth2AccessTokenService.remove(entity);
		List<OAuth2AccessToken> entities = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAllInBatch() throws Exception {
		for (int i = 0; i < 5; i++) {
			OAuth2AccessToken entity = new OAuth2AccessToken();
			this.oauth2AccessTokenService.save(entity);
		}
		List<OAuth2AccessToken> entities = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
		this.oauth2AccessTokenService.removeAllInBatch();
		entities = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			OAuth2AccessToken entity = new OAuth2AccessToken();
			this.oauth2AccessTokenService.save(entity);
		}
		this.oauth2AccessTokenService.removeAll();
		List<OAuth2AccessToken> entities = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testRemoveListInBatch() throws Exception {
		List<OAuth2AccessToken> entities = new ArrayList<OAuth2AccessToken>();
		for (int i = 0; i < 5; i++) {
			OAuth2AccessToken entity = new OAuth2AccessToken();
			
			this.oauth2AccessTokenService.save(entity);
			entities.add(entity);
		}
		this.oauth2AccessTokenService.removeInBatch(entities);
		entities = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isEmpty(entities));
	}

	@Test
	public void testGetAll() throws Exception {
		for (int i = 0; i < 5; i++) {
			OAuth2AccessToken entity = new OAuth2AccessToken();
			this.oauth2AccessTokenService.save(entity);
		}
		List<OAuth2AccessToken> entities = this.oauth2AccessTokenService.getAll();
		Assert.isTrue(CollectionUtils.isNotEmpty(entities) && entities.size() == 5);
	}

	@Test
	public void testGetPage() throws Exception {
		for (int i = 0; i < 25; i++) {
			OAuth2AccessToken entity = new OAuth2AccessToken();
			this.oauth2AccessTokenService.save(entity);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<OAuth2AccessToken> page = this.oauth2AccessTokenService.getPage(searchParams, 1, 5);
		Assert.isTrue(page != null && page.getSize() == 5);
		searchParams.put("EQ_name", "test-10");
		page = this.oauth2AccessTokenService.getPage(searchParams, 1, 5);
		Assert.isTrue(page != null && page.getTotalElements() == 1);
		searchParams = new HashMap<String, Object>();
		searchParams.put("LIKE_name", "test");
		page = this.oauth2AccessTokenService.getPage(searchParams, 1, 5);

		Assert.isTrue(page != null && page.getTotalElements() == 25 && page.getNumberOfElements() == 5);

	}

	@Test
	public void testGet() throws Exception {
		Long id = null;
		for (int i = 0; i < 25; i++) {
			OAuth2AccessToken entity = new OAuth2AccessToken();
			this.oauth2AccessTokenService.save(entity);
			id = entity.getId();
		}
		OAuth2AccessToken e = this.oauth2AccessTokenService.get(id);
		Assert.isTrue(e != null);
	}

	@Test
	public void testGetByIds() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < 25; i++) {
			OAuth2AccessToken entity = new OAuth2AccessToken();
			this.oauth2AccessTokenService.save(entity);
			if (i < 5) {
				ids.add(entity.getId());
			}
		}
		List<OAuth2AccessToken> entities = this.oauth2AccessTokenService.getAll(ids);
		Assert.isTrue(entities != null && entities.size() == 5);
	}
}
