<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!-- 注册页面 -->
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script> 
<!-- 声明js代码域 -->
<script type="text/javascript">
/*********校验qq方法**************/
			
			function  checkQQ(){
		
				//qq的正则表达式
				var  reg=/^[1-9][0-9]{4,10}$/;
				
				return check("qq",reg);
			}

/*********校验aid方法**************/
			
			function  checkAid(){
		
				//aid的正则表达式
				var  reg=/^[A-Za-z0-9]{1,8}$/;
				
				return check("aid",reg);
			}

function  checkPhone(){
				//手机号的正则表达式
				
				var  reg=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9]|19[0|1|2|3|5|6|7|8|9])\d{8}$/;
				
			return	check("phone",reg);
			}
			
			
			
/***********提取公共的部分***************/
			function  check(id,reg){
			
				//获得密码的值
				var  uname=document.getElementById(id);
				
				var  val=uname.value;
				
				//获得alt属性
				var  alt=uname.alt;
				
				//获得span对象
				var span =document.getElementById(id+"_span");
				
				if(val==null||val==""){
					
					
					span.innerText="×"+alt+"不能为空";
					
					span.style.color="red";
					
					return false;
					/*判断正则表达式*/
				}else if(reg.test(val)){
					
					span.innerText="√"+alt+"合法";
					
					span.style.color="green";
					
					return true;
					
				}else{
					span.innerText="×"+alt+"不合法";
					
					span.style.color="red";
					
					return false;
				}
			}
/*******是否统一协议**********/
			function  checkAgree(){
				//同意框
				var  check=document.getElementById("check");
				//提交
				var  sub=document.getElementById("sub");
				
				sub.disabled=!check.checked;
				
				
				
			}

function zong(){
				
			  var  flag=checkAid()&&checkPhone()&&checkQQ()&&checkAgree();
				
				
		     return flag;		
			}

         $(function(){
         //给男添加单击事件
         $("#man").click(function(){
                //给男的span添加选择样式
               $("#manspan").addClass("icon-check");
                //将女的选择状态去掉
                $("#womanspan").removeClass("icon-check");
         })
         //给女添加单击事件
         $("#woman").click(function(){
               //给女的span添加选择样式
               $("#womanspan").addClass("icon-check");
                //将男的选择状态去掉
                $("#manspan").removeClass("icon-check");
         })
                  })
           
        

</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" >
			<strong ><span class="icon-key" ></span>用户注册</strong>
		</div>
		<div class="body-content"  style="height:1000px;">

			<form method="post" class="form-x" action="reg" onsubmit="return zong()">
			
               <!-- 声明请求处理方法 -->
           <input type="hidden" name="method" value="userReg"/>
           <div class="beizhu" style="position:relative;left:150px;">(带 * 号的表示为必填项目，用户ID必须大于位小于8位，密码必须大于5位)</div>
           <div class="form-group" style="margin-top:10px;">
					<div class="label">
						<label for="sitename"><span style="color:red">*</span>用户ID：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="aid" name="aid" style="width: 400px;"
							size="50" placeholder="请输入用户ID" data-validate="required:请输入用户ID" onblur="checkAid()"/> 
							<span id="aid_span" style="position: absolute;left:420px;bottom: 10px;">用户ID必须是1-8位字母或数字</span>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename"><span style="color:red">*</span>用户名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="aname" name="aname"style="width: 400px;"
							size="50" placeholder="请输入用户名" data-validate="required:请输入用户名" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename"><span style="color:red">*</span>新密码：</label>
					</div>
					<div class="field">
						<input type="password" class="input w50" name="apwd" size="50"
							placeholder="请输入新密码" style="width: 400px;"
							data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename"><span style="color:red">*</span>确认新密码：</label>
					</div>
					<div class="field">
						<input type="password" class="input w50" style="width: 400px;"
							size="50" placeholder="请再次输入新密码"
							data-validate="required:请再次输入新密码,repeat#apwd:两次输入的密码不一致" />
					</div>
				</div>
				<!-- 性别 -->
				<div class="form-group">
					<div class="label">
						<label><span style="color:red">*</span>性别：</label>
					</div>
					<div class="field">
						<div class="button-group radio">

							<label class="button active"  > <span
								class="icon-check"  id="manspan"></span> <input name="sex" id="man" value="男"
								type="radio" checked="checked">男
							</label> <label class="button active" ><span
								class="" id="womanspan" ></span> <input name="sex" value="女" id="woman"
								type="radio" >女 </label>
						</div>
					</div>
				</div>
				<!-- 年龄 -->
				<div class="form-group">
					<div class="label">
						<label for="sitename"><span style="color:red">*</span>年龄：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="mpass" name="age" style="width: 400px;"
							size="50" placeholder="请输入用户年龄" data-validate="required:请输入用户年龄" />
					</div>
				</div>
				<!-- 出生日期 -->
				<div class="form-group">
					<div class="label">
						<label for="sitename"><span style="color:red">*</span>出生日期：</label>
					</div>
					<div class="field">
						<input type="date" class="input w50" id="mpass" name="birthday" style="width: 400px;"
							size="50" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename"><span style="color:red">*</span>联系方式：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="phone" name="phone"style="width: 400px;"
							size="50" placeholder="请输入手机号" data-validate="required:请输入手机号"  onblur="checkPhone()"/><span id="phone_span"style="position: absolute;left:420px;bottom: 10px;">请输入正确的手机号</span>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename"><span style="color:red">*</span>QQ：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="qq" name="qq"style="width: 400px;"
							size="50" placeholder="请输入QQ号" data-validate="required:请输入QQ号" onblur="checkQQ()" /><span id="qq_span"style="position: absolute;left:420px;bottom: 10px;">用户QQ必须是5-11位</span>
					</div>
				</div>
								<div class="form-group">
					<div class="label">
						
					</div>
					<div class="label" style="position: absolute;left:10px;">
						<label for="sitename">用户服务协议：</label>
					</div>
					<div class="contract" > 
							<iframe  src ="/news2/xieyi.jsp" style=" position: absolute;left:200px;width: 40%;height: 40%;" frameborder="0"></iframe>
						</div>
					<div class="field">
							<input type="checkbox" name="" id="check" value="" onclick="checkAgree()" style="position:absolute;left:30px;top:140px;  zoom:200%; ">
							<span style="position:absolute;left:90px;top:280px;font-size: 20px; ">我已阅读并完全同意<span style="color: blue;">《最终用户协议》</span></span>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
		        
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit" id="sub" value="注册" disabled="true" style="position:absolute;left:150px;top:300px;">
							注册</button>
							
					</div>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>
