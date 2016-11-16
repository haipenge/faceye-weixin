<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/component/weixin/responseContent/responseContent.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/responseContent/responseContent.js"/>"></script>
<div class="page-head">
	<h2>
		<fmt:message key="weixin.responseContent.manager"></fmt:message>
		<a class="btn btn-primary" href="<c:url value="/weixin/responseContent/input"/>"> <fmt:message
				key="weixin.responseContent.add"></fmt:message>
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
		<c:if test="${not empty WEIXIN_ACCOUNT_SESSION_KEY }">
			<div class="content">
				<h3>
					<fmt:message key="weixin.account.weixinName" />
					:${WEIXIN_ACCOUNT_SESSION_KEY.weixinName}
				</h3>
			</div>
		</c:if>
		<div class="content">
			<form action="<c:url value="/weixin/responseContent/home"/>" method="post" role="form" class="form-horizontal">
				<fieldset>
					<div class="form-group">

						<div class="col-md-1">
							<input type="text" name="EQ|name" value="${searchParams.name}"
								placeholder="<fmt:message key="weixin.responseContent.name"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|content" value="${searchParams.content}"
								placeholder="<fmt:message key="weixin.responseContent.content"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|isEnabled" value="${searchParams.isEnabled}"
								placeholder="<fmt:message key="weixin.responseContent.isEnabled"></fmt:message>" class="form-control input-sm">
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
							<th><fmt:message key='weixin.responseContent.name'></fmt:message></th>
							<th><fmt:message key="weixin.responseMessageType"/></th>
							<th><fmt:message key="weixin.responseType"/></th>
							<th><fmt:message key='weixin.responseContent.content'></fmt:message></th>
							<th><fmt:message key='weixin.responseContent.isEnabled'></fmt:message></th>
							<th><fmt:message key="weixin.responseContentItem"></fmt:message></th>
							<!--@generate-entity-jsp-property-desc@-->
							<th><fmt:message key="global.edit"></fmt:message></th>
							<th><fmt:message key="global.remove"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="responseContent">
							<tr>
								<td><input type="checkbox" name="check-single" value="${responseContent.id}"></td>
								<td>${responseContent.name}</td>
								<td>${responseContent.responseMessageType.name }</td>
								<td>${responseContent.responseType.name }</td>
								<td>${responseContent.content}</td>
								<td><f:boolean value="${responseContent.isEnabled}" /></td>
								<td><c:if test="${responseContent.responseMessageType.code eq 'news' }">
										<a href="<c:url value="/weixin/responseContentItem/home?EQ|responseContent.$id=${responseContent.id }"/>"><fmt:message
												key="weixin.responseContentItem" /></a>
									</c:if></td>
								<!--@generate-entity-jsp-property-value@-->
								<td><a href="<c:url value="/weixin/responseContent/edit/${responseContent.id}"/>"> <fmt:message
											key="global.edit"></fmt:message>
								</a></td>
								<td><a href="<c:url value="/weixin/responseContent/remove/${responseContent.id}"/>"> <fmt:message
											key="global.remove"></fmt:message>
								</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<f:page page="${page}" url="/weixin/responseContent/home" params="<%=request.getParameterMap()%>" />
		</div>
	</div>
</div>