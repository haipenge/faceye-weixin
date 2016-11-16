package com.faceye.component.weixin.service.message.receive;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.faceye.component.weixin.util.WeixinConstants;
import com.faceye.feature.util.JaxbMapper;

/**
 * 消息转换工厂
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月27日
 */
public class MessageFactory {
	private Logger logger = Logger.getLogger(getClass());

	private static MessageFactory factory = null;

	private MessageFactory() {

	}

	synchronized public static MessageFactory getFactory() {
		if (factory == null) {
			factory = new MessageFactory();
		}
		return factory;
	}

	public  RMessage  getMessage(String messageString) {
		RMessage message = null;
		String msgType = WeixinConstants.MSG_TYPE_TEXT;
		if (StringUtils.isNotEmpty(messageString)) {
			try {
				Document document = DocumentHelper.parseText(messageString);
				Element root = document.getRootElement();
				msgType = root.element("MsgType").getText();
				message = buildReceiveMessage(messageString, msgType);
			} catch (DocumentException e) {
				logger.error(">>FaceYe throws Exception: --->", e);
			}
		}
		return message;
	}

	private RMessage buildReceiveMessage(String xml, String msgType) {
		RMessage message = null;
		logger.debug(">>FaceYe -- > Build receiveMessage,msg type is:"+msgType);
		if (StringUtils.equals(msgType, WeixinConstants.MSG_TYPE_TEXT)) {
			TextMessage textMessage= JaxbMapper.fromXml(xml, TextMessage.class);
			logger.debug(">>FaceYe --> format xml object class name :"+textMessage.getClass().getName()+",msg type is:"+msgType);
			message=textMessage;
		}else if(StringUtils.equals(msgType, WeixinConstants.MSG_TYPE_EVENT)){
			EventMessage eventMessage  = JaxbMapper.fromXml(xml, EventMessage.class);
			logger.debug(">>FaceYe --> format xml object class name :"+eventMessage.getClass().getName()+",msg type is:"+msgType);
			message=eventMessage;
		}
		return message;
	}
}
