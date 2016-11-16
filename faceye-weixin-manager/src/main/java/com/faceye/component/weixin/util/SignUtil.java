package com.faceye.component.weixin.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.faceye.feature.util.RandUtil;
import com.faceye.feature.util.http.DecriptUtils;


/**
 *  
 * 微信支付 数据签名工具类
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月8日
 */
public class SignUtil {

	private Logger logger = LoggerFactory.getLogger(SignUtil.class);

	private static class SignUtilHolder {
		private static SignUtil INSTANCE = new SignUtil();
	}

	synchronized static public SignUtil getInstance() {
		return SignUtilHolder.INSTANCE;
	}

	/**
	 *数据签名
	 * @todo
	 * @param keyAndValues
	 * @param apiKey --> API密钥的值
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月7日
	 */
	public String sign(String keyAndValues, String key) {
		String sign = "";
		String temp = keyAndValues + "&key=" + key;
		sign = DecriptUtils.MD5(temp).toUpperCase();
		logger.debug(">>FaceYe -->Sign Result is:" + sign + ",source is:" + temp);
		return sign;
	}

	/**
	 * 对map参数进行签名
	 * @todo
	 * @param params
	 * @param key
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月8日
	 */
	public String sign(Map params, String key) {
		logger.debug(">>FaceYe start to sign,key is:" + key);
		String source = sortParams(params);
		logger.debug(">>FaceYe Source(待签名) :" + source + ",key is:" + key);
		return sign(source, key);
	}

	/**
	 * 特别注意以下重要规则：
	 *◆　参数名ASCII码从小到大排序（字典序）；
	 *◆　如果参数的值为空不参与签名；
	 *◆　参数名区分大小写；
	 *◆　验证调用返回或微信主动通知签名时，传送的sign参数不参与签名，将生成的签名与该sign值作校验。
	 *◆　微信接口可能增加字段，验证签名时必须支持增加的扩展字段
	 * @todo
	 * @param params
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月7日
	 */
	public String sortParams(Map params) {
		String res = "";
		List<String> keys = new ArrayList();
		if (MapUtils.isNotEmpty(params)) {
			Iterator it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next().toString();
				Object value = params.get(key);
				if (!StringUtils.equals(key, "sign") && value != null && StringUtils.isNotEmpty(value.toString())) {
					keys.add(key);
				}
			}
		}
		Collections.sort(keys);
		StringBuilder sb = new StringBuilder();
		for (String key : keys) {
			String value = params.get(key).toString();
			sb.append(key + "=" + value);
			sb.append("&");
		}
		sb.deleteCharAt(sb.lastIndexOf("&"));
		res = sb.toString();
		logger.debug(">>FaceYe debug --> sorted params is:" + res);
		return res;
	}

	/**
	 * 验签
	 * @todo
	 * @param params
	 * @param key
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月8日
	 */
	public boolean checkSignature(Map params, String key) {
		boolean res = false;
		String sign = this.sign(params, key);
		String checkSign = MapUtils.getString(params, "sign");
		res = StringUtils.equals(sign, checkSign);
		return res;
	}

	/**
	 * 生成微信随机字符串
	 * @todo
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年11月8日
	 */
	public String randNonceStr() {
		String randStr = RandUtil.randString();
		if (StringUtils.length(randStr) > 32) {
			randStr = StringUtils.substring(randStr, 0, 31);
		}
		return randStr;
	}
}
