<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/weixinUser/weixinUser.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/weixinUser/weixinUser.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.weixinUser.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
			 <tr>
	<td><fmt:message key="weixin.weixinUser.openid"></fmt:message></td>
	<td>${weixinUser.openid}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.nickname"></fmt:message></td>
	<td>${weixinUser.nickname}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.sex"></fmt:message></td>
	<td>${weixinUser.sex}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.province"></fmt:message></td>
	<td>${weixinUser.province}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.city"></fmt:message></td>
	<td>${weixinUser.city}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.country"></fmt:message></td>
	<td>${weixinUser.country}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.headimgurl"></fmt:message></td>
	<td>${weixinUser.headimgurl}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.privilege"></fmt:message></td>
	<td>${weixinUser.privilege}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.unionid"></fmt:message></td>
	<td>${weixinUser.unionid}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.language"></fmt:message></td>
	<td>${weixinUser.language}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinUser.createDate"></fmt:message></td>
	<td>${weixinUser.createDate}</td>
</tr>
<!--@generate-entity-jsp-property-detail@-->











			</table>
		</div>
	</div>
</div>