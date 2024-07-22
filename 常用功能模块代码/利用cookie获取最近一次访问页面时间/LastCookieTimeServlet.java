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
		//�����������
		response.setContentType("text/html;charset=utf-8");
		// ��ǰʱ��
		Date date = new Date();
		// ת����ָ����ʽ���ַ���
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		// ����cookie
		Cookie cookie = new Cookie("name", currentTime);
		// ��������cookieд��ͻ���
		response.addCookie(cookie);
		// �������õ��ͻ���Я��������cookie
		Cookie[] cookies = request.getCookies();
		//���һ�εķ���ʱ��
		String lastTime=null;
		if (null != cookies) {
			for (Cookie cookie2 : cookies) {
				String nameCookie = cookie2.getName();
				if (nameCookie.equals("name")) {
					lastTime = cookie2.getValue();
				}
			}
		}
		//�ж��ǲ��ǵ�һ�η���
		if(lastTime==null) {//��һ�η���
			response.getWriter().write("��ӭ���״η��ʱ���վҳ�棡");
		}else {
			response.getWriter().write("�����һ�η��ʸ�ҳ����¼���"+lastTime);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
