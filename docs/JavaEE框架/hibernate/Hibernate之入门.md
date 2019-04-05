# 一、什么是框架？

框架是软件的半成品，已完成部分功能，调用相应的方法，可以简化开发，提高开发效率

# 二、javaEE三层架构和对应的企业级框架

客户端层：HTML+CSS+JS

## 1、web层

1）servlet+jsp

2） SpringMVC

3）Strute2

## 2、业务层

1）javabean

2）Spring

## 3、持久层

1）JDBC

2）Hibernate

3）Mybatis

# 三、SSH和SSM

这两个都是目前流行的企业级组合开发框架

SSH是指：Strute2+Spring+Hibernate

SSM是指：SpringMVC+Spring+Mybatis

# 四、什么是Hibernate

 是一个持久层的ORM框架

# 五、什么是ORM

Object Ralational Mapping

对象关系映射

使表和类建立关系，直接操作类相当于操作表

# 六、hibernate开发步骤

## 1、导入所需的jar包

1）数据库驱动包

2）hibernate所必须包：requied

3）日志记录包

## 2、建库建表

## 3、实体类

## 4、创建映射

1）映射和实体类在同一个包中

2）映射的名字：类名.hbm.xml

3）xml的约束本分可在hibernate的核心包中copy

4）三个字标签：

​	class：属性（name：实体类全路径，table：表名）

​	id:(属性：name类名  column：主键字段名)，主键与相应的属性建立一一映射的关系

​	property（属性同id）——对应除了主键之外的列和类的属性建立一一映射的关系



实例：

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC 
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<!-- 建立类和表的一个映射关系 --> 
<hibernate-mapping>
	<class name="com.canghe.domain.Customer" table="cst_customer">
		<!-- 建立表中主键和类中属性的映射关系 -->
		<id name="cust_id" column="cust_id">
			<!-- 主键生成策略 -->
			<generator class="native"/>
		</id>
		<!-- 建立表中其他字段和类中属性进行一一对应 -->
		<property name="cust_name" column="cust_name"></property>
		<property name="cust_source" column="cust_source"></property>
		<property name="cust_industry" column="cust_industry"></property>
		<property name="cust_level" column="cust_level"></property>
		<property name="cust_phone" column="cust_phone"></property>
		<property name="cust_mobile" column="cust_mobile"></property>
	</class>
</hibernate-mapping>   
```

## 5、hibernate核心配置文件

1）在src文件下

2）文件名：hibernate.cfg.xml

3）xml约束在hibernate核心文件中copy，相应的必要配置可在project下的hibernate.properties下查找

4）四个必要参数

数据库驱动+url+username+password

5）可选配置

显示sql+格式化sql+自动建表

6）映射文件

实例：

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
	<session-factory>
		<!-- 必要的配置信息,连接数据库中的基本参数 -->
		<property name="hibernate.connection.driver_class">
			com.mysql.jdbc.Driver
		</property>
		<property name="hibernate.connection.url">
			jdbc:mysql:///test
		</property>
		<property name="hibernate.connection.username">
			root
		</property>
		<property name="hibernate.connection.password">
			aaaaa123
		</property>
		<!-- hibernate的属性 -->
		<!-- hibernate方言 , 作用：根据配置的方言生成相应的Sql语句-->
		<property name="hibernate.dialect">
			org.hibernate.dialect.MySQLDialect
		</property>
		
		<!-- 可选配置 -->
		<!-- 打印sql、 -->
		<property name="hibernate.show_sql">
			true
		</property>
		<!-- 格式化sql语句、 -->
		<property name="hibernate.format_sql">
			true
		</property>
		<!-- 自动建表 -->
		<property name="hibernate.hbm2ddl.auto">
			update
		</property>
		
		<!-- hibernate 加载映射 -->
		<mapping resource="com/canghe/domain/Customer.hbm.xml"/>
	</session-factory>
</hibernate-configuration>	
```

# 七、工具类hibernateUtils

```java
package com.canghe.util;
/**
 * 工具类
 * @author Administrator
 *
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final Configuration configuration;
	private static final SessionFactory sessionFactory;
	
	static {
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session openSission() {
		return sessionFactory.openSession();
	}
}

```

# 八、CURD测试

```java
package com.canghe.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.canghe.domain.Customer;
import com.canghe.util.HibernateUtils;

public class HibernateDemo2 {
	@Test
	/**
	 * 增加（保存对象）
	 */
	public void demo1() {
		//获得session链接对象
		Session session = HibernateUtils.openSission();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//处理
		Customer customer = new Customer();
		customer.setCust_name("小一");
		Serializable id = session.save(customer);
		System.out.println(id);
		//事务提交
		transaction.commit();
		//关闭资源
		session.close();
	}
	
	@Test
	/**
	 * 删除
	 */
	public void demo2() {
		Session session = HibernateUtils.openSission();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 4L);
		session.delete(customer);
		transaction.commit();
		session.close();
	}
	
	@Test
	/**
	 * 修改
	 */
	public void demo3() {
		Session session = HibernateUtils.openSission();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 5L);
		customer.setCust_name("小三");
		customer.setCust_phone("18603016817");
		session.update(customer);
		transaction.commit();
		session.close();
	}
	@Test
	/**
	 * 查询
	 */
	public void demo4() {
		Session session = HibernateUtils.openSission();
		Transaction transaction = session.beginTransaction();
		//get和load方法的区别，load是延迟加载
		Customer customer = session.get(Customer.class, 5L);
		System.out.println(customer);
		Customer customer2 = session.load(Customer.class, 6L);
		System.out.println(customer2);
		transaction.commit();
		session.close();
	}
	
}

```

