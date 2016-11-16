package com.faceye.component.weixin.service;

import java.util.List;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.WeixinMenu;
import com.faceye.feature.service.BaseService;
/**
 * WeixinMenu 服务接品<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface WeixinMenuService extends BaseService<WeixinMenu,Long>{

	/**
	 * 取得一个帐户的一级微信菜单
	 * @param account
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月12日 上午11:27:07
	 */
	public List<WeixinMenu> getWeixinMenusByAccountAndWeixinMenuIsNull(Account account);
	
	/**
	 * 取得一个菜单下的二级菜单
	 * @param weixinMenu
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月12日 上午11:27:59
	 */
	public List<WeixinMenu> getWeixinMenusByWeixinMenu(WeixinMenu weixinMenu);
	
}/**@generate-service-source@**/
