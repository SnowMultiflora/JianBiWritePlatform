<%@page import="com.action.ActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息列表</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
</head>
<body>
<div class="main-frame">
<jsp:include page="top.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="right">
	<div class="admin">
		<h1 class="title">后台主页</h1>
		<div class="welcome">欢迎<%=session.getAttribute("aname") %>使用简笔写作后台管理中心</div>
		
	</div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>