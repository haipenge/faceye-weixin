package com.faceye.component.weixin.service.message.request;

/**
 * 构造微信分享请求对像 用于组织wx.onMenuShareTimeline({})
 * 
 * @author haipenge
 *
 */
public class WeixinShareRequest {
	private String title = "";
	private String desc = "";
	private String link = "";
	private String imgUrl = "";
	private WeixinConfigRequestObject weixinConfigRequestObject = null;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public WeixinConfigRequestObject getWeixinConfigRequestObject() {
		return weixinConfigRequestObject;
	}

	public void setWeixinConfigRequestObject(WeixinConfigRequestObject weixinConfigRequestObject) {
		this.weixinConfigRequestObject = weixinConfigRequestObject;
	}

}
