package com.faceye.component.weixin.service;

import javax.servlet.http.HttpServletRequest;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.service.message.receive.RMessage;
import com.faceye.component.weixin.service.message.response.ResponseMessage;

/**
 * 用户自定义消息
 * 当前用于扫码等待
 * @author haipenge
 *
 */
public interface UserDefineResponseMessage {
	
   public ResponseMessage build(Account account,RMessage receiveMessage);
}
