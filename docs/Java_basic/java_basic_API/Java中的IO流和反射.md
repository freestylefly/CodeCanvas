## 一、定义
流是指一连串流动的字符，是以先进先出的方式发送信息的通道。程序和数据之间是通过流进行关联的。
## 二、分类
1、按流向分
输出流：OutputStream和Writer作为基类
输入流：InputStream和Reader作为基类
2、按处理数据的单元划分
字节流：nputStream/OutputStream作为基类
字符流：Reader/Writer作为基类
## 三、流之间的层级关系
上层为基类
1、输入
Reader
InputStreamReader(可设置字符编码)    Bufferendreader(带有缓冲区)
InputStream
FileInputStream objecInputStream（反序列化） DateInputStream（读二进制文件）
2、输出
Writer
OuputStreamWriterr(可设置字符编码)    BufferendWriterr(带有缓冲区)
InputStream
FileOutputStream objecOutputStream（序列化） DateIOutputStream（读二进制文件）

## 四、流的正确使用
1、File类操作文件

```java
package demo1;

import java.io.File;
import java.io.IOException;

/*
 * 使用File类创建文件,并实现更删除、显示文件名和路径操作
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\test1.txt");
		if(!file.exists()) {
			file.createNewFile();//不存在创建
		}else {
			file.delete();//存在删除
		}
		System.out.println("该文件的绝对路径名为"+file.getAbsolutePath());
		System.out.println("该文件名为："+file.getName());
	}
}

```
**特别注意：创建File对象的时候可以放决相对路径也可以放决对路径**
直接写test.txt代表的是在该项目底下的文件
而如果携程D:\\test.txt的话是代表此文件 在D盘下的文件

File类常用方法：
| 方法 | 说明 |
|--|--|
| boolean exisit() | 判断文件是否存在 |
| String getName() | 获得文件名 |
| boolean creatNewFile() | 创建文件（创建前要判断文件是否存在 ） |

2、使用字节流FileInputStream读文本文件

```java
package demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 字节流FileInputStream读取文件
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		File file =new File("demo2.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[fis.available()];
		int data=-1;
		while((data=fis.read(b))!=-1) {
		}
		String str = new String(b);//将字节数组变为字符串
		System.out.println(str);
		
		fis.close();
	}
}

```
FileInputStream 常用方法
| 方法 | 说明 |
|--|--|
| inr read((byte[] b) | 将数据缓存在字节数组中最后通过String的构造方法将字节数组转换成字符串输出 |
|int read() | 一个字节一个字节的读 |
3、使用字节流FileInputStream和FileOutputStream复制文本文件

```java
package demo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 复制文件
 */
public class Test2 {
	public static void main(String[] args) {
		FileInputStream fis =null;
		
		FileOutputStream fos=null;
		
		try {
			fis= new FileInputStream("D:\\demo1.txt");
			byte[] b = new byte[fis.available()];
			int date =-1;
			while((date=fis.read(b))!=-1){
			}
			
			fos = new FileOutputStream("E:\\Java\\java学习\\代码\\demo1.txt");
			fos.write(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=fos){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=fis){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

```

4、使用DataInputStream和DataOutputStream读写二进制文件

```java
package demo3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*
 * 复制图片,二进制流的应用
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		DataInputStream dis = new DataInputStream(new FileInputStream("D:\\1.jpg"));
		DataOutputStream  dos =new DataOutputStream(new FileOutputStream("E:\\Java\\java学习\\代码\\t.jpg"));
		
		int date=-1;
		while((date=dis.read())!=-1){
			dos.write(date);
		}
		
		dos.close();
		dis.close();
	}
}

```
5、字符流FileReader & FileWriter

```java
package demo4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * 字符流FileReader & FileWriter
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("demo2.txt");
		//方式一、一个字符一个字符的读
//		int date=-1;
//		while((date=fr.read())!=-1) {
//			System.out.print((char)date);
//		}
		
		//方式二：字符数组读文件
		char[] c = new char[1024];
		int data =-1;
		while((data=fr.read(c))!=-1) {
			
		}
		System.out.println(c);
		
		//为读出的文本文件追加字符
		FileWriter fw = new FileWriter("demo2.txt",true);
		fw.write("我做主");
		
		//关闭流
		fw.close();
		fr.close();
	}
}

```
6、使用带有缓冲区的流输入输出，异常处理

```java
package demo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/*
 * 使用带有缓冲区的流输入输出，异常处理
 */
public class Test1 {
	public static void main(String[] args) {

		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			// 读取文件
			is = new FileInputStream("demo5.txt");
			isr = new InputStreamReader(is, "GBK");
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println(info);
			}
			// 写入新的文本
			bw = new BufferedWriter(new FileWriter("demo5.txt", true));//熟悉之后都可以采用这种方式进行简写
			bw.newLine();
			bw.write("今天也要元气满满哦！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {//注意如果不管流的话会导致很多东西出现bug，如果有bug先找是否正确的关闭流了
			if (null != bw) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != isr) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

```
注意指定字符编码，请确认是GBK还是UTF-8
## 五、一个重要综合性利用流的例子

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class IoDemo1 {
	public static void main(String[] args) {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			// 读
			is = new FileInputStream("t1.txt");
			isr = new InputStreamReader(is, "GBK");
			br = new BufferedReader(isr);
			String info = br.readLine();
			System.out.println(info);
			// 写
			os = new FileOutputStream("t2.txt",true);
			osw = new OutputStreamWriter(os, "GBK");
			bw = new BufferedWriter(osw);
			bw.newLine();
			bw.write(info);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				osw.close();
				os.close();
				br.close();
				isr.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

```
 特别注意：一定要关闭流，有时候没关闭会出现很多的错误
## 六、序列化和反序列化
1、使用序列化保存对象信息（写出 objecOutputStream）

 2、使用反序列化获取对象信息（写出 objecInputStream）
 3、例子：
 

```java
package Demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 序列化和反序列化
 */
public class Test1 {
	public static void main(String[] args) throws Exception, IOException {
		ArrayList<Student> list = new ArrayList<Student>();
		Student stu1 =new Student("jck",12,"男");
		Student stu2 =new Student("lick",13,"男");
		Student stu3 =new Student("as",12,"女");
		
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		//反序列化储存
		
		ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("demo1.txt"));
		oos.writeObject(list);
		
		//反序列化
		ObjectInputStream ois =new ObjectInputStream(new FileInputStream("demo1.txt"));
		Object obj=ois.readObject();
		ArrayList<Student> stuList = (ArrayList<Student> )obj;
		for(int i =0;i<stuList.size();i++) {
			Student stu=stuList.get(i);
			System.out.println(stu);
		}
		
		
	}
}

```
## 七、反射

```java
package Demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {
	public static void main(String[] args) {
		//先获取Student类对应的Class对象
		Class cla=Student.class;
		
		//获取所有构造方法
		Constructor[] cons=cla.getConstructors();
		
		//获取所有构造方法的个数
		System.out.println(cons.length);
		
		//获取所有构造方法名字
		for (int i = 0; i < cons.length; i++) {
			System.out.println(cons[i].getName());
		}
		
		//获取共有的属性(只能是public修饰的)
		Field[] fields=cla.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
		//获取所有的属性
		Field[] fis=cla.getDeclaredFields();
		for (int i = 0;  i< fis.length; i++) {
			System.out.println(fis[i].getType());
		}
		
		//获取类的方法
		Method[] methods=cla.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
		}
	}
}

```

```java
package Demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射使用有参构造方法构造Student对象
 * @author Administrator
 *
 */
public class Test2 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//获取Student对应的Class对象
		Class<Student> cla=Student.class;
		//获取Class对象中的构造方法
		Constructor<Student> cons=cla.getConstructor(String.class,int.class,String.class);
		//为构造方法传递参数
		Student stu=cons.newInstance("jack",100,"123456");
		System.out.println(stu);
	}
}

```

```java
package Demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
 * 通过反射使用有参构造方法构造Student对象
 */
public class Test3 {
	public static void main(String[] args) throws Exception, SecurityException {
		//获取Student的class对象
		Class cla = Student.class;
		//获取Class对象中的构造方法
		Constructor<Student> cons=cla.getConstructor();
		Student stu=cons.newInstance();
		//获得指定set方法为属性赋值
		Method setNameMethod=cla.getDeclaredMethod("setName", String.class);
		setNameMethod.invoke(stu, "jack");
		Method setAgeMethod=cla.getDeclaredMethod("setAge", int.class);
		setAgeMethod.invoke(stu, 18);
		Method setSexMethod=cla.getDeclaredMethod("setSex", String.class);
		setSexMethod.invoke(stu, "男");
		
		
		
		System.out.println(stu);
	}
}

```

```java
package Demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
 *通过反射直接为私有属性赋值 
 */
public class Test4 {
	public static void main(String[] args) throws Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 获取Student的class对象
		Class cla = Student.class;
		// 获取Class对象中的构造方法
		Constructor<Student> cons = cla.getConstructor();
		Student stu = cons.newInstance();
		
		//访问私有成员
		Field nameField=cla.getDeclaredField("name");
		//获取私有属性的操作权限
		nameField.setAccessible(true);
		nameField.set(stu, "张三");
		
		Field ageField=cla.getDeclaredField("age");
		//获取私有属性的操作权限
		ageField.setAccessible(true);
		ageField.set(stu, 30);
		Field sexField=cla.getDeclaredField("sex");
		//获取私有属性的操作权限
		sexField.setAccessible(true);
		sexField.set(stu, "男");
		
		
		System.out.println(stu);
	}
}

```
反射机制在java框架中会用到！
掌握流的类名，通过相关的构造方法去构造流！
