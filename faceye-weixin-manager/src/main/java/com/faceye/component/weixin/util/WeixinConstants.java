package com.faceye.component.weixin.util;

/**
 * 微信常量
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月19日
 */
public class WeixinConstants {
	public static final String WEIXIN_ACCOUNT_SESSION_KEY="WEIXIN_ACCOUNT_SESSION_KEY";
	// 接收消息类型
	// http://mp.weixin.qq.com/wiki/10/79502792eef98d6e0c6e1739da387346.html
	public static final String MSG_TYPE_TEXT = "text";
	public static final String MSG_TYPE_RICH_TEXT="news";
	public static final String MSG_TYPE_IMAGE = "image";
	public static final String MSG_TYPE_VOICE = "voice";
	public static final String MSG_TYPE_VIDEO = "video";
	public static final String MSG_TYPE_SHORT_VIDEO = "shortvideo";
	public static final String MSG_TYPE_LOCATION = "location";
	public static final String MSG_TYPE_LINK = "link";
	public static final String MSG_TYPE_EVENT = "event";

	// 事件
	public static final String EVENT_SUBSCRIBE = "subscribe";
	public static final String EVENT_UN_SUBSCRIBE = "unsubscribe";
	public static final String EVENT_SCAN = "SCAN";
	public static final String EVENT_LOCATION = "LOCATION";
	public static final String EVENT_CLICK = "CLICK";
	public static final String EVENT_VIEW = "VIEW";
	public static final String EVENT_scancode_waitmsg="scancode_waitmsg";
	
	
	//**
	//响应消息类型
	public static final String RESPONSE_MSG_TYPE_TEXT="text";
	public static final String RESPONSE_MSG_TYPE_RICH_TEXT="news";
	
	/**
	 * OAuth2 scope 
	 * scope = "snsapi_userinfo";			 scope="snsapi_base";
	 */
	public static final String OAUTH2_SCOPE_BASE="snsapi_base";
	public static final String OAUTH2_SCOPE_USERINFO="snsapi_userinfo";
	
	/**
	 * JSAPI--公众号支付、
	 * NATIVE--原生扫码支付、
	 * APP--app支付、
	 * WAP--手机浏览器H5支付
	 * 统一下单接口trade_type的传参可参考这里
	 * MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
	 */
	public static final String PAY_TRADE_TYPE_JSAPI="JSAPI";
	public static final String PAY_TRADE_TYPE_NATIVE="NATIVE";
	public static final String PAY_TRADE_TYPE_APP="APP";
	public static final String PAY_TRADE_TYPE_WAP="WAP";
	public static final String PAY_TRADE_TYPE_MICROPAY="MICROPAY";
	
	//点击事件
	public static final String MENU_TYPE_CLICK="click";
	//URL跳转事件
	public static final String MENU_TYPE_VIEW="view";
	
	
	
	
}
