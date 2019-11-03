## 目录
<!-- TOC -->

- [目录](#目录)
- [一、前言](#一前言)
- [二、mysql的彻底卸载](#二mysql的彻底卸载)
- [三、安装mysql](#三安装mysql)
- [四、navicat连接mysql报错1251的解决方法](#四navicat连接mysql报错1251的解决方法)
- [五、正确连接上mysql](#五正确连接上mysql)

<!-- /TOC -->

## 一、前言
买了新的台式机，装了win10操作系统，打算本地安装mysql，由于之前一直用的win7，且用的mysql版本是比较老的，现在打算安装官网最新的版本8.0.16，记录一下安装过程和遇到的坑。
## 二、mysql的彻底卸载
在安装新版本前，先要彻底卸载本机上安装的其他版本，这个地方由于我没卸载C:\ProgramData\MySQL文件夹在安装新版本的时候会报这个异常
```java
Hostname Port and Username are as shown in figure ,and password is right.When I click Test Connection ,it show as above.But if i use 3307 in place of 3306 as port,it connect sucessfully. What matter lead that and how I fix it?
```
如果你也遇到安装时候的这个链接问题，那就表明机器上的mysql没有卸载干净。
1》停止MySQL服务
开始-》所有应用-》Windows管理工具-》服务，将MySQL服务停止。
2》卸载mysql server
控制面板\所有控制面板项\程序和功能，将mysql server卸载掉。
3》将MySQL安装目录下的MySQL文件夹删除（我的安装目录是C:\Program Files (x86)\MySQL）
4》运行“regedit”文件，打开注册表。
删除HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\Eventlog\Application\MySQL文件夹
删除HKEY_LOCAL_MACHINE\SYSTEM\ControlSet002\Services\Eventlog\Application\MySQL文件夹。
删除HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\Eventlog\Application\MySQL的文件夹。
如果没有相应的文件夹，就不用删除了。
5》删除C盘下的“C:\ProgramData\MySQL ”文件夹，如果删除不了则用360粉碎掉即可，
该programData文件默认是隐藏的，设置显示后即可见，或者直接复制 C:\ProgramData 到地址栏回车即可进入！
将整个MySQL文件夹删除掉。。。
6》开始-》所有应用-》Windows管理工具-》服务
如果已经将MySQL卸载，但通过“开始-》所有应用-》Windows管理工具-》服务”查看到MySQL服务仍然残留在
系统服务里。又不想改服务名，改怎么办呢。
只要在CMD里输入一条命令就可以将服务删除：
sc delete mysql //这里的mysql是你要删除的服务名
这样一来服务就被删除了。

然后，就可以重装MySQL数据库了！！！
## 三、安装mysql
这里可以参考这个博主写的，我认为已经很详细了。在开始前请看补充点
https://blog.csdn.net/believesoul/article/details/79323530
补充点：上面的安装步骤第九步，注意看你mysql服务的名字，可以改成mysql。所以你按照默认安装好了之后服务的名称是你默认的名称，在cmd中启动服务就要实际的服务名。
查看mysql服务名方法
win+R——services.msc——找到mysql服务
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019062300222530.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
可以看到我按照默认的服务名是mysql80，右键属性
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623002317705.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
按照这个修改，否则你会连接不上win10系统下本地的mysql服务

看完这些才能去对照着安装。
## 四、navicat连接mysql报错1251的解决方法
1、新安装的mysql8，使用破解版的navicat连接的时候一直报错，如图所示：



2、网上查找原因发现是mysql8 之前的版本中加密规则是mysql_native_password,而在mysql8之后,加密规则是caching_sha2_password, 解决问题方法有两种,一种是升级navicat驱动,一种是把mysql用户登录密码加密规则还原成mysql_native_password. 由于用的是破解版的navicat，所以只能用第二种方法解决了；

3、首先以管理员身份运行cmd，然后使用命令进入mysql。



然后输入你安装mysql是设置的root密码即可进入。进入后界面如下



  注意：如果你在输入mysql -u root -p后，cmd提示mysql 不是内部或外部命令,也不是可运行的程序 或批处理文件，说明你之前安装mysql后没有在环境变量PATH中将mysql的路径添加进去。该方法在文章最后有提示；

4、然后在mysql中先更改加密方式，指令如下：

ALTER USER 'root'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE NEVER;
5、然后再更改密码，由于加密规则更改，所以需要重新设置密码；

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '新密码';
 6、最后在刷新一下数据库；

FLUSH PRIVILEGES;
最后，写一下怎么在环境变量PATH中将mysql的路径添加进去；

1、win+r-->services.msc-->右击mysql服务-->属性-->找到可执行路径并复制出来；

2、右击“我的电脑”-->属性-->高级系统设置-->环境变量-->系统变量-->PATH-->编辑-->新建-->上面的“可执行路径”，如下图所示；


## 五、正确连接上mysql

 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623002607487.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

 ## 六、总结
 1、一定要确保本机mysql完全删除干净，否则会让你怀疑人生的，相信我
 2、一定确保自己的服务名是啥
 3、新版本的mysql可能并没有老版本的稳定，使用还请注意。
 ## 七、关于我

\------

**# 本文章已同步至我的GitHub仓库：<a href="https://github.com/freestylefly/javaStudy">Javastudy</a>,期待您的加入:blush:**

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019061700583138.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

**# 本文章已同步至<a href="https://freestylefly.github.io/">苍何的个人博客</a>,可以直接在博客上留言哦:blush:**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190617005714728.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)


