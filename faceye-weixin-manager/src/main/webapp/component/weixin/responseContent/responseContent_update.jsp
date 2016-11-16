<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/component/weixin/responseContent/responseContent.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/responseContent/responseContent.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<c:choose>
				<c:when test="${empty responseContent.id}">
					<fmt:message key="weixin.responseContent.add"></fmt:message>
				</c:when>
				<c:otherwise>
					<fmt:message key="weixin.responseContent.edit"></fmt:message>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="content">
		<form:form action="/weixin/responseContent/save" method="post" role="form" cssClass="form-horizontal"
			commandName="responseContent">
			<form:hidden path="id" />
			<fieldset>
				<div class="form-group">
					<label class="col-md-2 control-label" for="name"> <spring:message code="weixin.responseContent.name" />
					</label>
					<div class="col-md-6">
						<form:input path="name" cssClass="form-control" />
						<form:errors path="name" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="name"> <spring:message code="weixin.responseType" />
					</label>
					<div class="col-md-6">
						<form:select path="responseType.id" cssClass="form-control">
							<form:options items="${responseTypes}" itemValue="id" itemLabel="name" />
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="name"> <spring:message code="weixin.responseMessageType" />
					</label>
					<div class="col-md-6">
						<form:select path="responseMessageType.id" cssClass="form-control">
							<form:options items="${responseMessageTypes}" itemValue="id" itemLabel="name" />
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label" for="content"> <spring:message code="weixin.responseContent.content" />
					</label>
					<div class="col-md-6">
						<form:textarea path="content" cssClass="form-control" />
						<form:errors path="content" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="isEnabled"> <spring:message
							code="weixin.responseContent.isEnabled" />
					</label>
					<div class="col-md-6">
					<label class="radio-inline"><form:radiobutton path="isEnabled" value="true" /> <fmt:message
								key="weixin.responseContent.isEnabled.yes" /> </label> 
								<label class="radio-inline"><form:radiobutton path="isEnabled" value="false"/> <fmt:message
								key="weixin.responseContent.isEnabled.no" /> </label> 
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