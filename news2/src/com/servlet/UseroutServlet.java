package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UseroutServlet extends HttpServlet {
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		//处理请求消息
		//响应请求结果
		     //获取session
		     HttpSession hs = req.getSession();
		     //销毁session
		     hs.invalidate();
		     //重定向login.jsp
		     resp.sendRedirect("/news2/Userlogin.jsp");
}
}
