<!--MarkdownTOC-->

- [XML简介](#XML简介)
- [XML文档结构](#XML文档结构)
- [XML编写注意事项](#XML编写注意事项)
- [XML命名空间](#XML命名空间)
- [验证XML文档](#验证XML文档)
- [DOM解析XML](#DOM解析XML)
- [dom4j](#dom4j)

<!-- /MarkdownTOC-->



XML简介

1、XML是可扩展标记语言
2、与操作系统和操作平台均无关
3、规范统一，支持异构系统
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181101180436240.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

# XML文档结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181101180551962.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 1、XML声明

<?xml version="1.0" encoding="UTF-8" ?>
<font color=red>
注意：这里需要修改的encoding，如果出现乱码，需要改成GBK
<font/>

## 2、标签

元素名     元素属性名=“属性值”  元素内容
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018110118223759.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 3、根元素

写在声明下面的标签元素，有且只有一个根元素

## 4、属性

一个元素可以有多个属性，多个属性之间用空格分开
<font color=red size=5>
注意：属性可以加在任何一个元素的其实标签上，但不能加在结束标签上，且不能包含特殊字符< " .&
<font/>

## 5、特殊字符的处理

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181101182809133.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

# XML编写注意事项
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181101182921224.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

# XML命名空间
命名空间是在解析XML文档时，对于重名的元素，可能出现解析冲突，他们用来标识来自特定域（标准组织、公司、行业）的名称
除非带有前缀，否则属性属于他们的元素所在的命名空间
# 验证XML文档
DTD验证
# DOM解析XML
## 1、步骤

<font color=Gold size=4>

### （1）创建解析器工厂

```java
DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
```
<font/>

<font color=Gold size=4>

### （2）创建解析器

```java
DocumentBuilder builder =factory.newDocumentBuilder();
```
<font/>

<font color=Gold size=4>

### （3）获得Document

```java
document=builder.parse("src/info.xml");
```
<font/>

<font color=Gold size=4>

### （4）创建解析器工厂

<font/>

以Document对象为起点对DOM树的节点进行增加、删除、修改查询等操作

## 2、关键代码（包含增删该查操作）

```java
package demo1;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test1 {
	private Document document;
	
	/**
	 * 创建Document对象
	 * @throws IOException 
	 * @throws Exception 
	 */
	public void getDoc() throws Exception, IOException {
		//解析器工厂
		DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder =factory.newDocumentBuilder();
		//获得Document
		document=builder.parse("src/info.xml");
	}
	
	
	/**
	 * 保存XM
	 * @throws Exception 
	 */
	public void save() throws Exception {
		TransformerFactory factory =TransformerFactory.newInstance();
		factory.setAttribute("indent-number", 4);//天假空白
		Transformer transformer=factory.newTransformer();
		//设置格式
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "YES");
		DOMSource xmlSource =new DOMSource(document);
		StreamResult outputTarget =new StreamResult(new FileOutputStream("src/info.xml"));
		transformer.transform(xmlSource, outputTarget);
	}
	
	/**
	 * 增加新手机节点
	 * @throws Exception 
	 */
	public void add() throws Exception {
		getDoc();
		Element eleBrand=document.createElement("Brand");
		eleBrand.setAttribute("name", "小米手机");
		//获得根元素
		Element root=(Element) document.getElementsByTagName("PhoneInfo").item(0);
		root.appendChild(eleBrand);
		save();
	}
	
	/**
	 * 修改
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void change() throws IOException, Exception {
		getDoc();
		NodeList brands = document.getElementsByTagName("Brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brandNode=brands.item(i);
			Element eleBrand =(Element) brandNode;
			String brandName =  eleBrand.getAttribute("name");
			if(brandName.equals("苹果")) {
				eleBrand.setAttribute("name", "apple");
				save();
			}
		}
	}
	/**
	 * 删除
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void delate() throws Exception, Exception {
		getDoc();
		NodeList brands = document.getElementsByTagName("Brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brandNode=brands.item(i);
			Element eleBrand =(Element) brandNode;
			String brandName =  eleBrand.getAttribute("name");
			if(brandName.equals("苹果")) {
				eleBrand.getParentNode().removeChild(eleBrand);
				save();
			}
		}
	}
	
	/**
	 * 显示
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void show() throws IOException, Exception {
		getDoc();
		//获得brand节点
		NodeList brands=document.getElementsByTagName("Brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brandNode =brands.item(i);
			Element eleBrand =(Element) brandNode;
			System.out.println(eleBrand.getAttribute("name"));
			//获得brand下的子节点
			NodeList types=eleBrand.getChildNodes();
			for (int j = 0; j < types.getLength(); j++) {
				Node typeNode=types.item(j);
				if(typeNode.getNodeType()==Node.ELEMENT_NODE) {
					Element eleType = (Element) typeNode;
					System.out.println("\t"+eleType.getAttribute("name"));
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException, Exception {
		Test1 t = new Test1();
		t.show();
		t.add();
		t.change();
		t.delate();
	}
}

```
## 3、注意区别这几个关键词

<font color=red size=5>
Document:
<font/>

可操作整个DOM树
<font color=red size=5>
Node
<font/>

代表节点（节点又分为元素节点、文本节点），其中元素节点又叫标签节点，是带有尖括号的，换行在XML中也被认为是节点
<font color=red size=5>
Element
<font/>

元素节点，是Node的一个子类
<font color=red size=5>
Atteabute
<font/>

凡是对属性进行操作的
<font color=red size=5>
item
<font/>

从NodeList中获得Node，要通过循环遍历

# dom4j

## 1、方法：

百度dom4j，看官方帮助文档，里面会有一系列的方法。

![1541405704330](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1541405704330.png)

## 2、显示xml信息

```java
public class Test1 {
	public static void main(String[] args) throws Exception {
		//获取domcument对象
		SAXReader reader = new SAXReader();
		Document doc =reader.read("src//info.xml");
		
		//获取根元素
		Element root =doc.getRootElement();
		
		//循环遍历输出子节点
		Iterator<Element> it=root.elementIterator();
		while(it.hasNext()) {
			Element brandEle = it.next();
			String strBrand=brandEle.attributeValue("name");
			Iterator<Element> it2=brandEle.elementIterator();
					while(it2.hasNext()){
						Element typeEle=it2.next();
						String strType=typeEle.attributeValue("name");
						System.out.println("品牌："+strBrand+"\t"+"型号："+strType);
					}
		}
	}

}
```

## 3、保存xml文件

```java
//保存
		 OutputFormat format =OutputFormat.createPrettyPrint();
		 XMLWriter writer = new XMLWriter(new FileWriter("src//info.xml"),format);
         writer.write( doc );
         writer.close();
```

## 4、添加信息

```java
//添加
		Element eleBrand = root.addElement("Brand");
		eleBrand.addAttribute("name", "小米");
		eleBrand.addText("这是小米手机");
```

## 5、修改&删除

```java
// 修改
		Iterator<Element> it = root.elementIterator();
		while (it.hasNext()) {
			Element brandEle = it.next();
			Attribute att = brandEle.attribute("name");
			if (att.getValue().equals("三星")) {
				//修改
//				att.setValue("sanxing");
				//删除属性对象（包括属性名和属性值）
//				brandEle.remove(att);
				//删除整个brand三星
				brandEle.getParent().remove(brandEle);
			}
```

