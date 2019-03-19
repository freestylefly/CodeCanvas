## 一、写在前面的话
现在是19年的二月17号，一个很好的日子，可是心情却不是很好。我已经失恋4天，可是我并没有忘记这些回忆。
在一起的日子总是短暂的，没有人能命令别人做任何事，只有程序会按照你的想法走，这或许就是生活吧，希望各位均安好！
## 二、Struts2中的拦截器
1、什么是拦截器
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190217181513641.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
2、Struts2的执行流程
客户端向服务器发送一个Action的请求，执行核心过滤器（doFilter）方法。在这个方法中，调用executeAction()方法，在这个方法内部调用dispatcher.serviceAction();在这个方法内部创建一个Action代理，最终执行的是Action代理中的execute(),在代理中执行的execute方法中调用ActionInvocation的invoke方法。在这个方法内部递归执行一组拦截器（完成部分功能），如果没有下一个拦截器，就会执行目标Action，根据Action的返回的结果进行页面跳转。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190217181633445.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
3、自定义拦截器

```java
/**
 * 自定义的拦截器一
 * @author jt
 *
 */
public class InterceptorDemo1 extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("InterceptorDemo1执行了...");
		String obj = invocation.invoke();
		System.out.println("InterceptorDemo1执行结束了...");
		return obj;
	}

}
```
4、拦截器的配置

```java
<package name="demo1" extends="struts-default" namespace="/">
		<!-- 定义拦截器========== -->
		<!-- <interceptors>
			<interceptor name="interceptorDemo1" class="com.itheima.web.interceptor.InterceptorDemo1"/>
			<interceptor name="interceptorDemo2" class="com.itheima.web.interceptor.InterceptorDemo2"/>
		</interceptors> -->
		<interceptors>
			<interceptor name="interceptorDemo1" class="com.itheima.web.interceptor.InterceptorDemo1"/>
			<interceptor name="interceptorDemo2" class="com.itheima.web.interceptor.InterceptorDemo2"/>
			
			<!-- 定义拦截器栈 -->
			<interceptor-stack name="myStack">
				<interceptor-ref name="defaultStack"/>
				<interceptor-ref name="interceptorDemo1"/>
				<interceptor-ref name="interceptorDemo2"/>
			</interceptor-stack>
		</interceptors> 
	
		<action name="actionDemo1" class="com.itheima.web.action.ActionDemo1">
			<result>/demo1/demo1.jsp</result>
			
			<!-- 引入拦截器(一旦引入自定义拦截器，默认拦截器栈的拦截器就不执行了。)=========== -->
			<interceptor-ref name="myStack"/>
			<!-- <interceptor-ref name="defaultStack"/>
			<interceptor-ref name="interceptorDemo1"/>
			<interceptor-ref name="interceptorDemo2"/> -->
		</action>
		
		<action name="uiAction" class="com.itheima.web.action.UIAction">
			<result name="input">/demo2/demo3.jsp</result>
		</action>
	</package>
```

5、权限拦截器

```java

/**
 * 权限拦截器
 * 
 * @author jt
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 判断session中是否存在用户数据:
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		// 判断从session中获取的用户的信息是否为空:
		if(existUser == null){
			// 没有登录
			// 给出提示信息
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("没有登录！没有权限访问！");
			// 回到登录页面
			return actionSupport.LOGIN;
		}else{
			// 已经登录
			return invocation.invoke();
		}
	}

```

权限拦截器的配置

```java
<package name="crm" extends="struts-default" namespace="/">
		<!-- 定义拦截器 -->
		<interceptors>
			<interceptor name="privilegeInterceptor" class="com.itheima.web.interceptor.PrivilegeInterceptor"/>
		</interceptors>
	
		<global-results>
			<result name="login">/login.jsp</result>
		</global-results>
	
		<action name="customer_*" class="com.itheima.web.action.CustomerAction" method="{1}">
			<result name="findSuccess">/jsp/customer/list.jsp</result>
			<result name="saveUI">/jsp/customer/add.jsp</result>
			<result name="saveSuccess" type="redirectAction">customer_find.action</result>
			
			<!-- 引入拦截器 -->
			<interceptor-ref name="privilegeInterceptor"/>
			<interceptor-ref name="defaultStack"/>
		</action>
		
		<action name="user_*" class="com.itheima.web.action.UserAction" method="{1}">
			<result name="success" type="redirect">/index.jsp</result>
			
			<!-- 引入拦截器 -->
			<interceptor-ref name="privilegeInterceptor">
				<param name="excludeMethods">login</param>
			</interceptor-ref>
			<interceptor-ref name="defaultStack"/>
		</action>
	</package>
```
## 三、Struts2的标签库
1、通用标签库

```java
<s:set var="i" value="5" scope="request"/>
<s:if test="#request.i>3">
	i 大于 3
</s:if>
<s:elseif test="#request.i<3">
	i 小于 3
</s:elseif>
<s:else>
	i 等于 3
</s:else>
```

```java 
<s:iterator var="i" value="{'aa','bb','cc'}">
	<s:property value="#i"/>
</s:iterator>
<hr/>
<s:iterator var="entry" value="#{'aaa':'111','bbb':'222','ccc':'333'}">
	<s:property value="#entry.key"/>--<s:property value="#entry.value"/>
</s:iterator>
<hr/>
<s:iterator var="i" begin="1" end="10" step="1">
	<s:property value="#i"/>
</s:iterator>
<hr/>
<s:iterator var="i" begin="100" end="300" step="5" status="status">
	<s:if test="#status.count % 3 == 0">
		<font color="red"><s:property value="#i"/></font>
	</s:if>
	<s:else>
		<s:property value="#i"/>
	</s:else>
</s:iterator>
```

2、UI标签库（常用作数据回显）

```java
<h1>UI标签</h1>
<h3>传统的表单</h3>
<form action="${ pageContext.request.contextPath }/uiAction.action" method="post">
	<input type="hidden" name="id"/>
	用户名:<input type="text" name="name"/><br/>
	密码:<input type="password" name="password"><br/>
	年龄:<input type="text" name="age"><br/>
	性别:<input type="radio" name="sex" value="男">男
	<input type="radio" name="sex" value="女">女<br/>
	籍贯:<select name="city">
		<option value="">-请选择-</option>
		<option value="北京">北京</option>
		<option value="上海">上海</option>
		<option value="深圳">深圳</option>
		<option value="韩国">韩国</option>
	</select><br/>
	爱好:<input type="checkbox" name="hobby" value="basketball"/>篮球
	<input type="checkbox" name="hobby" value="football"/>足球
	<input type="checkbox" name="hobby" value="volleyball"/>排球
	<input type="checkbox" name="hobby" value="pingpang"/>乒乓球<br/>
	介绍:<textarea name="info" cols="8" rows="2"></textarea><br/>
	<input type="submit" value="提交"/>
</form>

<s:debug></s:debug>
<h3>UI标签的表单</h3>
<s:form action="uiAction" namespace="/" method="post" >
	<s:hidden name="id" />
	<s:textfield name="name" label="用户名"/>
	<s:password name="password" label="密码" showPassword="true"/>
	<s:textfield name="age" label="年龄"/>
	<s:radio list="{'男','女'}" name="sex" label="性别"/>
	<s:select list="{'北京','上海','深圳','韩国'}" name="city" label="籍贯" headerKey="" headerValue="-请选择-"/>
	<s:checkboxlist list="#{'basketball':'篮球','football':'足球','volleyball':'排球','pingpang':'乒乓球'}" name="hobby" label="爱好"/>
	<s:textarea name="info" cols="8" rows="2" label="介绍" ></s:textarea>
	<s:submit value="提交"/>
</s:form>
```

