# 一、问题描述
最近在idea中导入spring boot项目的依赖时，无论怎么也无法导入依赖，如图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420225355958.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
总是显示：Project 'org.springframework.boot:spring-boot-starter-parent:1.5.9.RELEASE' not found
一开始以为是maven配置的不对，重新修改配置还是不对
# 二、问题解决
原来是因为每次用idea新建项目, 二进制版本都是1.5或1.6。只需要修改settings——build Execution Deploment——Compler——java Compler里面修改，如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420225831122.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
修改成JDK1.8即可，刚开始默认是1.5的，也不知道为啥1.5就不能自动导入项目需要的依赖。反正问题就解决了。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420225941307.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
# 三、补充idea基础
## 1、进入settings，目录结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420230504104.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 2、设置主题
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420230601414.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这里默认提供了三套主题：IntelliJ，Darcula，Windows。这里可以根据自己的喜好进行选择。
## 3、设置窗体及菜单的字体及字体大小
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420230725605.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
## 4、Ctrl + 鼠标滚轮 快捷键来控制代码字体大小显示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420230853739.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
## 5、设置鼠标悬浮提示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420230924713.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
## 6、设置自动导包功能
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420230958526.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
Add unambiguous imports on the fly：自动导入不明确的结构
Optimize imports on the fly：自动帮我们优化导入的包#
## 7、设置显示行号和方法间的分隔符
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420231217341.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
如上图红圈所示，可以勾选 Show line numbers：显示行数。我建议一般这个要勾选上
如上图红圈所示，可以勾选 Show method separators： 显示方法分隔线。这种线有助于我们区分开方法，所以建议勾选上

## 8、忽略大小写提示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420231348255.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
## 9、设置取消单行显示 tabs 的操作

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420231428292.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 10、设置默认的字体、字体大小、字体行间距
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420231504625.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
## 11、修改类头的文档注释信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420231703634.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420231623228.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 12、设置项目文件编码
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420231839193.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
# 四、关于我
------
# 本文章已同步至我的GitHub仓库：<a href="https://github.com/freestylefly/javaStudy">Javastudy</a>,期待您的加入:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/github.jpg" width=""/>

# 本文章已同步至<a href="https://freestylefly.github.io/">苍何的个人博客</a>,可以直接在博客上留言哦:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/myblog..png" width=""/>

# 来我的微信公众号玩耍呗:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/weixingongzhonghao.jpg" width=""/>

# 扫码无套路关注我的<a href="https://blog.csdn.net/qq_43270074?orderby=UpdateTime">CSDN</a>博客:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/CSDN.png" width=""/>