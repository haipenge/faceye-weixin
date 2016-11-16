package com.faceye.component.weixin.service.oauth2.impl;

import java.net.URLEncoder;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.faceye.component.security.web.service.UserService;
import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.component.weixin.service.OAuth2AccessTokenService;
import com.faceye.component.weixin.service.WeixinUserService;
import com.faceye.component.weixin.service.oauth2.OAuth2Service;
import com.faceye.component.weixin.service.oauth2.response.OAuth2AccessToken;
import com.faceye.component.weixin.service.oauth2.response.WeixinUserInfo;
import com.faceye.component.weixin.util.WeixinConstants;
import com.faceye.feature.util.Json;
import com.faceye.feature.util.http.Http;

/**
 * 微信网页授权实现接口
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月3日
 */
@Service
public class OAuth2ServiceImpl implements OAuth2Service {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private OAuth2AccessTokenService oAuth2AccessTokenService = null;
	@Autowired
	private WeixinUserService weixinUserService = null;
	@Autowired
	@Qualifier("web-userServiceImpl")
	private UserService userService = null;
	@Autowired
	private AccountService accountService = null;

	/**
	 * 获得引导用户授权的URL
	 * @todo
	 * @param appId ->应用唯一标识
	 * @param redirectUri ->重定向地址
	 * @param scope  ->应用授权作用域,只能选择一个,snsapi_base (不弹出授权页面,直接跳转,这个只能拿到用户openid) snsapi_userinfo (弹出授权页面,这个可以通过 openid 拿到昵称、性别、所在 地)
	 * @param isWechatRedirect->直接在微信打开链接,可以不填此参数。做页面 302 重定向时 候,必须带此参数。
	 * @return -> exam:https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
	 *
	 * 如果用户同意授权,页面将跳转至 redirect_uri/?code=CODE&state=STATE。若用户禁止授 权,则重定向后不会带上 code 参数,仅会带上 state 参数 redirect_uri?state=STATE
	 * 
	 * code 说明 :
	 *  code 作为换取 access_token 的票据,每次用户授权带上的 code 将不一样,code 只能使用一 次,5 分钟未被使用自动过期。
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	@Override
	public String getOAuth2Url(String appId, String redirectUri, String scope, boolean isWechatRedirect) {
		// https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
		String res = "";
		StringBuilder sb = new StringBuilder();
		sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
		sb.append(appId);
		sb.append("&redirect_uri=");
		sb.append(URLEncoder.encode(redirectUri));
		sb.append("&response_type=code");
		sb.append("&scope=");
		if (StringUtils.isEmpty(scope)) {
			scope = WeixinConstants.OAUTH2_SCOPE_USERINFO;
			// scope="snsapi_base";
		}
		sb.append(scope);
		sb.append("&state=STATE");
		if (isWechatRedirect) {
			sb.append("#wechat_redirect");
		}
		res = sb.toString();
		logger.debug(">>FaceYe --> OAuth2 Url is :" + res);
		return res;
	}

	/**
	 * 取得获取access_token 的URL，在获取code之后
	 * @todo
	 * @param appid
	 * @param secret
	 * @param code,填写第一步获取的 code 参数
	 * @return:https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	@Override
	public String getAccessTokenUrl(String appid, String secret, String code) {
		// https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
		String res = "";
		StringBuilder sb = new StringBuilder("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
		sb.append(appid);
		sb.append("&secret=");
		sb.append(secret);
		sb.append("&code=");
		sb.append(code);
		sb.append("&grant_type=authorization_code");
		res = sb.toString();
		logger.debug(">>FaceYe --> get access_token url is:" + res);
		return res;
	}

	/**
	 * 取得oauth2 access_token
	 * 由于 access_token 拥有较短的有效期,当 access_token 超时后,可以使用 refresh_token 进行 刷新,refresh_token 拥有较长的有效期(7 天、30 天、60 天、90 天),当 refresh_token 失 效的后,需要用户重新授权。
	 * @todo
	 * @param url->https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=COD E&grant_type=authorization_code
	 * 或：https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */

	@Override
	public OAuth2AccessToken getOAuth2AccessToken(String url) {
		String res = Http.getInstance().get(url, "UTF-8");
		logger.debug(">>FaceYe get oauth2 access token url is:" + url);
		logger.debug(">>FaceYe --> oauth2 access token response from weixin is:" + res);
		OAuth2AccessToken oauth2AccessToken = null;
		if (StringUtils.isNotEmpty(res)) {
			oauth2AccessToken = Json.toObject(res, OAuth2AccessToken.class);
		}

		return oauth2AccessToken;
	}

	/**
	 * 由于 access_token 拥有较短的有效期,当 access_token 超时后,可以使用 refresh_token 进行 刷新,refresh_token 拥有较长的有效期(7 天、30 天、60 天、90 天),当 refresh_token 失 效的后,需要用户重新授权。
	 * @todo
	 * @param appid
	 * @param refreshToken
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	@Override
	public OAuth2AccessToken getRefreshOAuth2AccessToken(String appid, String refreshToken) {
		OAuth2AccessToken oauth2AccessToken = null;
		// ￼https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
		String url = "￼https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=";
		url += appid;
		url += "&grant_type=refresh_token&refresh_token=";
		url += refreshToken;
		logger.debug(">>FaceYe get refresh access token url is:" + url);
		// oauth2AccessToken = this.getOAuth2AccessToken(url);
		String res = Http.getInstance().get(url, "UTF-8");
		logger.debug(">>FaceYe get Refresh token res is:" + res);
		if (StringUtils.isNotEmpty(res)) {
			oauth2AccessToken = Json.toObject(res, OAuth2AccessToken.class);
		}
		return oauth2AccessToken;
	}

	/**
	 * 取得微信用户详情
	 * 通过 access_token 拉取用户信息(仅限 scope= snsapi_userinfo):
	 * http:GET https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN?acce ss_token=ACCESS_TOKEN&openid=OPENID
	 * @todo
	 * @param accessToken
	 * @param openid
	 * @return
	 * ->
	 * {
	￼"openid":" OPENID",
	￼" nickname": NICKNAME,
	￼"sex":"1",
	￼"province":"PROVINCE"
	￼"city":"CITY",
	￼"country":"COUNTRY",
	￼"privilege":[
	￼"PRIVILEGE1"
	￼"PRIVILEGE2"
	￼] }
	￼
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	@Override
	public WeixinUserInfo getWeixinUserInfo(String accessToken, String openid) {
		// https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN?access_token=ACCESS_TOKEN&openid=OPENID
		WeixinUserInfo weixinUserInfo = null;
		String res = "";
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=";
		url += accessToken;
		url += "&openid=";
		url += openid;
		res = Http.getInstance().get(url, "UTF-8");
		logger.debug(">>FaceYe get weixin user info url is:" + url);
		logger.debug(">>FaceYE --> get weixin user info res is:" + res);
		weixinUserInfo = Json.toObject(res, WeixinUserInfo.class);
		return weixinUserInfo;
	}

	@Override
	public void refreshOAuth2AccessToken() {
		logger.debug(">>FaceYe --> Start to refresh access token ");
		int page = 1;
		while (true) {
			Page<com.faceye.component.weixin.entity.OAuth2AccessToken> oAuth2AccessTokens = this.oAuth2AccessTokenService.getPage(null,
					page, 100);
			if (oAuth2AccessTokens != null && CollectionUtils.isNotEmpty(oAuth2AccessTokens.getContent())) {
				for (com.faceye.component.weixin.entity.OAuth2AccessToken accessToken : oAuth2AccessTokens.getContent()) {
					boolean isExpire = false;
					if (accessToken.getLastRefreshDate().getTime() + accessToken.getExpiresIn() * 1000L < System.currentTimeMillis()) {
						isExpire = true;
					}
					logger.debug(">>FaceYe in refresh access token ,access token :appid:"+accessToken.getAccount().getAppId()+",expires in:"+accessToken.getExpiresIn()+",open id:"+accessToken.getWeixinUser().getOpenid()+",is expire :"+isExpire);
					if (isExpire) {
						String appid = accessToken.getAccount().getAppId();
						String refreshToken = accessToken.getRefreshAccessToken();
						OAuth2AccessToken oAuth2AccessToken = this.getRefreshOAuth2AccessToken(appid, refreshToken);
						if (oAuth2AccessToken != null) {
							this.oauth2(accessToken.getAccount(), oAuth2AccessToken);
						}
					}
				}
			} else {
				break;
			}
		}
	}

	/**
	 * 用户授权微信访问
	 */
	@Override
	public WeixinUser oauth2(Account account, OAuth2AccessToken oAuth2AccessToken) {
		// Scop:snsapi_base,snsapi_userinfo
		WeixinUser weixinUser = null;
		if (StringUtils.equals(oAuth2AccessToken.getScope(), WeixinConstants.OAUTH2_SCOPE_BASE)) {
			WeixinUserInfo weixinUserInfo = new WeixinUserInfo();
			weixinUserInfo.setOpenid(oAuth2AccessToken.getOpenid());
			weixinUser = this.weixinUserService.saveWeixinUser(account, weixinUserInfo);
		} else if (StringUtils.equals(oAuth2AccessToken.getScope(), WeixinConstants.OAUTH2_SCOPE_USERINFO)) {
			WeixinUserInfo weixinUserInfo = this.getWeixinUserInfo(oAuth2AccessToken.getAccess_token(), oAuth2AccessToken.getOpenid());
			weixinUser = this.weixinUserService.saveWeixinUser(account, weixinUserInfo);
		}
//		WeixinUserInfo weixinUserInfo = this.getWeixinUserInfo(oAuth2AccessToken.getAccess_token(), oAuth2AccessToken.getOpenid());
//		weixinUser = this.weixinUserService.saveWeixinUser(account, weixinUserInfo);
		this.oAuth2AccessTokenService.saveOAuth2AccessToken(account, weixinUser, oAuth2AccessToken);
		return weixinUser;
	}

	public WeixinUser oauth2(String appid, String code) {
		WeixinUser weixinUser = null;
		Account account = this.accountService.getAccountByAppId(appid);
		String url = this.getAccessTokenUrl(appid, account.getSecret(), code);
		OAuth2AccessToken oAuth2AccessToken = this.getOAuth2AccessToken(url);
		weixinUser = this.oauth2(account, oAuth2AccessToken);
		return weixinUser;
	}
}
