package com.canghe.web.servlet.user;
/**
 * 用户注册
 */
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canghe.dao.UserDaoImpl;
import com.canghe.domain.User;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面参数
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int gender =Integer.valueOf( request.getParameter("gender"));
		//将数据封装成javabean对象
		//拿到当前日期
		Date date = new Date();
		//日期转换对象
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//将日期转换成指定格式的字符串
		String registeTime = format.format(date);
		//条用设定的构造函数构建javabean对象
		User user = new User(userName,password,gender,registeTime);
		//根据拿到的参数进入后来放入数据库
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			int count = userDaoImpl.add(user);
			//判断是否注册成功
			if(count>=1) {
				//注册成功——跳转首页,并将信息放入session作用域
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}else {
				//注册失败——跳转继续注册,通常不会注册失败 
				response.sendRedirect("/page/user/register.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
