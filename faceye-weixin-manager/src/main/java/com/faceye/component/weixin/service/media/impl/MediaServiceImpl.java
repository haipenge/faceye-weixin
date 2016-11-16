package com.faceye.component.weixin.service.media.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.service.media.MediaService;
import com.faceye.component.weixin.service.media.response.NewsItemResponse;
import com.faceye.component.weixin.service.media.response.NewsListResponse;
import com.faceye.feature.util.DateUtil;
import com.faceye.feature.util.Json;
import com.faceye.feature.util.http.Http;
import com.faceye.feature.util.storage.StorageHandler;

@Service
public class MediaServiceImpl implements MediaService {
	@Value("#{property['weixin.media.storage.path']}")
	private String mediaStoragePath = "";
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 获取临时素材接口 https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID 返回存储路径
	 * 
	 * @TODO,当前只存储图片，需进行修改，支持多种文件格式的存储 参考文档：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738727&token=&lang=zh_CN
	 */
	@Override
	public String getTempMedia(String accessToken, String mediaId) {
		String path = mediaStoragePath;
		logger.debug(">>FaceYe --> mediaStoragePath path is:" + path);
		path += "/";
		String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=" + accessToken + "&media_id=" + mediaId;
		byte[] bytes = Http.getInstance().getContent(url, "UTF-8", null);
		String dateDir = DateUtil.formatDate(new Date(), "yyyyMMdd");
		path += dateDir;
		path += "/";
		path += mediaId;
		path += ".jpg";
		StorageHandler.getInstance().write(bytes, path);
		return path;
	}

	/**
	 * 获取永久素材 https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN
	 */
	@Override
	public NewsItemResponse getMedia(String accessToken, String mediaId) {
		NewsItemResponse response = null;
		String url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
		url += accessToken + "&media_id=" + mediaId;
		String result = Http.getInstance().postJson(url, "utf-8", "{media_id:\"" + mediaId + "\"}");
		// String result=Http.getInstance().get(url, "utf-8");
		logger.debug(">>FaceYe -- Get media result is:" + result);
		if (StringUtils.isNotEmpty(result)) {
			response = Json.toObject(result, NewsItemResponse.class);
		}
		return response;
	}

	/**
	 * 取得素材列表 https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN
	 */
	@Override
	public NewsListResponse getMediaList(String accessToken, String type, String offset, String count) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=" + accessToken;
		if (StringUtils.isEmpty(type)) {
			type = "news";
		}
		if (StringUtils.isEmpty(offset)) {
			offset = "0";
		} 
		if (StringUtils.isEmpty(count)) {
			count = "10";
		}
		String json = "{\"type\":\"" + type + "\",\"offset\":\"" + offset + "\",\"count\":\"" + count + "\"}";
		logger.debug(">>FaceYe --> get media list json is:"+json);
		Map params=new HashMap();
		params.put("type", type);
		params.put("offset", offset);
		params.put("count", count);
		String result = Http.getInstance().postJson(url, "utf-8", json);
		logger.debug(">>FaceYe --> Get Media list json is:" + result);
		NewsListResponse response = Json.toObject(result, NewsListResponse.class);
		if (response == null) {
			logger.debug(">>FaceYE getMedia response is null.");
		}
		return response;
	}

}
