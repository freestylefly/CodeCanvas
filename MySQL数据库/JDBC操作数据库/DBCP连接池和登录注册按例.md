# 一、连接池介绍

## 1、连接池介绍

- 实际上就是存放连接的池子(容器)
- 在开发中“获得连接”或“释放资源”是非常消耗系统资源的两个过程
- 为了解决此类性能问题，通常情况我们采用连接池技术，来共享连接Connection。
- 这样我们就不需要每次都创建连接、释放连接了，这些操作都交给了连接池		

## 2、连接池概念规范和DataSource接口	

### A、连接池概念规范

- 不用自己来创建Connection，而是通过池来获取Connection对象
- 使用完Connection后，调用Connection的close()方法也不会真的关闭Connection，而是把Connection“归还”给池
- 连接池技术可以完成Connection对象的再次利用

### B、DataSource接口

- Java为数据库连接池提供了公共的接口：javax.sql.DataSource
- 各个厂商需要让自己的连接池实现这个接口。这样应用程序可以方便的切换不同厂商的连接池
- 常见的连接池：DBCP、C3P0
  ###03DBCP连接池介绍

## 3、DBCP连接池介绍

- DBCP也是一个开源的连接池，是Apache Common成员之一，在企业开发中也比较常见，tomcat内置的连接池
- tomcat是javaweb服务器，把我们写好的class文件放在Tomcat软件中，软件开启的时候会开启端口，根据不同功能返回不同结果

# 二、连接池如何使用

## 1、导入jar包

-  jar包介绍	
  - mysql-connector-java-5.1.37-bin.jar：数据库驱动
  - commons-dbutils-1.6.jar：提供QueryRunner类方便进行增删改查操作
  - commons-dbcp-1.4.jar：
  - commons-pool-1.5.6.jar：提供高效的数据库连接池技术

- b: 导入jar包
  - 在项目根路径下建立文件夹lib
  - 拷贝以上jar包，选定拷贝的jar包/右键/Build Path/Add to Build Path

# 三、BasicDataSource类的使用

连接池jar包中,定义好一个类 BasicDataSource，实现类数据源的规范接口 javax.sql.DataSource

### 1、BasicDataSource类的常见配置

分类	属性					描述
必须项	
​			driverClassName		数据库驱动名称
​			url					数据库的地址
​			username			用户名
​			password			密码
基本项（扩展）	
​			maxActive			最大连接数量
​			minIdle				最小空闲连接
​			maxIdle 				最大空闲连接（空闲连接即没有使用到的连接）
​			initialSize			初始化连接

### 2、使用DBCP实现数据库连接池工具类示例代码

```java
package Util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	//创建出BasicDataSource类对象
	private static BasicDataSource datasource= new BasicDataSource();
	//静态代码块,对象BasicDataSource对象中的配置,自定义
	static {
		//数据库连接信息,必须的
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/day33_user");
		datasource.setUsername("root");
		datasource.setPassword("aaaaa123");
		
		//对象连接池中的连接数量配置,可选的
		datasource.setInitialSize(10);//初始化的连接数
		datasource.setMaxActive(8);//最大连接数量
		datasource.setMaxIdle(5);//最大空闲数
		datasource.setMinIdle(1);//最小空闲
	}
	
	
	//定义静态方法,返回BasicDataSource类的对象
	public static DataSource getDataSource() {
		return datasource;
	}
}

```

### 3、测试写好的工具类

```java
package ui;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.naming.spi.Resolver;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import Util.JDBCUtils;

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

```

# 四、登录注册案例分析

## 1、分析

- a: 登录
  - 调用另一个类的方法,传递用户名和密码
  - 导数据表中查询是否有用户
  - 如果有，告诉用户登录成功

- b: 注册
  - 接收键盘输入的用户名和密码
  - 调用另一个类的方法,传递用户名和密码
  - 查询用户名是否存在，存在就告诉用户注册失败，不存在执行数据库的insert操作

## 2、实现步骤

- 创建数据库和数据表

- 分别建立dao、entity、mgr、service、ui、util包，各自作用如下：

  |                             dao                              |                      entity                      |                            mgr                            |                           service                            |                    ui                    |                             util                             |
  | :----------------------------------------------------------: | :----------------------------------------------: | :-------------------------------------------------------: | :----------------------------------------------------------: | :--------------------------------------: | :----------------------------------------------------------: |
  |                 对应数据库层，和数据库打交道                 |                      实体包                      |                          管理包                           |                           逻辑层包                           |                用户界面包                |                            工具类                            |
  | 包括实现类和接口，其中实现类在dao下面新建一个impl包存放（UserDao、UserDaoImpl） | 和数据表对应，有构造方法以及set、get方法（User） | 定义用户管理操作，一系列的输入输出都在这里完成（Usermgr） | 包含逻辑层接口和接口的实现类，是直接面向用户的（UserService、UserServiceImpl） | 实际中是图形化界面HTML等，这里用test代替 | 一系列的工具，这里有JDBCUtils，通过连接池来进行数据库连接操作 |

- 在项目下面建立lib文件夹，导入四个jar包，并build path

- 按照架构进行编程

### 3、各个包中具体类源码

- dao

  ```java
  package dao;
  /**
   * 对用户操作的接口
   * @author Administrator
   *
   */
  public interface UsersDao {
  	//登录
  	public Object[] login(String username,String password);
  	//注册
  	public boolean registr(String username,String password);
  }
  
  ```

  ```java
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
  
  ```

- entity

  ```java
  package entity;
  
  public class User {
  	private String username;
  	private String password;
  	public String getUsername() {
  		return username;
  	}
  	public void setUsername(String username) {
  		this.username = username;
  	}
  	public String getPassword() {
  		return password;
  	}
  	public void setPassword(String password) {
  		this.password = password;
  	}
  	public User(String username, String password) {
  		super();
  		this.username = username;
  		this.password = password;
  	}
  	public User() {
  		super();
  	}
  }
  
  ```

- mgr

  ```java
  package mgr;
  
  import java.util.Scanner;
  
  import service.UsersService;
  import service.impl.UsersServiceImpl;
  
  //用户管理类
  public class UsersMgr {
  	Scanner input = new Scanner(System.in);
  	UsersService usersService = new UsersServiceImpl();
  	private String username;
  	private String password;
  
  	/**
  	 * 主菜单
  	 */
  	public void menu() {
  		boolean flag = true;
  		do {
  			System.out.println("*****欢迎进入苍何的登录系统*****");
  			System.out.println("1、登录");
  			System.out.println("2、注册");
  			System.out.println("3、退出");
  			System.out.print("请选择：");
  			int option = input.nextInt();
  			switch (option) {
  			case 1:
  				login();
  				break;
  			case 2:
  				register();
  				break;
  			case 3:
  				System.exit(0);
  			default:
  				flag = false;
  				break;
  			}
  		} while (flag);
  
  	}
  
  	public void login() {
  		System.out.print("请输入您的用户名：");
  		username = input.next();
  		System.out.print("请输入您的密码：");
  		password = input.next();
  		boolean success = usersService.login(username, password);
  		if (success) {
  			System.out.println("登录成功，欢迎进入");
  		} else {
  			System.out.println("用户名或密码错误");
  		}
  	}
  
  	public void register() {
  		System.out.print("请输入您的用户名：");
  		username = input.next();
  		System.out.print("请输入您的密码：");
  		password = input.next();
  		boolean success = usersService.register(username, password);
  		if(success) {
  			System.out.println("注册成功");
  		}else {
  			System.out.println("用户名已存在，请重新注册");
  		}
  	}
  }
  
  ```

- service

  ```java
  package service;
  //逻辑层接口
  public interface UsersService {
  	public boolean login(String username,String password);
  	public boolean register(String username,String password);
  }
  
  ```



  ```java
  package service.impl;
  
  import dao.UsersDao;
  import dao.impl.UsersDaoImpl;
  import service.UsersService;
  
  public class UsersServiceImpl implements UsersService{
  	UsersDao usersDao = new UsersDaoImpl();
  	@Override
  	public boolean login(String username, String password) {
  		Object[] result =usersDao.login(username, password);
  		if(result.length ==0)
  			return false;
  		return true;
  	}
  
  	@Override
  	public boolean register(String username, String password) {
  		return usersDao.registr(username, password);
  	}
  
  }
  
  ```

- ui

  ```java
  package ui;
  
  import mgr.UsersMgr;
  
  public class UserOperator {
  	public static void main(String[] args) {
  		UsersMgr usersMgr = new UsersMgr();
  		usersMgr.menu();
  	}
  	
  }
  
  ```

- util

  ```java
  package util;
  
  import javax.sql.DataSource;
  
  import org.apache.commons.dbcp.BasicDataSource;
  
  public class JDBCUtils {
  	//创建出BasicDataSource类对象
  	private static BasicDataSource datasource= new BasicDataSource();
  	//静态代码块,对象BasicDataSource对象中的配置,自定义
  	static {
  		//数据库连接信息,必须的
  		datasource.setDriverClassName("com.mysql.jdbc.Driver");
  		datasource.setUrl("jdbc:mysql://localhost:3306/day33_user");
  		datasource.setUsername("root");
  		datasource.setPassword("aaaaa123");
  		
  		//对象连接池中的连接数量配置,可选的
  		datasource.setInitialSize(10);//初始化的连接数
  		datasource.setMaxActive(8);//最大连接数量
  		datasource.setMaxIdle(5);//最大空闲数
  		datasource.setMinIdle(1);//最小空闲
  	}
  	
  	
  	//定义静态方法,返回BasicDataSource类的对象
  	public static DataSource getDataSource() {
  		return datasource;
  	}
  }
  
  ```

