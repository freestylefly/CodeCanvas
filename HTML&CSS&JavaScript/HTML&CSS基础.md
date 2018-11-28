# 一、HTML5基础

## 1、HTML概述

HTML: Hyper Text Markup Language 超文本标记语言

超文本: 比普通文本功能更加强大,可以添加各种样式

标记语言: 通过一组标签.来对内容进行描述. <关键字> , 是由浏览器来解释执行

## 2、HTML语法规范

标签：不区分大小写，但是建议用小写

```
<!--
	1. 上面是一个文档声明 
	<meta charset="UTF-8"/>设置字符集编码
	2. 根标签 html
	3. html文件主要包含两部分. 头部分和体部分
		头部分 : 主要是用来放置一些页面信息
		体部分 : 主要来放置我们的HTML页面内容
	4. 通过标签来对内容进行描述,标签通常都是由开始标签和结束标签组成  
	5. 标签不区分大小写, 官方建议使用小写
-->
```

## 3、基本标签

```
<p></p>:标题标签
<br/>换行
<hr/>水平线
<strong></strong>加粗
<en></en>倾斜


```

## 4、特殊符号转义

|   空格   | 大于号 | 大于号 |   引号   | 版权符号（&copy;） |
| :------: | :----: | :----: | :------: | :----------------: |
| `&nbsp;` | `&gt;` | `&lt;` | `&quot;` |      `&copy`       |

## 5、图像标签

```
<img src="" alt=""/>
```

​	常用的属性;

​		width : 宽度

​		height: 高度

​		src :  指定文件路径

​		alt:  图片加载失败时的提示内容

注意：img标签是块集标签，但是可以设置行高和宽高

## 6、文件路径

​		./  代表的是当前路径
​		../ 	代表的上一级路径
​		../../	上上一级路径

## 7、超链接标签

```
<a href="超链接路径" target="_blank"></a>
```

- 其中target为在哪个窗口打开：_self为默认在本页面打开

_blank在新窗口打开

- 去除超链接下划线：text-decoration：none

- href=#表示链接到当前页面

- 超链接的应用场合

  1. 页面间链接：A页到B页

  2. 锚链接

     同页面内容的相互跳转：

     - 在页面乙位置放置标记，可以设置name或者id用a标签包裹，然后在需要超链接的位置放上#加name的值即可

     ```html
     <a name="login">登录</a>
     <a href="#register">[新用户注册帮助]</a>
     ```

     - 在不同页面的锚链接

       ```html
        <a href="help.html#register">[新用户注册帮助]</a>
        <a name="login">登录</a>
       ```

  3. 功能性链接

     加上mailto：邮箱地址

## 8、行内元素和块级元素

- 行内元素除了img无法设置宽高
- 款即元素前后有空行独占一行

# 二、列表

## 1、是块级元素

## 2、分类

- ## 无序列表

  ul无序列表定义

  li列表内容

  type: 

  1. 实心圆（默认）：disc
  2. ,空心圆circle
  3.  小方块square
  4. 去掉项目符号：null

- ## 有序列表

  ol有序列表定义

  li列表内容

  type: 1,a ,A,I,

  ​		start : 指定是起始索引

- ## 自定义列表

dl——声明定义列表

dt——声明列表项

dd——定义列表项内容

## 3、列表样式

| list-style | list-style-type | list-style-image | list-style-position |
| :--------: | :-------------: | :--------------: | :-----------------: |
|            |                 |                  |                     |



# 三、表格

## 1、基本概念

- table：

  tr：行

  td列（th代表第一行是定义行会加粗）

  ## 2、常用属性

- table里属性：

  ​	cellspacing：单元格外边距

  ​	cellpadding：单元格内边距

  ​	align：水平对齐方式（left、right、center）

  ​	不能加垂直对齐

  ​	bgcolor : 背景色

- 单元格对齐：

  垂直对齐：valign：（top、middle、bottom）

  水平对齐（left、right、center）

## 2、表格跨行和跨列

colspan：跨列

rowspan：跨行

# 三、表单

## 1、基本定义

```html
<form action="#" method="post">
	<input type="text" name="name" value="请输入姓名：" id=""
</form>
```

## 2、form标签内属性

- method：提交方式：post/get

  区别： 安全性、长度限制、URL中信息量是否拼接

-  action:  提交到哪里，#代表当前页面

## 3、input标签

### A、type类型

- text、password、radio（单选框）、CheckBox（复选框）、

- 按钮（有提交功能）：bottom（普通按钮）

​	   reset（重置按钮）

​	   image（图片按钮）

​	   submit（提交按钮）

- file文本域

  单独的一种提交方式，需要在form中添加 enctype=“multipart/form=data”

- hidden隐藏域

  通过指定的value属性，可用作后台处理数据，但是不需用显示出来

  - 不常用的：email、url、rang（范围，可设置max、min和步长step）、number （数量）、datetime-local（时间日期）

### B、name

最好加name，否则值可能获取不到

### C、value

在框中提示的词，需要删除替换的

### D、size

输入框长度

### E、maxlength

最大输入长度

### F、readenly

只读

### G、disable

禁用

### H、checked

默认值，设置此项为默认选项，在、radio（单选框）、CheckBox（复选框）的时候常用

### I、placeholder

提示信息（表单验证）

### J、required

不能为空，必填（表单验证）

### K、patterrn

patterrn=“正则表达式”（表单验证）

## 4、select下拉列表

```html
<select name="a"  id="c" size=3>
    <option value="2001" selected></option>
</select>
```

selected是默认选择的是哪一个

size为列表有几行

## 5、textarea

条款，条约

可以设置cols和rows设置显示列和行数

## 6、label标注

表单标注，语法为：

```html
<label for=""></label>
```

for里面加上id

常用于单选、复选为文字添加标注，目的是为了通过点击文字就可以到达对应的框里面

![表单](C:\Users\Administrator\Desktop\表单.jpg)

# 四、CSS浮动

- 定义：浮动的元素会脱离正常的文档流,在正常的文档流中不占空间

- float属性:
  ​				left
  ​				right

- style的clear属性: 清除浮动
  ​			both : 两边都不允许浮动
  ​			left: 左边不允许浮动
  ​			right : 右边不允许浮动

  ​			当下面div受到上面浮动影响加一个空的div清除浮动

  行高和高相等时，会居中

# 五、CSS选择器

## 1、css选择器

- 元素选择器: 标签的名称{}
- 类选择器:   以. 开头  .类的名称
- ID选择器:  以#开头 ,   #ID的名称  (ID必须是页面上面唯一) 

## 2、选择器优先级

- 按照选择器搜索精确度来编写:
- 就近原则: 哪个离得近,就选用哪个的样式
- 行内样式 > ID选择器 > 类选择器  > 元素选择器

## 3、css其他选择器

- 选择器分组: 选择器1,选择器2{ 属性的名称:属性的值}

- 属性选择器:

  ```html
  a[title]
  a[titile='aaa']
  a[href][title]
  a[href][title='aaa']
  ```

- 后代选择器: 

  爷爷选择器  孙子选择器   找出所有的后代，中间以空格隔开

- 子元素选择器:  父选择器  > 儿子选择器 ：只能找到父元素的直接后代

- 伪类选择器: 通常都是用在a标签上

  a:link {color:black}	未单击访问的链接

  a:hover{color:black}		鼠标悬浮其上的超链接样式

  a:active {color:black}	鼠标单击未释放的超链接样式

  a:visited {color:black}		已访问的链接


# 六、CSS的常见样式

## 1、字体样式

| font-family  |  font-size   | font--style  | font-weight  |             font             |
| :----------: | :----------: | :----------: | :----------: | :--------------------------: |
| 设置字体类型 | 设置字体大小 | 设置字体风格 | 设置字体粗细 | 在一个声明中设置所有字体属性 |

font简写，可以按顺序设置如下属性：

font--style

font--variant

font-weight

font-size/line-height

font-family

## 2、文本样式

|  color   |    text-align    |  text-indent   | text-height |               text-decoration                |
| :------: | :--------------: | :------------: | :---------: | :------------------------------------------: |
| 文本颜色 | 元素水平对齐方式 | 首行文本的缩进 | 文本的行高  | 文本的装饰（去除超链接默认下划线用其none值） |

## 3、div标签

- 网页布局
- 排版网页内容
- 属性：height、width
- 是块级元素，默认独占一行，两个div要想在一行显示就需要浮动

## 4、css设置鼠标形状

![1543375014732](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1543375014732.png)

## 5、背景属性

- 背景颜色：background-color:#B70447
- 背景图像(背景图会覆盖背景颜色)
  - 图像路径：background-image：url(图像路径)
  - 重复方式：background-repeat:no-reqeat
  - 背景定位：background-position:10px  15px

- 关键词：

  水平方向：left	center	right

  垂直方向：top	ccenter	bottom

- 背景属性简写（没有顺序要求）：

  background:url(背景图路径) no-repeat #f91f1 10px 15px

## 6、去除网页中所有的默认样式

 *{padding:0;margin:0;}

 a{text-decoration:none;color:#fff;}

# 七、网页中引用css样式

## 1、内联样式

就是在标签后直接写style属性如：

```html
<p style="CSS样式"></p>
```

## 2、内部样式表

指在head上加style标签，写css样式

```html
<style>
    css样式
</style>
```

## 3、外部样式表

css文件

在网页中导入或者引入外部样式文件即可

- 链接式 `<link/>`属于XHTML，使用其连接的css文件先加载到网页当中，再进行编译显示

  ```html
  <link rel="stylesheet" href="css/first.css"/>
  css文件样式
  h1{
      color: #0000FF;
  }
  不用写style
  ```

- 导入式式@import属于CSS2.1使用其导入的css文件，客户端显示HTML架构，再把css文件加载到网页众怒干，是属于CSS2.1特有的，对于不兼容CSS2.1的浏览器来说是无效的

# 八、

