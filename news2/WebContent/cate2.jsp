<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@page import="com.dao.SqlHelper"%>
<%@page import="com.tools.*"%>
<%@page import="com.pojo.NewsPojo"%>
<%@page import="com.pojo.NewsClass"%>
<%@page import="com.pojo.News"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.action.ActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	ActionBean actionBean=new ActionBean();
	
   int p=StringToInt.String2Int(request.getParameter("p"));
   String cid=request.getParameter("cid");
   String ntitle=request.getParameter("ntitle");
   String aid=(String)session.getAttribute("aid");
   
   if(p<0){
   	response.sendRedirect("cate2.jsp");
   }
   Map resultMap=actionBean.queryNewsByPage5(p,cid,ntitle,aid);
    List <Map>list=(List)resultMap.get("list");
    int rows = (Integer)resultMap.get("rows");
    if(p>0 && list.size()<1){
    	response.sendRedirect("cate2.jsp");
    }
    List<NewsClass> classlist  = (List)resultMap.get("classlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章信息管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
</head>
<body>

<div class="main-frame">

<div class="right">
	<div class="admin">
		<h1 class="title">草稿文章</h1>
	
		<table class="tab" cellspacing="0">
		<tr>
		  <td colspan="5">
		    <form action="cate2.jsp" method="post" id="frm">
		    <label>文章类别：</label>
		    <select name="cid">
		       <option value="">请选择文章类别</option>
		       <%for(NewsClass newsClass:classlist){
		    	   out.print("<option "+(newsClass.getCid().equals(cid)?"selected='selected'":"")+" value=\""+newsClass.getCid()+"\">"+newsClass.getCname()+"</option>");
		       } %>
		    </select>
		    <label>标题</label>
		    <input type="text" name="ntitle" id="ntitle" value="<%=ntitle==null?"":ntitle%>"/>
		    <input type="hidden" name="p" id="nextpage_num" value="<%=p%>"/>
		    <input type="submit" value="查询">
		    </form>
		  </td>
		</tr>
		 <tr><td style="10px">选择</td><td>序号</td><td>文章标题</td><td>文章类别</td><td>发布时间</td><td>状态</td>
		
		 </tr>
		   <%
		   int i=10*p;
		   int totalPages=(rows%10==0?rows/10:(rows / 10 + 1));
		   for(Map map:list){
			   %>
			   <tr><td><input type="radio" name="rad" value="<%=map.get("nid")%>" autocomplete="off"/></td><td><%=++i %></td><td><%=map.get("ntitle") %></td><td><%=map.get("cname") %></td><td><%=map.get("ndate") %></td><td><%=map.get("result") %></td></tr>
			   <%
		   }
		 %>   
		  <tr>
		    <td colspan="5" class="page">
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
		      </td>
		  </tr>
		 <tr><td colspan="5" style="border-bottom:0">
		 	
		
		 <a class="btn" href="javascript:void(0)" onclick="updateNews()">修改</a>
		 <a class="btn" href="javascript:void(0)" onclick="deleteNews()">删除</a>
		 </td></tr>
		</table>	
	</div>
</div>
</div>

<div class="win-box" id="win-box">
 <h2 class="win-title">修改文章                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           类别<span onclick="closeClassWindow(0);">&times;</span></h2>
 <iframe src="" id="update-win"></iframe>
</div>
	<script src="js/jquery.js"></script> 
	<script type="text/javascript">
	function nextPage(n){
		document.getElementById("nextpage_num").value=n;
		document.getElementById("frm").submit();
	}
	function selectedRow(){
		var ms=document.getElementsByName("rad");
		var obj=null;
		for(var i=0;i<ms.length;i++){
			if(ms[i].checked){
				obj=ms[i];
				break;
				}
			}
		if(null==obj){
			alert("请选择一行再操作");
			}
		return obj;
		}
	function updateNews(){
		var obj = selectedRow();
		if(obj==null)return;
		//发起ajax请求进行用户的修改
				$.get("/news2/admin/UpdateNewsServlet", {
					
					
				}, function(data) {
				//判断用户是否是权限不足
				if("power"==data){
				  alert("权限不足");
				}else  {
						
					location="updateNews.jsp?nid="+obj.value;
					}
					
	
				});
		
		}
	function deleteNews(){
		var obj = selectedRow();
		if(obj==null)return;
		if(confirm("您确认要删除当前文章吗？")){
		//发起ajax请求进行用户的删除
				$.get("/news2/DeleteNewsServlet2", {
					
					
				}, function(data) {
				//判断用户是否是权限不足
				if("power"==data){
				  alert("权限不足");
				}else  {
						alert("文章删除成功");
						window.location.href = "DeleteNewsServlet2?nid="+obj.value;
					}
					
	
				});
			
			}	
		}
	function updateClassWindow(url){
		document.getElementById("win-box").style.display="block";
		document.getElementById("update-win").src=url;
		}
	function closeClassWindow(f){
		document.getElementById("win-box").style.display="none";
		if(f==1){
			location=location;
			}
		}
	</script>
</body>
</html>