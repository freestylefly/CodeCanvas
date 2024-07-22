# 一、概述

## 1、 JavaScript概述和特点

概述：是一种基于对象和事件驱动的脚本语言

特点：交互、脚本语言，解释性语言，边执行边解释

## 2、什么是脚本语言?

- java源代码 ----> 编译成.class文件 -----> java虚拟机中才能执行

- 脚本语言:   源码  -------- > 解释执行，js由我们的浏览器来解释执行

- HTML: 决定了页面的框架  

  CSS: 用来美化我们的页面

  JS:	提供用户的交互的

## 3、JS的组成:

- ECMAScript : 核心部分 ,定义js的语法规范，是一种语法标准
- DOM： document Object Model 文档对象模型 , 主要是用来管理页面的
- BOM：Browser Object Model  浏览器对象模型, 前进,后退,页面刷新, 地址栏, 历史记录, 屏幕宽高

## 4、JavaScript基本结构

```html
 <script type="text/javascript">
        javascript语句
    </script>
如果要引入外部js脚本，直接在script右面添加一个src属性即可
```



# 二、JS语法

## 1、语法

变量弱类型: var i = true

区分大小写

语句结束之后的分号 ,可以有,也可以没有，最好写

写在script标签

## 2、JS的数据类型:

- 基本类型
  - string

    split:：分割

    join：拼接字符串

  - number

  - boolean 

  - undefine：未定义

  - null

    注意：undefine==null定义为是相等的

- 引用类型

  - 对象, 内置对象

    常用内置对象有：

    Array、String、Math、Date

    Date内置对象：

    按照：2018年11月12日22：3：59：格式显示，注意获得年使用getFullYear（）方法 

    ```javascript
     var date=new Date();
            var year=date.getFullYear();
            var month=date.getMonth();
            var day = date.getDate();
            var hour=date.getHours();
            var minute=date.getMinutes();
            var second=date.getSeconds();
            var ele=document.getElementById("datetime");
            ele.innerHTML=year+"年"+month+"月"+day+"日"+hour+"："+minute+"："+second+"：";
    ```

- typeof操作符来检测变量的数据类型

- 创建数组

  var arr=["a","b","c"]

  var arr = new Array("a","b","c")

  数组sort方法：是排序

  push方法是向后添加元素，返回新数组的长度，直接将原数组打印即可

- 类型转换

  - js内部自动转换 

  - 通过函数转换：parseInt（）转换为整数

    parseInt("aaa123")=NAN

    parseInt("123aaa")=123

  - parseFloat（）转换为浮点数

## 3、JS的运算符和语句

- 运算符和java 一样
  - "===" 全等号: 值和类型都必须相等
  - == 值相等就可以了

- 语句和java 一样

  ```
  ==和===的区别
  ==不会严格区分数据类型
  ===会严格区分数据类型
  ```

  ```
  “1”==true  正确
  "0"==false  正确
  “true”=true	错误
  
  ```


## 4、JS的输出

- alert()  直接弹框
- document.write()  向页面输出
- console.log() 向控制台输出
- innerHTML:  向页面输出
- 获取页面元素: document.getElementById("id的名称");
- window.location="页面地址"，让窗口的地址跳到指定页面去
- prompt（）可以是一个参数或者两个参数，弹出窗口，让用户输入值，有返回值，需要对返回值进行强制类型转换的时候需要用到部分常用的系统函数

## 5、JS声明变量:

var 变量的名称 = 变量的值

## 6、JS声明函数

var 函数的名称 = function(){	

​	}

function 函数的名称(){

​	}

js常用的系统函数

- parseInt（）转换为整数
- parseFloat（）转换为浮点数
- isNaN（）：贩毒案非数字
- eval（），计算表达式的值

## 7、创建对象

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181218095031912.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

- Object
  ```javascript
  var 对象名 = new Object（）
  属性：对象名.属性名=“”；
  方法：对象名.showName=function(){}
  调用方法：对象名.showName();
  ```

  - ECMAScript提供的一种原生引用类型
  - 可以通过Object引用类型的实例创建一个对象
  - 可以为对象定义属性和方法
  - Object实例本身不具备多少功能，一般在应用程序中存储和传递数据

- 使用Object创建对象

  ```html
  <html>
  <head lang="en">
      <meta charset="UTF-8">
      <title></title>
      <script type="text/javascript">
          //使用object创建对象
         var user = new Object();
          //对象的属性
          user.name="张三";
          user.psd="12345566";
          //对象的方法（函数）
          user.showInfo=function(){
              document.write(this.name+"-"+this.psd)
          }
  
      </script>
  </head>
  <body>
  <input type="button" value="点我啊" onclick="user.showInfo()"/>
  </body>
  </html>
  ```

- 对象字面量方式创建对象

  - 对象字面量是对象定义的一种简写方式

  - 会简化创建包含大量属性的对象的过程

  - 在为函数传递大量可选参数时，可考虑使用对象字面量

  - 创建代码实现

    ```html
    <script type="text/javascript">
            //使用对象字面量创建对象
            var user={
                name="张三";
                psd="12334";
                showInfo:function(){
                    document.write(this.name+"-"+this.psd)
                }
            }
            //使用对象字面量创建对象的第二种方式
            var user2={};
            user2.name="李四";
            user2.psd="123";
            user2.showInfo= function () {
                document.write(this.name+"-"+this.psd)
            }
        </script>
    ```


- 工厂模式创建对象

  - 工厂模式是软件工程领域的一种设计模式

  - 抽象了创建对象的过程

  - 通过函数封装创建对象的细节

  - 代码实现

    ```html
     //使用object创建对象
            var user = new Object();
            //对象的属性
            user.name="张三";
            user.psd="12345566";
            //对象的方法（函数）
            user.showInfo=function(){
                document.write(this.name+"-"+this.psd)
            }
            var user1=createUser("hhh","12312");
    
    ```

    - 弊端：看不出类型——解决构造函数

      ​		函数重复，浪费资源——解决：原型

- 构造函数

  构造函数一般以大写字符开头

  构造函数也是函数，只不过可以用来创建对象

  与工程模式对比

  - 没有显式创建对象
  - 直接将属性和方法赋给了this对象
  - 没有return

```html
<script type="text/javascript">
    //使用构造函数t创建对象
    function User(name,psd){
        //定义对象属性
        this.name="沾伞";
        this.psd="12312";
        //定义对象方法
        this.showInfo=function(){
            document.write(this.name+"-"+this.psd)
        }
    }
</script>
```

- 原型prototype

  - 每个函数都有一个prototype（原型）属性

  - 是一个指针，指向一个对象

  - 这个对象的用途是包含可以由特定类型的所有实例共享的属性和方法

  - instanceof判断对象的原类型

  - 代码实现

    ```javascript
       //定义无参构造函数
        function Flower(){
    
        }
        //原型属性和方法
        Flower.prototype.name="长春花";
        Flower.prototype.genera="夹竹桃科 长春花属";
        Flower.prototype.showName=function(){
            alert(this.name);
        }
        //构建实例对象
        var f1 = new Flower();
        var f2 = new Flower();
        //实例对象修改属性值
        f2.name="哈哈哈";
        //实例对象调用原型方法
        f1.showName();
        f2.showName();
    
    ```

- 用混合方式构造对象

  构造函数+prototype
  构造函数：属性

  原型prototype：方法

  ```html
  //使用构造函数t创建对象
      function User(name,psd){
          //定义对象属性
          this.name="沾伞";
          this.psd="12312";
          }
         //原型prototype：方法
       User.prototype.showInfo=function(){
              document.write(this.name+"-"+this.psd)
          }
  ```

## 8、继承

1、	原型链

一个原型对象是另一个原型对象的实例（dog.protptype=new Animal();

相关的原型对象层层递进，就构成了实例与原型的链条，就是原型链

2、对象继承

借用构造函数

- apply([thisOjb[,argArray]])

  应用某一对象的一个方法，用另一个对象替换当前对象

- call([thisObj[,arg1[,arg2[,  [,argN]]]]])

  n调用一个对象的一个方法，以另一个对象替换当前对象

  ​    Animal.call(this,cloth)

组合继承（做伪经典继承）

```javascript
<script>
    //构造函数Person
    function Person(name,chinese,math){
        this.name=name;
        this.chinese=chinese;
        this.math=math;
    }
    //构造函数Person方法
    Person.prototype.showName=function(){
        return this.name;
    }
    Person.prototype.showChinese=function(){
        return this.chinese;
    }
    Person.prototype.showMath=function(){
        return this.math;
    }
    //构造函数Student
    function Student(name,chinese,math,age){
        Person.call(this,name,chinese,math);
        this.age=age;
    }
    //实现继承
    Student.prototype=new Person();
    //构造函数Student方法
    Student.prototype.showAge=function(){
        return this.age;
    }

    //创建Student实例

    var student=new Student("张三",90,80,16);
    document.write("姓名："+student.showName()+"<br/>")
    document.write("语文："+student.showChinese()+"<br/>")
    document.write("数学："+student.showMath()+"<br/>")
    document.write("年龄："+student.showAge()+"<br/>")
</script>
```



## 9、在网页中引入JavaScript的方式

1、内部：用script标签，可以放在任意位置，习惯可放置在html的最后

2、行内：直接放在HTML标签中

3、外部：调用外部用script标签，属性src=“”，type=text/JavaScript

## 10、JS程序调试

1、用浏览器F12调试，F10跳过函数,F11进去方法里，watch可以监控变量

2、alert进行标记是比较实用的调试方式，在需要标记的地方做标记，如果能执行到标记的位置，那么就会弹出窗口

## 11、事件

onload：页面加载事件

onclick：点击事件

onkeydown：键盘按下事件

## 12、BOM——浏览器对象

BOM是浏览器对象模型，可以移动窗口，改变状态栏中的文本，执行其他与页面内容不直接相关的操作。

![1544623656486](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1544623656486.png)

BOM可实现功能：

u弹出新的浏览器窗口

u移动、关闭浏览器窗口以及调整窗口的大小

u页面的前进、后退

#### A、Window对象

- 属性

  history：有关客户访问过的URL的信息

  location：有关当前URL的信息，

  ```javascript
  window.location="http://www.baidu.com";
  ```

- 方法

  1. prompt()

     显示可提示用户输入的对话框，可有一个参数或者两个参数，两个参数时，第二个参数代表的是默认输入信息，有返回值，点击确定返回用户输入的值，点击取消返回null

  2. alert()

     为只含有一个确定按钮的警告框仅有一个参数，无返回值

  3. confirm()

     显示一段消息以及含有确定和取消按钮的对话框，返回值为布尔类型，常用于if -else语句

  4. close()

     关闭浏览器窗口

  5. open()

     在页面弹出一个新的浏览器敞口

     ```javascript
     window.open("http://www.baidu.com","_blank","width=100px,height=100px")
     ```

  6. setTimout()

     定时函数：仅会计时一次

  7. setInterval()

     定时函数：多次计时

     ```javascript
     setInterval(“adadas()”，1000)
     ```

#### B、History对象

- 方法

  back()：后退

  forward()：前进

  go(1)：同forward，负数代表后退

#### C、Location对象

- 属性：href：设置或者返回完整的URL

- 方法

  reload：重新加载

  replace：用新的文档替换当前文档，不能振兴后退操作

  align：用新的文档替换当前文档，能振兴后退操作

#### D、Document对象

- 属性

  referrer：返回载入当前文档的URL（谁把我加载进来的）

  URL：返回当前文档的URL

- 方法

  getElementById：通过id获取某一对象

  getElementsByName：通过name获取某一对象

  getElementsByTagName：通过标签名获取某一对象

  write：向文档写文本

  ```
  获得对象后需要对属性进行一系列操作，如可setAtrrbute等设置属性值，扩展：tofixed（2）代表保留两位小数，常用的对象属性有：
  1、value：值
  2、innerHTML：改变对象的所有显示属性，会解析HTML标签
  3、innerTEXT：改变对象的所有显示属性，不会解析HTML标签
  4、chected：复选框的属性值，让其为true，代表已选
  ```

## 13、DOM—文档对象模型

![JavaScript操作DOM对象](E:\Java\GitHub\javaStudy\JavaScript\JavaScript操作DOM对象.jpg)



DOM分类：

1、DOM core：DOM核心，包含getElement方法等

2、HTML DOM：用来操作节点

3、CSS DOM：用来操作样式

节点信息：

nodeName：节点名字

nodeValue：节点值

nodeType：节点类型

节点和节点的关系：

1. 父节点：parentNode（parentElementNode父元素节点）
2. 首个节点：firstChild
3. 最后一个节点：lastChild
4. 下一个节点：nextsibling
5. 上一个节点：previousSibling
6. 子节点集合childNode

操作节点：

操作节点属性：getAttribute("属性名")           setAttribute("属性名","属性值")

创建和插入节点节点：

```
createElement( tagName)
A.appendChild( B)、insertBefore( A,B )
cloneNode(deep)
```

清楚和替换节点：

```
removeChild(N)、replaceChild(newN,oldN)
```

操作节点样式：style属性（样式少的时候用，可读写   className属性（在css样式中已经写好，通过className操作）

------

页面事件：

1、onload页面加载事件

2、onscroll用于博做页面垂直和水平的滚动

制作带关闭按钮的广告

```javascript
//关闭按钮关闭广告
function adv_close(){
    var closeEle=document.getElementById("close").firstElementChild;
    var floatEle=document.getElementById("float").firstElementChild;
    closeEle.style.display="none";
    floatEle.style.display="none";
}
//当滚动条向下或向右移动时，图片和关闭按钮随滚动条移动，相对于浏览器的位置固定
//获取原始位置：top left
var adver=document.getElementById("float");
var initLeft=0;
var initTop=0;
/**
 * 1.获取小广告初始位置的top和left
 */
function initLocation(){
    if(adver.currentStyle){
        initLeft=parseInt(adver.style.left);
        initTop=parseInt(adver.style.top);
    }else{
        initLeft=parseInt(document.defaultView.getComputedStyle(adver,null).left);
        initTop=parseInt(document.defaultView.getComputedStyle(adver,null).top);
    }
}
function scrollCount(){
    //2.获取鼠标滚动的距离
    var leftChange= document.documentElement.scrollLeft||document.body.scrollLeft;
    var topChange= document.documentElement.scrollTop||document.body.scrollTop;
    //3.重新为属性赋值
    adver.style.top=topChange+initTop+"px";
    adver.style.left=leftChange+initLeft+"px";
    //console.log(topChange+initTop+"px");
}
window.onload=initLocation;//onload加载事件，调用方法
window.onscroll=scrollCount;//鼠标滚动事件，调用方法
```

制作论坛发帖：

```JavaScript

//获得发帖的div对象
var postEle=document.getElementsByClassName("post")[0];
//点击发帖
function pushsth(){
    //修改CSS属性，使其显示出来
    postEle.style.display="block";
}
//发布
function publish(){
    //获取标题
    var title=document.getElementsByClassName("title")[0].value;
    //获取板块
    var section=document.getElementsByTagName("select")[0].value;
    //获取时间
    var date = new Date();
    var year=date.getFullYear();
    var month=date.getMonth();
    var day=date.getDate();
    var dateTime=year+"年"+month+"月"+day+"日";
    //将li中内容添加进入ul上
    var ulEle=document.getElementsByTagName("ul")[0];
    ulEle.innerHTML=" <li>"+
        "<div><img src='images/tou01.jpg' /></div>"+
        "<h1>"+title+"</h1>"+
       " <p>"+
       " <span>板块："+section+"</span> <span>发布时间："+dateTime+"</span>"+
   " </p>"
   " </li>"
    //隐藏发帖板块
    postEle.style.display="none";
}
```

注意：要在成对的双引号之间加一个参数，可以用“++“，只需要把参数放在++之间即可！

## 14、内置对象

String（字符串）对象

Date（日期）对象

Array（数组）对象

Boolean（逻辑）对象

Math（算数）对象

RegExp对象

# 三、JS的开发步骤

1. 确定事件
2. 通常事件都会出发一个函数
3. 函数里面通常都会去操作页面元素,做一些交互动作

# 四、用js完成表单验证

## 1、代码实现

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script>
			/*
				1. 确认事件: 表单提交事件 onsubmit事件 
				2. 事件所要触发的函数: checkForm
				3. 函数中要干点事情
					1. 校验用户名, 用户不能为空, 长度不能小于6位
						1.获取到用户输入的值
			*/
			function checkForm(){
				//获取用户名输入项
				var inputObj = document.getElementById("username");
				//获取输入项的值
				var uValue = inputObj.value;
//				alert(uValue);
				//用户名长度不能6位 ""
				if(uValue.length < 6 ){
					alert("对不起,您的长度太短!");
					return false;	
				}
				//密码长度大于6 和确认必须一致
				
				//获取密码框输入的值
				var input_password = document.getElementById("password");
				var uPass = input_password.value;
				
				if(uPass.length < 6){
					alert("对不起,您还是太短啦!");
					return false;
				}
				
				//获取确认密码框的值
				var input_repassword = document.getElementById("repassword");
				var uRePass = input_repassword.value;
				if(uPass != uRePass){
					alert("对不起,两次密码不一致!");
					return false;
				}
				
				//校验手机号
				var input_mobile = document.getElementById("mobile");
				var uMobile = input_mobile.value;
				//
				if(!/^[1][3578][0-9]{9}$/.test(uMobile)){
					
					alert("对不起,您的手机号无法识别!");
					
					return false;
				}
				
				//校验邮箱: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/
				var inputEmail = document.getElementById("email");
				var uEmail = inputEmail.value;
				
				if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/.test(uEmail)){
					alert("对不起,邮箱不合法");
					return false;
				}			
				return true;
			}	
		</script>
	</head>
	<body>
		<form action="JS开发步骤.html" onsubmit="return checkForm()">
			<div>用户名:<input id="username" type="text"  /></div>
			<div>密码:<input id="password" type="password"  /></div>
			<div>确认密码:<input id="repassword" type="password"  /></div>
			<div>手机号码:<input id="mobile"  type="number"  /></div>
			<div>邮箱:<input id="email" type="text"  /></div>
			<div><input type="submit" value="注册"  /></div>
		</form>
	</body>
</html>
```

# 五、JS完成自动播放轮播图

## 1、需求

有一组图片, 每隔3秒钟,就去切换一张,最终是一直在不停切换

切换图片:

每个三秒钟做一件事:

- setInterval : 每隔多少毫秒执行一次函数
- setTimeout: 多少毫秒之后执行一次函数
- clearInterval取消定时
- clearTimeout取消定时

## 2、步骤分析:

1. 确定事件: 文档加载完成的事件 onload
2. 事件要触发 : init()
3. 函数里面要做一些事情:(通常会去操作元素,提供交互)
  4. 开启定时器: 执行切换图片的函数 changeImg()
5. changeImg()
  6. 获得要切换图片的那个元素

## 3、代码实现

```html
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script>
        var index=0
        function changeImage(){
           var img= document.getElementById("first");
            var curindex=index%3+1;
            img.src="images/"+curindex+".jpg";
            index=index+1;
        }
        function init(){
            setInterval("changeImage()",1000);
        }
    </script>
</head>
<body onload="init()">
<img src="images/1.jpg" id="first"/>
</body>
</html>
```

# 六、完成页面定时弹出广告

## 1、需求分析

一般网页，当我们刚打开的时候，它会5秒之后，显示一个广告，让我们看5秒钟，然后他的广告就自动消失了！

## 2、技术分析

- 定时器
  - setInterval : 每隔多少毫秒执行一次函数
  - setTimeout: 多少毫秒之后执行一次函数
  - clearInterval
  - clearTimeout
- 显示广告 img.style.display  = "block"
- 隐藏广告 img.style.display  = "none"

## 3、步骤分析

1. 确定事件: 页面加载完成的事件 onload
2. 事件要触发函数:  init()
3. init函数里面做一件事: 
   1. 启动一个定时器 : setTimeout() 
   2. 显示一个广告
      1. 再去开启一个定时5秒钟之后,关闭广告

## 4、代码实现

```html
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script>
        function out(){
            var img=document.getElementById("first");
            img.style.display="none";
        }
        function hide(){
            var img=document.getElementById("first");
            //弹出广告
            img.style.display="block";
            //显示5秒自动关闭
            setTimeout("out()",5000);

        }
        function init(){
            setTimeout("hide()",2000);
        }
    </script>
</head>
<body onload="init()">
<img src="images/1.jpg" id="first" style="display:none"/>
</body>
</html>
```

# 七、完成表单的校验

## 1、需求分析

之前我们做了一个简单的表单校验，每当用户输入出错的时候，我们是弹出了一个对话框，提示用户去修改。这样的用户体验效果非常不好好。现在就是需要来对他进行一个修改，当用户输入信息有问题的时候，我们就再输入框的后面给他一个友好提示。

## 2、技术分析

【HTML中innerHTML属性】

【JS中的常用事件】

onfocus 事件: 获得焦点事件

onblur : 失去焦点

onkeyup : 按键抬起事件

## 3、 代码实现

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<!--
			引入外部的js文件
		-->
		<script type="text/javascript" src="../js/regutils.js" ></script>
		<script>
			/*
				1. 确定事件 : onfocus
				2. 事件要驱动函数
				3. 函数要干一些事情: 修改span的内容
			*/
			function showTips(spanID,msg){
				//首先要获得要操作元素 span
				var span = document.getElementById(spanID);
				span.innerHTML = msg;
			}
			/*
				校验用户名:
				1.事件: onblur  失去焦点
				2.函数: checkUsername()
				3.函数去显示校验结果
			*/
			function checkUsername(){
				//获取用户输入的内容
				var uValue = document.getElementById("username").value;
				//对输入的内容进行校验
				//获得要显示结果的span
				var span = document.getElementById("span_username");
				if(uValue.length < 6){
					//显示校验结果
					span.innerHTML = "<font color='red' size='2'>对不起,太短</font>";
					return false;
				}else{
					span.innerHTML = "<font color='red' size='2'>恭喜您,可用</font>";
					return true;
				}
			}
			
			/*
			 密码校验
			 */
			function checkPassword(){
				//获取密码输入
				var uPass = document.getElementById("password").value;
				var span = document.getElementById("span_password");
				//对密码输入进行校验
				if(uPass.length < 6){
					span.innerHTML = "<font color='red' size='2'>对不起,太短</font>";
					return false;
				}else{
					span.innerHTML = "<font color='red' size='2'>恭喜您,够用</font>";
					return true;
				}
			}
			
			/*
			 确认密码校验
			 * */
			function checkRePassword(){
				//获取密码输入
				var uPass = document.getElementById("password").value;
				
				//获取确认密码输入
				var uRePass = document.getElementById("repassword").value;
				var span = document.getElementById("span_repassword");
				
				//对密码输入进行校验
				if(uPass != uRePass){
					span.innerHTML = "<font color='red' size='2'>对不起,两次密码不一致</font>";
					return false;
				}else{
					span.innerHTML = "";
					return true;
				}
			}
			
			/*
			 校验邮箱
			 * */
			function checkMail(){
				var umail = document.getElementById("email").value;
				var flag = checkEmail(umail);
				
				var span = document.getElementById("span_email");
				//对邮箱输入进行校验
				if(flag){
					span.innerHTML = "<font color='red' size='2'>恭喜您,可用</font>";
					return true;
				}else{
					span.innerHTML = "<font color='red' size='2'>对不起,邮箱格式貌似有问题</font>";
					return false;
				}
			}
			
			function checkForm(){
				var flag = checkUsername() && checkPassword() && checkRePassword() && checkMail();
				return flag;
			}
			
		</script>
	</head>
	<body>
		<form action="../01-自动轮播图片/图片自动轮播.html" onsubmit="return checkForm()" >
			用户名:<input type="text" id="username" onfocus="showTips('span_username','用户名长度不能小于6')" onblur="checkUsername()" onkeyup="checkUsername()" /><span id="span_username"></span><br />
			密码:<input type="password" id="password" onfocus="showTips('span_password','密码长度不能小于6')" onblur="checkPassword()" onkeyup="checkPassword()"/><span id="span_password"></span><br />
			确认密码:<input type="password" id="repassword" onfocus="showTips('span_repassword','两次密码必须一致')" onblur="checkRePassword()" onkeyup="checkRePassword()" /><span id="span_repassword"></span><br />
			邮箱:<input type="text" id="email" onfocus="showTips('span_email','邮箱格式必须正确')" onblur="checkMail()" /><span id="span_email"></span><br />
			手机号:<input type="text" id="text" /><br />
			
			<input type="submit" value="提交" />
		</form>
	</body>
</html>
```

# 八、表格隔行换色

## 1、需求分析

我们商品分类的信息太多，如果每一行都显示同一个颜色的话会让人看的眼花，为了提高用户体验，减少用户看错的情况，需要对表格进行隔行换色

## 2、步骤分析

确定事件: 文档加载完成 onload

1. 事件要触发函数: init()
   1. 函数:操作页面的元素
      要操作表格中每一行
         	动态的修改行的背景颜色

## 3、代码实现

```html
<script >
			function init(){
				//得到表格
				var tab = document.getElementById("tab");
				//得到表格中每一行
				var rows = tab.rows;
				//便利所有的行,然后根据奇数 偶数
				for(var i=1; i < rows.length; i++){
					var row = rows[i];  //得到其中的某一行
					if(i%2==0){
						row.bgColor = "yellow";
					}else{
						row.bgColor = "red"
					}
				}
			}
</script>
```

# 九、复选框的全选和全不选

## 1、需求分析

商品分类界面中，当我们点击全选框的时候，我们希望选中所有的商品，当我们取消掉的时候，我们希望不选中所有的商品

## 2、技术分析

事件 : onclick点击事件

## 3、 步骤分析

全选和全不选步骤分析:

1.确定事件: onclick 单机事件
2.事件触发函数: checkAll()
3.函数要去做一些事情:
  	获得当前第一个checkbox的状态
  	 获得所有分类项的checkbox
  	修改每一个checkbox的状态

## 4、代码实现

```html
function checkAll(){
//				获得当前第一个checkbox的状态
				var check1 = document.getElementById("check1");
				//得到当前checked状态
				var checked = check1.checked;
//				 	获得所有分类项的checkbox
//				var checks = document.getElementsByTagName("input");
				var checks = document.getElementsByName("checkone");
//				alert(checks.length);
				for(var i = 0; i < checks.length; i++){
//				 	修改每一个checkbox的状态
					var checkone = checks[i];
					checkone.checked = checked;
				}
			}
```

# 十、HTML中的DOM操作

一些常用的 HTML DOM 方法：
  getElementById(id) - 获取带有指定 id 的节点（元素） 
  appendChild(node) - 插入新的子节点（元素） 
  removeChild(node) - 删除子节点（元素） 

  一些常用的 HTML DOM 属性：
  innerHTML - 节点（元素）的文本值 
  parentNode - 节点（元素）的父节点 
  childNodes - 节点（元素）的子节点 
  attributes - 节点（元素）的属性节点 


查找节点：
getElementById() 返回带有指定 ID 的元素。 
getElementsByTagName() 返回包含带有指定标签名称的所有元素的节点列表（集合/节点数组）。 
getElementsByClassName() 返回包含带有指定类名的所有元素的节点列表。 

增加节点：
createAttribute() 创建属性节点。 
createElement() 创建元素节点。 
createTextNode() 创建文本节点。 
insertBefore() 在指定的子节点前面插入新的子节点。 
appendChild() 把新的子节点添加到指定节点。 

删除节点：
removeChild() 删除子节点。 
replaceChild() 替换子节点。 

修改节点：
setAttribute()  修改属性
setAttributeNode()  修改属性节点

# 十一、省市联动效果

## 1、需求分析

在网站中选择省份的时候，在右边的城市选择中会跳出对应的城市信息，达到省市联动的效果

## 2、技术分析

利用dom操作

## 3、代码实现

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script>
			/*
				准备工作 : 准备数据
			*/
			var provinces = [
				["深圳市","东莞市","惠州市","广州市"],
				["长沙市","岳阳市","株洲市","湘潭市"],
				["厦门市","福州市","漳州市","泉州市"]
			];
			/*
				1. 确定事件:  onchange
				2. 函数: selectProvince()
				3. 函数里面要搞事情了
					得到当前操作元素
					得到当前选中的是那一个省份
					从数组中取出对应的城市信息
					
					动态创建城市元素节点
					添加到城市select中
					
			*/
			function selectProvince(){
				var province = document.getElementById("province");
				//得到当前选中的是哪个省份
				//alert(province.value);
				var value = province.value;
				//从数组中取出对应的城市信息
				var cities = provinces[value];
				var citySelect = document.getElementById("city");
				//清空select中的option
				citySelect.options.length = 0;
				
				for (var i=0; i < cities.length; i++) {
//					alert(cities[i]);
					var cityText = cities[i]; 
					//动态创建城市元素节点   <option>东莞市</option>
					
					//创建option节点
					var option1 = document.createElement("option"); // <option></option>
					//创建城市文本节点
					var textNode = document.createTextNode(cityText) ;// 东莞市
					
					//将option节点和文本内容关联起来
					option1.appendChild(textNode);  //<option>东莞市</option>
					
//					添加到城市select中
					citySelect.appendChild(option1);
				}
				
			}
			
		</script>
	</head>
	<body>
		<!--选择省份-->
		<select onchange="selectProvince()" id="province">
			<option value="-1">--请选择--</option>
			<option value="0">广东省</option>
			<option value="1">湖南省</option>
			<option value="2">福建省</option>
		</select>
		<!--选择城市-->
		<select id="city"></select>
	</body>
</html>

```



# 十二、使用JS控制下拉列表左右选择

## 1、需求分析:

在我们的分类管理中,我们要能够去修改我们的分类信息,当我们一点修改的时候,跳转到一个可以编辑的页面,这里面能够修改分类的名称,分类的描述,以及分类的商品

## 2、 代码实现

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<!--
			步骤分析
				1. 确定事件: 点击事件 :onclick事件
				2. 事件要触发函数 selectOne
				3. selectOne要做一些操作
					(将左边选中的元素移动到右边的select中)
					1. 获取左边Select中被选中的元素
					2. 将选中的元素添加到右边的Select中就可以
		-->
		<script>
			
			function selectOne(){
//				1. 获取左边Select中被选中的元素
				var leftSelect = document.getElementById("leftSelect");
				var options = leftSelect.options;
				
				//找到右侧的Select
				var rightSelect = document.getElementById("rightSelect");
				//遍历找出被选中的option
				for(var i=0; i < options.length; i++){
					var option1 = options[i];
					if(option1.selected){
		//				2. 将选中的元素添加到右边的Select中就可以
						rightSelect.appendChild(option1);
					}
				}
			}
			
			//将左边所有的商品移动到右边
			function selectAll(){
//				1. 获取左边Select中被选中的元素
				var leftSelect = document.getElementById("leftSelect");
				var options = leftSelect.options;
				
				//找到右侧的Select
				var rightSelect = document.getElementById("rightSelect");
				//遍历找出被选中的option
				for(var i=options.length - 1; i >=0; i--){
					var option1 = options[i];
					rightSelect.appendChild(option1);
				}
			}
			
			
			
		</script>
	</head>
	<body>
		
		<table border="1px" width="400px">
			<tr>
				<td>分类名称</td>
				<td><input type="text" value="手机数码"/></td>
			</tr>
			<tr>
				<td>分类描述</td>
				<td><input type="text" value="这里面都是手机数码"/></td>
			</tr>
			<tr>
				<td>分类商品</td>
				<td>
					<!--左边-->
					<div style="float: left;">
						已有商品<br />
						<select multiple="multiple" id="leftSelect" ondblclick="selectOne()">
							<option>华为</option>
							<option>小米</option>
							<option>锤子</option>
							<option>oppo</option>
						</select>
						<br />
						<a href="#" onclick="selectOne()"> &gt;&gt; </a> <br />
						<a href="#" onclick="selectAll()"> &gt;&gt;&gt; </a>
					</div>
					<!--右边-->
					<div style="float: right;"> 
						未有商品<br />
						<select multiple="multiple" id="rightSelect">
							<option>苹果6</option>
							<option>肾7</option>
							<option>诺基亚</option>
							<option>波导</option>
						</select>
						<br />
						<a href="#"> &lt;&lt; </a> <br />
						<a href="#"> &lt;&lt;&lt; </a>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交"/>
				</td>
			</tr>
		</table>
	</body>
</html>
```



# 十三、使用JS实现页面上动态实时时钟

代码展示：两个定时函数的调用

```javascript
<body onload="shoowTime()">
<div id="datetime" ></div>
<input type="button" id="first" value="点击" onclick="closeTime()"/>
</body>
</html>
<script>
    //全局标量，标记变量，点击停止或者开始
    var flag=true;
    //计时函数
    var time=setInterval("shoowTime()",1000);
    //显示时间
    function shoowTime(){
        var date=new Date();
        var year=date.getFullYear();
        var month=date.getMonth();
        var day = date.getDate();
        var hour=date.getHours();
        var minute=date.getMinutes();
        var second=date.getSeconds();
        var ele=document.getElementById("datetime");
        ele.innerHTML=year+"年"+month+"月"+day+"日"+hour+"："+minute+"："+second+"：";
    }
    //点击开始或者停止计时

    function closeTime(){
        if(flag==true){
            clearInterval(time);
            flag=false;
        }else{
            setInterval("shoowTime()",1000);
            flag=true;
        }
    }
</script>
```

