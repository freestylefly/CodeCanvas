[TOC]

# 一、初识数据库

## 1、什么是数据库

数据库叫database ，简称DB，数据库就是存放数据的仓库，专业的数据库系统具有较小的数据冗余度，较高的数据安全性，易扩展性。

mysql主要优势：

1. 运行速度快
2. 使用成本低
3. 容易使用
4. 可移植性强
5. 适用更多用户



## 2、数据库分类

|  关系型数据库   | 非关系型数据库 |
| :-------------: | :------------: |
|      MySQL      |                |
|     Oracle      |                |
|   SQL Server    |                |
|     maradb      |                |
| db2（银行系统） |                |
|                 |                |

关系型数据库能保证数据的一致性，能建立关系。

非关系型数据库：放在不同的服务器上

## 3、DBMS、DBS、DBA区别

1. DBMS是数据库管理系统，是一种系统软件，包括数据库和用于数据库访问管理的接口系统，通常将DBMS直接称为数据库，严格意义上说mysql属于DBMS
2. DBS是一个实际可运行的系统，由软件、数据库、数据库管理员组成
3. 数据库管理员

![1542015105996](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542015105996.png)



## 4、mysql的安装及mysql语句

![1542015730816](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542015730816.png)

- 默认端口号：3306
- 启动mysql服务方式：
  1. 任务管理器打开
  2. 命令行输入：service(查看本地服务)
  3. dos窗口输命令：net start mysql

- MysqlInsranceConfig:配置向导
- programDate：数据文件的保存路径（默认是隐藏的，在C盘下）
- mysql的安装目录下的my.ini文件：相应的一些配置，可配置编码格式等
- mysql -uroot -paaaaa123 进入mysql
-  show databases显示所有的数据库
-   select version()显示mysql版本号

# 二、DDL语句创建数据库和数据表

## 1、mysql语句（在dos窗口下）

1、cmd——以管理员身份运行

2、启动mysql数据库服务：net start mysql

2、登录mysql：mysql -uroot -paaaaa123（或者：mysql -hlocalhost -uroot -paaaaa123）注意-p以后不能有空格

4、exit退出mysql

5、show databases;（显示数据库，一定要加分号）

6、use mysql

7、show tables（显示数据库中的表）

8、sql语句select * from user\G;显示user用户列表

9、修改user用户密码：

update user set password=password'（1234' ） where user=‘root’;

flush privileges;刷新下

10、？寻求帮助

## 2、结构化查询语句SQL分类

![1542017182304](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017182304.png)



## 3、创建数据库

CREATE DATABASE IF NOT EXISTS school;

## 4、使用数据库

USE school;

## 5、删除数据库

DROP DATABASE IF  EXISTS school;

## 6、显示表结构

desc+表名

## 7、显示表创建语句

show create table 表名

## 8、创建数据表

![1542017519858](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017519858.png)

![1542017843491](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017843491.png)

### 1、每一列后面有一个英文逗号，最后一列没有逗号

### 2、数据值和列类型

![1542017683597](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017683597.png)



![1542017693576](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017693576.png)



![1542017704171](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017704171.png)

![1542017716780](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017716780.png)

![1542017737471](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017737471.png)

### 3、数据字段属性

![1542017806082](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017806082.png)

![1542017823979](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542017823979.png)

### 4、注意点：

- 表名如果变蓝了表明和数据库有冲突，这时候要加上反引号·（tab正上方）
- 字符串类型的要用单引号引起来（英文单引号）
- 有多个属性的时候用空格隔开就好
- 注释：给字段加注释直接commeent'注释内容'，给表注释要用commeent=‘注释内容’

### 5、代码

```java
#使用语句构建student表
#学号int 登录密码varchar(100) 姓名 性别verchar(2)
#出生日期（datatime） email
CREATE TABLE IF NOT EXISTS `student`(
 id INT(4) PRIMARY KEY AUTO_INCREMENT COMMENT'主键、学号',
 psd VARCHAR(20) NOT NULL DEFAULT'123456' COMMENT'密码',
 `name` VARCHAR(30) NOT NULL DEFAULT'匿名' COMMENT'学生姓名',
 sex VARCHAR(2) NOT NULL DEFAULT'男' COMMENT'性别',
 birsday DATETIME,
 email VARCHAR(20)
)
```



### 6、查看数据库定义的语句：

show create database school

### 7、查看数据表的定义

show create table student

在结果下面右键，复制单元格数据到剪贴板，即可显示

## 9、保存sql文件以及打开sql文件

保存Ctrl+s

 新建查询编辑器——在同一标签中打开文件（在不同标签中打开）

对于图像声音视频用text、blob存储数据

一般没有必要直接存储图像，而存储的是路径用字符串

## 10、设置严格检查模式

set sql_mode='strict_trane_tables';

## 11、修改自增列的初始值

CREATE TABLE test3(

 xuhao INT(4) PRIMARY KEY AUTO_INCREMENT,

 `name` VARCHAR(20)

)AUTO_INCREMENT=100

一定要在创建表后进行修改

## 12、修改自增列的步长

SET @@auto_increment_increment=5;

**注意：改变自增列的初始值只影响当前表，但是改变自增列步长会影响所有使用自增列的值**

## 13、同一个列可以被多个属性同时修饰，但是要注意属性的顺序

## 14、注释

![1542019053772](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542019053772.png)

注意，表注释要加等号

## 15、数据表类型

![1542019272958](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542019272958.png)

![1542019286775](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542019286775.png)



## 16、数据表的储存位置

![1542019596383](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542019596383.png)

## 17、设置数据库、数据表的字符集

![1542019649443](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542019649443.png)



![1542019657435](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542019657435.png)



## 18、修改数据表

![1542019751092](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542019751092.png)



```java
#修改表
#1、修改表名
ALTER TABLE students RENAME TO student;
#2、添加字段
ALTER TABLE student ADD MyPsd VARCHAR(20) DEFAULT NULL;

#3、修改字段
ALTER TABLE student CHANGE MyPsd mypsd VARCHAR(30);

#4、删除字段
ALTER TABLE student DROP mypsd;

#5、添加主键约束
ALTER TABLE student ADD CONSTRAINT `student_no` PRIMARY KEY student(StudentNo);

#6、添加外键约束

#7、删除表
DROP TABLE IF EXISTS test1;
```















