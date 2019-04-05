package com.canghe.web.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canghe.dao.UserDaoImpl;
import com.canghe.domain.User;

public class ChangePasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拿到页面提交的数据
		String newPassword = request.getParameter("newPassword");
		//拿到session作用域中的user
		User user = (User) request.getSession().getAttribute("loginInfo");
		user.setPassword(newPassword);
		//根据拿到的password去修改密码
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			int count = userDaoImpl.modify(user);
			if(count>=1) {
				//修改成功
				response.sendRedirect(request.getContextPath()+"/page/user/changePassword.jsp");
				request.getSession().setAttribute("succsize", "密码修改成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
