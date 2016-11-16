package com.faceye.component.weixin.service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.OAuth2AccessToken;
import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.feature.service.BaseService;
/**
 * OAuth2AccessToken 服务接品<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface OAuth2AccessTokenService extends BaseService<OAuth2AccessToken,Long>{
    /**
     * 保存或更新oauth2 access token
     * @todo
     * @param account
     * @param oAuth2AccessToken
     * @return
     * @author:@haipenge
     * 联系:haipenge@gmail.com
     * 创建时间:2015年10月5日
     */
	public OAuth2AccessToken saveOAuth2AccessToken(Account account,WeixinUser weixinUser,com.faceye.component.weixin.service.oauth2.response.OAuth2AccessToken oAuth2AccessToken);
	
}/**@generate-service-source@**/
