package com.faceye.component.weixin.service.message.receive;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XMLUtil {
	private static Logger logger = LoggerFactory.getLogger(XMLUtil.class);

	public static String getEncrypt(String xml) {
		String encrypt = "";
		try {
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			Element encryptElement = root.element("Encrypt");
			encrypt = encryptElement.getText();
		} catch (DocumentException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
		logger.debug(">>FaceYe --> Encrypt message is:" + encrypt);
		return encrypt;
	}

	/**
	 * 
	 * @todo
	 * @param xml
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年6月4日
	 */
	public static String rebuild(String xml) {
		if (StringUtils.isNotEmpty(xml)) {
			String regexp = "<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>\n";
			xml = xml.replaceAll(regexp, "");
			regexp = "<xml [^>]+>";
			xml = xml.replaceAll(regexp, "<xml>");
		}
		return xml;
	}
}
