<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/responseType/responseType.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/responseType/responseType.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.responseType.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
			 <tr>
	<td><fmt:message key="weixin.responseType.name"></fmt:message></td>
	<td>${responseType.name}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.responseType.code"></fmt:message></td>
	<td>${responseType.code}</td>
</tr>
<!--@generate-entity-jsp-property-detail@-->


			</table>
		</div>
	</div>
</div>