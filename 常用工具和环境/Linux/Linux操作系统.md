## 一、Linux概述
Linux和Windows均属于操作系统的范畴，和windows不同的是，他没有像Windows有图形化界面，可以鼠标点点点，Linux所有操作都是命令行操作，Linux不同于Windows，是个开源的操作系统，全世界有很多的开发者都参与到Linux的建设中。
Linux可安装在各种计算机硬件设备中，比如手机、平板电脑、路由器、台式计算机。
Linux是由芬兰赫尔辛基大学学生Linus Torvalds和后来加入的众多爱好者共同开发完成，Linux之父Linus Torvalds于19年宣布退休。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191110162754370.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
## 二、Linux目录结构
bin (binaries)存放二进制可执行文件
sbin (super user binaries)存放二进制可执行文件，只有root才能访问
etc (etcetera)存放系统配置文件
usr (unix shared resources)用于存放共享的系统资源
home 存放用户文件的根目录
root 超级用户目录
dev (devices)用于存放设备文件
lib (library)存放跟文件系统中的程序运行所需要的共享库及内核模块
mnt (mount)系统管理员安装临时文件系统的安装点
boot 存放用于系统引导时使用的各种文件
tmp (temporary)用于存放各种临时文件
var (variable)用于存放运行时需要改变数据的文件
## 三、java开发用到的Linux命令

操作文件或目录常用命令
```
pwd 显示当前工作目录（print working directory）
touch 创建空文件                                 
mkdir 创建目录（make directoriy）
-p 父目录不存在情况下先生成父目录 （parents）            
cp 复制文件或目录（copy）
-r 递归处理，将指定目录下的文件与子目录一并拷贝（recursive）     
mv 移动文件或目录、文件或目录改名（move）

rm 删除文件（remove）
-r 同时删除该目录下的所有文件（recursive）
-f 强制删除文件或目录（force）
rmdir 删除空目录（remove directoriy）
cat显示文本文件内容 （catenate）
more、less 分页显示文本文件内容
head、tail查看文本中开头或结尾部分的内容
haed  -n  5  a.log 查看a.log文件的前5行
tail  -F b.log 循环读取（follow）

```
常用命令
```
wc 统计文本的行数、字数、字符数（word count）
-m 统计文本字符数
-w 统计文本字数
-l 统计文本行数
find 在文件系统中查找指定的文件
find /etc/ -name "aaa"
grep 在指定的文本文件中查找指定的字符串
ln 建立链接文件（link）
-s 对源文件建立符号连接，而非硬连接（symbolic）

top 显示当前系统中耗费资源最多的进程 
ps 显示瞬间的进程状态
-e /-A 显示所有进程，环境变量
-f 全格式
-a 显示所有用户的所有进程（包括其它用户）
-u 按用户名和启动时间的顺序来显示进程
-x 显示无控制终端的进程
kill 杀死一个进程
kill -9 pid
df 显示文件系统磁盘空间的使用情况

du 显示指定的文件（目录）已使用的磁盘空间的总
-h文件大小以K，M，G为单位显示（human-readable）
-s只显示各档案大小的总合（summarize）
free 显示当前内存和交换空间的使用情况 
netstat 显示网络状态信息
-a 显示所有连接和监听端口
-t (tcp)仅显示tcp相关选项
-u (udp)仅显示udp相关选项
-n 拒绝显示别名，能显示数字的全部转化成数字。
-p 显示建立相关链接的程序名
ifconfig 网卡网络配置详解 
ping 测试网络的连通性 


```
备份压缩命令
```
gzip 压缩（解压）文件或目录，压缩文件后缀为gz 
bzip2 压缩（解压）文件或目录，压缩文件后缀为bz2 
tar 文件、目录打（解）包

```
gzip命令
```
命令格式：bzip2 [-cdz] 文档名
-c将压缩的过程产生的数据输出到屏幕上
-d解压缩的参数（decompress）
-z压缩的参数（compress）
-num 用指定的数字num调整压缩的速度，-1或--fast表示最快压缩方法（低压缩比），-9或--best表示最慢压缩方法（高压缩比）。系统缺省值为6
```
tar命令
```
-c 建立一个压缩文件的参数指令（create）
-x 解开一个压缩文件的参数指令（extract）
-z 是否需要用 gzip 压缩
-j 是否需要用 bzip2 压缩
-v 压缩的过程中显示文件（verbose）
-f 使用档名，在 f 之后要立即接档名（file）

```
关机/重启命令
```
shutdown系统关机 
-r 关机后立即重启
-h 关机后不重新启动
halt 关机后关闭电源 shutdown -h
reboot 重新启动 shutdown -r
```
## 四、Linux文档
可以参考这篇文档
https://blog.csdn.net/syt8945/article/details/50838679
