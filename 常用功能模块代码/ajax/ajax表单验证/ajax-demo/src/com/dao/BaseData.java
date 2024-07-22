package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����jdbc����
 * @author Administrator
 *
 * @param <T>
 */
public abstract class BaseData<T> {

	/* �����ַ��� */
	//������, 
	private final String DRIVER = "com.mysql.jdbc.Driver";
	//���ӷ�ʽ, 
	private final String URL = "jdbc:mysql://localhost:3306/jt35?characterEncoding=utf-8";
	//�˺�
	private final String USER = "root";
	//����
	private final String PASSWORD = "111111";

	/* jdbc�����Ķ��� */
	//���ݿ����Ӷ���
	protected Connection conn;
	//���ݿ�ִ�ж���
	protected PreparedStatement ps;
	//���������
	protected ResultSet rs;
	//Ӱ������
	protected int count;
	
	/* ��ҳ����ĳ��󷽷�: ��ѯ�ܼ�¼��, ��ѯ��ҳ���� */
	/**
	 * ��ѯ�ܼ�¼��
	 * @return
	 */
	public abstract int count();
	/* ���󷽷�: ��, ɾ, ��, ��, �����ת�� */
	/**
	 * ��һ�н������¼ת���ɶ�Ӧ�Ķ���
	 * @return
	 */
	protected abstract T translate() throws SQLException;
	/**
	 * �������<br>
	 * ��������ֶε�����
	 * @param t
	 * @return
	 */
	public abstract int add(T t);
	/**
	 * ɾ������<br>
	 * ��������ֵɾ��
	 * @param t
	 * @return
	 */
	public abstract int delete(T t);
	/**
	 * �޸�����<br>
	 * ��������ֵƥ������
	 * �޸����������ֶε�����
	 * @param t
	 * @return
	 */
	public abstract int modify(T t);
	/**
	 * ��ѯ
	 * @param sql
	 * @param param
	 * @return
	 */
	public abstract List<T> query(String sql, Object...param);
	
	/* ��������: ���ݿ�����, �ر���Դ, ��ȡpreparedstatement����, ִ�в�ѯ, ִ����ɾ�� */
	
	
	/**
	 * ִ�в�ѯ
	 * @param sql
	 * @param param
	 * @return
	 */
	protected List<T> executeQuery(String sql, Object...param){
		
		//0. ��������
		List<T> list = new ArrayList<>();
		
		//1. ��ȡps
		getPs(sql, param);
		
		try {
			//2. ִ�в�ѯ
			rs = ps.executeQuery();
			
			//3. ����rs, �������ת���ɼ�����
			while(rs.next()) {
				//�����������ת���ɶ������ӵ�����
				list.add(translate());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. �ر���Դ
		shutDown();
		
		return list;
	}
	
	/**
	 * ִ����ɾ��
	 * @param sql
	 * @param param
	 * @return
	 */
	protected int executeUpdate(String sql, Object...param) {
		
		//1. ��ȡps
		getPs(sql, param);
		
		//2. ִ����ɾ��
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. �ر���Դ
		shutDown();
		
		return count;
	}
	
	/**
	 * ��ȡps����
	 * @param sql
	 * @param param
	 * @return
	 */
	protected PreparedStatement getPs(String sql, Object...param) {
		
		//���sql�Ͳ���
		System.out.println(sql);
		System.out.println(Arrays.toString(param));
		
		//0. ��ȡ����
		getConnection();
		
		try {
			//1. ��ȡpsʵ��
			ps = conn.prepareStatement(sql);
			
			//2. ���ռλ������
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	protected Connection getConnection() {
		
		try {
			//1. ��������
			Class.forName(DRIVER);
			//2. ��ȡ����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * �ر���Դ
	 */
	protected void shutDown() {
		
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}















