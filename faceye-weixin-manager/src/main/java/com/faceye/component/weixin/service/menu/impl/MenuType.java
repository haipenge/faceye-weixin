package com.faceye.component.weixin.service.menu.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单类型
 * 
 * @author haipenge
 *
 */
public  class MenuType {
	private static List<Type> TYPES=null;
	
	private static MenuType INSTANCE=null;
	
	public static MenuType getInstance(){
		if(INSTANCE==null){
			INSTANCE=new MenuType();
		}
		return INSTANCE;
	}
	private MenuType(){
		
	}
	
	public  List<Type> getTypes() {
		List<Type> types = new ArrayList<Type>();
		
		Type click = new Type("click","点击推事件");
		types.add(click);
		Type view=new Type("view","跳转URL");
		types.add(view);
		Type scancode_push=new Type("scancode_push","扫码推事件");
		types.add(scancode_push);
		Type scancode_waitmsg=new Type("scancode_waitmsg","扫码推事件且弹出“消息接收中”提示框");
		types.add(scancode_waitmsg);
		Type pic_sysphoto=new Type("pic_sysphoto","弹出系统拍照发图");
		types.add(pic_sysphoto);
		Type pic_photo_or_album=new Type("pic_photo_or_album","弹出拍照或者相册发图");
		types.add(pic_photo_or_album);
		Type pic_weixin=new Type("pic_weixin","弹出微信相册发图器");
		types.add(pic_weixin);
		Type location_select=new Type("location_select","弹出地理位置选择器");
		types.add(location_select);
		Type media_id=new Type("media_id","下发消息（除文本消息）");
		types.add(media_id);
		Type view_limited =new Type("view_limited","跳转图文消息URL");
		types.add(view_limited);
		return types;
	}
	

	public class Type {
		
		public Type(String key, String name) {
			this.key = key;
			this.name = name;
		}

		private String key = "";
		private String name = "";

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
