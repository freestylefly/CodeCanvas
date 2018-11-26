package dao;
/**
 * 基类
 * 1.创建连接对象
 * 2.关闭资源
 * 3.增加，删除，修改操作
 * 4.查询方法
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
	

	//静态变量可以保证类被加载的时候已经为连接参数赋值，并且只会执行一次
	private static String driver =null;
	private static String url =null;
	private static String user =null;
	private static String password =null;
	
	/*
	 * 静态代码块
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
		
		//为静态代码块赋值
		driver=proper.getProperty("driver");
		url=proper.getProperty("url");
		user=proper.getProperty("user");
		password=proper.getProperty("password");
	}
	protected Connection conn =null;
	protected PreparedStatement pstmt =null;
	protected ResultSet rs =null;
	
	/**
	 * 获取连接对象
	 * @return
	 */
	public Connection getConnection() {
		try {
			//1、加载驱动类
			Class.forName(driver);
			//2、创建连接对象
			conn=DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭资源
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
	 * 增删改操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public int exxcutUpdate(String sql,Object[] params) {
		this.getConnection();
		int result=-1;
		try {
			//3、创建prepareStatement对象
			pstmt=conn.prepareStatement(sql);
			//4、为占位符赋值
			if(null!=params) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//5.调用方法：执行sql语句
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
		}
		return result;
	}
	
	/**
	 * 查询方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet  executQuery(String sql,Object... params) {
		this.getConnection();
		try {
			//3、创建prepareStatement对象
			pstmt=conn.prepareStatement(sql);
			//4、为占位符赋值
			if(null!=params) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//5.调用方法：执行sql语句
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
