package com.faceye.component.weixin.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.service.UserDefineResponseMessage;
import com.faceye.component.weixin.service.message.receive.RMessage;
import com.faceye.component.weixin.service.message.response.ResponseMessage;

@Service("defaultUserDefineResponseMessage")
public class DefaultUserDefineResponseMessageImpl implements UserDefineResponseMessage {

	@Override
	public ResponseMessage build(Account account, RMessage receiveMessage) {
		return null;
	}

}
