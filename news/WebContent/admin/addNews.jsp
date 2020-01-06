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
	List <NewsClass>list=actionBean.queryClassList();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>添加文章</title>
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

function insert(){
var ntitle = $("#ntitle").val();
var author=$("#author").val();
var cid=$("#cid").val() ;
var ndate=$("#ndate").val() ;
var ncontent1=$("#ncontent1").val() ;
	var teacher=$("#teacher").val() ;
	  var ipts = [ "ntitle", "cid", "ndate"];
			var lens = [ 2, 1, 10];
			var msg = [ "请输入标题，至少2个字符", "请选择新闻类别", "请输入发布时间" ];
			var flag = true;
			for (var i = 0; i < ipts.length; i++) {
				flag = valiInput(ipts[i], msg[i], lens[i]) && flag;
			}
	  
		//发起ajax请求进行用户的修改
				$.post("is", {
					 ntitle:ntitle,
					 author:author,
					 cid:cid,
					 ndate:ndate,
					 ncontent1:ncontent1,
					 teacher:teacher
					 
				}, function(data) {
				//判断文章 是否增加成功
				if("true"==data){
					eval(data);
						alert("文章增加成功");
						window.location.href = "/news/admin/newsInfoList.jsp";
					}else if("false"==data){
					eval(data);
					alert("文章增加失败");
						window.location.href = "/news/admin/newsInfoList.jsp";
					} else{
					eval(data);
					alert("不能为空");
					
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
					添加文章<a href="admin/newsInfoList.jsp" class="back-btn">返回</a>
				</h1>
				<form name="frm" action="is" id="frm"
					mothed="post">
					<table>
						<tr>
							<td>文章标题：</td>
							<td><input id="ntitle" name="ntitle" autocomplete="off"
								maxlength="50" type="text" /></td>
							<td id="err-ntitle"></td>
						</tr>
						<tr>
							<td>作者：</td>
							<td><input id="author" name="author" autocomplete="off"
								maxlength="50" type="text" /></td>
							<td id="err-ntitle"></td>
						</tr>
						<tr>
							<td>指导老师：</td>
							<td><input id="teacher" name="teacher" autocomplete="off"
								maxlength="50" type="text" /></td>
							<td id="err-ntitle"></td>
						</tr>
						<tr>
							<td>文章类别：</td>
							<td><select id="cid" name="cid">
									<option value="">==请选择文章类别==</option>
									<%
										for(NewsClass newsClass:list){
									%>
									<option value="<%=newsClass.getCid()%>"><%=newsClass.getCname()%></option>
									<%
										}
									%>
							</select></td>
							<td id="err-cid"></td>
						</tr>
						<tr>
							<td>发布时间：</td>
							<td><input id="ndate" name="ndate" autocomplete="off"
								maxlength="20" type="text" onClick="WdatePicker()" readonly="readonly"/></td>
							<td id="err-ndate"></td>
						</tr>
						<tr>
							<td valign="top">文章正文：</td>
							<td colspan="2"><textarea id="ncontent1" name="ncontent1" rows="" cols=""
									style="width: 680px; height: 400px;"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><a class="btn" onclick="insert();"
								href="javascript:void(0)">保存</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
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
		function startPost() {
			
			
			if (!flag)
				return;
			document.getElementById("frm").submit();
		}
	</script> 
</body>
</html>