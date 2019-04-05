package com.canghe.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.canghe.domain.User;
import com.canghe.util.DataSourceUtils;

public class UserDaoImpl {
	/*声明要用到的参数*/
	//受影响的行数
	private int count;
	//dbutil中的queryrunner对象
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	//放user的集合
	List<User> userList = new ArrayList<>();
	
	/**
	 * 增加
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int add(User user) throws SQLException {
		String sql = "insert into user(username, password,gender,registeTime) values(?,?,?,?)";
		Object[] params = {user.getUserName(), user.getPassword(), user.getGender(), user.getRegisteTime()};
		count=qr.update(sql, params);
		return count;
	}
	/**
	 * 修改
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int modify(User user) throws SQLException {
		String sql = "UPDATE USER SET PASSWORD=? WHERE id=?";
		Object[] params= {user.getPassword(),user.getId()};
		count=qr.update(sql, params);
		return count;
		
	}
	/**
	 * 查询所有信user息
	 * @return
	 * @throws SQLException 
	 */
	public List<User> queryAllUser() throws SQLException{
		String sql = "select * from user";
		Object[] params = {};
		userList=qr.query(sql,new BeanListHandler<User>(User.class));
		return userList;
	}
	
	/**
	 * 根据用户名和密码查询读者信息（登录）
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User queryByNamePsd(String name,String password) throws SQLException {
		String sql = "SELECT * FROM user WHERE userName=? AND password=?";
		Object[] params = {name,password};
		User user =qr.query(sql, new BeanHandler<User>(User.class), params);
		return user;
	}
	/**
	 * 查询一共多少条数据
	 * @return
	 * @throws SQLException
	 */
	public int queryCount() throws SQLException {
		String sql = "SELECT COUNT(1) FROM user";
		count=(Integer)(qr.query(sql, new ScalarHandler<Long>()).intValue());
		return count;
	}
	/**
	 * 分页查询
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public List<User> queryByPage(int start,int pageSize) throws SQLException{
		String sql = "SELECT * FROM USER LIMIT ?,?";
		Object[] params= {start,pageSize};
		userList=qr.query(sql, new BeanListHandler<User>(User.class), params);
		return userList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
