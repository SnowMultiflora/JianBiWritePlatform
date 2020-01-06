package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.User;

/**
 * Servlet implementation class upsetuserservlet
 */
@WebServlet("/Upsetuserservlet")
public class Upsetuserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//设置请求编码格式
	   req.setCharacterEncoding("utf-8");
	//设置响应编码格式
	   resp.setContentType("text/html;charset=utf-8");
	   //获取请求信息
	            String aid=req.getParameter("aid");
	           String phone=req.getParameter("phone");
	           String qq=req.getParameter("qq");
	           String school=req.getParameter("school");
	           String city=req.getParameter("city");
	           String grade=req.getParameter("grade");
	         
	   //处理请求信息
	           if(aid!=null&&phone!=null&&qq!=null&&school!=null&&city!=null&&grade!=null) {
	           User user=new User();
	           user.setAid(aid);
	           user.setCity(city);
	           user.setGrade(grade);
	           user.setPhone(phone);
	           user.setQq(qq);
	           user.setSchool(school);
	           SqlHelper sqlHelper=new SqlHelper();
	        int n=sqlHelper.upsetUser(user);
	   //响应请求信息
	        if(n>0) {
	        	resp.getWriter().write("true");
	        }else {
	        	resp.getWriter().write("false");
	        }
	           }else {
	        	   resp.getWriter().write("null");
		        }
	           }
	           
   }


