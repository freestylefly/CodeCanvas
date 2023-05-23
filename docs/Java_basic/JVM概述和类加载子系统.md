# 目录
- [目录](#目录)
  - [一、前言](#一前言)
  - [二、虚拟机的概念](#二虚拟机的概念)
  - [三、JVM整体概述](#三jvm整体概述)
    - [1、JVM整体架构](#1jvm整体架构)
    - [2、java代码的执行流程](#2java代码的执行流程)
    - [3、JVM生命周期](#3jvm生命周期)
    - [4、JVM发展历程](#4jvm发展历程)
  - [四、类加载子系统](#四类加载子系统)
    - [1、概述](#1概述)
    - [2、类的加载过程](#2类的加载过程)
    - [3、类加载器](#3类加载器)
    - [4、双亲委派机制](#4双亲委派机制)
    - [5、沙箱安全机制](#5沙箱安全机制)


## 一、前言
大家好，我是苍何。最近思考了一个问题，为什么会出现公司面试造火箭，工作扭螺丝的现象，包括各种八股文的连环大绝杀问到你不会为主，其实这是考察你的知识面以及掌握的深度，而为什么需要这样呢？归其原因，无非是通过筛选找到那些会思考的人，他们需要的并不是CRUD的工具人，而是会思考能创新的工程师。

当你深刻理解到这点，我想不用刻意去学习，在工作中，肯定会吾日三省吾身。

于是乎，这个重新开始学习编程系列文章出来了。

愿与君共勉！


我记得当年学java的时候，就很好奇，为什么我在IDEA上写一些代码（其实就是一堆我们人能知道的英文单词的组合加一些运算符），为什么就可以在windows上运行后执行我们的指令，而且还可以打成jar包去linux系统跑起来，为什么一份代码可以在不同平台运行呢？类是如何加载的？对象如何创建的以及都有哪些信息？我创建的对象被分配到哪个内存去了？java是怎么和我们操作系统打交道的又是怎么调用CPU为我们计算的？创建了对象分配了内存，为什么可以不用手动回收就可以自动清理内存等等等，相信你也同样有过这些困惑。
![在这里插入图片描述](https://img-blog.csdnimg.cn/af450402a7824e1087a70c8bc4661ec2.jpg#pic_center)


之前我都是部分在一些博客或者网站上进行查看资料，概念大概能理解，但可能还不够系统的掌握这部分知识，现在我看了几百集的宋红康老师的视频教程，感到收益匪浅，特此总结记录一下。

下面就我的理解以及一些宋红康老师的图形进行一个系统的总结。我做了个系统轮廓的导图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/f06dc37b8a634011815ce05302ad3b82.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
为了防止文章过于长，我将分几篇文章进行发布。

## 二、虚拟机的概念
**系统虚拟机：**
VMware，可运行完整操作系统的软件平台
**程序虚拟机：**
运行字节码指令，如java虚拟机
## 三、JVM整体概述
执行字节码的虚拟计算机，所有java程序都运行在java虚拟机内部
一次编译，到处运行，自动内存管理，自动垃圾回收功能

### 1、JVM整体架构
![在这里插入图片描述](https://img-blog.csdnimg.cn/af8d34819f2e4d53a5f09ed29711cf99.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/f360d101850d40e9b1850ece1e10631f.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

### 2、java代码的执行流程

java程序经过前端编译器编译成class文件，也即字节码文件，这些文件我们用文本工具打开，就是这样一串乱码的东东

![在这里插入图片描述](https://img-blog.csdnimg.cn/f6e2722921db48eb8ab4b1f85c95c02f.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
我们可以用idea的jclasslib Bytecodes viewver打开字节码文件，可以看到其实是包含很多结构的，有方法的信息，字节码指令，局部变量表信息及长度等。

![在这里插入图片描述](https://img-blog.csdnimg.cn/e6d043f60a2b4266ad593cca633705f5.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

表明这个class文件其实就是一些指定格式的文件，也就是说不光java语言，其他语言，只要按照规范的格式也是可以被JVM虚拟机识别并执行的，所以JVM不仅仅只是java虚拟机。

如下图，不同平台的JVM实现会去运行字节码文件，通过JVM转为各个系统所能识别的操作指令，然后通过CPU执行运算，这就是java代码的执行流程，当然这其中会涉及很多，让我们慢慢看。

![在这里插入图片描述](https://img-blog.csdnimg.cn/c9443bcf0be440e1a1b779cf598e4922.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/135fafd6b79b4229a65c5b25a48642e9.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
### 3、JVM生命周期
1、虚拟机的启动
是通过引导类加载器创建一个初始类来完成的，这个类是由虚拟机的具体实现指定的
2、虚拟机的执行
程序开始执行，程序结束后就结束，
执行一个所谓的java程序，真正在执行的是一个叫java虚拟机的进程
3、虚拟机的退出
程序正常结束、异常、操作系统出现错误，线程调用System.exit()方法
### 4、JVM发展历程
1、Sun Classic VM
第一款商用虚拟机，只提供了解释器，现在hotspot内置了此虚拟机
2、exact VM
准确是内存管理
3、HotSpot VM
通过计数器找到最具编译价值代码，触发即时编译或栈上替换
通过边以及与解释器协同工作，在最优化的程序响应时间与最佳执行性能中取得平衡
4、JRockit
专注于服务器端应用数据显示是最快的虚拟机，全部代码都靠即时编译器执行
5、J9
有影响力的三大商用虚拟机之一，

## 四、类加载子系统
### 1、概述
类加载子系统是JVM用类加载器将类加载进内存，类的信息会存放于运行时数据区的方法区（后面会细说），加载类的时候也会做一些初始化的操作，如会进行clinit和init等。
![在这里插入图片描述](https://img-blog.csdnimg.cn/d3e9ddcec9c14944961213ee74e9d878.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
### 2、类的加载过程
相信很多伙伴面试都被问到过这吧，要说好这道题，得仔细理解。

总共分三大快来讲
首先是加载阶段，将.class文件加载到内存
其次是链接阶段，这部分又包含验证、准备和解析阶段
最后最初始化操作
![在这里插入图片描述](https://img-blog.csdnimg.cn/f9850b4313f84de485a173e7116f2d46.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2970e17e1c5943c0bcce4e498a3d7dc9.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

**加载阶段：**

![在这里插入图片描述](https://img-blog.csdnimg.cn/b3abcb57f3f347bf949c57480a283ec4.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)![在这里插入图片描述](https://img-blog.csdnimg.cn/ace8c10a1f484b8ea97db5655b290845.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**链接阶段**
![在这里插入图片描述](https://img-blog.csdnimg.cn/86416c83263b46198401390f5edde7b8.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**初始化**
![在这里插入图片描述](https://img-blog.csdnimg.cn/cc77c2bcdb98474fa20776b5992d6a5c.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
clinit其实就是初始化类中静态的变量，如int静态变量会初始化为0，init就是初始化类的构造器。

### 3、类加载器
分2类，引导类加载器和自定义类加载器，直接或间接继承抽象类ClassLoader的类加载器都划分为自定义类加载器。

这里说几个常用的类加载器，在后面双亲委派机制会用到
1、启动类加载器（Bootstrap ClassLoader）
虚拟机自带的加载器，java的核心类库都是通过该类加载器进行加载的，处于安全，Bootstrap启动类加载器只加载包名为java、javax、sun等开头的类
2、扩展类加载器
加载扩展目录jre/lib/ext子目录下的
3、系统类加载器
用户自定义的类来说，默认用的是系统类加载器进行加载（属于自定义类加载器）

*注意：这三个是有层级关系的，123分别是从上到下的关系，这里的层级并不是父子的关系，倒像是目录的那种层级关系*

**如何获取当前类的类加载器：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/edc4d53f74704d258b2326282746d454.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
### 4、双亲委派机制
一个类加载器收到了类加载请求，他是不会先去自己加载的，而是会去委托自己的父类去加载，如果父类加载器还存在其父类加载器，则递归一直向上委托，请求其实最终都会到达顶层的启动类加载器（这里不明白层级的可以看第3点讲的层级关系），如果父类加载器可以加载该类就由他来加载，如果做不到，就给子类自己去加载罢了。

![在这里插入图片描述](https://img-blog.csdnimg.cn/c1d3d28ea23a4380ad11b882c0dde9c7.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/cd85a4de291f472283915ee317da7a0b.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**优势：**
1、避免类重复加载
2、保护程序安全，防止核心类API被篡改。

### 5、沙箱安全机制
所谓沙箱安全机制，其实就是为了保护java的核心API而设置的，其实和双亲委派机制都是用来保护核心API的，比如，你自定义一个包也叫java.lang，并也定义了一个类也叫String，这时候定义一个main方法，启动，会发现程序报错。
![在这里插入图片描述](https://img-blog.csdnimg.cn/24876ccbc48246f28f502d761fa26735.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
这是因为，类加载器真正去加载的其实是核心API下的String类，根本不是我们自定义的类，也就是我们自定义的类压根没被加载到内存中来，当我们执行main方法，核心包下的String类当然没有该方法。

所以在建包的时候，也不允许建和核心API同名的包，实际公司中，通常都会以公司域名或者标识进行包名命名。
![在这里插入图片描述](https://img-blog.csdnimg.cn/c04e2ce99edd49ff97c1c859d09d7b41.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/3db327d899b049a7bbfa98d381b1df36.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

