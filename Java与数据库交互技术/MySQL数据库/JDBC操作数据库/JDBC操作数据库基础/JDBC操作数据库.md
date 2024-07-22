# 十、JDBC操作数据库

## 1、JDBC概念

JDBC是实现java程序对各种数据库的访问，是一组类和接口，位于java.sql与javax.sql包

## 2、通过JDBC连接数据库（不优化前）

```java
//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、建立连接
			String url="jdbc:mysql://localhost:3306/myschool";
			String user ="root" ;
			String password = "aaaaa123";
			con= DriverManager.getConnection(url, user, password);
			//创建sql语句
			String sql ="SELECT studentno,studentName FROM student";
			//创建对象
			pstm =con.prepareStatement(sql);
			//执行sql语句
			 rs=pstm.executeQuery();
			//处理结果
			System.out.println("编号：\t姓名：");
			while(rs.next()) {
				System.out.println(rs.getInt("studentno")+"\t"+rs.getString("studentName"));
			}
			//关闭资源
            rs.close();
            pstm.close();
            con.close();
```

Class.forName()  后加载  反射，事先不知道加载哪个类，运行时进行加载（桥接）        而Student stu =new Student() 先加载类

## 3、使用JDBC操作数据库（增删改查）（不优化前）

```java
//增加数据
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Test3 {

	public static void main(String[] args) {
		ResultSet rs =null;
		PreparedStatement pstm=null;
		Connection con =null;
		//1、加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2、建立连接
			String url="jdbc:mysql://localhost:3306/kgcnews";
			String user ="root" ;
			String password = "aaaaa123";
			con= DriverManager.getConnection(url, user, password);
			//创建sql语句
			String sql ="INSERT INTO news_category (NAME,createDate) VALUES (?,?)";
			//创建对象
			pstm =con.prepareStatement(sql);
			//给占位符赋值
			pstm.setString(1, "哈哈");
			pstm.setTimestamp(2, new Timestamp(10));
			//执行sql语句
			int i=pstm.executeUpdate();
			//处理结果
			if(i>=1) {
				System.out.println("增加成功");
			}else {
				System.out.println("未增加");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(null !=pstm) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null !=con) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

```

增删改操作类似，只是替换sql语句即可



## 4、JDBC封装和三层架构

### 1、JDBC的三层架构

- 表示层

  实际开发中的网页或者我们这里的test包，相当于现实中单客户

- 逻辑业务层

  处理逻辑业务，我们这里的service包，相当于现实中的经理

- 数据处理层

  底层处理数据层，这里的dao以及entity包，相当于员工 

为什么要进行JDBC封装？ 
主要是因为业务代码和数据访问代码的耦合。这就导致了可读性差、不利于后期修改和维护、不利于代码复用。 
所以我们采用面向接口编程，可以降低代码之间的耦合性。 

### 2、项目包

![在这里插入图片描述](https://img-blog.csdnimg.cn/2018112119171664.png)

### 3、具体实现步骤

- 先建entity包，这个包中放实体类，这里我们放pet类,，将数据库表中的字段作为pet的属性，并为其添加set和get方法，以及相应的有参和无参构造方法

```java
package entity;

public class Pet {
	private int id;
	private String name;
	private int health;
	private int love;
	private String strain;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	public Pet() {
		super();
	}
	public Pet(int id, String name, int health, int love, String strain) {
		super();
		this.id = id;
		this.name = name;
		this.health = health;
		this.love = love;
		this.strain = strain;
	}
	
}

```

- 建dao包，写BaseDao基类

  ```java
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
  import java.util.Properties;
  
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
  
  }
  
  ```



- 写数据处理层的接口

  ```java
  package dao;
  
  import java.util.List;
  
  import entity.Pet;
  
  /**
   * 接口
   * @author Administrator
   *
   */
  public interface PetDao {
  	
  	/**
  	 * 查询所有宠物列表
  	 * @return
  	 */
  	public List<Pet> findaLLPet();
  	
  	/**
  	 * 根据编号查询宠物列表
  	 * @param id
  	 * @return
  	 */
  	public Pet findAllPetById(int id);
  	
  	/**
  	 * 新增宠物
  	 * @param pet
  	 * @return
  	 */
  	public int addPet(Pet pet);
  }
  
  ```


- 写数据处理层实现类PetDaoImpl，在dao包下面建子包impl

  注意建子包要父包名点子包名，然后设置包的显示顺序

  ```java
  package dao.impl;
  
  import java.sql.SQLException;
  import java.util.ArrayList;
  import java.util.List;
  
  import dao.BaseDao;
  import dao.PetDao;
  import entity.Pet;
  
  /**
   * 实现类
   * @author Administrator
   *
   */
  public class PetDaoImpl extends BaseDao implements PetDao{
  	
  	/**
  	 * 查询所有宠物
  	 */
  	@Override
  	public List<Pet> findaLLPet() {
  		List<Pet> list =null;
  		try {
  			String sql = "SELECT id,NAME,health,love,strain FROM pet";
  			Object[] params=null;
  			//调用方法
  			rs=this.executQuery(sql, params);
  			if(null!=rs) {
  				list = new ArrayList<>();
  				while(rs.next()) {
  					Pet pet =new Pet();
  					pet.setId(rs.getInt("id"));
  					pet.setName(rs.getString("name"));
  					pet.setHealth(rs.getInt("health"));
  					pet.setLove(rs.getInt("love"));
  					pet.setStrain(rs.getString("strain"));
  					list.add(pet);
  				}
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}finally {
  			this.closeAll(conn, pstmt, rs);
  		}
  		return list;
  	}
  	
  	/**
  	 * 根据id查宠物信息
  	 */
  	@Override
  	public Pet findAllPetById(int id) {
  		Pet pet=null;
  		try {
  			String sql = "SELECT id,NAME,health,love,strain FROM pet WHERE id=?";
  			Object[] params= {id};
  			//调用方法
  			rs=this.executQuery(sql, params);
  			if(null!=rs) {
  				while(rs.next()) {
  					pet =new Pet();
  					pet.setId(rs.getInt("id"));
  					pet.setName(rs.getString("name"));
  					pet.setHealth(rs.getInt("health"));
  					pet.setLove(rs.getInt("love"));
  					pet.setStrain(rs.getString("strain"));
  				}
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}finally {
  			this.closeAll(conn, pstmt, rs);
  		}
  		return pet;
  	}
  
  	@Override
  	public int addPet(Pet pet) {
  		String sql ="INSERT INTO pet (id,NAME,health,love,strain) VALUES (DEFAULT,?,?,?,?)";
  		Object[] params= {pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain()};
  		int result =-1;
  		try {
  			result=this.exxcutUpdate(sql, params);
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return result;
  	}
  	
  }
  
  ```


- 建service包，写业务处理层的接口PetService

  ```java
  package service;
  
  import java.util.List;
  
  import entity.Pet;
  
  /**
   * 业务逻辑类
   * @author Administrator
   *
   */
  public interface PetService {
  	//查询所有宠物信息
  	public List<Pet> getAllPet();
  	//查询指定id宠物信息
  	public Pet getPetById(int id);
  	//注册
  	public boolean register(Pet pet);
  }
  
  ```




- 写业务处理层的实现类PetServiceImpl，在service包下再建一个包叫impl

  ```java
  package service.impl;
  
  import java.util.List;
  
  import dao.PetDao;
  import dao.impl.PetDaoImpl;
  import entity.Pet;
  import service.PetService;
  
  /**
   * 业务逻辑类 实现类
   * @author Administrator
   *
   */
  public class PetServiceImpl implements PetService{
  	PetDao petDao = new PetDaoImpl();
  	
  	//查询所有宠物信息
  	@Override
  	public List<Pet> getAllPet() {
  		return petDao.findaLLPet();
  	}
  	//查询指定id宠物信息
  	@Override
  	public Pet getPetById(int id) {
  		return petDao.findAllPetById(id);
  	}
  	//注册（增加宠物）
  	@Override
  	public boolean register(Pet pet) {
  		int result = petDao.addPet(pet);
  		if(result==-1) {
  			return false;
  		}else {
  			return true;
  		}
  	}
  }
  
  ```


- 建表示层测试包test

  ```java
  package test;
  
  import java.util.Scanner;
  
  import entity.Pet;
  import service.PetService;
  import service.impl.PetServiceImpl;
  
  /**
   * 表示层
   * 测试类
   * @author Administrator
   *
   */
  public class Test {
  	public static void main(String[] args) {
  		Scanner input = new Scanner(System.in);
  		PetService petService= new PetServiceImpl();
  		Pet pet =null;
  		
  		/*//测试查询所有宠物信息
  		List<Pet> list =petService.getAllPet();
  		System.out.println("编号 \t姓名\t健康值\t亲密度\t品种");
  		for (int i = 0; i < list.size(); i++) {
  			pet=list.get(i);
  			System.out.println(pet.getId()+"\t"+pet.getName()+"\t"+pet.getHealth()+"\t"+pet.getLove()+"\t"+pet.getStrain());
  		}
  		*/
  		
  		
  		/*//测试查询指定id宠物信息
  		System.out.print("请输入您要查找的宠物的id：");
  		int id =input.nextInt();
  		pet=petService.getPetById(id);
  		System.out.println("编号 \t姓名\t健康值\t亲密度\t品种");
  		System.out.println(pet.getId()+"\t"+pet.getName()+"\t"+pet.getHealth()+"\t"+pet.getLove()+"\t"+pet.getStrain());*/
  		
  		
  		//注册测试
  		pet = new Pet();
  		System.out.print("请输入姓名：");
  		pet.setName(input.next());
  		System.out.print("请输入健康值：");
  		pet.setHealth(input.nextInt());
  		System.out.print("请输入亲密度：");
  		pet.setLove(input.nextInt());
  		System.out.print("请输入亲品种：");
  		pet.setStrain(input.next());
  		boolean isSuccess=petService.register(pet);
  		if(isSuccess) {
  			System.out.println("注册成功1");
  		}else {
  			System.out.println("注册失败1");
  		}
  		
  		
  	}
  }
  
  ```


### 4、将相关数据写入配置文件

```
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
	}
```

### 5、配置文件信息

项目右键new一个resouces folder，然后new一个file，名字以.properties作为后缀名，配置文件是键值对形式存在，名字自己宿便取

```sql
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/epet?useUnicade=true&characterEncoding=UTF-8
user=root
password=aaaaa123
```

### 6、用到的数据库信息

```sql
/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.47-community : Database - epet

------

*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`epet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `epet`;

/*Table structure for table `master` */

DROP TABLE IF EXISTS `master`;

CREATE TABLE `master` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `name` varchar(12) DEFAULT NULL COMMENT '姓名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `money` int(11) DEFAULT NULL COMMENT '元宝数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `master` */

insert  into `master`(`id`,`name`,`password`,`money`) values (1,'jack','1234',2000),(2,'rose','1234',3000),(3,'smith','1234',4000);

/*Table structure for table `pet` */

DROP TABLE IF EXISTS `pet`;

CREATE TABLE `pet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `name` varchar(12) DEFAULT NULL COMMENT '昵称',
  `health` int(11) DEFAULT NULL COMMENT '健康值',
  `love` int(11) DEFAULT NULL COMMENT '亲密度',
  `strain` varchar(20) DEFAULT NULL COMMENT '品种',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `pet` */

insert  into `pet`(`id`,`name`,`health`,`love`,`strain`) values (1,'欧欧',80,15,'雪瑞纳'),(5,'亚亚',100,0,'拉布拉多'),(9,'美美',90,66,'雪瑞纳'),(10,'菲菲',90,50,'拉布拉多');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
```

