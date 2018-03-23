package com.faceye.component.weixin.service.api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.Msg;
import com.faceye.component.weixin.entity.ResponseContent;
import com.faceye.component.weixin.entity.ResponseContentItem;
import com.faceye.component.weixin.service.MsgService;
import com.faceye.component.weixin.service.ResponseContentItemService;
import com.faceye.component.weixin.service.ResponseContentService;
import com.faceye.component.weixin.service.ResponseTypeService;
import com.faceye.component.weixin.service.UserDefineResponseMessage;
import com.faceye.component.weixin.service.message.encrypt.aes.AesException;
import com.faceye.component.weixin.service.message.encrypt.aes.WXBizMsgCrypt;
import com.faceye.component.weixin.service.message.receive.EventMessage;
import com.faceye.component.weixin.service.message.receive.MessageFactory;
import com.faceye.component.weixin.service.message.receive.RMessage;
import com.faceye.component.weixin.service.message.receive.ReceiveMessage;
import com.faceye.component.weixin.service.message.receive.TextMessage;
import com.faceye.component.weixin.service.message.receive.XMLUtil;
import com.faceye.component.weixin.service.message.response.ResponseMessage;
import com.faceye.component.weixin.service.message.response.RichText;
import com.faceye.component.weixin.service.message.response.RichTextResponseMessage;
import com.faceye.component.weixin.service.message.response.TextResponseMessage;
import com.faceye.component.weixin.util.WeixinConstants;
import com.faceye.feature.service.PropertyService;
import com.faceye.feature.service.Reporter;
import com.faceye.feature.util.JaxbMapper;
import com.faceye.feature.util.SHAUtils;
import com.faceye.feature.util.bean.BeanContextUtil;
import com.faceye.feature.util.http.HttpUtil;


/**
 * 消息接口
 * 
 * @author @haipenge
 * @联系:haipenge@gmail.com 创建时间:2015年5月18日
 */
@Service
public class MsgApi extends API {
	@Autowired
	private MsgService msgService = null;

	@Autowired
	private ResponseTypeService responseTypeService = null;
	@Autowired
	private ResponseContentService responseContentService = null;

	@Autowired
	private ResponseContentItemService responseContentItemService = null;
	@Autowired
	private Reporter reporter = null;

	/**
	 * 消息验证
	 * 
	 * @todo
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年5月18日
	 */
	public boolean checkSignature(Long accountId, String signature, String timestamp, String nonce) {
		boolean res = false;
		logger.debug(">>FaceYe start 2 check signature now.accountId:" + accountId + "," + signature + "," + timestamp + "," + nonce);
		Account account = this.accountService.get(accountId);
		if (account != null) {
			String token = account.getToken();
			res = this.checkSignature(token, signature, timestamp, nonce);
		}
		return res;
	}

	private boolean checkSignature(String token, String signature, String timestamp, String nonce) {
		boolean res = false;
		String[] arr = new String[] { token, timestamp, nonce };
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (String str : arr) {
			sb.append(str);
		}
		logger.debug(">>FaceYe,string need 2 sha is:" + sb.toString());
		String shaStr = SHAUtils.sha(sb.toString());
		if (StringUtils.equalsIgnoreCase(shaStr, signature)) {
			res = true;
		}
		logger.debug(">>FaceYe,shaStr is:" + shaStr + ",signature is:" + signature + ",result is:" + res);
		return res;
	}

	/**
	 * 接收消息
	 * 
	 * @todo
	 * @param msg
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年5月18日
	 */
	private RMessage receive(HttpServletRequest request) {
		InputStream in;
		Account account = null;
		WXBizMsgCrypt pc = null;
		RMessage message = null;
		try {
			Map params = HttpUtil.getRequestParams(request);
			in = request.getInputStream();
			// InputStream sin=this.checkForUtf8BOMAndDiscardIfAny(in);
			reporter.reporter(params);
			String receive = IOUtils.toString(in);
			if (StringUtils.endsWith(receive, "\r\n")) {
				receive = StringUtils.removeEnd(receive, "\r\n");
			}
			if (StringUtils.endsWith(receive, "\n")) {
				receive = StringUtils.removeEnd(receive, "\n");
			}
			if (StringUtils.endsWith(receive, "\r")) {
				receive = StringUtils.removeEnd(receive, "\r");
			}
			logger.debug(">>FaceYe receive xml is:\n1" + receive + "2");
			Long accountId = MapUtils.getLong(params, "accountId");
			account = this.accountService.get(accountId);
			String signature = MapUtils.getString(params, "signature");
			String timestamp = MapUtils.getString(params, "timestamp");
			String nonce = MapUtils.getString(params, "nonce");
			String msg_signature = MapUtils.getString(params, "msg_signature");
			// 是否加密
			boolean isEncrypt = this.isEncrypt(request);
			if (isEncrypt) {
				Object[] extractResults;
				try {
					// extractResults = XMLParse.extract(receive);
					// String encrypt = extractResults[1].toString();
					// String toUserName = extractResults[2].toString();
					// String encrypt = XMLUtil.getEncrypt(receive);
					if (account != null) {
						pc = new WXBizMsgCrypt(account.getToken(), account.getEncodingAesKey(), account.getAppId());
						receive = pc.decryptMsg(msg_signature, timestamp, nonce, receive);
					}
					logger.debug(">>FaceYe --> 解密后的消息:" + receive);
				} catch (AesException e) {
					logger.error(">>FaceYe throws Exception: --->", e);
				}
			}
			message = this.parseXml(receive);
			if (message != null) {
				Msg msg = new Msg();
				try {
					BeanUtils.copyProperties(msg, message);
					msg.setAccount(account);
					this.msgService.save(msg);
				} catch (IllegalAccessException e) {
					logger.error(">>FaceYe throws Exception: --->", e);
				} catch (InvocationTargetException e) {
					logger.error(">>FaceYe throws Exception: --->", e);
				}
			}
		} catch (IOException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
		return message;
	}

	private InputStream checkForUtf8BOMAndDiscardIfAny(InputStream inputStream) throws IOException {
		PushbackInputStream pushbackInputStream = new PushbackInputStream(new BufferedInputStream(inputStream), 3);
		byte[] bom = new byte[3];
		if (pushbackInputStream.read(bom) != -1) {
			if (!(bom[0] == (byte) 0xEF && bom[1] == (byte) 0xBB && bom[2] == (byte) 0xBF)) {
				pushbackInputStream.unread(bom);
			}
		}
		return pushbackInputStream;
	}

	/**
	 * 响应接收到的消息
	 * 
	 * @todo
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年5月28日
	 */
	public String response(HttpServletRequest request) {
		String res = "";
		Map params = HttpUtil.getRequestParams(request);
		ResponseMessage responseMessage = new TextResponseMessage();
		Account account = null;
		WXBizMsgCrypt pc = null;
		Long accountId = MapUtils.getLong(params, "accountId");
		String signature = MapUtils.getString(params, "signature");
		String timestamp = MapUtils.getString(params, "timestamp");
		String nonce = MapUtils.getString(params, "nonce");
		String msg_signature = MapUtils.getString(params, "msg_signature");
		boolean isEncrypt = this.isEncrypt(request);
		account = this.accountService.get(accountId);
		RMessage message = this.receive(request);
		if (message != null) {
			responseMessage = this.buildResponseMessage(account, message);
			res = JaxbMapper.toXml(responseMessage);
			res = XMLUtil.rebuild(res);
		}
		logger.debug(">>FaceYe --> Response xml is:" + res);
		if (isEncrypt) {
			try {
				account = this.accountService.get(accountId);
				pc = new WXBizMsgCrypt(account.getToken(), account.getEncodingAesKey(), account.getAppId());
				logger.debug(">>FaceYe--> message before encrypt :" + res);
				res = pc.encryptMsg(res, responseMessage.getCreateTime().toString(), nonce);
				logger.debug(">>FaceYe --> message after encrypt:" + res);
			} catch (AesException e) {
				logger.error(">>FaceYe throws Exception: --->", e);
			}
		}

		return res;
	}

	/**
	 * 解析消息xml
	 * 
	 * @todo
	 * @param in
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年5月19日
	 */
	private RMessage parseXml(String xml) {
		RMessage message = null;
		logger.debug(">>FaceYe parse xml is:" + xml);
		message = MessageFactory.getFactory().getMessage(xml);
		return message;
	}

	/**
	 * 消息是否加密
	 * 
	 * @todo
	 * @param request
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年5月28日
	 */
	private boolean isEncrypt(HttpServletRequest request) {
		boolean res = false;
		Map params = HttpUtil.getRequestParams(request);
		String encrypt_type = MapUtils.getString(params, "encrypt_type");
		String msg_signature = MapUtils.getString(params, "msg_signature");
		if (StringUtils.isNotEmpty(encrypt_type) && StringUtils.equals(encrypt_type, "aes")) {
			res = true;
		}
		return res;
	}

	/**
	 * 构建回复消息
	 * 
	 * @todo
	 * @param receiveMessage
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年5月28日
	 */
	private ResponseMessage buildResponseMessage(Account account, Object message) {
		logger.debug(">>FaceYe --> Do Build Response Message.-1");
		ResponseContent responseContent = null;
		responseContent = this.responseContentService.getDefaultResponseContent(account);
		if (responseContent == null) {
			logger.debug(">>FaceYe --> Response content is Null.");
		}
		ResponseMessage responseMessage = null;
		if(message ==null){
			logger.debug(">>FaceYe --> message object is null.");
		}
		logger.debug(">>FaceYe --> message class name is:"+message.getClass().getName());
		if (message instanceof TextMessage) {
			// 回复图文消息
			logger.debug(">>FaceYe --> Format ReceiveMessage to TextMessage");
			TextMessage textMessage = (TextMessage) message;
			logger.debug(">>FaceYe --> Receive Text Message,msg is:" + textMessage.getContent());
			logger.debug(">>FaceYe --> Response Rich text message .");
			responseMessage = this.buildRichTextResponseMessage(account, textMessage, responseContent);
		} else if (message instanceof EventMessage) {
			EventMessage eventMessage = (EventMessage) message;
			String event = eventMessage.getEvent();
			logger.debug(">>FaceYe --> Receive event is:" + event);
			if (StringUtils.equals(event, WeixinConstants.EVENT_SUBSCRIBE)) {
				// 回复图文消息
				logger.debug(">>FaceYe --> response subscribe msg.");
				responseMessage = this.buildRichTextResponseMessage(account, eventMessage, responseContent);
			}else if(StringUtils.equals(event, WeixinConstants.EVENT_scancode_waitmsg)){
				logger.debug(">>FaceYe --> Response scancode_waitmsg.");
				responseMessage=this.getUserDefineResponseMessage().build(account, eventMessage);
			}
		} else {

		}
//		String toUserName = receiveMessage.getToUserName();
//		String msgType = receiveMessage.getMsgType();
		
		// 响应消息类型
//		String responseMessageTypeCode = responseContent.getResponseMessageType().getCode();
//		logger.debug(">>FaceYe --> responseMessageTypeCode is :" + responseMessageTypeCode + ",receive msg type:" + receiveMessage.getMsgType());
//		if (receiveMessage.getMsgType().equals(WeixinConstants.MSG_TYPE_TEXT)) {
//
//		} else if (receiveMessage.getMsgType().equals(WeixinConstants.MSG_TYPE_EVENT)) {
//			
//		}
		// 回复文本消息
		// if (StringUtils.equals(responseMessageTypeCode, WeixinConstants.RESPONSE_MSG_TYPE_TEXT)) {
		// responseMessage = this.buildTextResponseMessage(account, receiveMessage, responseContent);
		// } else if (StringUtils.equals(responseMessageTypeCode, WeixinConstants.RESPONSE_MSG_TYPE_RICH_TEXT)) {
		// // 回复图文消息
		// responseMessage = this.buildRichTextResponseMessage(account, receiveMessage, responseContent);
		// }
		return responseMessage;
	}
	
	private UserDefineResponseMessage getUserDefineResponseMessage(){
		UserDefineResponseMessage userDefineResponseMessage=null;
		String defaultMessageBean=BeanContextUtil.getBean(PropertyService.class).get("weixin.default.user.define.response.message.bean");
		if(StringUtils.isNotEmpty(defaultMessageBean) && !StringUtils.contains(defaultMessageBean, "$")){
			userDefineResponseMessage=BeanContextUtil.getBean(defaultMessageBean);
		}else{
			userDefineResponseMessage=BeanContextUtil.getBean("defaultUserDefineResponseMessage");
		}
		return userDefineResponseMessage;
	}

	/**
	 * 回复 文本消息
	 * 
	 * @todo
	 * @param account
	 * @param receiveMessage
	 * @param responseContent
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年5月28日
	 */
	private TextResponseMessage buildTextResponseMessage(Account account, ReceiveMessage receiveMessage, ResponseContent responseContent) {
		TextResponseMessage textResponseMessage = new TextResponseMessage();
		textResponseMessage.setToUserName(receiveMessage.getFromUserName());
		textResponseMessage.setFromUserName(receiveMessage.getToUserName());
		textResponseMessage.setContent(responseContent.getContent());
		textResponseMessage.setCreateTime(System.currentTimeMillis());
		textResponseMessage.setMsgType(WeixinConstants.MSG_TYPE_TEXT);
		return textResponseMessage;
	}

	/**
	 * 回复图文消息
	 * 
	 * @todo
	 * @param account
	 * @param receiveMessage
	 * @param responseContent
	 * @return
	 * @author:@haipenge 联系:haipenge@gmail.com 创建时间:2015年5月28日
	 */
	private RichTextResponseMessage buildRichTextResponseMessage(Account account, RMessage message, ResponseContent responseContent) {
		RichTextResponseMessage richTextMessage = new RichTextResponseMessage();
		Map searchParams = new HashMap();
		searchParams.put("EQ|responseContent.$id", responseContent.getId());
		Page<ResponseContentItem> responseContentItems = this.responseContentItemService.getPage(searchParams, 1, 5);
		richTextMessage.setFromUserName(message.getToUserName());
		richTextMessage.setToUserName(message.getFromUserName());
		richTextMessage.setMsgType(WeixinConstants.RESPONSE_MSG_TYPE_RICH_TEXT);
		richTextMessage.setCreateTime(System.currentTimeMillis());
		if (CollectionUtils.isNotEmpty(responseContentItems.getContent())) {
			List<RichText> richTexts = new ArrayList<RichText>(0);
			for (ResponseContentItem responseContentItem : responseContentItems.getContent()) {
				RichText richText = new RichText();
				richText.setDescription(responseContentItem.getRemark());
				richText.setPicUrl(responseContentItem.getPicUrl());
				richText.setTitle(responseContentItem.getName());
				richText.setUrl(account.getHost()+responseContentItem.getUrl());
				richTexts.add(richText);
				logger.debug(">>FaceYe --> Rich Text name is:" + richText.getTitle());
			}
			richTextMessage.setArticles(richTexts);
		}
		logger.debug(">>FaceYe --> Rich Text Message size:" + richTextMessage.getArticles().size());
		return richTextMessage;
	}
}
