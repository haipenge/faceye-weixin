<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/weixinMenu/weixinMenu.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/weixinMenu/weixinMenu.js"/>"></script>
<div class="page-head">
	<h2>
		<fmt:message key="weixin.weixinMenu.manager"></fmt:message>
		<a class="btn btn-primary"
			href="<c:url value="/weixin/weixinMenu/input?accountId=${account.id }"/>">
			<fmt:message key="weixin.weixinMenu.add"></fmt:message>
		</a> <a href="#" class="btn btn-primary" id="generate-weixin-menu"><fmt:message
				key="weixin.weixinMenu.create" /></a> <a href="#"
			class="btn btn-primary" id="delete-weixin-menu"><fmt:message
				key="weixin.weixinMenu.delete" /></a>
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
			<form action="<c:url value="/weixin/weixinMenu/home"/>" method="post"
				role="form" class="form-horizontal">
				<fieldset>
					<div class="form-group">

						<div class="col-md-1">
							<input type="text" name="EQ|name" value="${searchParams.name}"
								placeholder="<fmt:message key="weixin.weixinMenu.name"></fmt:message>"
								class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|type" value="${searchParams.type}"
								placeholder="<fmt:message key="weixin.weixinMenu.type"></fmt:message>"
								class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|key" value="${searchParams.key}"
								placeholder="<fmt:message key="weixin.weixinMenu.key"></fmt:message>"
								class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|url" value="${searchParams.url}"
								placeholder="<fmt:message key="weixin.weixinMenu.url"></fmt:message>"
								class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|mediaId"
								value="${searchParams.mediaId}"
								placeholder="<fmt:message key="weixin.weixinMenu.mediaId"></fmt:message>"
								class="form-control input-sm"> <input type="hidden"
								name="EQ|account.$id" value="${account.id}" />

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
			<input type="hidden" value="${account.id}" name="accountId" />
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
							<th><fmt:message key='weixin.weixinMenu.name'></fmt:message></th>
							<th style="width:120px;"><fmt:message key="weixin.weixinMenu.orderIndex"/></th>
							<th><fmt:message key='weixin.weixinMenu.type'></fmt:message></th>
							<th><fmt:message key='weixin.weixinMenu.key'></fmt:message></th>
							<th><fmt:message key='weixin.weixinMenu.url'></fmt:message></th>
							<th><fmt:message key='weixin.weixinMenu.mediaId'></fmt:message></th>
							<!--@generate-entity-jsp-property-desc@-->
							<th><fmt:message key="global.edit"></fmt:message></th>
							<th><fmt:message key="global.remove"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="weixinMenu">
							<tr id="${weixinMenu.id}">
								<td><input type="checkbox" name="check-single"
									value="${weixinMenu.id}"></td>
								<td>${weixinMenu.name}</td>
								<td class="order-index-box">${weixinMenu.orderIndex }</td>
								<td>${weixinMenu.type}</td>
								<td>${weixinMenu.key}</td>
								<td>${weixinMenu.url}</td>
								<td>${weixinMenu.mediaId}</td>
								<!--@generate-entity-jsp-property-value@-->
								<td><a
									href="<c:url value="/weixin/weixinMenu/edit/${weixinMenu.id}?accountId=${weixinMenu.account.id }"/>">
										<fmt:message key="global.edit"></fmt:message>
								</a></td>
								<td><a
									href="<c:url value="/weixin/weixinMenu/remove/${weixinMenu.id}"/>">
										<fmt:message key="global.remove"></fmt:message>
								</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<f:page page="${page}" url="/weixin/weixinMenu/home"
				params="<%=request.getParameterMap()%>" />
		</div>
	</div>
</div>