package com.faceye.component.weixin.service.menu.request;

import java.util.ArrayList;
import java.util.List;

/**
 * 点击与URL跳转Request 对像
 * 
 * @author haipenge
 *
 */
public class MenuRequest {
	private List<Button> button = new ArrayList<Button>();

	public List<Button> getButton() {
		return button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}

}
