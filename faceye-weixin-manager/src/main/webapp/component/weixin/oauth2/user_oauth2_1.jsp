<%@ include file="/component/core/taglib/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>微信访问授权</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0">
<meta name="keywords" content="微信访问授权" />
<meta name="description" content="" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<p>微信访问授权</p>
	<p>
		<a href="${oauth2Url}">授权使用微信帐户访问</a>
	</p>
	<p>Url is:${oauth2Url}</p>
</body>
</html>