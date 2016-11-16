<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/msg/msg.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/msg/msg.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<c:choose>
				<c:when test="${empty msg.id}">
					<fmt:message key="weixin.msg.add"></fmt:message>
				</c:when>
				<c:otherwise>
					<fmt:message key="weixin.msg.edit"></fmt:message>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="content">
	<form:form action="/weixin/msg/save" method="post" role="form" cssClass="form-horizontal"
			commandName="msg">
			<form:hidden path="id"/>
			<fieldset>
				<div class="form-group">
	<label class="col-md-2 control-label" for="toUserName"> <spring:message
			code="weixin.msg.toUserName"/>
	</label>
	<div class="col-md-6">
		<form:input path="toUserName" cssClass="form-control"/>
		<form:errors path="toUserName" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="fromUserName"> <spring:message
			code="weixin.msg.fromUserName"/>
	</label>
	<div class="col-md-6">
		<form:input path="fromUserName" cssClass="form-control"/>
		<form:errors path="fromUserName" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="msgType"> <spring:message
			code="weixin.msg.msgType"/>
	</label>
	<div class="col-md-6">
		<form:input path="msgType" cssClass="form-control"/>
		<form:errors path="msgType" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="msgId"> <spring:message
			code="weixin.msg.msgId"/>
	</label>
	<div class="col-md-6">
		<form:input path="msgId" cssClass="form-control"/>
		<form:errors path="msgId" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="content"> <spring:message
			code="weixin.msg.content"/>
	</label>
	<div class="col-md-6">
		<form:input path="content" cssClass="form-control"/>
		<form:errors path="content" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="createTime"> <spring:message
			code="weixin.msg.createTime"/>
	</label>
	<div class="col-md-6">
		<form:input path="createTime" cssClass="form-control"/>
		<form:errors path="createTime" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="location_x"> <spring:message
			code="weixin.msg.location_x"/>
	</label>
	<div class="col-md-6">
		<form:input path="location_x" cssClass="form-control"/>
		<form:errors path="location_x" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="location_y"> <spring:message
			code="weixin.msg.location_y"/>
	</label>
	<div class="col-md-6">
		<form:input path="location_y" cssClass="form-control"/>
		<form:errors path="location_y" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="scale"> <spring:message
			code="weixin.msg.scale"/>
	</label>
	<div class="col-md-6">
		<form:input path="scale" cssClass="form-control"/>
		<form:errors path="scale" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="title"> <spring:message
			code="weixin.msg.title"/>
	</label>
	<div class="col-md-6">
		<form:input path="title" cssClass="form-control"/>
		<form:errors path="title" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="url"> <spring:message
			code="weixin.msg.url"/>
	</label>
	<div class="col-md-6">
		<form:input path="url" cssClass="form-control"/>
		<form:errors path="url" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="description"> <spring:message
			code="weixin.msg.description"/>
	</label>
	<div class="col-md-6">
		<form:input path="description" cssClass="form-control"/>
		<form:errors path="description" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="picUrl"> <spring:message
			code="weixin.msg.picUrl"/>
	</label>
	<div class="col-md-6">
		<form:input path="picUrl" cssClass="form-control"/>
		<form:errors path="picUrl" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="mediaId"> <spring:message
			code="weixin.msg.mediaId"/>
	</label>
	<div class="col-md-6">
		<form:input path="mediaId" cssClass="form-control"/>
		<form:errors path="mediaId" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="thumbMediaId"> <spring:message
			code="weixin.msg.thumbMediaId"/>
	</label>
	<div class="col-md-6">
		<form:input path="thumbMediaId" cssClass="form-control"/>
		<form:errors path="thumbMediaId" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="format"> <spring:message
			code="weixin.msg.format"/>
	</label>
	<div class="col-md-6">
		<form:input path="format" cssClass="form-control"/>
		<form:errors path="format" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="event"> <spring:message
			code="weixin.msg.event"/>
	</label>
	<div class="col-md-6">
		<form:input path="event" cssClass="form-control"/>
		<form:errors path="event" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="latitude"> <spring:message
			code="weixin.msg.latitude"/>
	</label>
	<div class="col-md-6">
		<form:input path="latitude" cssClass="form-control"/>
		<form:errors path="latitude" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="longitude"> <spring:message
			code="weixin.msg.longitude"/>
	</label>
	<div class="col-md-6">
		<form:input path="longitude" cssClass="form-control"/>
		<form:errors path="longitude" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="precision"> <spring:message
			code="weixin.msg.precision"/>
	</label>
	<div class="col-md-6">
		<form:input path="precision" cssClass="form-control"/>
		<form:errors path="precision" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="eventKey"> <spring:message
			code="weixin.msg.eventKey"/>
	</label>
	<div class="col-md-6">
		<form:input path="eventKey" cssClass="form-control"/>
		<form:errors path="eventKey" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="ticket"> <spring:message
			code="weixin.msg.ticket"/>
	</label>
	<div class="col-md-6">
		<form:input path="ticket" cssClass="form-control"/>
		<form:errors path="ticket" cssClass="error"/>
	</div>
</div>
<!--@generate-entity-jsp-property-update@-->






















				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
						<button type="submit" class="btn btn-primary">
							<fmt:message key="global.submit.save"></fmt:message>
						</button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
</div>