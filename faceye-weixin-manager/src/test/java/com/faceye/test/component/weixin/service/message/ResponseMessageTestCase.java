package com.faceye.test.component.weixin.service.message;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.faceye.component.weixin.service.message.receive.XMLUtil;
import com.faceye.component.weixin.service.message.response.ResponseMessage;
import com.faceye.component.weixin.service.message.response.RichText;
import com.faceye.component.weixin.service.message.response.RichTextResponseMessage;
import com.faceye.component.weixin.service.message.response.TextResponseMessage;
import com.faceye.feature.util.JaxbMapper;


@RunWith(JUnit4.class)
public class ResponseMessageTestCase {
 private Logger logger=LoggerFactory.getLogger(getClass());
 
 @Test
 public void testRichTextResponseMessage() throws Exception{
	 RichTextResponseMessage richTextResponseMessage= buildRichTextResponseMessage();
	 String xml=JaxbMapper.toXml(richTextResponseMessage);
	 logger.debug(xml);
	 Assert.isTrue(StringUtils.isNotEmpty(xml));
 }
 @Test
 public void testTextResponseMessage() throws Exception{
	 ResponseMessage textResponseMessage=new TextResponseMessage();
	 ((TextResponseMessage)textResponseMessage).setContent("tst");
	 textResponseMessage.setCreateTime(1L);
	 textResponseMessage.setFromUserName("from");
	 textResponseMessage.setMsgType("text");
	 textResponseMessage.setToUserName("to");
	 String xml=JaxbMapper.toXml(textResponseMessage);
	 logger.debug("XML Before is:\n"+xml);
	 xml=XMLUtil.rebuild(xml);
	 logger.debug("1\n"+xml+"--1");
	 Assert.isTrue(StringUtils.isNotEmpty(xml));
 }
 
 private RichTextResponseMessage buildRichTextResponseMessage(){
	 RichTextResponseMessage richTextResponseMessage =new RichTextResponseMessage();
	 richTextResponseMessage.setCreateTime(1L);
	 richTextResponseMessage.setFromUserName("from");
	 richTextResponseMessage.setToUserName("to");
	 richTextResponseMessage.setMsgType("news");
	 for(int i=0;i<5;i++){
		 RichText richText=new RichText();
		 richText.setDescription(""+i);
		 richText.setTitle(""+i);
		 richText.setUrl("http://s0jc.com"+i);
		 richText.setPicUrl(""+i);
		 richTextResponseMessage.getArticles().add(richText);
	 }
	 return richTextResponseMessage;
 }
}
