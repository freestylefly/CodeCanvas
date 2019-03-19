package com.canghe.util;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.canghe.dao.UserDaoImpl;
import com.canghe.domain.User;

public class AddData {
	//可以使用的字符集合
	private static List<String> characters  = new LinkedList<String>();
	//为集合添加数据
	static {
		//循环调价数字
		for (int i = 0; i < 10; i++) {
			characters.add(i+"");
		}
		//循环添小写字母
		for (int i = 97; i < 123; i++) {
			characters.add((char)i+"");
		}
		//循环添大写字母
		for (int i = 65; i < 91; i++) {
			characters.add((char)i+"");
		}
	}
	public static void add(int count) throws SQLException {//count为需要调价多少条数据
		//操作数据库的对象
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		//循环调价count条数据
		for (int i = 0; i < count; i++) {
			//构建属性
			//用户名
			String userName = randomString((int)(Math.random()*5+4));
			//密码
			String password = randomString((int)(Math.random()*7+6));
			//性别
			int gender =(int) (Math.random()*3);
			//注册日期
			String registeTime = 
					1990 + (int) (Math.random()*21) + "-" +
					(int) (Math.random()*12 + 1) + "-" +
					(int) (Math.random()*30 + 1);
			//创建user对象
			User user = new User(userName,password,gender,registeTime);
			//添加数据
			userDaoImpl.add(user);
		}
	}
	
	
	
	/**
	 * 构建指定位数的字符串
	 * @param amonut
	 * @return
	 */
	public static String randomString(int amonut) {//amonut为位数
		//创建缓冲字符串
		StringBuffer sb = new StringBuffer();
		//循环构建字符串
		for (int i = 0; i < amonut; i++) {
			//随机需要的字符下标
			int index = (int)(Math.random()*characters.size());
			sb.append(characters.get(index));
		}
		return sb.toString();
	}

}
