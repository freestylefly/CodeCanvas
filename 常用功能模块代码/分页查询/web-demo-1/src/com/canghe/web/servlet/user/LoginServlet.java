package com.canghe.web.servlet.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canghe.dao.UserDaoImpl;
import com.canghe.domain.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> user login");
		//处理乱码问题
		request.setCharacterEncoding("utf-8");
		/*获取登录信息*/
		//用户名
		String userName = request.getParameter("userName");
		//密码
		String password = request.getParameter("password");
		/*条用后台方法查询*/
		//UserDaoImpl才做对象
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			//调用相关查询方法 
			User queryUser = userDaoImpl.queryByNamePsd(userName, password);
			//判断登录结果
			if(queryUser!=null) {
				//登录成功
				//保存用户信息到会话对象
				request.getSession().setAttribute("loginInfo", queryUser);
				//跳转到主页
				response.sendRedirect("page/main.jsp");
			}else {
				//登录失败
				//保存错误信息到作用域
				request.getSession().setAttribute("errMsg", "用户名或密码错误!");
				//跳转到登录也
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
