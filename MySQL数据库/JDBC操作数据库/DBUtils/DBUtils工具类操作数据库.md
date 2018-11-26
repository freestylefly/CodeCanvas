# 一、DButils工具类介绍和三个核心类

## 1、DButils工具类介绍

- DBUtils是java编程中的数据库操作实用工具，小巧简单实用。
- DBUtils封装了对JDBC的操作，简化了JDBC操作，可以少写代码。
- DBUtils就是JDBC的简化开发工具包。需要项目导入commons-dbutils-1.6.jar才能够正常使用DBUtils工具。
- DButils相当于之前写的BaseDao，而且比其更实用，提供了一系列方法对数据库进行更加复杂的操作

## 2、Dbutils三个核心功能（核心类）介绍

- QueryRunner中提供对sql语句操作的API.
  - update(Connection conn, String sql, Object... params) ，用来完成表数据的增加、删除、更新操作
  - query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) ，用来完成表数据的查询操作

- ResultSetHandler接口，用于定义select操作后，怎样封装结果集.
- DbUtils类，它就是一个工具类,定义了关闭资源与事务处理的方法

# 二、QueryRunner类的update方法介绍

- update(Connection conn, String sql, Object... params) ，用来完成表数据的增加、删除、更新操作
- 使用QueryRunner类,实现对数据表的insert delete update
- 调用QueryRunner类的方法 update (Connection con,String sql,Object...param)
  -  Object...param 可变参数,Object类型,SQL语句会出现?占位符
  - 数据库连接对象,自定义的工具类传递

## 1、QueryRunner类实现insert添加数据

案例代码

```java
/*
				 * 定义方法,使用QueryRunner类的方法update向数据表中,添加数据
				 */
				public static void insert()throws SQLException{
					//创建QueryRunner类对象
					QueryRunner qr = new QueryRunner();
					String sql = "INSERT INTO sort (sname,sprice,sdesc)VALUES(?,?,?)";
					//将三个?占位符的实际参数,写在数组中
					Object[] params = {"体育用品",289.32,"购买体育用品"};
					//调用QueryRunner类的方法update执行SQL语句
					int row = qr.update(con, sql, params);
					System.out.println(row);
					DbUtils.closeQuietly(con);
				}
```

## 2、QueryRunner类实现update修改数据

案例代码

```java
/*
				 *  定义方法,使用QueryRunner类的方法update将数据表的数据修改
				 */
				public static void update()throws SQLException{
					//创建QueryRunner类对象
					QueryRunner qr = new QueryRunner();	
					//写修改数据的SQL语句
					String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
					//定义Object数组,存储?中的参数
					Object[] params = {"花卉",100.88,"情人节玫瑰花",4};
					//调用QueryRunner方法update
					int row = qr.update(con, sql, params);
					System.out.println(row);
					DbUtils.closeQuietly(con);
				}				
```

## 3、QueryRunner类实现delete删除数据

案例代码

```java
				/*
				 *  定义方法,使用QueryRunner类的方法delete将数据表的数据删除
				 */
				public static void delete()throws SQLException{
					//创建QueryRunner类对象
					QueryRunner qr = new QueryRunner();	
					//写删除的SQL语句
					String sql = "DELETE FROM sort WHERE sid=?";
					//调用QueryRunner方法update
					int row = qr.update(con, sql, 8);
					System.out.println(row);
					/*
					 *  判断insert,update,delete执行是否成功
					 *  对返回值row判断
					 *  if(row>0) 执行成功
					 */
					DbUtils.closeQuietly(con);
				}				
```

# 三、JavaBean类

JavaBean就是一个类，在开发中常用封装数据。具有如下特性

1. 需要实现接口：java.io.Serializable ，通常实现接口这步骤省略了，不会影响程序。
2. 提供私有字段：private 类型 字段名;
3. 提供getter/setter方法：
4. 提供无参构造

# 四、DBUtils工具类结果集处理的方式

QueryRunner实现查询操作：query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) ，用来完成表数据的查询操作

|                         ArrayHandler                         |                       ArrayListHandler                       |                   BeanHandler                    |                       BeanListHandler                        |                ColumnListHandler                 |                   ScalarHandler                   |                       MapHandler                       |                        MapListHandler                        |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------: | :-----------------------------------------------: | :----------------------------------------------------: | :----------------------------------------------------------: |
| 将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值 | 将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。 | 将结果集中第一条记录封装到一个指定的javaBean中。 | 将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中 | 将结果集中指定的列的字段值，封装到一个List集合中 | 它是用于单数据。例如select count(*) from 表操作。 | 将结果集第一行封装到Map集合中,Key 列名, Value 该列数据 | 将结果集第一行封装到Map集合中,Key 列名, Value 该列数据,Map集合存储到List集合 |



# 五、QueryRunner的方法query实现查询操作

- 调用QueryRunner类方法query(Connection con,String sql,ResultSetHandler r, Object..params)
-   ResultSetHandler r 结果集的处理方式,传递ResultSetHandler接口实现类
- Object..params SQL语句中的?占位符
- 注意: query方法返回值,返回的是T 泛型, 具体返回值类型,跟随结果集处理方式变化

## 1、结果集第一种处理方法, ArrayHandler

**将结果集的第一行存储到对象数组中  Object[]，,只返回结果集的第一行**

```java
public static void arrayHandler() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM master";
		// 调用方法query执行查询,传递连接对象,SQL语句,结果集处理方式的实现类
		// 返回对象数组
		Object[] result = qr.query(conn, sql, new ArrayHandler());
		// 遍历数组
		for (Object obj : result) {
			System.out.print(obj);
		}
	}
```

## 2、结果集第二种处理方法,ArrayListHandler

**将结果集的每一行,封装到对象数组中, 出现很多对象数组,对象数组存储到List集合**

```java
public static void arrayListHandler() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM master";
		// 调用query方法,结果集处理的参数上,传递实现类ArrayListHandler
		// 方法返回值 每行是一个对象数组,存储到List
		List<Object[]> result = qr.query(conn, sql, new ArrayListHandler());
		// 遍历集合
		for (Object[] objs : result) {
			// 遍历对象数组
			for (Object obj : objs) {
				System.out.print(obj + "  ");
			}
			System.out.println();
		}
	}
```

## 3、结果集第三种处理方法,BeanHandler

**将结果集的第一行数据,封装成JavaBean对象 注意: 被封装成数据到JavaBean对象,，Master类必须有空参数构造**

```java
public static void beanHandler() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM master";
		// 调用方法,传递结果集实现类BeanHandler
		// BeanHandler(Class<T> type)
		Master master = qr.query(conn, sql, new BeanHandler<Master>(Master.class));
		System.out.println(master);
	}
```

## 4、结果集第四种处理方法, BeanListHandler

**结果集每一行数据,封装JavaBean对象 多个JavaBean对象,存储到List集合**

```java
public static void beanListHander() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM master";
		// 调用方法query,传递结果集处理实现类BeanListHandler
		List<Master> list = qr.query(conn, sql, new BeanListHandler<Master>(Master.class));
		for (Master m : list) {
			System.out.println(m);
		}
	}
```

## 5、结果集第五种处理方法,ColumnListHandler

 **结果集,指定列的数据,存储到List集合,指定咧的所有数据如name列就会返回所有的名字，List<Object> 每个列数据类型不同**

```java
public static void columnListHandler()throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM master ";		
		//调用方法 query,传递结果集实现类ColumnListHandler
		//实现类构造方法中,使用字符串的列名
		List<Object> list =qr.query(conn, sql, new ColumnListHandler<Object>("name"));
		for(Object o:list) {
			System.out.println(o);
		}
	}
```

## 6、结果集第六种处理方法,ScalarHandler

**对于查询后,只有1个结果,返回一个结果**

```java
public static void scalarHandler()throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT COUNT(*) FROM Master";
		//调用方法query,传递结果集处理实现类ScalarHandler
		long count = qr.query(conn, sql, new ScalarHandler<Long>());
		System.out.println(count);
	}
```

## 7、结果集第七种处理方法,MapHandler

**将结果集第一行数据,封装到Map集合中,只有第一行，Map<键,值> 键:列名  值:这列的数据**

```java
public static void mapHandler()throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT  * FROM master";
		//调用方法query,传递结果集实现类MapHandler
		//返回值: Map集合,Map接口实现类, 泛型
		Map<String,Object> map = qr.query(conn, sql, new MapHandler());
		//遍历Map集合
		for(String key:map.keySet()) {
			System.out.println(key+"\t"+map.get(key));
		}
	}
```

## 8、结果集第八种处理方法,MapListHandler

**将结果集每一行存储到Map集合,键:列名,值:数据，Map集合过多,存储到List集合，集合里面嵌套集合， map集合有一个有序的map集合，在hashmap子类linkedHashmap，打印map.getClass即可找到是因为内部类继承了linkedHashmap，是有顺序的**

```java
public static void mapListHandler()throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT  * FROM master";
		//调用方法query,传递结果集实现类MapListHandler
		//返回值List集合, 存储的是Map集合
		List<Map<String,Object>> list =qr.query(conn, sql, new MapListHandler());
		for(Map<String,Object>map:list) {
			for(String key:map.keySet()) {
				System.out.print(key+map.get(key));
			}
			System.out.println();
		}
	}
```

