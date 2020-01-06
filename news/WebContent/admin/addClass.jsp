<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>添加文章类别</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

function insert(){
var aid = $("#cname").val();

	
	var cname=document.getElementById("cname").value;
	   if(cname==""){
		   document.getElementById("err-cname").innerHTML="<span class='err'>请输入类别名称</span>";
		  
		   }
		//发起ajax请求进行用户的修改
				$.post("ic", {
					cname:cname
				}, function(data) {
				//判断用户是否修改成功
				if("true"==data){
					eval(data);
						alert("增加文章类别成功");
						window.location.href = "/news/admin/newsClassList.jsp";
					}else if("false"==data){
					eval(data);
					alert("增加文章类别失败");
						window.location.href = "/news/admin/newsClassList.jsp";
					} 
					
	})
				
	}
			
	
	
		
	</script>
</head>
<body>
<div class="main-frame">
<jsp:include page="top.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="right">
<div class="admin">
<h1 class="title">添加文章类别<a href="admin/newsClassList.jsp" class="back-btn">返回</a></h1>
 <form  id="frm" mothed="post">
   <table>
     <tr><td>文章类别：</td><td><input id="cname" name="cname" autocomplete="off" maxlength="50" type="text"/></td><td id="err-cname"></td></tr>
     <tr><td></td><td><a class="btn" onclick=" insert();" href="javascript:void(0)">保存</a></td></tr> 
   </table>
 </form>
 </div>
 </div>
 </div>
 <jsp:include page="footer.jsp"></jsp:include>
 <script type="text/javascript" src="<%=basePath%>js/newsClass.js"></script>
</body>
</html>