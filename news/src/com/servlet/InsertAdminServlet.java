package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.AdminInfo;


/**
 * Servlet implementation class InsertAdminServlet
 */
@WebServlet("/admin/InsertAdminServlet")
public class InsertAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
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
		String aid = request.getParameter("aid");
		String aname = request.getParameter("aname");
		String apwd = request.getParameter("apwd");
		String phone = request.getParameter("phone");
		SqlHelper sqlHelper1=new SqlHelper();
		
		AdminInfo adminInfo= new AdminInfo();
		adminInfo.setAid((aid));
		adminInfo.setAname((aname));
		adminInfo.setApwd(apwd);
		adminInfo.setPhone(phone);
		if(adminInfo.getAid()==null||"".equals(adminInfo.getAid())
				||adminInfo.getAname()==null||"".equals(adminInfo.getAname())
				||adminInfo.getApwd()==null||"".equals(adminInfo.getPhone())||"".equals(adminInfo.getPhone())){
			response.getWriter().write("null");
		}else{
			SqlHelper sqlHelper=new SqlHelper();
			if(sqlHelper.queryAdminInfoById(adminInfo.getAid())!=null){
				response.getWriter().write("false");
				sqlHelper.destroy();
			}else{
				boolean b= sqlHelper.insertAdmin(adminInfo);
				sqlHelper.destroy();
				response.getWriter().write("true");
			}	
		}
		
	}

}
