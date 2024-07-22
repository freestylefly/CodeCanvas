## 前言
大家好，我是苍何。最近思考了一个问题，为什么会出现公司面试造火箭，工作扭螺丝的现象，包括各种八股文的连环大绝杀问到你不会为主，其实这是考察你的知识面以及掌握的深度，而为什么需要这样呢？归其原因，无非是通过筛选找到那些会思考的人，他们需要的并不是CRUD的工具人，而是会思考能创新的工程师。

当你深刻理解到这点，我想不用刻意去学习，在工作中，肯定会吾日三省吾身。

于是乎，这个重新开始学习编程系列文章出来了。

愿与君共勉！

最近读了HashMap和ConcurrentHashmap的源码，以及花了两天时间看了这方面相关的视频，记录一下新get到的知识。以问答的方式记录。

## 一、HashMap的特性
1、存储的是键值对，允许为null，key不可重复，重复则覆盖
2、非同步，线程不安全
3、底层hash表，不保证有序

## 二、HashMap的底层原理是什么？

1、JDK7扩容时候多线程情况下可能会出现死循坏，根本原因是头插法导致
2、hash种子默认0，可以配置变量来使得hash值更散列一些。
3、modCount++每一次修改都会加一
容错快速失败机制（fail fast，并发时候出现问题
4、1.8hashmap是尾插法，链表长度大于8会转为红黑树，即第九个来的时候，数组是空的或者数组长度小于64不会树化
5、hashmap1.7扩容条件多了一个判断当前数组节点不为空，均要判断是否大于阈值
6、红黑树节点个数小于6个会转为链表

## 三、hashmap 的底层数据结构

JDK7：数组+链表
JSK8：数组+链表+红黑树

## 四、JDK8中hashmap为什么要用红黑树

当元素个数在小于某一个阈值时，链表的插入查询效率高于红黑树，大于该阈值时，红黑树插入和查询效率高于链表，在hashmap中此阈值为8，即链表的长度大于8时，转为红黑树效率更高

## 五、JDK8中hashmap什么时候将链表转为红黑树

链表元素个数大于8，且数组的长度大于等于64时，才会将链表转为红黑树，数组长度小于64，会进行扩容

## 六、JDK8中hashmap中put方法的实现过程

![在这里插入图片描述](https://img-blog.csdnimg.cn/a2d38045394d47aab2b4e59dafc9be69.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70#pic_center)


## 七、JDK8中hashmap中get方法实现过程？

![在这里插入图片描述](https://img-blog.csdnimg.cn/191128a18efd422ba108c6f5f1128fde.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70#pic_center)


## 八、JDK7和JDK8中hashmap不同？

1、8中用到了红黑树
2、7中链表插入用头插法（扩容元素的时候使用的也是头插法，头插法速度更快，无需遍历链表，但是在多线程扩容的情况下会出现循坏链表的问题，导致CPU飙升），8中用尾插法（反正要遍历计算链表当前的结点个数）
3、7中hash算法更复杂，生成的hashcode更散列，hashmap中的元素更散列，查询性能更好，8中有红黑树简化hash算法，防止消耗CPU
4、扩容7可能rehash，和hash种子有关，8中无
5、7的扩容条件除了判断size是否大于阈值外，还判断tab【i】不为空，才扩容，8中仅仅判断size是否大于阈值

6、扩容转移元素逻辑不一致，7是一次转移，8是先算出高低位，再一次性转移

## 九、JDK7中ConcurrentHashmap是怎么保证并发安全的？

主要是利用Unsafe操作+ReentrantLock+分段思想

Unsafe：通过CAS修改对象属性，并发安全的给数组的某个位置赋值以及获取元素；
分段思想是为了提高并发量，分段数可以通过参数控制

## 十、JDK7中ConcurrentHashmap的底层原理

由两层嵌套数组实现的
1、ConcurrentHashmap对象中有一个属性segments，类型为segment[],
2、segment对象有一个属性table，类型为hashEntry[]
put方法十，先根据key计算segment[],数组下标，确定好当前key，value应该插入到哪个segment对象中，如果segment[],为空，利用自旋锁在该位置生成segment对象，然后再调用segment对象的put方法先加锁，根据key计算hashEntry[]数组下标，加锁先通过自加锁(trylock)，如果超过一定次数就会加阻塞锁(lock())

## 十一、JDK8中ConcurrentHashmap是怎么保证线程安全的？

主要是unsafe操作+synchronized
对table[i]进行加锁

## 十二、JDK7和JDK8中ConcurrentHashmap不同点

1、8中没有分段锁了，而是通过synchronized来控制
2、8中扩容性能更高














