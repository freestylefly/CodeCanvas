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
 * 基础jdbc操作
 * @author Administrator
 *
 * @param <T>
 */
public abstract class BaseData<T> {

	/* 连接字符串 */
	//驱动类, 
	private final String DRIVER = "com.mysql.jdbc.Driver";
	//连接方式, 
	private final String URL = "jdbc:mysql://localhost:3306/jt35?characterEncoding=utf-8";
	//账号
	private final String USER = "root";
	//密码
	private final String PASSWORD = "111111";

	/* jdbc操作的对象 */
	//数据库连接对象
	protected Connection conn;
	//数据库执行对象
	protected PreparedStatement ps;
	//结果集对象
	protected ResultSet rs;
	//影响行数
	protected int count;
	
	/* 分页所需的抽象方法: 查询总记录数, 查询分页内容 */
	/**
	 * 查询总记录数
	 * @return
	 */
	public abstract int count();
	/* 抽象方法: 增, 删, 改, 查, 结果集转换 */
	/**
	 * 将一行结果集记录转换成对应的对象
	 * @return
	 */
	protected abstract T translate() throws SQLException;
	/**
	 * 添加数据<br>
	 * 添加所有字段的数据
	 * @param t
	 * @return
	 */
	public abstract int add(T t);
	/**
	 * 删除数据<br>
	 * 根据主键值删除
	 * @param t
	 * @return
	 */
	public abstract int delete(T t);
	/**
	 * 修改数据<br>
	 * 根据主键值匹配数据
	 * 修改其它所有字段的内容
	 * @param t
	 * @return
	 */
	public abstract int modify(T t);
	/**
	 * 查询
	 * @param sql
	 * @param param
	 * @return
	 */
	public abstract List<T> query(String sql, Object...param);
	
	/* 基础操作: 数据库连接, 关闭资源, 获取preparedstatement对象, 执行查询, 执行增删改 */
	
	
	/**
	 * 执行查询
	 * @param sql
	 * @param param
	 * @return
	 */
	protected List<T> executeQuery(String sql, Object...param){
		
		//0. 创建集合
		List<T> list = new ArrayList<>();
		
		//1. 获取ps
		getPs(sql, param);
		
		try {
			//2. 执行查询
			rs = ps.executeQuery();
			
			//3. 遍历rs, 将结果集转换成绩集合
			while(rs.next()) {
				//将结果集数据转换成对象后添加到集合
				list.add(translate());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. 关闭资源
		shutDown();
		
		return list;
	}
	
	/**
	 * 执行增删改
	 * @param sql
	 * @param param
	 * @return
	 */
	protected int executeUpdate(String sql, Object...param) {
		
		//1. 获取ps
		getPs(sql, param);
		
		//2. 执行增删改
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. 关闭资源
		shutDown();
		
		return count;
	}
	
	/**
	 * 获取ps对象
	 * @param sql
	 * @param param
	 * @return
	 */
	protected PreparedStatement getPs(String sql, Object...param) {
		
		//输出sql和参数
		System.out.println(sql);
		System.out.println(Arrays.toString(param));
		
		//0. 获取连接
		getConnection();
		
		try {
			//1. 获取ps实例
			ps = conn.prepareStatement(sql);
			
			//2. 添加占位符参数
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	protected Connection getConnection() {
		
		try {
			//1. 加载驱动
			Class.forName(DRIVER);
			//2. 获取连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 关闭资源
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















