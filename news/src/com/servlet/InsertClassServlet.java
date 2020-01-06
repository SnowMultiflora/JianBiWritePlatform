package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.NewsClass;

/**
 * Servlet implementation class InsertClassServlet
 */
@WebServlet("/admin/InsertClassServlet")
public class InsertClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertClassServlet() {
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
		String cname=request.getParameter("cname");
		if(cname==null||"".equals(cname)){
			response.getWriter().write("null");
		}else{
		String cid=UUID.randomUUID().toString();
		NewsClass newsClass=new NewsClass();
		newsClass.setCid(cid);
		newsClass.setCname(cname);
		SqlHelper sqlHelper= new SqlHelper();
		boolean b=sqlHelper.insertClass(newsClass);
		if(!b){
			response.getWriter().write("false");
			sqlHelper.destroy();
		}else{
			response.getWriter().write("true");
			
		}
		}
	}
	

}
