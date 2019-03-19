# 一、 Struts2的Servlet的API的访问

## 1、完全解耦合的方式

所谓完全解耦合的方式就是不能获得作用域的对象，不能调用对象的方法，只能对对象中保存的数据进行操作，用到的是ActionContext对象进行操作

这种方式只能获得代表request、session、application的数据的Map*集合，不能操作这些对象的本身的方法。

```java
public class RequestDemo1 extends ActionSupport{
	@Override
	public String execute() throws Exception {
		//接收参数
		ActionContext context = ActionContext.getContext();
		Map<String, Object> map = context.getParameters();
		for (String key : map.keySet()) {
			String[] values=(String[]) map.get(key);
			System.out.println(key+Arrays.toString(values));
		}
		//向域对象中存数据
		context.put("requestName", "request的值");
		context.getSession().put("sessionName", "session的值");
		context.getApplication().put("appName", "app的值");
		return "success";
	}
}
```

## 2、使用servlet的API的原生方式

就是先获得request等对象，然后可以对对象进行一系列的操作，使用的是ServletActionContext对象，可操作域对象的数据和方法

```java
public class RequestDemo2 extends ActionSupport {
	@Override
	public String execute() throws Exception {
		//获取页面参数
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			String[] values = map.get(key);
			System.out.println(key+"\t"+Arrays.toString(values));
		}
		//保存数据
		request.setAttribute("reqNam", "request值");
		request.getSession().setAttribute("seNam", "session的值");
		ServletActionContext.getServletContext().setAttribute("appNam", "app的值");
		return "SUCCESS";
	}
}
```



## 3、接口注入的方式

实现相关的接口，得到相应的对象

```java
public class RequestDemo3 extends ActionSupport implements ServletRequestAware,ServletContextAware{
	private HttpServletRequest request;
	private ServletContext context;

	@Override
	public String execute() throws Exception {
		//获取参数
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			String[] values = map.get(key);
			System.out.println(key+"\t"+Arrays.toString(values));
		}
		//保存数据
		request.setAttribute("reqNam", "request值");
		request.getSession().setAttribute("seNam", "session的值");
		context.setAttribute("appNam", "app的值");
		return "SUCCESS";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context=context;
	}
}
```

# 二、单利问题

Servlet是单例的，多个程序访问同一个Servlet只会创建一个Servlet的实例。Action是多例的，一次请求，创建一个Action的实例（不会出现线程安全的问题）。

# 三、结果页面配置

## 1、全局结果页面

全局结果页面：全局结果页面指的是，在包中配置一次，其他的在这个包中的所有的action只要返回了这个值，都可以跳转到这个页面。

 针对这个包下的所有的action的配置都有效。

```java
<!-- 全局的页面配置 -->
		<global-results>
			<result name="SUCCESS">/demo1/demo2.jsp</result>
		</global-results>
```

## 2、局部结果页面

l局部结果页面：局部结果页面指的是，只能在当前的action中的配置有效。 针对当前的action有效。

```java
	<action name="requestDemo1" class="com.canghe.struts2.demo1.RequestDemo1">
		/demo1/demo2.jsp
		</action>
```

# 四、result标签的配置

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190206193640348.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

# 五、Struts2的数据封装

## 1、属性驱动：提供属性set方法的方式（不常用）

编写页面

```html
<h1>1、属性驱动之提供属性set方法的方式</h1>
<form action="${pageContext.request.contextPath }/userAction1.action" method="post">
	姓名:<input type="text" name="name"/><br>
	密码：<input type="password" name="password"/><br>
	年龄：<input type="text" name="age"/><br>
	出生日期：<input type="text" name="birthday"/><br>
	工资：<input type="text" name="salary"/><br>
	<input type="submit" value="提交"/>
</form>
```

编写Action

```java
package com.canghe.struts2.demo2;
/**
 * 数据封装方式一
 * 属性驱动，提供属性和get和set方法
 */
import java.util.Date;

import com.canghe.struts2.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction1 extends ActionSupport {
	//提供对应的属性
	private String name;
	private String password;
	private Integer age;
	private Date birthday;
	private Double salary;
	//提供属性对应的set方法
	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(name);
		System.out.println(password);
		System.out.println(age);
		System.out.println(birthday);
		System.out.println(salary);
		User user  = new User();
		user.setName(name);
		user.setPassword(password);
		user.setBirthday(birthday);
		user.setSalary(salary);
		System.out.println(user);
		return NONE;
	}
}

```

## 2、属性驱动：页面中提供表达式方式

页面

```java
<h1>2、页面提供表达式的方式</h1>
<form action="${pageContext.request.contextPath }/userAction2.action" method="post">
	姓名:<input type="text" name="user.name"/><br>
	密码：<input type="password" name="user.password"/><br>
	年龄：<input type="text" name="user.age"/><br>
	出生日期：<input type="text" name="user.birthday"/><br>
	工资：<input type="text" name="user.salary"/><br>
	<input type="submit" value="提交"/>
</form>
```

Action

```java
package com.canghe.struts2.demo2;
/**
 * 属性驱动之页面中提供表达式方法
 */
import com.canghe.struts2.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction2 extends ActionSupport {
	//创建对象
	private User user = new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}

```



## 3、 模型驱动：采用模型驱动方式（最常用）

页面：

```java
<h1>1、模型驱动——采用模型驱动的方式</h1>
<form action="${pageContext.request.contextPath }/userAction3.action" method="post">
	姓名:<input type="text" name="name"/><br>
	密码：<input type="password" name="password"/><br>
	年龄：<input type="text" name="age"/><br>
	出生日期：<input type="text" name="birthday"/><br>
	工资：<input type="text" name="salary"/><br>
	<input type="submit" value="提交"/>
```

Action

```java
package com.canghe.struts2.demo2;

import com.canghe.struts2.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 数据封装方式三：模型驱动
 * @author Administrator
 *
 */
public class UserAction3 extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	@Override
	public String execute() throws Exception {
		return NONE;
	}

	@Override
	public User getModel() {
		return user;
	}
}

```

l模型驱动方式最常用的方式，缺点：只能同时向一个对象中封装数据，使用第二种可以向多个对象中同时封装数据

## 4、关于INPUT逻辑视图

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190206194559693.png)

```java
<!--INPUT错误调准  -->
		<global-results>
			<result name="input">/demo2/demo1.jsp</result>
		</global-results>
```

当拦截器按照顺序执行，有一个出错，那么就会跳转到INPUT逻辑视图中，所以需配置全局的INPUT跳转

# 六、Struts2复杂类型数据的封装

比如当我们批量添加商品信息的时候，需要将数据进行封装

## 1、封装数据到List集合中

```java
package com.canghe.struts2.demo3;
import java.util.List;

import com.canghe.struts2.domain.Product;
/**
 * 复杂类型的封装放入list集合中
 */
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction1 extends ActionSupport {
	private List<Product> products;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String execute() throws Exception {
		for (Product product : products) {
			System.out.println(product);
		}
		return NONE;
	}
}

```

JSP页面：

```java
<h1>list集合的方式封装复杂类型的数据</h1>
<form action="${pageContext.request.contextPath }/productAction1.action" method="post">
	商品1名称：<input type="text" name="products[0].name"><br>
	商品1价格：<input type="text" name="products[0].price"><br>
	商品2名称：<input type="text" name="products[1].name"><br>
	商品2价格：<input type="text" name="products[1].price"><br>
	商品3名称：<input type="text" name="products[2].name"><br>
	商品3价格：<input type="text" name="products[2].price"><br>
	<input type="submit" value="提交">
</form>
```

## 2、封装数据到Map集合中

Action：

```java
package com.canghe.struts2.demo3;
import java.util.Map;

import com.canghe.struts2.domain.Product;
/**
 * 复杂类型数据的封装——Map集合封装数据
 */
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction2 extends ActionSupport {
	private Map<String,Product> map;
	public Map<String, Product> getMap() {
		return map;
	}
	public void setMap(Map<String, Product> map) {
		this.map = map;
	}
	@Override
	public String execute() throws Exception {
		//遍历map输出产品信息
		for (String key : map.keySet()) {
			Product product = map.get(key);
			System.out.println(key+"\t"+product);
		}
		return NONE;
	}
}

```

JSP页面：

```java
<h1>Map集合的方式封装复杂类型的数据</h1>
<form action="${pageContext.request.contextPath }/productAction2.action" method="post">
	商品1名称：<input type="text" name="map['one'].name"><br>
	商品1价格：<input type="text" name="map['one'].price"><br>
	商品2名称：<input type="text" name="map['two'].name"><br>
	商品2价格：<input type="text" name="map['two'].price"><br>
	商品3名称：<input type="text" name="map['three'].name"><br>
	商品3价格：<input type="text" name="map['three'].price"><br>
	<input type="submit" value="提交">
</form>
```

