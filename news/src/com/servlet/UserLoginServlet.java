package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SqlHelper;

import com.pojo.AdminInfo;
import com.pojo.Url;
import com.pojo.User;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String aid=request.getParameter("aid");
	     String apwd=request.getParameter("apwd");
	     
	     AdminInfo admininfo=new AdminInfo(aid,apwd);
	       User user=new User();
	     SqlHelper sqlHelper=new SqlHelper();
	     AdminInfo newAdmin=sqlHelper.checkAdminInfo(admininfo);
	     User u=sqlHelper.checkUserInfo(aid,apwd);
	     HttpSession session=request.getSession();
	     String check=request.getParameter("code");
	     String checkServer=(String)(request.getSession().getAttribute("NUMBER"));
	     System.out.println(check);
	     System.out.println(checkServer);
	     if(check!=null){
	     if(check.equalsIgnoreCase(checkServer)){
	     if(newAdmin!=null||u!=null){
	    	//查询当前用户的URL权限
	    	    List<Url> lu=sqlHelper.getUserUrlInfoService(admininfo.getAid());	
	    	    List<Url> ls=sqlHelper.getUserUrlInfo(user.getAid());	
	    	    System.out.println(lu);
	    	    //将url权限数据存储到session中
	    	    if(newAdmin!=null){
	    	    session.setAttribute("aname", newAdmin.getAname());}
	    	    if(u!=null){
	    	    session.setAttribute("aname", u.getAname());
	    		session.setAttribute("user", u);
	    	    }
	    	    
	    	    session.setAttribute("ls", ls);
	    	  session.setAttribute("lu", lu);
	    	
	    
	    	 response.sendRedirect("/news/Index.html");
	     }else{
	    	session.setAttribute("flag", "loginfalse");
	    	 response.sendRedirect("login.jsp");
	     }}else{
	    	 session.setAttribute("flag", "yzmfalse");
	    	 response.sendRedirect("login.jsp");
	     }
	     
	}else{
		session.setAttribute("flag", "yzmfalse");
   	 response.sendRedirect("login.jsp");
	}}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request,response);
	}

}
