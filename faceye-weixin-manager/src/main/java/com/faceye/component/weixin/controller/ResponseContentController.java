package com.faceye.component.weixin.controller;

import java.util.List;
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

import com.faceye.component.weixin.entity.Account;
import com.faceye.component.weixin.entity.ResponseContent;
import com.faceye.component.weixin.entity.ResponseMessageType;
import com.faceye.component.weixin.entity.ResponseType;
import com.faceye.component.weixin.service.ResponseContentService;
import com.faceye.component.weixin.service.ResponseMessageTypeService;
import com.faceye.component.weixin.service.ResponseTypeService;
import com.faceye.component.weixin.util.WeixinConstants;
import com.faceye.feature.controller.BaseController;
import com.faceye.feature.util.AjaxResult;
import com.faceye.feature.util.http.HttpUtil;

/**
 * 模块:weixin<br>
 * 实体:ResponseContent<br>
 * 
 * @author @haipenge <br>
 *         haipenge@gmail.com<br>
 *         Create Date:2014年12月10日<br>
 */
@Controller
@Scope("prototype")
@RequestMapping("/weixin/responseContent")
public class ResponseContentController extends BaseController<ResponseContent, Long, ResponseContentService> {

	@Autowired
	private ResponseTypeService responseTypeService = null;
	@Autowired
	private ResponseMessageTypeService responseMessageTypeService = null;

	@Autowired
	public ResponseContentController(ResponseContentService service) {
		super(service);
	}

	/**
	 * 首页<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * 
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日<br>
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {
		// Account account = (Account) request.getSession().getAttribute(WeixinConstants.WEIXIN_ACCOUNT_SESSION_KEY);
		// if (account != null) {
		Map searchParams = HttpUtil.getRequestParams(request);
		// searchParams.put("EQ|account.$id", account.getId());
		Page<ResponseContent> page = this.service.getPage(searchParams, getPage(searchParams), getSize(searchParams));
		model.addAttribute("page", page);
		List<ResponseType> responseTypes = this.responseTypeService.getAll();
		model.addAttribute("responseTypes", responseTypes);
		resetSearchParams(searchParams);
		model.addAttribute("searchParams", searchParams);
		// }
		return "weixin.responseContent.manager";
	}

	/**
	 * 转向编辑或新增页面<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * 
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日<br>
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
		if (id != null) {
			beforeInput(model, request);
			ResponseContent entity = this.service.get(id);
			model.addAttribute("responseContent", entity);
		}
		return "weixin.responseContent.update";
	}

	/**
	 * 转向新增页面<br>
	 * @todo<br>
	 * 
	 * @param model<br>
	 * @return<br>
	 * @author:@haipenge<br>
	 * 						haipenge@gmail.com<br>
	 *                       2014年5月27日<br>
	 */
	@RequestMapping(value = "/input")
	public String input(ResponseContent responseContent, Model model, HttpServletRequest request) {
		beforeInput(model, request);
		return "weixin.responseContent.update";
	}

	/**
	 * 数据保存<br>
	 */
	@RequestMapping("/save")
	public String save(@Valid ResponseContent responseContent, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			beforeInput(model, request);
			return "weixin.responseContent.update";
		} else {
			this.beforeSave(responseContent, request);
			this.service.save(responseContent);
			this.afterSave(responseContent, request);
			return "redirect:/weixin/responseContent/home";
		}
	}

	/**
	 * 数据删除<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * 
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日<br>
	 */
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		if (id != null) {
			this.service.remove(id);
		}
		return "redirect:/weixin/responseContent/home";
	}

	/**
	 * 数据批量删除<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * 
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
	 * 
	 * @param id<br>
	 * @param model<br>
	 * @return<br>
	 * @author:@haipenge<br>
	 * 						haipenge@gmail.com<br>
	 *                       2014年5月26日<br>
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		if (id != null) {
			ResponseContent entity = this.service.get(id);
			model.addAttribute("responseContent", entity);
		}
		return "weixin.responseContent.detail";
	}

	// /////////////////////////////////////////////以下为回调函数////////////////////////////////////////////
	/**
	 * 新增、编辑页面的前置逻辑处理<br>
	 * @todo<br>
	 * 
	 * @param model<br>
	 * @param request<br>
	 * @author:@haipenge<br>
	 * 						haipenge@gmail.com<br>
	 *                       2015年4月5日<br>
	 */
	protected void beforeInput(Model model, HttpServletRequest request) {
		List<ResponseType> responseTypes = this.responseTypeService.getAll();
		model.addAttribute("responseTypes", responseTypes);
		List<ResponseMessageType> responseMessageTypes = this.responseMessageTypeService.getAll();
		model.addAttribute("responseMessageTypes", responseMessageTypes);
	}

	/**
	 *
	 * 保存数据前的回调函数
	 */
	protected void beforeSave(ResponseContent responseContent, HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute(WeixinConstants.WEIXIN_ACCOUNT_SESSION_KEY);
		if (account != null) {
			responseContent.setAccount(account);
		}
	}

	/**
	 *
	 * 保存数据后的回调函数
	 */
	protected void afterSave(ResponseContent responseContent, HttpServletRequest request) {

	}

}
