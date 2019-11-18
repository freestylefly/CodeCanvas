# 前言
最近又重新复习了一遍java基础知识，做了一下整理。这些知识点大部分为面试必问，建议收藏。
在理解的基础上进行记忆会更深刻，推荐用自己语言组织归纳，这样面试官认为你至少还是知道这个知识点的。
直接上干货！

# 一、java的跨平台原理

1、什么是平台

**把CPU处理器与操作系统的整体叫平台**

2、java跨平台原理

java虚拟机JVM将java文件编译成字节码文件，也就是.class文件，然后运行到不同的平台，对应的系统会将字节码文件转换成对应平台的对应机器码，产生可执行性文件

# 二、冒泡排序

1、概念

N个数字来比较，两两比较小靠前，外层循环N-1，内层循环N-1-i；

2、手写代码

```java
public class MrpSort{
	public static void main(String[] args){
		int[] arr = {1,4,9,10,45,12,2};
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					//交换
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		//遍历数组
		for(int a:arr){
			System.out.println(a);
		}
	}
}
```

# 三、比较排序

1、概念

外层循环, 决定比较的轮次, 决定每轮需要确定的元素的下标，内层循环, 决定每轮比较时, 用于和i进行比较的下标的起止（打擂台的方式）

2、手写代码

```java
package com.array.sort;

/**
 * 比较排序
 * @author Administrator
 *
 */
public class Comparison {

	public static void main(String[] args) {
		
		//声明数组中
		int[] arr = new int[20];
		//遍历数组, 随机生成元素内容
		for (int i = 0; i < arr.length; i++) {
			//生成1~100的随机数
			arr[i] = (int) (Math.random()*100 + 1);
		}
		//输出初始内容
		System.out.println("原数组内容如下:");
		for (int i = 0; i < arr.length; i++) {
			
			//输出元素内容
			System.out.print(arr[i] + "\t");
			
			//判断是否换行
			if(i%5 == 4) { //(i+1)%5==0
				System.out.println();
			}
		}
		System.out.println("===========================================");
		
		/* 升序排列 */
		//外层循环, 决定比较的轮次, 决定每轮需要确定的元素的下标
		for (int i = 0; i < arr.length-1; i++) {
			//内层循环, 决定每轮比较时, 用于和i进行比较的下标的起止
			for (int j = i+1; j < arr.length; j++) {
				//比较, 将较小的元素交换到下标i中
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		//输出结果
		System.out.println("排序后的数组内容如下:");
		for (int i = 0; i < arr.length; i++) {
			
			//输出元素内容
			System.out.print(arr[i] + "\t");
			
			//判断是否换行
			if(i%5 == 4) { //(i+1)%5==0
				System.out.println();
			}
		}
		System.out.println("===========================================");
	}
}

```

# 四、插入排序

1、概念

将数组划分成两个部分, 已经排序的部分, 和没有排序的部分，依次从未排序的数组中取出元素, 按照插入算法, 插入已经排序的数组部分，外层循环, 确定每次需要插入的元素的下标，内存循环, 遍历已经排序的数组的所有元素, 与需要插入的元素比较, 确定插入的具体效果

2、手写代码

```java
package com.array.sort;

/**
 * 插入排序
 * 基于插入算法的排序
 * @author Administrator
 *
 */
public class Insertion {

	public static void main(String[] args) {
		
		//声明数组中
		int[] arr = new int[20];
		//遍历数组, 随机生成元素内容
		for (int i = 0; i < arr.length; i++) {
			//生成1~100的随机数
			arr[i] = (int) (Math.random()*100 + 1);
		}
		//输出初始内容
		System.out.println("原数组内容如下:");
		for (int i = 0; i < arr.length; i++) {
			
			//输出元素内容
			System.out.print(arr[i] + "\t");
			
			//判断是否换行
			if(i%5 == 4) { //(i+1)%5==0
				System.out.println();
			}
		}
		System.out.println("===========================================");
		
		/* 插入排序, 升序 */
		/*
		 * 将数组划分成两个部分, 已经排序的部分, 和没有排序的部分
		 * 依次从未排序的数组中取出元素, 按照插入算法, 插入已经排序的数组部分 
		 */
		//外层循环, 确定每次需要插入的元素的下标
		for (int i = 1; i < arr.length; i++) {
			//内存循环, 遍历已经排序的数组的所有元素, 与需要插入的元素比较, 确定插入的具体效果
			for (int j = 0; j < i; j++) {
				
				//判断, i下标的元素比j下标的元素小时, 交换
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		//输出结果
		System.out.println("排序后的数组内容如下:");
		for (int i = 0; i < arr.length; i++) {
			
			//输出元素内容
			System.out.print(arr[i] + "\t");
			
			//判断是否换行
			if(i%5 == 4) { //(i+1)%5==0
				System.out.println();
			}
		}
		System.out.println("===========================================");
	}
}

```



# 五、for、while、do-while区别

分四个方面：总的说、结构、特点、适用条件

1、总的来说，都是用来循坏的控制语句

2、do-while在while的括号后面加分号，而while循环的括号后不加分号

3、for和while是先进行循环条件判断，再进入循环体，而do-while是先进入循环体，再执行循环条件，所以do-while至少出现一次。

4、适用条件：for适用于循环次数确定的情况

# 六、continue、break、return的异同

相同点

1、三个关键字都是用来终止循环的关键字，用了关键字会跳出相应的循环

不同点

2、continue是跳出当前循环进入下一个循环，break是退出循环，return是跳出方法，有返回值的话会返回要返回的值

# 七、==与equals方法的异同

相同：

都是用来进行比较操作

不同：

1、==是算术运算符，而equals是Object类的一个方法

2、基本数据类型的比较：只能用==运算符

3、非String类的引用数据类型，如果没有重写是Object类的equals方法，那么两者比较的都是对象的地址

4、String和重写了equals方法的引用数据类型，==比较的还是地址，equals比较的就是值是否相等了。

# 八、谈一谈封装

1、封装的作用

封装是面向对象三大特性之一，用封装有利于保护数据的安全性

2、封装的实现步骤

- 私有化属性private

  关于封装时的属性命名:首字母和第二个字母都不能大写

- get/set方法为属性提供一个公开访问的方法

- 需要对相关属性进行条件设置时，需要在set方法中进行设置

3、javabean

将字段封装成对象

# 九、谈一谈继承

1、继承的作用

继承就是子类继承父类的特征和行为，是用extends关键字，使用继承可以减少代码冗余，提高类和类之间的耦合性

2、子类能从父类继承到啥

广义的说，子类能继承到父类的除构造方法之外的所有，但是只有父类的非私有子类才可以应用

3、java支持的是单根继承，但是可以多重继承

# 十、谈一谈多态

1、多态的作用

多态是同一个行为具有多个不同表现形式或形态的能力，消除类型之间的耦合性，增强代码的可替换性和可扩展性

2、实现多态的前提

- 继承和实现
- 方法重写（向上、向下转型）

3、使用方式

- 父类作为方法的形参传递
- 父类作为方法返回值

# 十一、方法重载与方法重写的异同

相同点：

1、方法名相同

2、两者均提高了适用范围和灵活性

不同点

1、出现的位置

重载出现在本类中，重写出现在子类

2、参照的目标方法

重载参照的是同类的方法名相同的方法，重写参照的是父类的方法

3、访问修饰符

重载和访问修饰符无关、重写不能严于父类（比如父类用的是protected，那么重写的方法的访问修饰符只能是protected活着public）

4、返回值类型

重载无关、重写必须相同

5、参数列表类型或者数量

重载不同，重写可完全一致或者是其子类类型

6、异常声明

重写不能抛出比父类更多的异常，只能抛出和父类类型一样或是该异常的子类异常

# 十二、抽象类与接口的异同

相同点：

1、都不能被实例化，属于抽象层面

2、都可以含有抽象方法

不同点：

1、关键字不同

抽象类：abstract，接口：interface

2、属性要求不同

接口：public final static，初始值必须赋值，常量必须大写

3、方法

抽象类可以有非抽象方法，接口方法只能是public abstract

4、构造方法

抽象类有构造方法，接口无

5、使用

抽象类单根继承，接口多继承多实现

# 十三、final、finally、finalize的区别

1、final

可修饰类、方法、属性、局部变量

修饰类不能被继承，方法不能被重写，属性时一个常量在申明的时候必须赋值（因为全局变量会有默认值），局部变量可先申明再赋值）

2、finally

是异常处理时候的一个关键字，在try、catch和finally一起使用时，不管怎样最后都会执行，除非调用System.exit(0)才不会执行

3、finalize

垃圾回收的时候使用

# 十四、在java中如何最有效率的将数值8变成2

使用位运算完成

左移<<  右移>>  按位与&  按位或|  按位亦或^  按位非~

将数据转换成2进制后再处理. 32位2进制数

4&5=4

4|5=5 

100

101

100

```
先将8转换为二进制：1000，再将1000右移两位变成10就是2，即8>>2
```

# 十五、this与super的异同

相同：

都是用来调用属性和方法

不同：

1、调用 的类不同，this调用的是当前类，supper调用的是父类

2、this可以代表当前对象，supper无法代表父类

# 十六、谈一谈java的异常处理机制

1、什么是程序错误

error：程序错误，如内存溢出

逻辑错误：和最后想要的的结果不同

Exception：程序异常

2、try、catch、finally

try是核心，代表对可能出现异常的代码块进行异常捕捉，catch代表抓取异常，finally不管怎样都会执行（除了一个）

3、有返回值return时

返回值是基本数据类型时：

最后返回的不会是finally的值

返回值是对象时：

最后返回的是finally的值

```java
package com.param;

public class Test {

	public static void main(String[] args) {
		
		/*int n1 = 5,
			n2 = 10;
		cal(n1, n2);
		System.out.println(n1+","+n2);
		
		User user = new User("ÕÅÈý", 10);
		cal(user);
		System.out.println(user.getAge());*/
		
		/*int n = 10;
		System.out.println("n:" + n);
		System.out.println("result:" + cal(n));;*/
		
		User user = new User("º«Ã·Ã·", 20);
		System.out.println("result:" + cal(user));
	}
	
	private static User cal(User u) {
		
		try {
			
			u.setAge(100);
			System.out.println("try:" + u);
			return u;
		} catch (Exception e) {
			u.setAge(200);
			System.out.println("catch:" + u);
			return u;	
		} finally {
			u.setAge(1000);
			System.out.println("finally:" + u);
		}
	}
	
	private static int cal(int a) {
		
		try {
			a *= 10;
			System.out.println("try:" + a);
			int b = 1 / 0;
			return a;
		} catch (Exception e) {
			a += 100;
			System.out.println("catch:" + a);
			return a;
		} finally {
			a *= 1000;
			System.out.println("finally:" + a);
		}
	}
	
	private static void cal(int a, int b) {
		
//		System.out.println(a+b);
		a = 20;
		b = 50;
	}
	
	/*private static void cal(User u) {
		
//		u.setAge(50);
		
		u = new User("ÀîËÄ", 60);
		
	}*/
	
}

```

4、throws和throw

throws：抛出异常，避免冗余和重复工作

throws：申明异常，梳理结构

# 十七、谈一谈java的常见特性

1、面向对象

2、异常处理

3、垃圾回收

4、多线程

# 十八、ArrayList与LinkedList的异同

同：

都是属于List接口的具体实现类，都实现了List中常用方法，并且都是有序不唯一的集合

不同：

1、各自的特点和使用场景

ArrayList遍历效率高，对于只需要进行查询操作的集合，用ArrayList集合储存数据更好，因为ArrayList是连续的内存空间结构，所以查的快，但是插入删除效率低；

LinkedList插入和删除效率高，查询效率低，因为LinkedList是链式储存，每一个元素都含有三个元素，手拉手示的，插入块

# 十九、ArrayList与Vector的区别

1、线程安全

Vector是同步的线程安全的，ArrayList线程不安全

2、执行效率

线程不安全的执行效率高

3、元素超过初始大小时

 当Vector或ArrayList中的元素超过它的初始大小时,Vector会将它的容量翻倍,而ArrayList只增加50%的大小，这样,ArrayList就有利于节约内存空间。

# 二十、HashMap与HashTable的区别

1、线程安全

HashMap线程不安全，HashTable线程安全

2、执行效率

线程不安全的执行效率高

# 二十一、String、StringBuffer、StringBiulder的异同

同：

都是用来存储字符串

不同：

1、从字符串是否可变

String是不可变字符串，后两者均是可变 的

2、从线程安全角度

StringBiulder是安全的，其他都不安全

3、执行效率

StringBiulder比StringBuffer执行效率低

# 二十二、谈一谈反射

1、是什么

反射是一种半动态的代码加载和运行机制，在jvm第一次加载字节码(.class)文件时, 如发现了未知的未经编译的信息, 则会将未知信息和字节码文件返还给编译器,由编译器对未知信息进行二次编译,然后再交由jvm翻译运行

2、比正常的编译在JVM和编译器间多了一个来回

3、获取class类对象的方式：

​	类名.class

​	对象名.getClass

​	class.forName()字符串

# 二十三、谈一谈序列化

1、作用

解决互联网传输时，20%平均损失率问题，保证数据完整性

2、如何实现序列化

在实体类中实现serializable

，使用ObjectOutputStream

# 二十四、线程的生命周期

1、新生：new

2、可运行（就绪）：start线程具有了抢夺资源的能力

3、运行：不稳定的状态

4、阻塞：线城失去了抢夺资源的能力，sleep

5、死亡：

自然死亡：线程的run方法执行完

非自然死亡：容易死锁

# 二十五、线程的调度

1、优先级：setPriority

2、sleep（毫秒）：

阻塞的是：调用该方法的线程

能否恢复可运行：能

3、join（）

阻塞的是：别的线程,让本线程先执行

能否恢复可运行：能

4、yield(),礼让

阻塞的是：调用该方法的线程（时间极短，继续枪占资源）

能否恢复可运行：能

5、wait（)

阻塞的是：自己

能否恢复可运行：不能，必须调用notify，两者通常在两个线程之间调用

# 二十六、程序并发的数据安全(线程锁/线程安全)

1、多个用户访问同一数据时，会导致数据出现问题

2、线程同步方式

- Synchronized同步方法
- Synchronized同步代码块
- volatie关键字，申明域变量
- 创建重入锁对象重入锁对象的操作方法: lock(), unlock()
- 使用ThreadLocal声明局部变量

# 二十七、线程死锁

- 线程在执行过程中非正常死亡, 有几率导致死锁
-  2个线程在使用自己的资源的同时, 又去调用对方正在使用的资源

# 二十八、TCP

是一种面向连接的、可靠的、基于字节流的[传输层](https://baike.baidu.com/item/%E4%BC%A0%E8%BE%93%E5%B1%82/4329536)通信协议，必须要求双方建立连接后才开始通信。

点对点传输，安全

服务器端使用ServerSocket，使用其中的accept()方法监听客户端的请求，并使用Socket的getInputStream()和getOutputStream()方法，获取服务器端的输出流和输入流。

服务器端使用Socket，并使用Socket的getInputStream()和getOutputStream()方法，获取客户端的输出流和输入流。

最后将相应的流和socket关闭即可

# 二十九、socket

基于TCP协议的数据中转的对象，客户端/服务器

位于java.net包，被称为套接字，是网络通信连接的两个端点，是网络驱动层提供给应用程序的一个接口或者一种机制。

# 三十、XML的常见解析方式

1、DOM解析

基于XML的树结构来完成解析，通过获取各个节点的元素对象，来获取XML内容； 

创建解析器工厂对象，获得解析器对象，通过解析器对象对xml文件解析获得Document对象，Document对象的方法来获取XML内容。

2、jDOM解析

JDOM是Java和DOM的结合体。利用纯java技术对XML文档实现解析

3、SAX

基于事件解析，占用资源小、内存消耗小

4、DOM4j

是一个开源的库，特点是其中使用大量的接口，使用前需要导入dom4j的jar包。获得SAXReader对象，使用read()方法获得Document对象，通过Document对象获得根节点元素，来获取XML的内容。

# 三十一、单例-懒汉

```java
package com.singleton.lazy;

/**
 * 单例: 通过特殊的编码格式,
 * 	保证该类的实例在一次程序执行过程中只有1个
 * 懒汉式
 * @author Administrator
 *
 */
public class Lazy {

	/* 1. 声明私有的静态属性, 类型为本类类型 */
	private static Lazy lazy;
	
	/* 2. 隐藏构造方法 */
	private Lazy() {
	}
	
	/* 3. 提供一个公共的获取类实例的静态方法
		注: 此方法可以选择同步或不同步.
	 */
	public synchronized static Lazy getInstance() {
		
		/* 4. 判断, lazy属性是否为null */
		if(lazy == null) {
			lazy = new Lazy();
		}
		
		return lazy;
	}
}
```

# 三十二、单例-饿汉

```java
package com.singleton.hanger;

/**
 * 单例
 * 饿汉式
 * @author Administrator
 *
 */
public class Hanger {

	/* 1.声明私有的静态属性, 类型为本类类型, 
	 * 并在声明的同时实例化
	 */
	private static Hanger hanger = new Hanger();
	
	/* 2. 隐藏构造方法 */
	private Hanger() {
	}
	
	/* 3. 提供一个公共的获取类实例的静态方法
		注: 此方法可以选择同步或不同步.
	 */
	public static Hanger getInstance() {
		return hanger;
	}
}
```

# 三十三、单例-双重锁 

```java
package com.singleton.dblock;

/**
 * 单例
 * 双重锁式
 * @author Administrator
 *
 */
public class DoubleLock {

	/* 1. 声明私有的静态属性, 类型为本类类型
	 * 		并添加volatile关键字, 设置成域变量
	 *  */
	private volatile static DoubleLock doubleLock;
	
	/* 2. 隐藏构造方法 */
	private DoubleLock() {
	}
	
	/* 3. 提供一个公共的获取类实例的静态方法
	 */
	public static DoubleLock getInstance() {
	
		/* 4. 第一次判断 */
		if(doubleLock == null) {
			/* 5. 同步代码块, 并在代码块中进行第二次判断 */
			synchronized (DoubleLock.class) {
				if (doubleLock == null) {
					doubleLock = new DoubleLock();
				}
			}
		}
		
		return doubleLock;
	}
}

```

# 三十四、写出5种java常见的设计模式(常规共23种)

1、**单例模式。**

单例模式对实例个数的控制并节约系统资源.

在它的核心结构中只包含一个被称为单例类的特殊类,通过构造函数私有化和静态块以及提供对外访问的接口来实现.

饿汉模式:单例实例在类的加载中就被创建.不需要判断,安全.

private static MySingleton2 mySingleton = new MySingleton2();     饿汉式   直接创建了对象

懒汉模式:单例实例在第一次使用时被创建.需要if判断,不安全.

private static MySingleton2 mySingleton=null                      懒汉式    静态块中会进行判断

2、**工厂模式**

工厂模式主要是为创建对象提供了接口。

应用场景如下：

a、 在编码时不能预见需要创建哪种类的实例。

b、 系统不应依赖于产品类实例如何被创建、组合和表达的细节

3、**观察者模式**(一个学生对应多个老师,一个老师对应多个学生).

定义了对象间一对多的依赖关系，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。

应用场景如下：

a、对一个对象状态的更新，需要其他对象同步更新，而且其他对象的数量动态可变。

b、对象仅需要将自己的更新通知给其他对象而不需要知道其他对象的细节。

4、**迭代器模式。**

迭代器模式提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示。

应用场景如下：

当你需要访问一个聚集对象，而且不管这些对象是什么都需要遍历的时候，就应该考虑用迭代器模式。其实stl容器就是很好的迭代器模式的例子。

5、**代理模式**

为其他对象提供代理来控制对该对象的访问.

应用场景如下:

ngnix的反向代理(隐藏服务器)运用的就是代理模式.

# 三十五、++和--

++和--都是java内部的算术运算符，但是在和其他运算符一起参与运算时，++放在前和放在后有顺序问题

1、a++：参与运算的是没有++之前的数字

++a：参与运算的是++之前的数字



Int a = 1;

实际改变的值		  2           3         4

​			Int b = a++ * ++a * a++;   

参与运算的值		    1           3         3



经典面试题

```
int a = 0;
for(int i = 0; i < 6; i++){
实际：1
	a = a++;
运算：0
	System.out.print(a);  
}
输出的是6个0，因为每一次参与运算的a都是0

```

# 三十六、&和&&

&&是短路与，两个条件，如果前面那个为false，那么直接整个结果就是false，不会走到第二个

&会走到第二个再判断

经典面试案例

```
int	a1 = 7,
	a2 = 7,
	b1 = 8,
	b2 = 8;
boolean flag1 = a1++ > b1-- & a1++ > b1++;
boolean flag2 = a2++ > b2-- && a2++ > b2++;
a1, b1, a2, b2和flag1和flag2的值 
结果是：a1=9，b1=8，flag1=false
a2=8，b2=7，flag1=false

```

# 三十七、标识符、变量

1、字母、下划线、数字、$（64个）

2、数字不能放开头

3、不能使用关键字

4、不能使用保留字goto、const

5、驼峰命名

6、见名知义

```
5.	long n = 324174641657646;——错误，要加L
float f = 5 / 2;
int n = ‘a’;
byte b = 127;
b++; b = b+ 1;

```

# 三十八、API

application programming interface
​	应用程序编写接口

# 三十九、java中48个关键字，和2个保留字

关键字：

abstract	assert	boolean	break	byte	case
catch	char	class	continue	default	do
double	else	enum	extends	final	finally
float	for	if	implements	import	int
interface	instanceof	long	native	new	package
private	protected	public	return	short	static
strictfp	super	switch	synchronized	this	throw
throws	transient	try	void	volatile	while

保留字：

goto	const
--------------------- 

