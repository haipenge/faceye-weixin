<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/component/weixin/msg/msg.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/msg/msg.js"/>"></script>
<div class="page-head">
	<h2>
		<fmt:message key="weixin.msg.manager"></fmt:message>
		<a class="btn btn-primary" href="<c:url value="/weixin/msg/input"/>"> <fmt:message key="weixin.msg.add"></fmt:message>
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
			<form action="<c:url value="/weixin/msg/home"/>" method="post" role="form" class="form-horizontal">
				<fieldset>
					<div class="form-group">

						<div class="col-md-1">
							<input type="text" name="EQ|toUserName" value="${searchParams.toUserName}"
								placeholder="<fmt:message key="weixin.msg.toUserName"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|fromUserName" value="${searchParams.fromUserName}"
								placeholder="<fmt:message key="weixin.msg.fromUserName"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|msgType" value="${searchParams.msgType}"
								placeholder="<fmt:message key="weixin.msg.msgType"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|msgId" value="${searchParams.msgId}"
								placeholder="<fmt:message key="weixin.msg.msgId"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|content" value="${searchParams.content}"
								placeholder="<fmt:message key="weixin.msg.content"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|createTime" value="${searchParams.createTime}"
								placeholder="<fmt:message key="weixin.msg.createTime"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|location_x" value="${searchParams.location_x}"
								placeholder="<fmt:message key="weixin.msg.location_x"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|location_y" value="${searchParams.location_y}"
								placeholder="<fmt:message key="weixin.msg.location_y"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|scale" value="${searchParams.scale}"
								placeholder="<fmt:message key="weixin.msg.scale"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|title" value="${searchParams.title}"
								placeholder="<fmt:message key="weixin.msg.title"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|url" value="${searchParams.url}"
								placeholder="<fmt:message key="weixin.msg.url"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|description" value="${searchParams.description}"
								placeholder="<fmt:message key="weixin.msg.description"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|picUrl" value="${searchParams.picUrl}"
								placeholder="<fmt:message key="weixin.msg.picUrl"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|mediaId" value="${searchParams.mediaId}"
								placeholder="<fmt:message key="weixin.msg.mediaId"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|thumbMediaId" value="${searchParams.thumbMediaId}"
								placeholder="<fmt:message key="weixin.msg.thumbMediaId"></fmt:message>" class="form-control input-sm">
						</div>

						<div class="col-md-1">
							<input type="text" name="EQ|format" value="${searchParams.format}"
								placeholder="<fmt:message key="weixin.msg.format"></fmt:message>" class="form-control input-sm">
						</div>
						
<div class="col-md-1">
	<input type="text" name="EQ|event" value="${searchParams.event}"
		placeholder="<fmt:message key="weixin.msg.event"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|latitude" value="${searchParams.latitude}"
		placeholder="<fmt:message key="weixin.msg.latitude"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|longitude" value="${searchParams.longitude}"
		placeholder="<fmt:message key="weixin.msg.longitude"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|precision" value="${searchParams.precision}"
		placeholder="<fmt:message key="weixin.msg.precision"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|eventKey" value="${searchParams.eventKey}"
		placeholder="<fmt:message key="weixin.msg.eventKey"></fmt:message>"
		class="form-control input-sm">
</div>

<div class="col-md-1">
	<input type="text" name="EQ|ticket" value="${searchParams.ticket}"
		placeholder="<fmt:message key="weixin.msg.ticket"></fmt:message>"
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
							<th><fmt:message key='weixin.msg.toUserName'></fmt:message></th>
							<th><fmt:message key='weixin.msg.fromUserName'></fmt:message></th>
							<th><fmt:message key='weixin.msg.msgType'></fmt:message></th>
							<th><fmt:message key='weixin.msg.msgId'></fmt:message></th>
							<th><fmt:message key='weixin.msg.content'></fmt:message></th>
							<th><fmt:message key='weixin.msg.createTime'></fmt:message></th>
							<th><fmt:message key='weixin.msg.location_x'></fmt:message></th>
							<th><fmt:message key='weixin.msg.location_y'></fmt:message></th>
							<th><fmt:message key='weixin.msg.scale'></fmt:message></th>
							<th><fmt:message key='weixin.msg.title'></fmt:message></th>
							<th><fmt:message key='weixin.msg.url'></fmt:message></th>
							<th><fmt:message key='weixin.msg.description'></fmt:message></th>
							<th><fmt:message key='weixin.msg.picUrl'></fmt:message></th>
							<th><fmt:message key='weixin.msg.mediaId'></fmt:message></th>
							<th><fmt:message key='weixin.msg.thumbMediaId'></fmt:message></th>
							<th><fmt:message key='weixin.msg.format'></fmt:message></th>
							<th><fmt:message key='weixin.msg.event'></fmt:message></th>   
 <th><fmt:message key='weixin.msg.latitude'></fmt:message></th>   
 <th><fmt:message key='weixin.msg.longitude'></fmt:message></th>   
 <th><fmt:message key='weixin.msg.precision'></fmt:message></th>   
 <th><fmt:message key='weixin.msg.eventKey'></fmt:message></th>   
 <th><fmt:message key='weixin.msg.ticket'></fmt:message></th>   
 <!--@generate-entity-jsp-property-desc@-->
							<th><fmt:message key="global.edit"></fmt:message></th>
							<th><fmt:message key="global.remove"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="msg">
							<tr>
								<td><input type="checkbox" name="check-single" value="${msg.id}"></td>
								<td>${msg.toUserName}</td>
								<td>${msg.fromUserName}</td>
								<td>${msg.msgType}</td>
								<td>${msg.msgId}</td>
								<td>${msg.content}</td>
								<td>${msg.createTimeStr}</td>
								<td>${msg.location_x}</td>
								<td>${msg.location_y}</td>
								<td>${msg.scale}</td>
								<td>${msg.title}</td>
								<td>${msg.url}</td>
								<td>${msg.description}</td>
								<td>${msg.picUrl}</td>
								<td>${msg.mediaId}</td>
								<td>${msg.thumbMediaId}</td>
								<td>${msg.format}</td>
								<td>${msg.event}</td>   
 <td>${msg.latitude}</td>   
 <td>${msg.longitude}</td>   
 <td>${msg.precision}</td>   
 <td>${msg.eventKey}</td>   
 <td>${msg.ticket}</td>   
 <!--@generate-entity-jsp-property-value@-->
								<td><a href="<c:url value="/weixin/msg/edit/${msg.id}"/>"> <fmt:message key="global.edit"></fmt:message>
								</a></td>
								<td><a href="<c:url value="/weixin/msg/remove/${msg.id}"/>"> <fmt:message key="global.remove"></fmt:message>
								</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<f:page page="${page}" url="/weixin/msg/home" params="<%=request.getParameterMap()%>" />
		</div>
	</div>
</div>