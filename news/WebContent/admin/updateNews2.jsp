<%@page import="com.tools.StringToInt"%>
<%@page import="com.pojo.News"%>
<%@page import="java.util.Map"%>
<%@page import="com.pojo.NewsClass"%>
<%@page import="java.util.List"%>
<%@page import="com.action.ActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	ActionBean actionBean=new ActionBean();
	String nid = request.getParameter("nid");
	Map resultMap=actionBean.queryNewsMapForUpdate2(nid);
	List <NewsClass>list=(List)resultMap.get("newsClassList");
	News news=(News)resultMap.get("news");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>修改文章</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<link rel="stylesheet"
	href="<%=basePath%>admin/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="<%=basePath%>admin/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8"
	src="<%=basePath%>admin/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8"
	src="<%=basePath%>admin/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8"
	src="<%=basePath%>admin/kindeditor/plugins/code/prettify.js"></script>
<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="ncontent1"]', {
				cssPath : '<%=basePath%>admin/kindeditor/plugins/code/prettify.css',
				uploadJson : '<%=basePath%>admin/upload_json.jsp',
				fileManagerJson : '<%=basePath%>admin/file_manager_json.jsp',
									allowFileManager : true,
									afterBlur:function(){
										this.sync();
										},
									afterCreate : function() {
										var self = this;
										K.ctrl(document, 13, function() {
											self.sync();
											document.forms['frm'].submit();
										});
										K.ctrl(self.edit.doc, 13, function() {
											self.sync();
											document.forms['frm'].submit();
										});
									}
								});
				prettyPrint();
			});
</script>
 <script language="javascript" type="text/javascript" src="<%=basePath%>/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function save(){
var resul= $('input:radio:checked').val();
var tex=$("#tex").val();
var nid = $("#nid").val();
var ntitle=$("#ntitle").val();
var author=$("#author").val() ;
var cid=$("#cid").val() ;
var ndate=$("#ndate").val() ;
var ncontent1=$("#ncontent1").val() ;
var teacher=$("#teacher").val() ;	
	 
	  
		//发起ajax请求进行用户的修改
				$.post("re", {
				  resul:resul,
					tex:tex,
					 nid : nid,
					ntitle:ntitle,
					author:author,
					  cid:cid,
					  ndate:ndate,
					  ncontent1:ncontent1,
					  teacher:teacher
				}, function(data) {
				
				//判断用户是否修改成功
				if("true"==data){
					eval(data);
						alert("审核成功");
						window.location.href = "/news/admin/newsInfoList2.jsp";
					}else if("false"==data){
					eval(data);
					alert("驳回成功");
						window.location.href = "/news/admin/newsInfoList2.jsp";
					} else{
					eval(data);
					alert("审核结果和意见不能为空");
					}
					
	})
				
	}
			
	
	
		
	</script>

</head>
<body>
	<div class="main-frame" style="height: 725px;">
		<jsp:include page="top.jsp"></jsp:include>
		<jsp:include page="left.jsp"></jsp:include>
		<div class="right">
			<div class="admin">
				<h1 class="title">
					审核文章<a href="admin/newsInfoList.jsp" class="back-btn">返回</a>
				</h1>
				<form name="frm"  id="frm"
					mothed="post">
					<input id="nid"   name="nid" value="<%=news.getNid()%>" type="hidden"/>
					<table>
						<tr>
							<td>文章标题：</td>
							<td><input id="ntitle" readonly="readonly" name="ntitle" autocomplete="off"
								maxlength="50" type="text" value="<%=news.getNtitle()%>"/></td>
							<td id="err-ntitle"></td>
						</tr>
						<tr>
							<td>作者：</td>
							<td><input id="author" readonly="readonly" name="author" autocomplete="off"
								maxlength="50" type="text" value="<%=news.getAuthor()%>"/></td>
							<td id="err-ntitle"></td>
						</tr>
						<tr>
							<td>指导老师：</td>
							<td><input id="teacher" readonly="readonly" name="teacher" autocomplete="off"
								maxlength="50" type="text" value="<%=news.getTeacher()%>"/></td>
							<td id="err-ntitle"></td>
						</tr>
						<tr>
							<td>文章类别：</td>
							<td><select id="cid" name="cid" readonly="readonly">
									<option value="">==请选择文章类别==</option>
									<%
									
										for(NewsClass newsClass:list){
											//String sel= newsClass.getCid().equals(news.getCid())?" selected='selected'":"";
									%>
									<option <%=newsClass.getCid().equals(news.getCid())?" selected='selected'":"" %>value="<%=newsClass.getCid()%>"><%=newsClass.getCname()%></option>
									<%
										}
									%>
							</select></td>
							<td id="err-cid"></td>
						</tr>
						<tr>
							<td>发布时间：</td>
							<td><input readonly="readonly" id="ndate" name="ndate" autocomplete="off"
								maxlength="20" type="text" value="<%=news.getNdate() %>"/></td>
							<td id="err-ndate"></td>
						</tr>
						<tr>
							<td valign="top">文章正文：</td>
							<td colspan="2"><textarea name="ncontent1" readonly="readonly" id="ncontent1" rows="" cols=""
									style="width: 680px; height: 400px;"><%=news.getNcontent() %></textarea></td>
						</tr>
						
						
							
						
					</table>
					</form>
					
			</div>
		</div>
	</div>
	
		
		
				<div style="margin-left:500px;margin-top: 50px;">
				
					<span style="position: absolute;left:500px;">审核结果</span></br>
					<div style="position: absolute;left:500px;" >
					<input  id="resul" name="result" type="radio"  value="已审核"/>已审核
				    <input  id="resul" name="result" type="radio" value="驳回"/>驳回 </br>
				    </div></br>
					<label style="position: absolute;left:500px;">审核意见/评论</label></br>
					<textarea rows="5" cols="35" id="tex" ></textarea></br>
				
					<label>&nbsp;</label>
					<input  name="" type="button" class="btn" value="确认保存" onclick="save();"/>
				
		

		</div>
		
	<jsp:include page="footer.jsp"></jsp:include>
	 <script type="text/javascript">
		function valiInput(id, msg, n) {
			var val = document.getElementById(id).value;
			if (val == "" || val.length < n) {
				document.getElementById("err-" + id).innerHTML = "<span class='err'>"
						+ msg + "</span>";
				return false;
			} else {
				document.getElementById("err-" + id).innerHTML = "<span class='success'>验证通过</span>";
				return true;
			}
		}
		
	</script> 
</body>
</html>