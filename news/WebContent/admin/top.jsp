<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- 主页面 -->
<html>
<head>
    <base href="<%=basePath%>">
    </head>
    <body>
<div style="vertical-align: middle"class="top">
  <h1 >简笔写作后台管理中心</h1>
  <span style="font-size:20px;font-weight:bolder;color:white;position:relative;left:800px;top:0px;">当前在线人数:${applicationScope.count}</span>
  </div>
  </body>
 </html>