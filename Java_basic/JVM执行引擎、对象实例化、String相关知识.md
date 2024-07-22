# 目录
- [目录](#目录)
- [前言](#前言)
- [一、JVM执行引擎](#一jvm执行引擎)
  - [1、执行引擎的工作过程](#1执行引擎的工作过程)
  - [2、java代码编译和执行的过程](#2java代码编译和执行的过程)
  - [3、什么是解释器，什么是编译器](#3什么是解释器什么是编译器)
  - [4、为什么说java是半编译半解释型语言](#4为什么说java是半编译半解释型语言)
  - [5、机器码、指令、汇编语言、高级语言](#5机器码指令汇编语言高级语言)
  - [6、HotSpot JVM执行方式](#6hotspot-jvm执行方式)
  - [7、JIT编译器](#7jit编译器)
  - [8、方法调用计数器](#8方法调用计数器)
- [二、对象实例化](#二对象实例化)
  - [1、创建对象的方式及创建对象步骤](#1创建对象的方式及创建对象步骤)
  - [2、对象内存布局](#2对象内存布局)
  - [3、对象的访问定位](#3对象的访问定位)
- [三、String相关知识](#三string相关知识)
  - [1、String的基本特性](#1string的基本特性)
  - [2、string的内存分配](#2string的内存分配)
  - [3、字符串的拼接操作](#3字符串的拼接操作)
  - [4、intern()的使用](#4intern的使用)
  - [5、G1的string去重操作](#5g1的string去重操作)

# 前言
大家好，我是苍何。最近思考了一个问题，为什么会出现公司面试造火箭，工作扭螺丝的现象，包括各种八股文的连环大绝杀问到你不会为主，其实这是考察你的知识面以及掌握的深度，而为什么需要这样呢？归其原因，无非是通过筛选找到那些会思考的人，他们需要的并不是CRUD的工具人，而是会思考能创新的工程师。

当你深刻理解到这点，我想不用刻意去学习，在工作中，肯定会吾日三省吾身。

于是乎，这个重新开始学习编程系列文章出来了。

愿与君共勉！

这是JVM系列文章的第二篇，主要是JVM执行引擎、对象实例化、String相关知识。
# 一、JVM执行引擎
执行引擎就是执行内存中的指令，将字节码指令解释/编译为对应平台上的本地机器指令，充当了将高级语言翻译为机器语言的使者。
## 1、执行引擎的工作过程
![在这里插入图片描述](https://img-blog.csdnimg.cn/3fa6c56b0f5f445994ae7e1c4991a416.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 2、java代码编译和执行的过程
![在这里插入图片描述](https://img-blog.csdnimg.cn/f672d8944ed443658cddd997719ba9c7.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2f18b9bf9966429283cd32dd73cfbcd7.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/510d4c0c5f71456483185ff87edf0d25.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 3、什么是解释器，什么是编译器
![在这里插入图片描述](https://img-blog.csdnimg.cn/042517c90db548d1b5eb6aa06d78685d.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 4、为什么说java是半编译半解释型语言
![在这里插入图片描述](https://img-blog.csdnimg.cn/b907c5c0d7ab44b9b1c3b4db5a3f47f6.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2be54f2bb1984830b1fbea53e8584128.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 5、机器码、指令、汇编语言、高级语言
![在这里插入图片描述](https://img-blog.csdnimg.cn/6cb98092e6c5461ea4ea260068207fec.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a2fe4282c1ce4ec59aace191997b5065.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/15c656b6b1b84330bdbc1bccead4a3a4.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/8b67dc5677c640589e0fc89272b1047f.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/efdacbc1cb43454cad43719999d4d5be.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/3577c6dee91c4b709e8b567c0f15c6ea.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/8a1c48e22db44ba9b7432f0812c655a1.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/f0f5672ac7d248cbb6e6779b0517b8ba.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 6、HotSpot JVM执行方式
![在这里插入图片描述](https://img-blog.csdnimg.cn/2b450de87155473bb0c322fd94afb74f.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/40a81030493542939e7e7b3328967cbb.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 7、JIT编译器
![在这里插入图片描述](https://img-blog.csdnimg.cn/c16827fd97da4c96b8004ece309ee8d8.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/88504f37015a43218d92efbbff5f29c3.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 8、方法调用计数器
![在这里插入图片描述](https://img-blog.csdnimg.cn/cf732d1f78654c93a4d53df7bd56aea8.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/ce39ba5655074e3a8825b295ac68cb3b.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

# 二、对象实例化
## 1、创建对象的方式及创建对象步骤
![在这里插入图片描述](https://img-blog.csdnimg.cn/f1a041cb217f429bbe64cde27f9b3d35.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
指针碰撞：如果内存是规整的，那么虚拟机将采用的是指针碰撞法来为对象分配内存，用过的内存在一边，没用过的内存在另一边，中间有个指针，分配内存只需要移动指针即可。

## 2、对象内存布局
![在这里插入图片描述](https://img-blog.csdnimg.cn/7aeb1c83b8d64950bdde83394a92acc7.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
对象头里主要包含运行时元数据和类型指针，运行时元数据含GC分代年龄，锁状态标识、哈希值等

![在这里插入图片描述](https://img-blog.csdnimg.cn/5192e805aa434fcaad99affba8af57fc.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 3、对象的访问定位
![在这里插入图片描述](https://img-blog.csdnimg.cn/6019fb2dfe5b4647a8cfa5b27ae0e88b.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**句柄访问：**
堆中维护一个句柄池，对象的移动、只需改变句柄的指针值即可，不需要改变栈中的对象引用，效率要低一些

![在这里插入图片描述](https://img-blog.csdnimg.cn/3abd91e91f3e45b794083916b0ec1267.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
**直接指针：*

![在这里插入图片描述](https://img-blog.csdnimg.cn/64a276f0e65f42ea9d3526e01efdabb3.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
# 三、String相关知识
## 1、String的基本特性
![在这里插入图片描述](https://img-blog.csdnimg.cn/5a5d2f4d684b4a878740e0862d41c851.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/71236b434be345d8813a9b69f9110e65.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 2、string的内存分配
JDK7及以后的版本字符创常量池在堆中，JDK7之前字符创常量池在永久代中。
![在这里插入图片描述](https://img-blog.csdnimg.cn/e8cd5116cb2a4d47869261285db01d38.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/145428b714274d7bad3bb0b80b8de17d.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/61d5b54edfc541c78cb77056aa85a7ed.png)
## 3、字符串的拼接操作
整体而言，常量与常量相加，拼接结果放在常量池，只要其中有一个是变量，结果就在堆中

![在这里插入图片描述](https://img-blog.csdnimg.cn/8f8d5bb388754454ae4fe3ade38b3797.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 4、intern()的使用
![在这里插入图片描述](https://img-blog.csdnimg.cn/af72ea1cee15486c86ca08079575dd3f.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/34accc1a04d84e8382079084df855305.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/7292ae26eb3449d7a8542e9cd9f69778.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/fe32707fa1284c8c946877eacbc5d5af.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/074199a25fb243ddb7705a1c63a00e32.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/cef2e8aac4944343b09af048a5508b12.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/91ece024497042baaf0b9eb9eda2c69d.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

对于程序中大量存在的字符串，尤其存在很多重复的字符串，使用intern()可以大大提高性能

![在这里插入图片描述](https://img-blog.csdnimg.cn/b30f81e886974f19ad2bb495c1626b87.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 5、G1的string去重操作
![在这里插入图片描述](https://img-blog.csdnimg.cn/abe69eff733a455ea6ad30dc00b11461.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/e1944ad1f9f24be48e6fabda5815fb76.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

