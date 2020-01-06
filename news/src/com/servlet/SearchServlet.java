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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search.html")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		//如果搜索内容为空，返回到index页面
		if (search=="" || "".equals(search)) {
			response.sendRedirect("index.html");
			return;
		}
		int p=StringToInt.String2Int(request.getParameter("p"));
		SqlHelper sqlHelper=new SqlHelper();
		//获取导航的数据
		List<NewsClass> list=sqlHelper.queryClassAll();
		//获取最近发布
		List <News>lastnewss=sqlHelper.queryLastNewss();
		//根据关键词做模糊查询
		List <Map>newss = sqlHelper.queryNewsMapByPage(p, null, search);
		//根据关键词查询出总的记录数
		int rows=sqlHelper.queryNewsCount(null, search);
		sqlHelper.destroy();
		
		//数据传到jsp页面
		request.setAttribute("newsClassList", list);
		request.setAttribute("lastnewss", lastnewss);
		request.setAttribute("newss", newss);
		request.setAttribute("p", p);
		request.setAttribute("rows", rows);
		request.setAttribute("search", search);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
