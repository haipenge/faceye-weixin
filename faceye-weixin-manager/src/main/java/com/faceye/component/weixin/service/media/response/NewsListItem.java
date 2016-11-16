package com.faceye.component.weixin.service.media.response;

import java.util.ArrayList;
import java.util.List;

public class NewsListItem {
	private String media_id = "";
//	private List<NewsItem> content = new ArrayList<NewsItem>(0);
	private String update_time="";
	private NewsListItemContent content=null;
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public NewsListItemContent getContent() {
		return content;
	}
	public void setContent(NewsListItemContent content) {
		this.content = content;
	}
	
	

}
