# 一、问题背景
今天新需求，需要用到eclipse的tomcat插件，且项目的编译环境为JDK1.7及以下，而我电脑之前的JDK为1.8，tomcat为8，现在也就是要切换JDK版本为1.7且tomcat为7，搞来搞去，搞了一天，必须记录下
# 二、同一电脑安装不同版本的JDK和tomcat
## 1、网上很多都很玄学
百度了下，很多说的很玄学，其实很简单。
## 2、不同版本JDK
同样的安装，只是环境变量配置的时候，修改JAVA_HOME为对应的JDK的安装目录即可，当然还有更简单的切换方法，比如配置AVA_HOME7和AVA_HOME8，然后用AVA_HOME=%AVA_HOME7%这样的方式，告诉你，亲测，没什么软用
## 3、不同版本tomcat
环境变量替换即可
# 三、eclipse的tomcat插件配置
找到eclipse配置下的tomcat，然后选7x，选择tomcat的安装路径，然后下面的apache-tomcat-7.0.41\conf\Catalina\localhost将xml文件加进来，因为公司项目已经配好，具体怎么搞看自己
<img src="http://pp8g2fyug.bkt.clouddn.com/eclipse%E4%B8%8B%E7%9A%84tomcat%E6%8F%92%E4%BB%B6.jpg" width=""/>

注意：当项目死活启动说缺少相应jar包，排除其他问题，那么可以考虑，是不是tomcat-advanced这里没有依赖给引进来。</br>
我就是因为这个点，最后项目启动了半天，还是有经验的同事告诉我才解决这个问题。
eclipse真是个神奇的东西，各种错误都某明奇妙，走IDEA了准备。
