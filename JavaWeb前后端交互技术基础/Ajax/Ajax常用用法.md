# 一、ajax是什么

异步的脚本，在整体页面不刷新的情况下，完成与后台数据交互，并根据返回数据，局部刷新页面

# 二、ajax常用场合

1、表单验证：如验证用户名是否可用

2、页面拼接显示

3、前后端分离式的网站结构

# 三、ajax常见使用格式

## 1、基础格式

```
	语法: $.ajax({
	 		url:"需要访问的后台方法的地址",
	 		type:"post", //数据传递的格式, post或get
	 		data: {}, //需要携带到后台的请求参数
	 		dataType: "", //参数的数据格式, 例如"json"
	 								  success:fucntion(data){ 
 //后台响应成功后需要执行的回调函数
	 						
	 				   }
 });
```

## 2. post格式(常用)

```
//表单验证
$("[name='userName']").bind("blur", function(){
    //获取数据
	var userName = $("[name='userName']").val().trim();
	//关闭异步
	$.ajaxSettings.async = false;
	//使用ajax访问后台, 查询用户名是否存在
	//ajax post格式
	$.post(
		"${pageContext.request.contextPath }/checkUserName", //地址
		{
			userName:userName
		},
		//"userName="+userName, //参数(传给后台的参数)
		//"${pageContext.request.contextPath }/checkUserName?userName="+userName,
		function(data){//data是后台传过来的参数，也可以是HTML页面
			//辅助变量
			var msg = "√";
			var color = "green";
			//判断
			if(data==0){
				msg = "用户名已存在";
				color = "red";
				flag = false;
			}
			
			$("[name='userName']").parent().next().html(msg).css("color", color);
		}
	);
	//开启异步
	$.ajaxSettings.async = true;
    
    
}
```

## 3、get格式

```
$.get(
		"${pageContext.request.contextPath }/checkUserName?userName="+userName,
		function(data){
			//辅助变量
			var msg = "√";
			var color = "green";
			//判断
			if(data==0){
				msg = "用户名已存在";
				color = "red";
				flag = false;
			}
			$("[name='userName']").parent().next().html(msg).css("color", color);
		}
	);
```

# 四、使用ajax进行页面拼接

## 1、ajax局部刷新函数

使用该函数可以做到，将请求通过ajax传递给后台并携带页面需要传递到后台的参数，这个后台就是处理该请求的servlet，吼他接收到了请求，需要传递给页面一个消息，跳转到需要的页面。当然这里可以理解为后台传递给了页面一个页面作为参数data，然后tojump方法接收到该data，将该页面显示在我们需要指定的区域，这个时候相当于完成了局部刷新（记住ajax的执行过程）

```
//ajax局部页面刷新
function toJump(url, param) {
	//alert(url+":"+param);
	$.post(
		webroot+url, //拼接绝对路径
		param,
		function(data){
			//alert(data);
			$("#main").html(data); //将id main中的内容替换成data接收到的页面
		},
		"html" //表示, data接收的数据类型是页面
	);
}
```

比如我要将这个请求给到queryOne这个servlet，不携带任何参数，那么该后台接收到请求之后做什么呢？

```
//跳转到个人中心显示页(将页面信息作为参数传给页面
response.sendRedirect(request.getContextPath()+"/page/user/info.jsp");
```

很简单，只需要跳转到需要显示的页面，这里理解为跳转该页面为将该页面作为data参数返回给到页面

## 2、调用函数，实现局部显示

这个时候在页面中调用toJump("queryOne");函数那么就可以将该页面放在我们想放的范围内显示了