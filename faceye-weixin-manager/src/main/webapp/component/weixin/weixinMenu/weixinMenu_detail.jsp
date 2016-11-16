<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/weixinMenu/weixinMenu.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/weixinMenu/weixinMenu.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.weixinMenu.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
			 <tr>
	<td><fmt:message key="weixin.weixinMenu.name"></fmt:message></td>
	<td>${weixinMenu.name}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinMenu.type"></fmt:message></td>
	<td>${weixinMenu.type}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinMenu.key"></fmt:message></td>
	<td>${weixinMenu.key}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinMenu.url"></fmt:message></td>
	<td>${weixinMenu.url}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.weixinMenu.mediaId"></fmt:message></td>
	<td>${weixinMenu.mediaId}</td>
</tr>
<!--@generate-entity-jsp-property-detail@-->





			</table>
		</div>
	</div>
</div>