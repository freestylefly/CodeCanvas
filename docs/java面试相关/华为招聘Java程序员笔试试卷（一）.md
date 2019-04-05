## 一、 单项选择题
1．Java是从（ ）语言改进重新设计。
A．Ada       
B．C++  
C．Pasacal   
D．BASIC

2、下列语句哪一个正确（  ）
A． Java程序经编译后会产生 machine code
B． Java程序经编译后会产生 byte code
C． Java程序经编译后会产生 DLL
D． 以上都不正确 

3．下列说法正确的有（  ）
A． class中的constructor不可省略 
B． constructor必须与class同名，但方法不能与 class同名
C． constructor在一个对象被 new时执行
D． 一个class只能定义一个 constructor

4、提供Java存取数据库能力的包是（  ）
A．java.sql 
B．java.awt 
C．java.lang 
D．java.swing

5．下列运算符合法的是（  ）
A．&& 
B．<> 
C．if 
D．:=

6．执行如下程序代码 

```java
a=0;c=0;
　　do{
　　--c;
　　a=a-1;
　　}while(a>0);
```
后， C的值是（  ）
A．0 
B．1 
C．-1 
D．死循环 

7、下列哪一种叙述是正确的（  ）
A． abstract修饰符可修饰字段、方法和类 
B． 抽象方法的 body部分必须用一对大括号 { }包住
C． 声明抽象方法，大括号可有可无 
D． 声明抽象方法不可写出大括号 

8、下列语句正确的是（  ）
A． 形式参数可被视为 local variable
B． 形式参数可被字段修饰符修饰 
C． 形式参数为方法被调用时，真正被传递的参数 
D． 形式参数不可以是对象 

9．下列哪种说法是正确的（  ）
A． 实例方法可直接调用超类的实例方法 
B． 实例方法可直接调用超类的类方法 
C． 实例方法可直接调用其他类的实例方法 
D． 实例方法可直接调用本类的类方法 

10、以下代码输出结果是什么（）

```java
public static void changeStr(String str){
	　　str="welcome";
	　　}
	　　public static void main(String[] args) {
	　　String str="1234";
	　　changeStr(str);
	　　System.out.println(str);
　　}
　　}
```
A、1234
B、welcome
C、编译错误
D、无输出值

## 二、多项选择题
1．Java程序的种类有（  ）
A．类（Class） 
B．Applet 
C．Application 
D．Servlet

2、下列说法正确的有（  ）
A． 环境变量可在编译 source code时指定
B． 在编译程序时，所能指定的环境变量不包括 class path
C． javac一次可同时编译数个 Java源文件
D． javac.exe能指定编译结果要置于哪个目录（ directory）

3、下列标识符不合法的有（  ）
A．new 
B．$Usdollars 
C．1234 
D．car.taxi

4．下列说法错误的有（  ）
A． 数组是一种对象 
B． 数组属于一种原生类 
C． int number=[]={31,23,33,43,35,63}
D． 数组的大小可以任意改变 

5．不能用来修饰 interface的有（ ）
A．private 
B．public 
C．protected 
D．static

6．下列正确的有（  ）
A． call by value不会改变实际参数的数值 
B． call by reference能改变实际参数的参考地址 
C． call by reference不能改变实际参数的参考地址 
D． call by reference能改变实际参数的内容 

7．下列说法错误的有（  ）
A． 在类方法中可用 this来调用本类的类方法
B． 在类方法中调用本类的类方法时可直接调用 
C． 在类方法中只能调用本类中的类方法 
D． 在类方法中绝对不能调用实例方法 

8．下列说法错误的有（  ）
A． Java面向对象语言容许单独的过程与函数存在 
B． Java面向对象语言容许单独的方法存在 
C． Java语言中的方法属于类中的成员（ member）
D． Java语言中的方法必定隶属于某一类（对象），调用方法与过程或函数相同 

9．下列说法错误的有（  ）
A． 能被java.exe成功运行的 java class文件必须有 main()方法
B． J2SDK就是Java API
C． Appletviewer.exe可利用jar选项运行 .jar文件
D． 能被Appletviewer成功运行的 java class文件必须有 main()方法

## 三、  判断题
1．Java程序中的起始类名称必须与存放该类的文件名相同。（）
2．Unicode是用16位来表示一个字的。（  ）
3．原生类中的数据类型均可任意转换。（  ）

## 四、概念题
1. 描述Struts体系结构 ?对应各个部分的开发工作主要包括哪些 ?
2、JSP有哪些内置对象和动作 ?它们的作用分别是什么 ?

## 五、SQL问答题
1、以下两句SQL语句的检索结果为何不同 
```sql
	SELECT * FROM TABLE
　	和 
　　SELECT * FROM TABLE
　　WHERE NAME LIKE '%%' AND ADDR LIKE '%%'
　　AND (1_ADDR LIKE '%%' OR 2_ADDR LIKE '%%'
　　OR 3_ADDR LIKE '%%' OR 4_ADDR LIKE '%%' )
　　的检索结果为何不同 ?

```
2、相应的SQL操作
表结构 :
　　1、 表名:g_cardapply
　　字段 (字段名/类型/长度):
　　g_applyno varchar 8;//申请单号 (关键字)
　　g_applydate bigint 8;//申请日期  
　　g_state varchar 2;//申请状态  
　　2、 表名:g_cardapplydetail
　　字段 (字段名/类型/长度):
　　g_applyno varchar 8;//申请单号 (关键字)
　　g_name varchar 30;//申请人姓名  
　　g_idcard varchar 18;//申请人身份证号
　　g_state varchar 2;//申请状态  
　　其中，两个表的关联字段为申请单号。  
　　题目 :
　　1）、 查询身份证号码为 440401430103082的申请日期  
　　2）、 查询同一个身份证号码有两条以上记录的身份证号码及记录个数  
　　3)、 将身份证号码为 440401430103082的记录在两个表中的申请状态均改为 07 九塾教育 http://rooms9.com 
　　4)、 删除g_cardapplydetail表中所有姓李的记录  

