package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;

/**
 * 登录过滤
 * @author Administrator
 *
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println(">>> login filter");
		
		/* 0. 将请求和响应的格式转换到http格式 */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		/* 判断, 会话中是否有登录信息 */
		//获取会话
		HttpSession session = request.getSession();
		//获取登录信息
		Object loginInfo = session.getAttribute("loginInfo");
//		User loginInfo = (User) session.getAttribute("loginInfo");
		
		/*
		 *  由于登录成功之前, 一定没有登录信息, 
		 *  因此访问登录页和后台登录功能的请求必须放行 
		 */
		/* 获取请求目标的路径 */
		//全路径
		String url = request.getRequestURI();
		//获取目标资源的名字(不含文件夹路径)
		String name = url.substring(url.lastIndexOf("/")+1);
		//获取目标资源的后缀
		String sufix = name.substring(name.lastIndexOf(".")+1);
		
		System.out.println("全路径:"+url);
		System.out.println("资源名:"+name);
		System.out.println("后缀名:"+sufix);
		
		//判断, 是否为null
		if(loginInfo != null) {
			//已经登录, 放行
			chain.doFilter(request, response);
		}else if(name.equals("") || name.equals("login.jsp")
				|| name.equals("login") || sufix.equals("css")
				|| sufix.equals("js")) {
			chain.doFilter(request, response);
		}else {
			//未登录, 或登录失效
			response.sendRedirect("/filter-listener-demo/login.jsp");
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
