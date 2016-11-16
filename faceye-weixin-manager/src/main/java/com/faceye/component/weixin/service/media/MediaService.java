package com.faceye.component.weixin.service.media;

import com.faceye.component.weixin.service.media.response.NewsItemResponse;
import com.faceye.component.weixin.service.media.response.NewsListResponse;

/**
 * 多媒体接口
 * @author haipenge
 *
 */
public interface MediaService {

	/**
	 * 获取临时素材
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月9日 下午6:45:19
	 */
	public String getTempMedia(String accessToken,String mediaId);
	
	/**
	 * 获取永久素材
	 * @param accessToken
	 * @param mediaId
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月30日 上午11:56:55
	 */
	public NewsItemResponse getMedia(String accessToken,String mediaId);
	
	/**
	 * 取得图文素材列表
	 * @param accessToken
	 * @param type
	 * @param offset
	 * @param count
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月30日 下午1:36:05
	 */
	public NewsListResponse getMediaList(String accessToken,String type,String offset,String count);
	
	
}
