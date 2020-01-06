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
<html lang="zh-cn">
<head>
<base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>个人中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin2.css">
 
    <script src="js/jquery.js"></script>   
 
   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
  <%if(us.getPhotoName()==null){ %>
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />
    <% }%>
    <%if(us.getPhotoName()!=null){ %>
    <h1><img src="upload/<%=us.getPhotoName() %>" class="radius-circle rotate-hover" height="60" width="60" alt="" />
    <% }%>
    <a style="color:white;" href="/news2/Index.html">简笔</a><span style="position: absolute;left:150px;">|个人中心</span></h1>
  </div>

  <span style="position:relative;left:500px;top:20px;font-size:15px;color:white;">当前用户:<%=session.getAttribute("aname") %></span>
  <div class="head-l" style="position:relative;left:900px;"><a  id="out" class="button button-little bg-red" href="uos"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
   <li><a href="xuzhi.jsp" target="right"><span class="icon-caret-right"></span>投稿须知</a></li>
    <li><a href="info2.jsp" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
    <li><a href="pass.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    <li><a href="column.jsp" target="right"><span class="icon-caret-right"></span>投稿</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>我的投稿</h2>
  <ul>

    <li><a href="add.jsp" target="right"><span class="icon-caret-right"></span>已投稿</a></li>
  
     <li><a href="cate.jsp" target="right"><span class="icon-caret-right"></span>已审核</a></li> 
      <li><a href="cate1.jsp" target="right"><span class="icon-caret-right"></span>被退回</a></li>
            <li><a href="cate2.jsp" target="right"><span class="icon-caret-right"></span>草稿箱</a></li>                        
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
  //给推出登录添加单击事件
    $("#out").click(function(){
 	 return window.confirm("你真的要退出吗？");//return如果false(取消)就阻断href
    });
    if(window !=top){
	top.location.href="main.jsp";
}
});
</script>
<ul class="bread">
  <li><a href="xuzhi.jsp" target="right" class="icon-home"> 首页</a></li>
  <li><a   href="xuzhi.jsp" id="a_leader_txt">投稿须知</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>

</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="xuzhi.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">

</div>
</body>
</html>