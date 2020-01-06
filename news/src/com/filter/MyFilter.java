package com.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Url;



public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//设置请求编码格式
		request.setCharacterEncoding("utf-8");
		//设置响应编码格式
		response.setContentType("text/html;charset=utf-8");
		//强转request对象
		HttpServletRequest req=((HttpServletRequest)request);
		//强转response对象
		HttpServletResponse resp=((HttpServletResponse)response);
		//获取此次请求uri
		String uri=req.getRequestURI();
		
		System.out.println("当前请求的uri为:"+uri);
		if(("/news/login.jsp".equals(uri))){
			//放行
			chain.doFilter(request, response);
		}else{
		//放行登录页面  放行登录请求 放行静态资源
			
				//session管理(session统一校验)
					//获取Session对象
						HttpSession session = req.getSession();
						Object obj=session.getAttribute("aid");
						
					//判断
						if(obj!=null){
							//获取权限信息
								List<Url> lu=(List<Url>) session.getAttribute("lu");
								
							//权限校验
								for(Url url:lu){
									if(url.getLocation().equals(uri)){
										//放行
										chain.doFilter(request, response);
										return;
									}
								}
							
								
							//响应
								resp.getWriter().write("power");
								return;
						}else{
							//重定向到登录页面
						}		resp.sendRedirect("/news/login.jsp");
						}
			}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}