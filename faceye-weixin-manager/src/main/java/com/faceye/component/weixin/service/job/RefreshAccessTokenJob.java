package com.faceye.component.weixin.service.job;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.component.weixin.service.api.BaseApi;
import com.faceye.component.weixin.service.message.response.AccessToken;
import com.faceye.feature.service.job.impl.BaseJob;

/**
 * 刷新access token 的jok
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月28日
 */
@Service
public class RefreshAccessTokenJob extends BaseJob {
	@Autowired
	private AccountService accountService = null;

	@Autowired
	private BaseApi api = null;

	@Override
	public void run() {
		List<Account> accounts = this.accountService.getAll();
		if (CollectionUtils.isNotEmpty(accounts)) {
			for (Account account : accounts) {
				AccessToken accessToken = this.api.getAccessToken(account, true);
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					logger.error(">>FaceYe throws Exception: --->",e);
				}
			}
		}
	}

}
