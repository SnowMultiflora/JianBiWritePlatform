<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
  <!-- 声明js代码域 -->
  
<script src="js/jquery.js"></script> 
   <script type="text/javascript">
    $(function(){
         //给推出登录添加单击事件
         $("#out").click(function(){
       return window.confirm("你真的要退出吗？");//return如果false(取消)就阻断href
         })
         //给给管理员管理添加单击事件
         $("#ad").click(function(){
         //发起ajax请求进行用户的删除
				$.post("/news/admin/adminInfoList.jsp", {}, function(data) {
				//判断用户是否是权限不足
				if("power"==data){
				  alert("权限不足");
				}else  {
						
						window.location.href = "/news/admin/adminInfoList.jsp";
					}
					
	
				});
	
         
       
         })
         //给用户管理添加单击事件
         $("#user").click(function(){
         //发起ajax请求进行用户的删除
				$.post("/news/admin/userInfoList.jsp", {}, function(data) {
				//判断用户是否是权限不足
				if("power"==data){
				  alert("权限不足");
				}else  {
						
						window.location.href = "/news/admin/userInfoList.jsp";
					}
					
	
				});
	
         
       
         })
          //给给管理员管理添加单击事件
         $("#nc").click(function(){
         //发起ajax请求进行用户的删除
				$.post("/news/admin/newsClassList.jsp", {}, function(data) {
				//判断用户是否是权限不足
				if("power"==data){
				  alert("权限不足");
				}else {
						
						window.location.href = "/news/admin/newsClassList.jsp";
					}
					
	
				});
	
         
       
         })
         
    })
    
   </script>
   
<div class="left-menu">
<h1 class="title">导航菜单</h1>
  <ul>
    <li><a href="javascript:void(0)" id="ad" >管理员管理</a></li>
    <li><a href="javascript:void(0)" id="user">用户管理</a></li>
    <li><a href="javascript:void(0)" id="nc">类别管理</a></li>
    <li><a href="admin/newsInfoList.jsp">文章管理</a></li>
        <li><a href="admin/newsInfoList2.jsp">审核管理</a></li>
    <li><a id="out" href="out">退出系统</a></li>
  </ul>
</div>