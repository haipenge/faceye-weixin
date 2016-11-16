package com.faceye.component.weixin.service.message.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 图文消息
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年5月27日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RichTextResponseMessage extends ResponseMessage {
	@XmlElement(name = "ArticleCount")
	private Integer articleCount = 0;
	@XmlElement(name = "item")
	@XmlElementWrapper(name = "Articles")
	private List<RichText> articles = new ArrayList<RichText>(0);

	public Integer getArticleCount() {
		return this.getArticles().size();
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	public List<RichText> getArticles() {
		return articles;
	}

	public void setArticles(List<RichText> articles) {
		this.setArticleCount(articles.size());
		this.articles = articles;
	}

}
