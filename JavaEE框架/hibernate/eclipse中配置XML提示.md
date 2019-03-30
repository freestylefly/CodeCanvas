## 一、问题原油
当我们在eclipse中编写XML时，需要出来提示信息（前提是没有联网），那么就需要进行用户自定义配置相关信息、
## 二、步骤
这里我以配置Hibernate框架 中的XML为例子
### 1、将网络地址复制
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190127142330842.png)
### 2、打开windows下的个性设置profenrencese
如图，依次找到用户自定义设置
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190127142602526.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
点击add
### 3、add页面配置
将刚复制的网络URI地址放入keys中，type类型选择URI，location路径选择对应的路径，比如我这里对应的是hibernate-mapping-3.0的路径，需要在hibernate的jar包中找到该配置文件
### 4、完成配置

