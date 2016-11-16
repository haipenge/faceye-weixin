package com.faceye.component.weixin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.faceye.component.security.entity.User;
import com.faceye.component.security.service.UserService;
import com.faceye.component.security.util.SecurityUtil;
import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.component.weixin.service.api.MsgApi;
import com.faceye.component.weixin.service.message.response.AccessToken;
import com.faceye.component.weixin.util.WeixinConstants;
import com.faceye.feature.controller.BaseController;
import com.faceye.feature.util.AjaxResult;
import com.faceye.feature.util.http.HttpUtil;

/**
 * 模块:weixin<br>
 * 实体:Account<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年12月10日<br>
 */
@Controller
@Scope("prototype")
@RequestMapping("/weixin/account")
public class AccountController extends BaseController<Account, Long, AccountService> {
	@Autowired
	private UserService userService = null;
	@Autowired
	private MsgApi msgApi = null;

	@Autowired
	public AccountController(AccountService service) {
		super(service);
	}

	/**
	 * 首页<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日<br>
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {
		User user = this.userService.getUserByUsername(SecurityUtil.getCurrentUserName());
		if (user != null) {
			Map searchParams = HttpUtil.getRequestParams(request);
			searchParams.put("EQ|user.$id", user.getId());
			Page<Account> page = this.service.getPage(searchParams, getPage(searchParams), getSize(searchParams));
			model.addAttribute("page", page);
			resetSearchParams(searchParams);
			model.addAttribute("searchParams", searchParams);
		}
		return "weixin.account.manager";
	}

	/**
	 * 转向编辑或新增页面<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日<br>
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
		if (id != null) {
			beforeInput(model, request);
			Account entity = this.service.get(id);
			model.addAttribute("account", entity);
		}
		return "weixin.account.update";
	}

	/**
	 * 转向新增页面<br>
	 * @todo<br>
	 * @param model<br>
	 * @return<br>
	 * @author:@haipenge<br>
	 * haipenge@gmail.com<br>
	 * 2014年5月27日<br>
	 */
	@RequestMapping(value = "/input")
	public String input(Account account, Model model, HttpServletRequest request) {
		beforeInput(model, request);
		return "weixin.account.update";
	}

	/**
	 * 数据保存<br>
	 */
	@RequestMapping("/save")
	public String save(@Valid Account account, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			beforeInput(model, request);
			return "weixin.account.update";
		} else {
			this.beforeSave(account, request);
			this.service.save(account);
			this.afterSave(account, request);
			return "redirect:/weixin/account/home";
		}
	}

	/**
	 * 数据删除<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日<br>
	 */
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		if (id != null) {
			this.service.remove(id);
		}
		return "redirect:/weixin/account/home";
	}

	/**
	 * 数据批量删除<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日<br>
	 */
	@RequestMapping("/multiRemove")
	@ResponseBody
	public String remove(@RequestParam(required = true) String ids, RedirectAttributes redirectAttributes) {
		if (StringUtils.isNotEmpty(ids)) {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				this.service.remove(Long.parseLong(id));
			}
		}
		return AjaxResult.getInstance().buildDefaultResult(true);
	}

	/**
	 * 取得数据明细<br>
	 * @todo<br>
	 * @param id<br>
	 * @param model<br>
	 * @return<br>
	 * @author:@haipenge<br>
	 * haipenge@gmail.com<br>
	 * 2014年5月26日<br>
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model, HttpServletRequest request) {
		if (id != null) {
			Account account = this.service.get(id);
			request.getSession().setAttribute(WeixinConstants.WEIXIN_ACCOUNT_SESSION_KEY, account);
			model.addAttribute("account", account);
		}
		return "weixin.account.detail";
	}

	/**
	 * 消息有效性验证
	 * @todo
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月18日
	 */
	@RequestMapping("/checkSignature")
	@ResponseBody
	public String checkSignature(@RequestParam(required = true) Long accountId, @RequestParam(required = true) String signature,
			@RequestParam(required = true) String timestamp, @RequestParam(required = true) String nonce,
			@RequestParam(required = true) String echostr) {
		boolean isSignature = this.msgApi.checkSignature(accountId, signature, timestamp, nonce);
		if (isSignature) {
			return echostr;
		}
		return "";
	}

	/**
	 * 刷新access token
	 * @todo
	 * @return
	 * @param id ->Account:id
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月19日
	 */
	@RequestMapping("/refreshAccessToken")
	@ResponseBody
	public AccessToken refreshAccessToken(@RequestParam(required = true) Long id) {
		AccessToken accessToken = this.msgApi.getAccessToken(id, true);
		return accessToken;
	}

	// /////////////////////////////////////////////以下为回调函数////////////////////////////////////////////
	/**
	 * 新增、编辑页面的前置逻辑处理<br>
	 * @todo<br>
	 * @param model<br>
	 * @param request<br>
	 * @author:@haipenge<br>
	 * haipenge@gmail.com<br>
	 * 2015年4月5日<br>
	 */
	protected void beforeInput(Model model, HttpServletRequest request) {

	}

	/**
	 *
	 *保存数据前的回调函数
	 */
	protected void beforeSave(Account account, HttpServletRequest request) {
		User user = this.userService.getUserByUsername(SecurityUtil.getCurrentUserName());
		if (account != null && user != null) {
			account.setUser(user);
		}
	}

	/**
	 * 保存后的回调函数
	 * @todo
	 * @param account
	 * @param request
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年5月19日
	 */
	protected void afterSave(Account account, HttpServletRequest request) {
		if (account != null) {
			this.msgApi.getAccessToken(account.getId(), true);
		}
	}

}
