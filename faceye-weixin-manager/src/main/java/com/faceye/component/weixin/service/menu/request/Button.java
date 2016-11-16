package com.faceye.component.weixin.service.menu.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) 
@JsonInclude(Include.NON_EMPTY) 
public class Button {

	private String type="";
	private String name="";
	private String key="";
	private String url="";
	@JsonProperty("media_id")
	private String mediaId="";
	@JsonProperty("sub_button")
	private List<Button> subButtons=new ArrayList<Button>();
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Button> getSubButtons() {
		return subButtons;
	}
	public void setSubButtons(List<Button> subButtons) {
		this.subButtons = subButtons;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	
}
