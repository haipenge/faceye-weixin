<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/jsapiTicket/jsapiTicket.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/jsapiTicket/jsapiTicket.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<c:choose>
				<c:when test="${empty jsapiTicket.id}">
					<fmt:message key="weixin.jsapiTicket.add"></fmt:message>
				</c:when>
				<c:otherwise>
					<fmt:message key="weixin.jsapiTicket.edit"></fmt:message>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="content">
	<form:form action="/weixin/jsapiTicket/save" method="post" role="form" cssClass="form-horizontal"
			commandName="jsapiTicket">
			<form:hidden path="id"/>
			<fieldset>
				<div class="form-group">
	<label class="col-md-2 control-label" for="ticket"> <spring:message
			code="weixin.jsapiTicket.ticket"/>
	</label>
	<div class="col-md-6">
		<form:input path="ticket" cssClass="form-control"/>
		<form:errors path="ticket" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="expiresIn"> <spring:message
			code="weixin.jsapiTicket.expiresIn"/>
	</label>
	<div class="col-md-6">
		<form:input path="expiresIn" cssClass="form-control"/>
		<form:errors path="expiresIn" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="account"> <spring:message
			code="weixin.jsapiTicket.account"/>
	</label>
	<div class="col-md-6">
		<form:input path="account" cssClass="form-control"/>
		<form:errors path="account" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="lastRefreshDate"> <spring:message
			code="weixin.jsapiTicket.lastRefreshDate"/>
	</label>
	<div class="col-md-6">
		<form:input path="lastRefreshDate" cssClass="form-control"/>
		<form:errors path="lastRefreshDate" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="createDate"> <spring:message
			code="weixin.jsapiTicket.createDate"/>
	</label>
	<div class="col-md-6">
		<form:input path="createDate" cssClass="form-control"/>
		<form:errors path="createDate" cssClass="error"/>
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