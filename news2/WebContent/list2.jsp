<%@page import="com.pojo.News"%>
<%@page import="com.pojo.NewsClass"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<News> resultList = (List) request.getAttribute("resultList");
	List <NewsClass> newsList=(List)request.getAttribute("newsClassList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<title>简笔-书写青春，畅想未来</title>

</head>
<body style="background:url(images/5.jpg);background-size:1800px 1700px;background-repeat:no-repeat;">
	<jsp:include page="top.jsp"></jsp:include>
	
	<jsp:include page="nav.jsp"></jsp:include>
	
	
	<div class="index-main-box w">
	<h2 align="center" style="background-color:#c7c7e2 ">
	阅读量排行榜(前50)
				</h2>
		<h3 style="position: absolute;left:120px;top:245px;"><span >文章名</span></h3><h3 style="position: absolute;left:350px;top:245px;"><span >文章类型</span></h3><h3  style="position: absolute;left:660px;top:245px;"><span>作者名</span></h3><h3 style="position: absolute;left:900px;top:245px;"><span >指导老师</span></h3><h3 style="position: absolute;left:1120px;top:245px;"><span >发布日期</span></h3>
		<div class="panel" >
			<div class="panel-title" id="test-3" style="width: 1200px;margin-top: 40px;position: absolute;left:100px;">
				
				<ul>
					<%
					  
					    if(newsList.size()<1){
					    	//out.println("<li>没有数据</li>");
					    }else for (News news : resultList) {
					    
					%>
					<li><a href="item.html?nid=<%=news.getNid()%>&&id=<%=news.getId() %>" target="_self" title="<%=news.getNtitle() %>"><%=news.getNtitle() %></a>
				<span style="positiona:absolute;left:200px;"><%=news.getCname() %></span><span style="positiona:absolute;left:500px;"><%=news.getAuthor() %></span><span style="position: absolute;left:750px;" ><%=news.getTeacher() %></span><span style="positiona:absolute;left:1000px;"><%=news.getNdate() %></span></li>
					
					<%
						}
					%>
				</ul>
			</div>
		</div>
		
	</div>
	<div style="position:absolute;top:1600px;  ">
	<jsp:include page="footer.jsp"></jsp:include>
		</div>


</body>
</html>