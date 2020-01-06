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
	List<Map> resultList = (List) request.getAttribute("resultList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<title>简笔-书写青春，畅想未来</title>

</head>
<body style="background:url(images/indexbg.jpg);background-size:1800px 1800px;background-repeat:no-repeat;">
	<jsp:include page="top.jsp"></jsp:include>
	
	<jsp:include page="nav.jsp"></jsp:include>
	
	<div class="box" id="box">
	    <div class="inner">
        <!--轮播图-->
        <ul1>
            <li><a href="http://store.dangdang.com/gys_0014815_bmvo"><img src="images/1.jpg" alt=""></a></li>
            <li><a href="http://book.dangdang.com/20190311_k3pb"><img src="images/2.jpg" alt=""></a></li>
            <li><a href="http://baby.dangdang.com/20190319_tgmb"><img src="images/3.jpg" alt=""></a></li>
            <li><a href="http://book.dangdang.com/20190321_1dau"><img src="images/4.jpg" alt=""></a></li>
        </ul1>
        <ol class="bar">
        <!--  小按钮数量无法确定，由js动态生成 -->   
        </ol>
        <!--左右焦点-->
        <div id="arr">
              <span id="left"> <</span>
              <span id="right">></span>
        </div>
 
       </div>
    </div>

	<div class="index-main-box w">
		<%
			for (Map map : resultList) {
				NewsClass newsClass = (NewsClass) map.get("newsClass");
				List<News> newsList = (List) map.get("newsList");
		%>
		<div class="panel" id="test-3">
			<div class="panel-title" id="test-3">
				<h2 style="background-color:#c7c7e2 "><%=newsClass.getCname()%><a
						href="newsList.html?cid=<%=newsClass.getCid()%>" class="more"
						target="_self">更多</a>
				</h2>
				<ul>
					<%
					    if(newsList.size()<1){
					    	//out.println("<li>没有数据</li>");
					    }else for (News news : newsList) {
					%>
					<li><a href="item.html?nid=<%=news.getNid()%>&&id=<%=news.getId() %>" target="_self" title="<%=news.getNtitle() %>"><%=news.getNtitle() %></a>
					<span><%=news.getNdate() %></span></li>
					
					<%
						}
					%>
				</ul>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
		
<script>
    /**
     *
     * @param id  传入元素的id
     * @returns {HTMLElement | null}  返回标签对象，方便获取元素
     */
    function my$(id) {
        return document.getElementById(id);
    }
 
    //获取各元素，方便操作
    var box=my$("box");
    var inner=box.children[0];
    var ulObj=inner.children[0];
    var list=ulObj.children;
    var olObj=inner.children[1];
    var arr=my$("arr");
    var imgWidth=inner.offsetWidth;
    var right=my$("right");
    var pic=0;
    //根据li个数，创建小按钮
    for(var i=0;i<list.length;i++){
        var liObj=document.createElement("li");
 
        olObj.appendChild(liObj);
        liObj.innerText=(i+1);
        liObj.setAttribute("index",i);
 
        //为按钮注册mouseover事件
        liObj.onmouseover=function () {
            //先清除所有按钮的样式
 
            for (var j=0;j<olObj.children.length;j++){
                olObj.children[j].removeAttribute("class");
            }
            this.className="current";
            pic=this.getAttribute("index");
            animate(ulObj,-pic*imgWidth);
        }
 
    }
 
 
    //设置ol中第一个li有背景颜色
    olObj.children[0].className = "current";
    //克隆一个ul中第一个li,加入到ul中的最后=====克隆
    ulObj.appendChild(ulObj.children[0].cloneNode(true));
 
    var timeId=setInterval(onmouseclickHandle,2000);
    //左右焦点实现点击切换图片功能
    box.onmouseover=function () {
        arr.style.display="block";
        clearInterval(timeId);
    };
    box.onmouseout=function () {
        arr.style.display="none";
        timeId=setInterval(onmouseclickHandle,2000);
    };
 
    right.onclick=onmouseclickHandle;
    function onmouseclickHandle() {
        //如果pic的值是5,恰巧是ul中li的个数-1的值,此时页面显示第六个图片,而用户会认为这是第一个图,
        //所以,如果用户再次点击按钮,用户应该看到第二个图片
        if (pic == list.length - 1) {
            //如何从第6个图,跳转到第一个图
            pic = 0;//先设置pic=0
            ulObj.style.left = 0 + "px";//把ul的位置还原成开始的默认位置
        }
        pic++;//立刻设置pic加1,那么此时用户就会看到第二个图片了
        animate(ulObj, -pic * imgWidth);//pic从0的值加1之后,pic的值是1,然后ul移动出去一个图片
        //如果pic==5说明,此时显示第6个图(内容是第一张图片),第一个小按钮有颜色,
        if (pic == list.length - 1) {
            //第五个按钮颜色干掉
            olObj.children[olObj.children.length - 1].className = "";
            //第一个按钮颜色设置上
            olObj.children[0].className = "current";
        } else {
            //干掉所有的小按钮的背景颜色
            for (var i = 0; i < olObj.children.length; i++) {
                olObj.children[i].removeAttribute("class");
            }
            olObj.children[pic].className = "current";
        }
    }
    left.onclick=function () {
        if (pic==0){
            pic=list.length-1;
            ulObj.style.left=-pic*imgWidth+"px";
        }
        pic--;
        animate(ulObj,-pic*imgWidth);
        for (var i = 0; i < olObj.children.length; i++) {
            olObj.children[i].removeAttribute("class");
        }
        //当前的pic索引对应的按钮设置颜色
        olObj.children[pic].className = "current";
    };
    
    //设置任意的一个元素,移动到指定的目标位置
    function animate(element, target) {
        clearInterval(element.timeId);
        //定时器的id值存储到对象的一个属性中
        element.timeId = setInterval(function () {
            //获取元素的当前的位置,数字类型
            var current = element.offsetLeft;
            //每次移动的距离
            var step = 10;
            step = current < target ? step : -step;
            //当前移动到位置
            current += step;
            if (Math.abs(current - target) > Math.abs(step)) {
                element.style.left = current + "px";
            } else {
                //清理定时器
                clearInterval(element.timeId);
                //直接到达目标
                element.style.left = target + "px";
            }
        }, 10);
    }
</script>

</body>
</html>