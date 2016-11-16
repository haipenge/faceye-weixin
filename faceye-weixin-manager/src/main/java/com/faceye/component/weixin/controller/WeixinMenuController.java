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
import com.faceye.component.weixin.entity.WeixinMenu;
import com.faceye.component.weixin.service.AccountService;
import com.faceye.component.weixin.service.WeixinMenuService;
import com.faceye.component.weixin.service.menu.EWeixinMenuService;
import com.faceye.component.weixin.service.menu.impl.MenuType;
import com.faceye.component.weixin.service.menu.impl.MenuType.Type;
import com.faceye.component.weixin.service.message.response.BaseResponse;
import com.faceye.feature.controller.BaseController;
import com.faceye.feature.util.AjaxResult;
import com.faceye.feature.util.http.HttpUtil;

/**
 * 模块:weixin<br>
 * 实体:WeixinMenu<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年12月10日<br>
 */
@Controller
@Scope("prototype")
@RequestMapping("/weixin/weixinMenu")
public class WeixinMenuController extends BaseController<WeixinMenu, Long, WeixinMenuService> {

	@Autowired
	private AccountService accountService=null;
	
	@Autowired
	private EWeixinMenuService eweixinMenuService=null;
	@Autowired
	public WeixinMenuController(WeixinMenuService service) {
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
		Map searchParams=HttpUtil.getRequestParams(request);
		Long accountId=MapUtils.getLong(searchParams, "EQ|account.$id");
		Account account=this.accountService.get(accountId);
		model.addAttribute("account", account);
		Page<WeixinMenu> page = this.service.getPage(searchParams, getPage(searchParams), getSize(searchParams));
		model.addAttribute("page", page);
		resetSearchParams(searchParams);
		model.addAttribute("searchParams", searchParams);
		return "weixin.weixinMenu.manager";
	}

	/**
	 * 转向编辑或新增页面<br>
	 * 
	 * @todo<br>
	 * @return<br>
	 * @author:@haipenge haipenge@gmail.com 2014年5月24日<br>
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model,HttpServletRequest request) {
		if(id!=null){
			
			WeixinMenu entity=this.service.get(id);
			beforeInput(model,request,entity);
			model.addAttribute("weixinMenu", entity);
		}
		return "weixin.weixinMenu.update";
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
	@RequestMapping(value="/input")
	public String input(WeixinMenu weixinMenu,Model model,HttpServletRequest request){
		beforeInput(model,request,weixinMenu);
		
		return "weixin.weixinMenu.update";
	}
	
	
    

	/**
	 * 数据保存<br>
	 */
	@RequestMapping("/save")
	public String save(@Valid WeixinMenu weixinMenu,BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model,HttpServletRequest request) {
		if(bindingResult.hasErrors()){
			beforeInput(model,request,weixinMenu);
		    Long accountId=weixinMenu.getAccount().getId();
			model.addAttribute("account", this.accountService.get(accountId));
			return "weixin.weixinMenu.update";
		}else{
		   this.beforeSave(weixinMenu,request);
		   this.service.save(weixinMenu);
		   this.afterSave(weixinMenu,request);
		   return "redirect:/weixin/weixinMenu/home?EQ|account.$id="+weixinMenu.getAccount().getId();
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
		if(id!=null){
			this.service.remove(id);
		}
		return "redirect:/weixin/weixinMenu/home";
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
	public String remove(@RequestParam(required=true) String  ids, RedirectAttributes redirectAttributes) {
		if(StringUtils.isNotEmpty(ids)){
			String [] idArray=ids.split(",");
			for(String id:idArray){
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
	public String detail(@PathVariable Long id,Model model){
		if(id!=null){
			WeixinMenu entity=this.service.get(id);
			model.addAttribute("weixinMenu", entity);
		}
		return "weixin.weixinMenu.detail";
	}
	
	/**
	 * 生成菜单
	 * @param request
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月12日 下午6:54:29
	 */
	@RequestMapping("/generate")
	@ResponseBody
	public BaseResponse generate(HttpServletRequest request){
		BaseResponse response=null;
		Map params=HttpUtil.getRequestParams(request);
		Long accountId=MapUtils.getLong(params, "accountId");
		Account account=this.accountService.get(accountId);
		//1.Delete all Weixin Menu
		this.eweixinMenuService.deleteWeixinMenu(account);
		//2.Re Create Weixin Menu
		response=this.eweixinMenuService.createWeixinMenu(account);
		return response;
	}
	/**
	 * 删除微信菜单
	 * @param request
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月13日 下午2:56:45
	 */
	@RequestMapping("/deleteWeixinMenu")
	@ResponseBody
	public BaseResponse deleteWeixinMenu(HttpServletRequest request){
		BaseResponse response=null;
		Map params=HttpUtil.getRequestParams(request);
		Long accountId=MapUtils.getLong(params, "accountId");
		Account account=this.accountService.get(accountId);
		//1.Delete all Weixin Menu
		this.eweixinMenuService.deleteWeixinMenu(account);
		return response;
	}
	/**
	 * 设置微信菜单排序值
	 * @param request
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年5月24日 上午9:17:40
	 */
	@RequestMapping("/resetWeixinMenuOrderIndex")
	@ResponseBody
	public String resetWeixinMenuOrderIndex(HttpServletRequest request){
		Map params=HttpUtil.getRequestParams(request);
		Long id=MapUtils.getLong(params, "id");//weixinMenu.id
		Integer orderIndex=MapUtils.getInteger(params, "orderIndex");
		WeixinMenu weixinMenu=this.service.get(id);
		weixinMenu.setOrderIndex(orderIndex);
		this.service.save(weixinMenu);
		return AjaxResult.getInstance().buildDefaultResult(true);
	}
	
	
	///////////////////////////////////////////////以下为回调函数////////////////////////////////////////////
	/**
	 * 新增、编辑页面的前置逻辑处理<br>
	 * @todo<br>
	 * @param model<br>
	 * @param request<br>
	 * @author:@haipenge<br>
	 * haipenge@gmail.com<br>
	 * 2015年4月5日<br>
	 */
	protected void beforeInput(Model model,HttpServletRequest request,WeixinMenu weixinMenu){
		List<Type> types=MenuType.getInstance().getTypes();
		model.addAttribute("types", types);
		//取得一级菜单
		Map params=HttpUtil.getRequestParams(request);
		Long accountId=MapUtils.getLong(params, "accountId");
		Account account=this.accountService.get(accountId);
		model.addAttribute("account",account);
		weixinMenu.setAccount(account);
		List<WeixinMenu> roots=this.service.getWeixinMenusByAccountAndWeixinMenuIsNull(account);
		model.addAttribute("roots", roots);
	}
	/**
	 *
	 *保存数据前的回调函数
	 */
	protected void beforeSave(WeixinMenu weixinMenu,HttpServletRequest request){
		
	}
	
	/**
	 *
	 *保存数据后的回调函数
	 */
	protected void afterSave(WeixinMenu weixinMenu,HttpServletRequest request){
		
	}


}
