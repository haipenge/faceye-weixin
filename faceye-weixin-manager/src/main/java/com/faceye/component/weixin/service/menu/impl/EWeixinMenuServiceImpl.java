package com.faceye.component.weixin.service.menu.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.WeixinMenu;
import com.faceye.component.weixin.service.WeixinMenuService;
import com.faceye.component.weixin.service.menu.EWeixinMenuService;
import com.faceye.component.weixin.service.menu.request.Button;
import com.faceye.component.weixin.service.menu.request.MenuRequest;
import com.faceye.component.weixin.service.message.response.BaseResponse;
import com.faceye.component.weixin.service.oauth2.OAuth2Service;
import com.faceye.component.weixin.util.WeixinConstants;
import com.faceye.feature.util.Json;
import com.faceye.feature.util.http.Http;

/**
 * 微信菜单维护 DOC:http://mp.weixin.qq.com/wiki/5/f287d1a5b78a35a8884326312ac3e4ed.html
 * 
 * @author haipenge
 *
 */
@Service
public class EWeixinMenuServiceImpl implements EWeixinMenuService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WeixinMenuService weixinMenuService = null;
	@Autowired
	private OAuth2Service oauth2Service = null;

	/**
	 * 创建自定义菜单 https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
	 */
	@Override
	public BaseResponse createWeixinMenu(Account account) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
		url += account.getAccessToken();
		MenuRequest menuRequest = this.buildMenuRequest(account);
		String data = Json.toJson(menuRequest);
		logger.debug(">>FaceYe --> Create Menu Request:" + data);
		String response = Http.getInstance().postJson(url, "UTF-8", data);
		logger.debug(">>FaceYe --> Crate Menu Respone :" + response);
		BaseResponse result = Json.toObject(response, BaseResponse.class);
		return result;
	}

	/**
	 * 创建请求对像
	 * 
	 * @param account
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月12日 下午2:08:06
	 */
	private MenuRequest buildMenuRequest(Account account) {
		MenuRequest menuRequest = new MenuRequest();
		List<WeixinMenu> rootMenus = this.weixinMenuService.getWeixinMenusByAccountAndWeixinMenuIsNull(account);
		String oauth2Url = "";
		// String oauth2Url = oauth2Service.getOAuth2Url(account.getAppId(), host + "/emergency/rabbit/home" + "?appId=" + account.getAppId(), "", true);
		if (CollectionUtils.isNotEmpty(rootMenus)) {
			for (WeixinMenu weixinMenu : rootMenus) {
				Button button = new Button();
				button.setKey(weixinMenu.getKey());
				button.setMediaId(weixinMenu.getMediaId());
				button.setName(weixinMenu.getName());
				button.setType(weixinMenu.getType());
				String _url=weixinMenu.getUrl();
				if(_url.indexOf("?")==-1){
					_url+="?appId="+account.getAppId();
				}else{
					_url+="&appId="+account.getAppId();
				}
				//可访问菜单用户，为已关注 用户，已关注用户，使用userinfo scope,不会启动跳转页面，为静默授权，可获取用户身份信息
				oauth2Url = this.oauth2Service.getOAuth2Url(account.getAppId(), _url, WeixinConstants.OAUTH2_SCOPE_USERINFO, true);
				logger.debug(">>FaceYe --> weixin menu url is:"+oauth2Url);
				button.setUrl(oauth2Url);
				List<WeixinMenu> children = this.weixinMenuService.getWeixinMenusByWeixinMenu(weixinMenu);
				if (CollectionUtils.isNotEmpty(children)) {
					for (WeixinMenu sub : children) {
						Button subButton = new Button();
						subButton.setKey(sub.getKey());
						subButton.setMediaId(sub.getMediaId());
						subButton.setName(sub.getName());
						subButton.setType(sub.getType());
						 String subUrl=sub.getUrl();
						if(subUrl.indexOf("?")==-1){
							subUrl+="?appId="+account.getAppId();
						}else{
							subUrl+="&appId="+account.getAppId();
						}
						oauth2Url = this.oauth2Service.getOAuth2Url(account.getAppId(), subUrl, WeixinConstants.OAUTH2_SCOPE_USERINFO, true);
						logger.debug(">>FaceYe --> weixin menu url is:"+oauth2Url);
						subButton.setUrl(oauth2Url);
						button.getSubButtons().add(subButton);
					}
				}
				menuRequest.getButton().add(button);
			}
		}
		return menuRequest;
	}

	/**
	 * 查询微信菜单 https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN
	 */
	@Override
	public String getWeixinMenu(Account account) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
		url += account.getAccessToken();
		String response = Http.getInstance().get(url, "UTF-8");
		logger.debug(">>FaceYe getWeixinMenu,response is:" + response);
		return response;
	}

	/**
	 * 删除微信菜单
	 * 
	 * URL:https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN
	 */
	@Override
	public BaseResponse deleteWeixinMenu(Account account) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
		url += account.getAccessToken();
		String response = Http.getInstance().get(url, "UTF-8");
		logger.debug(">>FaceYe delete weixin menu response is:" + response);
		BaseResponse result = Json.toObject(response, BaseResponse.class);
		return result;
	}

}
