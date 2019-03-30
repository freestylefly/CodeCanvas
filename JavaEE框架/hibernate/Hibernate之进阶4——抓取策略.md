# 一、Hibernate优化处理

## 1、缓存

## 2、抓取策略

前面已经整理过Hibernate的一级缓存，二级缓存实际开发中用Redis替代

# 二、延迟加载的概述

## 1、什么是延迟加载

延迟加载：lazy（懒加载）。执行到该行代码的时候，不会发送语句去进行查询，在真正使用这个对象的属性的时候才会发送SQL语句进行查询

## 2、延迟加载的分类

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190131154321588.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

**抓取策略往往会和关联级别的延迟加载一起使用，优化语句。**

# 三、抓取策略

## 1、抓取策略概述

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190131154459135.png)

fetch主要控制sql的格式，是采用连接方式还是普通查询，lazy控制的是延迟加载

## 2、`<set>`上的fetch和lazy

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190131154628582.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

不同的值会产生不同的组合效果，需要可自行配置

```java
@Test
	/**
	 * 抓取策略默认值
	 * fetch="select" lazy="truw"
	 * 默认情况下，会发送两条sql语句（查客户、查联系人）
	 */
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查询一号客户
		Customer customer = session.get(Customer.class, 1l);//发送一条sql语句
		//查询1号客户对应的联系人
		Set<LinkMan> linkMan = customer.getLinkMan();
		//打印联系人
		for (LinkMan linkMan2 : linkMan) {//发送一条sql
			System.out.println(linkMan2);
		}
		transaction.commit();
	}
	
	@Test
	/**
	 * 抓取策略默认值
	 * fetch="select" lazy="false"
	 * 会连续发送两条sql语句，而且是查所有
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查询一号客户
		Customer customer = session.get(Customer.class, 1l);//发送2条sql语句,一条查客户，一条查联系人
		//查询1号客户对应的联系人，打印联系人个数
		System.out.println(customer.getLinkMan().size());
		transaction.commit();
	}
	
	@Test
	/**
	 * 抓取策略默认值
	 * fetch="select" lazy="extra"
	 * 想要什么查什么，极其懒惰
	 */
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查询一号客户
		Customer customer = session.get(Customer.class, 1l);//发送1条sql语句
		//查询1号客户对应的联系人，打印联系人个数
		System.out.println(customer.getLinkMan().size());//发送仅查个数的sql语句(select count)
		transaction.commit();
	}
	
	
	
	@Test
	/**
	 * 抓取策略默认值
	 * fetch="join" lazy="extra"
	 * 这个时候lazy失效，迫切左外连接
	 */
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查询一号客户
		Customer customer = session.get(Customer.class, 1l);//发送1条sql语句，迫切左外连接语句
		//查询1号客户对应的联系人，打印联系人个数
		System.out.println(customer.getLinkMan().size());//不发送语句了
		transaction.commit();
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	/**
	 * 抓取策略默认值
	 * fetch="subselect" lazy="true"
	 * 子查询，延迟加载
	 */
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查询所有号客户
		List<Customer> list = session.createQuery("from Customer").list();//发送一条sql语句
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
			System.out.println(customer.getLinkMan().size());//发送一条子查询语句
		}
		transaction.commit();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	/**
	 * 抓取策略默认值
	 * fetch="subselect" lazy="false"
	 * 这个时候lazy失效，迫切左外连接
	 */
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//查询所有号客户
		List<Customer> list = session.createQuery("from Customer").list();//发送一条sql语句查客户，和发送子查询语句
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
			System.out.println(customer.getLinkMan().size());
		}
		transaction.commit();
	}
```



## 3、`<many-to-one>`上的fetch和lazy

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019013115493424.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

```java
@Test
	/**
	 * 默认值
	 * fetch="select" lazy="proxy"
	 */
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		LinkMan linkMan = session.get(LinkMan.class, 1l);//发送一条sql语句
		System.out.println(linkMan.getLkm_name());
		System.out.println(linkMan.getCustomer().getCust_name());//发送sql语句
		transaction.commit();
	}
	
	@Test
	/**
	 * 默认值
	 * fetch="select" lazy="false"
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		LinkMan linkMan = session.get(LinkMan.class, 1l);//发送2条sql语句，没有延迟加载
		System.out.println(linkMan.getLkm_name());
		System.out.println(linkMan.getCustomer().getCust_name());
		transaction.commit();
	}
	
	@Test
	/**
	 * 默认值
	 * fetch="join" lazy="false"
	 * 和lazy无关，迫切左外连接
	 * proxy和另外一方class上的lazy是true还是false，默认是true
	 */
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		LinkMan linkMan = session.get(LinkMan.class, 1l);//发送2条sql语句，迫切左外连接
		System.out.println(linkMan.getLkm_name());
		System.out.println(linkMan.getCustomer().getCust_name());
		transaction.commit();
	}
	
```

## 4、批量抓取

一批关联对象一起抓取，batch-size

比如像通过查询所有客户的同时获得所有联系人的信息，如果不采用批量抓取，会导致多次访问数据库，执行效率很低

```java
package com.canghe.test;
/**
 * Hibernate的批量抓取
 * @author Administrator
 *
 */

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.canghe.domain.Customer;
import com.canghe.domain.LinkMan;
import com.canghe.util.HibernateUtils;

public class HibernateDemo12 {
	@SuppressWarnings("unchecked")
	@Test
	/**
	 * 获取客户时批量获取联系人
	 * 在Customer.hbm.xml中配置betch_size的值为4，代表每四个客户抓取一次，只会发送2条sql语句
	 */
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
			Set<LinkMan> linkMan = customer.getLinkMan();
			for (LinkMan linkMan2 : linkMan) {
				System.out.println(linkMan2.getLkm_name());
			}
		}
		transaction.commit();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	/**
	 * 获取联系人时获取对应的客户
	 * 在Customer.hbm.xml中的class上配置betch_size的值为4，代表每四个客户抓取一次，只会发送2条sql语句
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<LinkMan> list = session.createQuery("from LinkMan").list();
		for (LinkMan linkMan : list) {
			Customer customer = linkMan.getCustomer();
			System.out.println(customer.getCust_name());
		}
		transaction.commit();
	}
	
}

```

















