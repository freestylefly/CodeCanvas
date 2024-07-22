package com.heima.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastCookieTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码问题
		response.setContentType("text/html;charset=utf-8");
		// 当前时间
		Date date = new Date();
		// 转换成指定格式的字符串
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		// 创建cookie
		Cookie cookie = new Cookie("name", currentTime);
		// 服务器将cookie写入客户端
		response.addCookie(cookie);
		// 服务器拿到客户端携带过来的cookie
		Cookie[] cookies = request.getCookies();
		//最近一次的访问时间
		String lastTime=null;
		if (null != cookies) {
			for (Cookie cookie2 : cookies) {
				String nameCookie = cookie2.getName();
				if (nameCookie.equals("name")) {
					lastTime = cookie2.getValue();
				}
			}
		}
		//判断是不是第一次访问
		if(lastTime==null) {//第一次访问
			response.getWriter().write("欢迎您首次访问本网站页面！");
		}else {
			response.getWriter().write("您最近一次访问该页面的事件是"+lastTime);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
