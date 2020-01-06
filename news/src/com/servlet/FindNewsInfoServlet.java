package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.News;

/**
 * Servlet implementation class FindNewsInfoServlet
 */
@WebServlet("/FindNewsInfoServlet")
public class FindNewsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindNewsInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ntitle=request.getParameter("ntitle");
		//String cname=request.getParameter("cname");
		String ndate=request.getParameter("ndate");
		
		News news=new News(ntitle,ndate);
		SqlHelper nd=new SqlHelper();
		ArrayList<News> newss=nd.query(news);
		request.setAttribute("newss", newss);
	    request.getRequestDispatcher("/admin/newsInfoList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
