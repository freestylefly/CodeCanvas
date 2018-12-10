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

- 行内元素除了img无法设置宽高：span、a、img、strong
- 款即元素前后有空行独占一行：h、p、div、列表

## 9、去除网页中所有的默认样式

  *{padding:0;margin:0;}

 a{text-decoration:none;color:#fff;}

## 10、HTML5的结构元素

|     header     |     footer     |      section      | aside  |      nav       |    article     |
| :------------: | :------------: | :---------------: | :----: | :------------: | :------------: |
| 标题头部的内容 | 脚部区域的内容 | web页面中间大区域 | 侧边栏 | 导航类辅助内容 | 独立的文章内容 |

## 11、内部框架标签iframe

src属性，指定容器默认显示内容

name指定框架的名称

hight：高 

在a标签中的target可以选择iframe的name，这样会将内容放入iframe容器中显示，不再跳转到其他地方

## 12、框架标签:frameset：

注意: 使用了frameset必须将body删掉,否则页面会有问题

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

- 按钮（有提交功能）：button（普通按钮）

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

- ## 定义：

  浮动的元素会脱离正常的文档流,在正常的文档流中不占空间

- ## float属性:

  ​				left
  ​				right

- ## style的clear属性: 清除浮动

  ​			both : 两边都不允许浮动
  ​			left: 左边不允许浮动
  ​			right : 右边不允许浮动

  ​			当下面div受到上面浮动影响加一个空的div清除浮动

## 设置元素的高和行高一样的就可以让文字居中

## 清除浮动，防止父级边框塌陷的四种方法

​	1、浮动元素后面加空div

​	需要将空div清除浮动both

​	简单，空div会造成HTML代码冗余

​	2、设置父元素的高度

​	简单，元素固定高会降低扩展性

​	3、父级添加overflow属性（hidden）

​	简单，下拉列表框的场景不能用

​	4、父级添加伪类after

```
#father：after{
    content：“”；
    display：block；
    clear：both
}
```

​	写法比上面稍微复杂一点，但是没有副作用，推荐使用

设置浮动一定记得扩展盒子高度

# 五、CSS选择器

## 1、css选择器

- 元素（标签）选择器: 标签的名称{}——n标签选择器直接应用于HTML标签，不遵循就近原则

- 类选择器:   以. 开头  .类的名称——n类选择器可在页面中多次使用

- ID选择器:  以#开头 ,   #ID的名称  (ID必须是页面上面唯一) ——nID选择器在同一个页面中只能使用一次

  ​    �{��

## 2、选择器优先级

- 按照选择器搜索精确度来编写:
- 就近原则: 哪个离得近,就选用哪个的样式
- 行内样式 > ID选择器 > 类选择器  > 元素选择器

## 3、css高级选择器

- 并集选择器（选择器分组）

  - : 选择器1,选择器2{ 属性的名称:属性的值}
  - 多个选择器通过逗号连接而成

- 属性选择器:

  - 

  ```html
  a[title]     ——title为属性名
  a[titile='aaa']   ——aaa属性值
  a[href][title]	——两个属性名
  a[href][title='aaa']	——两个属性名，一个属性值
  a[title^=“val”] ——属性值是以val开头的
  a[title$=“val”] ———属性值是以val结尾的
  a[title`=“val”]  _属性值中包含以val字段的
  ```

  层次选择器包括：后代选择器、子元素选择器、相邻兄弟选择器、通用兄弟选择器

- 后代选择器: E F

  爷爷选择器  孙子选择器   找出所有的后代，中间以空格隔开

- 子元素选择器:  E>F

  父选择器  > 儿子选择器 ：只能找到父元素的直接后代

- 相邻兄弟选择器：E+F

  选择匹配的F元素，且匹配的F元素紧位于匹配的E元素后面

  如：

  ```html
  .active+p {  background: green;  }
  会找出在类名为active的类下的第一个p标签的元素
  ```

- 通用兄弟选择器:：E`F

  选择匹配的F元素，且位于匹配的E元素后的所有匹配的F元素，如：

  ```html
  .active~p{  background: yellow;  }
  会找出active类名下的所有含有p标签的元素
  ```

- 结构伪类选择器

  - E F:nth-child(n) 

    代表查找父元素E下面的弟n个叫做F的孩子，会按照顺序进行排序（不管亲兄弟还是堂兄弟，都是兄弟）

  - E F:nth-of-type(n)

    代表去除了类型之后的孩子，亲兄弟，在父元素E下面的所有亲的弟n个F（去除类型后再排序）

    ```html
    <head lang="en">
    	<meta charset="UTF-8">
    	<title>使用CSS3结构伪类选择器</title>
    	<style>
    		/*p:first-child{*/
    			/*background-color: #0000A8;*/
    		/*}*/
    		/*body>p:first-child{*/
    			/*background-color: #0000A8;*/
    		/*}*/
    		body p:nth-of-type(odd){
    			background-color: #0000A8;
    		} 
    		
    		
    		在body下的所有p，并且都是奇数，注意li里面的p中的p计数是以li里面各自计数，odd奇数，even代表偶数*/
    		
    	</style>
    </head>
    <body>
    	<p>p1</p>
    	<p>p2</p>
    	<p>p3</p>
    	<ul>
    		<li>
    			<p>li1</p>
    		</li>
    		<li>
    			<p>li2</p>
    		</li>
    		<li>
    			<p>li3</p>
    		</li>
    	</ul>
    </body>
    ```

- 伪类选择器: 通常都是用在a标签上

  a:link {color:black}	未单击访问的链接

  a:hover{color:black}		鼠标悬浮其上的超链接样式

  a:active {color:black}	鼠标单击未释放的超链接样式

  a:visited {color:black}		已访问的链接

- 交集选择器

  由两个选择器连接构成，，选中两者的交集，两个选择器之间不能有交集，第一个必须是标签选择器，第二个必须是类选择器或者id选择器

# 六、CSS的常见样式

## 1、字体样式

| font-family  |  font-size   | font--style  | font-weight  |             font             |
| :----------: | :----------: | :----------: | :----------: | :--------------------------: |
| 设置字体类型 | 设置字体大小 | 设置字体风格 | 设置字体粗细 | 在一个声明中设置所有字体属性 |

font简写，可以按顺序设置如下属性：

font--style：字体风格，italic表示斜体

font--variant

font-weight：粗细

font-size/：字体大小

ine-height：行高

font-family：字体类型，多种字体用逗号隔开，中文字体放在后面，字体名称为多个字符的时候用引号引起来 

一起写font：分（风格）出（粗细）大（大小）类（类型）

## 2、文本样式

|  color   |    text-align    |             text-indent              | text-height |                       text-decoration                        |                     vertical-align                     |               text-shadow                |
| :------: | :--------------: | :----------------------------------: | :---------: | :----------------------------------------------------------: | :----------------------------------------------------: | :--------------------------------------: |
| 文本颜色 | 元素水平对齐方式 | 首行文本的缩进1em代表向右缩进1个字符 | 文本的行高  | 文本的装饰（去除超链接默认下划线用其none值）underline、line- | 垂直对齐方式，设置文本和图片的居中对齐，在使得他的值为 | 文本阴影，三个值，阴影颜色、X位移、Y位移 |

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

- css3渐变

  linear-gradinent（tobottom，颜色1，颜色2）

- 背景属性简写（没有顺序要求）：

  background:url(背景图路径) no-repeat #f91f1 10px 15px

## 6、去除网页中所有的默认样式

 *{padding:0;margin:0;}

 a{text-decoration:none;color:#fff;}

## 7、display属性

- 控制元素的显示和隐藏

- 块级元素与行内元素的转变

- |        none        |         inline         |        block         | inline-block |
  | :----------------: | :--------------------: | :------------------: | ------------ |
  | 设置元素不会被显示 | 元素会被显示为内联元素 | 元素被显示为块级元素 | 行内块元素   |

注意：

1. block和none结合起来用，可以达到开始隐藏，当鼠标移上去的时候会显示图片或者相关的信息，如：

   ul li:hover div{

   ​	display:block;

   }

2. inline-block常用于将元素排列一排

# 七、网页中引用css样式

## 1、行内样式

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

  ```html
  <!--
  @import url("style.css");
  -->
  
  ```


# 八、盒子模型

![1543403891531](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1543403891531.png)



## 1、边框border

- 边框样式：border-style

  - border-top-style：上边框样式 none无边框
  - border-right-style：右边框样式 solid实线边框
  - border-bottom-style：下边框样式 dashed虚线边框
  - border-left-style：左边框样式 dolted点边框
  - border-style：设置四个边框样式  double双线边框

- 边框颜色：border-color

- 边框粗细：border-width

  - border-top-width（bottom、right、left）

  - border-width

    关键字：thin、medium、thick

    像素值：px

- 边框简写

  同时设置边框的颜色、粗细和样式

  border-bottom：9px #F00 dashed；

  border：8px #F00  solid（常用）

## 2、外边框margin

两个盒子之间的距离（都是内盒子）

margin-top（right、left、top）

margin：3px  3px  3px  3px（上、右、下、左）

大元素整体水平居中用margin：0px auto

## 3、内边距padding

子盒子和父盒子之间的边距（比如手机的内部填充物

padding：10px——四个方向都是10px

padding：10px 20px——上下10px，左右20px

padding：10px 20px 30px——上10，右20、下30，左20

padding：10px 20px 30px 40px——上10，右20、下30，左40（按照左右上下）

## 4、计算盒子模型的尺寸

盒子实际高度=上下外边距+上下边框+上下内边距+内容高度

盒子实际宽度=上下外边距+上下边框+上下内边距+内容宽度

5、box-sizing属性

content-box：盒子的实际宽度和高度仅适用于元素内容	，不包括内边距和边框

border-box盒子的实际宽度和高度包括元素内容、边框和内边距

## 5、使用overflow属性扩展盒子高度

|                 visible                  |                hidden                |                       scroll                       |                             auto                             |
| :--------------------------------------: | :----------------------------------: | :------------------------------------------------: | :----------------------------------------------------------: |
| 默认值，内容不会被修建，会呈现在盒子之外 | 内容会被修建，并且其余内容是不可见的 | 内容会被修建，但是浏览器会显示滚动条以查看其余内容 | 如果内容被修建，则浏览器会显示滚动条以查看其余内容，自动加滚动条 |

两种扩展盒子高度的区别

- 使用overflow 属性扩展盒子高度减少代码量，也减少了空的HTML标签，使代码更加简洁、清晰，从而提高了代码的可读性和网页性能
- 如果页面中有定位元素，并且元素超出了父级的范围，就必须clear属性来清楚浮动来扩展盒子高度

## 6、box-sizing

```
box-sizing：content-box  |  border-box  |  inherit
三个值分别为：默认值，盒子的总尺度
盒子的宽度或高度等于元素内容的宽度或高度
元素继承父元素的盒子模型模式	
```

## 7、圆角边框

```
border-radius: 20px  10px  50px  30px;

```

利用border-radius属性制作圆形的两个要点

- Ø元素的宽度和高度必须相同

- Ø圆角的半径为元素宽度的一半，或者直接设置圆角半径值为50%

  ```
   div{
              width: 100px;
              height: 100px;
              border: 4px solid red;
              border-radius: 50%;
          }
  
  ```

  u利用border-radius属性制作半圆形的两个要点

  - Ø制作上半圆或下半圆时，元素的宽度是高度的2倍，而且圆角半径为元素的高度值

  - ​    Ø右半圆时，元素的高度是宽度的2倍，而且圆角半径为元素的宽度值

u利用border-radius属性制作扇形遵循“三同，一不同”原则

Ø“三同”是元素宽度、高度、圆角半径相同

Ø“一不同”是圆角取值位置不同



鼠标悬浮其上，让其他变色：

```
a：hover span{}
li：hover a{}
```



对齐方式：

水平对齐：text-align或者设置外边距上下为0，左右为auto

垂直对齐：设置行高和高度相等即可

## 8、盒子阴影

```css
box-shadow:inset  x-offset  y-offset  blur-radius  color
各个参数意义：
阴影类型内阴影
X轴位移，指定阴影水平位移量
Y轴位移，用来指定阴影垂直位移量
阴影模糊半径阴影向外模糊的模糊范围
阴影颜色，定义绘制阴影时所使用的颜色
例子：
ul li:hover{box-shadow: 0 5px 5px rgba(0, 0, 0, 0.1), 0 0 10px 0 rgba(0,0,0,0.2);
```

# 九、定位position

定位常用用法：

- 在需要定位元素加position：absolute

  ​				top：0px。。。

- 在直接父级加一个无改变位置的position：relative

## 1、position属性

|      static      | relative | absolute |  fixed   |
| :--------------: | :------: | :------: | :------: |
| 默认值，没有定位 | 相对定位 | 绝对定位 | 固定定位 |

## 2、relative属性

- 相对自身原来位置进行偏移
- 偏移设置：top、left、right、bottom，单位px
- 设置相对定位的盒子会相对于它原来的位置，通过指定偏移，到达新的位置
- 设置了相对定位的网页元素，无论是在标准流中还是在浮动流中，都不会对他的父级元素和相邻元素有任何影响，他只是针对自身原来的位置进行偏移
- 设置相对定位的盒子仍在标准文档流中，它对父级盒子和相邻的盒子都没有任何影响
- n设置相对定位的盒子原来的位置会被保留下来
- 相对定位一般情况下很少自己单独使用，都是配合绝对定位使用，为绝对定位创造定位父级而又不设置偏移量

## 3、absolute属性

- 绝对定位
- 决对定位是针对浏览器的，如果想要针对父容器定位则要将父容器设置为非static
- n使用了绝对定位的元素以它最近的一个“已经定位”的“祖先元素为基准进行偏移
- 如果没有已经定位的祖先元素，会以浏览器窗口为基准进行定位
- 绝对定位的元素从标准文档流中脱离，这意味着它们对其他元素的定位不会造成影响
- 元素位置发生偏移后，它原来的位置不会被保留下来
- 一般情况下，绝对定位用在下拉菜单、焦点图轮播、弹出数字气泡、特别花边等场景

## 4、fixed

- 固定定位
- 会像狗皮膏药一样，尽管网页上下左右滑动，但是元素在网页中位置不变
- 类似绝对定位，不过区别在于定位的基准不是祖先元素，而是浏览器窗口
- 一般在网页中被用在窗口左右两边的固定广告、返回顶部图标、吸顶导航栏等

## 5、z-index属性

- 用来调整元素定位时重叠层的上下位置
- z-index属性值：整数，默认值是0
- 设置了position属性时，z-index属性可以设置各个元素之间的重叠高低关系
- zi-index值大的层位于值小的层的上方

## 6、网页元素透明度

|       opacity:x        |    filter:alpha(opacity=x)    |
| :--------------------: | :---------------------------: |
| x值为0~1，值越小越透明 |   x值为0~100，值越小越透明    |
|      opacity:0.4;      | filter:alpha(opacity=40);     |

# 十、css3动画

## 1、transform变形

CSS3变形是一些效果的集合

如平移、旋转、缩放、倾斜效果

transform:[transform-function] *;

设置变形函数，可以是一个，也可以是多个，中间以空格分开

变形函数

translate()：平移函数，基于X、Y坐标重新定位元素的位置

scale()：缩放函数，可以使任意元素对象尺寸发生变化

rotate()：旋转函数，取值是一个度数值

skew()：倾斜函数，取值是一个度数值

案例：制作多彩照片墙：

```html
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <style>
        div{
            width: 800px;
            margin: 0 auto;
            position: relative;
        }
        img{
            padding: 10px;
            border: 1px solid lightgray;
            background-color: white;
            position: absolute;
            width: 45%;
        }
        img:nth-child(1){
            top:150px;
            left: 50px;
            transform: rotate(-15deg);
        }
        img:nth-child(2){
            top:130px;
            left: 200px;
            transform: rotate(30deg);
        }
        img:nth-child(3){
            top:200px;
            left: 500px;
            transform: rotate(-20deg);
        }
        img:hover{
            transform: rotate(0deg) scale(1.3);
            z-index: 1;
            box-shadow: 0 0 5px rgba(0,0,0,0.4);
        }
    </style>
</head>
<body>
<div>
    <img src="image/1.jpg" title="1"/>
    <img src="image/2.jpg" title="2"/>
    <img src="image/3.jpg" title="3"/>
</div>
</body>
</html>
```



## 2、transition

- 实现步骤：
  - 设置开始状态，可不写
  - 设置结束状态
  - 添加transition属性

- transition呈现的是一种过渡，是一种动画转换的过程，如渐现、渐弱、动画快慢等

- CSS3 transition的过渡功能更像是一种“黄油”，通过一些CSS的简单动作触发样式平滑过渡

- 语法：

  transition:[transition-property  transition-duration  transition-timing-function   transition-delay ]

  分别代表含义：过渡或动态模拟的CSS属性、完成过渡所需要的时间、指定过渡函数、过渡开始出现的延迟时间

- 过渡属性（ transition-property ）

  定义转换动画的CSS属性名称

  IDENT：指定的CSS属性（width、height、background-color属性等）

  all：指定所有元素支持transition-property属性的样式，一般为了方便都会使用all

- n过渡所需的时间（ transition-duration ）

  u定义转换动画的时间长度，即从设置旧属性到换新属性所花费的时间，单位为秒（s）

- n过渡动画函数（ transition-timing-function ）

  u指定浏览器的过渡速度，以及过渡期间的操作进展情况，通过给过渡添加一个函数来指定动画的快慢方式

  Øease：速度由快到慢（默认值）

  Ølinear：速度恒速（匀速运动）

  Øease-in：速度越来越快（渐显效果）

  Øease-out：速度越来越慢（渐隐效果）

  Øease-in-out：速度先加速再减速（渐显渐隐效果）

- 过渡延迟时间（ transition-delay ）

  指定一个动画开始执行的时间，当改变元素属性值后多长时间去执行过渡效果

  Ø正值：元素过渡效果不会立即触发，当过了设置的时间值后才会被触发

  Ø负值：元素过渡效果会从该时间点开始显示，之前的动作被截断

  Ø0：默认值，元素过渡效果立即执行

- 过渡的触发机制

  n伪类触发

  u：hover

  u：active

  u：focus

  u：checked

  u

  n媒体查询：通过@media属性判断设备的尺寸，方向等

  nJavaScript触发：用JavaScript脚本触发

演示案例：旋转按钮：

```HTML
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <style>
        ul{
            overflow: hidden;
            border: 1px solid red;
        }
        li{
            list-style: none;
            float: left;
            margin-left: 10px;
            height: 100px;
            line-height: 100px;
            /*1.设置开始的状态*/
            /*3.添加transition*/
            transition: all 3s ease-in-out -1s ;
        }

        li:hover{
            /*2.设置结束的状态*/
            transform: rotate(1080deg) scale(1.3);
        }
        li img{
            vertical-align: middle;
        }
    </style>
</head>
<body>
<ul>
    <li><img src="images/delicious.png"/></li>
    <li><img src="images/facebook.png"/></li>
    <li><img src="images/rss.png"/></li>
    <li><img src="images/twitter.png"/></li>
    <li><img src="images/yahoo.png"/></li>
</ul>
</body>
</html>
```

## 3、animation动画

animation实现动画主要由两个部分组成

Ø通过类似Flash动画的关键帧来声明一个动画

Ø在animation属性中调用关键帧声明的动画实现一个更为复杂的动画效果

- 语法：

  animation:animation-name  animation–duration  animation-timing-function

     animation-delay  animation-iteration-count  animation-direction  

  animation-play-state  animation-fill-mode;

  ​    ;mso-ascL

![1544062206386](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1544062206386.png)

- n动画的播放次数（animation-iteration-count）

  u值通常为整数，默认值为1

  u特殊值infinite，表示动画无限次播放

  n动画的播放方向（animation-direction）

  unormal，动画每次都是循环向前播放

  ualternate，动画播放为偶数次则向前播放

  n动画的播放状态（animation-play-state）

  urunning将暂停的动画重新播放

  upaused将正在播放的元素动画停下来

- n动画发生的操作（animation-fill-mode）

  uforwards表示动画在结束后继续应用最后关键帧的位置

  ubackwards表示会在向元素应用动画样式时迅速应用动画的初始帧

  uboth表示元素动画同时具有forwards和backwards的效果

