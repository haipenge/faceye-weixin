package com.faceye.component.weixin.service.media.response;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文素材列表
 * @author haipenge
 *
 */
public class NewsListResponse {
    private String errcode="";
    private String errmsg="";
	private String total_count="";
	private String item_count="";
	private List<NewsListItem> item=new ArrayList<NewsListItem>(0);
	public String getTotal_count() {
		return total_count;
	}
	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}
	public String getItem_count() {
		return item_count;
	}
	public void setItem_count(String item_count) {
		this.item_count = item_count;
	}
	public List<NewsListItem> getItem() {
		return item;
	}
	public void setItem(List<NewsListItem> item) {
		this.item = item;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	
	
}
