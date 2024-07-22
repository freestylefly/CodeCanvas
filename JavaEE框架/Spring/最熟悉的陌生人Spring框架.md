
# 目录
- [目录](#目录)
- [一、前言](#一前言)
- [二、IOC](#二ioc)
- [三、AOP](#三aop)
  - [1、概述](#1概述)
  - [2、静态代理和动态代理](#2静态代理和动态代理)
  - [3、动态代理的2种实现方式](#3动态代理的2种实现方式)
- [四、spring的三级缓存和循环依赖](#四spring的三级缓存和循环依赖)
  - [1、循坏依赖](#1循坏依赖)
  - [2、三级缓存](#2三级缓存)
  - [3、三级缓存解决循环依赖](#3三级缓存解决循环依赖)
- [五、Spring后置处理器BeanPostProcessor](#五spring后置处理器beanpostprocessor)
- [六、Spring事务的传播行为](#六spring事务的传播行为)
  - [1、PROPAGATION\_REQUIRED](#1propagation_required)
  - [2、PROPAGATION\_SUPPORTS](#2propagation_supports)
  - [3、PROPAGATION\_MANDATORY](#3propagation_mandatory)
  - [4、PROPAGATION\_REQUIRES\_NEW](#4propagation_requires_new)
  - [5、ROPAGATION\_NOT\_SUPPORTED](#5ropagation_not_supported)
  - [6、PROPAGATION\_NEVER](#6propagation_never)
  - [7、PROPAGATION\_NESTED](#7propagation_nested)
- [七、 Spring的@Transactional如何实现](#七-spring的transactional如何实现)
  - [1、作用](#1作用)
  - [2、注解失效的几种场景](#2注解失效的几种场景)
- [八、BeanFactory和ApplicationContext的联系和区别](#八beanfactory和applicationcontext的联系和区别)

# 一、前言
大家好，我是苍何。最近思考了一个问题，为什么会出现公司面试造火箭，工作扭螺丝的现象，包括各种八股文的连环大绝杀问到你不会为主，其实这是考察你的知识面以及掌握的深度，而为什么需要这样呢？归其原因，无非是通过筛选找到那些会思考的人，他们需要的并不是CRUD的工具人，而是会思考能创新的工程师。

当你深刻理解到这点，我想不用刻意去学习，在工作中，肯定会吾日三省吾身。

于是乎，这个重新开始学习编程系列文章出来了。

愿与君共勉！

Spring框架为我们开发简化了很多，不用区考虑对象的创建和管理，将Bean交给spring，两大核心IOC和AOP，三级缓存、循环依赖，后置处理器、spring的事务处理等，往往每天都在用，但底层还是不大熟悉，所以称之为最熟悉的陌生人。

# 二、IOC
控制反转，将对象的生命周期和对象之间的关系交给spring容器进行管理

依赖注入的思想是通过反射机制实现的，在实例化一个类时，它通过反射调用类中set方法将事先保存在HashMap中的类属性注入到类中。 总而言之，在传统的对象创建方式中，通常由调用者来创建被调用者的实例，而在Spring中创建被调用者的工作由Spring来完成，然后注入调用者，即所谓的依赖注入or控制反转。 注入方式有两种：依赖注入和设置注入； IoC的优点：降低了组件之间的耦合，降低了业务对象之间替换的复杂性，使之能够灵活的管理对象。

# 三、AOP
## 1、概述
面向切面编程，底层是基于代理来实现的。
## 2、静态代理和动态代理
静态代理：在运行前就已经将.class文件编译好
动态代理：在程序运行时，运用反射机制动态创建而成。
## 3、动态代理的2种实现方式
**JDK动态代理：**
① 通过Java.lang.reflect.Proxy类来动态生成代理类
② 代理类要实现InvocationHandler接口；
③ JDK代理只能基于接口进行动态代理的；
**CJLIB动态代理**
CGLib采用非常底层的字节码技术，可以为一个类创建子类，并在子类中采用方法去技术拦截所有的父类方法的调用，并顺势织入横切逻辑。
**spring中用的哪种代理？**
如果一个类实现了接口，则用JDK动态代理，否则用CJLIB代理
# 四、spring的三级缓存和循环依赖
## 1、循坏依赖
类A实例化需要加载类B，类B实例化又需要加载类A，这就是循环依赖
## 2、三级缓存
Spring在创建Bean的过程中分为三步：
```
1、实例化对象，就是new对象
2、属性注入，为对象填充属性和注入依赖
3、初始化，完成AOP代理
```
**第一级缓存：**
存放成品bean，完全初始化
**第二级缓存：**
存放半成品的Bean，已经创建但是未注入属性和初始化
**第三级缓存：**
存的是Bean工厂对象，用来生成半成品的Bean，并放入二级缓存
```
获取bean是先从缓存获取
1、只针对单例的bean，多例的后面讨论
2、默认的singletonObjects缓存不存在要get的beanName时，判断beanName是否正在创建中
3、从early缓存earlySingletonObjects中再查询，early缓存是用来缓存已实例化但未组装完成的bean
4、如果early缓存也不存在，从singletonFactories中查找是否有beanName对应的ObjectFactory对象工厂
5、如果对象工厂存在，则调用getObject方法拿到bean对象
6、将bean对象加入early缓存，并移除singletonFactories的对象工厂
```
## 3、三级缓存解决循环依赖
![在这里插入图片描述](https://img-blog.csdnimg.cn/73291dcc599b4e628bb96fa99880893b.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)
Spring通过三级缓存解决了循环依赖。一级缓存为单例池，二级缓存为早期曝光对象，三级缓存为早期曝光对象工厂。当A、B两类发生循环引用，在A实例化之后，将自己提早曝光(即加入三级缓存)，如果A初始AOP代理，该工厂对象返回的是被代理的对象，若未被代理，返回对象本身。当A进行属性注入时，经过之前实例化步骤，此时轮到B属性注入，调用getBean(a)获取A对象，由于A处理正在创建集合中，此时也发了循环依赖，所以可以从三级缓存获取对象工厂(如果A被AOP代理，此时返回就是代理对象)，并把对象放到二级缓存中，这样保证A只经过一次AOP代理。接下来，B走完Spring生命周期流程，并放入单例池中。当B创建完后，会将B注入A，A走完Spring生命周期流程。到此，循环依赖结束。


# 五、Spring后置处理器BeanPostProcessor
作用：允许我们在工厂里所有的bean被加载进来后但是还没初始化前，对所有bean的属性进行修改也可以add属性值。
触发时间：先执行工厂后置处理器，再执行构造方法，最后init-method。
```java
package xz.quartz.analysis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class beanpostpro implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after"+beanName);
        return bean;
    }

}

```

# 六、Spring事务的传播行为
## 1、PROPAGATION_REQUIRED
required，如果当前存在事务，则加入该事务，如果当前不存在事务，则创建一个新的事务。( 也就是说如果A方法和B方法都添加了注解，在默认传播模式下，A方法内部调用B方法，会把两个方法的事务合并为一个事务 ）

## 2、PROPAGATION_SUPPORTS
supports，如果当前存在事务，则加入该事务；如果当前不存在事务，则以非事务的方式继续运行。
## 3、PROPAGATION_MANDATORY
mandatory，如果当前存在事务，则加入该事务；如果当前不存在事务，则抛出异常。
## 4、PROPAGATION_REQUIRES_NEW
requires_new,,重新创建一个新的事务，如果当前存在事务，暂停当前的事务。( 当类A中的 a 方法用默认Propagation.REQUIRED模式，类B中的 b方法加上采用 Propagation.REQUIRES_NEW模式，然后在 a 方法中调用 b方法操作数据库，然而 a方法抛出异常后，b方法并没有进行回滚，因为Propagation.REQUIRES_NEW会暂停 a方法的事务 )

## 5、ROPAGATION_NOT_SUPPORTED
not_supported，以非事务的方式运行，如果当前存在事务，暂停当前的事务
## 6、PROPAGATION_NEVER
never，以非事务的方式运行，如果当前存在事务，则抛出异常。
## 7、PROPAGATION_NESTED
nested，如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作



# 七、 Spring的@Transactional如何实现
## 1、作用
用来管理事务，底层是基于spring AOP来实现的
## 2、注解失效的几种场景
A、@Transactional注解只能应用到public修饰符上，用在非public方法会导致失效
B、默认情况下此注解会对unchecked异常进行回滚，对checked异常不回滚。
```
那什么是unchecked，什么是checked呢？通俗的说，编译器能检测到的是checked，检测不到的就是unchecked。

派生于Error或者RuntimeException（比如空指针，1/0）的异常称为unchecked异常。

继承自Exception的异常统称为checked异常，如 IOException、TimeoutException等。
```
C、@Transactional 注解属性 rollbackFor 设置错误
rollbackFor 可以指定能够触发事务回滚的异常类型。Spring默认抛出了未检查unchecked异常（继承自 RuntimeException 的异常）或者 Error才回滚事务；其他异常不会触发回滚事务。如果在事务中抛出其他类型的异常，但却期望 Spring 能够回滚事务，就需要指定 rollbackFor属性。
![在这里插入图片描述](https://img-blog.csdnimg.cn/729d942c9c5341ad8b04be5883578424.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
D、同一个类中方法调用，导致@Transactional失效
开发中避免不了会对同一个类里面的方法调用，比如有一个类Test，它的一个方法A，A再调用本类的方法B（不论方法B是用public还是private修饰），但方法A没有声明注解事务，而B方法有。则外部调用方法A之后，方法B的事务是不会起作用的。这也是经常犯错误的一个地方。
那为啥会出现这种情况？其实这还是由于使用Spring AOP代理造成的，因为只有当事务方法被当前类以外的代码调用时，才会由Spring生成的代理对象来管理。
```java
也就是同一个类下，调用一个已经有注解的方法，该方法给别的类调用，事务不生效，但是如果是不同类下调用有事务的方法，默认情况下事务是生效的。
```
E、捕获了异常，但是没有手动回滚事务
```java
手动回滚事务的方法：
TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动开启事务回滚
```
# 八、BeanFactory和ApplicationContext的联系和区别
1、ApplicationContext是BeanFactory的子类
2、如果使用ApplicationContext，如果配置的bean是singleton，那么不管你有没有或想不想用它，它都会被实例化。好处是可以预先加载，坏处是浪费内存。
3、BeanFactory，当使用BeanFactory实例化对象时，配置的bean不会马上被实例化，而是等到你使用该bean的时候（getBean）才会被实例化。好处是节约内存，坏处是速度比较慢。多用于移动设备的开发。
4、没有特殊要求的情况下，应该使用ApplicationContext完成。因为BeanFactory能完成的事情，ApplicationContext都能完成，并且提供了更多接近现在开发的功能。
