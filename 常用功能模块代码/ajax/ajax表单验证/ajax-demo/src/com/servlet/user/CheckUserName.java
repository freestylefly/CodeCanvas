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
 * ��֤�û���
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
		
		/* ��ȡ���� */
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println(userName + "," + password);
		
		/* ��ѯ */
		//�û����ݲ�������
		UserData ud = new UserData();
		//sql
		String sql = "select * from t_user where u_userName = ?";
		//��ѯ
		List<User> list = ud.query(sql, userName);
		
		/* �жϽ��, ������Ҫ������
		 * 	ͨ����Ӧ����, ����Ҫ�����ݴ���ԭҳ��,
		 * 	Я����������ҳ��ص��������β�data����.
		 *  */
		if(list.size() == 1) {
			//�в�ѯ���, ���û���������
			response.getWriter().println(0);
		}else {
			//����
			response.getWriter().println(1);
		}
	}

}












