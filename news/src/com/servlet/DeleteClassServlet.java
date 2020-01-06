package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.AdminInfo;
import com.pojo.News;
import com.pojo.NewsClass;

/**
 * Servlet implementation class DeleteClassServlet
 */
@WebServlet("/admin/DeleteClassServlet")
public class DeleteClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid=request.getParameter("cid");
		if(!(cid==null||"".equals(cid))){
			NewsClass newsClass= new NewsClass();
			newsClass.setCid(cid);
			SqlHelper sqlHelper = new SqlHelper();
			List<News>list =sqlHelper.queryClassByCid(cid);
			if(list.size()<1)sqlHelper.deleteClass(newsClass);
			sqlHelper.destroy();
		}
		response.sendRedirect("newsClassList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
