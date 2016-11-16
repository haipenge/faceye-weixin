<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/jsapiTicket/jsapiTicket.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/jsapiTicket/jsapiTicket.js"/>"></script>
<div class="page-head">
	<h2>
		<fmt:message key="weixin.jsapiTicket.manager"></fmt:message>
		<a class="btn btn-primary" href="<c:url value="/weixin/jsapiTicket/input"/>"> <fmt:message
				key="weixin.jsapiTicket.add"></fmt:message>
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
			<form action="<c:url value="/weixin/jsapiTicket/home"/>" method="post" role="form"
				class="form-horizontal">
				<fieldset>
					<div class="form-group">
						
<div class="col-md-1">
	<input type="text" name="EQ|ticket" value="${searchParams.ticket}"
		placeholder="<fmt:message key="weixin.jsapiTicket.ticket"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|expiresIn" value="${searchParams.expiresIn}"
		placeholder="<fmt:message key="weixin.jsapiTicket.expiresIn"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|account" value="${searchParams.account}"
		placeholder="<fmt:message key="weixin.jsapiTicket.account"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|lastRefreshDate" value="${searchParams.lastRefreshDate}"
		placeholder="<fmt:message key="weixin.jsapiTicket.lastRefreshDate"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|createDate" value="${searchParams.createDate}"
		placeholder="<fmt:message key="weixin.jsapiTicket.createDate"></fmt:message>"
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
							<th><fmt:message key='weixin.jsapiTicket.ticket'></fmt:message></th>   
 <th><fmt:message key='weixin.jsapiTicket.expiresIn'></fmt:message></th>   
 <th><fmt:message key='weixin.jsapiTicket.account'></fmt:message></th>   
 <th><fmt:message key='weixin.jsapiTicket.lastRefreshDate'></fmt:message></th>   
 <th><fmt:message key='weixin.jsapiTicket.createDate'></fmt:message></th>   
 <!--@generate-entity-jsp-property-desc@-->
							<th><fmt:message key="global.edit"></fmt:message></th>
							<th><fmt:message key="global.remove"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="jsapiTicket">
							<tr>
							   <td><input type="checkbox" name="check-single" value="${jsapiTicket.id}"></td>
								<td>${jsapiTicket.ticket}</td>   
 <td>${jsapiTicket.expiresIn}</td>   
 <td>${jsapiTicket.account}</td>   
 <td>${jsapiTicket.lastRefreshDate}</td>   
 <td>${jsapiTicket.createDate}</td>   
 <!--@generate-entity-jsp-property-value@-->
								<td><a href="<c:url value="/weixin/jsapiTicket/edit/${jsapiTicket.id}"/>">
										<fmt:message key="global.edit"></fmt:message>
								</a></td>
								<td><a href="<c:url value="/weixin/jsapiTicket/remove/${jsapiTicket.id}"/>">
										<fmt:message key="global.remove"></fmt:message>
								</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<f:page page="${page}" url="/weixin/jsapiTicket/home" params="<%=request.getParameterMap()%>" />
		</div>
	</div>
</div>