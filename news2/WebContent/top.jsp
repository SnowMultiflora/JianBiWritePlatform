<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.pojo.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	User user=new User();
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="icon/iconfont.css"/>
	<link rel="stylesheet" type="text/css" href="icon2/iconfont.css"/>
<style >

   a:hover{
	
	color: red;
	
}
   a{text-decoration: none;color:white;}
</style>
<script src="js/jquery.js"></script> 
   <script type="text/javascript">
    $(function(){
         //给推出登录添加单击事件
         $("#out").click(function(){
       return window.confirm("你真的要退出吗？");//return如果false(取消)就阻断href
         })
         })
         	
          </script>
</head>
<body>
<div class="top-box w" style="background-color:#5287B9;width:1342px;">

                                  <%
                          Object obj=session.getAttribute("aname");
                                    if( obj==null){
                                  
                                     
                                   %>
                                 <span style="position: absolute;left: 1150px;top:10px;"><a href="Userlogin.jsp"><i style="color:white;"class="iconfont">&#xe685;</i>登录/注册</a></span>
                                   <%
                                    }else{
                                    %>
                                    	<span style="position: absolute;left: 960px;top:10px;"><a href="Userlogin.jsp"><i style="color:white;"class="iconfont">&#xe685;</i>您好：<%=session.getAttribute("aname") %>，欢迎登录</a><a style="position:relative;left:10px;top:10xp;" href="/news2/main.jsp">个人中心</a><a id="out" style="position: relative;left:10px;" href="uos">|退出登录</a></span>
                                    <%
                                    }
                                   %>
								
							
							
							
							

					
		
			</span>
			
			
		
  <div class="sys-logo" style="font-size: 40px;text-shadow: 0 0 2px black;color: white;position: absolute;left: 160px;">简笔</div>
  <div class="sys-logo" style="font-size: 20px;text-shadow: 0 0 2px black;color: white;position: absolute;left: 350px;top: 70px">青少年写作平台</div>
  <form action="search.html" method="get" style="position: absolute;right: 180px;">
     <input  name="search" placeholder="请输入关键词" autocomplete="off" value="<%=request.getAttribute("search")==null?"":request.getAttribute("search")%>"/>
     <input name="p" id="p" type="hidden" complete="off" value="">
     <input type="submit" id="submit" value="搜索"/>
  </form>
  
</div>
</body>
</html>