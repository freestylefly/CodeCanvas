# 一、Oracle概念

oracle数据可系统是美国oracle（甲骨文）公司提供的以分布式数据库为核心的一组软件产品，是目前最流行的客户/服务器或B/S体系结构的数据库之一，oracle数据库时目前世界上使用最为广泛的数据库管理系统，作为一个通用的数据库系统，它具有完善的数据库管理功能，是关系型数据库，比mysql更为庞大，在现行的关系型数据库中排名第一（oracle、mysql、SqlServer），时间是最为精确的。

# 二、Oracle的安装

<a href=">https://blog.csdn.net/qq_43270074/article/details/85332826">安装教程</a>

# 三、Oracle数据库的体系结构

## 1、数据库database

Oracle数据库是数据的物理储存，这就包括（数据文件ORA或者DBF、控制文件、联机日志、参数文件）。其实Oracle数据库的概念和其他数据库不一样，这里的数据库时一个操作系统只有一个库，可以看做Oracle就只有一个大数据库。

## 2、实例

一个数据库可以有n个实例，有一系列的后台进程和内存结构组成。

## 3、数据文件dbf

是数据库的物理储存单位，数据库的数据是储存在表空间中的，真正是在某一个或者多个数据文件中，而一个表空间可以由一个或多个数据文件组成，一个数据文件只能属于一个表空间，一旦数据文件被加入到某个表空间后，就不能删除这个文件，如果要删除某个数据文件，只能删除其所属于的表空间才行。

## 4、表空间

表空间是Oracle对物理数据库上相关数据文件的逻辑映射，一个数据库在逻辑上被划分成一到若干个表空间，每个表空间包含了在逻辑上相关联的一组结构，每个数据库至少有一个表空间（称之为system表空间）

每个表空间由同一磁盘上的一个或多个文件组成，这些文件叫数据文件，一个数据文件只能属于一个表空间。

## 5、用户

用户是在实例下建立的，不同实例中可以建相同名字的用户，表的数据是由用户放入某一个表空间的，而这个表龙剑会随机把这些表数据进行管理和存放的，但是表不是由表空间去查询的，而是由用户去查询。

## 6、SCOTT和HR用户

是Oracle帮我们建好的测试账户，Scott账户常用，里面有emp、dept表等。

# 四、Oracle和MYSQL的差别

1、新建项目的方式

MYSQL : 创建一个数据库,创建相应的表

2、Oracle是多用户的, MYSQL是多数据库的

3、Oracle安全级别要高,MYSQL开源免费

## 1、数据完整性

关注数据的有效性和准确性

1）实体完整

关注点：一条数据的唯一性

使用主键、唯一约束

2）域完整性

关注点：字段的格式

非空、检查、外键约束

3）引用完整

关注点：字段的引用关系

4）自定义完整

可使用存储过程、触发器等进行规范

## 2、数据冗余

字段的数据出现重复，重复的数据是可忍受可不处理

处理方式：将重复数据提取成一张新的数据表

# 五、基本查询

## 1、SQL概念

结构化查询语言

## 2、SQL分类

DDL : 数据定义语言 create alter drop truncate
DML : 数据操纵语言 insert update delete
 DCL : 数据控制语言 安全 授权 grant revoke
 DQL : 数据查询语言 select from子句 where子句

在oracle中将DQL放入DML中，多了TCL：事务控制语言 commit、rollback

## 3、Oracle中的数据字典

所谓数据字典就是编写sql语句，全选可以一次性执行不报错

```sql

/* 1.删除数据对象 */
-- 删除数据表
drop table t_reply;
drop table t_user;
-- 删除序列
drop sequence sq_user;
drop sequence sq_reply;


/* 2.创建数据对象 */
-- 创建数据表
create table t_user(
   u_id number(4) primary key,
   u_userName varchar2(40) unique not null,
   u_password varchar2(50) not null,
   u_gender number(1) check(u_gender in (0,1,2)),
   u_age number(3) check(u_age between 12 and 120),
   u_registeTime date not null
);
create table t_reply(
   r_id number(10) primary key,
   r_content varchar2(500) not null,
   r_userId number(4) not null,
   foreign key(r_userId) references t_user(u_id)
);
-- 创建序列
create sequence sq_user start with 1001;
create sequence sq_reply start with 10000001;

/* 3.添加测试数据 */
-- 处理全新的数据表和全新的序列在使用时取不到初始值的问题
insert into t_user values
  (1, '1', '1', 1, 25, sysdate);
insert into t_reply values
  (1, '1', 1);
delete from t_reply;
delete from t_user;
commit;
/*insert into t_user values
  (1000, 'owner', '9999', 1, 25, sysdate);
insert into t_reply values
  (10000000, '人员召集...', 1000);*/
 
-- 添加数据
insert into t_user values
  (sq_user.nextval, 'admin', '9999', 1, 25, sysdate);
insert into t_reply values
  (sq_reply.nextval, '系统1.0上线...', sq_user.currval);

/* 4.提交 */
commit;

/* 5.查询语句 */
/*
   select * from t_user;
   select * from t_reply;
*/
```



## 3、查询语句的结构

```
 select [列名] [*] from 表名 [where 条件] [group by 分组条件] [having 过滤] [order by 排序]
```



## 4、伪表dual

  dual : oracle中的虚表 ,伪表, 主要是用来补齐语法结构，

```sql
比如：select 1+1 from dual;
注意：直接写一个常量比写 * 要高效
select count(1) from emp;
select count(*) from emp;
```



## 5、别名查询

使用as 关键字, 可以省略，别名中不能有特殊字符或者关键字, 如果有就加双引号(比如空格）

```sql
elect ename 姓名, sal 工资 from emp;
select ename "姓       名", sal 工资 from emp;
```



## 6、去除重复数据 distinct

加在select和列名后面，多列去除重复: 每一列都一样才能够算作是重复

```sql
--单列去除重复
select distinct job from emp;

--多列去除重复的
select distinct job,deptno from emp;
```



## 7、查询中四则运算

需要用到伪表dual

```sql
select 1+1 from dual;
--查询员工年薪  = 月薪* 12
select sal*12 from emp;
```

在Oracle 中 ,双引号主要是别名的时候使用, 单引号是使用的值, 是字符

## 8、空值处理函数

注意: null值 , 代表不确定的 不可预知的内容 , 不可以做四则运算

1）mysql的空值处理
​	ifnull(参数1, 参数2):
​	  判断参数1是否为null,
​	  不为null, 则函数的结果取参数1的值
​	  为null, 则取参数2的值
​	if(参数1, 参数2, 参数3)
​	  判断参数1是否为null,
​	  为null, 则取参数3的值
​	  不为null, 则取参数2的值
​	注意if函数只能处理数值字段的空值

```sql
SELECT e.`ename` 姓名,
	e.`sal` 底薪,
	e.`comm` 奖金,
	(e.`sal`+e.`comm`) 实发,
	IFNULL(e.`sal`+e.`comm`, e.`sal`) 实发1,
	IF(e.`comm`, e.`sal`+e.`comm`, e.`sal`) 实发2
FROM emp e;
```

2）oracle的空值处理

nvl（参数1，参数2）：如果1为null，则返回2，不为null就为1

nvl2（参数1, 参数2, 参数3）1为null，则返回,3，不为null，则返回2

decode(需要判断的字段, 
​                  常量值1, 结果值1,
​                  常量值2, 结果值2,
​                  ....
​                  常量值n, 结果值n,
​                  默认结果值
​                  )

```sql
select e.ename 姓名,
       e.sal 底薪,
       e.comm 奖金,
       nvl(e.sal+e.comm, e.sal) 实发1,
       nvl2(e.comm, e.sal+e.comm, e.sal) 实发2,
       decode(e.comm, null, e.sal, e.sal+e.comm) 实发3
from emp e;
```



## 9、字符串拼接

- Oracle 特有的连接符: || 拼接
-  concat(str1,str2) 函数, 在mysql和Oracle中都有

```sql
--查询员工姓名 :  姓名:SCOTT
select ename from emp;
--使用拼接符
select '姓名:' || ename from emp;

--使用函数拼接
select concat('姓名:',ename) from emp;
```



# 六、条件查询

条件查询就是where后面的写法

## 1、关系运算符和排序

```
> >= = < <= != <>
注意：不等于既可以用！=也可以用<>但是<>效率更高
```



## 2、逻辑运算符

 and or not

## 3、其它运算符

```sql
like 模糊查询
in(set) 在某个集合内
between..and.. 在某个区间内
 is null  判断为空
is not null 判断不为空
```

## 4、模糊查询: like

 %   匹配多个字符

_ 匹配单个字符

 如果有特殊字符, 需要使用escape转义

```sql
--查询员工姓名中,包含%的员工信息
select * from emp where ename like '%\%%' escape '\';

select * from emp where ename like '%#%%' escape '#';
```

## 5、排序order by 

升序: asc    ascend

降序: desc   descend

排序注意null问题 : nulls first | last指定null值显示的位置

 同时排列多列, 用逗号隔开

```sql
--查询员工信息,按照奖金由高到低排序
select * from emp order by comm desc nulls last;

--查询部门编号和按照工资  按照部门升序排序, 工资降序排序
select deptno, sal from emp order by deptno asc, sal desc;
```

分析函数：用来处理排名并列问题

rank——排名可并列，之后序号不会顺眼（如2个第二，下一个是第四名）1,2,2,4

dense_rank——排名可并列，之后序号会顺眼（如2个第二，下一个是第三名）1,2,2,3

row_number——不可并列排名

over——添加分组条件

partition—by——分组

```sql
/*
4. 查询实发工资总排名前十的员工, 将十人按照部门分组排名显示, 排名可并列, 排名不空出
   结果集要求显示: 员工编号, 员工姓名, 部门名称, 实发工资, 部门排名, 总排名

*/

select b.*,
     dense_rank() over(partition by b.部门名称 order by b.实发工资 desc) 部门排名
from(
      select dense_rank() over(order by s.实发工资 desc) 总排名,s.*
      from (
              select e.empno 员工编号,e.ename 员工姓名,d.dname 部门名称,
              e.sal+nvl(e.comm,0) 实发工资
              from emp e
              inner join dept d
              on e.deptno=d.deptno
             ) s
     ) b
where b.总排名<=10
```



## 6、分组排序

- select 分组的条件，分组之后的条件 from 表名 group by 分组的条件 having 条件过滤
- 在分组查询语句的检索内容中, 只能出现分组字段和聚合函数

**sql的编写顺序：
​		select,from,where,group by,having,order by 
sql的执行顺序：
​		from,where,group by,having,select,order by.......**

- where和having的区别：

  where后面不能跟聚合函数，可以接单行函数
  having是在group by之后执行，可以接聚合函数

  ```sql
  --分组统计所有部门的平均工资，找出平均工资大于1500的部门
  select deptno,avg(sal) from emp group by deptno having avg(sal)>1500;
  
  --报错,给分组之后的条件取别名的时候出错，因为sql语句执行的顺序问题
  select deptno,avg(sal),bb from emp group by deptno having bb>1500;
  ```


# 七、函数

函数: 必须要有返回值

## 1、单行函数

对某一行中的某个值进行处理

1）数值函数

- 取整

  ```
  select ceil(45.926) from dual;  --46 向上取整
  select floor(45.926) from dual; --45  向下取整
  ```

- 四舍五入

  round（a，b）

  b如果是正数代表取到小数点后b位数为止

  b如果是负数代表取到十位为止

  ```sql
  elect round(45.926,2) from dual; --45.93
  select round(45.926,1) from dual; -- 45.9
  select round(45.926,0) from dual; --46
  select round(45.926,-1) from dual; --50
  select round(45.926,-2) from dual; --0
  select round(65.926,-2) from dual; --100
  ```

- 截断（去尾法）

  ```sql
  select trunc(45.926,2) from dual; --45.92
  select trunc(45.926,1) from dual; -- 45.9
  select trunc(45.926,0) from dual; --45
  select trunc(45.926,-1) from dual; --40
  select trunc(45.926,-2) from dual; --0
  select trunc(65.926,-2) from dual; --0
  ```

- 求余

  ```
  select mod(9,3) from dual; --0
  select mod(9,4) from dual; --1
  ```


 2）字符函数

```sql
 substr(str1,起始索引,长度) 
--注意: 起始索引不管写 0 还是 1 都是从第一个字符开始截取
select substr('abcdefg',0,3) from dual; --abc
select substr('abcdefg',1,3) from dual; --abc

select substr('abcdefg',2,3) from dual; --bcd

--获取字符串长度 24 28
select length('abcdefg') from dual;

--去除字符左右两边的空格
select trim('  hello  ') from dual;

--替换字符串
Select replace('hello','l','a') from dual;
```

 3）  日期函数

```sql
-查询今天的日期（查询的是服务器上的日期）
select sysdate from dual;
--查询3个月后的今天的日期
select add_months(sysdate,3) from dual;
--查询3天后的日期
select sysdate + 3 from dual;


--查询员工入职的天数
select sysdate - hiredate from  emp;

select ceil(sysdate - hiredate) from  emp;

--查询员工入职的周数
select (sysdate - hiredate)/7 from emp;

--查询员工入职的月数
select months_between(sysdate,hiredate) from emp;

--查询员工入职的年份
select months_between(sysdate,hiredate)/12 from emp;
```

 4）  转换函数

数值转字符

```sql
select to_char(sal,'$9,999.99') from emp;

select to_char(sal,'L9,999.99') from emp;
/*
to_char(1210.73, '9999.9') 返回 '1210.7' 
to_char(1210.73, '9,999.99') 返回 '1,210.73' 
to_char(1210.73, '$9,999.00') 返回 '$1,210.73' 
to_char(21, '000099') 返回 '000021' 
to_char(852,'xxxx') 返回' 354'

*/
```

 日期转字符 to_char()  （不区分大小写）

```sql
select to_char(sysdate,'yyyy-mm-dd hh:mi:ss') from dual;
select to_char(sysdate,'yyyy-mm-dd hh12:mi:ss') from dual; --默认的是24小时制度
--只想要年
select to_char(sysdate,'yyyy') from dual;  --2017

--只想要日
select to_char(sysdate,'d') from dual; --2  代表一个星期中第几天（美国周天是一个星期的第一天）
select to_char(sysdate,'dd') from dual;  --10  代表一个月中的第几天
select to_char(sysdate,'ddd') from dual; --100 代表一年中的第几天


select to_char(sysdate,'day') from dual;  --monday（星期的英文）
select to_char(sysdate,'dy') from dual;   --mon  星期的简写
```



字符转日期

```sql
select to_date('2017-04-10','yyyy-mm-dd') from dual;

--查询1981年 -- 1985年入职的员工信息
select * from emp where hiredate between to_date('1981','yyyy') and to_date('1985','yyyy');
```

5） 通用函数

```sql
nvl(参数1,参数2) 如果参数1 = null 就返回参数2
       nvl2(参数1,参数2,参数3) 如果参数1 = null ,就返回参数3, 否则返回参数2
       
       nullif(参数1,参数2) 如果参数1 = 参数2 那么就返回 null , 否则返回参数1
       
       coalesce: 返回第一个不为null的值
       
select nvl2(null,5,6) from dual; --6;

select nvl2(1,5,6) from dual; --5;

select nullif(5,6) from dual; --5
select nullif(6,6) from dual; --null

select coalesce(null,null,3,5,6) from dual;  --3
```



## 2、多行函数（聚合函数）

对某一列的所有行进行处理

  max()  min count sum avg

注意：直接忽略空值

例子：

```sql
--统计员工的平均奖金  550  错误    2200/14 =，因为空值产生的影响
select avg(comm) from emp;
--统计员工的平均奖金 157.
select sum(comm)/count(1) from emp;
select ceil(sum(comm)/count(1)) from emp;
```

## 3、条件表达式

作用：查询的时候用来替换列中所有数据的值，区别于取别名，取别名只是单纯的给子弹取别名

```sql
/*
条件表达式：
	case 字段
	when 值1 then 值
	when 值2 then 值
	else
		默认值
	end "别名"
case、when通用的写法，mysql和oracle中都可以用

oracle特有的写法：decode(字段,if1,then1,if2,then2,else1)
*/
--给表中姓名取一个中文名
select 
	case ename
	when 'SMITH' then '刘备小二'
	when 'ALLEN' then '萨达'
	else 
		'路人甲'
	end "中文名"
from emp;

--oracle 特有写法
select decode(ename,'SMITH','刘备小二','ALLEN','萨达','路人甲') from emp;
```

# 八、多表查询

## 1、笛卡尔积

实际上是两张表的乘积,但是在实际开发中没有太大意义，格式: select * from 表1,表2

```sql
select * from emp;
select * from dept;

select * from emp, dept;

select * from emp e1, dept d1 where e1.deptno = d1.deptno;
```

## 2、内连接

隐式内联接: 
​           等值内联接:   where e1.deptno = d1.deptno;
​           不等值内联接:  where e1.deptno <> d1.deptno;
​           自联接: 自己连接自己
  显式内联接:
​           select * from 表1 inner join 表2 on 连接条件
​           inner 关键字可以省略

```sql
       --查询员工编号,员工姓名,经理的编号,经理的姓名
select e1.empno,e1.ename,e1.mgr,m1.ename
from emp e1, emp m1 where e1.mgr= m1.empno;


--查询员工编号,员工姓名,员工的部门名称,经理的编号,经理的姓名
select e1.empno,e1.ename,d1.dname,e1.mgr,m1.ename
from emp e1, emp m1,dept d1 where e1.mgr= m1.empno and e1.deptno = d1.deptno;

--查询员工编号,员工姓名,员工的部门名称,经理的编号,经理的姓名,经理的部门名称
select e1.empno,e1.ename,d1.dname,e1.mgr,m1.ename,d2.dname
from emp e1, emp m1,dept d1,dept d2 
where 
     e1.mgr= m1.empno 
 and e1.deptno = d1.deptno
 and m1.deptno = d2.deptno 
;

--查询员工编号,员工姓名,员工的部门名称,员工的工资等级,经理的编号,经理的姓名,经理的部门名称
select e1.empno,e1.ename,d1.dname,s1.grade,e1.mgr,m1.ename,d2.dname
from emp e1, emp m1,dept d1,dept d2,salgrade s1 
where 
     e1.mgr= m1.empno 
 and e1.deptno = d1.deptno
 and m1.deptno = d2.deptno
 and e1.sal between s1.losal and s1.hisal 
;

--查询员工编号,员工姓名,员工的部门名称,员工的工资等级,经理的编号,经理的姓名,经理的部门名称,经理的工资等级
select e1.empno,e1.ename,d1.dname,s1.grade,e1.mgr,m1.ename,d2.dname,s2.grade
from emp e1, emp m1,dept d1,dept d2,salgrade s1,salgrade s2 
where 
     e1.mgr= m1.empno 
 and e1.deptno = d1.deptno
 and m1.deptno = d2.deptno
 and e1.sal between s1.losal and s1.hisal 
 and m1.sal between s2.losal and s2.hisal 
;

--查询员工编号,员工姓名,员工的部门名称,员工的工资等级,经理的编号,经理的姓名,经理的部门名称,经理的工资等级
--将工资等级 1,2,3,4 显示成 中文的 一级 二级 三级...

select e1.empno,
       e1.ename,
       d1.dname,
       case s1.grade
         when 1 then '一级'--为所有列更换成你想要的信息
         when 2 then '二级'
         when 3 then '三级'
         when 4 then '四级'
         else
             '五级'
         end "等级",--取别名
       e1.mgr,
       m1.ename,
       d2.dname,
       decode(s2.grade,1,'一级',2,'二级',3,'三级',4,'四级','五级') "等级"
from emp e1, emp m1,dept d1,dept d2,salgrade s1,salgrade s2 
where 
     e1.mgr= m1.empno 
 and e1.deptno = d1.deptno
 and m1.deptno = d2.deptno
 and e1.sal between s1.losal and s1.hisal 
 and m1.sal between s2.losal and s2.hisal 
;

--查询员工姓名和员工部门所处的位置
select e1.ename,d1.loc from emp e1,dept d1 where e1.deptno = d1.deptno;

select * from emp e1 inner join dept d1 on e1.deptno = d1.deptno;
```

## 2、外连接

外连接: (标准,通用写法)
​       左外连接: left outer join 左表中所有的记录,如果右表没有对		 应记录,就显示空
​       右外连接: right outer join 右表中的所有记录,如果左表没有对应记录,就显示空
​       outer 关键字可以省略  
  Oracle中的外连接: (+) 实际上是如果没有对应的记录就加上空值
​      select * from emp e1,dept d1 where e1.deptno = d1.deptno(+);  

```sql
select * from emp e1 left outer join dept d1 on e1.deptno = d1.deptno;
insert into emp(empno,ename) values(9527,'HUAAN');
select * from emp e1,dept d1 where e1.deptno = d1.deptno(+);

select * from emp e1 right outer join dept d1 on e1.deptno = d1.deptno;
select * from emp e1,dept d1 where e1.deptno(+) = d1.deptno;
```
# 九、子查询

查询语句中嵌套查询语句; 用来解决复杂的查询语句

## 1、单行子查询

= = < <= <> !=

```sql
--查询最高工资的员工信息 
--1.查询出最高工资 --5000
select max(sal) from emp;
--2. 工资等于最高工资
select * from emp where sal = (select max(sal) from emp);


--查询出比雇员7654的工资高,同时和7788从事相同工作的员工信息
--1.雇员7654的工资 1250
select sal from emp where empno = 7654;
--2.7788从事的工作 ANALYST
select job from emp where empno = 7788;
--3.两个条件合并
select * from emp where sal > 1250 and job = 'ANALYST';

select * from emp where sal > (select sal from emp where empno = 7654) and job = (select job from emp where empno = 7788);

--查询每个部门最低工资的员工信息和他所在的部门信息
--1.查询每个部门的最低工资,分组统计
select deptno,min(sal) minsal from emp group by deptno;
--2.员工工资等于他所处部门的最低工资
select * 
from emp e1,
     (select deptno,min(sal) minsal from emp group by deptno) t1 --将查询到的结果作为一张表进行两表连查
where e1.deptno = t1.deptno and e1.sal = t1.minsal; 
--3.查询部门相关信息
select * 
from emp e1,
     (select deptno,min(sal) minsal from emp group by deptno) t1,
     dept d1 
where e1.deptno = t1.deptno and e1.sal = t1.minsal and e1.deptno = d1.deptno; 

```



## 2、多行子查询

in not in  >any >all exists not exists

通常情况下, 数据库中不要出现null  最好的做法加上Not null
​      null值并不代表不占空间, char(100) null 100个字符

```sql
--查询不是领导的信息
select * from emp where empno not in (select mgr from emp);
select * from emp where empno <>all(select mgr from emp);
--正确的写法
select * from emp where empno not in (select mgr from emp where mgr is not null);
```

## 3、exists(查询语句)

 存在的意思,判断一张表里面的记录是否存在与另外一张表中，作布尔值来处理:， 当查询语句有结果的时候, 就是返回true，否则返回的是false，数据量比较大的时候是非常高效的  

```sql
--查询有员工的部门的信息
select * from dept d1 where exists(select * from emp e1 where e1.deptno = d1.deptno );
```

# 十、分页

 Oracle的分页查询需要使用伪列辅助

伪列 : 在Oracle的结果集中默认带有的可以使用的
​      不出现在结果集列中的内容.
​      rownum : 伪列序号, 从1开始
​      rowid : 伪列地址

SQL执行顺序
​       from .. where ..group by..having .. select..rownum..order by

默认都是从1开始。

```sql
rownum按照员工id排序后再分页
select t.*
from (
      select rownum rn,e.*
      from (
            select *
            from emp 
            order by empno
           ) e
     ) t
where t.rn between 5 and 9;  
```



```sql
rowid去除表中重复数据
create table p(
       name varchar2(10)
);

insert into p values('黄伟福');
insert into p values('赵洪');
insert into p values('杨华');

delete from p where 

select rowid,p.* from p;
select distinct * from p;

delete from p p1 where rowid > (select min(rowid) from p p2 where p1.name = p2.name);
```

# 十一、集合运算

 所有的查询结果可能不是来自同一张表,  将查询结果进行合并，并去除重复项

## 1、并集

union : 去除重复的,并且排序

 union all : 不会去除重复的

```sql
select * from emp where sal > 1500
union
select * from emp where deptno = 20;

select * from emp where sal > 1500
union all
select * from emp where deptno = 20;
```

## 2、交集运算: intersect

```sql
--工资大于1500,并且20号部门下的员工
select * from emp where sal > 1500;
select * from emp where deptno = 20;

select * from emp where sal > 1500
intersect
select * from emp where deptno = 20;
```

## 3、差集运算

两个结果相减

```sql
--1981年入职员工(不包括总裁和经理)
--1981年入职员工
select * from emp where to_char(hiredate,'yyyy')='1981';

--总裁和经理
select * from emp where job = 'PRESIDENT' or job = 'MANAGER';


select * from emp where to_char(hiredate,'yyyy')='1981'
minus
select * from emp where job = 'PRESIDENT' or job = 'MANAGER';
```

## 4、集合运算中的注意事项

1.列的类型要一致
2.按照顺序写
3.列的数量要一致,如果不足,用空值填充

```sql
select ename,sal from emp where sal > 1500
union
select ename,sal from emp where deptno = 20;
--列的类型不匹配
select ename,sal from emp where sal > 1500
union
select sal,ename from emp where deptno = 20;

--列的数量不匹配
select ename,sal,deptno from emp where sal > 1500
union
select ename,sal from emp where deptno = 20;

select ename,sal,deptno from emp where sal > 1500
union
select ename,sal,null from emp where deptno = 20;

select ename,sal,deptno from emp where sal > 1500
union
select ename,sal,66 from emp where deptno = 20;

select * from emp;
select * from dept;
```

# 十二、DDL语句管理表

## 1、表空间

逻辑单位, 通常我们新建一个项目,就会去新建表空间,在表空间中创建用户来创建表

- 创建表空间

  语法:
  ​               create tablespace 表空间的名称
  ​               datafile '文件的路径(服务器上)'
  ​               size 大小
  ​               autoextend on  自动扩展
  ​               next 每次扩展的大小

  ```sql
  --创建表空间-
  create tablespace canghe
  datafile 'C:\oracle\canghe.dbf'
  size 100m
  autoextend on
  next 10m;
  ```


- 删除表空间

```sql
--删除表空间
drop tablespace canghe;
```

## 2、创建用户

 create user 用户名
 identified by 密码
 default tablespace 表空间的名称

```sql
create user canghe
identified by canghe
default tablespace canghe;
```

- 授权

```sql
--授予 dba的角色
grant dba to canghe;
select * from scott.emp;
```

## 3、创建表

 create table 表名(
​           列名  列的类型 [列的约束],
​           列名  列的类型  [列的约束]      
​         );

     列的类型:
    varchar ,在Oracle中,目前是支持的, 但是不保证以后还支持
    varchar2(长度) 可变字符长度    varchar2(10)  hello  占5个字符
         char(长度)   固定长度字符      char(10)      hello  占10个字符,用空格填充
         number(总长度,小数长度)     数字类型 --小数长度不能大于等于总长度
         
         date                   年月日时分秒 2017/4/13 9:43:49
         timestamp              时间戳, 比date类型更加精确 13-APR-17 09.44.08.272000 AM +08:00
         
         LONG/CLOB : 存放一本小说
         BLOB      : 存放电影  java 存进去,  再读取出来


    使用子查询的方式创建表
         
         create table 表名 as 查询语句; 
         
           注意: 只会复制表结构和表中的数据,不会复制列的约束     
                 如果查询语句有结果, 就是复制 表结构和数据
                 如果查询语句没有结果, 就是复制 表结构
```sql
create table test1(
       name1 varchar2(10),
       name2 char(10),
       age number(4,2)
);
create table 表名 as 查询语句; 复制表
create table emp as select * from scott.emp;
```



## 4、修改表

- 添加咧

  alter table 表名 add 列

- 修改列

  修改列类型：modify

  修改列名：rename

- 删除咧

  alter table 表名 drop column 列名;

- 修改列名

  alter table 表名 rename column 列名;

- 重命名表

  rename 旧表名 to 新表名;

## 5、删除表

drop table 表名

## 6、表的五大约束

1. 主键约束

   primary key

2. 非空约束

   not null

3. 唯一约束

   unique

4. 外键约束

   添加外键约束：

   alter table 表名 add foreign key（添加约束的字段） references 引用的表名 （引用的字段）

   插入：先主表、再从表

   删除：先从表，再主表

   强制删除表（不建议）：

   drop table 表名 cascade constraint;

   级联删除:

   添加外键约束,使用级联约束  ,在删除的时候,使用级联删除

   ```sql
   ----添加外键约束,使用级联约束  ,在删除的时候,使用级联删除
   alter table product add foreign key(cno) references category(cid) on delete cascade;
   
   
   insert into category values(2,'电脑办公');
   insert into product values(11,'外星人',2);
   
   --级联删除 : 首先去从表中找有没有 关联数据, 如果在从表中找到关联数据,先删除从表中关联数据,然后再删除表中的数据
   delete from category where cid = 2;
   ```

5. 检查约束

   check( 列名 in ('值1','值2','值3'))

# 十三、DML管理表数据

## 1、插入数据

- 指定列名插入

  insert into 表名 values(所有列的值都要对应写上)

- 不指定列名插入

   insert into 表名(列1,列2) values(值1,值2);

- 使用子查询插入

   insert into 表名 查询语句

## 2、修改数据

update 表名 set 列名 = 列的值  [where 条件]

## 3、删除数据

delete from 表名  [where 条件]

```sql
 delete和truncate 区别
        
       delete:                 truncate:
        DML                    DDL
        逐条删除               先删除表再创建表
        支持事务操作           不支持事务操作,
                               执行效率要高  
```

# 十四、其他数据库对象

## 1、事务

事务: 就是一系列的操作,要么都成功,要么都失败
​       四大特性: 原子性,隔离性,持久性,一致性
​          

       如果不考虑隔离级别: 脏读,虚读,不可重复读
            MYSQL隔离级别: READ UNCOMMITTED , READ COMMITTED, REPEATABLE READ, SERIALIAZABLE
            ORACLE隔离级别: READ COMMITTED SERIALIZABLE READ ONLY 
                        默认隔离级别: READ COMMITTED
                        
      提交 : commit
      事务的保存点/回滚点: savepoint 保存点的名称
      回滚: rollback


## 2、视图

视图: 是对查询结果的一个封装
​              视图里面所有的数据,都是来自于它查询的那张表,视图本身不存储任何数据
​          1.能够封装复杂的查询结果
​          2.屏蔽表中的细节
​       语法: 
​          create [or replace] view 视图的名称 as 查询语句 [ with read only]
​             注意: 通常不要通过视图去修改,视图创建的时候,通常要加上with read only

```sql
--创建一个视图
create or replace view view_test1 as select ename,job,mgr from emp;

--通过视图修改数据
update view_test1 set ename='SMITH2' where ename = 'SMITH';

--创建一个只读视图
create or replace view view_test2 as select ename,job,mgr from emp with read only;

update view_test2 set ename='SMITH3' where ename = 'SMITH2';
```

-同义词的概念（就是为视图取的一个别名）
create synonym dept for view_test3;

## 3、序列

oracle中用来控制自增长的

```sql
语法:
           create sequence 序列的名称
           start with 从几开始
           increment by 每次增长多少
           maxvalue 最大值 | nomaxvalue
           minvalue 最小值 | nominvalue
           cycle | nocycle  是否循环    1,2,3,1,2,3
           cache 缓存的数量3 | nocache  1,2,3,4,5,6 
           
      如何从序列获取值
          currval : 当前值
          nextval : 下一个值
          
               注意: currval 需要在调用nextval之后才能使用      
               
               永不回头,往下取数据, 无论发生异常, 回滚   
```

```sql
--序列用的最多的一种写法
create sequence seq_test2;
select seq_test2.nextval from dual;
```



## 4、索引

```
 索引:相当于是一本书的目录,能够提高我们的查询效率
       如果某一列,你经常用来作为查询条件,那么就有必要创建索引,数据量比较的情况
       
       语法: 
             create index 索引的名称 on 表名(列)   
        
       注意:主键约束自带主键索引, 唯一约束自带唯一索引
       
       索引原理: btree   balance Tree 平衡二叉树
       
             如果某列作为查询条件的时候,可以提高查询效率,但是修改的时候,会变慢
             
             索引创建好之后,过了一段,DBA都会去做重构索引
             
       SQL调优:
             1.查看执行计划F5
             2. 分析里面的cost 和 影响行数, 想办法降低  
```

# 十五、PLSQL编程

## 1、概述

procedure Language 过程语言 Oracle对SQL的一个扩展
​             让我们能够像在java中一样写 if else else if 条件, 还可以编写循环逻辑 for while

## 2、基本语法

```sql
declare
                --声明变量
                变量名 变量类型;
                变量名 变量类型 := 初始值;
                  vsal emp.sal%type;  --引用型的变量  
                  vrow emp%rowtype;   --声明记录型变量          
             begin
                --业务逻辑,比如输出一句话：
				dbms_output.put_line()相当于java中 syso 
             end;
```

```sql
declare
   i varchar2(10) := '张三';          
begin
  dbms_output.put_line(i);
end;
```

## 3、变量

%type --引用型变量

%rowtype  --记录型变量

## 4、PL条件判断

```sql
 if then
     
     elsif then
       
     else 
     
     end if;
```

```sql
declare
   age number := &aaa;
begin
  if age < 18 then
     dbms_output.put_line('小屁孩');
  elsif age>=18 and age <=24 then
     dbms_output.put_line('年轻人');
  elsif age>24 and age < 40 then
    dbms_output.put_line('老司机');
  else 
      dbms_output.put_line('老年人');    
  end if;
end;
```

## 5、循环操作

```sql
while 循环
      while 条件 loop
        
      end loop;
    
  for循环
      for 变量  in [reverse] 起始值..结束值 loop
        
      end loop;
  
  loop循环  
      loop
        exit when 条件
      end loop;
```

```sql
--输出1~10
declare
  i number :=1;
begin
  while i<=10 loop
    dbms_output.put_line(i);
    i := i+1;    
  end loop;
end;

--输出1~10
declare

begin
  for i in reverse 1..10 loop
    dbms_output.put_line(i);
  end loop;
end;

--输出1~10
declare
   i number :=1;
begin
   loop
     exit when i>10;
      dbms_output.put_line(i);  
     i := i+1;
   end loop;
end;

/*

   *
  ***
 *****
  ***
   *   
输出 m  
   x : [-m,m]
   y : [-m,m]
   
   输出所有满足条件的 : abs(y)+abs(x) <=m
   
   m取值
*/
--使用PLSQL输出菱形
declare
   m number := 10;
begin
   for x in -m..m loop
     for y in -m..m loop
       if abs(y) + abs(x) <= m then
         dbms_output.put('*');
       else
         dbms_output.put(' ');
       end if;      
     end loop;
     dbms_output.new_line();
   end loop;  
end;

--使用PLSQL输出三角形,只要是三个角
declare
   m number := 10;
begin
   for x in reverse -m..m loop
     for y in -m..m loop
       if abs(y) + abs(x) <= m and x>=0 then
         dbms_output.put('*');
       else
         dbms_output.put(' ');
       end if;      
     end loop;
     dbms_output.new_line();
   end loop;  
end;
```

# 十六、游标

用来操作查询的结果集.相当于JDBC中的ResultSe

```
语法: cursor 游标名[(参数名 参数类型)] is 查询结果集
       
       开发步骤:
           1. 声明游标
           2. 打开游标       open 游标名
           3. 从游标中取数据  fetch 游标名 into 变量
                         游标名%found :找到数据
                         游标名%notfound : 没有找到数据 
           4. 关闭游标       close 游标名
           
      系统引用游标
           1. 声明游标 : 游标名 sys_refcursor
           2. 打开游标: open 游标名 for 结果集
           3. 从游标中取数据
           4. 关闭游标
                
     for循环遍历游标:
           不需要声明额外变量
           不需要打开游标
           不需要关闭游标      
```

## 1、不带参数游标

```sql
*/
--输出员工表中所有的员工姓名和工资(不带参数游标)
/*
   游标:所有员工
   声明一个变量,用来记录一行数据  %rowtype
*/
declare
   --游标
   cursor vrows is select * from emp;
   --s声明变量,记录一行数据
   vrow emp%rowtype;
begin
   --1.打开游标  
   open vrows;
   --2.从游标提取数据
   --循环取数据
   loop
       fetch vrows into vrow; 
       exit when vrows%notfound;  
       dbms_output.put_line('姓名:'||vrow.ename ||' 工资: ' || vrow.sal);
   end loop;
   --3.关闭游标
   close vrows;
end;
```

## 2、带参数的游标

```sql
--输出指定部门下的员工姓名和工资
/*
   游标: 指定部门的所有员工
   声明一个变量记录一行数据
*/
declare
   --声明游标
   cursor vrows(dno number) is select * from emp where deptno = dno;
   --声明变量
   vrow emp%rowtype;
begin
  --1.打开游标 , 指定10号部门
  open vrows(10);
  --2. 循环遍历,取数据
  loop
     fetch vrows into vrow;
     exit when vrows%notfound;    
      dbms_output.put_line('姓名:'||vrow.ename ||' 工资: ' || vrow.sal);
  end loop;
  close vrows;
end;
```

## 3、系统引用游标

```sql
--输出员工表中所有的员工姓名和工资
declare
  --声明系统引用游标
  vrows sys_refcursor;
  --声明一个变量
  vrow emp%rowtype;
begin
  --1.打开游标
  open vrows for select * from emp;
  --2.取数据
  loop
    fetch vrows into vrow;
    exit when vrows%notfound;
     dbms_output.put_line('姓名:'||vrow.ename ||' 工资: ' || vrow.sal);
  end loop;
  close vrows;
end;
```

## 4、-使用for循环遍历游标

```sql
--按照员工工作给所有员工涨工资,总裁涨1000,经理涨800,其他人涨400
/*
    游标 : 所有员工
    声明一个记录一行数据   
*/
declare
   --声明游标
   cursor vrows is select * from emp;
   --声明一个变量
   vrow emp%rowtype; 
begin
  --1.打开游标
  open vrows;
  --2.循环取数据
  loop
       --取数据
       fetch vrows into vrow;
       --退出条件
       exit when vrows%notfound;  
       --根据不同的职位,涨工资 总裁涨1000,经理涨800,其他人涨400
       if vrow.job = 'PRESIDENT' then
          update emp set sal = sal + 1000 where empno = vrow.empno;
       elsif vrow.job = 'MANAGER' then
          update emp set sal = sal + 800 where empno = vrow.empno;
       else
          update emp set sal = sal + 400 where empno = vrow.empno; 
       end if;       
  end loop;
  --3.关闭游标
  close vrows;
  --4.提交事务
  commit;
end;
```

# 十七、例外

例外:(意外)程序运行的过程发生异常,相当于是JAVA中的异常

```sql
declare
       --声明变量
   begin
       --业务逻辑
   exception
       --处理异常
       when 异常1 then
         ...
       when 异常2 then
         ...
       when others then
         ...处理其它异常
   end;
   
   zero_divide : 除零异常
   value_error : 类型转换异常
   too_many_rows : 查询出多行记录,但是赋值给了rowtype记录一行数据变量
   no_data_found : 没有找到数据
       
   
   自定义异常:
       异常名  exception;
       raise 异常名  
```



```sql
--查询指定编号的员工,如果没有找到,则抛出自定义的异常
/*
     --错误的演示
     
     1.声明一个变量 %rowtype
     2.查询员工信息,保存起来
     3.判断员工信息是否为空
     4. 如果是 则抛出异常
*/
declare
  --   1.声明一个变量 %rowtype
  vrow emp%rowtype;
  --2 .声明一个自定义的异常
  no_emp exception;  
begin
  --查询员工信息,保存起来
  select * into vrow from emp where empno = 8888;   --抛出异常
  
  if vrow.sal is null then
    raise no_emp; --抛出自定义的异常
  end if;
exception
  when no_emp then
     dbms_output.put_line('输出了自定义的异常');  
  when others then
     dbms_output.put_line('输出了其它异常'||sqlerrm);  
end;

--查询指定编号的员工,如果没有找到,则抛出自定义的异常
/*
     游标来判断
       %found %notfound
    声明一个游标
    声明一个变量,记录数据
    从游标中取记录
       如果有,则不管它
       如果没有就抛出自定义的异常
*/
declare
  --声明游标
  cursor vrows is select * from emp where empno=8888;   
  --声明一个记录型变量
  vrow emp%rowtype;
  --声明一个自定义异常
  no_emp exception;  
begin
  --1.打开游标
  open vrows;
  --2.取数据
  fetch vrows into vrow;
  --3.判断游标是否有数据
  if vrows%notfound then
    raise no_emp;
  end if;
  close vrows;
exception
  when no_emp then
    dbms_output.put_line('发生了自定义的异常');
end;
```

# 十八、存储过程

```sql

    存储过程: 实际上是封装在服务器上一段PLSQL代码片断,已经编译好了的代码
              1.客户端取调用存储过程,执行效率就会非常高效
         语法:
              create [or replace] procedure 存储过程的名称(参数名 in|out 参数类型,参数名 in|out 参数类型)
              is | as
               --声明部分
              begin
               --业务逻辑 
              end; 
```



```sql
*/
--给指定员工涨薪,并打印涨薪前和涨薪后的工资
/*
    参数 : in 员工编号
    参数 : in 涨多少
    
    声明一个变量 : 存储涨工资前的工资
    
    查询出当前是多少
    打印涨薪前的工资
    更新工资
    打印涨薪后的工资          
*/
create or replace procedure proc_updatesal(vempno in number,vnum in number)
is
   --声明变量.记录当前工资
   vsal number;    
begin
  --查询当前的工资
  select sal into vsal from emp where empno = vempno;
  --输出涨薪前的工资
  dbms_output.put_line('涨薪前:'||vsal);
  --更新工资
  update emp set sal = vsal + vnum where empno = vempno;
  --输出涨薪后的工资
  dbms_output.put_line('涨薪后:'||(vsal+vnum));
  --提交
  commit;
end;

--调用方式1
call proc_updatesal(7788,10);

--调用方式2 用的最多的方式
declare

begin
  proc_updatesal(7788,-100);
end;
```

# 十九、存储函数

## 1、基本语法和例子

存储函数: 实际上是一段封装是Oracle服务器中的一段PLSQL代码片断,它是已经编译好了的代码片段
​        
​        语法: 
​             create [or replace] function 存储函数的名称(参数名 in|out 参数类型,参数名 in|out 参数类型) return 参数类型
​             is | as
​             
​             begin
​               
             end;
        存储过程和函数的区别:
             1.它们本质上没有区别
             2.函数存在的意义是给过程调用   存储过程里面调用存储函数
             3.函数可以在sql语句里面直接调用
             4.存储过程能实现的,存储函数也能实现,存储函数能实现的,过程也能实现
             
        默认是 in     
```sql
*/
--查询指定员工的年薪
/*
    参数 : 员工的编号
    返回 : 年薪          
*/
create or replace function func_getsal(vempno number) return number
is
  --声明变量.保存年薪
  vtotalsal number;     
begin
  select sal*12 + nvl(comm,0) into vtotalsal from emp where empno = vempno;
  return vtotalsal;
end;

--调用存储函数
declare
  vsal number;
begin
  vsal := func_getsal(7788);
  dbms_output.put_line(vsal);
end;
```



## 2、java调用存储过程、存储函数

1）基本套路

```sql
/*
    JAVA调用存储过程
       JDBC的开发步骤:
          1.导入驱动包
          2.注册驱动
          3.获取连接
          4.获取执行SQL的statement
          5.封装参数
          6.执行SQL
          7.获取结果
          8.释放资源   
*/

/*
   封装一个存储过程 : 输出所有表中的记录
   
   输出类型 : 游标  
*/
create or replace procedure proc_getemps(vrows out sys_refcursor)
is

begin
  --1.打开游标, 给游标赋值
  open vrows for select * from emp;
end;
```

2）调用存储过程

```java
/**
	 * 查询指定员工的年薪，用存储过程实现
	 * create or replace procedure proc_gettotalsal(vempno in number,vtotalsal out number)
		is
		       
		begin
		  select sal*12 + nvl(comm,0) into vtotalsal from emp where empno = vempno;
		end;
	 * @throws Exception
	 */
	public void test1() throws Exception {
		//注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//获取连接
		String url="jdbc:oracle:thin:@106.13.43.205:1521:orcl";
		String user="canghe";
		String password="canghe";
		Connection conn = DriverManager.getConnection(url, user, password);
		//获取执行对象
		String sql="{call proc_gettotalsal(?,?)}";
		CallableStatement state = conn.prepareCall(sql);
		//为问号赋值
		state.setInt(1, 7654);//设置员工编号
		state.registerOutParameter(2, OracleTypes.NUMBER);
		//执行statement
		state.execute();
		//获取结果
		int totle = state.getInt(2);
		//输出结果
		System.out.println(totle);
		//释放资源
		state.close();
		conn.close();
	}
```

3）调用存储函数

```java
//调用存储函数
		/*
		 create or replace function func_getsal(vempno number) return number
			is
			  --声明变量.保存年薪
			  vtotalsal number;     
			begin
			  select sal*12 + nvl(comm,0) into vtotalsal from emp where empno = vempno;
			  return vtotalsal;
			end; 
		 */
public void test2() throws Exception{
			//注册驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接
			String url = "jdbc:oracle:thin:@106.13.43.205:1521:orcl";
			String username = "canghe";
			String password = "canghe";
			Connection conn = DriverManager.getConnection(url, username,password);
			//3.获取执行SQL的statement
			String sql = " {?= call func_getsal(?)}";
			CallableStatement state = conn.prepareCall(sql);
			//4.封装参数
			//注册返回类型参数
			state.registerOutParameter(1, OracleTypes.NUMBER);
			//设置第二个参数
			state.setInt(2, 7788);
			//5.执行SQL
			state.execute();		
			//6.获取结果
			int totalsal = state.getInt(1);
			System.out.println("年薪 :  ====" +totalsal);		
			//7.释放资源
			state.close();
			conn.close();
		}
```

3）通过游标输出结果集

```java
/**
	 * 通过游标输出结果集
	 * @throws Exception
	 */
	public void test3() throws Exception{
		//注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.获取连接
		String url = "jdbc:oracle:thin:@106.13.43.205:1521:orcl";
		String username = "canghe";
		String password = "canghe";
		Connection conn = DriverManager.getConnection(url, username,password);
		//3.获取执行SQL的statement
		String sql = "{call proc_getemps(?)}";
		CallableStatement call = conn.prepareCall(sql);
		//接口  --- > 对象 -->实现类的名称
		System.out.println(call.getClass().getName());
		OracleCallableStatement oracleCall = (OracleCallableStatement)call;
		//4.注册输出类型的参数
		call.registerOutParameter(1, OracleTypes.CURSOR);
		//5.执行SQL
		call.execute();
		//6.获取执行的结果
		ResultSet resultSet = oracleCall.getCursor(1);
		while(resultSet.next()){
			int empno = resultSet.getInt("empno");
			String name = resultSet.getString("ename");
			System.out.println(empno +" ==== "+name);
		}
		
		//7.释放资源
		resultSet.close();
		call.close();
		conn.close();
	}
```

# 二十、触发器

```
触发器: 当用户执行了 insert | update | delete 这些操作之后, 可以触发一系列其它的动作/业务逻辑
       作用 : 
            在动作执行之前或者之后,触发业务处理逻辑
            插入数据,做一些校验
            
       语法:
           create [or replace] trigger 触发器的名称
           before | after
           insert | update | delete 
           on 表名
           [for each row]
           declare
           
           begin
             
           end;
           
       触发器的分类:
           语句级触发器:   不管影响多少行, 都只会执行一次
           
           行级触发器:     影响多少行,就触发多少次
                  :old  代表旧的记录, 更新前的记录
                  :new  代表的是新的记录
```



```sql
--新员工入职之后,输出一句话: 欢迎加入黑马程序员
create or replace trigger tri_test1
after
insert
on emp
declare

begin
  dbms_output.put_line('欢迎加入黑马程序员');
end;

insert into emp(empno,ename) values(9527,'HUAAN');

--数据校验, 星期六老板不在, 不能办理新员工入职
--在插入数据之前
--判断当前日期是否是周六
--如果是周六,就不能插入
create or replace trigger tri_test2
before
insert 
on emp
declare
 --声明变量
 vday varchar2(10);
begin
  --查询当前
  select trim(to_char(sysdate,'day')) into vday from dual;
  --判断当前日期:
  if vday = 'saturday' then
     dbms_output.put_line('老板不在,不能办理入职');
     --抛出系统异常
     raise_application_error(-20001,'老板不在,不能办理入职');
  end if;
end;

insert into emp(empno,ename) values(9528,'HUAAN2');

--更新所有的工资 输出一句话
create or replace trigger tri_test3
after
update
on emp 
for each row
declare

begin
  dbms_output.put_line('更新了数据');
end;

update emp set sal = sal+10;



--判断员工涨工资后的工资一定要大于涨工资前的工资
/*
   200 --> 100
   触发器 : before
      旧的工资 
      新的工资
      如果旧的工资大于新的工资 , 抛出异常,不让它执行成功   
      
      
   触发器中不能提交事务,也不能回滚事务 
*/
create or replace trigger tri_updatesal
before
update
on emp
for each row
declare

begin
  if :old.sal > :new.sal then
    raise_application_error(-20002,'旧的工资不能大于新的工资');
  end if;
end;

update emp set sal = sal + 10;
select * from emp;

update emp set sal = sal - 100;


/*
   模拟mysql中ID的自增属性 auto_increment 
   insert into person(null,'张三');  
   
   触发器:
   
   pid=1  insert  pid=1
   
   序列 : create sequence seq_person_pid;       
*/
create table person(
    pid number primary key,
    pname varchar2(20)   
);

insert into person values(null,'张三'); 

create sequence seq_person_pid;

--触发器
create or replace trigger tri_add_person_pid
before
insert
on person
for each row
declare

begin
  dbms_output.put_line(:new.pname);
  --给新记录 pid 赋值
  select seq_person_pid.nextval into :new.pid from dual;
end;

insert into person values(null,'张三'); 


select * from person;
```

# 二十一、数据库设计

# 二十一、数据库优化

1.优化SQL:提升sql语句的执行效率
​	1) 查询语句中尽量不使用"*"
​	2) 查询语句中尽量将筛选效果好的条件放在前面
​	3) 可以使用连接查询替代子查询时, 尽量使用连接查询
​	4) 将模糊查询条件尽量放在后面
​	5) 将带有索引的字段条件放在前面
​	6) 可以使用in/not in/between替代的场合,就替代使用
​	
2.优化索引
​	1) 不能随意添加
​	2) 为使用量大的字段添加
3.优化表分区(分区表)
​	根据指定字段将数据表的数据(数据巨大时), 划分成多个分区.
​	查询时, 首先判断数据所在分区, 再检索数据
​	
​	
4.优化系统