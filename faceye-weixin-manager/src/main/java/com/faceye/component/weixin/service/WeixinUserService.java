package com.faceye.component.weixin.service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.component.weixin.service.oauth2.response.WeixinUserInfo;
import com.faceye.feature.service.BaseService;
/**
 * WeixinUser 服务接品<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface WeixinUserService extends BaseService<WeixinUser,Long>{
    /**
     * 保存微信用户
     * @todo
     * @param weixinUserInfo
     * @return
     * @author:@haipenge
     * 联系:haipenge@gmail.com
     * 创建时间:2015年10月5日
     */
	public WeixinUser saveWeixinUser(Account account,WeixinUserInfo weixinUserInfo);
	
	/**
	 * 根据OpenId取得微信用户
	 * @todo
	 * @param openid
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月6日
	 */
	public WeixinUser getWeixinUserByOpenid(String openid);
}/**@generate-service-source@**/
