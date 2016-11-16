package com.faceye.component.weixin.service.response.event;

/**
 * 关注/取消关注事件
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月18日
 */
public class Event {
	private String toUserName = "";
	private String fromUserName = "";
	private String createTime = "";
	private String msgType = "";
	private String event="";
	////GEO EVENT
	private String latitude="";
	private String longitude="";
	private String precision="";
	
	//Menu Event,Ticket Event
	private String eventKey="";
	
	//Ticken Event
	private String ticket="";

}
