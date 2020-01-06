<%@page import="com.action.*"%>
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
<title>用户信息列表</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
</head>
<body>
<div class="main-frame">
<jsp:include page="top.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="right">
	<div class="admin">
		<h1 class="title">用户信息列表<a href="admin/welcome.jsp" class="back-btn">返回主页</a></h1>
		<table class="tab" cellspacing="0">
		 <tr><td>选择</td><td class="text-center">序号</td><td class="text-center">登录账号</td><td class="text-center">真实姓名</td><td class="text-center">联系方式</td><td class="text-center">QQ号</td></tr>
		 <%
		   ActionBean2 actionBean = new ActionBean2();
		   out.println(actionBean.queryuserAll());
		 %>
		 <tr><td colspan="4" style="border-bottom:0">
		 <a class="btn" href="javascript:void(0)" id="update-btn" onclick="updateAdmin();">修改</a>
		 <a class="btn" href="javascript:void(0)" id="delete-btn" onclick="deleteAdmin();">删除</a>
		 </td></tr>
		</table>	
	</div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
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
	function updateAdmin(){		
		var obj = selectedRow();
		if(obj==null)return;	
		location="admin/updateUser.jsp?aid="+obj.value;
		}
	function deleteAdmin(){
		var obj = selectedRow();
		if(obj==null)return;
		if(confirm("您确认要删除当前用户吗？")){
			location="/news/ds?aid="+obj.value;
			}	
		}
	</script>
</body>
</html>