package dao;
/**
 * ����
 * 1.�������Ӷ���
 * 2.�ر���Դ
 * 3.���ӣ�ɾ�����޸Ĳ���
 * 4.��ѯ����
 * @author Administrator
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import entity.Master;

public class BaseDao {
	

	//��̬�������Ա�֤�౻���ص�ʱ���Ѿ�Ϊ���Ӳ�����ֵ������ֻ��ִ��һ��
	private static String driver =null;
	private static String url =null;
	private static String user =null;
	private static String password =null;
	
	/*
	 * ��̬�����
	 */
	static {
		Properties proper = new Properties();
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			proper.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Ϊ��̬����鸳ֵ
		driver=proper.getProperty("driver");
		url=proper.getProperty("url");
		user=proper.getProperty("user");
		password=proper.getProperty("password");
	}
	protected Connection conn =null;
	protected PreparedStatement pstmt =null;
	protected ResultSet rs =null;
	
	/**
	 * ��ȡ���Ӷ���
	 * @return
	 */
	public Connection getConnection() {
		try {
			//1������������
			Class.forName(driver);
			//2���������Ӷ���
			conn=DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ر���Դ
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(null!=conn) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(null!=pstmt) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(null!=rs) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ɾ�Ĳ���
	 * @param sql
	 * @param params
	 * @return
	 */
	public int exxcutUpdate(String sql,Object[] params) {
		this.getConnection();
		int result=-1;
		try {
			//3������prepareStatement����
			pstmt=conn.prepareStatement(sql);
			//4��Ϊռλ����ֵ
			if(null!=params) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//5.���÷�����ִ��sql���
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
		}
		return result;
	}
	
	/**
	 * ��ѯ����
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet  executQuery(String sql,Object... params) {
		this.getConnection();
		try {
			//3������prepareStatement����
			pstmt=conn.prepareStatement(sql);
			//4��Ϊռλ����ֵ
			if(null!=params) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//5.���÷�����ִ��sql���
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public List<Master> findAllMaster() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}
