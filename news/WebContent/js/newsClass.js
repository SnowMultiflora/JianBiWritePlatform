function startPost(){
	   var cname=document.getElementById("cname").value;
	   if(cname==""){
		   document.getElementById("err-cname").innerHTML="<span class='err'>请输入类别名称</span>";
		   return;
		   }
	   document.getElementById("frm").submit();
   }
