<%@page import="com.pojo.*"%>
<%@page import="com.action.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	String aid=request.getParameter("aid");
	ActionBean2 actionBean=new ActionBean2();
	User user=actionBean.queryUserById(aid);
	 if(null==user){
		response.sendRedirect("userInfoList.jsp");
		return;
	} 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>修改用户信息</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
</head>
<body>
<div class="main-frame">
<jsp:include page="top.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

function del(){
var aid = $("#aid").val();
var aname=$("#aname").val();
var apwd=$("#apwd").val() ;
		var ipts=["aname"];
	   var lens=[2];
	   var msg=["请输入真实姓名，至少2位"];
       var flag=true;
	   for(var i=0;i<ipts.length;i++){
		   flag =   valiInput(ipts[i],msg[i],lens[i])&&flag;
		   } 
	  
	  
		//发起ajax请求进行用户的修改
				$.post("up", {
					 aid : aid,
					 aname:aname,
					apwd:apwd  
				}, function(data) {
				
				//判断用户是否修改成功
				if("true"==data){
					if (eval(data)) {
						alert("用户修改成功");
						window.location.href = "admin/userInfoList.jsp";
					}else{
					eval(data);
					alert("用户修改失败");
						window.location.href = "admin/updateUser.jsp";
					} 
					}
	})
				
	}
			
	
	
		
	</script>


<div class="right">
<div class="admin">
<h1 class="title">修改用户信息<a href="admin/adminInfoList.jsp" class="back-btn">返回</a></h1>
 <form  id="frm" mothed="post">
   <table>
     <tr><td>登录账号：</td><td><input id="aid" name="aid" readonly="readonly" autocomplete="off" maxlength="10" type="text" value="<%=user.getAid()%>"/></td><td id="err-aid"></td></tr>
     <tr><td>真实姓名：</td><td><input id="aname" name="aname" autocomplete="off" maxlength="20" type="text" value="<%=user.getAname()%>"/></td><td id="err-aname"></td></tr>
     <tr><td>登录密码：</td><td><input id="apwd" name="apwd" autocomplete="off" maxlength="20" type="text" value="<%=user.getApwd() %>"/></td><td id="err-aname"></td></tr>
     <tr><td></td><td><a class="btn" onclick="del();"   href="javascript:void(0)">保存</a></td></tr> 
   </table>
 </form>
 </div>
 </div>
 </div>
 <jsp:include page="footer.jsp"></jsp:include>
 <script type="text/javascript">
   function valiInput(id,msg,n){
	   var val=document.getElementById(id).value;
	   if(val==""||val.length<n){
		   document.getElementById("err-"+id).innerHTML="<span class='err'>"+msg+"</span>";
		   return false;
		   }else{
			   document.getElementById("err-"+id).innerHTML="<span class='success'>验证通过</span>";
			   return true;
			   }
	   }
   function valiPwd(){
	   if(document.getElementById("apwd").value!=document.getElementById("reapwd").value){
		   document.getElementById("err-reapwd").innerHTML="<span class='err'>两次密码不一致</span>";
		   return false;
		   }
	   return true;
	   }
   function startPost(){
	   
   }
 </script>
</body>
</html>