<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/responseMessageType/responseMessageType.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/responseMessageType/responseMessageType.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.responseMessageType.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
			 <tr>
	<td><fmt:message key="weixin.responseMessageType.name"></fmt:message></td>
	<td>${responseMessageType.name}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.responseMessageType.code"></fmt:message></td>
	<td>${responseMessageType.code}</td>
</tr>
<!--@generate-entity-jsp-property-detail@-->


			</table>
		</div>
	</div>
</div>