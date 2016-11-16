<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/responseContentItem/responseContentItem.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/responseContentItem/responseContentItem.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.responseContentItem.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
			 <tr>
	<td><fmt:message key="weixin.responseContentItem.name"></fmt:message></td>
	<td>${responseContentItem.name}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.responseContentItem.remark"></fmt:message></td>
	<td>${responseContentItem.remark}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.responseContentItem.url"></fmt:message></td>
	<td>${responseContentItem.url}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.responseContentItem.picUrl"></fmt:message></td>
	<td>${responseContentItem.picUrl}</td>
</tr>
<!--@generate-entity-jsp-property-detail@-->




			</table>
		</div>
	</div>
</div>