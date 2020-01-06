package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.News;
import com.pojo.NewsClass;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/item.html")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SqlHelper sqlHelper = new SqlHelper();
		List<NewsClass>list = sqlHelper.queryClassAll();
		String nid=request.getParameter("nid");
		int id=Integer.parseInt(request.getParameter("id"));
		int id1=id+1;
		int id2=id-1;
		
		News news4 = sqlHelper.queryNewsById3(id1);
	String	nid2=null;
	int  count2=0;
	News news2=null;
		if(news4==null){
			int id3=1;
			News news6 = sqlHelper.queryNewsById3(id3);
			 count2=news6.getCount();
		    nid2=news6.getNid();
			count2++;
			 sqlHelper.updateNewsById2(nid2,count2);
			news2 = sqlHelper.queryNewsById3(id3);
		
		}else{
		 count2=news4.getCount();
		 nid2=news4.getNid();
			count2++;
			 sqlHelper.updateNewsById2(nid2,count2);
			 news2 = sqlHelper.queryNewsById3(id1);
			
			
		}
		News news5 = sqlHelper.queryNewsById3(id2);
		int count3=0;
		String nid3=null;
		News news3=null;
		if(news5==null){
			int id4=1;
			News news7 = sqlHelper.queryNewsById3(id4);
			count3=news7.getCount();
			nid3=news7.getNid();
			count3++;
			 sqlHelper.updateNewsById2(nid3,count3);
			 news3 = sqlHelper.queryNewsById3(id4);
		}else{
	 count3=news5.getCount();
	nid3=news5.getNid();
	count3++;
	 sqlHelper.updateNewsById2(nid3,count3);
	 news3 = sqlHelper.queryNewsById3(id2);
		}
		
		
		
		News news1 = sqlHelper.queryNewsById2(nid);
		int count=news1.getCount();
		
		count++;
		 sqlHelper.updateNewsById2(nid,count);
		 News news = sqlHelper.queryNewsById2(nid);
		sqlHelper.destroy();
		request.setAttribute("newsClassList", list);
		request.setAttribute("news", news);
		request.setAttribute("news2", news2);
		request.setAttribute("news3", news3);
		request.getRequestDispatcher("detail.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
