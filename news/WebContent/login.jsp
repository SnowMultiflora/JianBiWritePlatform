<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<!--登录页面  -->
<html lang="lang="en"">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>

<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript">
    	//判断登录页面是不是顶层页面，如果不是则将其设置为顶层页面（解决框架中出现了登录页面）
    	if(window !=top){
    		top.location.href=location.href;
    	}
    </script>
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript"></script>

</head>
<body>

  
<div class="bg"></div>
     <div  class="stage"></div>
	
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:90px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="Ad" method="post">
					<!-- 声明请求处理方法 -->
					<input type="hidden" name="method" value="userLogin" />
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
						    <h1 >简笔</h1></br>
							<h1 >后台管理中心</h1> 

						</div>
						<!-- 声明jstl进行判断 -->
						<c:choose>
							<c:when test="${sessionScope.flag=='loginfalse'}">
								<div style="text-align:center;color:red;">用户名或密码错误</div>
							</c:when>
							<c:when test="${sessionScope.flag=='regSuccess'}">
								<div style="text-align:center;color:red;">用户注册成功</div>
							</c:when>
							<c:when test="${sessionScope.flag=='yzmfalse'}">
								<div style="text-align:center;color:red;">验证码输入错误</div>
							</c:when>

						</c:choose>
						<!-- 销毁session -->
				  <% session.invalidate();%> 
				 <%--  <c:remove var="flag" scope="session" />  --%>
						<!--jstl清除session数据 -->
						<div class="panel-body"
							style="padding:30px; padding-bottom:10px; padding-top:10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="aid"
										placeholder="登录账号" data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="apwd"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<input type="text" class="input input-big" name="code"  
										placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码"  onblur="checkYZM()"/>
									
									 <img src="yzm.jsp" alt="" width="100" height="32" name="checkname"
										class="passcode" style="height:43px;cursor:pointer;"
										onclick="this.src=this.src+'?'"> <span id="pcspan"></span>
								</div>
							</div>
						</div>
						<div style="padding:30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录">
						</div>
						
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>