package com.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns={"/*"}, initParams={@WebInitParam(name="encoding",value="utf-8")})

public class CharsetFilter implements Filter {

    private String encoding;
    public CharsetFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest  request=(HttpServletRequest)req;
	    HttpServletResponse response=(HttpServletResponse)res;
	   
	    //閹稿洤鐣緍equest閸滃esponse閻ㄥ嫮绱惍锟�
	    request.setCharacterEncoding(encoding);  //閸欘亜顕☉鍫熶紖娴ｆ挻婀侀弫锟�
	    response.setContentType("text/html;charset=utf-8");
	    CharacterRequest characterRequest=new CharacterRequest(request);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.encoding=fConfig.getInitParameter("encoding");
	}
	class CharacterRequest extends HttpServletRequestWrapper{

		public CharacterRequest(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String getParameter(String name) {
			String value=super.getParameter(name);
			if(value==null){
				return null;
			}
			//get閺傜懓绱￠惃鍕嚞濮瑰倸寮弫鏉跨摠閺�鎯ф躬濞戝牊浼呮径缈犺厬閿涘矂锟芥潻鍥箯閸欐湧RI閸欏倹鏆熼幍宥堝厴鏉╂稖顢戠拋鍓х枂
			String method=super.getMethod();
			if("get".equalsIgnoreCase(method)){
				try {
					value=new String(value.getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			//闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撶憲鐔荤箲閸ョ偞鏋婚幏鐑芥晸閿燂拷
			return value;
		}
		
	}
}
