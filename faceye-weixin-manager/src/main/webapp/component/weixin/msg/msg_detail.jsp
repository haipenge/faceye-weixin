<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/component/weixin/msg/msg.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/msg/msg.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.msg.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<table class="table table-bordered table-hover">
				<tr>
					<td><fmt:message key="weixin.msg.toUserName"></fmt:message></td>
					<td>${msg.toUserName}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.fromUserName"></fmt:message></td>
					<td>${msg.fromUserName}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.msgType"></fmt:message></td>
					<td>${msg.msgType}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.msgId"></fmt:message></td>
					<td>${msg.msgId}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.content"></fmt:message></td>
					<td>${msg.content}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.createTime"></fmt:message></td>
					<td>${msg.createTimeStr}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.location_x"></fmt:message></td>
					<td>${msg.location_x}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.location_y"></fmt:message></td>
					<td>${msg.location_y}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.scale"></fmt:message></td>
					<td>${msg.scale}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.title"></fmt:message></td>
					<td>${msg.title}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.url"></fmt:message></td>
					<td>${msg.url}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.description"></fmt:message></td>
					<td>${msg.description}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.picUrl"></fmt:message></td>
					<td>${msg.picUrl}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.mediaId"></fmt:message></td>
					<td>${msg.mediaId}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.thumbMediaId"></fmt:message></td>
					<td>${msg.thumbMediaId}</td>
				</tr>
				<tr>
					<td><fmt:message key="weixin.msg.format"></fmt:message></td>
					<td>${msg.format}</td>
				</tr>
				<tr>
	<td><fmt:message key="weixin.msg.event"></fmt:message></td>
	<td>${msg.event}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.msg.latitude"></fmt:message></td>
	<td>${msg.latitude}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.msg.longitude"></fmt:message></td>
	<td>${msg.longitude}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.msg.precision"></fmt:message></td>
	<td>${msg.precision}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.msg.eventKey"></fmt:message></td>
	<td>${msg.eventKey}</td>
</tr>
<tr>
	<td><fmt:message key="weixin.msg.ticket"></fmt:message></td>
	<td>${msg.ticket}</td>
</tr>
<!--@generate-entity-jsp-property-detail@-->







			</table>
		</div>
	</div>
</div>