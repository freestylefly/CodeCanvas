package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 在线人数监听
 * @author Administrator
 *
 */
public class CountListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
		System.out.println(">>> session create");
		
		/* 获取会话诞生前的在线人数 */
		//获取application
		ServletContext application = event.getSession().getServletContext();
		//声明变量, 在线人数
		int count = 0;
		//获取在线人数
		Object obj = application.getAttribute("count");
		//判断, obj是否为null
		if(obj != null) {
			//将在线人数赋值
			count = Integer.parseInt(obj+"");
		}
		
		/* 在线人数+1 */
		count++;
		
		/* 保存回application */
		application.setAttribute("count", count);
		
		//显示当前在线人数
		System.out.println("在线人数+1, 当前在线" + count + "人");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
		System.out.println(">>> session destroy");
		
		/* 获取会话销毁前的在线人数 */
		//获取application
		ServletContext application = event.getSession().getServletContext();
		//声明变量, 在线人数
		int count = Integer.parseInt(application.getAttribute("count")+"");
		
		/* 在线人数-1 */
		count--;
		
		/* 保存回application */
		application.setAttribute("count", count);
		
		//显示当前在线人数
		System.out.println("在线人数-1, 当前在线" + count + "人");
	}

}
