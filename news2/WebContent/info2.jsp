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
<!-- 侧页面 -->
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>个人信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
   <script src="http://www.codefans.net/ajaxjs/jquery-1.6.2.min.js"></script>  
<script src="js/jquery.js">
  
</script>

<script src="js/pintuer.js"></script>
 
</head>
<body>

	<div class="panel admin-panel" style="height: 1000px;">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 个人信息</strong>
		</div>
		
		<div class="body-content">
			<form action="servlet/AddServlet" method="post"  enctype="multipart/form-data" class="form-x">
			<div class="form-group" style="margin-top: 50px;">
					<div class="label" style="margin-top: 50px;">
						<label>头像：</label>
					</div>
					<div class="field">
						   <%if(us.getPhotoName()==null){ %> 
					<div class="field">
						 <img alt=""  id="img0" src="images/y.jpg"width="150px" height="130px"></br>
						<div class="tips"></div>
					</div>
					 <% }%> 
					<%if(us.getPhotoName()!=null){ %> 
					<div class="field">
						 <img alt="" id="img0" src="upload/<%=us.getPhotoName() %>"width="150px" height="130px"></br>
						<div class="tips"></div><span style="color:red;">*</span>(支持jpg,png,gif格式)
					</div>
					 <% }%> 
						<!-- <img alt="" id="img0" src="images/y.jpg"width="100px;"style="margin-top: 50px;"> </br> -->
						<div class="label" style="position:absolute;right:930px;margin-top:150px; ">
						<label>更改头像：</label>
					</div> <input type="file" name="photo" id="file0" multiple="multiple" style="position:relative;left:50px;margin-top: 10px;"/><br>
						<div class="tips"></div>
					</div>
								 <input   style="width: 100px;height: 30px;margin-top:180px;  position: absolute;left:200px;margin-top: 200px;" type="submit" value="确认更改" />
				</div>
				
				<script>    
    $("#file0").change(function(){  
        var objUrl = getObjectURL(this.files[0]) ;  
        console.log("objUrl = "+objUrl) ;  
        if (objUrl) {  
            $("#img0").attr("src", objUrl) ;  
        }  
    }) ;  
    //建立一个可存取到该file的url  
    function getObjectURL(file) {  
        var url = null ;   
        if (window.createObjectURL!=undefined) { // basic  
            url = window.createObjectURL(file) ;  
        } else if (window.URL!=undefined) { // mozilla(firefox)  
            url = window.URL.createObjectURL(file) ;  
        } else if (window.webkitURL!=undefined) { // webkit or chrome  
            url = window.webkitURL.createObjectURL(file) ;  
        }  
        return url ;  
    }  
    </script>  
				<div style="position: relative;top:100px;">
			<div class="form-group"  >
				
					<div class="field">
					<div >
				
				  
    	             </div>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>用户ID：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="aid" value="<%=us.getAid() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>用户姓名：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="aname"
							value="<%=us.getAname() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>用户年龄：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="stitle" value="<%=us.getAge() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>用户性别：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="stitle" value="<%=us.getSex() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>出生日期：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="stitle"
							value="<%=us.getBirthday() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>联系方式：</label>
					</div>
					<div class="field">
						<input  readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="phone"
							value="<%=us.getPhone() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>	QQ：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="qq"
							value="<%=us.getQq() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<%if(us.getCity()!=null)
				{%>
				<div class="form-group">
					<div class="label">
						<label>	所在地：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="qq"
							value="<%=us.getCity() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<%} 
				%>
				<%if(us.getSchool()!=null)
				{%>
				<div class="form-group">
					<div class="label">
						<label>	学校：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="qq"
							value="<%=us.getSchool() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<%} 
				%>
				<%if(us.getSchool()!=null)
				{%>
					<div class="form-group">
					<div class="label">
						<label>	年级：</label>
					</div>
					<div class="field">
						<input readonly="readonly" style="width:25%; float:left;"
							type="text" class="input" name="qq"
							value="<%=us.getGrade() %>" />
						<div class="tips"></div>
					</div>
				</div>
				<%} 
				%>
				</div>
                 <div style="margin-top: 120px;position: absolute;left:250px;">
				<a href="info.jsp" target="right"><input   style="background-color:blue;width: 100px;height: 50px;color:white;font-weight: bold;" type="button" value="重置"/></a>
			       </div>
			</form>
		</div>
	</div>
</body>
</html>
