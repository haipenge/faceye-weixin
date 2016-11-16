package com.faceye.component.weixin.service.oauth2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.service.oauth2.OAuth2Service;
import com.faceye.feature.service.job.impl.BaseJob;
@Service
public class OAuth2AccessTokenRefreshJob extends BaseJob {
	@Autowired
    private OAuth2Service oAuth2Service=null;
	@Override
	public void run() {
		this.oAuth2Service.refreshOAuth2AccessToken();
	}

}
