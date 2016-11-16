<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/component/weixin/account/account.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/account/account.js"/>"></script>
<div class="page-head">
	<h2>
		<fmt:message key="weixin.account.manager"></fmt:message>
		<a class="btn btn-primary" href="<c:url value="/weixin/account/input"/>"> <fmt:message key="weixin.account.add"></fmt:message>
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
		<div class="content">
			<form action="<c:url value="/weixin/account/home"/>" method="post" role="form" class="form-horizontal">
				<fieldset>
					<div class="form-group">
						<div class="col-md-2">
							<input type="text" name="LIKE|name" value="${searchParams.name}" placeholder="<fmt:message key="weixin.account.name"></fmt:message>" class="form-control input-sm">
						</div>
						<div class="col-md-2">
							<input type="text" name="LIKE|host" value="${searchParams.host}" placeholder="<fmt:message key="weixin.account.host"></fmt:message>" class="form-control input-sm">
						</div>
						<div class="col-md-2">
							<input type="text" name="LIKE|appId" value="${searchParams.appId}" placeholder="<fmt:message key="weixin.account.appId"></fmt:message>" class="form-control input-sm">
						</div>
						<div class="col-md-2">
							<input type="text" name="LIKE|weixinName" value="${searchParams.weixinName}" placeholder="<fmt:message key="weixin.account.weixinName"></fmt:message>"
								class="form-control input-sm">
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
							<th><fmt:message key='weixin.account.name'></fmt:message></th>
							<th><fmt:message key='weixin.account.appId'></fmt:message></th>
							<th><fmt:message key='weixin.account.lastGotAccessTokenDate'></fmt:message></th>
							<th><fmt:message key='weixin.account.accountType'></fmt:message></th>
							<th><fmt:message key='weixin.account.weixinName'></fmt:message></th>
							<th><fmt:message key='weixin.account.host'></fmt:message></th>
							<!--@generate-entity-jsp-property-desc@-->
							<th><fmt:message key="weixin.responseContent.manager"></fmt:message></th>
							<th><fmt:message key="weixin.weixinUser" /></th>
							<th><fmt:message key="weixin.weixinMenu" /></th>
							<th><fmt:message key="global.edit"></fmt:message></th>
							<th><fmt:message key="global.remove"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="account">
							<tr>
								<td><input type="checkbox" name="check-single" value="${account.id}"></td>
								<td><a href="<c:url value="/weixin/account/detail/${account.id}"/>">${account.name}</a></td>
								<td>${account.appId}</td>
								<td><fmt:formatDate value="${account.lastGotAccessTokenDate}" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
								<td>${account.accountType}</td>
								<td>${account.weixinName}</td>
								<td>${account.host}</td>
								<!--@generate-entity-jsp-property-value@-->
								<td><a href="/weixin/responseContent/home?EQ|account.$id=${account.id}"><fmt:message key="weixin.responseContent.manager"></fmt:message></a></td>
								<td><a href="<c:url value="/weixin/weixinUser/home?EQ|account.$id=${account.id}"/>"><fmt:message key="weixin.weixinUser" /></a></td>
								<td><a href="<c:url value="/weixin/weixinMenu/home?EQ|account.$id=${account.id}"/>"><fmt:message key="weixin.weixinMenu" /></a></td>
								<td><a href="<c:url value="/weixin/account/edit/${account.id}"/>"> <fmt:message key="global.edit"></fmt:message></a></td>
								<td><a href="<c:url value="/weixin/account/remove/${account.id}"/>"> <fmt:message key="global.remove"></fmt:message></a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<f:page page="${page}" url="/weixin/account/home" params="<%=request.getParameterMap()%>" />
		</div>
	</div>
</div>