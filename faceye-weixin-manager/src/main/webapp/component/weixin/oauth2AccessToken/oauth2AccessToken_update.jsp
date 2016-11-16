<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/oauth2AccessToken/oauth2AccessToken.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/oauth2AccessToken/oauth2AccessToken.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<c:choose>
				<c:when test="${empty oauth2AccessToken.id}">
					<fmt:message key="weixin.oauth2AccessToken.add"></fmt:message>
				</c:when>
				<c:otherwise>
					<fmt:message key="weixin.oauth2AccessToken.edit"></fmt:message>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="content">
	<form:form action="/weixin/oauth2AccessToken/save" method="post" role="form" cssClass="form-horizontal"
			commandName="oauth2AccessToken">
			<form:hidden path="id"/>
			<fieldset>
				<div class="form-group">
	<label class="col-md-2 control-label" for="account"> <spring:message
			code="weixin.oauth2AccessToken.account"/>
	</label>
	<div class="col-md-6">
		<form:input path="account" cssClass="form-control"/>
		<form:errors path="account" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="openid"> <spring:message
			code="weixin.oauth2AccessToken.openid"/>
	</label>
	<div class="col-md-6">
		<form:input path="openid" cssClass="form-control"/>
		<form:errors path="openid" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="accessToken"> <spring:message
			code="weixin.oauth2AccessToken.accessToken"/>
	</label>
	<div class="col-md-6">
		<form:input path="accessToken" cssClass="form-control"/>
		<form:errors path="accessToken" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="refreshAccessToken"> <spring:message
			code="weixin.oauth2AccessToken.refreshAccessToken"/>
	</label>
	<div class="col-md-6">
		<form:input path="refreshAccessToken" cssClass="form-control"/>
		<form:errors path="refreshAccessToken" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="expiresIn"> <spring:message
			code="weixin.oauth2AccessToken.expiresIn"/>
	</label>
	<div class="col-md-6">
		<form:input path="expiresIn" cssClass="form-control"/>
		<form:errors path="expiresIn" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="unionid"> <spring:message
			code="weixin.oauth2AccessToken.unionid"/>
	</label>
	<div class="col-md-6">
		<form:input path="unionid" cssClass="form-control"/>
		<form:errors path="unionid" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="openid"> <spring:message
			code="weixin.oauth2AccessToken.openid"/>
	</label>
	<div class="col-md-6">
		<form:input path="openid" cssClass="form-control"/>
		<form:errors path="openid" cssClass="error"/>
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