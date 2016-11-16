package com.faceye.component.weixin.service.media.response;

import java.util.ArrayList;
import java.util.List;

public class NewsItemResponse {

	private List<NewsItem> newsItem=new ArrayList<NewsItem>(0);

	public List<NewsItem> getNewsItem() {
		return newsItem;
	}

	public void setNewsItem(List<NewsItem> newsItem) {
		this.newsItem = newsItem;
	}
	
	
}
