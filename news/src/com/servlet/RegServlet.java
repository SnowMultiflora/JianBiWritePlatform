package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SqlHelper;



public class RegServlet extends HttpServlet {
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//设置请求编码格式
	   req.setCharacterEncoding("utf-8");
	//设置响应编码格式
	   resp.setContentType("text/html;charset=utf-8");
	//获取请求信息
	   String aid=req.getParameter("aid");
	   String aname = req.getParameter("aname");
	   String apwd = req.getParameter("apwd");
	   String sex = req.getParameter("sex");
	  int age=Integer.parseInt(req.getParameter("age")) ;
	   String birthday = req.getParameter("birthday");
	  
     //处理请求信息
	      //获取业务层
	   SqlHelper sqlHelper=new SqlHelper();
	      //处理业务对象
	          //注册服务
	      int i=sqlHelper.regUserInfoService(aid,aname,apwd,sex,age,birthday);
	      //获取session
	              HttpSession session = req.getSession();
	 //响应处理结果 
	       //重定向登录页面
	            if(i>0){
	            	//存取数据到session中
	            	 session.setAttribute("flag", "regSuccess");
	            	//重定向登录页面
	            	resp.sendRedirect("/news/login.jsp");
	            }else{
	            	
	            }
}
}
