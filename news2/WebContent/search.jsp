<%@page import="java.util.Map"%>
<%@page import="com.pojo.News"%>
<%@page import="com.pojo.NewsClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	List <News>lastnewss = (List)request.getAttribute("lastnewss");
	List <Map>newss = (List)request.getAttribute("newss");
	int rows=(Integer)request.getAttribute("rows");
	int p=(Integer)request.getAttribute("p");
	String search=request.getAttribute("search").toString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<title>文章查询<%=search %></title>
</head>
<body style="background:url(images/5.jpg);background-size:1800px 800px;background-repeat:no-repeat;">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="w"     >
		<div class="left-box">
			<h2>最新发布</h2>
			<ul>
			  <%for(News news : lastnewss){ %> 
			  <li><a href="item.html?nid=<%=news.getNid() %>&&id=<%=news.getId() %>" target="_self" title="<%=news.getNtitle() %>"><%=news.getNtitle() %></a></li>
			  <%} %>  
			  </ul>
		</div>
		<div class="right-box">
		  <h2>共查询到<%=rows %>条记录</h2>
			<ul>
			 <% 
			 int i=10*p;
			   int totalPages=(rows%10==0?rows/10:(rows / 10 + 1));
			 for(Map map:newss){%>
	    		<li><a href="item.html?nid=<%=map.get("nid") %>&&id=<%=map.get("id") %>" target="_self" 
	    		title="<%=map.get("ntitle")%>"><%=map.get("order_no") %> .<%=map.get("ntitle")%></a>
	    		<span><%=map.get("ndate")%></span></li>
	    	<%} %>
			</ul>
		 	<p class="page">
			  <span>总共<%=rows %>篇文章</span><span>当前是第<%=p+1 %>页</span>
		    <%if(p>0) {%>
		      <a href="javascript:void(0)" onclick="nextPage(0)">首页</a>
		      <a href="javascript:void(0)" onclick="nextPage(<%=p-1%>)">上一页</a>
		    <%} %>
		    <%if(p<totalPages-1) {%>
		      <a href="javascript:void(0)" onclick="nextPage(<%=p+1%>)">下一页</a>
		      <a href="javascript:void(0)" onclick="nextPage(<%=totalPages-1%>)">尾页</a>
		    <%} %>
		      <span>共<%=totalPages %>页</span>
		      <%if(totalPages>1){ %>
		      <span>跳转到第<select onchange="nextPage(this.value)"><%for(int j=0;j<totalPages;j++) {%><option value="<%=j%>"<%=j==p?"selected='selected'":"" %>><%=j+1 %></option><%} %></select>页</span>
		      <%} %>			
			</p >
		</div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
	function nextPage(n){
		document.getElementById("p").value=n;
		document.getElementById("submit").click();
	}
	</script>
</body>
</html>