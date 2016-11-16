package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * JSAPITicket ORM 实体<br>
 * 数据库表:weixin_jsapiTicket<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection = "weixin_jsapi_ticket")
public class JSAPITicket implements Serializable {
	private static final long serialVersionUID = 8926119711730830203L;
	@Id
	private Long id = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 说明:票据<br>
	 * 属性名: ticket<br>
	 * 类型: String<br>
	 * 数据库字段:ticket<br>
	 * @author haipenge<br>
	 */

	private String ticket = "";

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * 说明:有效时间(s)<br>
	 * 属性名: expiresIn<br>
	 * 类型: Long<br>
	 * 数据库字段:expires_in<br>
	 * @author haipenge<br>
	 */

	private Long expiresIn = 0L;

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * 说明:所属微信公众号<br>
	 * 属性名: account<br>
	 * 类型: Account<br>
	 * 数据库字段:account_id<br>
	 * @author haipenge<br>
	 */
	@DBRef
	private Account account = null;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * 说明:最后刷新时间<br>
	 * 属性名: lastRefreshDate<br>
	 * 类型: Date<br>
	 * 数据库字段:last_refresh_date<br>
	 * @author haipenge<br>
	 */

	private Date lastRefreshDate = null;

	public Date getLastRefreshDate() {
		return lastRefreshDate;
	}

	public void setLastRefreshDate(Date lastRefreshDate) {
		this.lastRefreshDate = lastRefreshDate;
	}

	/**
	 * 票据是否过期
	 * @todo
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年10月7日
	 */
	public boolean isExpire() {
      boolean isExpire=true;
      if(this.getLastRefreshDate()!=null){
    	  //todo 是否需要提前1分钟刷新?
    	  isExpire=this.getLastRefreshDate().getTime()+this.expiresIn*1000<System.currentTimeMillis();
      }
      return isExpire;
	}

	/**
	 * 说明:创建时间<br>
	 * 属性名: createDate<br>
	 * 类型: Date<br>
	 * 数据库字段:create_date<br>
	 * @author haipenge<br>
	 */

	private Date createDate = new Date();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
/**@generate-entity-source@**/

