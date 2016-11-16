<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/responseContent/responseContent.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/responseContent/responseContent.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.responseContent.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
			 <tr>
	<td><fmt:message key="weixin.responseContent.name"></fmt:message></td>
	<td>${responseContent.name}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.responseContent.content"></fmt:message></td>
	<td>${responseContent.content}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.responseContent.isEnabled"></fmt:message></td>
	<td>${responseContent.isEnabled}</td>
</tr>
<!--@generate-entity-jsp-property-detail@-->



			</table>
		</div>
	</div>
</div>