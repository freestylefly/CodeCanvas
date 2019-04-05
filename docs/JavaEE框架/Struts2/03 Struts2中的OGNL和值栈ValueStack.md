# 一、OGNL

## 1、什么是OGNL

是一种功能强大的表达式语言，通过他可以获取对象的任意属性和方法，同时能实现必要的类型转换，比EL表达式更加的强大，可以应用在页面，Action以及配置文件中

## 2、OGNL的作用

- 对象方法调用
- 类静态方法调用
- 赋值操作和表达式串联
- 访问OGNL上下文
- 操作集合对象

## 3、OGNL的要素

- 表达式
- 跟对象root
- context对象

# 二、值栈的概述

## 1、什么是值栈

ValueStack是Struts2的一个接口，OgnlValueStatck是实现类，客户端发送一个请求就会创建一个Action实例，同时会创建一个OgnlValueStatck实例，ValueStack其实类似于数据中转站，Struts中的数据都保存在值栈中，贯穿Action的生命周期，值栈中的数据可在JSP、Action、配置文件中使用

## 2、值栈的内部结构

值栈的内部有两个主要区域，

1）root区域

实际上是一个ArrayList集合，放的是对象，实现压栈和出栈功能，拥有栈的特点，先进后出，后进先出，最后压进栈的数据再栈顶，称之为对象栈，取的时候不用加#号

通常操作值栈，就是值操作root区域，<s:debug>可查看值栈的内部结构

2）context区域

他是一个map结构，存放的是一些引用，request、session、等，其中attr代表该Map按如下顺序检索某个属性：request、session、application，其中使用<s:iterator时，var存放的是放在context中的，取的时候要加#号

## 3、ActionContext和ValueStatck的关系

通过查询源码可以知道，在创建ActionContext的时候，会创建ValueStatck对象，将ValueStatck独享给ActionContext，ActionContext中有一个ValueStatck的引用，ValueStatck中也有一个ActionContext的引用，ActionContext获取servlet的时候，依赖值栈了。

## 4、如何获取值栈对象

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190208165701231.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

两种方式，获取的是同一个值栈

## 5、向值栈存数据

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190208165733543.png)

使用第一种方式的原因是因为，默认情况下Action会被压入到值栈中，所以Action中的属性也会被放入值栈，第二种方式，会压栈，即每一次push都会将其放入栈顶

## 6、从值栈中获取数据

1）采用提供get方法的方式获取

```
<s:property value="user.cust_name"/>
```

2）采用valueStatck本身方法方式存入获取

```
<s:property value="cust_name"/>
```

3）获取值栈中集合的数据

```
<s:property value="list[0].cust_name"/>
```

4）获取context区域存放的数据

```
<s:property value="#request.cust_name"/>
```

## 7 、EL为何能访问值栈中的数据

因为Struts2的底层对request.getAttribute()方法进行了增强，找到	找到就返回，没有找到就会从值栈中去找

# 三、OGNL特殊字符

## 1、#号

1）获取context中的数据，在使用标签遍历的时候var中的值

2）构建Map集合

默认Struts2框架会识别

```
{"aa","bb","cc"}为list集合
{"aa":"11","bb":"22"}为map集合
```

当使用标签的时候，可以用#构建map集合

## 2、%号

强制解析OGNL，Struts2的有些便签不能识别OGNL，需要使用%强制解析OGNL

## 3、$号

1）在配置文件中使用

A、属性文件：国际化的地方

B：XML：如文件下载的时候使用

















