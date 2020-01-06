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
		//获取导航
		List <NewsClass>list=sqlHelper.queryClassAll();
	    //获取最新发布
		List <News>lastnewss=sqlHelper.queryLastNewss();
		//分页下新闻
		List <Map>newss = sqlHelper.queryNewsMapByPage(p, cid, null);
		//获取总的新闻数
		int rows=sqlHelper.queryNewsCount(cid, null);
		request.setAttribute("newsClass", sqlHelper.queryClassById(cid));//获取分类
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
