

# 一、初识数据库

## 1、什么是数据库

数据库叫database ，简称DB，是长期存放在计算机内，有组织、可共享的大量数据的集合；数据库就是存放数据的仓库，专业的数据库系统具有较小的数据冗余度，较高的数据安全性，易扩展性。

数据库设计原则：

mysql主要优势：一个应用对应一个数据库

## 2、数据库分类

| 关系型数据库（保证数据的一致性，能建立关系） | 非关系型数据库(放在不同的服务器上) |
| :------------------------------------------: | :--------------------------------: |
|           MySQL（中小型企业免费）            |        MongoDB（文档存储）         |
|            Oracle（大型电商网站）            |         Redis（键值存储）          |
|       SQL Server（政府网站，大学教育）       |       Memcached（键值存储）        |
|      maradb（mysql开源版本的一个分支）       |          Hbase（列存储）           |
|               db2（银行系统）                |           Neo4J（图形）            |
|               sybase（被淘汰）               |                                    |

### 补充：ER关系图

| 实体用 | 属性 | 关系 |
| :----: | :--: | :--: |
|  方框  | 椭圆 | 菱形 |

### 补充：服务器

服务器是一台电脑，这台电脑安装了服务器软件，这些软件会监听不同的端口号，根据用户访问的端口号提供不同的服务

## 3、DBMS、DBS、DBA区别

1. DBMS是数据库管理系统，是一种系统软件，包括数据库和用于数据库访问管理的接口系统，通常将DBMS直接称为数据库，严格意义上说mysql属于DBMS
2. DBS是一个实际可运行的系统，由软件、数据库、数据库管理员组成
3. DBA数据库管理员

## 4、MySQL简介

- ### 概念

  是现行的开源、免费的关系型数据库	

- ###    特点

  1. 运行速度快
  2. 使用成本低
  3. 容易使用
  4. 可移植性强
  5. 适用更多用户

- ### mysql语句分类

  |         DDL         |           DML            |     DQL      |                         DCL                          |
  | :-----------------: | :----------------------: | :----------: | :--------------------------------------------------: |
  |    数据定义语言     |       数据操纵语言       | 数据查询语言 | ：数据控制语言，定义访问权限、取消访问权限，安全设置 |
  | create、drop、alter | ，insert、update、delete |    select    |                        grant                         |


## 5、mysql的安装、卸载及启动mysql服务

- ### 安装

  - 运行安装程序、在启动配置教程以前，一路下一步直到finish
  - 第一次finish之后启动服务配置教程
  - 第一个induce mysql bin dinctory to windows path
  - 第二个端口号不要去修改，字符集要选择utf-8，默认端口号：3306

- ### 卸载

  - 打开控制控制面板删除软件
  - 删除mysql安装目录的所有文件
  - 删除mysql数据存放的文件，C:\ProgramData\MySQL

- ### 启动mysql服务方式

  - 任务管理器打开

  - 命令行输入：service(查看本地服务)

  - dos窗口输命令：net start mysql

- ### MysqlInsranceConfig:配置向导

  - programDate：数据文件的保存路径（默认是隐藏的，在C盘下）

  - mysql的安装目录下的my.ini文件：相应的一些配置，可配置编码格式等

  - mysql -uroot -paaaaa123 进入mysql

  - show databases显示所有的数据库

  - select version()显示mysql版本号

# 二、DDL语句创建数据库和数据表

## 1、连接数据库（在dos窗口下）

- cmd——以管理员身份运行


- 启动mysql数据库服务：net start mysql

- 登录mysql：mysql -uroot -paaaaa123（或者：mysql -hlocalhost -uroot -paaaaa123）注意-p以后不能有空格

- exit退出mysql


- show databases;（显示数据库，一定要加分号）


- use mysql


- show tables（显示数据库中的表）


- sql语句select * from user\G;显示user用户列表


- 修改user用户密码：update user set password=password'（1234' ） where user=‘root’;,flush privileges;刷新下


- ？寻求帮助
- 查看mysql所支持的引擎类型、表类型：SHOW ENGINES;
- 查看默认引擎：SHOW VARIABLES LIKE 'storage_engine';
- 显示变量：show variables like'auto%'

## 2、数据库操作

- 创建数据库

  CREATE DATABASE  [IF NOT  EXISTS ]数据库名;

- 删除数据库

  DROP DATABASE [IF  EXISTS] 数据库名;

- 修改数据库字符集

  alter database  数据库名 character set 字符集

- 查看数据库

  - 查看所有数据库：show databases
  - 查看数据库定义：show create databse 数据库名
  - 查看当前正在使用的数据库：select database()

- 选中数据库

  use 数据库名

## 3、表结构操作

- 创建表

  - create table 表名(	

    ​				列名 列的类型  列的约束,

    ​				列名 列的类型  列的约束

    ​			)【表类型】【表字符集】【表注释】

  - 代码示例：

    ```sql
    #创建学生表，并设置表类型、字符集
    CREATE TABLE `student` (
      `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '主键、学号',
      `psd` VARCHAR(20) COLLATE utf8_estonian_ci NOT NULL DEFAULT '123456' COMMENT '密码',
      `name` VARCHAR(30) COLLATE utf8_estonian_ci NOT NULL DEFAULT '匿名' COMMENT '学生姓名',
      `sex` VARCHAR(2) COLLATE utf8_estonian_ci NOT NULL DEFAULT '男' COMMENT '性别',
      `birsday` DATETIME DEFAULT NULL,
      `email` VARCHAR(20) COLLATE utf8_estonian_ci DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci
    ```


  - 注释

    ```sql
    字段注释： comment'注释的内容'
    表注释：comment='注释的内容'
    ```

  - 列的约束

    primary key 主键约束

    ​					unique : 唯一约束

    ​					not null 非空约束

  - 注意事项

    1. 除了最后一个列不用逗号隔开，每一列都要逗号隔开

    2. 表名如果变蓝了表明和数据库有冲突，这时候要加上反引号·

    3. 字符串类型的要用单引号引起来

    4. 有多个属性的时候用空格隔开就好

    5. commend后面加单引号注释内容

    6. #代表整个注释

    7. 设置严格检查模式

       ```sql
       SET sql_mode='strict_trane_tables';
       ```

  - 

    - 数值型
      1. ：非常小的数据
      2. int：标准整数
      3. double：双精度浮点数
      4. decimal【（M,D）】：字符串形式浮点数，M表示总位数，D表示保留小数位数
    - 字符串型
      1. char：固定长度
      2. vachar：可变长度，括号内代表的是字符的个数
      3. text：文本串
    - 日期和时间
      1. datetime：日期和时间，默认是null
      2. timestamp：常用于显示当前时间，默认是当前日期和时间
    - Null值
      1. 理解为没有值或未知值
      2. 不要用null进行算术运算

  - 表的类型

    常见的MyISAM，InnoDB

    |    名称    | MyISAM | InnoDB |
    | :--------: | :----: | :----: |
    |  事务处理  |   no   |  yes   |
    |  外键约束  |   no   |  yes   |
    | 数据行锁定 |   no   |  yes   |
    |  全文索引  |  yes   |   no   |
    | 表空间大小 |  较小  |  较大  |

  - 数据表的存储位置

    都位于C:\ProgramData\MySQL目录下

    |     InnoDB      |        MyISAM         |
    | :-------------: | :-------------------: |
    | 只有一个frm文件 | frm、wyd、myi三个文件 |

  - 数据字段属性

    1. unsigned：无符号，声明该数据不允许为负数
    2. zerofill：0填充，不足位数用0填充，如int（3）5则为005
    3. auto_increment：自动增长，常用于设置主键，且为整数，定义起始值和步长：
       - 定义起始值：auto_increment=100(建表时在右括号右边写，影响的是当前表，对整个数据库的其他表没有影响
       - 定义自增步长：set auto_increment_ncrement=5，会对所有数据库受影响
    4. null和not null ：默认为null，若设置为not null则必须有值
    5. default：设置默认值

- 删除表

  drop table 表名

- 修改表

  ```sql
  #修改表名
  ALTER TABLE 表名 RENAME AS test1;
  #修改表的字符集
  alter table 表名  character set 字符集
  #添加列
  ALTER TABLE 表名 ADD 列名 列类型 属性 ;
  #修改列
  alter table 表名 modify 列名 列类型 属性 ;
  #修改列名
  alter table 表名 change 旧列名 新列名 列类型 属性 ;
  #删除列
  alter table 表名 dop 列名
  ```

- 查看表

  ```sql
  查看当前数据库所有的表名
  show tables
  查看表的定义结构/创建语句
  show create table 表名
  查看表的结构
  desc 表名
  ```

## 

## 4、保存sql文件以及打开sql文件

保存Ctrl+s

 新建查询编辑器——在同一标签中打开文件（在不同标签中打开）

对于图像声音视频用text、blob存储数据

一般没有必要直接存储图像，而存储的是路径用字符串

------

# 三、DML语句对表中数据CRUD操作

## 1、主键&外键

- 主键咋一个表里面可有也可以没有，

- 一个表里面的外键既可以有一个也可以有多个，

- 建立主外键关系的有主键的表为主表，有外键的表成为子表或者从表

- 能够保证数据的完整性和 正确性

- 对于有主外键关系的表，数据插入操作要有一定顺序，先放主键数据，再放外键数据 ，先删除子表，再删除主表

- 主键和外键，列名可以不同，但是数据类型一定要相同

- 主键和外键建立联系第一种方法在建表的时候就联系，关键词是constraint，外键名一般以FK开头 foreign key代表外键，引用主键用关键词reference

- 主键&外键相关的SQL语句

  ```sql
  创建主键&外键
  1、创建此表的同时就创建外键
  主键：PRIMARY KEY可写在列后面，也可以字段都写完了在最后一行写明PRIMARY KEY（字段名 ）
  外键：CONSTRAINT FR_gradeId FOREIGN KEY (要添加主键的字段) REFERENCES 引用表(引用表中的哪个字段)（FR_gradeId字段名）
  2、创建字表完毕后，修改子表增加外键
  ALTER TABLE 表名
  ADD CONSTRAINT 外键名 FOREIGN KEY (要添加主键的字段) REFERENCES 引用表(引用表中的哪个字段);
  删除外键
  ALTER TABLE 表名 DROP FOREIGN KEY 外键名;
  （删除了之所以还能看到外键在表中，是因为外键会默默的创建了一个索引，要想彻底删除还要加上一句话删除索引
  ALTER TABLE 表名 DROP INDEX  外键名;
  删除外键要有两句话才能彻底删除）
  
  ```


## 2、插入数据

- insert into 表名（列名1，列名2） values（值1，值2）

- insert into 表名 values（值1，值2）

- insert into 表名（列名1，列名2） values（值1，值2），（值1，值2）

  批量插入数据

- 注意点：
  1. 批量插入比单条插入效率更高，但是更容易出现问题
  2. 插入全部列名可以省略，插入部分列的话就不能省略表名后面的列名。
  3. 有默认值的时候在values里面可以写默认值也可以写default
  4. 如果不写列名的情况下即使有些列可以为空，但是不能不写要写null，最好都写上列名，如果外键值超过了主表的主键数目，会报错

## 3、删除数据

- delete  from 表名 【where条件】
- truncate table 表名
- delete  和 truncate 的区别
  1. delete  是DML语句   一条一条删除表中数据
  2. truncate是DDL   先删除表再重建表
  3. 关于哪条执行效率高，具体要看表中的数据量，如果数据比较少，delete高效，数据多，则truncate效率高
  4. 当使用不带where条件的delete from删除数据时，自增当前数值依然从原来基础上进行，会记录日志，不删除表结构，但使用truncate table删除表中全部数据的时候，自增当前数值不从原来基础上进行，从原来自增初始值开始。如下例子：不会记录日志
  5. 两种不同村粗引擎，在使用delete from删除全部数据后，自增列初始值表现的不同：同样使用delete from清空数据，重启数据库服务后，对于INNODB的表，自增列从初始值从新开始（比如开始默认初始值是1，那就从1再开始），而对于MYISAM型的表，自增序列从上一个自增数据基础上开始，原因是：INNODB的数据是储存在内容中的，重启数据可服务后，之前的也就都没有了，而MYISAM是储存在文件中，就算重启，数据依然存在。

## 4、修改数据

- update 表名 set 列名=值【where条件】

# 四、DQL查询语句

## 1、AS为字段取别名

AS可省略

## 2、Dinstinct去重复项

select distinct 字段名 from 表名

## 3、通用格式

```sql
select [distinct] [*] [列名1,列名2] from 表名 where 条件
group by...
having
order by 
```

## 4、基础查询

```sql
#查询数据用DQL语句

#1、核心查询（*代表查询所有列，效率比较低）
SELECT * FROM student;

#2、查询指定列，查询student的学号和姓名,在mysql中列名不区分大小写
SELECT studentno,studentname FROM student;
#3、被查出的列取别名（给列取别名as可以省略）
SELECT studentno AS 学号,studentname AS 姓名 FROM student;

SELECT studentno  学号,studentname 姓名 FROM student;

#6、给表取取别名（给表取别名as可以省略），别名不会该表原表的列名，只是为了看的
SELECT studentno  学号,studentname 姓名 FROM student AS 学生表;

SELECT studentno  学号,studentname 姓名 FROM student 学生表;
#7、as为查询结构（如函数）取一个新的名字
SELECT CONCAT('姓名：',studentName)AS 新姓名 FROM student;

#8、查看那些同学参加了考试（学号）,去除重复项，用关键字distinct，默认为all代表查询所有行
SELECT DISTINCT studentno FROM result;
注意：distinct一定写前面
SELECT DISTINCT NAME NAME,english  FROM exam;

#9、select中可以出现表达式
SELECT @@auto_increment_increment;
SELECT VERSION();
SELECT 100*3-1 AS 计算结果

SELECT studentno,studentresult+1 AS 提分后 FROM result;

#10、满足条件的查询(where)  考试成绩95-100
SELECT studentno,StudentResult
FROM result
WHERE StudentResult>=95 AND StudentResult<=100;
```

## 5、模糊查询

```sql
#13、精确查询
SELECT studentno,StudentResult
FROM result
WHERE studentno=1000;

#15、查询除了1000号这个学生，其他学生的考试成绩！=
SELECT studentno,StudentResult
FROM result
WHERE studentno !=1000;
#16、或者用not和！=一样
SELECT studentno,StudentResult
FROM result
WHERE NOT studentno =1000;

#17、模糊查询between and/ like/in/null
#查询姓李的同学的学号和姓名
#like及结合使用的通配符，%（0到任意一个字符） _(一个字符)

#查询所有姓李的同学
SELECT studentno,StudentName
FROM student
WHERE StudentName LIKE '李%';
#查询姓李的，名字是三个字的
SELECT studentno,StudentName
FROM student
WHERE StudentName LIKE '李__';

#查询所有带有“文字的”（不管开头和结尾）常用
SELECT studentno,StudentName
FROM student
WHERE StudentName LIKE '%文%';
```



```sql
转义字符%——\%
            _——\_

如何不想用\作为转义字符，可以自定义转义字符，使用自己定义的转衣服：escape ‘你定义的转义符’但是%和_是不可以自行设计的

#模糊查询之  in
SELECT studentName,studentNo FROM student
WHERE studentNo IN(1000,1001,1002,1003);

SELECT studentName,studentNo FROM student
WHERE Address IN('北京','南京');


#模糊查询之  null
注意：只有是显示null的才为空，对于空白什么都没有的并不是空null而是字符串为空，如：
```

```sql
#查询家庭住址没有写的同学
#1、错误用法
SELECT studentname FROM student
WHERE Address IS  NULL;
#2、用空字符串
SELECT studentname FROM student
WHERE Address='';
#3、一般这种类型的查询用这种写法
SELECT studentname FROM student
WHERE Address='' OR Address IS NULL;
```

```sql
#查询出生日期没有填写的同学，=null是错误的，和null比较要用iis null
SELECT studentno FROM student
WHERE BornDate IS NULL;

#对于不是空的要用is not null
SELECT studentname FROM student
WHERE BornDate IS  NOT NULL;
```

## 6、分组查询

```sql
#不同课程的平均分、最高分、最低分
SELECT  subjectname, AVG(StudentResult) AS 平均分,MAX(StudentResult) AS 最高分,MIN(StudentResult) AS 最低分
FROM result r
INNER JOIN `subject` sub
ON r.SubjectNo=sub.SubjectNo
GROUP BY r.subjectno

#分组后再筛选执行的sql语句筛选
SELECT  subjectname, AVG(StudentResult) AS 平均分,MAX(StudentResult) AS 最高分,MIN(StudentResult) AS 最低分
FROM result r
INNER JOIN `subject` sub
ON r.SubjectNo=sub.SubjectNo
GROUP BY r.subjectno
HAVING 平均分>80
ORDER BY 平均分 DESC
LIMIT 0,4
```



## 7、连接查询

|          内连接          |                            左连接                            |                            右连接                            |                    自连接                    |         等值连接         |        非等值连接         |
| :----------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :------------------------------------------: | :----------------------: | :-----------------------: |
|        nner join         |                          left join                           |                          right join                          |                      \                       |            \             |             \             |
| 查询两个表结果集中的交集 | 以左表为基准，右边表来一一匹配，匹配不上的返回左表记录，右表以null填充 | 以右表为基准，右边表来一一匹配，匹配不上的返回左表记录，左表以null填充 | 自连接的表一定要取别名（AS）子栏目父栏目问题 | 和内连一样，只是写法不同 | 区别于等值连接，不加where |

```sql
等值连接：
SELECT s.StudentNo,StudentName,subjectno,StudentResult
FROM student s,result r
WHERE s.StudentNo = r.StudentNo;
```

```sql
#自连接代码 
CREATE TABLE IF NOT EXISTS category(
    categoryId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '当前栏目',
    pId INT(10) NOT NULL COMMENT '当前栏目的父栏目',
    categoryName VARCHAR(50) NOT NULL,
    PRIMARY KEY (categoryId)
)
INSERT INTO category
VALUES (2,1,'美术设计'),
(3,1,'软件开发'),
(4,3,'数据库基础'),
(5,2,'ps基础'),
(7,2,'色彩搭配'),
(8,3,'PHP基础'),
(9,3,'java基础');



SELECT * FROM category;
SELECT categoryName '知足上进' FROM category;

#将各个栏目的父子栏目显示出来（父栏目名称   子栏目名称）
SELECT a.categoryName AS '主栏目',b.categoryName AS '子栏目'
FROM category AS a,category AS b;
WHERE a.categoryId=b.pId;
```



- 一定要先写连接查询再写where

- 多重嵌套连接：

  注意：inner join ,和from以及on后面都不能用,隔开，否则会报1064错误

  ```sql
  #参加了参加了考试的同学（学号、学生姓名、科目名、分数）
  SELECT s.StudentNo,StudentName,subjectname,StudentResult
  FROM student AS s
  INNER JOIN result AS r
  ON s.StudentNo = r.StudentNo
  INNER JOIN `subject` AS sub
  ON r.SubjectNo=sub.SubjectNo;
  ```


## 8、排序



```sql
#查询《数据库结构—1》的所有考试的同学（学号、学生姓名、科目名、分数）
SELECT s.StudentNo,StudentName,subjectname,StudentResult
FROM student AS s
INNER JOIN result AS r
ON s.StudentNo = r.StudentNo
INNER JOIN `subject` AS sub
ON r.SubjectNo=sub.SubjectNo
WHERE SubjectName='数据库结构-1'
ORDER BY StudentResult DESC,studentno  DESC    #1、默认升序asc  2、desc为降序
#常见错误：ORDER BY StudentResult ,studentno  DESC 这时候StudentResult升序，studentno降序，desc是就近原则
```





## 9、分页查询

- limit 索引，页容量
- 当前页码-1）*页容量，页容量

```sql
#分页查询
##查询《数据库结构—1》的所有考试的同学（学号、学生姓名、科目名、分数）
#每页显示五条数据出来
SELECT s.StudentNo,StudentName,subjectname,StudentResult
FROM student AS s
INNER JOIN result AS r
ON s.StudentNo = r.StudentNo
INNER JOIN `subject` AS sub
ON r.SubjectNo=sub.SubjectNo
WHERE SubjectName='数据库结构-1'
ORDER BY StudentResult DESC,studentno  DESC  
#limit 0,5  #从哪条记录开始起始行0，要显示几行
LIMIT 5,5   #第二页
LIMIT 10,5  #第三页   （等于linit 5 offset 0)
```



## 10、子查询

- 定义：子查询就是在查询语句中的where条件子句中，又嵌套了另外一个select查询语句

```sql
#子查询
#分部写简单sql语句，然后去嵌套
SELECT studentno ,studentname FROM student WHERE studentno IN()
SELECT studentno FROM result WHERE StudentResult>=80 AND subjectno=()#1\2\3\4
SELECT subjectno FROM `subject` WHERE SubjectName='高等数学-2' #2


SELECT studentno, studentname FROM student WHERE studentno IN(
SELECT studentno FROM result WHERE StudentResult>=80 AND subjectno=(
SELECT subjectno FROM `subject` WHERE SubjectName='高等数学-2' ))
```



# 五、mysql函数

## 1、数学函数

|           ABS（)            |       CEILING()        |        FLOOR()         |       RAND()        |                     RAND()                      |
| :-------------------------: | :--------------------: | :--------------------: | :-----------------: | :---------------------------------------------: |
|           绝对值            | 大于等于我的最小的整数 | 小于等于我的最大的整数 | 返回0-1之间的随机数 | 每次生成固定的0-1之间的随机数(以某个数作为种子) |
| SELECT ABS(-8) '-8的绝对值' | SELECT CEILING(9.8)=10 |  SELECT FLOOR(9.8)=9   |          \          |                        \                        |



## 2、字符串函数

```sql
#返回字符串中包含的字符数
SELECT CHAR_LENGTH ( '好好学习数据库')
#合并字符串
SELECT CONCAT('我','爱')
#替换字符串，从某个位置开始，替换某个长度，替换的内容
SELECT INSERT('我爱你婺源',1,3,'很爱')
SELECT INSERT('我爱你婺源',1,3,'很爱')  #如果起始位置超过字符串长度，则返回原长度
#变小写
SELECT LOWER('I LOVE YOU')
#变大写
SELECT UPPER('i love you')
#从左边截取指定长度的字符串
SELECT LEFT('我爱你中国',3)
##从右边截取指定长度的字符串
SELECT RIGHT('我爱你中国',3)
#替换字符串（要替换的字符串，要替换的文字，替换的内容）
SELECT REPLACE('中国欢迎你，你好','你','你们')
#截取(从哪个位置开始截取，截取多长）
SELECT SUBSTRING('中国欢迎你，你好',1,2)
#反转
SELECT REVERSE('中国欢迎你')
```





## 3、日期和时间函数

```sql
#获得当前日期
SELECT CURRENT_DATE()
SELECT CURDATE()
#获得当前日期和时间
SELECT NOW()
SELECT LOCALTIME()
SELECT SYSDATE()
#分别获取日期中的某个部分
SELECT YEAR(NOW())
SELECT MONTH(NOW())
SELECT DAY(NOW())
SELECT HOUR(NOW())
SELECT MINUTE(NOW())
SELECT SECOND(NOW())
```



## 4、系统信息的函数

```sql
SELECT VERSION()
SELECT USER()
```



## 5、聚合函数

```sql
#聚合函数：返回的是一个值，不要出现多个值
#count（字段名） 是非空值的计数
count(*)返回所有列的统计
SELECT COUNT(StudentName) FROM student
SELECT COUNT(1) FROM student
#sum()求总和
SELECT SUM(StudentResult) AS 总分 FROM result
SELECT AVG(StudentResult) AS 平均分 FROM result
SELECT MAX(StudentResult) AS 最高分 FROM【】 result
SELECT MIN(StudentResult) AS 最低分 FROM result
```

count（*)尽量少用 

# 六、MySql事务

## 1、事务定义

事务就是将一组sql语句放在同一批次内去执行，如果一个sql语句错误，则该批次的所有sql语句都将取消执行，最能理解的就是银行转账

**注意：** mysql事务只支出innoDB和BDB数据表类型

## 2、事务的ACID原则

- 原子性（A）

  组sql语句是当做一个整体执行的，不能单独执行其中的某一条，要么全部成功，要么全部失败

- 一致性（C）

  要么都是事务提交前的状态，要么都是事务提交以后的状态，不可能存在事务在中间的什么状态

- 隔离性（I）

  每一个事务处理之间互不影响，彼此独立和透明，事务间不能交叉

- 持久性（D）

  事务一旦提交成功，对事务的影响是永久 的

## 3、mysql事务实现方法

- set autocomment=0关闭mysql的自动提交 

- start transaction

  开启一个事务

- 执行的sql语句

- commit/rollback

  提交或者回滚

- set autocomment=1

  还原mysql默认的自动提交

```sql
代码示例：
#使用事务模拟实现转账
CREATE TABLE IF NOT EXISTS account(
        id INT(4) PRIMARY KEY AUTO_INCREMENT,
        `name` VARCHAR(32) NOT NULL,
        cash DECIMAL(9,2) NOT NULL
);
INSERT INTO account (`name`,cash)
VALUES ('A',2000),('B',10000);

SELECT * FROM account;
DELETE FROM account;

#没有异常情况时候的事务
SET autocommit=0;

START TRANSACTION;
UPDATE account SET cash=cash-500 WHERE `name`='A';
UPDATE account SET cash=cash+500 WHERE `name`='B';
COMMIT;

SET autocommit=1;

#有问题时候的事务用rollback撤销，回到事务开始最初的状态
SET autocommit=0;

START TRANSACTION;

UPDATE account SET cash=cash-500 WHERE `name`='A';
UPDATE account SET cash=cash+500 WHERE `name`='B';
ROLLBACK；

SET autocommit=1;
```



# 七、MySql索引和视图

## 1、索引分类

|            主键索引            | 唯一索引 |       常规索引       |                     全文索引                     |
| :----------------------------: | :------: | :------------------: | :----------------------------------------------: |
|          primary key           |  unique  |        index         |                     fulltext                     |
| 避免同一个表中某数据列的值重复 |          | 不宜添加过多常规索引 | 只能英语myisam，并且只能是vachar、char、test类型 |

唯一索引和主键索引区别：

- 主键索引只有一个、唯一索引可以有多个
- 主键索引非空，唯一索引可以null
- 一个列上有很多索引，数据库会去选一个效率高的索引执行

## 2、添加索引

```sql
#添加索引
#方式一：在创建表申明列的时候添加上
CREATE TABLE text1(
    id INT(3) PRIMARY KEY,
    testno VARCHAR(10) UNIQUE,
    c VARCHAR(50),
    d VARCHAR(20),
    e TEXT,
    INDEX `index_c`(c,d),
    FULLTEXT(e)
)ENGINE MYISAM

***添加常规索引的时候，可以添加多个列为常规索引，写在前面的列有优先权，索引名字用``隔开，而不是逗号。

#方式二，将所有列都申明完毕后再添加索引，统一添加索引

CREATE TABLE text2(
    id INT(3) ,
    testno VARCHAR(10) ,
    c VARCHAR(50),
    d VARCHAR(20),
    e TEXT,
    PRIMARY KEY(id),
    UNIQUE KEY(testno),
    INDEX `index_c`(c,d),
    FULLTEXT(e)
)ENGINE MYISAM

#方式三：创建表完毕后修改表的时候去添加索引
CREATE TABLE text3(
    id INT(3) ,
    testno VARCHAR(10) ,
    c VARCHAR(50),
    d VARCHAR(20),
    e TEXT
)ENGINE MYISAM
ALTER TABLE text3 ADD PRIMARY KEY(id);
ALTER TABLE text3 ADD UNIQUE KEY(testno);
ALTER TABLE text3 ADD INDEX(c,d);
ALTER TABLE text3 ADD FULLTEXT(e);
```



- 注意：EXPLAIN SELECT * FROM student WHERE studentno='1000'，explain代表的是查询查询的具体明细，包括如下信息：

- 全文索引，你要设置全文索引的列，查询的条件不能超过全文数据的50%，否则全文索引就没用了（只能用在字符串类型varchar和text上，只能用于MYISAM）

- 设置全文索引

  ```sql
  ALTER TABLE student ENGINE=MYISAM;
  EXPLAIN SELECT * FROM student WHERE MATCH(StudentName) AGAINST('李%');
  ```


## 3、显示索引信息

- 在目录index下可以看到
- 利用sql语句显示索引信息：SHOW INDEX FROM student;

## 4、删除索引

```sql
1、DROP INDEX 索引名 ON 表名;
DROP INDEX testno ON text3;
2、ALTER TABLE 表名 DROP INDEX e索引名
ALTER TABLE text3 DROP INDEX e;
3、#删除主键索引
ALTER TABLE 表名 DROP PRIMARY KEY;
ALTER TABLE text3 DROP PRIMARY KEY;
```

## 5、复合索引

A-B-C先把A用到

## 6、索引准则

- 选择建立索引的列
  1. 频繁搜索的列
  2. 经常用作查询的列
  3. 经常排序、分组的列
  4. 经常用作连接的列（主键、外键）

- 不介意使用索引的列
  1. 仅包含几个不同值的列
  2. 小型表

## 7、视图

- 视图是保存在数据库中的select查询，是一种虚拟表，使用视图原因，一个是出于安全考虑，用户不必看到整个数据库的结构，另一个是复合用户日常业务逻辑

- 创建视图

- ```sql
  create view 视图名
  AS 查询语句
  ```

- 删除视图
  drop view 视图名

- 查看视图

  select  字段1，字段2 from 视图名

- 注意事项
  1. 每个视图中可以使用多个表
  2. 一个视图可以嵌套另一个视图，单最好不要超过三层
  3. 对视图进行增加、修改、删除操作会直接影响表中数据
  4. 当视图来自多个表时，不允许添加和删除数据
  5. 选中系统数据库information_schnma，然后 select * from vieww;可查看所有视图 

# 八、Mysql数据的备份与恢复

## 1、使用命令mysqldump备份

```sql
mysqldump是和mysql同级的一个命令！
备份整个数据库
mysqldump -uroot -p school>E:/java/beifen/school.sql
执行备份：
*密码可以先不P输出，最后以密码文的形式
*>千万别丢了，如果丢了，会报mysqldump couldnot find。。。。
备份特定的表
mysqldump -uroot -p school grade student >E:/java/beifen/school1.sql
mysqldump设置之指定哪些语句不显示
mysqldump -uroot -p --skip-add-drop-table school grade student >E:/java/beifen/school2.sql
mysqldump设置之显示insert into加上列名
加上一个-c即可 
mysqldump -uroot -p --skip-add-drop-table  -c school grade student >E:/java/beifen/school2.sql
备份文件解析：
1、/*和*/包裹的数据代表是可以被mysql执行的注释，但是不能被其他数据库执行
2、--包围的是注释
3、 !40101是版本号

**mysql --help|more会以一屏显示，一行一行的看
```



## 2、使用mysql底下的脚本source

```
1、进入mysql
mysql -urrot -p
2、选择要备份到哪里
use test
3、选择要备份的数据库
source E:/java/beifen/school.sql
```

## 3、使用sqlyong工具备份

注意点：1、打勾的时候一定要注意，不要勾选use database和carat database

## 4、用sql命令进行备份数据

```sql
#将school库中的student表中的学号和姓名这两列备份出去
USE school;
#注意：备份出去的文件不可以提前存在
SELECT studentno,StudentName INTO OUTFILE 'E:/java/beifen/student.sql' FROM student;

#将备份出去的数据导入到test库中的stable表里来
USE test;
CREATE TABLE stable(
    id INT(4),
    sname VARCHAR(20)
)
LOAD DATA INFILE 'E:/java/beifen/student.sql' INTO TABLE stable(id,sname);

SELECT * FROM stable;
```

# 九、数据库设计

## 1、设计目的

- 效率高
- 节省数据的储存空间
- 便于进一步扩展
- 使应用程序的开发变得更容易

## 2、设计数据库的步骤

- 收集信息
- 标识实体
- 标识每个实体之间的关系

## 3、绘制E-R图

矩形表示实体、椭圆表示属性、菱形表示关系

## 4、绘制数据库模型图

用Visio2007版本及以下版本绘制更好

![1542724324408](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1542724324408.png)

## 5、三大范式

- 第一范式（1NF）

  目标是确保每列 原子性，如果每列或者每个属性值都是不可再分的最小数据单元，则满足第一范式

- 第二范式（2NF）

  1. 一个表只描述一件事情，目标是确保表中的每列都和主键相关
  2. 如果一个关系满足第一范式，并且除了主键以外的其他键全部依赖于主键，则满足第二范式

- 第三范式（3NF）

  目标是确保每列值都和主键直接相关，而不是间接相关，如果一个关系满足第二范式，并且除了主键以外的其他列都只能依赖于主键，列于列之间不存在相互依赖关系

# 十、特别注意

**数据库的脚本sql文件必须保存**