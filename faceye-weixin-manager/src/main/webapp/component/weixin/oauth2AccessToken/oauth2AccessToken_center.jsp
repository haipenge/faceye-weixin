<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/oauth2AccessToken/oauth2AccessToken.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/oauth2AccessToken/oauth2AccessToken.js"/>"></script>
<div class="page-head">
	<h2>
		<fmt:message key="weixin.oauth2AccessToken.manager"></fmt:message>
		<a class="btn btn-primary" href="<c:url value="/weixin/oauth2AccessToken/input"/>"> <fmt:message
				key="weixin.oauth2AccessToken.add"></fmt:message>
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
			<form action="<c:url value="/weixin/oauth2AccessToken/home"/>" method="post" role="form"
				class="form-horizontal">
				<fieldset>
					<div class="form-group">
						
<div class="col-md-1">
	<input type="text" name="EQ|account" value="${searchParams.account}"
		placeholder="<fmt:message key="weixin.oauth2AccessToken.account"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|openid" value="${searchParams.openid}"
		placeholder="<fmt:message key="weixin.oauth2AccessToken.openid"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|accessToken" value="${searchParams.accessToken}"
		placeholder="<fmt:message key="weixin.oauth2AccessToken.accessToken"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|refreshAccessToken" value="${searchParams.refreshAccessToken}"
		placeholder="<fmt:message key="weixin.oauth2AccessToken.refreshAccessToken"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|expiresIn" value="${searchParams.expiresIn}"
		placeholder="<fmt:message key="weixin.oauth2AccessToken.expiresIn"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|unionid" value="${searchParams.unionid}"
		placeholder="<fmt:message key="weixin.oauth2AccessToken.unionid"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|openid" value="${searchParams.openid}"
		placeholder="<fmt:message key="weixin.oauth2AccessToken.openid"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|code" value="${searchParams.code}"
		placeholder="<fmt:message key="weixin.oauth2AccessToken.code"></fmt:message>"
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
	       <button class="btn btn-primary btn-sm multi-remove"><fmt:message key="global.remove"></fmt:message></button>
			<div classs="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
						   <th><input type="checkbox" name="check-all"></th>
							<th><fmt:message key='weixin.oauth2AccessToken.account'></fmt:message></th>   
 <th><fmt:message key='weixin.oauth2AccessToken.openid'></fmt:message></th>   
 <th><fmt:message key='weixin.oauth2AccessToken.accessToken'></fmt:message></th>   
 <th><fmt:message key='weixin.oauth2AccessToken.refreshAccessToken'></fmt:message></th>   
 <th><fmt:message key='weixin.oauth2AccessToken.expiresIn'></fmt:message></th>   
 <th><fmt:message key='weixin.oauth2AccessToken.unionid'></fmt:message></th>   
 <th><fmt:message key='weixin.oauth2AccessToken.openid'></fmt:message></th>   
 <!--@generate-entity-jsp-property-desc@-->
							<th><fmt:message key="global.edit"></fmt:message></th>
							<th><fmt:message key="global.remove"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="oauth2AccessToken">
							<tr>
							   <td><input type="checkbox" name="check-single" value="${oauth2AccessToken.id}"></td>
								<td>${oauth2AccessToken.account}</td>   
 <td>${oauth2AccessToken.weixinUser.openid}</td>   
 <td>${oauth2AccessToken.accessToken}</td>   
 <td>${oauth2AccessToken.refreshAccessToken}</td>   
 <td>${oauth2AccessToken.expiresIn}</td>   
 <td>${oauth2AccessToken.unionid}</td>   
 <td>${oauth2AccessToken.openid}</td>   
 <!--@generate-entity-jsp-property-value@-->
								<td><a href="<c:url value="/weixin/oauth2AccessToken/edit/${oauth2AccessToken.id}"/>">
										<fmt:message key="global.edit"></fmt:message>
								</a></td>
								<td><a href="<c:url value="/weixin/oauth2AccessToken/remove/${oauth2AccessToken.id}"/>">
										<fmt:message key="global.remove"></fmt:message>
								</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<f:page page="${page}" url="/weixin/oauth2AccessToken/home" params="<%=request.getParameterMap()%>" />
		</div>
	</div>
</div>