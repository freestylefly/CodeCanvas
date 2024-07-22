package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.User;

/**
 * 用户数据操作
 * @author Administrator
 *
 */
public class UserData extends BaseData<User> {

	@Override
	protected User translate() throws SQLException {
		
		//创建user对象
		User u = new User();
		
		//添加各个属性的数据
		u.setId(rs.getInt("u_id"));
		u.setUserName(rs.getString("u_userName"));
		u.setPassword(rs.getString("u_password"));
		u.setGender(rs.getInt("u_gender"));
		u.setRegisteTime(rs.getDate("u_registeTime"));
		
		return u;
	}

	@Override
	public int add(User t) {
		
		//sql
		String sql = "insert into t_user(u_username, u_password, "
				+ "u_gender, u_registeTime) values(?,?,?,?)";
		
		//参数数组
		Object[] param = {
			t.getUserName(), t.getPassword(), 
			t.getGender(), t.getRegisteTime()
		};
		
		//执行获取结果
		count = executeUpdate(sql, param);
		
		return count;
	}

	@Override
	public int delete(User t) {
		
		//sql
		String sql = "delete from t_user where u_id = ?";
		
		//执行
		count = executeUpdate(sql, t.getId());
		
		return count;
	}

	@Override
	public int modify(User t) {
		
		//sql
		String sql = "update t_user set u_userName = ?, u_password = ?,"
				+ " u_gender = ?, u_registeTime = ?"
				+ " where u_id = ?";
		
		//参数数组
		Object[] param = {
			t.getUserName(), t.getPassword(), t.getGender(),
			t.getRegisteTime(), t.getId()
		};
		
		//执行
		count = executeUpdate(sql, param);
		
		return count;
	}

	@Override
	public List<User> query(String sql, Object... param) {
		return executeQuery(sql, param);
	}

	@Override
	public int count() {
		
		//sql
		String sql = "select count(u_id) from t_user";
		
		//构建ps
		getPs(sql);
		
		try {
			//执行
			rs = ps.executeQuery();
			
			//读取一条记录
			rs.next();
			
			//将结果转换成整数
			count = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	

}
