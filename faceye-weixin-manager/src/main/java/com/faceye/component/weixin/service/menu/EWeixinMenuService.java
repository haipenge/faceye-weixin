package com.faceye.component.weixin.service.menu;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.service.message.response.BaseResponse;

/**
 * 微信公众号自定义菜单维护
 * @author haipenge
 *
 */
public interface EWeixinMenuService {

	/**
	 * 创建微信菜单
	 * @param account
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月12日 上午11:25:04
	 */
	public BaseResponse createWeixinMenu(Account account);
	/**
	 * 查询微信菜单（从微信服务器）
	 * @param account
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月12日 下午2:13:52
	 */
	public String getWeixinMenu(Account account);
	
	/**
	 * 删除微信菜单
	 * @param account
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月12日 下午2:17:44
	 */
	public BaseResponse deleteWeixinMenu(Account account);
}
