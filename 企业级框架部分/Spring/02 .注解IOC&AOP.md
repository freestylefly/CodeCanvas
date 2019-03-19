# 一、Spring的bean管理（注解方式）

## 1、配置组件扫描

扫描类下的注解，哪些包下的类需要使用IOC注解

```java
<!-- Spring 的注解开发:组件扫描(类上注解: 可以直接使用属性注入的注解) -->
<context:component-scan base-package="com.itheima.spring.demo1"/>

```

## 2、在类上添加注解

```java
@Component(value="userDao")
public class UserDaoImpl implements UserDao {
@Override
public void sayHello() {
System.out.println("Hello Spring Annotation...");
}
}
```

相当于在xml中用bean标签配置类

# 二、Spring的bean管理常用注解

## 1、@Component:组件.(作用在类上)

```java
Spring 中提供@Component 的三个衍生注解:(功能目前来讲是一致的)
* @Controller :WEB 层
* @Service :业务层
* @Repository :持久层
这三个注解是为了让标注类本身的用途清晰，Spring 在后续版本会对其增强
```

## 2、属性注入的注解:(使用注解注入的方式,可以不用提供 set 方法.)

```java
@Value :用于注入普通类型.
@Autowired :自动装配:
* 默认按类型进行装配.
* 按名称注入:
* @Qualifier:强制使用名称注入.
@Resource 相当于:
* @Autowired 和@Qualifier 一起使用.

```

## 3、Bean 的作用范围的注解

@Scope:
* singleton:单例
* prototype:多例

## 4、 Bean 的生命周期的配置

@PostConstruct :相当于 init-method
@PreDestroy :相当于 destroy-method

# 三、注解和xml对bean管理区别

## 1、区别

XML 和注解:

* XML :结构清晰.
* 注解 :开发方便.(属性注入.)
  实际开发中还有一种 XML 和注解整合开发:

注意：注解方式的这个类是自己提供，但是xml的话可以适用所有类

## 2、两种方式结合

Bean 有 XML 配置.但是使用的属性使用注解注入.

在没有扫描下，使用属性注入的注解，需要加上这个配置

```
<context:annotation-config>
```

# 四、AOP的概述

## 1、什么是AOP

AOP是指面向切面编程，是oop的延续，可以为业务逻辑的各个部分进行隔离，解决oop开发遇到的问题，使得业务间的耦合性降低

## 2、AOP特点

可以对程序，或者通俗的说是对类的方法进行增强，在不修改源代码的条件下

AOP可以进行权限校验，日志记录，性能监控，事务控制

## 3、AOP的底层实现原理

底层利用了代理机制

Spring 的 AOP 的底层用到两种代理机制：

* JDK 的动态代理 :针对实现了接口的类产生代理.
* Cglib 的动态代理 :针对没有实现接口的类产生代理. 应用的是底层的字节码增强的技术 生成当前类
  的子类对象.

## 4、Spring底层AOP的实现原理

1）JDK 动态代理增强一个类中方法

```java
public class MyJDKProxy implements InvocationHandler {
private UserDao userDao;
public MyJDKProxy(UserDao userDao) {
this.userDao = userDao;
}
// 编写工具方法：生成代理：
public UserDao createProxy(){
UserDao userDaoProxy = (UserDao)
Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
userDao.getClass().getInterfaces(), this);
return userDaoProxy;
}
@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
{
if("save".equals(method.getName())){
System.out.println("权限校验================");
}
return method.invoke(userDao, args);
}
}

```

2）Cglib 动态代理增强一个类中的方法

```java
public class MyCglibProxy implements MethodInterceptor{
private CustomerDao customerDao;
public MyCglibProxy(CustomerDao customerDao){
this.customerDao = customerDao;
}
// 生成代理的方法:
public CustomerDao createProxy(){
// 创建 Cglib 的核心类:
Enhancer enhancer = new Enhancer();
// 设置父类:
enhancer.setSuperclass(CustomerDao.class);
// 设置回调:
enhancer.setCallback(this);
// 生成代理：
CustomerDao customerDaoProxy = (CustomerDao) enhancer.create();
return customerDaoProxy;
}
@Override
public Object intercept(Object proxy, Method method, Object[] args, MethodProxy
methodProxy) throws Throwable {
if("delete".equals(method.getName())){
Object obj = methodProxy.invokeSuper(proxy, args);
System.out.println("日志记录================");
return obj;
}
return methodProxy.invokeSuper(proxy, args);
}
}

```

# 五、AOP 的开发中的相关术语

## 1、连接点Joinpoint

可以被拦截到的点，在 spring 中,这些点指的是方法,因为 spring 只支持方法类型的连接点。

## 2、切入点Pointcut

真正被拦截到的点，就是我们真正需要去增强的方法

## 3、通知/增强Advice

就是为切入点增强功能的那些个方法，比如权限校验方法等.通知分为前置通知,后置
通知,异常通知,最终通知,环绕通知(切面要完成的功能)

## 4、切面Aspect

是切入点和通知（引介）的结合

## 5、引介Introduction

引介是一种特殊的通知在不修改类代码的前提下, Introduction 可以在运行期为类动态地添加一些方法或 Field.，是类层面的

## 6、目标对象Target

:代理的目标对象

## 7、织入Weaving

是指把增强应用到目标对象来创建新的代理对象的过程，spring 采用动态代理织入，

## 8、代理Proxy

一个类被 AOP 织入增强后，就产生一个结果代理类

# 六、Spring使用 AspectJ 进行 AOP 的开发：XML 的方式

## 1、Spring整合Junit进行单元测试

引入Spring-test的jar包，不需要再创建工厂，直接测试

类注解：

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

```

依赖注入：

@Resource(name="orderDao")

## 2、编写切面类

将增强的方法放进来，比如权限校验等

## 3、通过AOP配置，为目标类生成代理

```java
<!-- 配置切面类 -->
<bean id="myAspectXml" class="cn.itcast.spring.demo3.MyAspectXml"></bean>
<!-- 进行 aop 的配置 -->
<aop:config>
<!-- 配置切入点表达式:哪些类的哪些方法需要进行增强 -->
<aop:pointcut expression="execution(*
cn.itcast.spring.demo3.OrderDao.save(..))" id="pointcut1"/>
<!-- 配置切面 -->
<aop:aspect ref="myAspectXml">
<aop:before method="before" pointcut-ref="pointcut1"/>
</aop:aspect>
</aop:config>
```

## 4、其他增强的配置

```java
<aop:config>
		<!-- 表达式配置哪些类的哪些方法需要增强  点点代表任意参数-->
		<aop:pointcut expression="execution(* com.canghe.demo1.PruductDaoImpl.save(..))" id="pointcut1"/>
		<aop:pointcut expression="execution(* com.canghe.demo1.PruductDaoImpl.delete(..))" id="pointcut2"/>
		<aop:pointcut expression="execution(* com.canghe.demo1.PruductDaoImpl.update(..))" id="pointcut3"/>
		<aop:pointcut expression="execution(* com.canghe.demo1.PruductDaoImpl.find(..))" id="pointcut4"/>
		<!-- 配置切面 -->
		<aop:aspect ref="myAspect">
			<!-- 配置前置通知 -->
			<aop:before method="checkPri" pointcut-ref="pointcut1"/>
			<!-- 配置后置通知 -->
			<aop:after-returning method="weiteLog" pointcut-ref="pointcut2" returning="result"/>
			<!-- 配置环绕通知 -->
			<aop:around method="around" pointcut-ref="pointcut3"/>
			<!-- 配置异常抛出通知 -->
			<aop:after-throwing method="afterThrowing" pointcut-ref="pointcut4" throwing="ex" />
			<!-- 配最终异知 -->
			<aop:after method="after" pointcut-ref="pointcut4" />
		</aop:aspect>
	</aop:config>
```

# 七、Spring通知类型和使用

每种通知均可获得切入点信息

## 1、前置通知

如权限校验

在目标方法执行之前执行

```
<aop:before method="checkPri" pointcut-ref="pointcut1"/>
```

## 2、后置通知

如：日志记录

在目标方法执行之后执行

获得方法的返回值

```java
<!-- 配置后置通知 -->
<aop:after-returning method="weiteLog" pointcut-ref="pointcut2" returning="result"/>
```

然后将result作为参数传入切面中的通知

## 3、环绕通知

如：性能监控

在目标方法执行前和执行后执行

可以阻止目标方法的执行

在通知类方法要有Object返回值，设置如下：

```java
 /**
	  * 环绕通知——性能监控
	 * @throws Throwable 
	  */
	 public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		 System.out.println("环绕通知前==============");
		 Object object = joinPoint.proceed();
		 System.out.println("环绕通知后==============");
		 return object;
	 }
	 
```

## 4、异常抛出通知

在目标方法执行出现 异常的时候 执行

可得到异常信息，

```java
<!-- 配置异常抛出通知 -->
			<aop:after-throwing method="afterThrowing" pointcut-ref="pointcut4" throwing="ex" />
			 /**
	  * 异常抛出通知
	  */
	 public void afterThrowing(Throwable ex) {
		 System.out.println("异常抛出通知============="+ex.getMessage());
	 }
```

## 5、最终通知

无论目标方法是否出现异常 最终通知都会 执行

```java
<!-- 配最终异知 -->
			<aop:after method="after" pointcut-ref="pointcut4" />
```



# 八、切入点表达式写法

execution(表达式)

```
表达式:
[方法访问修饰符] 方法返回值 包名.类名.方法名(方法的参数)
public * cn.itcast.spring.dao.*.*(..)
* cn.itcast.spring.dao.*.*(..)
* cn.itcast.spring.dao.UserDao+.*(..)
* cn.itcast.spring.dao..*.*(..)
```



# 九、AOP核心思想

鞥切面扩展程序，想要增强某一个方法，来一个切面然后配置一下就好了，不需要修改源代码

# 









