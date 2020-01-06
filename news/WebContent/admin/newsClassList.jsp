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
<title>文章类别管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
</head>
<body>
<div class="main-frame">
<jsp:include page="top.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="right">
	<div class="admin">
		<h1 class="title">文章类别管理<a href="admin/welcome.jsp" class="back-btn">返回主页</a></h1>
		<table class="tab" cellspacing="0">
		 <tr><td style="10px">选择</td><td class="text-center">序号</td><td class="text-center">类别名称</td></tr>
		<%
		   ActionBean actionBean = new ActionBean();
		   out.println(actionBean.queryClassAll());
		 %> 
		 <tr><td colspan="4" style="border-bottom:0"><a class="btn" href="admin/addClass.jsp">增加类别</a>
		 <a class="btn" href="javascript:void(0)" id="update-btn" onclick="updateClass();">修改</a>
		 <a class="btn" href="javascript:void(0)" id="delete-btn" onclick="deleteClass();">删除</a>
		 </td></tr>
		</table>	
	</div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<div class="win-box" id="win-box">
 <h2 class="win-title">修改类别<span onclick="closeClassWindow(0);">&times;</span></h2>
 <iframe src="" id="update-win"></iframe>
</div>
	<script type="text/javascript">
	function selectedRow(){
		var ms=document.getElementsByName("rad");
		var obj=null;
		for(var i=0;i<ms.length;i++){
			if(ms[i].checked){
				obj=ms[i];
				break;
				}
			}
		if(null==obj){
			alert("请选择一行再操作");
			}
		return obj;
		}
	function updateClass(){
		var obj = selectedRow();
		if(obj==null)return;
		updateClassWindow("admin/updateClass.jsp?cid="+obj.value);
		}
	function deleteClass(){
		var obj = selectedRow();
		if(obj==null)return;
		if(confirm("您确认要删除当前类吗？")){
			location="admin/DeleteClassServlet?cid="+obj.value;
			}	
		}
	function updateClassWindow(url){
		document.getElementById("win-box").style.display="block";
		document.getElementById("update-win").src=url;
		}
	function closeClassWindow(f){
		document.getElementById("win-box").style.display="none";
		if(f==1){
			location=location;
			}
		}
	</script>
</body>
</html>