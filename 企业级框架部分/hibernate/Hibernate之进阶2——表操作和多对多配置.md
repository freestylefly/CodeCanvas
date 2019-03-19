# 一、数据库表与表之间的关系

## 1、一对多关系

1）一个部门对应多个员工、客户和联系人、商品和分类

2）建表原则

在多的一方创建外键，指向一的一方的主键

## 2、多对多关系

1）学生和课程、用户和角色

2）建表原则

创建一个中间表，中间表至少有两个字段分别作为指向多对多双方的主键

## 3、一对一关系

1）公司和注册地址

2）建表原则

唯一外键对应：模拟一对多关系，在多的一方创建外键约束，并加唯一约束；

主键对应：两个主键关联

# 二、Hibernate一对多关系配置

## 1、建表

根据一对多建表原则建表

## 2、实体类

1）在一的一方需要添加多的对象的集合

```java
private Set<LinkMan> linkMan = new HashSet<LinkMan>();
```

2）在多的一方设置一的一方的对象属性

```java
private Customer customer;
```

## 3、持久化类的映射配置

1）在一的一方配置

```java
<!-- 配置一对多的映射：放置的多的一方的集合 -->
		<!-- 
			set标签 ：
				* name	：多的一方的对象集合的属性名称。
				* cascade：级联
				* inverse：放弃外键维护权。
		-->
		<set name="linkMans" cascade="save-update" inverse="true">
			<!--
				 key标签
					* column：多的一方的外键的名称。
			 -->
			<key column="lkm_cust_id"/>
			<!-- 
				one-to-many标签
					* class	:多的一方的类的全路径
			 -->
			<one-to-many class="com.itheima.hibernate.domain.LinkMan"/>
		</set>
```

2）多的一方配置

```java
<!-- 配置多对一的关系：放置的是一的一方的对象 -->
		<!-- 
			many-to-one标签
				* name		:一的一方的对象的属性名称。
				* class		:一的一方的类的全路径。
				* column	:在多的一方的表的外键的名称。
		 -->
		<many-to-one name="customer" class="com.itheima.hibernate.domain.Customer" column="lkm_cust_id"/>
```



## 4、核心配置文件的配置

需要将映射文件都放入核心配置中来

## 5、一对多的级联操作

正常未作其他配置的前提下，必须保存两个才可以进行执行，否则就会报瞬时对象异常

1）级联保存或更新

保存客户级联联系人：

在客户的映射中的set标签中加cascade属性，值为save-update，为了避免产生多余的sql语句，通常在一的一方的set中添加属性inverse="true"，放弃外键维护

```

```

保存联系人级联客户@Test
​	/**
​	 * 级联保存——保存一的一方（保存客户，级联联系人）
​	 */
​	public void demo2() {
​	​	Session session = HibernateUtils.getCurrentSession();
​	​	Transaction transaction = session.beginTransaction();
​	​	

```java
	Customer customer = new Customer();
	customer.setCust_name("客户1");
	
	LinkMan linkMan = new LinkMan();
	linkMan.setLkm_name("联系人1");
	
	customer.getLinkMan().add(linkMan);
	linkMan.setCustomer(customer);
	
	session.save(customer);
	
	transaction.commit();
}
```
在联系人的配置文件中cascade

*通过级联操作可以测试对象的导航，判断发送几条sql语句

## 6、级联删除

在JDBC或者数据库中，有主外键关系的数据表，要先删除从表，再删除主表，在hibernate中科技设置级联删除，删除某一方就可以将级联的也删除掉

1）删除客户级联删除联系人

在客户的配置文件的set中的cascade中新加值delete

## 7、cascade和inverse区别

cascade是级联操作设置

inverse是维护外键的设置

## 8、测试对象的导航

```java
@Test
	/**
	 * 测试对象的导航
	 * 前提：在两边均设置了：cascade="save-update"
	 */
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("客户1");
		
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("联系人1");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_name("联系人2");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_name("联系人3");
		
		linkMan1.setCustomer(customer);
		customer.getLinkMan().add(linkMan2);
		customer.getLinkMan().add(linkMan3);
		
		
//		session.save(linkMan1);//发送4条insert语句
//		session.save(customer);//发送3条insert语句
		session.save(linkMan2);//发送1条insert语句
		
		transaction.commit();
	}
```



# 三、Hibernate的多对多关系映射

## 1、建表

多对多关系一定要建立中间表

## 2、创建实体

在两边的实体中都要添加另一方的set集合作为一个属性

## 3、创建映射

```java
<!-- 建立与角色的多对多的映射关系 -->
		<!-- 
			set标签
				* name		：对方的集合的属性名称。
				* table		：多对多的关系需要使用中间表，放的是中间表的名称。
		 -->
		<set name="roles" table="sys_user_role" cascade="save-update,delete"  >
			<!-- 
				key标签：
					* column	：当前的对象对应中间表的外键的名称。
			 -->
			<key column="user_id"/>
			<!-- 
				many-to-many标签：
					* class		：对方的类的全路径
					* column	：对方的对象在中间表中的外键的名称。
			 -->
			<many-to-many class="com.itheima.hibernate.domain.Role" column="role_id"/>
		</set>
```

## 4、多对多的级联保存或更新

同样未设置级联操作的时候只保存一方是会抛异常的，注意多对多关系，一定要有一方放弃外键维护，通常是被动方放弃外键维护，这里可以是角色方放弃外键维护inverse=“true”

1）保存用户级联保存角色

在用户的一方的映射文件中配置set的一个cascade属性，值是sava-update

并将逐渐交给该类维护

```java
@Test
	/**
	 * 设置了级联关系的，仅保存用户就可以级联保存角色
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//创建一个用户
		User user = new User();
		user.setUser_name("用户1");
		//创建一个角色
		Role role = new Role();
		role.setRole_name("角色1");
		//设置双向关联关系
		user.getRoles().add(role);
		role.getUsers().add(user);
		//保存用户即可级联保存用户对应的角色
		session.save(user);
		//提交
		transaction.commit();
	}
```

2）保存角色激烈保存用户

在角色的映射中的set加cascade属性，并且维护外键

## 5、多对多级联删除（基本用不上）

## 6、给用户选择角色

```java
	}
	@Test
	/**
	 * 给用户选择角色（为1号用户添加3号角色）
	 */
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查1号用户
		User user = session.get(User.class, 1l);
		//查询3号角色
		Role role = session.get(Role.class, 3l);
		//设置一号用户添加3号角色
		user.getRoles().add(role);
		//提交
		transaction.commit();
	}
```



## 7、给用户改选角色

```java
@Test
	/**
	 * 给用户改选角色（给2号用户选的2号角色改为1号角色
	 */
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查2号用户
		User user = session.get(User.class, 2l);
		//查询2号角色
		Role role2 = session.get(Role.class, 2l);
		//查询1号角色
		Role role1 = session.get(Role.class, 1l);
		//先将2号用户的2号角色删除
		user.getRoles().remove(role2);
		//再重新给二号用户添加1号角色
		user.getRoles().add(role1);
		//提交
		transaction.commit();
	}
```

## 8、给用户删除角色

```java
@Test
	/**
	 * 给用户删除角色（给2号用户删除1号角色）
	 */
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查2号用户
		User user = session.get(User.class, 2l);
		//查询1号角色
		Role role1 = session.get(Role.class, 1l);
		//先将2号用户的2号角色删除
		user.getRoles().remove(role1);
		//提交
		transaction.commit();
	}
```

# 四、QBC查询、

## 1、 QBC简单查询

```java
@Test
	/**
	 * QBC简单查询
	 */
	public void demo1() {
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

## 2、 QBC条件查询

```java
@Test
	/**
	 * QBC条件查询
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("cust_name", "客户1"));
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

## 3、QBC排序查询

```java
@Test
	/**
	 * QBC排序查询
	 * 等于	eq
	 * 大于	gt
	 * 大于等于  ge
	 * 小于	lt
	 * 小于等于	le
	 * 不等于		ne
	 * like
	 * in
	 * and
	 * or
	 */
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.addOrder(Order.desc("cust_id"));
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

## 4、QBC分页查询

```java

	@Test
	/**
	 * QBC分页查询
	 */
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

## 5、 QBC统计查询

```java

	@Test
	/**
	 * QBC统计查询
	 * 习惯用HQL
	 */
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		/**
		 * add() 在where后面的条件
		 * addOrder() 排序
		 * setProjection	聚合函数和group by having
		 */
		criteria.setProjection(Projections.rowCount());
		Object obj = criteria.uniqueResult();
		System.out.println(obj);
		transaction.commit();
	}
```

## 6、离线条件查询



```java
@Test
	/**
	 * 离线条件查询
	 * 在SSH整合和多条件结合查询的时候用的多
	 */
	public void demo6() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.eq("cust_name", "客户1"));
		
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
```

# 五、SQL检索

写sql语句

```java
@Test
	/**
	 * SQL查询出放在Object[]数组中
	 */
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Object[]> list = session.createSQLQuery("select * from cst_Customer").list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		transaction.commit();
	}
	
	@Test
	/**
	 * SQL查询数据封装到对象中
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery sqlQuery = session.createSQLQuery("select * from cst_Customer");
		sqlQuery.addEntity(Customer.class);
		List<Customer> list = sqlQuery.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		transaction.commit();
	}
```

