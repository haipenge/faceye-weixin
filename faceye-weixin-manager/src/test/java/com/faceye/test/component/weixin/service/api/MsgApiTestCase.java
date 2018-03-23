package com.faceye.test.component.weixin.service.api;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.faceye.component.weixin.service.api.MsgApi;
import com.faceye.test.feature.service.BaseServiceTestCase;

public class MsgApiTestCase extends BaseServiceTestCase {
	@Autowired
	MsgApi msgApi = null;
	String path="";
	@Before
	public void set() throws Exception{
		path="/work/Work/FeatureWorkSpace/feature/faceye-weixin/faceye-weixin-manager/src/test/msg.xml";
	}
	@Test
	public void testParseXml() throws Exception{
		byte buffer[] =new byte[1024];
		InputStream input=new FileInputStream(path);
//		ReceiveMessage receiveMsg=this.msgApi.parseXml(input);
//		Assert.assertTrue(receiveMsg!=null &&StringUtils.isNotEmpty(((TextMessage)receiveMsg).getContent()));
	}
}
