# 目录
- [目录](#目录)
  - [一、前言](#一前言)
  - [二、线程和进程的区别](#二线程和进程的区别)
  - [三、重量级锁和轻量级锁](#三重量级锁和轻量级锁)
  - [四、如何开启线程](#四如何开启线程)
  - [五、如何保证线程安全](#五如何保证线程安全)
  - [六、volatile](#六volatile)
  - [七、CAS](#七cas)
  - [八、java锁机制是怎样的](#八java锁机制是怎样的)
  - [九、偏向锁、轻量级锁、重量级锁什么区别](#九偏向锁轻量级锁重量级锁什么区别)
  - [十、锁升级机制](#十锁升级机制)
  - [十一、AQS](#十一aqs)
  - [十二、可重入锁](#十二可重入锁)
  - [十三、三个并发工具](#十三三个并发工具)
  - [十四、fork/join框架](#十四forkjoin框架)
  - [十五、synchronized](#十五synchronized)
  - [十六、线程池](#十六线程池)
  - [十七、ThreadLocal](#十七threadlocal)

## 一、前言
大家好，我是苍何。最近思考了一个问题，为什么会出现公司面试造火箭，工作扭螺丝的现象，包括各种八股文的连环大绝杀问到你不会为主，其实这是考察你的知识面以及掌握的深度，而为什么需要这样呢？归其原因，无非是通过筛选找到那些会思考的人，他们需要的并不是CRUD的工具人，而是会思考能创新的工程师。

当你深刻理解到这点，我想不用刻意去学习，在工作中，肯定会吾日三省吾身。

于是乎，这个重新开始学习编程系列文章出来了。

愿与君共勉！

## 二、线程和进程的区别
1、进程是操作系统进行资源分配的最小单元
2、线程是执行操作的最小单元
## 三、重量级锁和轻量级锁
重量级就是要通过操作系统来进行锁的操作，轻量级直接在JVM中就可以进行
## 四、如何开启线程
1、继承Thread类，重写run方法
2、实现Runnable接口，实现run方法
3、实现Callable方法，通过FutureTask创建一个线程，获得线程执行的返回值
4、线程池创建线程
## 五、如何保证线程安全
1、JVM提供的关键字Synchronized
2、JDK提供的各种锁
## 六、volatile
1、线程变量可见性（一个线程写，多个线程读）
2、防止指令重排（DCL单利需要加volatile）
3、不能保证线程安全，不能保证原子性
## 七、CAS
一、什么是CAS
比较并交换（Swap）-compareAndSet
二、unsafe类
UnSafe类是CAS的核心类，由于Java无法直接访问底层系统，所以要通过本地的native方法进行访问，UnSafe类就相当于一个后门，基于该类可以直接操作特定内存中的数据，其内部就像C的指针一样操作内存。观察UnSafe类的源码，可以看到UnSafe类都是native方法，也就是说Unsafe类都是直接调用操作系统底层资源执行任务。

三、CAS底层原理
1、CAS是一种CPU的原子指令，不会造成所谓的数据不一致情况
2、在Java中 CAS 底层使用的就是自旋锁 + UnSafe类。
四、CAS实现原⼦操作的三⼤问题？解决⽅案
1、ABA问题
个变量是A，变成了B,又变成了A，那么使用CAS进行检查时是发现没有变化，但是的确是变化了
解决方案：加一个版本号去做标识，AtomicStampedReference类compareAndSet方法（作用是首先检查当前引用是否等于预期引用,并且检查当前标志是否等于预期标志，如果全部相等，则以原子方式将该引用和该标志的值设定为给定的更新值）
2、循环时间长开销大
使用pause指令
延迟流水线执行指令de-pipline,使CPU不会消耗过多的执行资源，延迟的时间取决与具体实现的版本，在一些CPU上延迟时间是0
避免在退出循环的时候因内存顺序冲突引起CPU流水线清空，从而提高CPU执行效率。
3、只能保证一个共享变量的原子操作
当对一个共享变量执行操作时，我们可以使用循环cas（自旋锁）的方式保证原子性，但是对多个共享变量操作时，循环CAS就无法保证操作原子性，这时后可以取用锁，，也可以取巧把多个共享变量合并成一个共享变量操作。
从java1.5时,JDK提供了AtomicReference类保证引用对象之间的原子性。

四、Atomic类如何保证原⼦性（CAS操作）
通过Unsafe类，实现的原子性。而Unsafe类是由native方法实现的，unsafe.getAndAddInt(this, valueOffset, 1)，直接调用操作内存

## 八、java锁机制是怎样的
java锁就是在对象的markword中记录一个锁状态
## 九、偏向锁、轻量级锁、重量级锁什么区别
1、对应不同的锁状态
2、偏向锁就是类似一个门，请大家有序访问，并说获得该锁的线程是
3、轻量级锁也叫自旋锁，就是不断循坏看是否能获得锁
4、重量级锁：由操作系统进行统一管理

## 十、锁升级机制
1、new对象默认是不开偏向锁，等过了4s后再打开偏向锁
2、new一个对象先开一个偏向锁，有资源轻度竞争加轻量级锁，竞争比较激烈就用重量级锁

## 十一、AQS
1、是一个java线程同步的框架，是JDK中很多锁工具的核心实现框架
2、在AQS中维护了一个信号量state，和一个线程组成的双向链表队列，其中这个队列就是用来给线程排队的，而state就像是一个红绿灯，用来控制线程排队或放行，在不同场景下有不同的意义


## 十二、可重入锁
ReetrantLock
可多次锁住和释放锁，
AQS如何实现可重入锁
AQS中的state用来表示加锁的次数，0表示无锁，每加一次锁，state就加1，释放锁就减1



## 十三、三个并发工具
1、CountDownLatch
保证三个线程同时执行，可以让我们模拟高并发的场景
2、CylicBarrier
并发情况下三个线程依次执行
3、Semaphore
三个线程有序交错执行





## 十四、fork/join框架
拆分合并的过程
## 十五、synchronized
一、对象头
1、存储对象自身的运行时数据
哈希码
GC分代年龄
锁状态标识
线程持有的锁
偏向线程id
偏向时间戳
2、类型指针
3、若为对象数组，还有记录数组长度的数据


Java对象头一般占有2个机器码（在32位虚拟机中，1个机器码等于4字节，也就是32bit，在64位虚拟机中，1个机器码是8个字节，也就是64bit），但是 如果对象是数组类型，则需要3个机器码，因为JVM虚拟机可以通过Java对象的元数据信息确定Java对象的大小，但是无法从数组的元数据来确认数组的大小，所以用一块来记录数组长度。

二、synchronized和Lock的区别（
1、synchronized是java关键字，是在JVM层面上，lock是一个接口，是JDK提供的
2、synchronized自动释放，lock需要手动释放
3、synchronized其他线程获取不到锁智能等待，lock提供了trylock方法可以不阻塞等待，尝试获得锁

4、synchronized可重入、不可中断，非公平，lock可重入、可判断、可公平
5、synchronized原始采用悲观锁，lock采用乐观锁的方式

## 十六、线程池
一、ThreadPoolExecutor的七个参数
private static ExecutorService executor = new ThreadPoolExecutor(10, 10,
        60L, TimeUnit.SECONDS,
        new ArrayBlockingQueue(10));


1、corePoolSize：
核心线程数量，
2、maximumPoolSize：
最大线程数
3、keepAliveTime：
存活时间
4、unit：
超时时间的单位
5、BlockingQueue  ：
任务队列
6、ThreadFactory  ：
线程工厂
7、RejectStrategy  ：
拒绝策略


二、ThreadPoolExecutor的⼯作流程

1、在创建了线程池后，开始等待请求
2、当调用execute()方法添加一个请求任务时，线程池会做出如下判断
如果正在运行的线程数量小于corePoolSize，那么马上创建线程运行这个任务
3、如果正在运行的线程数量大于或等于corePoolSize，那么将这个任务放入队列
4、如果这个时候队列满了且正在运行的线程数量还小于maximumPoolSize，那么还是要创建非核心线程立刻运行这个任务
5、如果队列满了且正在运行的线程数量大于或等于maximumPoolSize，那么线程池会启动饱和拒绝策略handler来执行
6、当一个线程完成任务时，它会从队列中取下一个任务来执行
7、当一个线程无事可做超过一定的时间（keepAliveTime）时，线程会判断：
8、如果当前运行的线程数大于corePoolSize，那么这个线程就被停掉。
所以线程池的所有任务完成后，它最终会收缩到corePoolSize的大小。


三、线程池的状态⽣命周期，他们是怎么流转的
线程池的状态一共有五种，分别是RUNNING、SHUTDOWN、STOP、TIDYING、TERMINATED；

1、RUNNING
运行态，表示可接受新任务，且可执行队列中的任务
2、SHUTDOWN
关机
表示不接受新任务，但可执行队列中的任务；
3、STOP
停止

表示不接受新任务，且不再执行队列中的任务，且中断正在执行的任务；

4、TIDYING
清理
所有任务已经中止，且工作线程数量为0，最后变迁到这个状态的线程将要执行terminated()钩子方法，只会有一个线程执行这个方法；
5、TERMINATED
中止状态，已经执行完terminated()钩子方法

四、你们项⽬中怎么⽤的线程池
查询客户动态的时候，分发三个线程去分别去获取客户的名片动态、访问项目动态以及客户留点动态


## 十七、ThreadLocal
一、是什么？
ThreadLocal是解决多线程下共享变量并发问题，即同一个变量在不同线程下赋予不同值。

二、ThreadLocal和synchronized区别？
synchronized是时间换空间让多个线程排队访问，ThreadLocal是空间换时间为每个线程提供了一份变量的副本，从而实现线程隔离。

三、ThreadLocal的内部结构
1、每一个thread维护一个threadlocalmap，threadlocalmap是由threadlocal维护的，map里面存的key是threadlocal对象本身，value是变量副本

![在这里插入图片描述](https://img-blog.csdnimg.cn/000651d7a74f4ac793607e0160d9a93e.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_Q1NETiBA6IuN5L2VZmx5,size_68,color_FFFFFF,t_70,g_se,x_16#pic_center)


2、set方法
先获取当前线程，获取线程的threadlocalmap，（获取不到就创建一个map），将当前ThreadLocal为key，value为值set进去
3、get方法
获取线程的的threadlocalmap，获取到ma且根据key（当前threadlocal）获取到值就返回，如果map是空或者获取不到值就返回一个默认的


3、initialValue方法
初始值，可以被继承，设置默认初始值



四、threadlocalmap基本结构
1、是threadlocal静态内部类
2、key是threadlocal对象是弱引用，目的是将threadlocal对象的生命周期和线程的生命周期解绑


五、弱引用和内存泄漏

1、内存泄漏和内存溢出
内存溢出：
程序申请内存，没有足够的空间供其使用，out of memory
内存泄漏：
无用对象无法被GC回收，始终占用内存，造成空间浪费，最终会导致内存溢出，
2、弱引用
垃圾回收期会回收
3、threadlocalmap使用了弱引用也会出现弱引用
![在这里插入图片描述](https://img-blog.csdnimg.cn/8a084b1089834f8bab6651d37c823643.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_Q1NETiBA6IuN5L2VZmx5,size_68,color_FFFFFF,t_70,g_se,x_16#pic_center)



4、threadlocal出现内存泄漏的真实原因

A、没有手动删除Entry对象，使用完threadlocal调用其remove方法就可以删除对应的Entry，避免内存泄漏
B、threadlocal的使用，thread也随之结束

根本原因：threadlocalmap和thread生命周期是一样的。


六、threadlocalMap使用线性探测法来解决冲突的

如果hash冲突，数组下标加1，如果还是冲突依次计算直到超过数组下标，这个时候又重头开始，相当于一个环形数组


