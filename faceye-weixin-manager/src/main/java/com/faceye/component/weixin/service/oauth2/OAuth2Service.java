package com.faceye.component.weixin.service.oauth2;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.component.weixin.service.oauth2.response.OAuth2AccessToken;
import com.faceye.component.weixin.service.oauth2.response.WeixinUserInfo;

/**
 * 微信oauth2网页授权接口
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月3日
 */
public interface OAuth2Service {

	/**
	 * 获得引导用户授权的URL
	 * @todo
	 * @param appId ->应用唯一标识
	 * @param redirectUri ->重定向地址
	 * @param scope  ->应用授权作用域,只能选择一个,snsapi_base (不弹出授权页面,直接跳转,这个只能拿到用户openid) snsapi_userinfo (弹出授权页面,这个可以通过 openid 拿到昵称、性别、所在 地)
	 * @param isWechatRedirect->直接在微信打开链接,可以不填此参数。做页面 302 重定向时 候,必须带此参数。
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	public String getOAuth2Url(String appId, String redirectUri, String scope, boolean isWechatRedirect);

	/**
	 * 取得获取access_token 的URL，在获取code之后
	 * @todo
	 * @param appid
	 * @param secret
	 * @param code,填写第一步获取的 code 参数
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	public String getAccessTokenUrl(String appid, String secret, String code);

	/**
	 * 取得oauth2 access_token
	 * 由于 access_token 拥有较短的有效期,当 access_token 超时后,可以使用 refresh_token 进行 刷新,refresh_token 拥有较长的有效期(7 天、30 天、60 天、90 天),当 refresh_token 失 效的后,需要用户重新授权。
	 * @todo
	 * @param url->https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=COD E&grant_type=authorization_code
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	public OAuth2AccessToken getOAuth2AccessToken(String url);
	
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
	public OAuth2AccessToken getRefreshOAuth2AccessToken(String appid,String refreshToken);
	
	/**
	 * OAuth2 过期后自动刷新 
	 * @todo
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月5日
	 */
	public void refreshOAuth2AccessToken();
	
	/**
	 * 取得微信用户详情
	 * 通过 access_token 拉取用户信息(仅限 scope= snsapi_userinfo):
	 * @todo
	 * @param accessToken
	 * @param openid
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	public WeixinUserInfo getWeixinUserInfo(String accessToken,String openid);
	/**
	 * 微信用户授权与本地用户系统统一
	 * @todo
	 * @param oAuth2AccessToken
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月5日
	 */
	public WeixinUser oauth2(Account account,OAuth2AccessToken oAuth2AccessToken);
	/**
	 * 网页认证
	 * @todo
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月5日
	 */
	public WeixinUser oauth2(String appid, String code);
}
