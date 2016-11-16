package com.faceye.component.weixin.service.message.receive;

/**
 * 接收消息接口
 * @author haipenge
 *
 */
public interface RMessage {
	public String getMsgType();
	
	public String getToUserName();
	
	public String getFromUserName();
}
