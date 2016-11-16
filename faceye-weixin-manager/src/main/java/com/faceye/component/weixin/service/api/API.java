package com.faceye.component.weixin.service.api;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.faceye.component.security.service.UserService;
import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.JSAPITicket;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.component.weixin.service.JSAPITicketService;
import com.faceye.component.weixin.service.message.response.AccessToken;
import com.faceye.component.weixin.service.message.response.JSAPITicketResponse;
import com.faceye.feature.util.Json;
import com.faceye.feature.util.http.Http;

/**
 * 所有API的基类
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月18日
 */
abstract public class API {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected AccountService accountService = null;
	@Autowired
	protected UserService userService = null;
	@Autowired
	protected JSAPITicketService jsapiTicketService = null;

	/**
	 * 取得Access token
	 * @todo
	 * @param accountId
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月19日
	 */
	public AccessToken getAccessToken(Long accountId, boolean isForceRefresh) {
		AccessToken accessToken = null;
		Account account = this.accountService.get(accountId);
		accessToken = this.getAccessToken(account, isForceRefresh);
		return accessToken;
	}

	public AccessToken getAccessToken(Account account, boolean isForceRefresh) {
		AccessToken accessToken = null;
		if (account != null) {
			accessToken = this.refreshAccessToken(account, isForceRefresh);
		}
		return accessToken;
	}

	/**
	 * 刷新access token
	 * @todo
	 * @param account
	 * @param isForce ->是否强制刷新
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月19日
	 */
	protected AccessToken refreshAccessToken(Account account, boolean isForceRefresh) {
		boolean isExpire = account.isTokenExpire();
		AccessToken accessToken = null;
		if (isExpire || isForceRefresh) {
			accessToken = this.refreshAccessToken(account.getAppId(), account.getSecret());
			if (accessToken != null) {
				account.setAccessToken(accessToken.getAccess_token());
				account.setLastGotAccessTokenDate(new Date());
				this.accountService.save(account);
			}
		} else {
			accessToken = new AccessToken();
			accessToken.setAccess_token(account.getAccessToken());
		}
		return accessToken;
	}

	/**
	 * 刷新access token
	 * @todo
	 * @param appId
	 * @param secret
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月19日
	 */
	protected AccessToken refreshAccessToken(String appId, String secret) {
		AccessToken accessToken = null;
		String res = "";
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret;
		res = Http.getInstance().get(url, "utf-8");
		logger.debug(">>FaceYe Get Access Token is: " + res);
		accessToken = Json.toObject(res, AccessToken.class);
		return accessToken;
	}

	/**
	 * 获取js-sdk临时票据
	 * @todo
	 * @param appid
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月7日
	 */
	public JSAPITicket getJSAPITicket(String appid) {
		JSAPITicket jsapiTicket = null;
		Account account = this.accountService.getAccountByAppId(appid);
		if (account != null) {
			jsapiTicket = this.getJSAPITicket(account);
		}
		return jsapiTicket;
	}

	/**
	 * 根据微信公众号帐户获取jsapi ticket
	 * @todo
	 * @param account
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月7日
	 */
	public JSAPITicket getJSAPITicket(Account account) {
		JSAPITicket jsapiTicket = null;
		jsapiTicket = this.jsapiTicketService.getJSAPITicketByAccount(account);
		if (jsapiTicket == null) {
			jsapiTicket = new JSAPITicket();
		}
		boolean isJSAPITicketExpire = jsapiTicket.isExpire();
		if (isJSAPITicketExpire) {
			boolean isAccessTokenExpire = account.isTokenExpire();
			if (isAccessTokenExpire) {
				this.refreshAccessToken(account, true);
			}
			JSAPITicketResponse jsapiTicketResponse = this.refreshJSAPITicket(account.getAccessToken());
			if (jsapiTicketResponse != null) {
				jsapiTicket.setAccount(account);
				jsapiTicket.setCreateDate(new Date());
				jsapiTicket.setExpiresIn(jsapiTicketResponse.getExpires_in());
				jsapiTicket.setLastRefreshDate(new Date());
				jsapiTicket.setTicket(jsapiTicketResponse.getTicket());
				this.jsapiTicketService.save(jsapiTicket);
			}
		}
		return jsapiTicket;
	}

	/**
	 * 刷新 js-sdk临时票据
	 * @todo
	 * @param accessToken
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月7日
	 */
	protected JSAPITicketResponse refreshJSAPITicket(String accessToken) {
		JSAPITicketResponse jsapiTicketResponse = null;
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";
		String res = Http.getInstance().get(url, "UTF-8");
		logger.debug(">>FaceYe --> get jsapi ticket is:" + res);
		jsapiTicketResponse = Json.toObject(res, JSAPITicketResponse.class);
		return jsapiTicketResponse;
	}

}
