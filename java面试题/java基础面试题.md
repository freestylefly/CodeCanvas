基础部分的顺序：基本语法，类相关的语法，内部类的语法，继承相关的语法，异常的语法，线程的 语法，集合的语法，io  的语法，虚拟机方面的语法。

 

[TOC]



# 1、一个".java"源文件中是否可以包括多个类（不是内部 类）？有什么限制？

 

可以有多个类，但只能有一个 public 的类，并且 public 的类名必须与文件名相一致。




# 2、Java 有没有 goto?

 

java 中的保留字，现在没有在 java 中使用。

 

# 3、说说&和&&的区别。

 

&和&&都可以用作逻辑与的运算符，表示逻辑与（and），当运算符两边的表达式的结果都为 true 时， 整个运算结果才为 true，否则，只要有一方为 false，则结果为 false。

&&还具有短路的功能，即如果第一个表达式为 false，则不再计算第二个表达式，例如，对于 if(str != null && !str.equals(“”))表达式，当 str 为 null 时，后面的表达式不会执行，所以不会出现 NullPointerException 如果将&&改为&，则会抛出 NullPointerException 异常。If(x`==`33 & ++y>0) y 会增长，If(x==33 && ++y>0) 不会增长

&还可以用作位运算符，当&操作符两边的表达式不是 boolean 类型时，&表示按位与操作，我们通常 使用 0x0f 来与一个整数进行&运算，来获取该整数的最低 4 个 bit 位，例如，0x31 & 0x0f 的结果为 0x01。 备注：这道题先说两者的共同点，再说出&&和&的特殊之处，并列举一些经典的例子来表明自己理解

透彻深入、实际经验丰富。

 

# 4、在 JAVA 中如何跳出当前的多重嵌套循环？

 

在 Java 中，要想跳出多重循环，可以在外面的循环语句前定义一个标号，然后在里层循环体的代码中 使用带有标号的 break 语句，即可跳出外层循环。例如，

```java
ok:

for(int i=0;i<10;i++)    {

for(int j=0;j<10;j++)              { System.out.println(“i=” + i + “,j=” + j); if(j == 5) break ok;

}

}
```

另外，我个人通常并不使用标号这种方式，而是让外层的循环条件表达式的结果可以受到里层循环体 代码的控制，例如，要在二维数组中查找到某个数字。

```java
int arr[][] = {{1,2,3},{4,5,6,7},{9}};

boolean found = false;

for(int i=0;i<arr.length && !found;i++) { for(int j=0;j<arr[i].length;j++){

System.out.println(“i=” + i + “,j=” + j); if(arr[i][j]    == 5) {

found = true; break;

}

}

}
```




# 5、switch 语句能否作用在 byte 上，能否作用在 long 上，能**否作用在** String上

在 switch（condition）中，condition 只能是一个整数表达式或者枚举常量（更大字体），整数表达式可 以是 int 基本类型或 Integer 包装类型，由于，byte,short,char 都可以隐式转换为 int，所以，这些类型以及这 些类型的包装类型也是可以的。显然，long 和 String 类型都不符合 switch 的语法规定，并且不能被隐式转 换成 int 类型，所以，它们不能作用于 swtich 语句中。

 

# 6、short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 +=   1;有什么错?

对于 short s1 = 1; s1 = s1 + 1; 由于 s1+1 运算时会自动提升表达式的类型，所以结果是 int 型，再赋值 给 short 类型 s1 时，编译器将报告需要强制转换类型的错误。

对于 short s1 = 1; s1 += 1;由于 += 是 java 语言规定的运算符，java 编译器会对它进行特殊处理，因此 可以正确编译。

 

# 7、char 型变量中能不能存贮一个中文汉字?为什么?

 

char 型变量是用来存储 Unicode 编码的字符的，unicode 编码字符集中包含了汉字，所以，char 型变量 中当然可以存储汉字啦。不过，如果某个特殊的汉字没有被包含在 unicode 编码字符集中，那么，这个 char 型变量中就不能存储这个特殊汉字。补充说明：unicode 编码占用两个字节，所以，char 类型的变量也是占 用两个字节。

备注：后面一部分回答虽然不是在正面回答题目，但是，为了展现自己的学识和表现自己对问题理解 的透彻深入，可以回答一些相关的知识，做到知无不言，言无不尽。

 

# 8、用最有效率的方法算出 2 乘以 8 等於几?

 

2 << 3，

因为将一个数左移 n 位，就相当于乘以了 2 的 n 次方，那么，一个数乘以 8 只要将其左移 3 位即可， 而位运算 cpu 直接支持的，效率最高，所以，2 乘以 8 等於几的最效率的方法是 2 << 3。

 

# 9、请设计一个一百亿的计算器

 

首先要明白这道题目的考查点是什么，一是大家首先要对计算机原理的底层细节要清楚、要知道加减 法的位运算原理和知道计算机中的算术运算会发生越界的情况，二是要具备一定的面向对象的设计思想。 首先，计算机中用固定数量的几个字节来存储的数值，所以计算机中能够表示的数值是有一定的范围 的，为了便于讲解和理解，我们先以 byte 类型的整数为例，它用 1 个字节进行存储，表示的最大数值范围 为-128 到+127。-1 在内存中对应的二进制数据为 11111111，如果两个-1 相加，不考虑 Java 运算时的类型提 升，运算后会产生进位，二进制结果为 1,11111110，由于进位后超过了 byte 类型的存储空间，所以进位部




分被舍弃，即最终的结果为 11111110，也就是-2，这正好利用溢位的方式实现了负数的运算。-128 在内存 中对应的二进制数据为 10000000，如果两个-128 相加，不考虑 Java 运算时的类型提升，运算后会产生进位， 二进制结果为 1,00000000，由于进位后超过了 byte 类型的存储空间，所以进位部分被舍弃，即最终的结果 为 00000000，也就是 0，这样的结果显然不是我们期望的，这说明**计算机中的算术运算是会发生越界情况 的，两个数值的运算结果不能超过计算机中的该类型的数值范围。**由于 Java 中涉及表达式运算时的类型自 动提升，我们无法用 byte 类型来做演示这种问题和现象的实验，大家可以用下面一个使用整数做实验的例 子程序体验一下：

```java
int a = Integer.MAX_VALUE; int b = Integer.MAX_VALUE; int sum = a + b;

System.out.println(“a=”+a+”,b=”+b+”,sum=”+sum);
```

 

 

先不考虑 long 类型，由于 int 的正数范围为 2 的 31 次方，表示的最大数值约等于 2*1000*1000*1000， 也就是 20 亿的大小，所以，要实现一个一百亿的计算器，我们得自己设计一个类可以用于表示很大的整数， 并且提供了与另外一个整数进行加减乘除的功能，大概功能如下：

（）这个类内部有两个成员变量，一个表示符号，另一个用字节数组表示数值的二进制数

（）有一个构造方法，把一个包含有多位数值的字符串转换到内部的符号和字节数组中

（）提供加减乘除的功能

```java
public class BigInteger{ int sign;

byte[] val;

public Biginteger(String val){ sign = ;

val = ;

}

public BigInteger add(BigInteger other) {


}

public BigInteger subtract(BigInteger other)   {


}

public BigInteger multiply(BigInteger other){

}

public BigInteger divide(BigInteger other){


}


}
```

备注：要想写出这个类的完整代码，是非常复杂的，如果有兴趣的话，可以参看 jdk 中自带的 java.math.BigInteger 类的源码。面试的人也知道谁都不可能在短时间内写出这个类的完整代码的，他要的 是你是否有这方面的概念和意识，他最重要的还是考查你的能力，所以，你不要因为自己无法写出完整的 最终结果就放弃答这道题，你要做的就是你比别人写得多，证明你比别人强，你有这方面的思想意识就可 以了，毕竟别人可能连题目的意思都看不懂，什么都没写，你要敢于答这道题，即使只答了一部分，那也




与那些什么都不懂的人区别出来，拉开了距离，算是矮子中的高个，机会当然就属于你了。另外，答案中 的框架代码也很重要，体现了一些面向对象设计的功底，特别是其中的方法命名很专业，用的英文单词很 精准，这也是能力、经验、专业性、英语水平等多个方面的体现，会给人留下很好的印象，在编程能力和 其他方面条件差不多的情况下，英语好除了可以使你获得更多机会外，薪水可以高出一千元。

 

 

# 10、使用 final 关键字修饰一个变量时，是引用不能变，还 是引用的对象不能变？

 

使用 final 关键字修饰一个变量时，是指引用变量不能变，引用变量所指向的对象中的内容还是可以改 变的。例如，对于如下语句：

final StringBuffer a=new StringBuffer("immutable");

执行如下语句将报告编译期错误：

a=new StringBuffer("");

但是，执行如下语句则可以通过编译：

a.append(" broken!");

 

 

有人在定义方法的参数时，可能想采用如下形式来阻止方法内部修改传进来的参数对象：

public void method(final    StringBuffer   param){

}

实际上，这是办不到的，在该方法内部仍然可以增加如下代码来修改参数对象：

param.append("a");

 

# 11、"=="和 equals 方法究竟有什么区别？

 

（单独把一个东西说清楚，然后再说清楚另一个，这样，它们的区别自然就出来了，混在一起说，则 很难说清楚）

`==`操作符专门用来比较两个变量的值是否相等，也就是用于比较变量所对应的内存中所存储的数值是 否相同，要比较两个基本类型的数据或两个引用变量是否相等，只能用==操作符。

如果一个变量指向的数据是对象类型的，那么，这时候涉及了两块内存，对象本身占用一块内存（堆 内存），变量也占用一块内存，例如 Objet obj = new Object();变量 obj 是一个内存，new Object()是另一个内 存，此时，变量 obj 所对应的内存中存储的数值就是对象占用的那块内存的首地址。对于指向对象类型的 变量，如果要比较两个变量是否指向同一个对象，即要看这两个变量所对应的内存中的数值是否相等，这 时候就需要用==操作符进行比较。

equals 方法是用于比较两个独立对象的内容是否相同，就好比去比较两个人的长相是否相同，它比较 的两个对象是独立的。例如，对于下面的代码：

String a=new String("foo");

String b=new String("foo");

两条 new 语句创建了两个对象，然后用 a,b 这两个变量分别指向了其中一个对象，这是两个不同的对 象，它们的首地址是不同的，即 a 和 b 中存储的数值是不相同的，所以，表达式 a==b 将返回 false，而这 两个对象中的内容是相同的，所以，表达式 a.equals(b)将返回 true。

在实际 开发 中，我 们经 常要比 较传 递进行 来的 字符串 内容 是否等 ，例 如， String  input




= …;input.equals(“quit”)，许多人稍不注意就使用==进行比较了，这是错误的，随便从网上找几个项目实战 的教学视频看看，里面就有大量这样的错误。记住，字符串的比较基本上都是使用 equals 方法。

如果一个类没有自己定义 equals 方法，那么它将继承 Object 类的 equals 方法，Object 类的 equals 方法 的实现代码如下：

boolean equals(Object o){ return this==o;

}

这说明，如果一个类没有自己定义 equals 方法，它默认的 equals 方法（从 Object 类继承的）就是使 用`==`操作符，也是在比较两个变量指向的对象是否是同一对象，这时候使用 equals 和使用==会得到同样的 结果，如果比较的是两个独立的对象则总返回 false。如果你编写的类希望能够比较该类创建的两个实例对 象的内容是否相同，那么你必须覆盖 equals 方法，由你自己写代码来决定在什么情况即可认为两个对象的 内容是相同的。

 

# 12、静态变量和实例变量的区别？

 

在语法定义上的区别：静态变量前要加 static 关键字，而实例变量前则不加。 在程序运行时的区别：实例变量属于某个对象的属性，必须创建了实例对象，其中的实例变量才会被

分配空间，才能使用这个实例变量。静态变量不属于某个实例对象，而是属于类，所以也称为类变量，只 要程序加载了类的字节码，不用创建任何实例对象，静态变量就会被分配空间，静态变量就可以被使用了。 总之，实例变量必须创建对象后才可以通过这个对象来使用，静态变量则可以直接使用类名来引用。

例如，对于下面的程序，无论创建多少个实例对象，永远都只分配了一个 staticVar 变量，并且每创建 一个实例对象，这个 staticVar 就会加 1；但是，每创建一个实例对象，就会分配一个 instanceVar，即可能 分配多个 instanceVar，并且每个 instanceVar 的值都只自加了 1 次。

```java
public class VariantTest{

public static int staticVar = 0; public int instanceVar = 0; public VariantTest(){

staticVar++; instanceVar++;

System.out.println(“staticVar=” + staticVar + ”,instanceVar=” + instanceVar);

}

}
```

备注：这个解答除了说清楚两者的区别外，最后还用一个具体的应用例子来说明两者的差异，体现了 自己有很好的解说问题和设计案例的能力，思维敏捷，超过一般程序员，有写作能力！

 

# 13、是否可以从一个 static 方法内部发出对非 static 方法的 调用？

 

不可以。因为非 static 方法是要与对象关联在一起的，必须创建一个对象后，才可以在该对象上进行方 法调用，而 static 方法调用时不需要创建对象，可以直接调用。也就是说，当一个 static 方法被调用时，可 能还没有创建任何实例对象，如果从一个 static 方法中发出对非 static 方法的调用，那个非 static 方法是关 联到哪个对象上的呢？这个逻辑无法成立，所以，一个 static 方法内部发出对非 static 方法的调用。




# 14、Integer 与 int 的区别

 

int 是 java 提供的 8 种原始数据类型之一。Java 为每个原始类型提供了封装类，Integer 是 java 为 int 提 供的封装类。int 的默认值为 0，而 Integer 的默认值为 null，即 Integer 可以区分出未赋值和值为 0 的区别， int 则无法表达出未赋值的情况，例如，要想表达出没有参加考试和考试成绩为 0 的区别，则只能使用 Integer。 在 JSP 开发中，Integer 的默认为 null，所以用 el 表达式在文本框中显示时，值为空白字符串，而 int 默认 的默认值为 0，所以用 el 表达式在文本框中显示时，结果为 0，所以，int 不适合作为 web 层的表单数据的 类型。

在 Hibernate 中，如果将 OID 定义为 Integer 类型，那么 Hibernate 就可以根据其值是否为 null 而判断一 个对象是否是临时的，如果将 OID 定义为了 int 类型，还需要在 hbm 映射文件中设置其 unsaved-value 属性 为 0。

另外，Integer 提供了多个与整数相关的操作方法，例如，将一个字符串转换成整数，Integer 中还定义 了表示整数的最大值和最小值的常量。

 

# 15、Math.round(11.5)等於多少? Math.round(-11.5)等於多 少?

Math 类中提供了三个与取整有关的方法：ceil、floor、round，这些方法的作用与它们的英文名称的含 义相对应， 例如， ceil 的 英文意义是 天花板，该 方法就表示 向上取整， Math.ceil(11.3) 的 结果为 12,Math.ceil(-11.3)的结果是-11；floor  的英文意义是地板，该方法就表示向下取整，Math.ceil(11.6)的结果为

11,Math.ceil(-11.6)的结果是-12；最难掌握的是 round 方法，它表示“四舍五入”，算法为 Math.floor(x+0.5)， 即将原来的数字加上 0.5 后再向下取整，所以，Math.round(11.5)的结果为 12，Math.round(-11.5)的 结果为-11。

 

# 16、下面的代码有什么不妥之处?

 

```java
\1. if(username.equals(“zxx”){}

\2. **int**  x = 1;

return x==1?true:false;
```

 

# 17、请说出作用域 public，private，protected，以及不写时 的区别

 

这四个作用域的可见范围如下表所示。 说明：如果在修饰的元素上面没有写任何访问修饰符，则表示 friendly。

|  作用域   | 当前类 | 同一 package | 子孙类 | 其他 package |
| :-------: | :----: | :----------: | :----: | :----------: |
|  public   |   √    |      √       |   √    |      √       |
| protected |   √    |      √       |   √    |      ×       |
| friendly  |   √    |      √       |   ×    |      ×       |
|  private  |   √    |      ×       |   ×    |      ×       |

备注：只要记住了有 4 种访问权限，4 个访问范围，然后将全选和范围在水平和垂直方向上分别按排 从小到大或从大到小的顺序排列，就很容易画出上面的图了。

 

# 18、Overload 和Override 的区别。Overloaded 的方法是否 可以改变返回值的类型?

Overload 是重载的意思，Override 是覆盖的意思，也就是重写。

重载 Overload 表示同一个类中可以有多个名称相同的方法，但这些方法的参数列表各不相同（即参数 个数或类型不同）。

重写 Override 表示子类中的方法可以与父类中的某个方法的名称和参数完全相同，通过子类创建的实 例对象调用这个方法时，将调用子类中的定义方法，这相当于把父类中定义的那个完全相同的方法给覆盖 了，这也是面向对象编程的多态性的一种表现。子类覆盖父类的方法时，只能比父类抛出更少的异常，或 者是抛出父类抛出的异常的子异常，因为子类可以解决父类的一些问题，不能比父类有更多的问题。子类 方法的访问权限只能比父类的更大，不能更小。如果父类的方法是 private 类型，那么，子类则不存在覆盖 的限制，相当于子类中增加了一个全新的方法。

至于 Overloaded 的方法是否可以改变返回值的类型这个问题，要看你倒底想问什么呢？这个题目很模 糊。如果几个 Overloaded 的方法的参数列表不一样，它们的返回者类型当然也可以不一样。但我估计你想 问的问题是：如果两个方法的参数列表完全一样，是否可以让它们的返回值不同来实现重载 Overload。这 是不行的，我们可以用反证法来说明这个问题，因为我们有时候调用一个方法时也可以不定义返回结果变 量，即不要关心其返回结果，例如，我们调用 map.remove(key)方法时，虽然 remove 方法有返回值，但是 我们通常都不会定义接收返回结果的变量，这时候假设该类中有两个名称和参数列表完全相同的方法，仅 仅是返回类型不同，java 就无法确定编程者倒底是想调用哪个方法了，因为它无法通过返回结果类型来判 断。

 

override 可以翻译为覆盖，从字面就可以知道，它是覆盖了一个方法并且对其重写，以求达 到不同的作用。对我们来说最熟悉的覆盖就是对接口方法的实现，在接口中一般只是对方法 进行了声明，而我们在实现时，就需要实现接口声明的所有方法。除了这个典型的用法以外， 我们在继承中也可能会在子类覆盖父类中的方法。在覆盖要注意以下的几点： 1、覆盖的方法的标志必须要和被覆盖的方法的标志完全匹配，才能达到覆盖的效果；

2、覆盖的方法的返回值必须和被覆盖的方法的返回一致；

3、覆盖的方法所抛出的异常必须和被覆盖方法的所抛出的异常一致，或者是其子类；

4、被覆盖的方法不能为 private，否则在其子类中只是新定义了一个方法，并没有对其进行 覆盖。

overload 对我们来说可能比较熟悉，可以翻译为重载，它是指我们可以定义一些名称相同 的方法，通过定义不同的输入参数来区分这些方法，然后再调用时，VM 就会根据不同的参 数样式，来选择合适的方法执行。在使用重载要注意以下的几点： 1、在使用重载时只能通过不同的参数样式。例如，不同的参数类型，不同的参数个数，不 同的参数顺序（当然，同一方法内的几个参数类型必须不一样，例如可以是 fun(int,float)， 但是不能为 fun(int,int)）；

2、不能通过访问权限、返回类型、抛出的异常进行重载；




3、方法的异常类型和数目不会对重载造成影响；

4、对于继承来说，如果某一方法在父类中是访问权限是 priavte，那么就不能 在子类对其进行重载，如果定义的话，也只是定义了一个新方法，而不会达到重 载的效果。

 

# 19、构造器 Constructor是否可被 **override?**

 

构造器 Constructor 不能被继承，因此不能重写 Override，但可以被重载 Overload。

 

# 20、接口是否可继承接口? 抽象类是否可实现(implements) 接口? 抽象类是否可继承具体类(concrete class)? 抽象类中 是否可以有静态的 main 方法？

接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承具体类。抽象类中可以有静 态的 main 方法。

备注：只要明白了接口和抽象类的本质和作用，这些问题都很好回答，你想想，如果你是 java 语言的 设计者，你是否会提供这样的支持，如果不提供的话，有什么理由吗？如果你没有道理不提供，那答案就 是肯定的了。

只有记住抽象类与普通类的唯一区别就是不能创建实例对象和允许有 abstract 方法。

 

# 21、写 clone()方法时，通常都有一行代码，是什么？

 

clone 有缺省行为，super.clone();因为首先要把父类中的成员复制到位，然后才是复制自己的成员。

 

# 22、面向对象的特征有哪些方面

 

计算机软件系统是现实生活中的业务在计算机中的映射，而现实生活中的业务其实就是一个个对象协 作的过程。面向对象编程就是按现实业务一样的方式将程序代码按一个个对象进行组织和编写，让计算机 系统能够识别和理解用对象方式组织和编写的程序代码，这样就可以把现实生活中的业务对象映射到计算 机系统中。

面向对象的编程语言有封装、继承 、抽象、多态等 4 个主要的特征。

1 封装：

封装是保证软件部件具有优良的模块性的基础，封装的目标就是要实现软件部件的“高内聚、低 耦合”，防止程序相互依赖性而带来的变动影响。在面向对象的编程语言中，对象是封装的最基本单 位，面向对象的封装比传统语言的封装更为清晰、更为有力。面向对象的封装就是把描述一个对象的属 性和行为的代码封装在一个“模块”中，也就是一个类中，属性用变量定义，行为用方法进行定义，方法 可以直接访问同一个对象中的属性。通常情况下，**只要记住让变量和访问这个变量的方法放在一起，将一 个类中的成员变量全部定义成私有的，只有这个类自己的方法才可以访问到这些成员变量，这就基本上实 现对象的封装，就很容易找出要分配到这个类上的方法了，就基本上算是会面向对象的编程了。把握一个 原则：把对同一事物进行操作的方法和相关的方法放在同一个类中，把方法和它操作的数据放在同一个类中。

例如，人要在黑板上画圆，这一共涉及三个对象：人、黑板、圆，画圆的方法要分配给哪个对象呢？ 由于画圆需要使用到圆心和半径，圆心和半径显然是圆的属性，如果将它们在类中定义成了私有的成员变 量，那么，画圆的方法必须分配给圆，它才能访问到圆心和半径这两个属性，人以后只是调用圆的画圆方 法、表示给圆发给消息而已，画圆这个方法不应该分配在人这个对象上，**这就是面向对象的封装性，即将 对象封装成一个高度自治和相对封闭的个体，对象状态（属性）由这个对象自己的行为（方法）来读取和 改变。**一个更便于理解的例子就是，司机将火车刹住了，刹车的动作是分配给司机，还是分配给火车，显 然，应该分配给火车，因为司机自身是不可能有那么大的力气将一个火车给停下来的，只有火车自己才能 完成这一动作，火车需要调用内部的离合器和刹车片等多个器件协作才能完成刹车这个动作，司机刹车的 过程只是给火车发了一个消息，通知火车要执行刹车动作而已。

 

抽象：

抽象就是找出一些事物的相似和共性之处，然后将这些事物归为一个类，这个类只考虑这些事物 的相似和共性之处，并且会忽略与当前主题和目标无关的那些方面，将注意力集中在与当前目标有关 的方面。例如，看到一只蚂蚁和大象，你能够想象出它们的相同之处，那就是抽象。抽象包括行为抽 象和状态抽象两个方面。例如，定义一个 Person 类，如下：

```java
class Person{

String name; int age;

}
```

人本来是很复杂的事物，有很多方面，但因为当前系统只需要了解人的姓名和年龄，所以上面定 义的类中只包含姓名和年龄这两个属性，这就是一种抽像，使用抽象可以避免考虑一些与目标无关的 细节。我对抽象的理解就是不要用显微镜去看一个事物的所有方面，这样涉及的内容就太多了，而是 要善于划分问题的边界，当前系统需要什么，就只考虑什么。

 

继承： 在定义和实现一个类的时候，可以在一个已经存在的类的基础之上来进行，把这个已经存在的类

所定义的内容作为自己的内容，并可以加入若干新的内容，或修改原来的方法使之更适合特殊的需要， 这就是继承。继承是子类自动共享父类数据和方法的机制，这是类之间的一种关系，提高了软件的可 重用性和可扩展性。

 

多态： 多态是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时

并不确定，而是在程序运行期间才确定，即一个引用变量倒底会指向哪个类的实例对象，该引用变量 发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。因为在程序运行时才 确定具体的类，这样，不用修改源程序代码，就可以让引用变量绑定到各种不同的类实现上，从 而导致该引用调用的具体方法随之改变，即不修改程序代码就可以改变程序运行时所绑定的具 体代码，让程序可以选择多个运行状态，这就是多态性。多态性增强了软件的灵活性和扩展性。 例 如，下面代 码中 的 UserDao 是 一 个 接口，它定 义引用变量 userDao 指 向的实例对 象由 daofactory.getDao()在执行的时候返回，有时候指向的是 UserJdbcDao 这个实现，有时候指向 的是 UserHibernateDao 这个实现，这样，不用修改源代码，就可以改变 userDao 指向的具体

类实现，从而导致 userDao.insertUser()方法调用的具体代码也随之改变，即有时候调用的是

UserJdbcDao 的 insertUser 方法，有时候调用的是 UserHibernateDao 的 insertUser 方法：

UserDao userDao = daofactory.getDao();




userDao.insertUser(user);

 

比喻：人吃饭，你看到的是左手，还是右手？

 

# 23、java 中实现多态的机制是什么？

 

靠的是父类或接口定义的引用变量可以指向子类或具体实现类的实例对象，而程序调用的方法在 运行期才动态绑定，就是引用变量所指向的具体实例对象的方法，也就是内存里正在运行的那个对象 的方法，而不是引用变量的类型中定义的方法。

 

# 24、abstract class 和 interface 有什么区别?

 

含有 abstract 修饰符的 class 即为抽象类，abstract 类不能创建的实例对象。含有 abstract 方法的类必须 定义为 abstract class，abstract class 类中的方法不必是抽象的。abstract class 类中定义抽象方法必须在具体 (Concrete)子类中实现，所以，不能有抽象构造方法或抽象静态方法。如果的子类没有实现抽象父类中的所 有抽象方法，那么子类也必须定义为 abstract 类型。

接口（interface）可以说成是抽象类的一种特例，接口中的所有方法都必须是抽象的。接口中的方法定 义默认为 public abstract 类型，接口中的成员变量类型默认为 public static final。

下面比较一下两者的语法区别：

1.抽象类可以有构造方法，接口中不能有构造方法。

2.抽象类中可以有普通成员变量，接口中没有普通成员变量

3.抽象类中可以包含非抽象的普通方法，接口中的所有方法必须都是抽象的，不能有非抽象的普通方 法。

\4. 抽象类中的抽象方法的访问类型可以是 public，protected 和（默认类型,虽然

eclipse 下不报错，但应该也不行），但接口中的抽象方法只能是 public 类型的，并且默认即为 public abstract 类型。

\5. 抽象类中可以包含静态方法，接口中不能包含静态方法

\6. 抽象类和接口中都可以包含静态成员变量，抽象类中的静态成员变量的访问类型可以任意，但接口 中定义的变量只能是 public static final 类型，并且默认即为 public static final 类型。

\7.  一个类可以实现多个接口，但只能继承一个抽象类。

下面接着再说说两者在应用上的区别： 接口更多的是在系统架构设计方法发挥作用，主要用于定义模块之间的通信契约。而抽象类在代码实

现方面发挥作用，可以实现代码的重用，例如，模板方法设计模式是抽象类的一个典型应用，假设某个项 目的所有 Servlet 类都要用相同的方式进行权限判断、记录访问日志和处理异常，那么就可以定义一个抽象 的基类，让所有的 Servlet 都继承这个抽象基类，在抽象基类的 service 方法中完成权限判断、记录访问日 志和处理异常的代码，在各个子类中只是完成各自的业务逻辑代码，伪代码如下：

```java
public abstract class BaseServlet extends HttpServlet{

public final void service(HttpServletRequest request, HttpServletResponse response) throws IOExcetion,ServletException       {

记录访问日志

进行权限判断 if(具有权限){ try{


 

doService(request,response);

}

catch(Excetpion e)       {

记录异常信息

}

}

}

protected abstract void doService(HttpServletRequest request, HttpServletResponse response) throws IOExcetion,ServletException;

//注意访问权限定义成 protected，显得既专业，又严谨，因为它是专门给子类用的

}

 

 

public class MyServlet1 extends BaseServlet

{

protected void doService(HttpServletRequest request, HttpServletResponse response) throws IOExcetion,ServletException

{

本 Servlet 只处理的具体业务逻辑代码

}

 

}
```

父类方法中间的某段代码不确定，留给子类干，就用模板方法设计模式。 备注：这道题的思路是先从总体解释抽象类和接口的基本概念，然后再比较两者的语法细节，最后再

说两者的应用区别。比较两者语法细节区别的条理是：先从一个类中的构造方法、普通成员变量和方法（包 括抽象方法），静态变量和方法，继承性等 6 个方面逐一去比较回答，接着从第三者继承的角度的回答，特 别是最后用了一个典型的例子来展现自己深厚的技术功底。

 

# 25、abstract 的 method 是否可同时是 static,是否可同时是 native，是否可同时是 synchronized?

abstract 的 method  不可以是 static 的，因为抽象的方法是要被子类实现的，而 static 与子类扯不上关系！

native 方法表示该方法要用另外一种依赖平台的编程语言实现的，不存在着被子类实现的问题，所以， 它也不能是抽象的，不能与 abstract 混用。例如，FileOutputSteam 类要硬件打交道，底层的实现用的是操 作系统相关的 api 实现，例如，在 windows 用 c 语言实现的，所以，查看 jdk 的源代码，可以发现 FileOutputStream 的 open 方法的定义如下：

private native void open(String name) throws FileNotFoundException;

如果我们要用 java 调用别人写的 c 语言函数，我们是无法直接调用的，我们需要按照 java 的要求写一 个 c 语言的函数，又我们的这个 c 语言函数去调用别人的 c 语言函数。由于我们的 c 语言函数是按 java 的 要求来写的，我们这个 c 语言函数就可以与 java 对接上，java 那边的对接方式就是定义出与我们这个 c 函 数相对应的方法，java 中对应的方法不需要写具体的代码，但需要在前面声明 native。

关于 synchronized 与 abstract 合用的问题，我觉得也不行，因为在我几年的学习和开发中，从来没见到 过这种情况，并且我觉得 synchronized 应该是作用在一个具体的方法上才有意义。而且，方法上的 synchronized 同步所使用的同步锁对象是 this，而抽象方法上无法确定 this 是什么。




# 26、什么是内部类？Static Nested Class  和 Inner Class 的不同

内部类就是在一个类的内部定义的类，内部类中不能定义静态成员（静态成员不是对象的特性，只是 为了找一个容身之处，所以需要放到一个类中而已，这么一点小事，你还要把它放到类内部的一个类中， 过分了啊！提供内部类，不是为让你干这种事情，无聊，不让你干。我想可能是既然静态成员类似 c 语言 的全局变量，而内部类通常是用于创建内部对象用的，所以，把“全局变量”放在内部类中就是毫无意义 的事情，既然是毫无意义的事情，就应该被禁止），内部类可以直接访问外部类中的成员变量，内部类可以 定义在外部类的方法外面，也可以定义在外部类的方法体中，如下所示：

```java
public class Outer

{

int out_x    = 0; public void method()

{

Inner1 inner1 = new Inner1();

public class Inner2      //在方法体内部定义的内部类

{

public method()

{

out_x = 3;

}

}

Inner2 inner2 = new Inner2();

}

 

public class Inner1      //在方法体外面定义的内部类

{

}

}
```

在方法体外面定义的内部类的访问类型可以是 public,protecte,默认的，private 等 4 种类型，这就好像类 中定义的成员变量有 4 种访问类型一样，它们决定这个内部类的定义对其他类是否可见；对于这种情况， 我们也可以在外面创建内部类的实例对象，创建内部类的实例对象时，一定要先创建外部类的实例对象， 然后用这个外部类的实例对象去创建内部类的实例对象，代码如下：

Outer outer = new Outer();

Outer.Inner1 inner1 = outer.new Innner1();

 

 

在方法内部定义的内部类前面不能有访问类型修饰符，就好像方法中定义的局部变量一样，但这种内 部类的前面可以使用 final 或 abstract 修饰符。这种内部类对其他类是不可见的其他类无法引用这种内部类， 但是这种内部类创建的实例对象可以传递给其他类访问。这种内部类必须是先定义，后使用，即内部类的 定义代码必须出现在使用该类之前，这与方法中的局部变量必须先定义后使用的道理也是一样的。这种内 部类可以访问方法体中的局部变量，但是，该局部变量前必须加 final 修饰符。

对于这些细节，只要在 eclipse 写代码试试，根据开发工具提示的各类错误信息就可以马上了解到。






在方法体内部还可以采用如下语法来创建一种匿名内部类，即定义某一接口或类的子类的同时，还创 建了该子类的实例对象，无需为该子类定义名称：

```java
public class Outer

{

public void start()

{

new Thread(

new Runable(){

public void run(){};

}

).start();

}

}

 
```

最后，在方法外部定义的内部类前面可以加上 static 关键字，从而成为 Static Nested Class，它不再具有 内部类的特性，所有，从狭义上讲，它不是内部类。Static Nested Class 与普通类在运行时的行为和功能上 没有什么区别，只是在编程引用时的语法上有一些差别，它可以定义成 public、protected、默认的、private 等多种类型，而普通类只能定义成 public 和默认的这两种类型。在外面引用 Static Nested Class 类的名称为 “外部类名.内部类名”。在外面不需要创建外部类的实例对象，就可以直接创建 Static Nested Class，例如， 假设 Inner 是定义在 Outer 类中的 Static Nested Class，那么可以使用如下语句创建 Inner 类：

Outer.Inner inner = new Outer.Inner();

由于 static Nested Class 不依赖于外部类的实例对象，所以，static Nested Class 能访问外部类的非 static 成员变量。当在外部类中访问 Static Nested Class 时，可以直接使用 Static Nested Class 的名字，而不需要加 上外部类的名字了，在 Static Nested Class 中也可以直接引用外部类的 static 的成员变量，不需要加上外部 类的名字。

在静态方法中定义的内部类也是 Static Nested Class，这时候不能在类前面加 static 关键字，静态方法中 的 Static Nested Class 与普通方法中的内部类的应用方式很相似，它除了可以直接访问外部类中的 static 的 成员变量，还可以访问静态方法中的局部变量，但是，该局部变量前必须加 final 修饰符。

 

备注：首先根据你的印象说出你对内部类的总体方面的特点：例如，在两个地方可以定义，可以访问 外部类的成员变量，不能定义静态成员，这是大的特点。然后再说一些细节方面的知识，例如，几种定义 方式的语法区别，静态内部类，以及匿名内部类。

 

# 27、内部类可以引用它的包含类的成员吗？有没有什么限 制？

 

完全可以。如果不是静态内部类，那没有什么限制！ 如果你把静态嵌套类当作内部类的一种特例，那在这种情况下不可以访问外部类的普通成员变量，而

只能访问外部类中的静态成员，例如，下面的代码：

```java
class Outer

{

static int x;


 

static class Inner

{

void test()

{

syso(x);

}

}

}

 
```

答题时，也要能察言观色，揣摩提问者的心思，显然人家希望你说的是静态内部类不能 访问外部类的成员，但你一上来就顶牛，这不好，要先顺着人家，让人家满意，然后再说特 殊情况，让人家吃惊。

 

 

# 28 、 Anonymous Inner Class ( 匿名内部类 ) 是否可以 extends( 继 承 ) 其 它 类 ， 是 否 可 以implements( 实 现)interface(接口)?

可以继承其他类或实现其他接口。不仅是可以，而是必须!

 

# 29、**super**.getClass()方法调用下面程序的输出结果是多少？

```java
import java.util.Date;

**public  class** Test **extends** Date{

**public static void** main(String[] args) {

**new** Test().test();

}

 

**public void** test(){ System.*out*.println(**super**.getClass().getName());

}

}
```

 

很奇怪，结果是 Test

 

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image001.gif)

这属于脑筋急转弯的题目，在一个 qq 群有个网友正好问过这个问题，我觉得挺有趣，就研究了 一下，没想到今天还被你面到了，哈哈。

在 test 方法中，直接调用 getClass().getName()方法，返回的是 Test 类名 由于 getClass()在 Object 类中定义成了 final，子类不能覆盖该方法，所以，在

test 方法中调用 getClass().getName()方法，其实就是在调用从父类继承的 getClass()

方 法 ， 等 效 于 调     用  super.getClass().getName() 方  法  ，  所 以 ，




super.getClass().getName()方法返回的也应该是 Test。 如果想得到父类的名称，应该用如下代码：

getClass().getSuperClass().getName();

 

# 30、String 是最基本的数据类型吗?

 

基本数据类型包括 byte、int、char、long、float、double、boolean 和 short。 java.lang.String 类是 final 类型的，因此不可以继承这个类、不能修改这个类。为了提高

效率节省空间，我们应该用 StringBuffer 类

 

# 31、String s = "Hello";s = s + " world!";这两行代码执行后， 原始的 String 对象中的内容到底变了没有？

没有。因为 String 被设计成不可变(immutable)类，所以它的所有对象都是不可变对象。 在这段代码中，s 原先指向一个 String 对象，内容是 "Hello"，然后我们对 s 进行了+操作， 那么 s 所指向的那个对象是否发生了改变呢？答案是没有。这时，s 不指向原来那个对象了， 而指向了另一个 String 对象，内容为"Hello world!"，原来那个对象还存在于内存之中，只 是 s 这个引用变量不再指向它了。

通过上面的说明，我们很容易导出另一个结论，如果经常对字符串进行各种各样的修改， 或者说，不可预见的修改，那么使用 String 来代表字符串的话会引起很大的内存开销。因为 String 对象建立之后不能再改变，所以对于每一个不同的字符串，都需要一个 String 对象来 表示。这时，应该考虑使用 StringBuffer 类，它允许修改，而不是每个不同的字符串都要生 成一个新的对象。并且，这两种类的对象转换十分容易。 同时，我们还可以知道，如果要使用内容相同的字符串，不必每次都 new 一个 String。例如 我们要在构造器中对一个名叫 s 的 String 引用变量进行初始化，把它设置为初始值，应当这 样做：

```java
public class Demo { private String s;

...

public Demo {

s = "Initial Value";

}

...

}
```

而非

s = new String("Initial Value"); 后者每次都会调用构造器，生成新对象，性能低下且内存开销大，并且没有意义，因为 String 对象不可改变，所以对于内容相同的字符串，只要一个 String 对象来表示就可以了。也就说， 多次调用上面的构造器创建多个对象，他们的 String 类型属性 s 都指向同一个对象。 上面的结论还基于这样一个事实：对于字符串常量，如果内容相同，Java 认为它们代表同一 个 String 对象。而用关键字 new 调用构造器，总是会创建一个新的对象，无论内容是否相 同。




至于为什么要把 String 类设计成不可变类，是它的用途决定的。其实不只 String，很多 Java 标准类库中的类都是不可变的。在开发一个系统的时候，我们有时候也需要设计不可变类， 来传递一组相关的值，这也是面向对象思想的体现。不可变类有一些优点，比如因为它的对 象是只读的，所以多线程并发访问也不会有任何问题。当然也有一些缺点，比如每个不同的 状态都要一个对象来代表，可能会造成性能上的问题。所以 Java 标准类库还提供了一个可 变版本，即 StringBuffer。

 

 

# 32、是否可以继承 String 类?

 

String 类是 final 类故不可以继承。

 

 

# 33、String s = new String("xyz");创建了几个 String Object?

**二者之间有什么区别？**

 

两个或一个，”xyz”对应一个对象，这个对象放在字符串常量缓冲区，常量”xyz”不管出现 多少遍，都是缓冲区中的那一个。New String 每写一遍，就创建一个新的对象，它一句那个常 量”xyz”对象的内容来创建出一个新 String 对象。如果以前就用过’xyz’，这句代表就不会创 建”xyz”自己了，直接从缓冲区拿。

 

# 34、String 和 StringBuffer 的区别

 

JAVA 平台提供了两个类：String 和 StringBuffer，它们可以储存和操作字符串，即包含多 个字符的字符数据。这个 String 类提供了数值不可改变的字符串。而这个 StringBuffer 类提供 的字符串进行修改。当你知道字符数据要改变的时候你就可以使用 StringBuffer。典型地，你 可以使用 StringBuffers 来动态构造字符数据。 另外， String 实现了 equals 方法， new String(“abc”).equals(new String(“abc”)的结果为 true,而 StringBuffer 没有实现 equals 方法，所以， new StringBuffer(“abc”).equals(new StringBuffer(“abc”)的结果为 false。

 

接着要举一个具体的例子来说明，我们要把 1 到 100 的所有数字拼起来，组成一个串。

StringBuffer sbf = new StringBuffer(); for(int i=0;i<100;i++)

{

sbf.append(i);

}

上面的代码效率很高，因为只创建了一个 StringBuffer 对象，而下面的代码效率很低，因为 创建了 101 个对象。

String str = new String(); for(int i=0;i<100;i++)

{




str = str + i;

}

在讲两者区别时，应把循环的次数搞成 10000，然后用 endTime-beginTime 来比较两者执行 的时间差异，最后还要讲讲 StringBuilder 与 StringBuffer 的区别。

 

String 覆盖了 equals 方法和 hashCode 方法，而 StringBuffer 没有覆盖 equals 方法和 hashCode

方法，所以，将 StringBuffer 对象存储进 Java 集合类中时会出现问题。

 

# 35、如何把一段逗号分割的字符串转换成一个数组?

 

如果不查 jdk api，我很难写出来！我可以说说我的思路：

\1.                 用正则表达式，代码大概为：String [] result = orgStr.split(“,”);

\2.                 用 StingTokenizer ,代码为：StringTokenizer tokener = StringTokenizer(orgStr,”,”); String [] result = new String[tokener .countTokens()];

Int i=0; while(tokener.hasNext(){result[i++]=toker.nextToken();}

 

 

 

# 36、数组有没有 length()这个方法? String 有没有 length()这 个方法？

数组没有 length()这个方法，有 length 的属性。String 有有 length()这个方法。

 

# 37 、下面这条语句一共创建了多少个对象： String s="a"+"b"+"c"+"d";

答：对于如下代码：

String s1 = "a"; String s2 = s1 + "b"; String s3 = "a" + "b";

System.out.println(s2 == "ab"); System.out.println(s3 == "ab");

第一条语句打印的结果为 false，第二条语句打印的结果为 true，这说明 javac 编译可以对

字符串常量直接相加的表达式进行优化，不必要等到运行期去进行加法运算处理，而是在编 译时去掉其中的加号，直接将其编译成一个这些常量相连的结果。

题目中的第一行代码被编译器在编译时优化后，相当于直接定义了一个”abcd”的字符串， 所以，上面的代码应该只创建了一个 String 对象。写如下两行代码，

String s = "a" + "b" + "c" + "d"; System.out.println(s == "abcd");

最终打印的结果应该为 true。




# 38、try {}里有一个 return 语句，那么紧跟在这个 try 后的

**finall****y {}****里****的** **cod****e** **会不会被执行，什么时候被执行，在** **r****e****turn**

**前还是后****?**

 

也许你的答案是在 return 之前，但往更细地说，我的答案是在 return 中间执行，请看下面程序代码的 运行结果：

```java
**public  class** Test {

 

/**

\* **@param** args add by zxx ,Dec 9, 2008

*/

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub System.*out*.println(**new** Test().test());;

}

 

static **int** test()

{

**int** x = 1;

**try**

{

**return** x;

}

**finally**

{

++x;

}

}

 

}

 

---------执行结果 ---------

1
```

 

运行结果是 1，为什么呢？主函数调用子函数并得到结果的过程，好比主函数准备一个空罐子，当子 函数要返回结果时，先把结果放在罐子里，然后再将程序逻辑返回到主函数。所谓返回，就是子函 数说，我不运行了，你主函数继续运行吧，这没什么结果可言，结果是在说这话之前放进罐子里的。

 

# 39、下面的程序代码输出的结果是多少？

 

```java
public class    smallT


 

{

public static void    main(String args[])

{

smallT t    = new    smallT(); int  b     =            t.get(); System.out.println(b);

}

 

public int    get()

{


 

try

{

 

}


 



 

 

return 1 ;


 

finally

{

return 2 ;

}

}

}

 

 

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image002.gif)
```

返回的结果是 2。

我可以通过下面一个例子程序来帮助我解释这个答案，从下面例子的运行结果中可以发现， try 中的 return 语句调用的函数先于 finally 中调用的函数执行，也就是说 return 语句先执行， finally 语句后执行，所以，返回的结果是 2。Return 并不是让函数马上返回，而是 return 语 句执行后，将把返回结果放置进函数栈中，此时函数并不是马上返回，它要执行 finally 语 句后才真正开始返回。

在讲解答案时可以用下面的程序来帮助分析：

```java
**public  class** Test {

 

/**

\* **@param** args add by zxx ,Dec 9, 2008

*/

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub System.*out*.println(**new** Test().test());;

}

 

**int** test()

{


 

**try**

{

 

}


 



 

 

**return** func1();


 

**finally**

{

**return** func2();

}

}

 

**int** func1()

{

System.*out*.println("func1");

**return** 1;

}

**int** func2()

{

System.*out*.println("func2");

**return** 2;

}

}

-----------执行结果-----------------

 

func1 func2 2
```

 

结论：finally 中的代码比 return 和 break 语句后执行

 

 

# 40、final, finally, finalize 的区别。

 

final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。 内部类要访问局部变量，局部变量必须定义成 final 类型，例如，一段代码……

 

finally 是异常处理语句结构的一部分，表示总是执行。

 

 

finalize 是 Object 类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法， 可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。JVM 不保证此方 法总被调用

 

 

# 41、运行时异常与一般异常有何异同？

 

异常表示程序运行过程中可能出现的非正常状态，运行时异常表示虚拟机的通常操作中可能 遇到的异常，是一种常见运行错误。java 编译器要求方法必须声明抛出可能发生的非运行时




异常，但是并不要求必须声明抛出未被捕获的运行时异常。

 

# 42、error 和 exception 有什么区别?

 

error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指 望程序能处理这样的情况。 exception 表示一种设计或实现问题。也就是说，它表示如果程 序运行正常，从不会发生的情况。

 

 

# 43、Java 中的异常处理机制的简单原理和应用。

 

异常是指 java 程序运行时（非编译）所发生的非正常情况或错误，与现实生活中的事件很 相似，现实生活中的事件可以包含事件发生的时间、地点、人物、情节等信息，可以用一个 对象来表示，Java 使用面向对象的方式来处理异常，它把程序中发生的每个异常也都分别封 装到一个对象来表示的，该对象中包含有异常的信息。

Java 对异常进行了分类，不同类型的异常分别用不同的 Java 类表示，所有异常的根类为 java.lang.Throwable，Throwable 下面又派生了两个子类：Error 和 Exception，Error 表示应 用程序本身无法克服和恢复的一种严重问题，程序只有死的份了，例如，说内存溢出和线程 死锁等系统问题。Exception 表示程序还能够克服和恢复的问题，其中又分为系统异常和普 通异常，系统异常是软件本身缺陷所导致的问题，也就是软件开发人员考虑不周所导致的问 题，软件使用者无法克服和恢复这种问题，但在这种问题下还可以让软件系统继续运行或者 让软件死掉 ，例如，数 组脚本越界 （ ArrayIndexOutOfBoundsException ），空指针异 常

（NullPointerException）、类转换异常（ClassCastException）；普通异常是运行环境的变化或 异常所导致的问题，是用户能够克服的问题，例如，网络断线，硬盘空间不够，发生这样的 异常后，程序不应该死掉。

java 为系统异常和普通异常提供了不同的解决方案，编译器强制普通异常必须 try..catch 处 理或用 throws 声明继续抛给上层调用方法处理，所以普通异常也称为 checked 异常，而系统 异常可以处理也可以不处理，所以，编译器不强制用 try..catch 处理或用 throws 声明，所以 系统异常也称为 unchecked 异常。

 

提示答题者：就按照三个级别去思考：虚拟机必须宕机的错误，程序可以死掉也可以不死掉 的错误，程序不应该死掉的错误；

 

# 44、请写出你最常见到的 5 个 runtime exception。

 

这道题主要考你的代码量到底多大，如果你长期写代码的，应该经常都看到过一些系统方面的异常， 你不一定真要回答出 5 个具体的系统异常，但你要能够说出什么是系统异常，以及几个系统异常就可以了， 当然，这些异常完全用其英文名称来写是最好的，如果实在写不出，那就用中文吧，有总比没有强！

所谓系统异常，就是…..，它们都是 RuntimeException 的子类，在 jdk doc 中查 RuntimeException 类， 就可以看到 其 所有的子类 列 表，也就是 看 到了所有的 系 统异常。我 比 较有印象的 系 统异常有： NullPointerException、ArrayIndexOutOfBoundsException、ClassCastException。




# 45 、 JAVA   语 言 如 何 进 行 异 常 处 理 ， 关 键 字 ：

**throws,throw,try,catch,finally** **分别代表什么意义？在** **try** **块 中可以抛出异常吗？**

 

# 46、java 中有几种方法可以实现一个线程？用什么关键字修 饰同步方法? stop()和 suspend()方法为何不推荐使用？

 

java5 以前，有如下两种： 第一种：

new Thread(){}.start();这表示调用 Thread 子类对象的 run 方法，new Thread(){}表示一个 Thread 的匿名子类的实例对象，子类加上 run 方法后的代码如下：

new Thread(){ public void run(){

}

}.start();

 

第二种：

new Thread(new Runnable(){}).start();这表示调用 Thread 对象接受的 Runnable 对象的 run 方法，new Runnable(){}表示一个 Runnable 的匿名子类的实例对象,runnable 的子类加 上 run 方法后的代码如下：

```java
new Thread(new Runnable(){

public void run(){

}

}

).start();

 

 

 

从 java5 开始，还有如下一些线程池创建多线程的方式： ExecutorService pool = Executors.newFixedThreadPool(3) for(int i=0;i<10;i++)

{

pool.execute(new Runable(){public void run(){}});

}

Executors.newCachedThreadPool().execute(new Runable(){public void run(){}}); Executors.newSingleThreadExecutor().execute(new Runable(){public void run(){}});
```

 

 

 

 

有两种实现方法，分别使用 new Thread()和 new Thread(runnable)形式，第一种直接调用




thread 的 run 方法，所以，我们往往使用 Thread 子类，即 new SubThread()。第二种调 用 runnable 的 run 方法。

 

有两种实现方法，分别是继承 Thread 类与实现 Runnable 接口 用 synchronized 关键字修饰同步方法

反对使用 stop()，是因为它不安全。它会解除由线程获取的所有锁定，而且如果对象处 于一种不连贯状态，那么其他线程能在那种状态下检查和修改它们。结果很难检查出 真正的问题所在。suspend()方法容易发生死锁。调用 suspend()的时候，目标线程会停 下来，但却仍然持有在这之前获得的锁定。此时，其他任何线程都不能访问锁定的资 源，除非被"挂起"的线程恢复运行。对任何线程来说，如果它们想恢复目标线程，同 时又试图使用任何一个锁定的资源，就会造成死锁。所以不应该使用 suspend()，而应 在自己的 Thread 类中置入一个标志，指出线程应该活动还是挂起。若标志指出线程应 该挂起，便用 wait()命其进入等待状态。若标志指出线程应当恢复，则用一个 notify() 重新启动线程。

 

# 47、sleep()  和 wait() 有什么区别?

 

（网上的答案：sleep 是线程类（Thread）的方法，导致此线程暂停执行指定时间，给 执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。调用 sleep 不会释放对 象锁。 wait 是 Object 类的方法，对此对象调用 wait 方法导致本线程放弃对象锁，进入等待 此对象的等待锁定池，只有针对此对象发出 notify 方法（或 notifyAll）后本线程才进入对象 锁定池准备获得对象锁进入运行状态。）

 

sleep 就是正在执行的线程主动让出 cpu，cpu 去执行其他线程，在 sleep 指定的时间过 后，cpu 才会回到这个线程上继续往下执行，如果当前线程进入了同步锁，sleep 方法并不会 释放锁，即使当前线程使用 sleep 方法让出了 cpu，但其他被同步锁挡住了的线程也无法得 到执行。wait 是指在一个已经进入了同步锁的线程内，让自己暂时让出同步锁，以便其他正 在等待此锁的线程可以得到同步锁并运行，只有其他线程调用了 notify 方法（notify 并不释 放锁，只是告诉调用过 wait 方法的线程可以去参与获得锁的竞争了，但不是马上得到锁， 因为锁还在别人手里，别人还没释放。如果 notify 方法后面的代码还有很多，需要这些代码 执行完后才会释放锁，可以在 notfiy 方法后增加一个等待和一些代码，看看效果），调用 wait 方法的线程就会解除 wait 状态和程序可以再次得到锁后继续向下运行。对于 wait 的讲解一 定要配合例子代码来说明，才显得自己真明白。

```java
**package** com.huawei.interview;

 

**public class** MultiThread {

 

/**

\* **@param** args

*/

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub **new** Thread(**new** Thread1()).start(); **try** {


 

Thread.*sleep*(10);

} **catch** (InterruptedException e) {

// **TODO** Auto-generated catch block e.printStackTrace();

}

**new** Thread(**new** Thread2()).start();

}

 

 

 

**private static class** Thread1 **implements** Runnable

{

 

@Override

**public void** run() {

// **TODO** Auto-generated method stub

//由于这里的Thread1和下面的Thread2内部run方法要用同一对象作为监视器，我们这里不 能用this，因为在Thread2里面的this和这个Thread1的this不是同一个对象。我们用 MultiThread.class这个字节码对象，当前虚拟机里引用这个变量时，指向的都是同一个对 象。

**synchronized** (MultiThread.**class**) { System.*out*.println("enter thread1...");

System.*out*.println("thread1 is waiting");

**try** {

//释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开了 synchronized关键字管辖的代码范围，另一种方式就是在synchronized关键字管辖的代码 内部调用监视器对象的wait方法。这里，使用wait方法释放锁。

MultiThread.**class**.wait();

} **catch** (InterruptedException e) {

// **TODO** Auto-generated catch block e.printStackTrace();

}

 

System.*out*.println("thread1 is going on..."); System.*out*.println("thread1 is being over!");

}

}

 

}

 

**private static class** Thread2 **implements** Runnable

{


 

@Override

**public void** run() {

// **TODO** Auto-generated method stub

**synchronized** (MultiThread.**class**) { System.*out*.println("enter thread2...");

System.*out*.println("thread2 notify other thread can release wait status..");

//由于notify方法并不释放锁， 即使thread2调用下面的sleep方法休息了10毫秒，但

thread1仍然不会执行，因为thread2没有释放锁，所以Thread1无法得不到锁。

 

MultiThread.**class**.notify();

 

System.*out*.println("thread2 is sleeping ten millisecond...");

**try** {

Thread.*sleep*(10);

} **catch** (InterruptedException e) {

// **TODO** Auto-generated catch block e.printStackTrace();

}

 

System.*out*.println("thread2 is going on..."); System.*out*.println("thread2 is being over!");

 

}

}

 

}

 

}

 
```

 

# 48、同步和异步有何异同，在什么情况下分别使用他们？举 例说明。

如果数据将在线程间共享。例如正在写的数据以后可能被另一个线程读到，或者正在读的数 据可能已经被另一个线程写过了，那么这些数据就是共享数据，必须进行同步存取。 当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方 法的返回时，就应该使用异步编程，在很多情况下采用异步途径往往更有效率。




# 49. 下面两个方法同步吗？（自己发明）

 

```java
class Test

{

**synchronized static void** sayHello3()

{

 

}


**synchronized void** getX(){}

}
```

 

# 50、多线程有几种实现方法?同步有几种实现方法?

 

多线程有两种实现方法，分别是继承 Thread 类与实现 Runnable 接口 同步的实现方面有两种，分别是 synchronized,wait 与 notify wait():使一个线程处于等待状态，并且释放所持有的对象的 lock。

sleep():使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要捕捉 InterruptedException 异常。

notify():唤醒一个处于等待状态的线程，注意的是在调用此方法的时候，并不能确切的唤 醒某一个等待状态的线程，而是由 JVM 确定唤醒哪个线程，而且不是按优先级。 Allnotity():唤醒所有处入等待状态的线程，注意并不是给所有唤醒线程一个对象的锁，

而是让它们竞争。

 

 

 

 

# 51、启动一个线程是用 run()还是 start()? .

 

启动一个线程是调用 start()方法，使线程就绪状态，以后可以被调度为运行状态，一个 线程必须关联一些具体的执行代码，run()方法是该线程所关联的执行代码。

 

 

# 52、当一个线程进入一个对象的一个 synchronized 方法后， 其它线程是否可进入此对象的其它方法?

分几种情况：

1.其他方法前是否加了 synchronized 关键字，如果没加，则能。 2.如果这个方法内部调用了 wait，则可以进入其他 synchronized 方法。 3.如果其他个方法都加了 synchronized 关键字，并且内部没有调用 wait，则不能。 4.如果其他方法是 static，它用的同步锁是当前类的字节码，与非静态的方法不能




同步，因为非静态的方法用的是 this。

 

 

# 53、线程的基本概念、线程的基本状态以及状态之间的关系

 

一个程序中可以有多条执行线索同时执行，一个线程就是程序中的一条执行线索，每个 线程上都关联有要执行的代码，即可以有多段程序代码同时运行，每个程序至少都有 一个线程，即 main 方法执行的那个线程。如果只是一个 cpu，它怎么能够同时执行多 段程序呢？这是从宏观上来看的，cpu 一会执行 a 线索，一会执行 b 线索，切换时间 很快，给人的感觉是 a,b 在同时执行，好比大家在同一个办公室上网，只有一条链接 到外部网线，其实，这条网线一会为 a 传数据，一会为 b 传数据，由于切换时间很短 暂，所以，大家感觉都在同时上网。

 

状态：就绪，运行，synchronize 阻塞，wait 和 sleep 挂起，结束。wait 必须在 synchronized

内部调用。

调用线程的 start 方法后线程进入就绪状态，线程调度系统将就绪状态的线程转为运行 状态，遇到 synchronized 语句时，由运行状态转为阻塞，当 synchronized 获得锁后， 由阻塞转为运行，在这种情况可以调用 wait 方法转为挂起状态，当线程关联的代码执 行完后，线程变为结束状态。

 

 

# 54、简述 synchronized 和 java.util.concurrent.locks.Lock 的 异同 ？

主要相同点：Lock 能完成 synchronized 所实现的所有功能

主要不同点：Lock 有比 synchronized 更精确的线程语义和更好的性能。synchronized 会 自动释放锁，而 Lock 一定要求程序员手工释放，并且必须在 finally 从句中释放。Lock 还有更强大的功能，例如，它的 tryLock 方法可以非阻塞方式去拿锁。

举例说明（对下面的题用 lock 进行了改写）：

```java
**package** com.huawei.interview;

 

**import** java.util.concurrent.locks.Lock;

**import** java.util.concurrent.locks.ReentrantLock;

 

**public class** ThreadTest {

 

/**

\* **@param** args

*/

 

**private int** j;


 

**private** Lock lock = **new** ReentrantLock();

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub ThreadTest tt = **new** ThreadTest(); **for**(**int** i=0;i<2;i++)

{

**new** Thread(tt.**new** Adder()).start();

**new** Thread(tt.**new** Subtractor()).start();

}

}

 

**private class** Subtractor **implements** Runnable

{

 

@Override

**public void** run() {

// **TODO** Auto-generated method stub

**while**(**true**)

{

/*synchronized (ThreadTest.this) { System.out.println("j--=" + j--);

//这里抛异常了，锁能释放吗？

}*/ lock.lock(); **try**

{

System.*out*.println("j--=" + j--);

}**finally**

{

lock.unlock();

}

}

}

 

}

 

**private class** Adder **implements** Runnable

{

 

@Override

**public void** run() {

// **TODO** Auto-generated method stub

**while**(**true**)

{


 

/*synchronized (ThreadTest.this) { System.out.println("j++=" + j++);

}*/ lock.lock(); **try**

{

System.*out*.println("j++=" + j++);

}**finally**

{

lock.unlock();

}

}

}

 

}

}

 
```



# 55、设计 4 个线程，其中两个线程每次对 j 增加 1，另外两 个线程对 j 每次减少 1。写出程序。

以下程序使用内部类实现线程，对 j 增减的时候没有考虑顺序问题。

```java
public class ThreadTest1

{

private int j;

public static void main(String args[]){ ThreadTest1 tt=new ThreadTest1(); Inc inc=tt.new Inc();

Dec dec=tt.new Dec(); for(int i=0;i<2;i++){

Thread t=new Thread(inc); t.start();

t=new Thread(dec); t.start();

}

}

private synchronized void inc(){ j++;

System.out.println(Thread.currentThread().getName()+"-inc:"+j);

}

private synchronized void dec(){ j--;

System.out.println(Thread.currentThread().getName()+"-dec:"+j);

}


 

class Inc implements Runnable{ public void run(){

for(int i=0;i<100;i++){ inc();

}

}

}

class Dec implements Runnable{ public void run(){

for(int i=0;i<100;i++){ dec();

}

}

}

}

 

----------随手再写的一个-------------

class A

{

JManger j =new JManager(); main()

{

new A().call();

}

 

void call

{

for(int i=0;i<2;i++)

{

new Thread(

new Runnable(){ public void run(){while(true){j.accumulate()}}}

).start();

new Thread(new Runnable(){ public void run(){while(true){j.sub()}}}).start();

}

}

}

 

class JManager

{

private j = 0;

 

public synchronized void subtract()

{

j--


 

}

 

public synchronized void accumulate()

{

j++;

}

 

}

```



# 56、子线程循环 10 次，接着主线程循环 100，接着又回到子 线程循环 10 次，接着再回到主线程又循环 100，如此循环 50 次，请写出程序。

 

最终的程序代码如下：

```java
**public class** ThreadTest {

 

/**

\* **@param** args

*/

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub

**new** ThreadTest().init();

 

}

 

**public void** init()

{

**final** Business business = **new** Business();

**new** Thread(

**new** Runnable()

{

 

**public void** run() {

**for**(**int** i=0;i<50;i++)

{

business.SubThread(i);

}

}

 

}


 

 

).start();

 

**for**(**int** i=0;i<50;i++)

{

business.MainThread(i);

}

}

 

**private class** Business

{

**boolean** bShouldSub = **true**;//这里相当于定义了控制该谁执行的一个信号灯 **public synchronized void** MainThread(**int** i)

{

**if**(bShouldSub) **try** {

**this**.wait();

} **catch** (InterruptedException e) {

// **TODO** Auto-generated catch block e.printStackTrace();

}

 

**for**(**int** j=0;j<5;j++)

{

System.*out*.println(Thread.*currentThread*().getName() + ":i=" + i +",j=" + j);

}

bShouldSub = **true**; **this**.notify();

 

}

 

 

 

**public synchronized void** SubThread(**int** i)

{

**if**(!bShouldSub) **try** {

**this**.wait();

} **catch** (InterruptedException e) {

// **TODO** Auto-generated catch block e.printStackTrace();

}

 

**for**(**int** j=0;j<10;j++)


 

{

System.*out*.println(Thread.*currentThread*().getName() +

":i=" + i +",j=" + j);

}

bShouldSub = **false**; **this**.notify();

}

}

}
```

 

备注：不可能一上来就写出上面的完整代码，最初写出来的代码如下，问题在于两个线程的代码 要参照同一个变量，即这两个线程的代码要共享数据，所以，把这两个线程的执行代码搬到同一 个类中去：

 

```java
**package** com.huawei.interview.lym;

 

**public class** ThreadTest {

 

**private static boolean** *bShouldMain* = **false**;

 

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub

/*new Thread(){ public void run()

{

for(int i=0;i<50;i++)

{

for(int j=0;j<10;j++)

{

System.out.println("i=" + i + ",j=" + j);

}

}

}

 

}.start();*/

 

 

 

//final String str = new String("");

 

**new** Thread(

**new** Runnable()

{

**public void** run()

{


 

**for**(**int** i=0;i<50;i++)

{

**synchronized** (ThreadTest.**class**) {

**if**(*bShouldMain*)

{

**try** {

ThreadTest.**class**.wait();}

**catch** (InterruptedException e) { e.printStackTrace();

}

}

**for**(**int** j=0;j<10;j++)

{

System.*out*.println(

 


 

Thread.*currentThread*().getName() +

 

}


 



"i=" + i + ",j=" + j);


 

 

 

 

 

 

 

}

}

).start();


 

*bShouldMain* = **true**; ThreadTest.**class**.notify();

}

}


 

 

**for**(**int** i=0;i<50;i++)

{

**synchronized** (ThreadTest.**class**) {

**if**(!*bShouldMain*)

{

**try** {

ThreadTest.**class**.wait();}

**catch** (InterruptedException e) { e.printStackTrace();

}

}

**for**(**int** j=0;j<5;j++)

{

System.*out*.println(

Thread.*currentThread*().getName() +

 

"i=" + i + ",j=" + j);

}


 

*bShouldMain* = **false**; ThreadTest.**class**.notify();

}

}

}

 

}
```

下面使用 jdk5 中的并发库来实现的：

```java
 import java.util.concurrent.Executors; import java.util.concurrent.ExecutorService; import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock; import java.util.concurrent.locks.Condition;

 

public class ThreadTest

{

private static Lock lock = new ReentrantLock();

private static Condition subThreadCondition = lock.newCondition(); private static boolean bBhouldSubThread = false;

public static void main(String [] args)

{

ExecutorService threadPool = Executors.newFixedThreadPool(3); threadPool.execute(new Runnable(){

public void run()

{

for(int i=0;i<50;i++)

{

lock.lock(); try

{

if(!bBhouldSubThread) subThreadCondition.await();

for(int j=0;j<10;j++)

{


 

 

j);


 

System.out.println(Thread.currentThread().getName() + ",j=" +

 

}


 

bBhouldSubThread = false; subThreadCondition.signal();

}catch(Exception e)

{

}

finally

{


 

lock.unlock();

}

}

}

 

});

threadPool.shutdown(); for(int i=0;i<50;i++)

{

lock.lock(); try

{

if(bBhouldSubThread)

subThreadCondition.await();

 

for(int j=0;j<10;j++)

{

System.out.println(Thread.currentThread().getName() + ",j=" + j);

}

bBhouldSubThread = true; subThreadCondition.signal();

}catch(Exception e)

{

}

finally

{

lock.unlock();

}

}

}

}
```

 

# 57、介绍 Collection 框架的结构

 

答：随意发挥题，天南海北谁便谈，只要让别觉得你知识渊博，理解透彻即可。

 

 

# 58、Collection 框架中实现比较要实现什么接口

 

comparable/comparator




# 59、ArrayList 和 Vector 的区别

 

答：

这两个类都实现了 List 接口（List 接口继承了 Collection 接口），他们都是有序集合，即存储 在这两个集合中的元素的位置都是有顺序的，相当于一种动态的数组，我们以后可以按位置 索引号取出某个元素，，并且其中的数据是允许重复的，这是 HashSet 之类的集合的最大不 同处，HashSet 之类的集合不可以按索引号去检索其中的元素，也不允许有重复的元素（本 来题目问的与 hashset 没有任何关系，但为了说清楚 ArrayList 与 Vector 的功能，我们使用对 比方式，更有利于说明问题）。

 

接着才说 ArrayList 与 Vector 的区别，这主要包括两个方面：.

（1）同步性：

Vector 是线程安全的，也就是说是它的方法之间是线程同步的，而 ArrayList 是线程序 不安全的，它的方法之间是线程不同步的。如果只有一个线程会访问到集合，那最好是使用 ArrayList，因为它不考虑线程安全，效率会高些；如果有多个线程会访问到集合，那最好是 使用 Vector，因为不需要我们自己再去考虑和编写线程安全的代码。

 

备注：对于 Vector&ArrayList、Hashtable&HashMap，要记住线程安全的问题，记住 Vector 与 Hashtable 是旧的，是 java 一诞生就提供了的，它们是线程安全的，ArrayList 与 HashMap 是 java2 时才提供的，它们是线程不安全的。所以，我们讲课时先讲老的。

（2）数据增长：

ArrayList 与 Vector 都有一个初始的容量大小，当存储进它们里面的元素的个数超过了 容量时，就需要增加 ArrayList 与 Vector 的存储空间，每次要增加存储空间时，不是只增加 一个存储单元，而是增加多个存储单元，每次增加的存储单元的个数在内存空间利用与程序 效率之间要取得一定的平衡。Vector 默认增长为原来两倍，而 ArrayList 的增长策略在文档 中没有明确规定（从源代码看到的是增长为原来的 1.5 倍）。ArrayList 与 Vector 都可以设置 初始的空间大小，Vector 还可以设置增长的空间大小，而 ArrayList 没有提供设置增长空间 的方法。

总结：即 Vector 增长原来的一倍，ArrayList 增加原来的 0.5 倍。

 

# 60、HashMap 和 Hashtable 的区别

 

（条理上还需要整理，也是先说相同点，再说不同点）

HashMap 是 Hashtable 的轻量级实现（非线程安全的实现），他们都完成了 Map 接口，主要 区别在于 HashMap 允许空（null）键值（key）,由于非线程安全，在只有一个线程访问的情 况下，效率要高于 Hashtable。

HashMap 允许将 null 作为一个 entry 的 key 或者 value，而 Hashtable 不允许。

HashMap 把 Hashtable 的 contains 方法去掉了，改成 containsvalue 和 containsKey。因为 contains

方法容易让人引起误解。

Hashtable 继承自 Dictionary 类，而 HashMap 是 Java1.2 引进的 Map interface 的一个实现。 最大的不同是，Hashtable 的方法是 Synchronize 的，而 HashMap 不是，在多个线程访问 Hashtable 时，不需要自己为它的方法实现同步，而 HashMap 就必须为之提供外同步。 Hashtable 和 HashMap 采用的 hash/rehash 算法都大概一样，所以性能不会有很大的差异。






就 HashMap 与 HashTable 主要从三方面来说。

一.历史原因:Hashtable 是基于陈旧的 Dictionary 类的，HashMap 是 Java 1.2 引进的 Map 接口 的一个实现

二.同步性:Hashtable 是线程安全的，也就是说是同步的，而 HashMap 是线程序不安全的， 不是同步的

三.值：只有 HashMap 可以让你将空值作为一个表的条目的 key 或 value

 

# 61、List  和 Map 区别?

 

一个是存储单列数据的集合，另一个是存储键和值这样的双列数据的集合，List 中存储的数 据是有顺序，并且允许重复；Map 中存储的数据是没有顺序的，其键是不能重复的，它的 值是可以有重复的。

 

# 62、List, Set, Map 是否继承自 Collection 接口?

 

List，Set 是，Map 不是

 

 

# 63、List、Map、Set 三个接口，存取元素时，各有什么特点？

 

这样的题属于随意发挥题：这样的题比较考水平，两个方面的水平：一是要真正明白这些内 容，二是要有较强的总结和表述能力。如果你明白，但表述不清楚，在别人那里则等同于不 明白。

 

首先，List 与 Set 具有相似性，它们都是单列元素的集合，所以，它们有一个功共同的父接 口，叫 Collection。Set 里面不允许有重复的元素，所谓重复，即不能有两个相等（注意，不 是仅仅是相同）的对象 ，即假设 Set 集合中有了一个 A 对象，现在我要向 Set 集合再存入 一个 B 对象，但 B 对象与 A 对象 equals 相等，则 B 对象存储不进去，所以，Set 集合的 add 方法有一个 boolean 的返回值，当集合中没有某个元素，此时 add 方法可成功加入该元素时， 则返回 true，当集合含有与某个元素 equals 相等的元素时，此时 add 方法无法加入该元素， 返回结果为 false。Set 取元素时，没法说取第几个，只能以 Iterator 接口取得所有的元素， 再逐一遍历各个元素。

List 表示有先后顺序的集合， 注意，不是那种按年龄、按大小、按价格之类的排序。 当我们多次调用 add(Obj e)方法时，每次加入的对象就像火车站买票有排队顺序一样，按先 来后到的顺序排序。有时候，也可以插队，即调用 add(int index,Obj e)方法，就可以指定当 前对象在集合中的存放位置。一个对象可以被反复存储进 List 中，每调用一次 add 方法，这 个对象就被插入进集合中一次，其实，并不是把这个对象本身存储进了集合中，而是在集合 中用一个索引变量指向这个对象，当这个对象被 add 多次时，即相当于集合中有多个索引指 向了这个对象，如图 x 所示。List 除了可以以 Iterator 接口取得所有的元素，再逐一遍历各 个元素之外，还可以调用 get(index i)来明确说明取第几个。

Map 与 List 和 Set 不同，它是双列的集合，其中有 put 方法，定义如下：put(obj key,obj




value)，每次存储时，要存储一对 key/value，不能存储重复的 key，这个重复的规则也是按 equals 比较相等。取则可以根据 key 获得相应的 value，即 get(Object key)返回值为 key 所对 应的 value。另外，也可以获得所有的 key 的结合，还可以获得所有的 value 的结合，还可以 获得 key 和 value 组合成的 Map.Entry 对象的集合。

 

List  以特定次序来持有元素，可有重复元素。Set  无法拥有重复元素,内部排序。Map  保存

key-value 值，value 可多值。

 

 

HashSet 按照 hashcode 值的某种运算方式进行存储，而不是直接按 hashCode 值的大小进行 存储。例如，"abc" ---> 78，"def" ---> 62，"xyz" ---> 65 在 hashSet 中的存储顺序不是 62,65,78， 这些问题感谢以前一个叫崔健的学员提出，最后通过查看源代码给他解释清楚，看本次培训 学员当中有多少能看懂源码。LinkedHashSet 按插入的顺序存储，那被存储对象的 hashcode 方法还有什么作用呢？学员想想!hashset 集合比较两个对象是否相等，首先看 hashcode 方法 是否相等，然后看 equals 方法是否相等。new 两个 Student 插入到 HashSet 中，看 HashSet 的 size，实现 hashcode 和 equals 方法后再看 size。

 

同一个对象可以在 Vector 中加入多次。往集合里面加元素，相当于集合里用一根绳子连接 到了目标对象。往 HashSet 中却加不了多次的。

 

 

# 64、说出 ArrayList,Vector, LinkedList 的存储性能和特性

 

ArrayList 和 Vector 都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增 加和插入元素，它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存 操作，所以索引数据快而插入数据慢，Vector 由于使用了 synchronized 方法（线程安全）， 通常性能上较 ArrayList 差，而 LinkedList 使用双向链表实现存储，按序号索引数据需要进 行前向或后向遍历，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快。

 

LinkedList 也是线程不安全的，LinkedList 提供了一些方法，使得 LinkedList 可以被当作堆 栈和队列来使用。

 

# 65、去掉一个 Vector 集合中重复的元素

 

Vector newVector = new Vector(); For (int i=0;i<vector.size();i++)

{

Object obj = vector.get(i); if(!newVector.contains(obj);

newVector.add(obj);

}

还有一种简单的方式，HashSet set = new HashSet(vector);




# 66、Collection  和 Collections 的区别。

 

Collection 是集合类的上级接口，继承与他的接口主要有 Set 和 List.

Collections 是针对集合类的一个帮助类，他提供一系列静态方法实现对各种集合的搜索、排 序、线程安全化等操作。

 

# 67、Set 里的元素是不能重复的，那么用什么方法来区分重 复与否呢?  是用==还是 equals()? 它们有何区别?

Set 里的元素是不能重复的，元素重复与否是使用 equals()方法进行判断的。 equals()和==方法决定引用值是否指向同一对象 equals()在类中被覆盖，为的是当两个分

离的对象的内容和类型相配的话，返回真值。

 

 

# 68、你所知道的集合类都有哪些？主要方法？

 

最常用的集合类是 List 和 Map。 List 的具体实现包括 ArrayList 和 Vector，它们是 可变大小的列表，比较适合构建、存储和操作任何类型对象的元素列表。 List 适用 于按数值索引访问元素的情形。

Map 提供了一个更通用的元素存储方法。 Map 集合类用于存储元素对（称作"键"和" 值"），其中每个键映射到一个值。

 




ArrayList/VectorList HashSet/TreeSetSet PropetiesHashTable

Treemap/HashMap






Collection

 

 

 

 

Map






我记的不是方法名，而是思想，我知道它们都有增删改查的方法，但这些方法的具体名称， 我记得不是很清楚，对于 set，大概的方法是 add,remove, contains；对于 map，大概的方法 就是 put,remove，contains 等，因为，我只要在 eclispe 下按点操作符，很自然的这些方法就 出来了。我记住的一些思想就是 List 类会有 get(int index)这样的方法，因为它可以按顺序取 元素，而 set 类中没有 get(int index)这样的方法。List 和 set 都可以迭代出所有元素，迭代时 先要得到一个 iterator 对象，所以，set 和 list 类都有一个 iterator 方法，用于返回那个 iterator 对象。map 可以返回三个集合，一个是返回所有的 key 的集合，另外一个返回的是所有 value 的集合，再一个返回的 key 和 value 组合成的 EntrySet 对象的集合，map 也有 get 方法，参 数是 key，返回值是 key 对应的 value。




# 69、两个对象值相同(x.equals(y) == true)，但却可有不同的

**hash code****，这句话对不对****?**

 

对。

如果对象要保存在 HashSet 或 HashMap 中，它们的 equals 相等，那么，它们的 hashcode 值 就必须相等。

如果不是要保存在 HashSet 或 HashMap，则与 hashcode 没有什么关系了，这时候 hashcode 不等是可以的，例如 arrayList 存储的对象就不用实现 hashcode，当然，我们没有理由不实 现，通常都会去实现的。

 

# 70、TreeSet 里面放对象，如果同时放入了父类和子类的实 例对象，那比较时使用的是父类的 compareTo 方法，还是使 用的子类的 compareTo 方法，还是抛异常！

（应该是没有针对问题的确切的答案，当前的 add 方法放入的是哪个对象，就调用哪个对象 的 compareTo 方法，至于这个 compareTo 方法怎么做，就看当前这个对象的类中是如何编写 这个方法的）

实验代码：

```java
**public class** Parent **implements** Comparable {

**private int** age = 0;

**public** Parent(**int** age){

**this**.age = age;

}

**public int** compareTo(Object o) {

// **TODO** Auto-generated method stub System.*out*.println("method of parent"); Parent o1 = (Parent)o;

**return** age>o1.age?1:age<o1.age?-1:0;

}

 

}

 

**public class** Child **extends** Parent {

 

**public** Child(){

**super**(3);

}

**public int** compareTo(Object o) {

 

// **TODO** Auto-generated method stub


 

System.*out*.println("method of child");

//         Child o1 = (Child)o;

**return** 1;

 

}

}

 

**public class** TreeSetTest {

 

/**

\* **@param** args

*/

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub TreeSet set = **new** TreeSet(); set.add(**new** Parent(3)); set.add(**new** Child());

set.add(**new** Parent(4)); System.*out*.println(set.size());

}

 

}
```



# 71、说出一些常用的类，包，接口，请各举 5 个

 

要让人家感觉你对java ee开发很熟，所以，不能仅仅只列core java中的那些东西，要多列你 在做ssh项目中涉及的那些东西。就写你最近写的那些程序中涉及的那些类。

 

常用的类：BufferedReader    BufferedWriter   FileReader    FileWirter   String    Integer java.util.Date，System，Class，List,HashMap

 

常用的包：java.lang     java.io    java.util

java.sql ,javax.servlet,org.apache.strtuts.action,org.hibernate

常用的接口：Remote    List    Map    Document

NodeList ,Servlet,HttpServletRequest,HttpServletResponse,Transaction(Hibernate)、 Session(Hibernate),HttpSession

 

# 72、java 中有几种类型的流？JDK 为每种类型的流提供了一 些抽象类以供继承，请说出他们分别是哪些类？

字 节 流，字 符 流。字 节 流继承 于 InputStream  OutputStream ，字符 流 继承于 




InputStreamReader OutputStreamWriter。在 java.io 包中还有许多其他的流，主要是为了 提高性能和使用方便。

 

# 73、字节流与字符流的区别

 

要把一片二进制数据数据逐一输出到某个设备中，或者从某个设备中逐一读取一片二进 制数据，不管输入输出设备是什么，我们要用统一的方式来完成这些操作，用一种抽象的方 式进行描述，这个抽象描述方式起名为 IO 流，对应的抽象类为 OutputStream 和 InputStream ， 不同的实现类就代表不同的输入和输出设备，它们都是针对字节进行操作的。

在应用中，经常要完全是字符的一段文本输出去或读进来，用字节流可以吗？计算机中 的一切最终都是二进制的字节形式存在。对于“中国”这些字符，首先要得到其对应的字节， 然后将字节写入到输出流。读取时，首先读到的是字节，可是我们要把它显示为字符，我们 需要将字节转换成字符。由于这样的需求很广泛，人家专门提供了字符流的包装类。

底层设备永远只接受字节数据，有时候要写字符串到底层设备，需要将字符串转成字节再 进行写入。字符流是字节流的包装，字符流则是直接接受字符串，它内部将串转成字节，再 写入底层设备，这为我们向 IO 设别写入或读取字符串提供了一点点方便。

字符向字节转换时，要注意编码的问题，因为字符串转成字节数组， 其实是转成该字符的某种编码的字节形式，读取也是反之的道理。

 

讲解字节流与字符流关系的代码案例：

```java
import java.io.BufferedReader; import java.io.FileInputStream; import java.io.FileOutputStream; import java.io.FileReader; import java.io.FileWriter;

import java.io.InputStreamReader; import java.io.PrintWriter;

 

public class IOTest {

public static void main(String[] args) throws Exception { String str = "中国人";

/*FileOutputStream fos    = new FileOutputStream("1.txt");

 

fos.write(str.getBytes("UTF-8")); fos.close();*/

 

/*FileWriter fw = new FileWriter("1.txt"); fw.write(str);

fw.close();*/

PrintWriter pw = new PrintWriter("1.txt","utf-8"); pw.write(str);

pw.close();

 

/*FileReader fr = new FileReader("1.txt");


 

char[] buf = new char[1024]; int len = fr.read(buf);

String myStr = new String(buf,0,len); System.out.println(myStr);*/

/*FileInputStream fr = new FileInputStream("1.txt"); byte[] buf = new byte[1024];

int len = fr.read(buf);

String myStr = new String(buf,0,len,"UTF-8"); System.out.println(myStr);*/

BufferedReader br = new BufferedReader( new InputStreamReader(

new FileInputStream("1.txt"),"UTF-8"

)

);

String myStr = br.readLine(); br.close(); System.out.println(myStr);

}

 

}
```

 

# 74、什么是 java 序列化，如何实现 java 序列化？或者请解 释 Serializable 接口的作用。

 

我们有时候将一个 java 对象变成字节流的形式传出去或者从一个字节流中恢复成一个 java 对象，例如，要将 java 对象存储到硬盘或者传送给网络上的其他计算机，这个过程 我们可以自己写代码去把一个 java 对象变成某个格式的字节流再传输，但是，jre 本身 就提供了这种支持，我们可以调用 OutputStream 的 writeObject 方法来做，如果要让 java 帮我们做，要被传输的对象必须实现 serializable 接口，这样，javac 编译时就会进行特 殊处理，编译的类才可以被 writeObject 方法操作，这就是所谓的序列化。需要被序列化 的类必须实现 Serializable 接口，该接口是一个 mini 接口，其中没有需要实现的方法， implements Serializable 只是为了标注该对象是可被序列化的。

 

 

例如，在 web 开发中，如果对象被保存在了 Session 中，tomcat 在重启时要把 Session 对象序列化到硬盘，这个对象就必须实现 Serializable 接口。如果对象要经过分布式系统 进行网络传输或通过 rmi 等远程调用，这就需要在网络上传输对象，被传输的对象就必 须实现 Serializable 接口。




# 75、描述一下 JVM 加载 class 文件的原理机制?

 

JVM 中类的装载是由 ClassLoader 和它的子类来实现的,Java  ClassLoader 是一个重要的

Java 运行时系统组件。它负责在运行时查找和装入类文件的类。

 

 

# 76、heap 和 stack 有什么区别。

 

java 的内存分为两类，一类是栈内存，一类是堆内存。栈内存是指程序进入一个方法时， 会为这个方法单独分配一块私属存储空间，用于存储这个方法内部的局部变量，当这 个方法结束时，分配给这个方法的栈会释放，这个栈中的变量也将随之释放。

堆是与栈作用不同的内存，一般用于存放不放在当前方法栈中的那些数据，例如，使用 new 创建的对象都放在堆里，所以，它不会随方法的结束而消失。方法中的局部变量 使用 final 修饰后，放在堆中，而不是栈中。

 

 

# 77、GC 是什么?  为什么要有 GC?

 

GC 是垃圾收集的意思（Gabage Collection）,内存处理是编程人员容易出现问题的地方， 忘记或者错误的内存回收会导致程序或系统的不稳定甚至崩溃，Java 提供的 GC 功能 可以自动监测对象是否超过作用域从而达到自动回收内存的目的，Java 语言没有提供 释放已分配内存的显示操作方法。

 

 

# 78、垃圾回收的优点和原理。并考虑 2 种回收机制。

 

Java 语言中一个显著的特点就是引入了垃圾回收机制，使 c++程序员最头疼的内存管理 的问题迎刃而解，它使得 Java 程序员在编写程序的时候不再需要考虑内存管理。由于 有个垃圾回收机制，Java 中的对象不再有"作用域"的概念，只有对象的引用才有"作用 域"。垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存。垃圾回收器通 常是作为一个单独的低级别的线程运行，不可预知的情况下对内存堆中已经死亡的或 者长时间没有使用的对象进行清楚和回收，程序员不能实时的调用垃圾回收器对某个 对象或所有对象进行垃圾回收。回收机制有分代复制垃圾回收和标记垃圾回收，增量 垃圾回收。

 

 

# 79、垃圾回收器的基本原理是什么？垃圾回收器可以马上回 收内存吗？有什么办法主动通知虚拟机进行垃圾回收？

对于 GC 来说，当程序员创建对象时，GC 就开始监控这个对象的地址、大小以及使用




情况。通常，GC 采用有向图的方式记录和管理堆(heap)中的所有对象。通过这种方式 确定哪些对象是"可达的"，哪些对象是"不可达的"。当 GC 确定一些对象为"不可达" 时，GC 就有责任回收这些内存空间。可以。程序员可以手动执行 System.gc()，通知 GC 运行，但是 Java 语言规范并不保证 GC 一定会执行。

 

 

 

# 80、什么时候用 assert。

 

assertion(断言)在软件开发中是一种常用的调试方式，很多开发语言中都支持这种机制。在 实现中，assertion 就是在程序中的一条语句，它对一个 boolean 表达式进行检查，一个正 确程序必须保证这个 boolean 表达式的值为 true；如果该值为 false，说明程序已经处于不 正确的状态下，assert 将给出警告或退出。一般来说，assertion 用于保证程序最基本、关 键的正确性。assertion 检查通常在开发和测试时开启。为了提高性能，在软件发布后， assertion 检查通常是关闭的。

```java
**package** com.huawei.interview;

 

**public class** AssertTest {

 

/**

\* **@param** args

*/

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub

**int** i = 0;

**for**(i=0;i<5;i++)

{

System.*out*.println(i);

}

//假设程序不小心多了一句--i;

--i;

**assert** i==5;

}

 

}
```

 

 

 

# 81、java 中会存在内存泄漏吗，请简单描述。

 

所谓内存泄露就是指一个不再被程序使用的对象或变量一直被占据在内存中。java 中有垃圾 回收机制，它可以保证一对象不再被引用的时候，即对象编程了孤儿的时候，对象将自动被 垃圾回收器从内存中清除掉。由于 Java 使用有向图的方式进行垃圾回收管理，可以消除引 用循环的问题，例如有两个对象，相互引用，只要它们和根进程不可达的，那么 GC 也是可




以回收它们的，例如下面的代码可以看到这种情况的内存回收：

```java
**package** com.huawei.interview; **import** java.io.IOException; **public class** GarbageTest {

/**

\*  **@param** args

\*  **@throws** IOException

*/

**public static void** main(String[] args) **throws** IOException {

// **TODO** Auto-generated method stub

**try** {

*gcTest*();

} **catch** (IOException e) {

// **TODO** Auto-generated catch block e.printStackTrace();

}

System.*out*.println("has exited gcTest!"); System.*in*.read();

System.*in*.read(); System.*out*.println("out begin gc!"); **for**(**int** i=0;i<100;i++)

{

System.*gc*(); System.*in*.read(); System.*in*.read();

}

}

 

**private static void** gcTest() **throws** IOException { System.*in*.read();

System.*in*.read();

Person p1 = **new** Person(); System.*in*.read(); System.*in*.read();

Person p2 = **new** Person(); p1.setMate(p2); p2.setMate(p1);

System.*out*.println("before exit gctest!"); System.*in*.read();

System.*in*.read(); System.*gc*();


 

System.*out*.println("exit gctest!");

}

 

**private static class** Person

{

**byte**[] data = **new byte**[20000000]; Person mate = **null**;

**public void** setMate(Person other)

{

mate = other;

}

}

}
```

 

java 中的内存泄露的情况：长生命周期的对象持有短生命周期对象的引用就很可能发生内存 泄露，尽管短生命周期对象已经不再需要，但是因为长生命周期对象持有它的引用而导致不 能被回收，这就是 java 中内存泄露的发生场景，通俗地说，就是程序员可能创建了一个对 象，以后一直不再使用这个对象，这个对象却一直被引用，即这个对象无用但是却无法被垃 圾回收器回收的，这就是 java 中可能出现内存泄露的情况，例如，缓存系统，我们加载了 一个对象放在缓存中(例如放在一个全局 map 对象中)，然后一直不再使用它，这个对象一直 被缓存引用，但却不再被使用。

检查 java 中的内存泄露，一定要让程序将各种分支情况都完整执行到程序结束，然后看某 个对象是否被使用过，如果没有，则才能判定这个对象属于内存泄露。

 

如果一个外部类的实例对象的方法返回了一个内部类的实例对象，这个内部类对象被长期引 用了，即使那个外部类实例对象不再被使用，但由于内部类持久外部类的实例对象，这个外 部类对象将不会被垃圾回收，这也会造成内存泄露。

 

下面内容来自于网上（主要特点就是清空堆栈中的某个元素，并不是彻底把它从数组中拿掉， 而是把存储的总数减少，本人写得可以比这个好，在拿掉某个元素时，顺便也让它从数组中 消失，将那个元素所在的位置的值设置为 null 即可）：

 

我实在想不到比那个堆栈更经典的例子了,以致于我还要引用别人的例子，下面 的例子不是我想到的，是书上看到的，当然如果没有在书上看到，可能过一段时 间我自己也想的到，可是那时我说是我自己想到的也没有人相信的。

 

```java
public class Stack {

private Object[] elements=new Object[10]; private int size = 0;

public void push(Object e){ ensureCapacity(); elements[size++] = e;

}


 

public Object pop(){ if( size == 0)

 

throw new EmptyStackException(); return elements[--size];

}

private void ensureCapacity(){ if(elements.length == size){ Object[] oldElements = elements;

elements = new Object[2 * elements.length+1]; System.arraycopy(oldElements,0, elements, 0, size);

}

}

}
```

上面的原理应该很简单，假如堆栈加了 10 个元素，然后全部弹出来，虽然 堆栈是空的，没有我们要的东西，但是这是个对象是无法回收的，这个才符合了 内存泄露的两个条件：无用，无法回收。

 

但是就是存在这样的东西也不一定会导致什么样的后果，如果这个堆栈用的 比较少，也就浪费了几个 K 内存而已，反正我们的内存都上 G 了，哪里会有什么 影响，再说这个东西很快就会被回收的，有什么关系。下面看两个例子。

 

例子 1

```java
public class Bad{

public static Stack s=Stack(); static{

s.push(new Object());

s.pop(); //这里有一个对象发生内存泄露

s.push(new Object()); //上面的对象可以被回收了，等于是自愈了

}

}
```

因为是 static，就一直存在到程序退出，但是我们也可以看到它有自愈功 能，就是说如果你的 Stack 最多有 100 个对象，那么最多也就只有 100 个对象无 法被回收其实这个应该很容易理解，Stack 内部持有 100 个引用，最坏的情况就 是他们都是无用的，因为我们一旦放新的进取，以前的引用自然消失！

 

 

内存泄露的另外一种情况：当一个对象被存储进 HashSet 集合中以后，就不能修改这个 对象中的那些参与计算哈希值的字段了，否则，对象修改后的哈希值与最初存储进 HashSet 集合中时的哈希值就不同了，在这种情况下，即使在 contains 方法使用该对象的当前引用 作为的参数去 HashSet 集合中检索对象，也将返回找不到对象的结果，这也会导致无法从 HashSet 集合中单独删除当前对象，造成内存泄露。




# 82、能不能自己写个类，也叫 java.lang.String？

 

可以，但在应用的时候，需要用自己的类加载器去加载，否则，系统的类加载器永远只是去 加载jre.jar包中的那个java.lang.String。由于在tomcat的web应用程序中，都是由webapp自己 的类加载器先自己加载WEB-INF/classess目录中的类，然后才委托上级的类加载器加载，如 果我们在tomcat的web应用程序中写一个java.lang.String，这时候Servlet程序加载的就是我们 自己写的java.lang.String，但是这么干就会出很多潜在的问题，原来所有用了java.lang.String 类的都将出现问题。

 

虽然java提供了endorsed技术，可以覆盖jdk中的某些类，具体做法是….。但是，能够被覆盖 的类是有限制范围，反正不包括java.lang这样的包中的类。

 

（下面的例如主要是便于大家学习理解只用，不要作为答案的一部分，否则，人家怀疑是题 目泄露了）例如，运行下面的程序：

```java
**package** java.lang;

 

**public class** String {

 

/**

\* **@param** args

*/

**public static void** main(String[] args) {

// **TODO** Auto-generated method stub System.*out*.println("string");

}

 

}
```

报告的错误如下： java.lang.NoSuchMethodError: main Exception in thread "main"

这是因为加载了jre自带的java.lang.String，而该类中没有main方法。

 

 

# 83. Java 代码查错

 

1.

abstract class Name { private String name;

public abstract boolean isStupidName(String name) {}

}

大侠们，这有何错误?

答案:  错。abstract method 必须以分号结尾，且不带花括号。




2.

public class Something { void doSomething () { private String s = "";

int l = s.length();

}

}

有错吗?

答案: 错。局部变量前不能放置任何访问修饰符 (private，public，和 protected)。final 可以 用来修饰局部变量

(final 如同 abstract 和 strictfp，都是非访问修饰符，strictfp  只能修饰 class 和 method 而非

variable)。 3.

abstract class Something {

private abstract String doSomething ();

}

这好像没什么错吧?

答案: 错。abstract 的 methods 不能以 private 修饰。abstract 的 methods 就是让子类 implement(实 现)具体细节的，怎么可以用 private 把 abstract

method 封锁起来呢? (同理，abstract method 前不能加 final)。 4.

public class Something {

public int addOne(final int x) { return ++x;

}

}

这个比较明显。

答案: 错。int x 被修饰成 final，意味着 x 不能在 addOne method 中被修改。

5.

```java
public class Something {

public static void main(String[] args) { Other o = new Other();

new Something().addOne(o);

}

public void addOne(final Other o) { o.i++;

}

}

class Other { public int i;

}
```

和上面的很相似，都是关于 final 的问题，这有错吗?

答案: 正确。在 addOne method 中，参数 o 被修饰成 final。如果在 addOne method 里我们修 改了 o 的 reference




(比如: o = new Other();)，那么如同上例这题也是错的。但这里修改的是 o 的 member vairable (成员变量)，而 o 的 reference 并没有改变。

6.

class Something { int i;

public void doSomething() { System.out.println("i = " + i);

}

}

有什么错呢? 看不出来啊。

答案: 正确。输出的是"i = 0"。int i 属於 instant variable (实例变量，或叫成员变量)。instant variable 有 default value。int 的 default value 是 0。

7.

class Something { final int i;

public void doSomething() { System.out.println("i = " + i);

}

}

和上面一题只有一个地方不同，就是多了一个 final。这难道就错了吗?

答案: 错。final int i 是个 final 的 instant variable (实例变量，或叫成员变量)。final 的 instant variable 没有 default value，必须在 constructor (构造器)结束之前被赋予一个明确的值。可以 修改为"final int i = 0;"。

8.

public class Something {

public static void main(String[] args) { Something s = new Something();

System.out.println("s.doSomething() returns " + doSomething());

}

public String doSomething() { return "Do something ...";

}

}

看上去很完美。

答案: 错。看上去在 main 里 call doSomething 没有什么问题，毕竟两个 methods 都在同一个 class 里。但仔细看，main 是 static 的。static method 不能直接 call non-static methods。可改 成"System.out.println("s.doSomething() returns " + s.doSomething());"。同理，static method 不 能访问 non-static instant variable。

9.

此处，Something 类的文件名叫 OtherThing.java class Something {

private static void main(String[] something_to_do) { System.out.println("Do something ...");

}




}

这个好像很明显。

答案: 正确。从来没有人说过 Java 的 Class 名字必须和其文件名相同。但 public class 的名字 必须和文件名相同。

10．

```java
 interface  A{

int x = 0;

}

class B{

int x =1;

}

class C extends B implements A { public void pX(){

System.out.println(x);

}

public static void main(String[] args) { new C().pX();

}

}
```

答案：错误。在编译时会发生错误(错误描述不同的 JVM 有不同的信息，意思就是未明确的 x 调用，两个 x 都匹配（就象在同时 import java.util 和 java.sql 两个包时直接声明 Date 一样）。 对于父类的变量,可以用 super.x 来明确，而接口的属性默认隐含为 public static final.所以可 以通过 A.x 来明确。

11.

```java
interface Playable { void play();

}

interface Bounceable { void play();

}

interface Rollable extends Playable, Bounceable { Ball ball = new Ball("PingPang");

}

class Ball implements Rollable { private String name;

public String getName() { return name;

}

public Ball(String name) { this.name = name;

}

public void play() {

ball = new Ball("Football"); System.out.println(ball.getName());


 

}

}
```

这个错误不容易发现。

答案: 错。"interface Rollable extends Playable, Bounceable"没有问题。interface 可继承多个 interfaces，所以这里没错。问题出在 interface Rollable 里的"Ball ball = new Ball("PingPang");"。 任何在 interface 里声明的 interface variable (接口变量，也可称成员变量)，默认为 public static final。也就是说"Ball ball = new Ball("PingPang");"实际上是"public static final Ball ball = new Ball("PingPang");"。在 Ball 类的 Play()方法中，"ball = new Ball("Football");"改变了 ball 的 reference，而这里的 ball 来自 Rollable interface，Rollable interface 里的 ball 是 public static final 的，final 的 object 是不能被改变 reference 的。因此编译器将在"ball = new Ball("Football");" 这里显示有错。

# 84、java的跨平台原理

- ## Java编译过程与C/C++编译过程的差异

  C/C++编译器生成一个对象的代码时，该代码是在某一特定硬件平台下运行而生成的。因此在编译过程中，编译程序通过查表将所有对符号的引用转换为特定的内存偏移量，以保证程序运行。

  Java编译时却不将对变量和方法的引用编译为数值引用，也不确定程序执行过程中的内存布局，而是将这些符号引用信息保留在字节码中，由解释器在运行过程中创建内存布局，然后再通过查表来确定一个方法所在的地址，这样就有效地保证了Java的可移植性和安全性

  C/C++源代码--机器码

  Java源代码--Java字节码--机器码

- ## 实现跨平台机制

  Java实现跨平台无非就是JVM起的作用，可以这样想，如果是C/C++的编译方式，一旦换了一个平台，那么我们就需要重新编译一份对应的可执行代码，但是Java则不同，我们编译好了一份Java字节码，换到不同的平台上时，并不需要重新编译，前提是这些平台上都装了相应平台的JVM，JVM不是跨平台的，但是这是Sun公司的工作：为不同平台提供对应的JVM。所以，实现跨平台的根本机制还是JVM

- ## Java解释器执行过程

  执行过程分为三步：代码的装入、代码的检验和代码的执行
  类加载器（ClassLoader)负责加载装入运行一个程序所需要的所有代码，这也包括程序代码中的类所继承的类和被其调用的类。当类装载器装入一个类时，该类被放 在自己的名字空间中。除了通过符号引用自己名字空间以外的类，类之间没有其他办法可以影响其他类。在本台计算机上的所有类都在同一地址空间内，而所有从外 部引进的类，都有一个自己独立的名字空间。这使得本地类通过共享相同的名字空间获得较高的运行效率，同时又保证它们与从外部引进的类不会相互影响。当装入 了运行程序需要的所有类后，解释器便可确定整个可执行程序的内存布局。解释器为符号引用同特定的地址空间建立对应关系及查询表。通过在这一阶段确定代码的 内存布局，Java很好地解决了由超类改变而使子类崩溃的问题，同时也防止了代码对地址的非法访问。
  随后，被装入的代码由字节码检验器进行检查，检验器可以检查出操作数栈溢出，非法数据类型等多种错误。通过校验后，代码就开始执行了。

  # 85、冒泡排序

  ```java
  N个数字来排序，两两比较小靠前，外层循环N-1，内层循环N-1-i（从小到大）
  Int[] nums = {a,b,c,d,e…}
  for(int i=0;i<nums.length-1;i++){
  	for(int j=0;j< nums.length-1-i;j++){
  		if(nums[j]>nums[j+1]){
  			int temp=nums[j];
  			nums[j] = nums[j+1];
  			nums[j+1]=temp;
  }
  }
  }
  从大到小）
  Int[] nums = {a,b,c,d,e…}
  for(int i=0;i<nums.length-1;i++){
  	for(int j=0;j< nums.length-1-i;j++){
  		if(nums[j]<nums[j+1]){
  			int temp=nums[j];
  			nums[j] = nums[j+1];
  			nums[j+1]=temp;
  }
  }
  }
  
  
  ```



  1. 原理：比较两个相邻的元素，将值大的元素交换至右端。

     思路：依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。重复第一趟步骤，直至全部排序完成。

     第一趟比较完成后，最后一个数一定是数组中最大的一个数，所以第二趟比较的时候最后一个数不参与比较；

     第二趟比较完成后，倒数第二个数也一定是数组中第二大的数，所以第三趟比较的时候最后两个数不参与比较；

     依次类推，每一趟比较次数-1；

     ……

     冒泡排序的优点：每进行一趟排序，就会少比较一次，因为每进行一趟排序都会找出一个较大值。如上例：第一趟比较之后，排在最后的一个数一定是最大的一个数，第二趟排序的时候，只需要比较除了最后一个数以外的其他的数，同样也能找出一个最大的数排在参与第二趟比较的数后面，第三趟比较的时候，只需要比较除了最后两个数以外的其他的数，以此类推……也就是说，没进行一趟比较，每一趟少比较一次，一定程度上减少了算法的量。



     https://www.cnblogs.com/shen-hua/p/5422676.html

  # 86、比较排序

  ```java
  获得最大最小值：
  	int[] nums = {11,45,23,4,78};
  	int max = nums[0];int min = nums[0];
  	for(int i=1;i<nums.lenght;i++){
  		if(nums[i]>max){
  			max = nums[i];
  }else if(nums[i]<mim){
  	min = nums[i];
  }		
  }
  
  ```



  1. 在java中，要给数据排序，有两种实现方式，分别实现两个接口：

     1. 一种是实现Comparable接口
     2. 另一种是实现Comparator接口

     　　在JDK类库中，有一部分类实现了Comparable接口,如Integer Double和String等。 
     　Comparable接口有一个comparTo(Object o)方法,它返回整数类型。对于表达式x.compareTo(y),如果返回值为0，则表示x和y相等,如果返回值大于0，则表示x大于y,如果返回值小于0，则表示x小于y.

      

     ![img](https://images2015.cnblogs.com/blog/625365/201606/625365-20160622191251688-1744267884.jpg)

      

     ​    查看Comparable接口源码

     ```java
     public interface Comparable<T> {
         public int compareTo(T o);
     }
     ```



# 87、插入排序

插入排序在实现上，在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

```java
置标记index=-1，遍历数组，若插入数字小于数组数字，index=i并跳出循环
移：如果找到即index!=-1将后一个数组元素等于前一个数组元素，
for(int i=nums.length-1;i>index;i++){nums[i]=nums[i-1]}, 
设置：nums[index]=num
如果未找到index=-1
Nums[nums.length-1] = num

```



# 88、3种基础循环结构的区别



|          | while                                          | do while                                   | for                                                 |
| -------- | ---------------------------------------------- | ------------------------------------------ | --------------------------------------------------- |
| 结构     | while（条件）｛循环体｝                        | do {循环体}while(条件)；                   | for(初始化变量；循环条件；循环变量的操作)｛循环体｝ |
| 特点     | x先判断后执行，可能一次都不执行，while后无分号 | x先执行后判断，最少执行一次，while后有分号 | 先判断，在执行                                      |
| 适用情况 | x循环不确定的情况                              | 循环不确定的情况                           | 循环次数确定的情况                                  |

# 89、continue、break、return的异同

break :跳出当前循环；但是如果是嵌套循环，则只能跳出当前的这一层循环，只有逐层break才能跳出所有循环；

continue:终止当前循环，但是不跳出循环（在循环中continue后面的语句是不会执行了），继续往下根据循环条件执行循环。

return

​    (1).return 从当前的方法中退出,返回到该调用的方法的语句处,继续执行。 
​    (2).return 返回一个值给调用该方法的语句，返回值的数据类型必须与方法的声明中的返回值的类型一致。 
​    (3). return后面也可以不带参数，不带参数就是返回空，其实主要目的就是用于想中断函数执行，返回调用函数处。

​      **特别注意：返回值为void的方法，从某个判断中跳出，必须用return**

# 90、==与equals方法的异同

**==**：本数据类型中表示比较两个值是否相同；比较引用数据类型时，表示比较两个对象的地址是否相同

**equals：**在比较出String类型以外的引用数据类型时，比较的是两个对象地址；String由于重写另外equals，所以String类型使用equals时比较的是两个String数据的值

（具体参见11点）

# 91、谈一谈封装

封装：是指一种将抽象性函式接口的实现细节部份包装、隐藏起来的方法。

###### 封装的优点

- \1. 良好的封装能够减少耦合。
- \2. 类内部的结构可以自由修改。
- \3. 可以对成员变量进行更精确的控制。
- \4. 隐藏信息，实现细节。

# 92、谈一谈继承

继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。

###### 继承的特性

- 子类拥有父类非private的属性，方法。

- 子类可以拥有自己的属性和方法，即子类可以对父类进行扩展。

- 子类可以用自己的方式实现父类的方法。

- Java的继承是单继承，但是可以多重继承，单继承就是一个子类只能继承一个父类，多重继承就是，例如A类继承B类，B类继承C类，所以按照关系就是C类是B类的父类，B类是A类的父类，这是java继承区别于C++继承的一个特性。

- 提高了类之间的耦合性（继承的缺点，耦合度高就会造成代码之间的联系越紧密，代码独立性越差）。

- 继承关键字

  继承可以使用 extends 和 implements 这两个关键字来实现继承，而且所有的类都是继承于 java.lang.Object，当一个类没有继承的两个关键字，则默认继承object（这个类在 **java.lang** 包中，所以不需要 **import**）祖先类。

  extends关键字

  在 Java 中，类的继承是单一继承，也就是说，一个子类只能拥有一个父类，所以 extends 只能继承一个类。

  implements关键字

  使用 implements 关键字可以变相的使java具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口（接口跟接口之间采用逗号分隔）。

# 93、谈一谈多态

多态是同一个行为具有多个不同表现形式或形态的能力。

多态就是同一个接口，使用不同的实例而执行不同操作

### 多态的优点

- \1. 消除类型之间的耦合关系

- \2. 可替换性

- \3. 可扩充性

- \4. 接口性

- \5. 灵活性

- \6. 简化性

- ### 多态存在的三个必要条件

  - 继承
  - 重写
  - 父类引用指向子类对象

# 94、方法重载与方法重写的异同

|          |  访问修饰符  | 返回值 | 方法名 | 参数列表 |
| :------: | :----------: | :----: | :----: | :------: |
| 方法重载 |     无关     |  无关  |  相同  |   不同   |
| 方法重写 | 不能严于父类 |  相同  |  相同  |   相同   |

# 95、抽象类与接口的异同

**抽象类：**使用abstract修饰；抽象方法可有可无；子类必须重写抽象父类的抽象方法，不然该子类也是抽象类；不能被实例化；有构造方法

**接口：**使用interface不能实现接口ace修饰；方法都是公共的抽象方法；属性是公共静态常量；不能被实例化；无构造方法；不能实现接口，可以继承多个接口，

# 96、final、finally、finalize的区别

**final****：**修饰变量为常量，修饰方法为最终方法不能被重写，修饰类为最终类不能被继承

**finally****：**在处理异常时，无论是否发生异常，最后都会执行finally的代码；有return的话先执行return，再执行finally

**finalize****：**finalize用于在GC（垃圾回收）发生前事先调用去回收JNI调用中申请的特殊内存，下次GC发生时候保证GC后所有该对象的内存都释放了。

垃圾回收器准备释放内存的时候，会先调用finalize()。

# 97、在java中如何最有效率的将数值10变成2



# 98、this与super的异同

**this****：**调用属性、方法、构造方法；调用构造方法都要在第一句；指代调用方法的对象，调用的是当前类的属性、方法、构造方法；区分局部和成员变量

**super****：**调用属性、方法、构造方法；调用构造方法都要在第一句；指代父类对象；调用的是父类的属性、方法、构造方法

​    "

# 99、 谈一谈java的异常处理机制

JAVA的异常处理机制：如果某个方法不能按照正常的途径完成任务，就可以通过另一种路径退出方法。在这种情况下会抛出一个封装了错误信息的对象。此时，这个方法会立刻退出同时不返回任何值。另外，调用这个方法的其他代码也无法继续执行，异常处理机制会将代码执行交给异常处理器。

抛出异常有三种形式，一是throw,一个throws，还有一种系统自动抛异常。

Throw和throws的区别： 

1. 位置不同：throws用在函数上，后面跟的是异常类，可以跟多个；而throw用在函数内，后面跟的是异常对象。 
2. 功能不同：throws用来声明异常，让调用者只知道该功能可能出现的问题，可以给出预先的处理方式；throw抛出具体的问题对象，执行到throw，功能就已经结束了，跳转到调用者，并将具体的问题对象抛给调用者。也就是说throw语句独立存在时，下面不要定义其他语句，因为执行不到。 
3. throws表示出现异常的一种可能性，并不一定会发生这些异常；throw则是抛出了异常，执行throw则一定抛出了某种异常对象。 
4. 两者都是消极处理异常的方式（这里的消极并不是说这种方式不好），只是抛出或者可能抛出异常，但是不会由函数去处理异常，真正的处理异常由函数的上层调用处理。 

# 100、谈一谈java的常见特性

**简单**
Java语言的语法与C语言和C++语言很接近，使得大多数程序员很容易学习和使用。另一方面，Java丢弃了C++中很少使用的、很难理解的、令人迷惑的那些特性，如操作符重载、多继承、自动的强制类型转换。特别地，Java语言不使用指针，而是引用。并提供了自动的废料收集，使得程序员不必为内存管理而担忧。
**面向对象**
Java语言提供类、接口和继承等面向对象的特性，为了简单起见，只支持类之间的单继承，但支持接口之间的多继承，并支持类与接口之间的实现机制（关键字为implements）。Java语言全面支持动态绑定，而C++语言只对虚函数使用动态绑定。总之，Java语言是一个纯的面向对象程序设计语言。
**分布式**
Java语言支持Internet应用的开发，在基本的Java应用编程接口中有一个网络应用编程接口（java net），它提供了用于网络应用编程的类库，包括URL、URLConnection、Socket、ServerSocket等。Java的RMI（远程方法激活）机制也是开发分布式应用的重要手段。
**健壮**
Java的强类型机制、异常处理、垃圾的自动收集等是Java程序健壮性的重要保证。对指针的丢弃是Java的明智选择。Java的安全检查机制使得Java更具健壮性。
**安全**
Java通常被用在网络环境中，为此，Java提供了一个安全机制以防恶意代码的攻击。除了Java语言具有的许多安全特性以外，Java对通过网络下载的类具有一个安全防范机制（类ClassLoader），如分配不同的名字空间以防替代本地的同名类、字节代码检查，并提供安全管理机制（类SecurityManager）让Java应用设置安全哨兵。
**体系结构中立**
Java程序（后缀为java的文件）在Java平台上被编译为体系结构中立的字节码格式（后缀为class的文件），然后可以在实现这个Java平台的任何系统中运行。这种途径适合于异构的网络环境和软件的分发。
**可移植**
这种可移植性来源于体系结构中立性，另外，Java还严格规定了各个基本数据类型的长度。Java系统本身也具有很强的可移植性，Java编译器是用Java实现的，Java的运行环境是用ANSI C实现的。
**解释型**
如前所述，Java程序在Java平台上被编译为字节码格式，然后可以在实现这个Java平台的任何系统中运行。在运行时，Java平台中的Java解释器对这些字节码进行解释执行，执行过程中需要的类在联接阶段被载入到运行环境中。
**高性能**
与那些解释型的高级脚本语言相比，Java的确是高性能的。事实上，Java的运行速度随着JIT(Just-In-Time）编译器技术的发展越来越接近于C++。
**多线程**
在Java语言中，线程是一种特殊的对象，它必须由Thread类或其子（孙）类来创建。通常有两种方法来创建线程：其一，使用型构为Thread(Runnable)的构造子将一个实现了Runnable接口的对象包装成一个线程，其二，从Thread类派生出子类并重写run方法，使用该子类创建的对象即为线程。值得注意的是Thread类已经实现了Runnable接口，因此，任何一个线程均有它的run方法，而run方法中包含了线程所要运行的代码。线程的活动由一组方法来控制。Java语言支持多个线程的同时执行，并提供多线程之间的同步机制（关键字为synchronized）。
**动态**
Java语言的设计目标之一是适应于动态变化的环境。Java程序需要的类能够动态地被载入到运行环境，也可以通过网络来载入所需要的类。这也有利于软件的升级。另外，Java中的类有一个运行时刻的表示，能进行运行时刻的类型检查。

# 101、ArrayList与LinkedList的异同

ArrayList

　　优点：适合随机读取的时候，读取速度快，可以一步get(index)。

　　缺点：添加值很慢——一方面，添加数据在array中间的时候，需要移动后面的数；另一方面，当长度大于初始长度的时候，每添加一个数，都会需要扩容。

　　LinkedList：双向链表

　　优点：添加值很快——添加在list中间也只需要更改指针；长度不固定。

　　实现栈和队列方面，LinkedList要优于ArrayList。

# 102、ArrayList与Vector的区别

Vector的方法都是同步的(Synchronized),是线程安全的(thread-safe)，而ArrayList的方法不是，由于线程的同步必然要影响性能，因此,ArrayList的性能比Vector好。 
   2） 当Vector或ArrayList中的元素超过它的初始大小时,Vector会将它的容量翻倍,而ArrayList只增加50%的大小，这样,ArrayList就有利于节约内存空间。

# 103、HashMap与HashTable的区别

1. HashMap的存储规则:

   优先使用数组存储, 如果出现Hash冲突, 将在数组的该位置拉伸出链表进行存储(在链表的尾部进行添加), 如果链表的长度大于设定值后, 将链表转为红黑树.

    HashTable的存储规则:

   优先使用数组存储, 存储元素时, 先取出下标上的元素(可能为null), 然后添加到数组元素Entry对象的next属性中(在链表的头部进行添加).

   出现Hash冲突时, 新元素next属性会指向冲突的元素. 如果没有Hash冲突, 则新元素的next属性就是null



   HashMap虽然是线程不安全的, 但还是推荐使用, 因为 HashTable实现线程安全的方式太低效了, 直接在方法上加了 synchronized 关键字来实现的.

# 104、String、StringBuffer、StringBiulder的异同

**1.可变与不可变**

　　String类中使用字符数组保存字符串，如下就是，因为有“final”修饰符，所以可以知道string对象是不可变的。

　　　　**private final char value[];**

　　StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，如下就是，可知这两种对象都是可变的。

　　　　**char[] value;**

**2.是否多线程安全**

　　String中的对象是不可变的，也就可以理解为常量，**显然线程安全**。

　　AbstractStringBuilder是StringBuilder与StringBuffer的公共父类，定义了一些字符串的基本操作，如expandCapacity、append、insert、indexOf等公共方法。

　　StringBuffer对方法加了同步锁或者对调用的方法加了同步锁，所以是**线程安全的**。

​	StringBuilder并没有对方法进行加同步锁，所以是**非线程安全的**。

StringBuilder、StringBuffer的方法都会调用AbstractStringBuilder中的公共方法

# 105、谈一谈反射

反射是指在运行状态中，动态获取信息以及动态调用对象方法的功能。

有三个动态性质：运行时生成对象实例、运行期间调用方法、运行期间更改属性

# 106、谈一谈序列化

序列化就是将对象的状态存储到特定的存储介质的过程，序列化的过程中会将对象的共有和私有成员（除了transient修饰的成员）转换为字节流，写入数据流中，然后存储到文件中。

序列化需要先将对象实现Serializable接口，创建OutputStream对象，再创建对象输出流对象ObjectOutputStream并将OutputStream对象作为参数，使用void writeObject(Object obj)把对象写出到文件中。

#  107、线程的生命周期

**创建状态：**使用start()之前

**就绪状态：**使用了start()

**可运行状态：**抢占到CPU的资源

**堵塞状态：**使用了sleep()、i/0操作未完成、所需的锁在别的对象身上

**死亡状态：**run()方法结束、发生未能捕捉的异常、调用stop()方法

# 108、**线程的调度**

计算机通常只有一个CPU，在任意时刻只能执行一条机器指令，每个[线程](https://baike.baidu.com/item/%E7%BA%BF%E7%A8%8B/103101)只有获得CPU的使用权才能执行指令。所谓多线程的[并发运行](https://baike.baidu.com/item/%E5%B9%B6%E5%8F%91%E8%BF%90%E8%A1%8C/4585811)，其实是指从宏观上看，各个线程轮流获得CPU的使用权，分别执行各自的任务。在运行池中，会有多个处于就绪状态的线程在等待CPU，JAVA[虚拟机](https://baike.baidu.com/item/%E8%99%9A%E6%8B%9F%E6%9C%BA)的一项任务就是负责线程的调度，线程调度是指按照特定机制为多个线程分配CPU的使用权。

有两种调度模型：分时调度模型和[抢占式](https://baike.baidu.com/item/%E6%8A%A2%E5%8D%A0%E5%BC%8F)调度模型。

分时调度模型是指让所有的[线程](https://baike.baidu.com/item/%E7%BA%BF%E7%A8%8B)轮流获得cpu的使用权,并且平均分配每个线程占用的CPU的时间片这个也比较好理解。

java虚拟机采用抢占式调度模型，是指优先让可运行池中优先级高的线程占用CPU，如果可运行池中的线程优先级相同，那么就随机选择一个线程，使其占用CPU。处于运行状态的线程会一直运行，直至它不得不放弃CPU。

# 109、程序并发的数据安全(线程锁/线程安全)

当多个线程使用同一个资源的时候，会发生线程不安全，程序运行结果的不准确。

此时需要使用Synchronized修饰，相当于将方法上了一把锁，当一个线程拿到这把锁时，其他线程不能进入该方法，只有等到该线程运行完这个同步方法后，把锁交出，其他线程才有机会去获得这把锁，即同一时刻只允许一个线程访问该资源，从而保证了运行结果的准确性。

分为同步方法和同步代码块。

​    ,

# 110、线程死锁

当多个线程都拥有对方需要的资源，并且同时在等待对方线程交出自身资源的时候，此时就造成死锁现象，但死锁现象不一定出现。

产生死锁原因：存在两个或以上线程；存在两个或以上的资源

# 111、TCP

TCP（Transmission Control Protoco[传输控制协议](https://baike.baidu.com/item/%E4%BC%A0%E8%BE%93%E6%8E%A7%E5%88%B6%E5%8D%8F%E8%AE%AE/9727741)）是一种面向连接的、可靠的、基于字节流的[传输层](https://baike.baidu.com/item/%E4%BC%A0%E8%BE%93%E5%B1%82/4329536)通信协议，必须要求双方建立连接后才开始通信。

服务器端使用ServerSocket，使用其中的accept()方法监听客户端的请求，并使用Socket的getInputStream()和getOutputStream()方法，获取服务器端的输出流和输入流。

服务器端使用Socket，并使用Socket的getInputStream()和getOutputStream()方法，获取客户端的输出流和输入流。

最后将相应的流和socket关闭即可

#  112、**Socket**

位于java.net包，被称为套接字，是网络通信连接的两个端点，是网络驱动层提供给应用程序的一个接口或者一种机制。

# 113、XML的常见解析方式

**DOM****：**基于XML的树结构来完成解析，通过获取各个节点的元素对象，来获取XML内容； 

创建解析器工厂对象，获得解析器对象，通过解析器对象对xml文件解析获得Document对象，Document对象的方法来获取XML内容。

DOM4J：是一个开源的库，特点是其中使用大量的接口，使用前需要导入dom4j的jar包。获得SAXReader对象，使用read()方法获得Document对象，通过Document对象获得根节点元素，来获取XML的内容。

**JDOM****：**JDOM是Java和DOM的结合体。利用纯java技术对XML文档实现解析

**SAX****：**基于事件解析，占用资源小、内存消耗小



