<%@page import="com.pojo.NewsClass"%>
<%@page import="com.action.ActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/"; 
	ActionBean actionBean=new ActionBean();
	String cid=request.getParameter("cid");
	NewsClass newsClass=actionBean.queryClassById(cid);
	if(newsClass==null){
		response.sendRedirect("newsClassList.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>修改类别</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
</head>
<body>
<div class="admin">
 <form action="admin/UpdateClassServlet" id="frm" mothed="post">
  <input type="hidden" value="<%=newsClass.getCid() %>" name="cid"/>
   <table>
     <tr><td>类别：</td><td><input id="cname" name="cname" autocomplete="off" maxlength="50" type="text"  value="<%=newsClass.getCname()%>"/></td><td id="err-cname"></td></tr>
     <tr><td></td><td><a class="btn" onclick="startPost();" href="javascript:void(0)">保存</a></td></tr> 
   </table>
 </form>
 </div>
 <script type="text/javascript" src="<%=basePath%>js/newsClass.js">
 </script>
</body>
</html>