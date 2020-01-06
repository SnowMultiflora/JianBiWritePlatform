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

/**
 * Servlet implementation class UpdateAdminServlet
 */

public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
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
		String phone=request.getParameter("phone");
		AdminInfo adminInfo =new AdminInfo();
		adminInfo.setAid(aid);
		adminInfo.setAname(aname);
		adminInfo.setApwd(apwd);
		adminInfo.setPhone(phone);
			SqlHelper sqlHelper=new SqlHelper();
			boolean flag = sqlHelper.updateAdminName(adminInfo);
			sqlHelper.destroy();
			if(flag==true){
				response.getWriter().write("true");
				}
				else{
					response.getWriter().write("false");
				}
			
		}
	}


