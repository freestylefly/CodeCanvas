package com.canghe.web.servlet.user;

/**
 * 用户查询
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canghe.dao.UserDaoImpl;
import com.canghe.domain.User;
import com.canghe.util.PageAssitant;

public class QueryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> user query");

		/* 0. 创建必要的辅助对象 */
		// 用户数据操作对象
		// 调用后台查询所有用户信息的方法，并将数据给到jsp页面
		UserDaoImpl userDaoImpl = new UserDaoImpl();

		/* 1. 获取页面参数 */
		// 当前页页码
		String currPage = request.getParameter("currPage");
		// 页面大小
		String pageSize = request.getParameter("pageSize");

		/* 2. 设置页面助手的属性数据 */
		// 实例
		PageAssitant pa = new PageAssitant();
		// 设置总记录数
		try {
			pa.setCount(userDaoImpl.queryCount());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 设置当前页码
		// 判断, 是否为空
		if (currPage != null) {
			pa.setCurrPage(Integer.parseInt(currPage));
		}
		// 设置页面大小
		// 判断, 是否为空
		if (pageSize != null) {
			pa.setPageSize(Integer.parseInt(pageSize));
		}
		// 检查数据, 总页数与当前页的关系
		if (pa.getTotalPage() < pa.getCurrPage()) {
			// 默认去查询最后一页
			pa.setCurrPage(pa.getTotalPage());
		}

		System.out.println(pa);
		try {
			//查询
			List<User> userList = userDaoImpl.queryByPage(pa.getStart(), pa.getPageSize());
			// 判断查到的结果
			if (userList.size() >= 1) {
				// 查到了
				// 放入session作用域
				request.getSession().setAttribute("userList", userList);//页面内容
				request.getSession().setAttribute("pa", pa); //页面助手
				// 跳转到显示页面
				request.getRequestDispatcher("page/user/list.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
