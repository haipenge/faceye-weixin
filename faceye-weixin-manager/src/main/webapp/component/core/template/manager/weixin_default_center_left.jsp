<%@ include file="/component/core/taglib/taglib.jsp"%>
<li><a href="#"><i class="fa fa-file"></i><span><fmt:message key="weixin.weixin.manager" /></span></a>
	<ul class="sub-menu">
		<li class="<%=JspUtil.isActive(request, "/weixin/account|/weixin/responseContent|/weixin/weixinUser")%>"><a href="/weixin/account/home"><fmt:message key="weixin.account.manager"></fmt:message></a></li>
		<li class="<%=JspUtil.isActive(request, "/weixin/msg")%>"><a href="/weixin/msg/home"><fmt:message key="weixin.msg.manager"></fmt:message></a></li>
		<li class="<%=JspUtil.isActive(request, "/weixin/responseType")%>"><a href="/weixin/responseType/home"><fmt:message key="weixin.responseType.manager"></fmt:message></a></li>
		<li class="<%=JspUtil.isActive(request, "/weixin/responseMessageType")%>"><a href="/weixin/responseMessageType/home"><fmt:message
					key="weixin.responseMessageType.manager"></fmt:message></a></li>
		<li class="<%=JspUtil.isActive(request, "/weixin/oauth2AccessToken")%>"><a href="/weixin/oauth2AccessToken/home"><fmt:message key="weixin.oauth2AccessToken.manager"></fmt:message></a></li>
		<!--@generate-entity-manager-list-group-item@-->
	</ul></li>
