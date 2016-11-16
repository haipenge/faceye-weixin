<%@ include file="/component/core/taglib/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/component/weixin/account/account.css"/>" />
<script type="text/javascript" src="<c:url value="/js/component/weixin/account/account.js"/>"></script>
<div class="block-flat">
	<div class="header">
		<h3>
			<fmt:message key="weixin.account.detail"></fmt:message>
		</h3>
	</div>
	<div class="content">
		<div classs="table-responsive">
			<input type="hidden" value="${account.id}" name="accountId">
			<table class="table table-bordered">
				<tr>
					<td class="bg-title-col width-p-20"><fmt:message key="weixin.account.name"></fmt:message></td>
					<td>${account.name}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.appId"></fmt:message></td>
					<td>${account.appId}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.secret"></fmt:message></td>
					<td>${account.secret}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.lastGotAccessTokenDate"></fmt:message></td>
					<td><fmt:formatDate value="${account.lastGotAccessTokenDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.accountType"></fmt:message></td>
					<td>${account.accountType}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.accessToken"></fmt:message></td>
					<td>${account.accessToken}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.weixinName"></fmt:message></td>
					<td>${account.weixinName}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.token"></fmt:message></td>
					<td>${account.token}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.encodingAesKey"></fmt:message></td>
					<td>${account.encodingAesKey}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.mchId"></fmt:message></td>
					<td>${account.mchId}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.mchKey"></fmt:message></td>
					<td>${account.mchKey}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.appSecret"></fmt:message></td>
					<td>${account.appSecret}</td>
				</tr>
				<tr>
					<td  class="bg-title-col width-p-20"><fmt:message key="weixin.account.host"></fmt:message></td>
					<td>${account.host}</td>
				</tr>
				<tr>
				   <td  class="bg-title-col width-p-20">Weixin api receive url</td>
				   <td>/weixin/api/receive?accountId=${account.id}</td>
				</tr>
				<!--@generate-entity-jsp-property-detail@-->
			</table>
		</div>
	</div>
	<div id="msg"></div>
	<div class="content">
		<button type="button" class="btn btn-sm btn-primary" id="refresh-token">
			<fmt:message key="weixin.account.refresh.token" />
		</button>
		<a class="btn btn-sm btn-primary" href="/weixin/responseContent/home?EQ|account.$id=${account.id}"><fmt:message key="weixin.responseContent.manager"></fmt:message></a> 
		<a class="btn btn-sm btn-primary"
			herf="<c:url value="/weixin/weixinUser/home?EQ|account.$id=${account.id}"/>"><fmt:message key="weixin.weixinUser" /></a> 
		<a class="btn btn-sm btn-primary"
 			href="<c:url value="/weixin/weixinMenu/home?EQ|account.$id=${account.id}"/>"><fmt:message key="weixin.weixinMenu" /></a> 
 		<a class="btn btn-sm btn-primary"
			href="<c:url value="/weixin/account/edit/${account.id}"/>"> <fmt:message key="global.edit"></fmt:message></a>
		 <a class="btn btn-sm btn-primary" href="<c:url value="/weixin/account/remove/${account.id}"/>">
			<fmt:message key="global.remove"></fmt:message>
		</a>
	</div>
</div>