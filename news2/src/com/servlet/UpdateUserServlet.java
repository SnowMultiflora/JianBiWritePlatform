package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dao.SqlHelper;
import com.pojo.AdminInfo;
import com.pojo.User;

/**
 * Servlet implementation class UpdateAdminServlet
 */

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String aid=(String)session.getAttribute("aid");
		
		String apwd=request.getParameter("apwd");
		String napwd=request.getParameter("napwd");
		System.out.println(aid+""+apwd+""+napwd);
		
		User user=new User(); 
		user.setAid(aid);
		user.setApwd(apwd);
		SqlHelper sqlHelper=new SqlHelper();
		User u=sqlHelper.selUser(user);
		if(u!=null){
			user.setAid(aid);
			user.setApwd(napwd);
			boolean flag2 = sqlHelper.updateUserName(user);
			
			System.out.println(flag2);
			if(flag2==true){
			response.getWriter().write("true");
			}
			else{
				response.getWriter().write("false");
			}}else{
				response.getWriter().write("1");
				
			}
		}
	}


