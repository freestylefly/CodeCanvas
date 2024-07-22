文末附所有要用到的资源下载链接
## 一、背景
当我们在安装oracle数据库第一次安装失败时，卸载是一件超级令人头大的事情，而且很多时候根本卸载不干净，而且oracle数据库很大，当我们本机打开的服务过多，会影响机器的运行！
这样就急需一个解决办法——
那就是将oracle11安装到虚拟机上，并在本机进行远程操控oracle数据库。
这样一来，数据库服务将通过虚拟机提供！
## 二、什么是虚拟机
虚拟机（Virtual Machine）指通过软件模拟的具有完整硬件系统功能的、运行在一个完全隔离环境中的完整计算机系统。
虚拟系统通过生成现有操作系统的全新虚拟镜像，它具有真实windows系统完全一样的功能，进入虚拟系统后，所有操作都是在这个全新的独立的虚拟系统里面进行，可以独立安装运行软件，保存数据，拥有自己的独立桌面，不会对真正的系统产生任何影响 ，而且具有能够在现有系统与虚拟镜像之间灵活切换的一类操作系统。虚拟系统和传统的虚拟机（Parallels Desktop ，Vmware，VirtualBox，Virtual pc）不同在于：虚拟系统不会降低电脑的性能，启动虚拟系统不需要像启动windows系统那样耗费时间，运行程序更加方便快捷；虚拟系统只能模拟和现有操作系统相同的环境，而虚拟机则可以模拟出其他种类的操作系统；而且虚拟机需要模拟底层的硬件指令，所以在应用程序运行速度上比虚拟系统慢得多。
***********************************************************
其实说白了就是在计算机中再装了一台虚拟的计算机！
## 三、如何安装虚拟机到本机
说明：这里我用的是VMware12版本的虚拟机，oracle用的是oracle11
1、VMware12下载地址
链接：https://pan.baidu.com/s/1K0S_558FpZU6OVWQupxe4w 
提取码：tuu4 
2、VMware12下载步骤
https://mp.weixin.qq.com/s/piIadMK80A9iRlCmcvyXaA
## 四、在虚拟机上安装操作系统
有了虚拟机，相当于你的电脑上新加了一台虚拟的计算机，需要安装操作系统，这里我安装的是Win7的版本（建议和我一致的操作系统，因为不同的操作系统可能会导致版本兼容性问题）
1、win7系统下载地址：
链接：https://pan.baidu.com/s/1G_BpabXfQUCc77GocPgOKg 
提取码：9dla 
2、win7系统安装在虚拟机上的步骤：
https://mp.weixin.qq.com/s/piIadMK80A9iRlCmcvyXaA
（在文章第二部分，看仔细）
3、按照步骤安装成功后，你会看到本机上一台虚拟的计算机诞生了，庆祝一下吧！·^_^·
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228223723278.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
可以看到在虚拟机上一样可以上网，装各种软件，而且比本机运行速度快！
那么你一定很奇怪怎么进行联网呢？
## 五、VMVare虚拟机网络配置
这些步骤的目的是为了将虚拟机的IP地址设置成笃定的IP地址，这样在本机连接虚拟机上的数据库时访问的IP地址是固定的！——当然还有一个最重要的目的，就是可以上网装逼喽，哈哈，所以认真跟着做吧！

1、设置VMVare的默认网关: 
1）.编辑->虚拟网络编辑器: 
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018122822432732.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
2）打开虚拟网络编辑器,点击添加网络：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228224512443.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
3）选择一个不重复的网络名称
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228224620165.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
4）修改此网络为NAT模式
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228224817707.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
5）特别注意：
只能将一个网络设置成NAT模式
由于我之前设置了一个网络19位NAT模式，这里以我设置的为例：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228225140626.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
6）查看该自定义网络相关信息：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228225246667.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这里的信息都不需要进行更改
2、修改虚拟机的网络适配器为自定义的网络
对该虚拟机进行右键——设置
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228225722249.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
点击网络适配器——自定义，选择刚刚设置的网络名称
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228225812359.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
3、设置本地主机的虚拟网卡
1）打开本机（是原先自己的计算机不是虚拟机）的网络和共享中心![在这里插入图片描述](https://img-blog.csdnimg.cn/2018122823103647.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
2）点击更改适配器设置
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228231134734.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
3）找到你在虚拟机上新加的网络
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228231310123.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
4）右键属性
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228231339805.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
5）双击：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228231414837.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
6）选择IP地址
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018122823144751.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
7）点击确定网络设置大功告成
4、查看虚拟机是否连接上网络
打开IE，随便访问一个网址，或者看右下角看是否连接成功
5、查看虚拟机的IP地址
如果你没记住虚拟机的IP地址，可以在虚拟机的dos窗口下输入命令ipconfig
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228232003606.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
6、查看虚拟机和本机能否正常连接
分别在虚拟机和本机的dos窗口下ping一下对方的ip地址即可查看是否连接成功，这里我以在本机查看为例，在虚拟机上查看一样的效果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228232502791.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这样代表你已经和你的虚拟机建立连接了，庆祝一下吧！
——————————————————————————————
## 六、在虚拟机上安装oracle11数据库
终于到了最关键的一步，在虚拟机上安装oracle11
1、新建oracle目录
在虚拟机的C盘下新建oracle目录，这将用来存放oracle11
2、下载oracle11地址（我用的是解压版）

3、解压
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228233034365.png)
一起选中这两个压缩包一起解压到当前目录
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228233129951.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
4、将解压后的文件拖人虚拟机
将解压后的database文件夹拖入到虚拟机刚刚在C盘下创建的oracle目录下
5、打开database文件夹，启动setup
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018122823342892.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
6、安装第一步：配置安全更新，这步可将自己的电子邮件地址填写进去（也可以不填写，只是收到一些没什么用的邮件而已）。取消下面的“我希望通过My Oracle Support接受安全更新(W)”。 如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228233643933.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
7、安全选项，直接选择默认创建和配置一个数据库(安装完数据库管理软件后，系统会自动创建一个数据库实例)。 如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228233727388.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
8、系统类，直接选择默认的桌面类就可以了。(若安装到的电脑是，个人笔记本或个人使用的电脑使用此选项) 如图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228233756815.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
9、 典型安装。 重要步骤。建议只需要将Oracle基目录更新下，目录路径不要含有中文或其它的特殊字符。全局数据库名可以默认，且口令密码，必须要牢记。密码输入时，有提示警告，不符合Oracel建议时不用管。 (因Oracel建议的密码规则比较麻烦， 必须是大写字母加小写字母加数字，而且必须是8位以上。麻烦，可以输入平常自己习惯的短小密码即可)  如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228233833538.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
10、若输入的口令短小简单，安装时会提示如下。直接确认Y继续安装就是了。如图：
![](https://img-blog.csdnimg.cn/20181228233859798.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
11、先决条件检查。 安装程序会检查软硬件系统是否满足，安装此Oracle版本的最低要求。 直接下一步就OK 了。如图：
![](https://img-blog.csdnimg.cn/20181228233922115.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
12、 概要 安装前的一些相关选择配置信息。 可以保存成文件 或 不保存文件直接点完成即可。如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228234000109.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
13、安装产品 自动进行，不用管。如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/201812282340508.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
14、 数据库管理软件文件及dbms文件安装完后，会自动创建安装一个实例数据库默认前面的orcl名称的数据库。如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228234114952.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
15、实例数据库创建完成了，系统 默认是把所有账户都锁定不可用了(除sys和system账户可用外)，建议点右边的口令管理，将常用的scott账户解锁并输入密码。 如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228234138646.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
16、解锁scott账户和HR账户， 去掉前面的绿色小勾，输入密码。同样可以输入平常用的短小的密码，不必非得按oracle建议的8位以上大小写加数字，麻烦。如图：（题外话，scott是oracle起初团队的一个员工这个账户下能看到一些视图，HR是测试账号，一定要记住这两个账号名和密码：Scott密码设置成tiger，HR密码设置成hr）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228234443226.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这里没有标出HR账号，需要自行找到并同样方式解锁
17、安装成功，完成即可
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228234514753.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
部分引用自该博客，感谢：
https://www.cnblogs.com/hoobey/p/6010804.html
## 七、在虚拟机上测试oracle11是否安装成功
1、在虚拟机上以管理员身份运行dos，
2、输入指令sqlplus
3、输入用户名：
4、输入口令
这里对应的用户名和密码有四个，我列举出三个：
system——口令是在刚开始安装数据库的时候设置的
scott——口令是tiger
HR——口令是hr
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228235026402.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这样表示已经安装成功
## 八、本机通过和InstantClient工具连接到虚拟机数据库
1、在虚拟机上设置相关参数
1）修改listener和tnsnames的配置信息
这里我将oracle11安装在了C盘下的oracle下的root目录下
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228235425939.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
2）依次点击找到这个目录：C:\oracle\root\product\11.2.0\dbhome_1\NETWORK\ADMIN
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228235639368.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
分别用记事本打开
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228235745574.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228235852830.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
将localhost修改成虚拟机的IP地址
并将修改后的tnsnames配置文件进行拷贝，这个配置文件需要拷贝到InstantClient工具包的一个目录下
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181228235954355.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
2、分别安装PLSQLDeveloper和InstantClient工具到本机上
PLSQLDeveloper下载地址：

InstantClient下载地址：

3、注意：
这两个工具安装需要安装的目录不能有空格和中文，建议不要放在C盘下面
4、找到instantclient_11_2下的目录
instantclient_11_2——NETWORK——ADMIN——tnsnames.ora
将tnsnames.ora删除，并将在虚拟机上拷贝的tnsnames.ora放进去
5、本机环境变量的配置
新建系统环境变量，变量名为TNS_ADMIN，变量值为tnsnames.ora在本机的目录（就是刚才拷贝的地方目录）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229000806153.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
6、PLSQLDeveloper工具连接数据库
PLSQLDeveloper是基于InstantClient下进行的，所以一定按照我的步骤进行
1、将PLSQLDeveloper安装在和InstantClient一级目录下，并创建桌面快捷方式，点击快捷方式
先不管用户名和密码进入到PLSQLDeveloper图形化界面
2、设置
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229001525757.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229001602810.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这两个地方的值分别是：
instantclient_11_2的安装路径和instantclient_11_2下的oci.dll的安装路径
![在这里插入图片描述](https://img-blog.csdnimg.cn/201812290018199.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229001831218.png)
3、重启PLSQLDeveloper客户端
输入用户名和密码
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229001930930.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
用户名和密码是在虚拟机上安装的oracle11的设置的用户名，system、scott、HR，输入队形的密码，点击确定
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229002104111.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这时该工具会去虚拟机寻找对应的数据库并寻找对应的用户名和密码
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229002218540.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
左上角代表登录状态，显示已登录成功，这个时候查看一下数据库
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229002322234.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018122900235625.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
运行后：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181229002419494.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

终于完成、查到啦！
该奖励自己一个鸡腿了，哈哈哈，想通了过程就不难！希望共同进步。。。。
————————————————————————————————

## 九、所有资源下载地址：
1、虚拟机下载：
2、运行在虚拟机上的操作系统下载
3、oracle11g下载
4、InstantClient下载
5、PLSQLDeveloper下载
## 十、最后说明
码字不易，需要支持，感谢，此文同步我的GitHub和微信公众号，欢迎关注和点赞。
1、GitHub
所有文章均以同步我的GitHub仓库，欢迎pull requests ，并期待你的star（即点赞）
https://github.com/freestylefly/javaStudy
2、微信公众号：苍何之旅
微信搜索：苍何之旅，或者扫码即可关注
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181210111159299.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)




