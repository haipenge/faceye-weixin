<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/component/weixin/weixinUser/weixinUser.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/weixinUser/weixinUser.js"/>"></script>
<div class="page-head">
	<h2>
		<fmt:message key="weixin.weixinUser.manager"></fmt:message>
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
			<form action="<c:url value="/weixin/weixinUser/home"/>" method="post" role="form" class="form-horizontal">
				<fieldset>
					<div class="form-group">

						<div class="col-md-2">
							<input type="text" name="like|openid" value="${searchParams.openid}" placeholder="<fmt:message key="weixin.weixinUser.openid"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-2">
							<input type="text" name="like|nickname" value="${searchParams.nickname}" placeholder="<fmt:message key="weixin.weixinUser.nickname"></fmt:message>"
								class="form-control input-sm">
						</div>

						<div class="col-md-2">
							<input type="text" name="EQ|province" value="${searchParams.province}" placeholder="<fmt:message key="weixin.weixinUser.province"></fmt:message>"
								class="form-control input-sm">
						</div>

						<div class="col-md-2">
							<input type="text" name="EQ|city" value="${searchParams.city}" placeholder="<fmt:message key="weixin.weixinUser.city"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-2">
							<input type="text" name="like|unionid" value="${searchParams.unionid}" placeholder="<fmt:message key="weixin.weixinUser.unionid"></fmt:message>"
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
							<th><fmt:message key='weixin.weixinUser.nickname'></fmt:message></th>
							<th><fmt:message key='weixin.weixinUser.openid'></fmt:message></th>
							<th><fmt:message key='weixin.weixinUser.sex'></fmt:message></th>
							<th><fmt:message key='weixin.weixinUser.province'></fmt:message></th>
							<th><fmt:message key='weixin.weixinUser.city'></fmt:message></th>
							<th><fmt:message key='weixin.weixinUser.headimgurl'></fmt:message></th>
							<th><fmt:message key='weixin.weixinUser.privilege'></fmt:message></th>
							<th><fmt:message key='weixin.weixinUser.unionid'></fmt:message></th>
							<th><fmt:message key='weixin.weixinUser.createDate'></fmt:message></th>
							<!--@generate-entity-jsp-property-desc@-->
							<!-- 
							<th><fmt:message key="global.edit"></fmt:message></th>
							<th><fmt:message key="global.remove"></fmt:message></th>
							 -->
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="weixinUser">
							<tr>
								<td><input type="checkbox" name="check-single" value="${weixinUser.id}"></td>
								<td>${weixinUser.nickname}</td>
								<td>${weixinUser.openid}</td>
								<td>${weixinUser.sex}</td>
								<td>${weixinUser.province}</td>
								<td>${weixinUser.city}</td>
								<td><img src="${weixinUser.headimgurl}" class="img-small img-responsive img-thumbnail"></td>
								<td>${weixinUser.privilege}</td>
								<td>${weixinUser.unionid}</td>
								<td>${weixinUser.createDate}</td>
								<!--@generate-entity-jsp-property-value@-->
								<!-- 
								<td><a href="<c:url value="/weixin/weixinUser/edit/${weixinUser.id}"/>"> <fmt:message key="global.edit"></fmt:message>
								</a></td>
								<td><a href="<c:url value="/weixin/weixinUser/remove/${weixinUser.id}"/>"> <fmt:message key="global.remove"></fmt:message>
								</a></td>
								 -->
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<f:page page="${page}" url="/weixin/weixinUser/home" params="<%=request.getParameterMap()%>" />
		</div>
	</div>
</div>