# 一、OID查询

根据对象的OID，即数据表中的主键进行查询某一个特定的对象，比如get和load方法

## 1、get方式

```
Customer customer = session.get(Customer.class,1l);
```

## 2、load方式

```
Customer customer = session.load(Customer.class,1l);
```

## 3、get和load的区别

- load采用的是延迟加载
- load返回的是一个代理对象（通过集成持久化类），而get返回的是一个真实对象
- 当查不到结果时，get返回的是null，而load会报异常

# 二、对象导航检索

对象导航检索：Hibernate根据一个已经查询到的对象，获得其关联的对象的一种查询方式。

```
LinkMan linkMan = session.get(LinkMan.class,1l);
Customer customer  = linkMan.getCustomer();

Customer customer = session.get(Customer.class,2l);
Set<LinkMan> linkMans = customer.getLinkMans();

```

# 三、HQL检索

HQL查询：Hibernate Query
Language，Hibernate的查询语言，是一种面向对象的方式的查询语言，语法类似SQL。通过session.createQuery()，用于接收一个HQL进行查询方式

## 1、 HQL的简单查询

```java
@Test
	/**
	 * HQL的简单查询——查询所有客户
	 * Hibernate中不支持*的写法
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

## 2、HQL别名查询

```java
@Test
	/**
	 * HQL别名查询
	 * Hibernate中不支持*的写法
	 */
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select C from Customer C");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

## 3、HQL排序查询

```java
@Test
	/**
	 * HQL排序查询（默认升序asc，降序用desc
	 */
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer order by cust_id desc").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

## 4、HQL条件查询

```java
@Test
/**
 * HQL条件查询——按位置绑定，类似于sql
 */
public void demo6() {
	Session session = HibernateUtils.getCurrentSession();
	Transaction transaction = session.beginTransaction();
	Query query = session.createQuery("from Customer where cust_name=? and cust_source=?");
	query.setParameter(0, "客户1");
	query.setParameter(1, "小广告");
	List<Customer> list = query.list();
	for (Customer customer : list) {
		System.out.println(customer);
	}
	transaction.commit();
}
```
```java
@Test
	/**
	 * HQL条件查询——按名称查询
	 */
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer where cust_name= :aaa and cust_source= :bbb");
		//为参数赋值
		query.setParameter("aaa", "客户1");
		query.setParameter("bbb", "小广告");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```



## 5、HQL投影查询

```java
@Test
	/**
	 * HQL投影查询——查询对象的某个或者某些属性
	 * 需要为类起一个别名
	 */
	public void demo8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select C.cust_name,C.cust_source from Customer C");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		transaction.commit();
	}
	
	
	@Test
	/**
	 * HQL投影查询——查询对象的某个或者某些属性并将这些属性放入对象中封装
	 * 利用持久化类提供特定的构造方法
	 */
	public void demo9() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select new Customer(cust_name,cust_source) from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
	
```

## 6、HQL分页查询

```java
@Test
	/**
	 * HQL分页查询
	 * 
	 */
	public void demo10() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from LinkMan");
		query.setFirstResult(10);
		query.setMaxResults(10);
		List<LinkMan> list = query.list();
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
		}
		transaction.commit();
	}
```

## 7、HQL统计查询

```java
@Test
	/**
	 * HQL统计查询
	 * 聚合函数
	 * 
	 */
	public void demo11() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Object object = session.createQuery("select count(*) from Customer").uniqueResult();
		System.out.println(object);
		transaction.commit();
	}
```

## 8、HQL分组统计查询

```java
@Test
	/**
	 * HQL分组统计查询
	 * group by
	 * 
	 */
	public void demo12() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Object[]> list = session.createQuery("select cust_source,count(*) from Customer group by cust_source"
				+ " having count(*)>=2").list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		transaction.commit();
	}
	
```



## 9、HQL多表查询

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190131153152739.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

```java
@Test
	/**
	 * HQL多表查询——普通内连接
	 */
	public void demo13() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Object[]> list = session.createQuery("from Customer c inner join c.linkMan").list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		transaction.commit();
	}
	
	@Test
	/**
	 * HQL多表查询——迫切内连接
	 * 在inner join后面加fetch，通知Hibernate，可以将另一个对象的数据封装到该对象中
	 * 在from之前加上distinct
	 */
	public void demo14() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> list = session.createQuery("select distinct c from Customer c inner join fetch c.linkMan").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

# 四、QBC检索