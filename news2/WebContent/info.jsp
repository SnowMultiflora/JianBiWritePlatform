<%@page import="com.dao.SqlHelper"%>
<%@page import="com.pojo.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    SqlHelper sql=new SqlHelper();
      String aid=(String)session.getAttribute("aid");
      User us=sql.selUser(aid);
 %>
<!DOCTYPE html>
<!-- 侧页面 -->
<html lang="zh-cn">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>修改个人信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script type="text/javascript">
    function upset() {
    	var aid = $("#aid").val();
    	var phone=$("#phone").val();
    	var city=$("#city").val() ;
    	var school=$("#school").val() ;
    	var grade=$("#grade").val() ;
	
    	var qq=$("#qq").val() ;
    		//发起ajax请求进行用户的修改
    					$.post("Upsetuserservlet", {
    						 aid : aid,
    						 phone:phone,
    						 school:school,
    						 grade:grade,
    						  city:city,
    						  qq:qq
    					}, function(data) {
    				
    					//判断用户是否修改成功
    					if("true"==data){
    						eval(data);
    							alert("修改成功");
    							window.location.href = "/news2/info2.jsp";
    						}else if("false"==data){
    						eval(data);
    						alert("修改失败");
    							window.location.href = "/news2/info2.jsp";
    						} else{
    						eval(data);
    						alert("不能为空");
    						}
    						
    		})
    					
    		}
    
</script>
<script src="js/pintuer.js">

</script>
</head>
<body>
	<div class="panel admin-panel" style="height: 800px;">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 修改个人信息</strong>
		</div>
		
		<div class="body-content">
			<form method="post" class="form-x" action="">
			
				<div class="form-group">
					<div class="label">
						<label>用户ID：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" id="aid"  name="stitle" value="<%=us.getAid() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>用户姓名：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" id="aname" name="stitle"
							value="<%=us.getAname() %>" />
						<div class="tips"></div>
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="label">
						<label>联系方式：</label>
					</div>
					<div class="field">
						<input  style="width:25%; float:left;"
							type="text" class="input" id="phone" name="stitle"
							value="<%=us.getPhone() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>	QQ：</label>
					</div>
					<div class="field">
						<input  style="width:25%; float:left;"
							type="text" class="input" id="qq" name="stitle"
							value="<%=us.getQq() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>所在地：</label>
					</div>
					<div class="field">
						<input  style="width:25%; float:left;"
							type="text" class="input" id="city" name="stitle"
							value="<%=us.getCity() %>" placeholder="省/市" />
						<div class="tips"></div>
					</div>
				</div><div class="form-group">
					<div class="label">
						<label>学校：</label>
					</div>
					<div class="field">
						<input  style="width:25%; float:left;"
							type="text" class="input" id="school" name="stitle"
							value="<%=us.getSchool() %>" />
						<div class="tips"></div>
					</div>
				</div><div class="form-group">
					<div class="label">
						<label>年级：</label>
					</div>
					<div class="field">
						<input  style="width:25%; float:left;"
							type="text" class="input" id="grade" name="stitle"
							value="<%=us.getGrade() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<input   style="background-color:blue;width: 100px;height: 50px;color:white;font-weight: bold;position: absolute;left:200px;" type="button" value="提交" onclick="upset()"/>
				
			</form>
		</div>
	</div>
</body>
</html>
