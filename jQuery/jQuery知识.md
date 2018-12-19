# 一、jQuery概述

## 1、什么是jQuery？

jQuery是一个快速、简洁的JavaScript框架，是继Prototype之后又一个优秀的JavaScript代码库（*或JavaScript框架*）。jQuery设计的宗旨是“write Less，Do More”，即倡导写更少的代码，做更多的事情。它封装JavaScript常用的功能代码，提供一种简便的JavaScript设计模式，优化HTML文档操作、事件处理、动画设计和Ajax交互。

## 2、jQuery的核心特性

jQuery的核心特性可以总结为：具有独特的链式语法和短小清晰的多功能接口；具有高效灵活的css选择器，并且可对CSS选择器进行扩展；拥有便捷的插件扩展机制和丰富的插件。jQuery兼容各种主流浏览器，如IE 6.0+、FF 1.5+、Safari 2.0+、Opera 9.0+等

## 3、JQuery的作用:

- 写更少的代码,做更多的事情: write Less ,Do more
- 将我们页面的JS代码和HTML页面代码进行分离

# 二、jQuery入门

## 1、JQ的语法结构

1、页面加载完成事件

$(document)..ready(function(){})

$(document).ready()与window.onload类似，但也有区别

|          |                        window.onload                         |                     $(document).ready()                      |
| :------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| 执行时机 | 必须等待网页中所有的内容加载完毕后（包括图片、flash、视频等）才能执行 | 网页中所有DOM文档结构绘制完毕后即刻执行，可能与DOM元素关联的内容（图片、flash、视频等）并没有加载完 |
| 编写个数 |                   同一页面不能同时编写多个                   |                    同一页面能同时编写多个                    |
| 简化写法 |                              无                              |                        $(function(){                         |

$(selector).action()

$()工厂函数，将dom对象转换为JQ对象

selector：选择器

action()：方法，有事件处理方法

## 2、JQ的开发步骤:

```html
1. 导入JQ相关的文件
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
通过选择器选择对哪个对象进行操作
2.  文档加载完成事件: $(function)  : 页面初始化的操作: 绑定事件, 启动页面定时器
 $(function () {}——简写
$(document)..ready(function(){}) _ 一般写法
3. 确定相关操作的事件
用JQ选择器选定要绑定事件的按钮或者元素，通过.事件的方法绑定时间，里面再嵌套一个函数
4. 事件触发函数
5. 函数里面再去操作相关的元素
```

## 3、JS和JQ文档流加载区别

```html
<script>
			//js文档加载完成的事件
			window.onload = function(){
				alert("window.onload   111");
			}
			
			window.onload = function(){
				alert("window.onload   222");
			}
			
			/*文档加载完成的事件*/
			jQuery(document).ready(function(){
			 	alert("jQuery(document).ready(function()");
			});
			/*
			 	jQuery  简写成 $
			 */
			$(document).ready(function(){
			 	alert("$(document).ready(function()");
			});
			
			/*
				最简单的写法 
			*/
			$(function(){
				alert("$(function(){");
			});
			
		</script>
```

js会覆盖，而JQ不会覆盖

- 脚本从上到下执行
- onload事件是在页面先加载完再执行，
- JQ中的页面加载完成事件在页面加载完成后执行但是速度比onload要快，所以脚本文件一般写在页面最底部

## 3、JQ和JS之间的转换

- JQ对象,只能调用JQ的属性和方法
- JS对象 只能调用JS的属性和方法

```html
function changeJS(){
				var div = document.getElementById("div1");
//				div.innerHTML = "JS成功修改了内容"
				//将JS对象转成JQ对象
				$(div).html("转成JQ对象来修改内容")
			}
			
			$(function(){
				//给按钮绑定事件
				$("#btn2").click(function(){
					//找到div1
//					$("#div1").html("JQ方式成功修改了内容");
					//将JQ对象转成JS对象来调用
					var $div = $("#div1");
//					var jsDiv = $div.get(0);
					var jsDiv = $div[0];
					jsDiv.innerHTML="jq转成JS对象成功";
				});
			});
```

## 4、JQ操作样式

1、css（）方法

单个样式：css("属性","属性值")

多个样式：css("属性":"属性值","属性":"属性值");

2、addClass()方法：在括号内直接写类名即可，不用加点

样式多的时候使用

链式操作（选择器选择了一个元素.next()代表下一个元素，children（"a")代表下一个名字是a的子元素）和隐式迭代

## 5、JQ常用方法

mouseover():鼠标悬浮

mouseout():鼠标移出

show()：显示

hide()：隐藏

# 三、JQuery中的选择器

![JQ选择器](https://img-blog.csdnimg.cn/20181219103748717.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 1、基本选择器

- ID选择器 :     #ID的名称
- 类选择器:     以 . 开头  .类名
- 元素（标签）选择器:    标签的名称
- 通配符（全局）选择器:   * 
- 并集选择器:  选择器1，选择器2

案例：

```html
	<!--
			- ID选择器 :     #ID的名称
			- 类选择器:     以 . 开头  .类名
			- 元素选择器:    标签的名称
			- 通配符选择器:   * 
			- 选择器,选择器:  选择器1,选择器2
		-->
		<script>
			//文档加载事件,页面初始化的操作
			$(function(){
				//初始化操作: 给按钮绑定事件
				$("#btn1").click(function(){
					$("#two").css("background-color","palegreen");					
				});
				
				//找出mini类的所有元素
				$("#btn2").click(function(){
					$(".mini").css("background-color","palegreen");					
				});
				$("#btn3").click(function(){
					$("div").css("background-color","palegreen");					
				});
				$("#btn4").click(function(){
					$("*").css("background-color","palegreen");
					
				});
				/*选择器分组*/
				
				//找出mini类 和 span元素
				$("#btn5").click(function(){
					$(".mini,span").css("background-color","palegreen");
				});
			});
		</script>
```



## 2、层级选择器

- 子元素选择器:   选择器1 > 选择器2（只能是儿子）
- 后代选择器:  选择器1 儿孙
- 相邻兄弟选择器 :  选择器1 + 选择器2 : 找出紧挨着的同辈元素（第一个弟弟）
- 通用兄弟选择器:  选择器1~ 选择器2   : 找出所有选择器1之后的同辈元素

```html
<script>
			//文档加载事件,页面初始化的操作
			$(function(){
				//初始化操作: 给按钮绑定事件
				//找出body下面的子div   
				$("#btn1").click(function(){
					$("body > div").css("background-color","palegreen");					
				});
				//找出body下面的所有div
				$("#btn2").click(function(){
					$("body div").css("background-color","palegreen");					
				});
				$("#btn3").click(function(){
					$("#one+div").css("background-color","palegreen");					
				});
				$("#btn4").click(function(){
					$("#two~div").css("background-color","palegreen");					
				});
				
			});
		</script>
```

## 3、属性选择器

- a[name]含有属性名为name的元素
- a[name="value"]有属性名为name的属性值为value元素
- a[name^="value"]含有属性名为name的属性值以value开头元素
- a[name$="value"]含有属性名为name的属性值以value结尾元素
- a[name*="value"]含有属性名为name的属性值包含value的元素

## 4、JQ中的基本过滤器

通过特定的过滤规则来筛选出所需的元素

1. 基本过滤选择器(索引一律从0开始)

   ::even：选取索引为偶数的元素

   ::odd：选取索引为奇数的元素

   eq（index）：选取索引为index的元素

   :gt（index）：选取索引大于index的元素

   :lt（index）：选取索引小于index的元素

   :header：选取所有标题元素（h1-h6）

   :focus：选取当前获取焦点的元素

   :animated：选取所有动画

2. 可见性过滤选择器s

   hidden：选择所有隐藏的元素（能选到display-none、hide（）、type=“hidden”

   visible：选择所有可见的元素

3. 表单对象

4. 内容/子元素过滤选择器

特殊符号的转义：\\

选择器的书写规范很严格，多一个空格或少一个空格，都会影响选择器的效果

```html
		<script>
			$(function(){
				/<script>
			//文档加载事件,页面初始化的操作
			$(function(){
				
				//初始化操作: 给按钮绑定事件
				//过滤出所有div中第一个元素
				$("#btn1").click(function(){
					$("div:first").css("background-color","palegreen");					
				});
				
				//过滤出所有div中偶数位的div
				$("#btn2").click(function(){
					$("div:even").css("background-color","palegreen");					
				});
				$("#btn3").click(function(){
					$("div:odd").css("background-color","palegreen");					
				});
				$("#btn4").click(function(){
					$("div:gt(2)").css("background-color","palegreen");					
				});
			
			});
		</script>
```

## 4、JQ中的属性选择器

```html
		$(function(){
				//找到有name属性的input
				$("#btn1").click(function(){
					$("input[name]").attr("checked",true);
				});
				$("#btn2").click(function(){
					$("input[name='accept']").attr("checked",true);
				});
				$("#btn3").click(function(){
					$("input[name='newsletter'][value='Hot Fuzz']").attr("checked",true);
				});
			});
```



## 5、JQ中的表单过滤器

:selected

:checked

```html
<script>
  //1.文档加载事件	
  $(function(){
    $(":text").css("background-color","pink");
  });
</script>
```

# 四、JQ中常用函数及遍历数组

```html
$(function)  : 文档加载完成的事件
css()  : 	修改css样式
prop() :    修改属性/ 获取属性
html() :    修改innerHTML

append : 	给自己添加子节点
appendTo :  将自己添加到别人家,给自己找一个爹
prepend :   在自己最前面添加子节点
after	:   在自己后面添加一个兄弟
empty	:   清空所有子节点

$(cities).each(function(i,n){
  	
})

$.each(arr,function(i,n){
  
});
```

# 五、JQ中的动画效果

show()
hide()
slideUp
slideDown
fadeIn
fadeOut
animate : 自定义动画

# 六、使用JQuery完成页面定时弹出广告

## 1、 需求分析

当用户打开界面，3秒钟之后弹出广告，这个广告显示5秒钟，隐藏广告

## 2、 技术分析

定时器: setTimeout 

显示和隐藏:  style.display = "block/none"

## 3、步骤分析

1. 导入JQ的文件
2. 编写JQ的文档加载事件
3. 启动定时器 setTimeout("",3000);
4. 编写显示广告的函数
5. 在显示广告里面再启动一个定时器
6. 编写隐藏广告的函数

## 4、代码实现

```html
<script>
			//显示广告
			function showAd(){
				$("#img1").slideDown(2000);
				setTimeout("hideAd()",3000);
			}
			//隐藏广告
			function hideAd(){
				$("#img1").slideUp(2000);
			}
			$(function(){
				setTimeout("showAd()",3000);
			});
		</script>
```

# 七、使用JQ完成表格的隔行换色

## 1、需求分析

在我们的实际开发过程中,我们的表格如果所有的行都是一样的话,很容易看花眼,所以我们需要让我们的表格隔行换色

## 2、技术分析

获取所有行 table.rows

遍历所有行

根据行号去修改每一行的背景颜色: bgColor

​	style.backgroundColor = "red"

## 3、步骤分析

1. 导入JQ的包
2. 文档加载完成函数: 页面初始化
3. 获得所有的行 :   元素选择器
4. 根据行号去修改颜色

## 5、代码实现

```html
	$(function(){
				//获得所有的行 :   元素选择器
				$("tbody > tr:even").css("background-color","#CCCCCC");
				//修改基数行
				$("tbody > tr:odd").css("background-color","#FFF38F");
//				$("tbody > tr").css("background-color","#FFF38F");
				
				
			});
```

# 八、使用JQuery完成表单的全选全不选功能以及隔行换色

## 1、需求分析

在我们对表格处理的时,有些情况下,我们需要对表格进行批量处理,，隔行换色

## 2、代码实现:

```html
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script>

        $(function () {
            $("tr:even:gt(0)").css("background-color","#CCCCCc");
            //鼠标点击后触发
            $("tr:odd").mousedown(function(){
                $("tr:odd").css("background-color","red");
            });
            //通过鼠标在元素上移动
            $("tr:odd").mousemove(function(){
                $("tr:odd").css("background-color","yellow");
            });
            //mouseout事件在鼠标从元素上离开后会触发
            $("tr:odd").mouseout(function(){
                $("tr:odd").css("background-color","blue");
            });
            //为元素绑定函数，点击
            $("#cheack1").click(function(){
                //全选和取消全选
                $("input[type='checkbox']:gt(0)").prop("checked",this.checked);
                $("body > table > tbody > tr:nth-child(2) > td:nth-child(1) > input[type="checkbox"]")
            });

        });
    </script>
</head>
<body>
<table border="1px" width="300px" cellpadding="0" cellspacing="0">
    <tr>
        <th><input type="checkbox" id="cheack1"/></th>
        <th>姓名</th>
        <th>年龄</th>
        <th>爱好</th>
    </tr>
    <tr align="center">
        <td><input type="checkbox"/></td>
        <td >江彬</td>
        <td>24</td>
        <td>编程</td>
    </tr>
    <tr align="center">
        <td><input type="checkbox"/></td>
        <td>初识</td>
        <td>22</td>
        <td>看书</td>
    </tr>
    <tr align="center">
        <td><input type="checkbox"/></td>
        <td>张三</td>
        <td>26</td>
        <td>鞋子</td>
    </tr>
    <tr align="center">
        <td><input type="checkbox"/></td>
        <td>王五</td>
        <td>23</td>
        <td>看电影</td>
    </tr>

</table>
</body>
</html>
```

# 九、使用JQ完成省市联动效果

## 1、需求分析

在我们的注册表单中,通常我们需要知道用户的籍贯,需要一个给用选择的项,当用户选中了省份之后,列出省下面所有的城市

## 2、技术分析

1. 准备工作 : 城市信息的数据
2. 添加节点 :  appendChild (JS)
   1. append  :  添加子元素到末尾
   2. appendTo  : 给自己找一个爹,将自己添加到别人家里
   3. prepend : 在子元素前面添加
   4. after :   在自己的后面添加一个兄弟
3. 遍历的操作:

## 3、步骤分析

1. 导入JQ的文件
2. 文档加载事件:页面初始化
3. 进一步确定事件:  change事件
4. 函数: 得到当前选中省份
5. 得到城市, 遍历城市数据
6. 将遍历出来的城市添加到城市的select中

## 4、代码实现

```html
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>省市联动效果制作</title>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script>
        /*
         准备工作 : 准备数据
         */
        var provinces = [
            ["深圳市","东莞市","惠州市","广州市"],
            ["长沙市","岳阳市","株洲市","湘潭市"],
            ["厦门市","福州市","漳州市","泉州市"]
        ];
        $(function () {
            $("#province").change(function(){
                var citys=provinces[this.value];
                //清空城市信息
                $("#city").empty();
                //遍历城市信息
                $(citys).each(function(i,n){
                    $("#city").append("<option>"+n+"</option>");
                })

            });
        });
    </script>
</head>
<body>
<!--选择省份-->
<select name="sheng" id="province">
    <option value="1">请选择</option>
    <option value="0">广东</option>
    <option value="1">湖南</option>
    <option value="2">福建</option>
</select>
<!--选择城市-->
<select name="city" id="city">

</select>
</body>
</html>
```

# 十、使用JQ完成下拉列表左右选择

## 1、代码实现

```html
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
    <script>
        $(function(){
            //双击添加至右边
            $("#leftSelect option").dblclick(function(){
                $("#rightSelect").append($("#leftSelect option:selected"));
            });
            $("#a1").click(function(){
                //找到被选中的那一项
                //将被选中项添加到右边
                $("#rightSelect").append($("#leftSelect option:selected"));
            });

            //将左边所有商品移动到右边
            $("#a2").click(function(){
                $("#rightSelect").append($("#leftSelect option"));
            });

            //将右边商品点击选中放入左边
            $("#b1").click(function(){
                $("#leftSelect").append($("#rightSelect option:selected"))
            })
            //将右边所有商品选中放入左边
            $("#b2").click(function(){
                $("#leftSelect").append($("#rightSelect option"))
            })
            //双击添加至左边
            $("#rightSelect option").dblclick(function(){
                $("#leftSelect").append($("#rightSelect option:selected"))
            });
        });
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
                已有商品<br/>
                <select multiple="multiple" id="leftSelect">
                    <option>华为</option>
                    <option>小米</option>
                    <option>锤子</option>
                    <option>oppo</option>
                </select>
                <br/>
                <a href="#" id="a1"> &gt;&gt; </a> <br/>
                <a href="#" id="a2"> &gt;&gt;&gt; </a>
            </div>
            <!--右边-->
            <div style="float: right;">
                未有商品<br/>
                <select multiple="multiple" id="rightSelect">
                    <option>苹果6</option>
                    <option>肾7</option>
                    <option>诺基亚</option>
                    <option>波导</option>
                </select>
                <br/>
                <a href="#" id="b1"> &lt;&lt; </a> <br/>
                <a href="#" id="b2"> &lt;&lt;&lt; </a>
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

