package com.servlet;

import java.io.IOException;
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
import com.tools.StringToInt;

/**
 * Servlet implementation class NewsListServlet
 */
@WebServlet("/newsList.html")
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p=StringToInt.String2Int(request.getParameter("p"));
		String cid = request.getParameter("cid");
		SqlHelper sqlHelper = new SqlHelper();
		//��ȡ����
		List <NewsClass>list=sqlHelper.queryClassAll();
	    //��ȡ���·���
		List <News>lastnewss=sqlHelper.queryLastNewss();
		//��ҳ������
		List <Map>newss = sqlHelper.queryNewsMapByPage2(p, cid, null);
		//��ȡ�ܵ�������
		int rows=sqlHelper.queryNewsCount2(cid, null);
		request.setAttribute("newsClass", sqlHelper.queryClassById(cid));//��ȡ����
		request.setAttribute("newsClassList", list);
		request.setAttribute("lastnewss", lastnewss);
		request.setAttribute("cid",cid);
		request.setAttribute("newss", newss);
		request.setAttribute("rows", rows);
		request.setAttribute("p", p);
		sqlHelper.destroy();
		request.getRequestDispatcher("list.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
