<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/component/core/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<h5>微信帐户信息</h5>
<p>Weixin oauth 2</p>
<p>WeixinUserInfo is:</p>
<p>nickname is:${weixiUser.nickname }</p>
<p>open id is:${weixinUser.openid}</p>
<p><a href="<c:url value="/setting/shop/home"/>">开始访问</a></p>
<p>Login user is:<sec:authentication property="principal.username" /></p>
</body>
</html>