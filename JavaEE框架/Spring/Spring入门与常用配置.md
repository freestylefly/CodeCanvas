# 一、Spring概述

## 1、什么是Spring

Spring是一个开源框架，Spring是于2003 年兴起的一个轻量级的Java 开发框架，由Rod Johnson
在其著作 Expert One-On-One J2EE Development and Design 中阐述的部分理念和原型衍生而来。它是
为了解决企业应用开发的复杂性而创建的。框架的主要优势之一就是其分层架构，分层架构允许使
用者选择使用哪一个组件，同时为 J2EE 应用程序开发提供集成的框架。Spring 使用基本的 JavaBean
来完成以前只可能由 EJB 完成的事情。然而，Spring 的用途不仅限于服务器端的开发。从简单性、
可测试性和松耦合的角度而言，任何 Java 应用都可以从 Spring 中受益。Spring 的核心是控制反转
（IoC）和面向切面（AOP）。简单来说，Spring 是一个分层的 JavaSE/EEfull-stack(一站式) 轻量级
开源框架。

Spring涉及到EE开发的三层

* WEB 层:Spring MVC.
* 业务层:Bean 管理:(IOC)
* 持久层:Spring 的 JDBC 模板.ORM 模板用于整合其他的持久层框架

## 2、Spring特点

- Spring 就是一个大工厂，可以将所有对象创建和依赖关系维护，交给 Spring 管理
  AOP 编程的支持
- Spring 提供面向切面编程，可以方便的实现对程序进行权限拦截、运行监控等功能
  声明式事务的支持
- 只需要通过配置就可以完成对事务的管理，而无需手动编程
  方便程序的测试
- Spring 对 Junit4 支持，可以通过注解方便的测试 Spring 程序
  方便集成各种优秀框架
- Spring 不排斥各种优秀的开源框架，其内部提供了对各种优秀框架（如：Struts、Hibernate、
  MyBatis、Quartz 等）的直接支持
  降低 JavaEE API 的使用难度
- Spring 对 JavaEE 开发中非常难用的一些 API（JDBC、JavaMail、远程调用等），都提供了封装，
  使这些 API 应用难度大大降低

# 二、Spring的IOC

## 1、IOC的底层实现原理

IOC：Inversion of Control 控制反转. 指的是 对象的创建权反转(交给)给 Spring.
作用是实现了程序的解耦合.

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190219114221760.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 2、IOC和DI

IOC :控制反转,将对象的创建权交给了 Spring.
DI :Dependency Injection 依赖注入.需要有 IOC 的环境,Spring 创建这个类的过程中,Spring 将类的依
赖的属性设置进去.

面向对象中类与类之间的关系：

- 依赖：如B类方法中需要将A类传入
- 继承：is a的关系
- 聚合：has a的关系



# 三、Spring的工厂

## 1、BeanFactory

旧版本，调用getBean方法时，才会实例化类

## 2、ApplicationContext

实现了BeanFactory，加载配置文件的时候就会实例化

实现类：

ClassPathXmlApplicationContext :加载类路径下 Spring 的配置文件.
FileSystemXmlApplicationContext :加载本地磁盘下 Spring 的配置文件.

# 四、Spring的相关配置

## 1、bean标签属性id和name配置

id :Bean 起个名字. 在约束中采用 ID 的约束:唯一.必须以字母开始，可以使用字母、数字、连字符、
下划线、句话、冒号 id:不能出现特殊字符.

name:Bean 起个名字. 没有采用 ID 的约束. name:出现特殊字符.如果没有 id 的话 , name 可
以当做 id 使用.

* 整合 struts1 的时候:

## 2、bean标签属性scope

bean的作用范围

* singleton :默认值，单例的.
* prototype :多例的.
* request :WEB 项目中,Spring 创建一个 Bean 的对象,将对象存入到 request 域中.
* session :WEB 项目中,Spring 创建一个 Bean 的对象,将对象存入到 session 域中.
* globalSession :WEB 项目中,应用在 Porlet 环境.如果没有 Porlet 环境那么 globalSession 相当
  于 session.

## 3、Bean 的生命周期的配置

通过配置标签上的 init-method 作为 Bean 的初始化的时候执行的方法，配置 destroy-method
作为 Bean 的销毁的时候执行的方法。
销毁方法想要执行，需要是单例创建的 Bean 而且在工厂关闭的时候，Bean 才会被销毁.

# 五、Spring的bean管理

## 1、 Spring 生成 Bean 的时候三种方式

【无参数的构造方法的方式:】

```
<bean id="bean1" class="cn.itcast.spring.demo3.Bean1"></bean>
```

【静态工厂实例化的方式】

【实例工厂实例化的方式】

## 2、 Spring 的 Bean 的属性注入

1）【构造方法的方式注入属性】

```
<bean id="car" class="cn.itcast.spring.demo4.Car">
<constructor-arg name="name" value="保时捷"/>
<constructor-arg name="price" value="1000000"/>
</bean>

```

如果注入的是对象，value属性要改为ref属性引用另一个 bean 的 id 或 name 

2）【set 方法的方式注入属性】

```
<bean id="car2" class="cn.itcast.spring.demo4.Car2">
<property name="name" value="奇瑞 QQ"/>
<property name="price" value="40000"/>
</bean>
```

比较常用，需要在类中提供set方法

如果注入的是对象，value属性要改为ref属性引用另一个 bean 的 id 或 name 

3） 名称空间 p 的属性注入的方式

Spring2.x 版本后提供的方式

第一步:引入 p 名称空间

第二步:使用 p 名称空间.
* 普通属性: p:属性名称=””
* 对象类型属性: p:属性名称-ref=””

```
<!-- p 名称空间的属性注入的方式 -->
<bean id="car2" class="cn.itcast.spring.demo4.Car2" p:name=" 宝 马 7"
p:price="1200000"/>
<bean id="person" class="cn.itcast.spring.demo4.Person" p:name=" 思 聪 "
p:car2-ref="car2"/>

```

4）SpEL 的方式的属性注入

Spring3.x 版本后提供的方式

```java
SpEL：Spring Expression Language.
语法:#{ SpEL }
<!-- SpEL 的注入的方式 -->
<bean id="car2" class="cn.itcast.spring.demo4.Car2">
<property name="name" value="#{'奔驰'}"/>
<property name="price" value="#{800000}"/>
</bean>
 <bean id="person" class="cn.itcast.spring.demo4.Person">
 <property name="name" value="#{'冠希'}"/>
 <property name="car2" value="#{car2}"/>
 </bean>
<bean id="carInfo" class="cn.itcast.spring.demo4.CarInfo"></bean>
引用了另一个类的属性
<bean id="car2" class="cn.itcast.spring.demo4.Car2">
<!-- <property name="name" value="#{'奔驰'}"/> -->
<property name="name" value="#{carInfo.carName}"/>
<property name="price" value="#{carInfo.calculatePrice()}"/>
</bean>

```

5）注入复杂类型

```
<!-- Spring 的复杂类型的注入===================== -->
<bean id="collectionBean" class="cn.itcast.spring.demo5.CollectionBean">
<!-- 数组类型的属性 -->
<property name="arrs">
<list>
<value>会希</value>
<value>冠希</value>
<value>天property>
<!-- 注入 List 集合的数据 -->
<property name="list">
<list>
<value>芙蓉</value>
<value>如花</value>
<value>凤姐</value>
</list>
</property>
<!-- 注入 Map 集合 -->
<property name="map">
<map>
<entry key="aaa" value="111"/>
<entry key="bbb" value="222"/>
<entry key="ccc" value="333"/>
</map>
</property>
<!-- Properties 的注入 -->
<property name="properties">
<props>
<prop key="username">root</prop>
<prop key="password">123</prop>
</props>
</property>
</bean>

```

## 3、分模块开发

```java
一种:创建工厂的时候加载多个配置文件:
ApplicationContext applicationContext = new
ClassPathXmlApplicationContext("applicationContext.xml","applicationContext2.xml");
二种:在一个配置文件中包含另一个配置文件：
<import resource="applicationContext2.xml"></import>
```





























