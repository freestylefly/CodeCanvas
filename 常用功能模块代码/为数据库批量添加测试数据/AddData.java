package com.canghe.util;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.canghe.dao.UserDaoImpl;
import com.canghe.domain.User;

public class AddData {
	//����ʹ�õ��ַ�����
	private static List<String> characters  = new LinkedList<String>();
	//Ϊ�����������
	static {
		//ѭ����������
		for (int i = 0; i < 10; i++) {
			characters.add(i+"");
		}
		//ѭ����Сд��ĸ
		for (int i = 97; i < 123; i++) {
			characters.add((char)i+"");
		}
		//ѭ�����д��ĸ
		for (int i = 65; i < 91; i++) {
			characters.add((char)i+"");
		}
	}
	public static void add(int count) throws SQLException {//countΪ��Ҫ���۶���������
		//�������ݿ�Ķ���
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		//ѭ������count������
		for (int i = 0; i < count; i++) {
			//��������
			//�û���
			String userName = randomString((int)(Math.random()*5+4));
			//����
			String password = randomString((int)(Math.random()*7+6));
			//�Ա�
			int gender =(int) (Math.random()*3);
			//ע������
			String registeTime = 
					1990 + (int) (Math.random()*21) + "-" +
					(int) (Math.random()*12 + 1) + "-" +
					(int) (Math.random()*30 + 1);
			//����user����
			User user = new User(userName,password,gender,registeTime);
			//�������
			userDaoImpl.add(user);
		}
	}
	
	
	
	/**
	 * ����ָ��λ�����ַ���
	 * @param amonut
	 * @return
	 */
	public static String randomString(int amonut) {//amonutΪλ��
		//���������ַ���
		StringBuffer sb = new StringBuffer();
		//ѭ�������ַ���
		for (int i = 0; i < amonut; i++) {
			//�����Ҫ���ַ��±�
			int index = (int)(Math.random()*characters.size());
			sb.append(characters.get(index));
		}
		return sb.toString();
	}

}
