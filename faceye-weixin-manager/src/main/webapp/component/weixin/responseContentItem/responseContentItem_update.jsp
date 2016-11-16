<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/responseContentItem/responseContentItem.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/responseContentItem/responseContentItem.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<c:choose>
				<c:when test="${empty responseContentItem.id}">
					<fmt:message key="weixin.responseContentItem.add"></fmt:message>
				</c:when>
				<c:otherwise>
					<fmt:message key="weixin.responseContentItem.edit"></fmt:message>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="content">
		<form:form action="/weixin/responseContentItem/save" method="post" role="form" cssClass="form-horizontal"
			commandName="responseContentItem">
			<form:hidden path="id" />
			<fieldset>
				<div class="form-group">
					<label class="col-md-2 control-label" for="name"> <spring:message code="weixin.responseContentItem.name" />
					</label>
					<div class="col-md-6">
						<form:input path="name" cssClass="form-control" />
						<form:errors path="name" cssClass="error" />
					</div>
				</div>
				<c:choose>
					<c:when test="${not empty param.responseContentId}">
                       <form:hidden path="responseContent.id" value="${param.responseContentId}"/>
					</c:when>
					<c:otherwise>
						<div class="form-group">
							<label class="col-md-2 control-label" for="name"> <spring:message code="weixin.responseContent" />
							 
							</label>
							<div class="col-md-6">
								<form:select path="responseContent.id" cssClass="form-control">
									<form:options items="${responseContents}" itemValue="id" itemLabel="name" />
								</form:select>
							</div>
						</div>
					</c:otherwise>
				</c:choose>


				<div class="form-group">
					<label class="col-md-2 control-label" for="remark"> <spring:message
							code="weixin.responseContentItem.remark" />
					</label>
					<div class="col-md-6">
						<form:textarea path="remark" cssClass="form-control" />
						<form:errors path="remark" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="url"> <spring:message code="weixin.responseContentItem.url" />
					</label>
					<div class="col-md-6">
						<form:input path="url" cssClass="form-control" />
						<form:errors path="url" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="picUrl"> <spring:message
							code="weixin.responseContentItem.picUrl" />
					</label>
					<div class="col-md-6">
						<form:input path="picUrl" cssClass="form-control" />
						<form:errors path="picUrl" cssClass="error" />
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