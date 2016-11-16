package com.faceye.component.weixin.service;

import com.faceye.component.weixin.entity.ResponseContentItem;
import com.faceye.feature.service.BaseService;
/**
 * ResponseContentItem 服务接品<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月20日<br>
 */
public interface ResponseContentItemService extends BaseService<ResponseContentItem,Long>{

	public ResponseContentItem getResponseContentItemByUrl(String url);
	public ResponseContentItem getResponseContentItemByResponseContentAndUrl(Long responseContentId,String url);
}/**@generate-service-source@**/
