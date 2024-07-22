# 目录
- [目录](#目录)
- [一、前言](#一前言)
- [二、运行时数据区整体概架构](#二运行时数据区整体概架构)
- [三、程序计数器](#三程序计数器)
- [四、虚拟机栈](#四虚拟机栈)
  - [1、栈的特点](#1栈的特点)
  - [2、栈帧的内部结构](#2栈帧的内部结构)
  - [3、局部变量表](#3局部变量表)
  - [4、操作数栈](#4操作数栈)
  - [5、动态链接](#5动态链接)
  - [6、方法返回地址](#6方法返回地址)
- [五、本地方法栈](#五本地方法栈)
- [六、堆](#六堆)
  - [1、设置堆大小的参数](#1设置堆大小的参数)
  - [2、对象分配过程](#2对象分配过程)
  - [3、堆中的GC](#3堆中的gc)
  - [4、内存分配策略](#4内存分配策略)
  - [5、什么是TLAB](#5什么是tlab)
  - [6、堆是分配对象存储的唯一选择吗？](#6堆是分配对象存储的唯一选择吗)
- [七、方法区](#七方法区)
  - [1、方法区概述](#1方法区概述)
  - [2、设置方法区内存大小](#2设置方法区内存大小)
  - [3、如何解决OOM问题？](#3如何解决oom问题)
  - [4、方法区存储什么](#4方法区存储什么)
  - [5、方法区的演进细节](#5方法区的演进细节)
  - [6、方法区的GC](#6方法区的gc)

# 一、前言
大家好，我是苍何。最近思考了一个问题，为什么会出现公司面试造火箭，工作扭螺丝的现象，包括各种八股文的连环大绝杀问到你不会为主，其实这是考察你的知识面以及掌握的深度，而为什么需要这样呢？归其原因，无非是通过筛选找到那些会思考的人，他们需要的并不是CRUD的工具人，而是会思考能创新的工程师。

当你深刻理解到这点，我想不用刻意去学习，在工作中，肯定会吾日三省吾身。

于是乎，这个重新开始学习编程系列文章出来了。

愿与君共勉！

这是JVM系列文章的第三篇，这篇文章将对整个JVM运行时数据区和GC垃圾回收详细的介绍。这部分也算是JVM的核心内容了。

# 二、运行时数据区整体概架构
![在这里插入图片描述](https://img-blog.csdnimg.cn/05832487137143368c4d5410e972bdfd.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**以下是自己的一句话总结：**
分为线程私有和线程共享的两大类，其中程序计数器、虚拟机栈、本地方法栈是属于线程私有的，堆内存及方法区内存是线程共享的。程序计数器主要是记录字节码指令，CPU上下文切换线程，从一个线程切换到另一个线程，需要知道线程执行到哪一步，所以记录这个指令就是很有必要的，程序计数器无OOM和GC的发生。虚拟机栈里面是一个个栈帧，每一个栈帧对应着每一个方法，栈帧又是由局部变量表、操作数栈、方法返回值地址、动态链接组成。虚拟机栈可能会发生栈溢出异常，即starkoverflow本地方法栈是存放本地方法相关的东西；堆是一块很大的空间，整体分为2大块，新生代和老年代，新生代又分了Eden区、S0区、S1区，垃圾回收主要发生在新生代，每一个区对应不同的垃圾回收算法；方法区保存的是一些常量、类的基本信息等，方法区对应的实现在JDK7中是永久代，在JDK8中是元空间。

# 三、程序计数器
用来储存指向下一条指令的地址，是线程私有的，生命周期和线程的生命周期一致。
![在这里插入图片描述](https://img-blog.csdnimg.cn/ee8351a42d5a4a3290171519892d5823.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/054d97580fb24dad9598a7025d543863.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/0bac3e2dedcb4d8198fbebb55d749d40.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/7fb1f7d392f64206b4b17cb07dbfa88a.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

# 四、虚拟机栈
虚拟机栈是线程私有的，内部保存一个个栈帧，每一个栈帧对应一个Java方法的调用，生命周期和线程的生命周期保持一致。先来看看栈的特点。
![在这里插入图片描述](https://img-blog.csdnimg.cn/bd928493952c4edc853b0a6550299a22.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

## 1、栈的特点
栈是运行时的单位，而堆是存储的单位。栈的特点是先进后出，后进先出。
![在这里插入图片描述](https://img-blog.csdnimg.cn/626a1ab09ee34133beeb23cbbb9baee5.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/0efc33359dc44c83a16860f523a8adc8.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/27dab23e16f2412ba84293a13b51555c.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/ff2ee99ad1c54a75ab08f520f70b8a70.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

可以通过参数-Xss来设置栈空间大小

## 2、栈帧的内部结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/7b4ba152a28040cf827f8f711f65b875.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 3、局部变量表
是一个数字数组，主要用于存储方法参数和定义在方法内的局部变量，这些数据类型包括各类基本数据类型，对象引用等，所需的容量大小是在编译期确定下来的，在方法运行期间是不会改变局部变量表大小的。
**关于Slot的理解：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/6a7c7b1432cb40d3a16f895e7d585cb4.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**静态变量和局部变量的区别：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/b4a1ecc6ead5477aab301cc9b4f69e23.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**总结：**
在栈帧中，与性能关系最为密切的就是局部变量表，在方法执行时，虚拟机使用局部变量表完成完成方法的传递，局部变量表中的数据也是可达性分析中的GC Root，如果一个对象在局部变量表中还有引用，那么根绝可达性分析算法，这个变量就不属于垃圾对象，是不会被GC回收的。

## 4、操作数栈
操作数栈是栈中栈，也可称为表达式栈，在方法执行过程中，根据字节码指令，往栈中写入数据或提取数据，即入栈和出栈。主要用于保存计算过程的中间结果。操作数栈，可以看成是临时寄存器，计算过程中变量的临时保存 
![在这里插入图片描述](https://img-blog.csdnimg.cn/3d4ea2d92ade48fa9fb8e881ba5fc6d3.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a816fcef38b24a86b87dc0d6085ad3cc.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/d83d2b317c1b469ca792181ef2d1d45e.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/90a2b65bce454656ab5504957dd7be2e.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/3de79b5ef49d4b12a463d32da55b452d.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

## 5、动态链接
![在这里插入图片描述](https://img-blog.csdnimg.cn/7415ad407980495a93706878622359fd.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/5074368eb69d4ee4983fff73c144ebd0.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**方法重写的本质**
![在这里插入图片描述](https://img-blog.csdnimg.cn/b928b14830104bab80d4df918a70b555.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 6、方法返回地址
存放调用该方法的PC寄存器的值
![在这里插入图片描述](https://img-blog.csdnimg.cn/71e40c1b074d466b9abf3c8978cc0a46.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
# 五、本地方法栈
管理本地native本地方法，是线程私有的，所谓的本地方法，其实就是一些非Java语言写的代码，这部分代码甚至可以和操作系统CPU进行打交道。

# 六、堆
堆是内存管理的核心区域，是线程共享的，属于JVM级别，也就是一个JVM实例就会有一个堆空间，注意的是虽然堆整体上是线程共享的，但是在内部有一小块空间是线程私有的缓存区TLAB。

几乎所有的对象实例都是在堆中，堆是GC垃圾回收的重点区域。堆整体可以分为新生代和老年代，新生代又分为Eden区和S0和S1区。
![在这里插入图片描述](https://img-blog.csdnimg.cn/4b840eef228349d7b97212039da3fd80.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
新生代和老年代的比例是1：2，Eden区和s0，s1区所占空间比例是8：1：1

## 1、设置堆大小的参数
-Xms：用于表示堆区的起始内存，默认情况下，占物理内存大小的64分之一。
-Xmx用于表示堆区的最大内存，默认情况下，占物理内存的四分之一。
```
通常起始内存和最大内存两个参数设置成一样，目的是为了GC清理完堆区内存后不需要重新分隔
计算堆区的大小，从而提高性能。
查看设置的参数：
方式一：jps(查看进程）  
            jstat -gc 进程id
方式二：-xx:+printGCDetails
```
## 2、对象分配过程
![在这里插入图片描述](https://img-blog.csdnimg.cn/f8965f1764554ca9a3df593d40231303.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
这里s0和s1谁是空的谁就是to，年龄计数器阈值是15，YGC是在Eden区满的时候会触发，s0和s1满的时候不会触发YGC，YGC会将s区以及伊甸园区一起GC
关于垃圾回收，频繁在新生区收集，很少在养老区收集，几乎不在永久区/元空间收集。
![在这里插入图片描述](https://img-blog.csdnimg.cn/fc29aaad7cfe4144aff5a1a4a8d31236.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
```
Visualvm是JVM常用调优工具，在JDK的bin下就可以打开
```

## 3、堆中的GC
![在这里插入图片描述](https://img-blog.csdnimg.cn/e86bc7af08874e82b152031b879588f2.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
年轻代（Minor GC）触发机制
![在这里插入图片描述](https://img-blog.csdnimg.cn/d8c20c972130480cbd14d0e02c9d0e7d.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
老年代GC（Major GC/Full GC）触发机制

Full GC 触发机制

![在这里插入图片描述](https://img-blog.csdnimg.cn/94d7e36e7a2442d6ac2b453634e192eb.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 4、内存分配策略
![在这里插入图片描述](https://img-blog.csdnimg.cn/be02e59545c74fcb99f892f7a153d146.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 5、什么是TLAB
![在这里插入图片描述](https://img-blog.csdnimg.cn/46cbecb1313b4ee2ab6a701fca42b4db.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/b70c424043594286b458a9ab774cabbe.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
TLAB表明堆不一定是共享的。
## 6、堆是分配对象存储的唯一选择吗？
如果经过逃逸分析，一个对象并没有逃逸出方法的话，那么就有可能被优化成栈上分配。

**逃逸分析手段：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/f698ba6a28fd4f3b8ac05bcd2531aa52.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

![在这里插入图片描述](https://img-blog.csdnimg.cn/3af6acf230884658bd7f459af8f3dd25.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**注意：JDK6U23版本后，HotSpot默认已经开启逃逸分析。所以我们得出一个结论，开发中能使用局部变量的，就不要使用在方法外定义。JDK7后字符串常量池和静态变量存储在堆中**



# 七、方法区
方法区可以看做是一块独立于堆的内存空间，是线程共享的，主要存储类信息、运行时常量池等，也会发生OOM，JDK8前成为永久代，JDK8成为元空间。（元空间和永久代最大的区别是，元空间不再使用JVM内存，而是使用了本地内存技术）
## 1、方法区概述
![在这里插入图片描述](https://img-blog.csdnimg.cn/09faa918a2d34f54b3a303970d461004.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)


![在这里插入图片描述](https://img-blog.csdnimg.cn/df267728b0bb45b7945038835eb8aad9.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/c87f959077c5436c89743944543cdc96.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/bc7ae75ed0a04976a679006eb5e7312e.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 2、设置方法区内存大小
![在这里插入图片描述](https://img-blog.csdnimg.cn/1f06f3b4cf8d4eb99eb8496504609352.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

![在这里插入图片描述](https://img-blog.csdnimg.cn/517432b28a0c4879b7b467a9d2eeee80.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

## 3、如何解决OOM问题？
![在这里插入图片描述](https://img-blog.csdnimg.cn/659024346c9f4c8a900721bf03c423b2.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 4、方法区存储什么
![在这里插入图片描述](https://img-blog.csdnimg.cn/fe108e418e3843e19228ef6325663740.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/c7d23354b31b4072ac57e61657f43719.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/f5cf344ad27a408a888a70b46f454d40.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/acbee260a22e4efc816143540ea82723.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/25b6106e28be49e09149510ffbeb3047.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 5、方法区的演进细节
![在这里插入图片描述](https://img-blog.csdnimg.cn/3c7cd733803f4ec2bf20e331f5c3332a.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/1574cec5156f483e98d3538ad898e4d3.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 6、方法区的GC
![在这里插入图片描述](https://img-blog.csdnimg.cn/ee4f711da8f946ac92623a9d780f1cc5.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/429cadf47a4c4ca9a543317db3b7bea3.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2f40b9cafece4a46b1d6254a42243a61.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

