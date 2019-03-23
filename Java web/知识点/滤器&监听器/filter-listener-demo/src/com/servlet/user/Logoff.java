package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户退出
 * @author Administrator
 *
 */
public class Logoff extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println(">>> user logoff");
		
		/* 销毁会话 */
		//获取会话
		HttpSession session = request.getSession();
		//销毁
		session.invalidate();
		
		/* 跳转到登录页 */
		response.sendRedirect("login.jsp");
	}

}











