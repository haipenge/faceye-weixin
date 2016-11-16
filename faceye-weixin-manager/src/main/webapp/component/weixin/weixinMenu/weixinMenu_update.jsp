<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/component/weixin/weixinMenu/weixinMenu.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/component/weixin/weixinMenu/weixinMenu.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<c:choose>
				<c:when test="${empty weixinMenu.id}">
					<fmt:message key="weixin.weixinMenu.add"></fmt:message>
				</c:when>
				<c:otherwise>
					<fmt:message key="weixin.weixinMenu.edit"></fmt:message>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div class="content">
		<form:form action="/weixin/weixinMenu/save" method="post" role="form"
			cssClass="form-horizontal" commandName="weixinMenu">
			<form:hidden path="id" />
			<form:hidden path="account.id" />
			<fieldset>
				<div class="form-group">
					<label class="col-md-2 control-label" for="name"> <spring:message
							code="weixin.weixinMenu.name" />
					</label>
					<div class="col-md-6">
						<form:input path="name" cssClass="form-control" />
						<form:errors path="name" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="type"> <spring:message
							code="weixin.weixinMenu.type" />
					</label>
					<div class="col-md-6">
						<form:select path="type" cssClass="form-control">
							<form:option value="0" label="Select Menu Type" />
							<form:options items="${types}" itemValue="key" itemLabel="name" />
						</form:select>
						<form:errors path="type" cssClass="error" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label" for="weixinMenuId"> <spring:message
							code="weixin.weixinMenu.top.level" />
					</label>
					<div class="col-md-6">
						<form:select path="weixinMenuId" cssClass="form-control">
							<form:option  value="0" label="Select Top Menu" />
							<form:options items="${roots}" itemValue="id" itemLabel="name" />
						</form:select>
						<form:errors path="weixinMenuId" cssClass="error" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label" for="key"> <spring:message
							code="weixin.weixinMenu.key" />
					</label>
					<div class="col-md-6">
						<form:input path="key" cssClass="form-control" />
						<form:errors path="key" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="url"> <spring:message
							code="weixin.weixinMenu.url" />
					</label>
					<div class="col-md-6">
						<form:input path="url" cssClass="form-control" />
						<form:errors path="url" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="mediaId"> <spring:message
							code="weixin.weixinMenu.mediaId" />
					</label>
					<div class="col-md-6">
						<form:input path="mediaId" cssClass="form-control" />
						<form:errors path="mediaId" cssClass="error" />
					</div>
				</div>
				<form:hidden path="orderIndex"/>
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