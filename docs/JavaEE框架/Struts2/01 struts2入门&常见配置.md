# 一、Struts2的概述

## 1、什么是Struts2

是一个机遇MVC设计模式的web层框架

## 2、常见的web层框架

Struts2

Struts1

Webwork

SpringMVC

所有web层框架都有一个特点就是都是基于前端控制器实现的

## 3、前端控制器模式

传统的servlet开发，有一次请求就会对应一个servlet，这样会导致出现很多的servlet，而Struts2的请求都会先经过前端控制器，在前端控制器中实现框架的部分功能，剩下的具体操作要提交到具体的Action中过滤器是最好的前端控制器的实现方式

# 二、Struts2快速入门

## 1、Struts2开发包目录结构

apps：提供Struts2提供的示例程序，其中有一个blank.war可以用来赋值基础的一些jar包

does：Struts2的官方文档，API文档

lib：jar包以及第三方插件类库

src：Struts2的源代码

## 2、Struts2的开发流程

当客户端发送强求过来，先经过前端控制器（核心过滤器StrutsPrepareAndExecuteFilter)过滤器中执行一组拦截器，一组拦截器就会完成部分功能，拦截器执行完成以后，就会执行目标Action，在Action中返回一个结果视图，根据Struts.xml中配置实现页面跳转

## 3、Action类

```java
public class CustomerAction extends ActionSupport {
	/**
	 * 查询客户列表的方法
	 * @return
	 */
	public String findAll() {
		System.out.println("CustomerAction<<<<<<<<<<<<<");
		//创建业务层类的对象
		CutomerService cutomerService = new CutomerServiceImpl();
		//调用业务层的方法查询所有客户
		List<Customer> list = cutomerService.findAll();
		//获得request对象并保存在request中
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findAll";
	}
}
```

## 4、Action类配置Struts2.xml

```java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
        "http://struts.apache.org/dtds/struts-2.0.dtd">

<struts>
	<!-- Struts2为了管理Action的配置，通过包进行管理 -->
	<!-- 配置Struts的包 -->
	<!-- name包名可以随意取，但是不能有重复 -->
	<!-- 继承了struts-default的包 -->
	<package name="crm" extends="struts-default" namespace="/">
		<!-- 配置Action -->
		<!-- name需要和访问的路径对应起来 这里访问的是hello.action-->
		<action name="customer_*" class="com.canghe.web.action.CustomerAction" method="{1}">
			<!-- 配置页面的跳转 -->
			<result name="findAll" >/jsp/customer/list.jsp</result>
		</action>
	
	
	</package>
</struts>
```

## 5、配置前端控制器（核心过滤器）

```java
<!-- Struts2的核心过滤器配置 -->
	<filter>
		<filter-name>struts2</filter-name>
		<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```

# 三、Struts2的常见配置

## 1、eclipse中xml的did配置

这样写配置文件到 时候会有提示（不是联网的时候）

## 2、Struts2配置文件的加载顺序

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190202151355231.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190202151420780.png)

加载顺序

![1549091678591](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1549091678591.png)

一般在struts.xml中进行配置

## 3、Action的配置

1）package标签配置

lpackage标签称为包，这个包与Java中的包的概念不一致。包为了更好管理action的配置。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190202151641783.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

2）action标签配置

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190202151715435.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 4、Struts2常量配置

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190202151832481.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 5、分模块开发的配置

实际开发中分模块发开进行的Struts.xml每个人各自配置，然后需要整合到主struts.xml配置中使用的 是include标签，将各个模块的xml配置整合进来

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190202152037755.png)

# 四、Action的访问

## 1、Action的写法

1）Action类是POJO类

POJO就是不继承任何类也不识闲任何借口 的普通类

只需要写一个有返回String的execute方法

```java
package com.canghe.strutts.demo1;
/**
 * struts入门的action类
 * @author Administrator
 *
 */
public class HelloAction {
	public String execute() {
		System.out.println("helloAction 执行了 。。。");
		return "success";
	}
}
```

2） Action类实现一个Action的接口

```java
package com.canghe.strutts.demo2;
/**
 * Action实现Action接口
 * 里面有五个逻辑视图名称
 */
import com.opensymphony.xwork2.Action;

public class ActionDemo2 implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("ActionDemo2执行<<<<<");
		return null;
	}

}
```

3） Action类继承ActionSupport类

 

```java
package com.canghe.strutts.demo2;

import com.opensymphony.xwork2.ActionSupport;

public class ActionDemo3 extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("Action方式三<<<<<<");
		return NONE;
	}
}
```

实际开发中，常用继承ActionSupport的方式写Action，里面含有数据校验、国际化操作的一系列方法

## 2、Action的访问

1）通过method设置

配置：

```java
<action name="userFind" class="com.canghe.strutts.demo3.StrutsDemo1" method="find"></action>
		<action name="userUpdate" class="com.canghe.strutts.demo3.StrutsDemo1" method="update"></action>
		<action name="userDelete" class="com.canghe.strutts.demo3.StrutsDemo1" method="update"></action>
		<action name="userSaves" class="com.canghe.strutts.demo3.StrutsDemo1" method="save"></action>
```

页面“

```html
<h3>method方式设置Action的访问</h3>
<a href="${pageContext.request.contextPath }/userFind.action">查找用户</a><br>
<a href="${pageContext.request.contextPath }/userUpdate.action">修改用户</a><br>
<a href="${pageContext.request.contextPath }/userDelete.action">删除用户</a><br>
<a href="${pageContext.request.contextPath }/userSaves.action">保存用户</a><br>
```

Action类：

```java
package com.canghe.strutts.demo3;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsDemo1 extends ActionSupport{
	public String find() {
		System.out.println("查找用户<<<<<<<<");
		return NONE;
	}
	public String update() {
		System.out.println("修改用户<<<<<<<<");
		return NONE;
	}
	public String delete() {
		System.out.println("删除用户<<<<<<<<");
		return NONE;
	}
	public String save() {
		System.out.println("保存用户<<<<<<<<");
		return NONE;
	}
}

```

2）通过通配符的方式访问（常用）

页面访问连接写法：

```html
<h3>通配符方式设置Action的访问</h3>
<a href="${pageContext.request.contextPath }/product_find.action">查找用户</a><br>
<a href="${pageContext.request.contextPath }/product_update.action">修改用户</a><br>
<a href="${pageContext.request.contextPath }/product_delete.action">删除用户</a><br>
<a href="${pageContext.request.contextPath }/product_save.action">保存用户</a><br>
```

配置文件的写法：

```java
<!-- 通过通配符的方式配置 -->
		<action name="product_*" class="com.canghe.strutts.demo3.StrutsDemo2" method="{1}"></action>
```

还有一种更抽象的写法

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190202153447731.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

3）动态方法访问

```java
<!-- 开启动态方法访问 -->
	<constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
```

```java
<!-- 通过动态访问的方式访问action -->
		<action name="customer" class="com.canghe.strutts.demo3.StrutsDemo3"></action>
```

```html
<h3>动态访问设置Action的访问</h3>
<a href="${pageContext.request.contextPath }/customer!find.action">查找用户</a><br>
<a href="${pageContext.request.contextPath }/customer!update.action">修改用户</a><br>
<a href="${pageContext.request.contextPath }/customer!delete.action">删除用户</a><br>
<a href="${pageContext.request.contextPath }/customer!save.action">保存用户</a><br>
```

