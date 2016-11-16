package com.faceye.component.weixin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.faceye.component.security.web.service.UserService;
import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.WeixinUser;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.component.weixin.service.api.MsgApi;
import com.faceye.component.weixin.service.oauth2.OAuth2Service;
import com.faceye.component.weixin.service.pay.WeixinPayService;
import com.faceye.component.weixin.service.qrcode.QRCodeService;
import com.faceye.feature.service.Reporter;
import com.faceye.feature.util.http.HttpUtil;

/**
 * 微信API接口相关
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月28日
 */
@Controller
@RequestMapping("/weixin/api")
@Scope("prototype")
public class ApiController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MsgApi msgApi = null;
	@Autowired
	private Reporter reporter = null;
	@Autowired
	private OAuth2Service oauth2Service = null;

	@Autowired
	private WeixinPayService weixinPayService = null;
	@Autowired
	private QRCodeService qrCodeService = null;
	@Autowired
	private AccountService accountService = null;
	@Autowired
	private UserService userService = null;

	/**
	 * api 接入验证
	 * @todo
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月19日
	 */
	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String checkSignature(@RequestParam(required = true) Long accountId, @RequestParam(required = true) String signature,
			@RequestParam(required = true) String timestamp, @RequestParam(required = true) String nonce,
			@RequestParam(required = true) String echostr) {
		String res = "";
		logger.debug(">>FaceYe --> Start to check signature now.");
		boolean isSignature = this.msgApi.checkSignature(accountId, signature, timestamp, nonce);
		if (isSignature) {
			return echostr;
		}
		return res;
	}

	/**
	 * 接收消息
	 * @todo
	 * @param accountId
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月19日
	 */
	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	// @ResponseBody
	public void receive(HttpServletRequest request, HttpServletResponse response) {
		// @RequestParam Long accountId,
		// @RequestParam(required = true) String signature, @RequestParam(required = true) String timestamp,
		// @RequestParam(required = true) String nonce
		String res = "-sk";
		Map params = HttpUtil.getRequestParams(request);
		Long accountId = MapUtils.getLong(params, "accountId");
		String signature = MapUtils.getString(params, "signature");
		String timestamp = MapUtils.getString(params, "timestamp");
		String nonce = MapUtils.getString(params, "nonce");
		reporter.reporter(params);
		logger.debug(">>FaceYe ->> Start to receive msg now.");
		boolean isSignature = this.msgApi.checkSignature(accountId, signature, timestamp, nonce);
		if (isSignature) {
			// this.msgApi.receive(request);
			res = this.msgApi.response(request);
		}
		response.setContentType("application/xml");
		try {
			response.getWriter().write(res);
		} catch (IOException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
		// Json.print(response, res);
		// return res;
	}

	/**
	 * 引导用户至授权页面
	 * @todo
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年9月21日
	 */
	@RequestMapping("/toOAuth2")
	public String toOAuth2(Model model, HttpServletRequest request) {
		// #测试号：可体验所有高级接口,包含支付接口
		// #appid:wx78163efe931761c8
		// #appsecret:aab309a8d46f09200111f47cd783af52
		Map params = HttpUtil.getRequestParams(request);
		Long accountId = MapUtils.getLong(params, "accountId");
		Account account = this.accountService.get(accountId);
		String appId = account.getAppId();
		String oauth2Url = this.oauth2Service.getOAuth2Url(appId, "http://wx.faceye.com/weixin/api/oauth2?appId=" + appId, "", true);
		model.addAttribute("oauth2Url", oauth2Url);
		return "/component/weixin/oauth2/user_oauth2_1";
	}

	/**
	 * 网页auth2 用户授权
	 * @todo
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月3日
	 */
	@RequestMapping("/oauth2")
	public String oauth2(@RequestParam String code, @RequestParam String state, @RequestParam String appId, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		logger.debug(">>FaceYe -->start weixi oauth2 -----------------now,code is:" + code + ",state is:" + state + ",appid is:" + appId);

		WeixinUser weixinUser = this.oauth2Service.oauth2(appId, code);
		if (weixinUser != null) {
			logger.debug(">>FaceYe --> weixin user opeid is:" + weixinUser.getOpenid());
			this.userService.weixinOAuth2AndAutoLogin(request, response, weixinUser.getOpenid());
			model.addAttribute("weixinUser", weixinUser);
		} else {
			logger.debug(">>FaceYe --> Have not got weixinUser.");
		}
		logger.debug(">>FaceYe Code is:" + code + ",state is:" + state);
		return "/component/weixin/oauth2/user_oauth2_2";
	}

	/**
	 * 生成支付用二维码
	 * @todo
	 * @param productOrOrderId -> 产品或订单ID
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月9日
	 */
	@RequestMapping("/generatePayQRCode")
	public void generatePayQRCode(@RequestParam(required = true) String productOrOrderId, @RequestParam(required = true) String appid,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String source = this.weixinPayService.generateQRCodeStr(appid, productOrOrderId);
			ServletOutputStream op = response.getOutputStream();
			response.setContentType("image/jpg");
			this.qrCodeService.write2Stream(source, 300, 300, op);
			op.flush();
			op.close();
		} catch (IOException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
	}

	/**
	 * 生成任意二维码，含支付二维码
	 * @todo
	 * @param productOrOrderId
	 * @param appid
	 * @param request
	 * @param response
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年9月25日
	 */
	@RequestMapping("/generateQRCode")
	public void generateQRCode(@RequestParam(required = true) String source, HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletOutputStream op = response.getOutputStream();
			response.setContentType("image/jpg");
			this.qrCodeService.write2Stream(source, 300, 300, op);
			op.flush();
			op.close();
		} catch (IOException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
	}

	/**
	 * 扫码支付的回调方法 -->模式1
	 * @todo
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年9月25日
	 */
	public String receiveScanPayReCall(@RequestParam(required = true) String appid, @RequestParam(required = true) String openid,
			@RequestParam(required = true) String mch_id, @RequestParam(required = true) String is_subscribe,
			@RequestParam(required = true) String nonce_str, @RequestParam(required = true) String product_id,
			@RequestParam(required = true) String sign) {

		return "";
	}

	/**
	 * 扫码支付回调接口
	 * @todo
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月8日
	 */
	@RequestMapping("/receivePayReCall")
	public void receivePayReCall(HttpServletRequest request, HttpServletResponse response) {
		BufferedReader in = null;
		String inputLine = "";
		StringBuilder receiveData = new StringBuilder();
		try {
			in = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			while ((inputLine = in.readLine()) != null) {
				receiveData.append(inputLine);
			}
			// 进入扫码支付
			this.weixinPayService.scanPay(receiveData.toString());
			// Map params=XmlParseUtil.toMap(receiveData.toString());
		} catch (UnsupportedEncodingException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		} catch (IOException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error(">>FaceYe throws Exception: --->", e);
				}
			}
		}
	}
}
