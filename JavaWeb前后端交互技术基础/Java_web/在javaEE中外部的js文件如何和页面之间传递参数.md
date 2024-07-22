问题：当我们在进行javaEE开发时（原生态开发，未利用框架），需要为页面引入外部JS脚本，但是在外部JS脚本中是没法利用EL表达式拿到我们想要的参数的，一个最简单的例子就是：当我们在页面点击某个按钮的时候，想要进行跳转，在外部JS中，需要改变location的值，此时需要用到工程的根目录

我们都知道在页面中可以利用EL表达式：

```java
${pageContext.request.contextPath }
```
就可以拿到工程根目录，如何在外部JS中也拿到页面的参数呢？方法很简单
## 1、在外部JS中声明需要用到的变量，如工程根目录
有时候将所有JS都需要用到的js变量抽出去，携程project.js
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019011816234686.png)
## 2、在页面body之后引入所有要使用到的外部js文件
一定要在body之后。这是页面加载问题
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190118162031665.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
## 3、在引入外部js的最后协商页面内部js代码
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190118162131509.png)
## 4、这个时候你的外部JS就可以使用该变量了


## 总结
外部js要想使用页面的某一变量，需要先在js里面声明，然后加载到页面，最后在页面的最后为该变量进行赋值即可



