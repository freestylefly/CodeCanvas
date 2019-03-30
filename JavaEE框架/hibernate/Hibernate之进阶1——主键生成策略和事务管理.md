# 一、持久化类的编写规则

## 1、什么是持久化？

将内存中的数据永久保存到关系型数据库中

## 2、什么是持久化类？

java中的类和数据库表建立了映射关系

## 3、持久化类的编写规则

- 无参构造方法
- 属性需要私有，对私有属性提供公共的set和get方法
- 属性精良使用包装类型（防止基本数据类型默认值为0造成的问题
- 要有一个唯一标识OID与表的主键对应
- 不能使用ffinal修饰（延迟加载代理对象继承了持久化类）

# 二、Hibernate主键生成策略

## 1、主键的类型

1）自然主键

​	实体中具体属性（如省份证id）

2）代理主键（开发常用）

​	主键本身不是持久化类中的具体属性

## 2、主键生成策略

- increment

  long\short\int类型，hibernate中的自增长，只允许在单线程中使用

- identity

  long\short\int类型，利用的是数据库的自增长，如mysql

- sequence

  long\short\int类型，序列，如oracle

- native

  本地策略，在identity和sequence中进行自动切换

- uuid

  适合字符串，会产生随机的字符串

- assigned

  hibernate放弃主键管理，需哟啊月用户手动设置

- foreign

  一对一主键对应

# 三、Hibernate持久化类的三中状态

## 1、瞬时态

无唯一标识UID

不被session管理

数据库重女无记录

new对象的时候产生

## 2、持久态

有UUID

被session管理

持久化对象可自动更新数据库

```java
@Test
	/**
	 * hibernate主键生成策略，以及持久态会自动更新数据表
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
//		Customer customer = new Customer();
//		customer.setCust_name("脏三");
		Customer customer  = session.get(Customer.class, 1l);
		customer.setCust_source("小广告");
//		session.save(customer);
		transaction.commit();
	}
```



## 3、托管态

有OID

未被session管理

# 四、Hibernate的一级缓存

## 1、什么是缓存

缓存是计算机领域非常通用的概念，介于应用程序和永久性数据存储器（如硬盘上文件或数据库）之间，缓存是将数据放在内存中，降低应用程序直接读写数据库的频率，从而提高应用的运行性能。	

## 2、Hibernate中的缓存

1）以及缓存

session级别的缓存，hibernate自带缓存，且不可取消

2）二级缓存

sessionFactory级别缓存，需要手动配置才可生效

## 3、Hibernate一级缓存

1）一级缓存的内部结构

在Session接口的实现中包含一系列java集合，构成了缓存

快照区：当事务提交时，比较缓存和快照区中数据，当一致的时候不会发送update方法，不一致才会发送update语句，这也解释了为什么hibernate中的持久化类的持久态为什么可以自动更新数据库

## 4、缓存的清空

session.close()

session.clar()：清除所有缓存

session.evict：清除指定缓存

# 五、Hibernate的事务管理

## 1、什么是事务

逻辑上的一组操作，组成这组操作的各个单元，要么一起成功，要么一起失败

## 2、事务的四个特性

ACID

1）原子性（A）：

不可分割的单元

2）一致性（C）

保证数据整体保持一致状态

3）隔离性（I）

一个事务的执行不受其他事务的影响

4）持久性（D）

执行完毕后，数据存到数据库

## 3、事务的并发问题

1）脏读

​	一个事务读取到另一个事务未提交的数据

2）不可重复读

一个事务读到了另一个事务已经提交的update的数据，导致在同一个事务中的多次查询结果不一致

3）虚读

一个事务读到了另一个事务已经提交的insert的数据，导致在同一个事务中的多次查询结果不一致

## 4、事务的蛤蜊级别

为了解决事务并发的问题

1）读未提交（Read Uncommited）

不能解决以上读问题

2）已读提交（Read Commitied）

解决脏读，oracle默认

3）可重复读（Rwpeatable Read）

解决脏读和不可重复读，mysql默认

4）序列化（Serializable）

能解决所有事务并发的问题，但是效率较低

## 5、Hibernate事务管理

考虑到事务是事务应该在sercice层实现，保证调用不同的dao但是是同一个session，可以在工具类中通过sessionFactory对象的getCurrentSession() 方法获得与线程绑定的session，且该session不需要关闭

1）先在核心配置文件中配置

```
<!--指定session管理方式 -->
		<property name="hibernate.current_session_context_class">
			thread
		</property>
```

2）在工具类中修改

```
public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
```



# 六、Hibernate的其他API

## 1、Query

通过.createQuery（HQL）产生Query,调用query的list（）方法执行查询

1）基本查询

```java
	@Test
	/**
	 * 利用query查询所有数据
	 */
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
		}
		transaction.commit();
	}
```

2）条件查询

```java
	@Test
	/**
	 * 利用query条件查询
	 */
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer where cust_name=? and cust_source=?");
		query.setString(0, "张三");
		query.setString(1, "小广告");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

3）分页查询

```java
	@Test
	/**
	 * 分页查询
	 */
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer");
		query.setFirstResult(2);
		query.setMaxResults(2);
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```



## 2、 Criteria

是一个完全面型对象，可扩展的条件查询API，QBC查询

1）查询所有记录

```java
@Test
	/**
	 * Criteria查询所有记录
	 */
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

2）条件查询

```java
@Test
/**
 * Criteria条件查询
 */
public void demo7() {
	Session session = HibernateUtils.getCurrentSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Customer.class);
	criteria.add(Restrictions.eq("cust_name", "张三"));
	criteria.add(Restrictions.eq("cust_source", "小广告"));
	List<Customer> list = criteria.list();
	for (Customer customer : list) {
		System.out.println(customer);
	}
	transaction.commit();
}
```

3）分页查询

```java
@Test
/**
 * Criteria条件查询
 */
public void demo8() {
	Session session = HibernateUtils.getCurrentSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Customer.class);
	criteria.setFirstResult(2);
	criteria.setMaxResults(2);
	List<Customer> list = criteria.list();
	for (Customer customer : list) {
		System.out.println(customer);
	}
	transaction.commit();
}
```

## 3、SQLQuery

用于接收sql语句进行查询





