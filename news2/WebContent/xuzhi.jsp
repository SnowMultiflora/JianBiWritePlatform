<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE html>
<html>
	<head>
	<base href="<%=basePath%>"/>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
	
		<div class="inbox">
				<div class="item show">
					<h1><span style="position: relative;left:500px;" >投稿流程</span></h1>
					<dl class="dl_cont" style="position: relative;left:100px;line-height: 50px;" >
						<dt style="color: red;"><i></i>账号登录</dt>
						<dd>无论是主动登录还是注册完成都会进入个人中心页面，可以在这里点击投稿开始写文字了。</dd>
						<dd>账号密码登录：打开简笔网（localhost:8080/news2/Index.html）→登录→输入账号密码,验证码→登录成功</dd>
						
						<dt style="color: red;"><i></i>文章发布指南</dt>
						<dd>①成功登录后进入个人中心首页，点击左侧<a href="column.jsp" class="btn"><i></i>投稿</a>按钮，即可进行文章发布；</dd>
						<dd>②进入个人中心首页，点击左侧我的投稿，对已发表文章进行相关操作。</dd>
						<dt style="color: red;"><i></i>等待审核</dt>
						<dd>这些都完成之后文章就已经提交到我们的管理员手里了，我们会在24小时内审核您的作品，如遇节假日延迟48个小时。</dd>
						<dt style="color: red;"><i></i>投稿须知</dt>
						<dd>1、文章必须原创，请勿抄袭。</dd>
						<dd>2、文章内容须积极向上，无敏感词，无广告宣传。</dd>
						<dd>3、文章格式须正确，请使用正确文字和标点符号。</dd>
						<dd>4、文章内容须完整，结构正确，中心思想明确，语句通顺(但避免口语化）。</dd>
						<dd>5、投稿人信息填写只包括作者姓名；（为保护您的个人隐私，请勿填写个人信息或过于详细的个人信息）</dd>
					</dl>
				</div>
	</body>
</html>
