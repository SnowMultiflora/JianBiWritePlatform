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
 * Servlet implementation class UpdateClassServlet
 */
@WebServlet("/admin/UpdateClassServlet")
public class UpdateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClassServlet() {
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
		String cid=request.getParameter("cid");
		if(cid==null || cname==null){
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" >");
			out.println("<HTML>");
			out.println("<HEAD><TITLE></TITLE></HEAD>");
			out.println("<BODY>");
			out.print("请将信息输入完整");
			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			return;
		}
		NewsClass newsClass=new NewsClass();
		newsClass.setCid(cid);
		newsClass.setCname(cname);
		SqlHelper sqlHelper= new SqlHelper();
		boolean b=sqlHelper.updateClass(newsClass);
		if(!b){
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" >");
			out.println("<HTML>");
			out.println("<HEAD><TITLE></TITLE></HEAD>");
			out.println("<BODY>");
			out.print("类别错误");
			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			sqlHelper.destroy();
		}else{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" >");
			out.println("<HTML>");
			out.println("<HEAD><TITLE></TITLE></HEAD>");
			out.println("<BODY>");
			out.print("<script>parent.closeClassWindow(1);</script>");
			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}

}
