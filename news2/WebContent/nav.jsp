<%@page import="com.pojo.NewsClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";   
    List <NewsClass>list=(List)request.getAttribute("newsClassList");
    if(list==null)return;
    String activeDiv="active";
    String currCid="";
    if(request.getAttribute("cid")!=null){
    	activeDiv="";
    	currCid=request.getAttribute("cid").toString();
    }
%>
<div class="nav-box">
<div style="background:url(../images/timg.jpg); "></div>
  <ul class="w">
    <li class="<%=activeDiv%>"><a href="Index.html">首页</a></li>
    <%for(NewsClass newsClass:list) {%>
    <li <%=newsClass.getCid().equals(currCid)?"class=\"active\"":"" %>><a href="newsList.html?cid=<%=newsClass.getCid() %>" class="active"target="_self"><%=newsClass.getCname() %></a></li>
    <%} %><li ><a href="/news2/Index2.html"><span>排行榜<span></a>
  </ul>
</div>