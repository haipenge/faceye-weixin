<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/component/weixin/account/account.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/account/account.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<c:choose>
				<c:when test="${empty account.id}">
					<fmt:message key="weixin.account.add"></fmt:message>
				</c:when>
				<c:otherwise>
					<fmt:message key="weixin.account.edit"></fmt:message>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="content">
		<form:form action="/weixin/account/save" method="post" role="form" cssClass="form-horizontal" commandName="account">
			<form:hidden path="id" />
			<fieldset>
			<div class="form-group">
					<label class="col-md-2 control-label" for="name"> <spring:message code="weixin.account.name" />
					</label>
					<div class="col-md-6">
						<form:input path="name" cssClass="form-control" />
						<form:errors path="name" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="appId"> <spring:message code="weixin.account.appId" />
					</label>
					<div class="col-md-6">
						<form:input path="appId" cssClass="form-control" />
						<form:errors path="appId" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="secret"> <spring:message code="weixin.account.secret" />
					</label>
					<div class="col-md-6">
						<form:input path="secret" cssClass="form-control" />
						<form:errors path="secret" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label" for="accountType"> <spring:message code="weixin.account.accountType" />
					</label>
					<div class="col-md-6">
						<form:input path="accountType" cssClass="form-control" />
						<form:errors path="accountType" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label" for="weixinName"> <spring:message code="weixin.account.weixinName" />
					</label>
					<div class="col-md-6">
						<form:input path="weixinName" cssClass="form-control" />
						<form:errors path="weixinName" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="token"> <spring:message code="weixin.account.token" />
					</label>
					<div class="col-md-6">
						<form:input path="token" cssClass="form-control" />
						<form:errors path="token" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="encodingAesKey"> <spring:message code="weixin.account.encodingAesKey" />
					</label>
					<div class="col-md-6">
						<form:input path="encodingAesKey" cssClass="form-control" />
						<form:errors path="encodingAesKey" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="mchId"> <spring:message code="weixin.account.mchId" />
					</label>
					<div class="col-md-6">
						<form:input path="mchId" cssClass="form-control" />
						<form:errors path="mchId" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="mchKey"> <spring:message code="weixin.account.mchKey" />
					</label>
					<div class="col-md-6">
						<form:input path="mchKey" cssClass="form-control" />
						<form:errors path="mchKey" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="appSecret"> <spring:message code="weixin.account.appSecret" />
					</label>
					<div class="col-md-6">
						<form:input path="appSecret" cssClass="form-control" />
						<form:errors path="appSecret" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="host"> <spring:message code="weixin.account.host" />
					</label>
					<div class="col-md-6">
						<form:input path="host" cssClass="form-control" />
						<form:errors path="host" cssClass="error" />
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