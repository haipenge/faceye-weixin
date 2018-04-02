package com.faceye.test.component.weixin.service.api;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.faceye.component.weixin.service.api.BaseApi;
import com.faceye.component.weixin.service.message.response.AccessToken;
import com.faceye.test.feature.service.BaseServiceTestCase;

public class BaseApiTestCase extends BaseServiceTestCase {
	@Autowired
	private BaseApi baseApi = null;

	private Long accountId = null;

	@Before
	public void set() throws Exception {
		accountId = 1L;
	}
	@Test
	public void testGetAccessToken() throws Exception {
		AccessToken accessToken = baseApi.getAccessToken(accountId, true);
		Assert.assertTrue(StringUtils.isEmpty(accessToken.getErrcode()) && StringUtils.isNotEmpty(accessToken.getAccess_token()));
	}
}
