<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/responseContentItem/responseContentItem.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/responseContentItem/responseContentItem.js"/>"></script>
<div class="page-head">
	<h2>
		<fmt:message key="weixin.responseContentItem.manager"></fmt:message>
		<a class="btn btn-primary" href="<c:url value="/weixin/responseContentItem/input?responseContentId=${responseContent.id}"/>"> <fmt:message
				key="weixin.responseContentItem.add"></fmt:message>
		</a>
	</h2>
</div>
<div class="cl-mcont">
	<!-- 
	<div class="header">
		<h2>
			<fmt:message key="security.role.manager"></fmt:message>
		</h2>
		<a class="btn btn-default" href="<c:url value="/security/role/input"/>"> <fmt:message key="security.role.add"></fmt:message>
		</a>
	</div>
	 -->
	<div class="block-flat">
		<c:if test="${not empty responseContent }">
			<div class="content">
				<h4>${responseContent.name }</h4>
			</div>
		</c:if>
		<div class="content">
			<form action="<c:url value="/weixin/responseContentItem/home"/>" method="post" role="form" class="form-horizontal">
				<fieldset>
					<div class="form-group">

						<div class="col-md-3">
							<input type="text" name="LIKE|name" value="${searchParams.name}"
								placeholder="<fmt:message key="weixin.responseContentItem.name"></fmt:message>" class="form-control input-sm">
						</div>

						
						<!--@generate-entity-jsp-query-detail@-->
						<div class="col-md-1">
							<button type="submit" class="btn btn-sm btn-primary">
								<fmt:message key="global.search"></fmt:message>
							</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="content">
			<div id="msg"></div>
			<button class="btn btn-primary btn-sm multi-remove">
				<fmt:message key="global.remove"></fmt:message>
			</button>
			<div classs="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th><input type="checkbox" name="check-all"></th>
							<th><fmt:message key='weixin.responseContentItem.name'></fmt:message></th>
							<th><fmt:message key='weixin.responseContentItem.picUrl'></fmt:message></th>
							<!--@generate-entity-jsp-property-desc@-->
							<th><fmt:message key="global.edit"></fmt:message></th>
							<th><fmt:message key="global.remove"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="responseContentItem">
							<tr id="${responseContentItem.id}">
								<td><input type="checkbox" name="check-single" value="${responseContentItem.id}"></td>
								<td><a target="_blank" href="${responseContentItem.responseContent.account.host}${responseContentItem.url}" taret="_blank">${responseContentItem.name}</a></td>
								<td><img src="${responseContentItem.picUrl}" class="img-thumbnail img-small"></td>
								<!--@generate-entity-jsp-property-value@-->
								<td><a href="<c:url value="/weixin/responseContentItem/edit/${responseContentItem.id}?responseContentId=${responseContentItem.responseContent.id }"/>"> <fmt:message
											key="global.edit"></fmt:message>
								</a></td>
								<td><a href="<c:url value="/weixin/responseContentItem/remove/${responseContentItem.id}"/>"> <fmt:message
											key="global.remove"></fmt:message>
								</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<f:page page="${page}" url="/weixin/responseContentItem/home" params="<%=request.getParameterMap()%>" />
		</div>
	</div>
</div>