<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/weixinUser/weixinUser.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/weixinUser/weixinUser.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<c:choose>
				<c:when test="${empty weixinUser.id}">
					<fmt:message key="weixin.weixinUser.add"></fmt:message>
				</c:when>
				<c:otherwise>
					<fmt:message key="weixin.weixinUser.edit"></fmt:message>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="content">
	<form:form action="/weixin/weixinUser/save" method="post" role="form" cssClass="form-horizontal"
			commandName="weixinUser">
			<form:hidden path="id"/>
			<fieldset>
				<div class="form-group">
	<label class="col-md-2 control-label" for="openid"> <spring:message
			code="weixin.weixinUser.openid"/>
	</label>
	<div class="col-md-6">
		<form:input path="openid" cssClass="form-control"/>
		<form:errors path="openid" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="nickname"> <spring:message
			code="weixin.weixinUser.nickname"/>
	</label>
	<div class="col-md-6">
		<form:input path="nickname" cssClass="form-control"/>
		<form:errors path="nickname" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="sex"> <spring:message
			code="weixin.weixinUser.sex"/>
	</label>
	<div class="col-md-6">
		<form:input path="sex" cssClass="form-control"/>
		<form:errors path="sex" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="province"> <spring:message
			code="weixin.weixinUser.province"/>
	</label>
	<div class="col-md-6">
		<form:input path="province" cssClass="form-control"/>
		<form:errors path="province" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="city"> <spring:message
			code="weixin.weixinUser.city"/>
	</label>
	<div class="col-md-6">
		<form:input path="city" cssClass="form-control"/>
		<form:errors path="city" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="country"> <spring:message
			code="weixin.weixinUser.country"/>
	</label>
	<div class="col-md-6">
		<form:input path="country" cssClass="form-control"/>
		<form:errors path="country" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="headimgurl"> <spring:message
			code="weixin.weixinUser.headimgurl"/>
	</label>
	<div class="col-md-6">
		<form:input path="headimgurl" cssClass="form-control"/>
		<form:errors path="headimgurl" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="privilege"> <spring:message
			code="weixin.weixinUser.privilege"/>
	</label>
	<div class="col-md-6">
		<form:input path="privilege" cssClass="form-control"/>
		<form:errors path="privilege" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="unionid"> <spring:message
			code="weixin.weixinUser.unionid"/>
	</label>
	<div class="col-md-6">
		<form:input path="unionid" cssClass="form-control"/>
		<form:errors path="unionid" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="language"> <spring:message
			code="weixin.weixinUser.language"/>
	</label>
	<div class="col-md-6">
		<form:input path="language" cssClass="form-control"/>
		<form:errors path="language" cssClass="error"/>
	</div>
</div>
<div class="form-group">
	<label class="col-md-2 control-label" for="createDate"> <spring:message
			code="weixin.weixinUser.createDate"/>
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