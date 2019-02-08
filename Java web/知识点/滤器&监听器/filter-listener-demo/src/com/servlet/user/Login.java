package com.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserData;

/**
 * 用户登录
 * @author Administrator
 *
 */
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println(">>> user login");
		
		/* 获取登录信息 */
		//用户名
		String userName = request.getParameter("userName");
		//密码
		String password = request.getParameter("password");
		
		/* 查询 */
		//user数据操作对象
		UserData ud = new UserData();
		//sql
		String sql = "select * from t_user where u_userName = ? and u_password = ?";
		//查询
		List<User> list = ud.query(sql, userName, password);
		
		/* 判断登录结果 */
		/* 获取作用域对象 */
		//会话
		HttpSession session = request.getSession();
		//应用程序
		ServletContext application = session.getServletContext();
		
		if(list.size() == 1) {
			//登录成功
			//设置登录时效
			session.setMaxInactiveInterval(10);
			//保存登录用户的数据到会话
			session.setAttribute("loginInfo", list.get(0));
			//跳转到主页
			response.sendRedirect("page/main.jsp");
		}else {
			//登录失败
			//保存失败信息到会话
			session.setAttribute("errMsg", "用户名或密码错误!!!");
			//跳转到登录页
			response.sendRedirect("login.jsp");
		}
		
	}

}













