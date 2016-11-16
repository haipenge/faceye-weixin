<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/oauth2AccessToken/oauth2AccessToken.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/oauth2AccessToken/oauth2AccessToken.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.oauth2AccessToken.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
			 <tr>
	<td><fmt:message key="weixin.oauth2AccessToken.account"></fmt:message></td>
	<td>${oauth2AccessToken.account}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.oauth2AccessToken.openid"></fmt:message></td>
	<td>${oauth2AccessToken.openid}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.oauth2AccessToken.accessToken"></fmt:message></td>
	<td>${oauth2AccessToken.accessToken}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.oauth2AccessToken.refreshAccessToken"></fmt:message></td>
	<td>${oauth2AccessToken.refreshAccessToken}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.oauth2AccessToken.expiresIn"></fmt:message></td>
	<td>${oauth2AccessToken.expiresIn}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.oauth2AccessToken.unionid"></fmt:message></td>
	<td>${oauth2AccessToken.unionid}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.oauth2AccessToken.openid"></fmt:message></td>
	<td>${oauth2AccessToken.openid}</td>
</tr>

<!--@generate-entity-jsp-property-detail@-->








			</table>
		</div>
	</div>
</div>