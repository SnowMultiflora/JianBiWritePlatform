package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.News;
import com.pojo.NewsClass;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Index2.html")
public class IndexServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SqlHelper sqlHelper=new SqlHelper();
		//��ȡ����
		List <NewsClass>list=sqlHelper.queryClassAll();
		List <Map>resultList = new ArrayList();
		//��ȡ������Ϣ
		
		
			 List<News> news=sqlHelper.queryNewsByCidIndex2();
		
			
				sqlHelper.destroy();
		request.setAttribute("newsClassList", list);
		request.setAttribute("resultList", news);
		request.getRequestDispatcher("list2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
