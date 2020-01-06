<%@page import="com.pojo.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
    News news=(News)request.getAttribute("news");
     News news2=(News)request.getAttribute("news2");
         News news3=(News)request.getAttribute("news3");
    if(news==null){
    	response.sendRedirect("Index.html");
    	return;
    }
    if(news2==null){
    	response.sendRedirect("Index.html");
    	return;
    }
    if(news3==null){
    	response.sendRedirect("Index.html");
    	return;
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=news.getNtitle() %></title>
<style type="text/css">

a:hover
{

text-decoration: underline;

}
</style>

<script src="js/html2canvas.js"></script>
<script src="js/jspdf.debug.js"></script>
</head>
<body lang=ZH-CN style='tab-interval:21.0pt'>
  <jsp:include page="top.jsp"></jsp:include>
  <jsp:include page="nav.jsp"></jsp:include>
   <input style="position: relative;z-index: 100;left:740px;top:130px;"  type="button" value="下载本文"></br>
 
  <div style="background-color:#FFFEDF;height:1000px;width:1000px;position: relative;left:150px;top:20px;"id="exportdata">
  <div class="word"  >
   <div class="w" >
    <h1 class="title" align="center" style="font-size:20pt;font-weight:bold;"><%=news.getNtitle() %><span style="color:gray;position:relative;left: 160px;top:20px;font-size: 15px; ">浏览量:<%=news.getCount() %></span></h1>
    <p class="date" align="center" style="font-size:15pt;font-weight:bold;color: gray;position: relative;right:30px;">发布日期：<%=news.getNdate() %></p>
     <p class="date" align="center" style="font-size:15pt;font-weight:bold;color: gray;position: relative;right:40px;">作者：<%=news.getAuthor() %><span style="position: relative;left:60px;">指导老师：<%=news.getTeacher() %><span></p>

    <div class="content" style="width: 800px;position: relative;top:100px;left:100px;" >
    <%=news.getNcontent() %> 
    </div>
   </div> 
  </div>
 <div  style="margin-top: 150px;width: 800px;position: relative;left: 100px;">
 
  专家点评：<span style="font-style:italic;line-height:30px;font-size: 16px;color: red;"><%=news.getTex() %></span>
  </div>
  <span style="color:gray;position:relative;left:100px;top:100px;">凡简笔网原创的文章、图片，版权均属于本站，任何网站未经本网授权不得转载、摘编或利
用其它方式使用上述作品。</span></br>
  </div> 
  <div align="center" style="margin-top: 50px;">
  <div style="position:absolute;left:400px; ">
   <span style="font-size: 20px;">上一篇:</span><a style=" font-size: 20px;color:blue;" href="item.html?nid=<%=news3.getNid()%>&&id=<%=news3.getId() %>" target="_self" title="<%=news3.getNtitle() %>"><%=news3.getNtitle() %></a>
  </div>
  <div style="position:absolute;left:750px; ">
    <span style="font-size: 20px;">下一篇:</span><a style="font-size: 20px;color:blue;" href="item.html?nid=<%=news2.getNid()%>&&id=<%=news2.getId() %>" target="_self" title="<%=news2.getNtitle() %>"><%=news2.getNtitle() %></a>
  </div>
  </div>
  <div align="center" style="margin-top: 80px;">
  
     
        	<span class="iconfont"style="position: relative;right:80px;top:25px;"font-size:15px;">支持请打赏&#xe62e;</span>
 <a href="http://www.dashangcloud.com/sh/87a9db" > <img  src="/news2/images/danshang.png" width=50px;height=50px; style="position:relative;top:50px;right:50px;"></a>
  </div>

  

<script>
    $(function(){
        $("input[type='button']").click(function(exportData) {
        	html2canvas(document.getElementById("exportdata"), {//到导出的部分的id
    			onrendered: function(canvas) {
    				var imgData = canvas.toDataURL('image/jpeg');
    				//初始化pdf，设置相应格式
    				var doc = new jsPDF("p", "mm", "a4");
     
    				//这里设置的是a4纸张尺寸
    				doc.addImage(imgData, 'JPEG', 0, 0, 210, 297);
                    
    				//保存时的文件名，自行设置，这里输出保存命名为www.pdf
    				doc.save('<%=news.getNtitle() %>.pdf');
    			}
    		});
        });
    })
</script>
<div style="height:100px;"></div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
