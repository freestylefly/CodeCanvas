package ui;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.naming.spi.Resolver;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import util.JDBCUtils;

public class QueryRunnerDemo {
	public static void main(String[] args) {
//		select();
		insert();
	}
	
	//QueryRunner类对象,写在类成员位置
	private static QueryRunner qr= new QueryRunner(JDBCUtils.getDataSource());
	//定义2个方法,实现数据表的添加,数据表查询
	
	//数据表查询
	public static void select() {
		try {
			String sql = "SELECT * FROM users";
			List<Object[]> list =qr.query(sql, new ArrayListHandler());
			//遍历对象数组集合
			for(Object[] objs:list) {
				for(Object obj:objs) {
					System.out.print(obj);
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据查询失败");
		}
	}
	
	//数据表添加数据
	public static void insert() {
		try {
			String sql="INSERT INTO users (username,PASSWORD) VALUES (?,?)";
			Object[] params = {"c","3"};
			int result=qr.update(sql, params);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("插入数据失败");
		}
	}
	
}
