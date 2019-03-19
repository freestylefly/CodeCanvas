package com.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserData;

/**
 * 验证用户名
 * @author Administrator
 *
 */
public class CheckUserName extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(">>> user check userName");
		
		/* 获取参数 */
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println(userName + "," + password);
		
		/* 查询 */
		//用户数据操作对象
		UserData ud = new UserData();
		//sql
		String sql = "select * from t_user where u_userName = ?";
		//查询
		List<User> list = ud.query(sql, userName);
		
		/* 判断结果, 返回需要的数据
		 * 	通过响应对象, 将需要的数据带回原页面,
		 * 	携带的数据由页面回调函数的形参data接收.
		 *  */
		if(list.size() == 1) {
			//有查询结果, 则用户名不可用
			response.getWriter().println(0);
		}else {
			//可用
			response.getWriter().println(1);
		}
	}

}












