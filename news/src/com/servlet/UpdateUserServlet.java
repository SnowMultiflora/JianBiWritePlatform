package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String aid=request.getParameter("aid");
		String aname=request.getParameter("aname");
		String apwd=request.getParameter("apwd");
		System.out.println(aid+""+apwd+""+aname);
		User user=new User(); 
		user.setAid(aid);
		user.setAname(aname);
		user.setApwd(apwd);
		
			SqlHelper sqlHelper=new SqlHelper();
			boolean flag = sqlHelper.updateUserName(user);
			System.out.println(flag);
			sqlHelper.destroy();
			if(flag==true){
			response.getWriter().write("true");
			}
			else{
				response.getWriter().write("false");
			}
		}
	}


