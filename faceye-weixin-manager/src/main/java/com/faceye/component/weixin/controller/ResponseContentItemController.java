package com.faceye.component.weixin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.collections.MapUtils;
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
import com.faceye.component.weixin.entity.ResponseContentItem;
import com.faceye.component.weixin.service.ResponseContentItemService;
import com.faceye.component.weixin.service.ResponseContentService;
import com.faceye.component.weixin.util.WeixinConstants;
import com.faceye.feature.controller.BaseController;
import com.faceye.feature.util.AjaxResult;
import com.faceye.feature.util.http.HttpUtil;

/**
 * 模块:weixin<br>
 * 实体:ResponseContentItem<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年12月10日<br>
 */
@Controller
@Scope("prototype")
@RequestMapping("/weixin/responseContentItem")
public class ResponseContentItemController extends BaseController<ResponseContentItem, Long, ResponseContentItemService> {
	@Autowired
	private ResponseContentService responseContentService = null;

	@Autowired
	public ResponseContentItemController(ResponseContentItemService service) {
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
		Map searchParams = HttpUtil.getRequestParams(request);
		Page<ResponseContentItem> page = this.service.getPage(searchParams, getPage(searchParams), getSize(searchParams));
		model.addAttribute("page", page);
		Long responseContentId = MapUtils.getLong(searchParams, "EQ|responseContent.$id");
		if (responseContentId != null) {
			ResponseContent responseContent = this.responseContentService.get(responseContentId);
			model.addAttribute("responseContent", responseContent);
		}
		resetSearchParams(searchParams);
		model.addAttribute("searchParams", searchParams);
		return "weixin.responseContentItem.manager";
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
			ResponseContentItem entity = this.service.get(id);
			model.addAttribute("responseContentItem", entity);
		}
		return "weixin.responseContentItem.update";
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
	public String input(ResponseContentItem responseContentItem, Model model, HttpServletRequest request) {
		beforeInput(model, request);
		return "weixin.responseContentItem.update";
	}

	/**
	 * 数据保存<br>
	 */
	@RequestMapping("/save")
	public String save(@Valid ResponseContentItem responseContentItem, BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			beforeInput(model, request);
			return "weixin.responseContentItem.update";
		} else {
			this.beforeSave(responseContentItem, request);
			this.service.save(responseContentItem);
			this.afterSave(responseContentItem, request);
			return "redirect:/weixin/responseContentItem/home?EQ|responseContent.$id="+responseContentItem.getResponseContent().getId();
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
		ResponseContentItem responseContentItem=null;
		String suffix="";
		if (id != null) {
			responseContentItem=this.service.get(id);
			suffix="EQ|responseContent.$id="+responseContentItem.getResponseContent().getId();
			this.service.remove(responseContentItem);
		}
		return "redirect:/weixin/responseContentItem/home?"+suffix;
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
	public String detail(@PathVariable Long id, Model model) {
		if (id != null) {
			ResponseContentItem entity = this.service.get(id);
			model.addAttribute("responseContentItem", entity);
		}
		return "weixin.responseContentItem.detail";
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

		Account account = (Account) request.getSession().getAttribute(WeixinConstants.WEIXIN_ACCOUNT_SESSION_KEY);
		if (account != null) {
			Map searchParams = new HashMap();
			searchParams.put("EQ|account.$id", account.getId());
			List<ResponseContent> responseContents = this.responseContentService.getPage(searchParams, 1, 0).getContent();
			model.addAttribute("responseContents", responseContents);
		}
	}

	/**
	 *
	 *保存数据前的回调函数
	 */
	protected void beforeSave(ResponseContentItem responseContentItem, HttpServletRequest request) {

	}

	/**
	 *
	 *保存数据后的回调函数
	 */
	protected void afterSave(ResponseContentItem responseContentItem, HttpServletRequest request) {

	}

}
