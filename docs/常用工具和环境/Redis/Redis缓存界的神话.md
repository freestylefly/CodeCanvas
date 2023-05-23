# 目录
- [目录](#目录)
- [前言](#前言)
- [一、redis的底层数据结构](#一redis的底层数据结构)
  - [1、string类型](#1string类型)
    - [1.1、概述](#11概述)
    - [1.2、应用场景](#12应用场景)
    - [1.3、数据结构](#13数据结构)
  - [2、list链表](#2list链表)
    - [2.1、概述](#21概述)
    - [2.2、应用场景](#22应用场景)
    - [2.3、数据结构](#23数据结构)
  - [3、Set集合](#3set集合)
    - [3.1、应用场景](#31应用场景)
    - [3.2、数据结构](#32数据结构)
  - [4、Sorted Set有序集合](#4sorted-set有序集合)
    - [4.1、使用场景](#41使用场景)
    - [4.2、数据结构](#42数据结构)
  - [5、hash](#5hash)
    - [5.1、适用场景](#51适用场景)
- [二、 Redis的持久化](#二-redis的持久化)
  - [1、RDB](#1rdb)
  - [2、AOF](#2aof)
- [三、redis主从同步](#三redis主从同步)
  - [1、全量同步](#1全量同步)
  - [2、 增量同步](#2-增量同步)
- [四、热点key发现和处理方案](#四热点key发现和处理方案)
  - [1、发现热key](#1发现热key)
  - [2、热点key处理](#2热点key处理)
- [五、缓存穿透、缓存击穿、缓存雪崩](#五缓存穿透缓存击穿缓存雪崩)
  - [1、缓存穿透](#1缓存穿透)
  - [2、缓存击穿](#2缓存击穿)
  - [3、缓存雪崩](#3缓存雪崩)
- [六、淘汰策略](#六淘汰策略)
- [七、布隆过滤器](#七布隆过滤器)
  - [1、bitmaps](#1bitmaps)
- [八、分布式锁实现原理](#八分布式锁实现原理)
- [九、如何保证redis原子性](#九如何保证redis原子性)
- [引用](#引用)

# 前言
大家好，我是苍何。最近思考了一个问题，为什么会出现公司面试造火箭，工作扭螺丝的现象，包括各种八股文的连环大绝杀问到你不会为主，其实这是考察你的知识面以及掌握的深度，而为什么需要这样呢？归其原因，无非是通过筛选找到那些会思考的人，他们需要的并不是CRUD的工具人，而是会思考能创新的工程师。

当你深刻理解到这点，我想不用刻意去学习，在工作中，肯定会吾日三省吾身。

于是乎，这个重新开始学习编程系列文章出来了。

redis在日常开发中用的非常多，本文将做一个系统的总结。

# 一、redis的底层数据结构
## 1、string类型
### 1.1、概述
一个key 对应一个 value。string 类型是二进制安全的，意思是 Redis 的 string 可以包含任何数据，比如图片或者序列化的对象，一个 redis 中字符串 value 最多可以是 512M。

### 1.2、应用场景
原子计数
session key设置过期时间
SetNx:当key不存在时才set，实现分布式锁，选举master

### 1.3、数据结构
Redis 是用 C 语言写的，但是对于Redis的字符串，却不是 C 语言中的字符串（即以空字符’\0’结尾的字符数组），它是自己构建了一种名为 简单动态字符串（simple dynamic string,SDS）的抽象类型，并将 SDS 作为 Redis的默认字符串表示。
![在这里插入图片描述](https://img-blog.csdnimg.cn/f301059371424a12a353333899413ac0.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/acd37113543145298657f505ddc89413.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
java中的string是通过char数组实现的，并且它是不可变的。因为char数组被final修饰了（如果"+"拼接是通过编译的时候转译为STringBuilder进行拼接的），所以说redis的String和java的string还是千差万别的。

**Redis的动态字符串在占用内存大小为1M以下的时候，是以翻倍的形式增长的。当超过1M的时候是以每次1M进行增长的。 需要注意的是最大扩展的空间为512M.**


## 2、list链表
### 2.1、概述
List是一个双向链表，可以支持反向查找和遍历，更方便操作，不过带来了部分额外的内存开销，Redis内部的很多实现，包括发送缓冲队列等也都是用的这个数据结构。
### 2.2、应用场景
各种列表，比如twitter的关注列表、粉丝列表等，最新消息排行、每篇文章的评论等也可以用Redis的list结构来实现。
消息队列；
利用LRANGE可以很方便的实现list内容分页的功能。

### 2.3、数据结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/807f140660cf40a582db004ffebab7ed.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
　Redis链表特性：

　　①、双端：链表具有前置节点和后置节点的引用，获取这两个节点时间复杂度都为O(1)。

　　②、无环：表头节点的 prev 指针和表尾节点的 next 指针都指向 NULL,对链表的访问都是以 NULL 结束。　　

　　③、带链表长度计数器：通过 len 属性获取链表长度的时间复杂度为 O(1)。

　　④、多态：链表节点使用 void* 指针来保存节点值，可以保存各种不同类型的值。

## 3、Set集合
是一种无序唯一的集合
### 3.1、应用场景
某些需要去重的列表
### 3.2、数据结构
set 的内部实现是一个 value永远为null的HashMap，实际就是通过计算hash的方式来快速排重的，这也是set能提供判断一个成员是否在集合内的原因。

## 4、Sorted Set有序集合
有序集合，相比set，元素放入集合时还要提供该元素的分数，可根据分数自动排序。
### 4.1、使用场景
放一个有序的并且不重复的集合列表
排行榜相关
### 4.2、数据结构
Redis sorted set的内部使用HashMap和跳跃表(SkipList)来保证数据的存储和有序，HashMap里放的是成员到score的映射，而跳跃表里存放的是所有的成员，排序依据是HashMap里存的score,使用跳跃表的结构可以获得比较高的查找效率，并且在实现上比较简单。

![在这里插入图片描述](https://img-blog.csdnimg.cn/648d6b8dc6ba48f3abaf24410d44ab53.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
## 5、hash
Hash存的是字符串和字符串值之间的映射。Hash将对象的各个属性存入Map里，可以只读取/更新对象的某些属性。这样有些属性超长就让它一边呆着不动，另外不同的模块可以只更新自己关心的属性而不会互相并发导致覆盖冲突。
### 5.1、适用场景
存放结构化数据如用户 信息等
可以用来建索引

# 二、 Redis的持久化
## 1、RDB
是一种快照的方式，可以设置定时把内存中的所有数据dump到磁盘上，主要用于数据备份。
**操作流程**
RDB持久化是指在指定的时间间隔内将内存中的数据集快照写入磁盘，实际操作过程是fork一个子进程，先将数据集写入临时文件，写入成功后，再替换之前的文件，用二进制压缩存储。
![在这里插入图片描述](https://img-blog.csdnimg.cn/582234583da946199393b2d339067c54.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
优势：
如果数据集很大，RDB的启动效率会更高
极大的避免服务进程执行IO操作
劣势：
无法最大限度高可用及最大限度的避免数据丢失。

## 2、AOF
AOF持久化以日志的形式记录服务器所处理的每一个写、删除操作，查询操作不会记录，以文本的方式记录，可以打开文件看到详细的操作记录。
流程：
![在这里插入图片描述](https://img-blog.csdnimg.cn/96db0ba1c97a477db5e6209772028210.png)
优势：
该机制可以带来更高的数据安全性，即数据持久性
由于该机制对日志文件的写入操作采用的是append模式，因此在写入过程中即使出现宕机现象，也不会破坏日志文件中已经存在的内容

# 三、redis主从同步
Redis的主从结构可以采用一主多从或者级联结构，Redis主从复制可以根据是否是全量分为全量同步和增量同步。

## 1、全量同步
Redis全量复制一般发生在Slave初始化阶段，这时Slave需要将Master上的所有数据都复制一份。具体步骤如下： 

　　1）从服务器连接主服务器，发送SYNC命令； 

　　2）主服务器接收到SYNC命名后，开始执行BGSAVE命令生成RDB文件并使用缓冲区记录此后执行的所有写命令； 

　　3）主服务器BGSAVE执行完后，向所有从服务器发送快照文件，并在发送期间继续记录被执行的写命令； 

　　4）从服务器收到快照文件后丢弃所有旧数据，载入收到的快照； 

　　5）主服务器快照发送完毕后开始向从服务器发送缓冲区中的写命令； 

　　6）从服务器完成对快照的载入，开始接收命令请求，并执行来自主服务器缓冲区的写命令； 
![在这里插入图片描述](https://img-blog.csdnimg.cn/4d4f21fdce7b4c74a9806a684e968fbd.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/6f2cf602d3414771b5eeeb056b4a1fb1.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)

## 2、 增量同步
Redis增量复制是指Slave初始化后开始正常工作时主服务器发生的写操作同步到从服务器的过程。 

增量复制的过程主要是主服务器每执行一个写命令就会向从服务器发送相同的写命令，从服务器接收并执行收到的写命令。

通过offset进行增量同步

主从同步失败了怎么办？
CONFIG SET client-output-buffer-limit "slave 2147483648 1073741824 300"，设置一下值

# 四、热点key发现和处理方案
## 1、发现热key
方法一:凭借业务经验，进行预估哪些是热key
方法二:在客户端进行收集
方法三:在Proxy层做收集
方法四:用redis自带命令
hotkeys参数，redis 4.0.3提供了redis-cli的热点key发现功能，执行redis-cli时加上–hotkeys选项即可。但是该参数在执行的时候，如果key比较多，执行起来比较慢。
方法五:自己抓包评估
## 2、热点key处理
(1)利用二级缓存
比如利用ehcache，或者一个HashMap都可以。在你发现热key以后，把热key加载到系统的JVM中。针对这种热key请求，会直接从jvm中取，而不会走到redis层。
(2)备份热key
redis集群


热点发现，本地缓存。

# 五、缓存穿透、缓存击穿、缓存雪崩
## 1、缓存穿透
指的是查询一个不存在的key，穿透了缓存，直接查数据库，造成数据库压力过大。
**解决方案：**
1）布隆过滤器
将所有可能存在的数据哈希到一个足够大的bitmap中，一个一定不存在的数据会被 这个bitmap拦截掉，从而避免了对底层存储系统的查询压力
2）将查不到的
如果一个查询返回的数据为空（不管是数 据不存在，还是系统故障），我们仍然把这个空结果进行缓存，但它的过期时间会很短，最长不超过五分钟。

## 2、缓存击穿
对于一些设置了过期时间的key，如果这些key可能会在某些时间点被超高并发地访问，是一种非常“热点”的数据。这个时候，需要考虑一个问题：缓存被“击穿”的问题，这个和缓存雪崩的区别在于这里针对某一key缓存，前者则是很多key。

**解决方案：**
1）热点数据永不过期
2）限流hystrix
3）使用互斥锁(mutex key)
```java
//2.6.1前单机版本锁
String get(String key) {  
   String value = redis.get(key);  
   if (value  == null) {  
    if (redis.setnx(key_mutex, "1")) {  
        // 3 min timeout to avoid mutex holder crash  
        redis.expire(key_mutex, 3 * 60)  
        value = db.get(key);  
        redis.set(key, value);  
        redis.delete(key_mutex);  
    } else {  
        //其他线程休息50毫秒后重试  
        Thread.sleep(50);  
        get(key);  
    }  
  }  
}
```
## 3、缓存雪崩
缓存雪崩是指在我们设置缓存时采用了相同的过期时间，导致缓存在某一时刻同时失效，请求全部转发到DB，DB瞬时压力过重雪崩。
**解决方案**
1）加锁或者队列
2）设置过期时间为随机

# 六、淘汰策略
1）voltile-lru：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰
2）volatile-ttl：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰
3）volatile-random：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰
4）allkeys-lru：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰
5）allkeys-random：从数据集（server.db[i].dict）中任意选择数据淘汰
6）no-enviction（驱逐）：禁止驱逐数据

# 七、布隆过滤器
布隆过滤器可以判断某个数据一定不存在，但是无法判断一定存在。
## 1、bitmaps
我们知道计算机是以二进制位作为底层存储的基础单位，一个字节等于8位。

　　比如“big”字符串是由三个字符组成的，这三个字符对应的ASCII码分为是98、105、103，对应的二进制存储如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/5af6718e2f2b44208e6aaf9f828a5dcd.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
在Redis中，Bitmaps 提供了一套命令用来操作类似上面字符串中的每一个位。
```
setbit key offset value
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/60e983a283a64c508b7bb5de0b6ec5c8.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
我们知道"b"的二进制表示为0110 0010，我们将第7位（从0开始）设置为1，那0110 0011 表示的就是字符“c”，所以最后的字符 “big”变成了“cig”。

Redisson 来构造布隆过滤器
guava 工具包构造布隆过滤器

# 八、分布式锁实现原理
可以通过Redisson实现Redis分布式锁
原理如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/e9cdacc01f7e453a9c42da72f840ea63.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6IuN5L2VZmx5,size_20,color_FFFFFF,t_70,g_se,x_16)
某个客户端要加锁。如果该客户端面对的是一个redis cluster集群，他首先会根据hash节点选择一台机器。发送一段lua脚本到redis上，如何加锁呢
```
hset myLock
8743c9c0-0795-4907-87fd-6c719a6b4586:1 1
```
key 是对应的要加锁的key，值是客户端id，后面数字代表重入锁可数。

# 九、如何保证redis原子性
Lua脚本
多个操作写到一个 Lua 脚本中（Redis 会把整个 Lua 脚本作为一个整体执行，在执行的过程中不会被其他命令打断，从而保证了 Lua 脚本中操作的原子性）

# 引用
1、[redis底层数据结构](https://www.huaweicloud.com/articles/4baa25aabddd53213bf011d849020b62.html)

2、[细品Redis高性能数据结构之SDS](https://cloud.tencent.com/developer/article/1686035)

3、[redis缓存失败情况方案](https://blog.csdn.net/zeb_perfect/article/details/54135506)



