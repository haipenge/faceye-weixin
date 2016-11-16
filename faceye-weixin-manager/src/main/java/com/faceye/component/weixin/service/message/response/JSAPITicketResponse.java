package com.faceye.component.weixin.service.message.response;

/**
 * JS-sdk临时票据
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年10月7日
 */
public class JSAPITicketResponse extends BaseResponse {
	private String ticket = "";
	private Long expires_in = 0L;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

}
