package com.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.News;

public class ResultServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		   String tex= req.getParameter("tex");
		   String resul=req.getParameter("resul");
		   
		   String ntitle=req.getParameter("ntitle");
			String ndate=req.getParameter("ndate");
			String ncontent=req.getParameter("ncontent1");
			String cid=req.getParameter("cid");
			String nid=req.getParameter("nid");
			String author=req.getParameter("author");
			String teacher=req.getParameter("teacher");
			
		
		 //处理请求信息
		        if(("已审核").equals(resul)){
		        	News news = new News();
		    		news.setNcontent(ncontent);
		    		news.setNdate(ndate);
		    		news.setCid(cid);
		    		news.setNtitle(ntitle);
		    		news.setNid(nid);
		    		news.setAuthor(author);
		    		news.setResult(resul);
		    		news.setTex(tex);
		    		news.setTeacher(teacher);
		    		SqlHelper sqlHelper=new SqlHelper();
		    		boolean b = sqlHelper.updateNews2(news);
		    		
		    		
		    			
		    			String nid2=UUID.randomUUID().toString();
		    			
		    			news.setNid(nid2);
		    			sqlHelper.insertNews(news);
		    			resp.getWriter().write("true");
		    			sqlHelper.destroy();
		    		
		        	
		        }else if(("驳回").equals(resul)){
		        	News news = new News();
		    		news.setNcontent(ncontent);
		    		news.setNdate(ndate);
		    		news.setCid(cid);
		    		news.setNtitle(ntitle);
		    		news.setNid(nid);
		    		news.setAuthor(author);
		    		news.setResult(resul);
		    		news.setTex(tex);
		    		news.setTeacher(teacher);
		    		SqlHelper sqlHelper=new SqlHelper();
		    		boolean b = sqlHelper.updateNews2(news);
		    		sqlHelper.destroy();
		    		
		    		
		    			resp.getWriter().write("false");
		    		
		    			
		    		}
		    			
		    		}
		        	
		        	
		        }
		   
		
		
	


