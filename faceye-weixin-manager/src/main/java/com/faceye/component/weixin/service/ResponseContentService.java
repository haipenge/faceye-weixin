package com.faceye.component.weixin.service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.ResponseContent;
import com.faceye.feature.service.BaseService;
/**
 * ResponseContent 服务接品<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface ResponseContentService extends BaseService<ResponseContent,Long>{
	public ResponseContent getDefaultResponseContent(Account account);
	public ResponseContent getResponseContent(Account account, String responseTypeCode);
}/**@generate-service-source@**/
