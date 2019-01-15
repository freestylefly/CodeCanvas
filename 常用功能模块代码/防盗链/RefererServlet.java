package com.ithiema.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//对该新闻的来源的进行判断
		String header = request.getHeader("referer");
		if(header!=null&&header.startsWith("http://localhost")){
			//是从我自己的网站跳转过来的 可以看新闻
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("中国确实已经拿到100块金牌....");
		}else{
			response.getWriter().write("你是盗链者，可耻！！");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}