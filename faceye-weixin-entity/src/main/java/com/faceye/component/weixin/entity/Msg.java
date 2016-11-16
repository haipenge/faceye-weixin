package com.faceye.component.weixin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.faceye.feature.util.DateUtil;

/**
 * Msg ORM 实体<br>
 * 数据库表:weixin_msg<br>
 * @author @haipenge <br>
 * haipenge@gmail.com<br>
*  Create Date:2014年5月21日<br>
 */
@Document(collection = "weixin_msg")
public class Msg implements Serializable {
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
	 * 说明:开发者微信号<br>
	 * 属性名: toUserName<br>
	 * 类型: String<br>
	 * 数据库字段:to_user_name<br>
	 * @author haipenge<br>
	 */

	private String toUserName;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * 说明:发送方帐号<br>
	 * 属性名: fromUserName<br>
	 * 类型: String<br>
	 * 数据库字段:from_user_name<br>
	 * @author haipenge<br>
	 */

	private String fromUserName;

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * 说明:消息类型<br>
	 * 属性名: msgType<br>
	 * 类型: String<br>
	 * 数据库字段:msg_type<br>
	 * @author haipenge<br>
	 */

	private String msgType;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * 说明:消<br>
	 * 属性名: msgId<br>
	 * 类型: String<br>
	 * 数据库字段:msg_id<br>
	 * @author haipenge<br>
	 */

	private Long msgId;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	/**
	 * 说明:文本消息内容<br>
	 * 属性名: content<br>
	 * 类型: String<br>
	 * 数据库字段:content<br>
	 * @author haipenge<br>
	 */

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 说明:消息<br>
	 * 属性名: createTime<br>
	 * 类型: Integer<br>
	 * 数据库字段:create_time<br>
	 * @author haipenge<br>
	 */

	private Long createTime;

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	@Transient
	public String createTimeStr = "";

	public String getCreateTimeStr() {
		if (this.createTime != null) {
			this.setCreateTimeStr(DateUtil.formatDate(new Date(this.getCreateTime())));
		}
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	/**
	 * 消息与开发者微信号关联
	 * 
	 * account.weixinName = msg.toUserName
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
	 * 说明:Location_X<br>
	 * 属性名: location_x<br>
	 * 类型: Double<br>
	 * 数据库字段:location_x<br>
	 * @author haipenge<br>
	 */

	private Double location_x;

	public Double getLocation_x() {
		return location_x;
	}

	public void setLocation_x(Double location_x) {
		this.location_x = location_x;
	}

	/**
	 * 说明:Location_y<br>
	 * 属性名: location_y<br>
	 * 类型: Double<br>
	 * 数据库字段:location_y<br>
	 * @author haipenge<br>
	 */

	private Double location_y;

	public Double getLocation_y() {
		return location_y;
	}

	public void setLocation_y(Double location_y) {
		this.location_y = location_y;
	}

	/**
	 * 说明:地图缩放大小<br>
	 * 属性名: scale<br>
	 * 类型: Double<br>
	 * 数据库字段:scale<br>
	 * @author haipenge<br>
	 */

	private Double scale;

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	/**
	 * 说明:标题<br>
	 * 属性名: title<br>
	 * 类型: String<br>
	 * 数据库字段:title<br>
	 * @author haipenge<br>
	 */

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 说明:链接<br>
	 * 属性名: url<br>
	 * 类型: String<br>
	 * 数据库字段:url<br>
	 * @author haipenge<br>
	 */

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 说明:描述<br>
	 * 属性名: description<br>
	 * 类型: String<br>
	 * 数据库字段:description<br>
	 * @author haipenge<br>
	 */

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 说明:图片链接<br>
	 * 属性名: picUrl<br>
	 * 类型: String<br>
	 * 数据库字段:pic_url<br>
	 * @author haipenge<br>
	 */

	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	/**
	 * 说明:媒体ID<br>
	 * 属性名: mediaId<br>
	 * 类型: String<br>
	 * 数据库字段:media_id<br>
	 * @author haipenge<br>
	 */

	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * 说明:缩略图的媒体id<br>
	 * 属性名: thumbMediaId<br>
	 * 类型: String<br>
	 * 数据库字段:thumb_media_id<br>
	 * @author haipenge<br>
	 */

	private String thumbMediaId;

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	/**
	 * 说明:语音格式<br>
	 * 属性名: format<br>
	 * 类型: String<br>
	 * 数据库字段:format<br>
	 * @author haipenge<br>
	 */

	private String format;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 说明:事件<br>
	 * 属性名: event<br>
	 * 类型: String<br>
	 * 数据库字段:event<br>
	 * @author haipenge<br>
	 */

	private String event;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * 说明:上报纬度<br>
	 * 属性名: latitude<br>
	 * 类型: Double<br>
	 * 数据库字段:latitude<br>
	 * @author haipenge<br>
	 */

	private Double latitude;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 说明:上报经度<br>
	 * 属性名: longitude<br>
	 * 类型: Double<br>
	 * 数据库字段:longitude<br>
	 * @author haipenge<br>
	 */

	private Double longitude;

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 说明:上报精度<br>
	 * 属性名: precision<br>
	 * 类型: Double<br>
	 * 数据库字段:precision<br>
	 * @author haipenge<br>
	 */

	private Double precision;

	public Double getPrecision() {
		return precision;
	}

	public void setPrecision(Double precision) {
		this.precision = precision;
	}

	/**
	 * 说明:事件KEY值<br>
	 * 属性名: eventKey<br>
	 * 类型: String<br>
	 * 数据库字段:event_key<br>
	 * @author haipenge<br>
	 */

	private String eventKey;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * 说明:二维码<br>
	 * 属性名: ticket<br>
	 * 类型: String<br>
	 * 数据库字段:ticket<br>
	 * @author haipenge<br>
	 */

	private String ticket;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	

}/**@generate-entity-source@**/

