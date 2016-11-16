<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/jsapiTicket/jsapiTicket.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/jsapiTicket/jsapiTicket.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.jsapiTicket.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
			 <tr>
	<td><fmt:message key="weixin.jsapiTicket.ticket"></fmt:message></td>
	<td>${jsapiTicket.ticket}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.jsapiTicket.expiresIn"></fmt:message></td>
	<td>${jsapiTicket.expiresIn}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.jsapiTicket.account"></fmt:message></td>
	<td>${jsapiTicket.account}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.jsapiTicket.lastRefreshDate"></fmt:message></td>
	<td>${jsapiTicket.lastRefreshDate}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.jsapiTicket.createDate"></fmt:message></td>
	<td>${jsapiTicket.createDate}</td>
</tr>
<!--@generate-entity-jsp-property-detail@-->





			</table>
		</div>
	</div>
</div>