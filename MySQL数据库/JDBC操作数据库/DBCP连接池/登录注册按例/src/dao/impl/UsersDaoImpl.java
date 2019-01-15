package dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.UsersDao;
import util.JDBCUtils;

/**
 * 对用户操作的实体类
 * @author Administrator
 *
 */
public class UsersDaoImpl implements UsersDao{
	
	//创建QueryRunner类的对象,构造方法中,传递工具类中获取的数据源
	private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	
	/**
	 * 创建登录功能
	 *  用户名和密码,作为数据表users的查询条件,查询表结果集
	 */
	@Override
	public Object[] login(String username, String password) {
		try {
			String sql="SELECT * FROM users WHERE username=? AND PASSWORD=?";
			Object[] params = {username,password};
			Object[] result = queryRunner.query(sql, new ArrayHandler(), params);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("登录查询失败");
		}
	}
	
	/**
	 * 创建注册功能
	 * 接收用户的输入用户名和密码
	 * 检查用户名是否被占
	 * 	  将用户输入的用户名,作为users表查询条件
	 * 	如果有结果集,说明用户名已经有了
	 * 如果没有结果集,用户名可以使用, 用户名和密码insert 写入到数据表
	 */
	@Override
	public boolean registr(String username, String password) {
		try {
			String sql = "SELECT username FROM users WHERE username=?";
			//调用qr对象方法query查询结果集,ScalarHandler 一个结果集
			String user=queryRunner.query(sql, new ScalarHandler<String>(), username);
			if(user !=null)
				return false;
			//用户名可以使用
			//把用户名和密码放入数据库
			sql="INSERT INTO users (username,PASSWORD) VALUES (?,?)";
			Object[] params = {username,password};
			queryRunner.update(sql, params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("注册失败");
		}
	}
	
}
