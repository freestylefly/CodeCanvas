package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.User;

/**
 * �û����ݲ���
 * @author Administrator
 *
 */
public class UserData extends BaseData<User> {

	@Override
	protected User translate() throws SQLException {
		
		//����user����
		User u = new User();
		
		//��Ӹ������Ե�����
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
		
		//��������
		Object[] param = {
			t.getUserName(), t.getPassword(), 
			t.getGender(), t.getRegisteTime()
		};
		
		//ִ�л�ȡ���
		count = executeUpdate(sql, param);
		
		return count;
	}

	@Override
	public int delete(User t) {
		
		//sql
		String sql = "delete from t_user where u_id = ?";
		
		//ִ��
		count = executeUpdate(sql, t.getId());
		
		return count;
	}

	@Override
	public int modify(User t) {
		
		//sql
		String sql = "update t_user set u_userName = ?, u_password = ?,"
				+ " u_gender = ?, u_registeTime = ?"
				+ " where u_id = ?";
		
		//��������
		Object[] param = {
			t.getUserName(), t.getPassword(), t.getGender(),
			t.getRegisteTime(), t.getId()
		};
		
		//ִ��
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
		
		//����ps
		getPs(sql);
		
		try {
			//ִ��
			rs = ps.executeQuery();
			
			//��ȡһ����¼
			rs.next();
			
			//�����ת��������
			count = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	

}
