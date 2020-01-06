package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener,ServletContextListener{//监听器
//监听appliation对象

	   @Override
	   public void contextInitialized(ServletContextEvent sce) {
	     //声明一个计数器
		   int count=0;
		   //获取Application对象
		   ServletContext sc = sce.getServletContext();
		    sc.setAttribute("count", count);
	}

	   @Override
	   public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
 //监听session对象
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//获取Application对象中的计数器
		ServletContext sc = se.getSession().getServletContext();
	      int count=(int) sc.getAttribute("count");
	      //计数器自增
	      ++count;
	      System.out.println(count);
	      //然后再将计数器存到application中
	      sc.setAttribute("count", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//获取Application对象中的计数器
				ServletContext sc = se.getSession().getServletContext();
			      int count=(int) sc.getAttribute("count");
		//计数器自减
			      --count;
			      
			      //然后再将计数器存到application中
			      sc.setAttribute("count", count); 
	}

}
