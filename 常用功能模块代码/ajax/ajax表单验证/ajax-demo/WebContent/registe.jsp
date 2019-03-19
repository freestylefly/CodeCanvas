<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注册页</title>
	<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<fieldset class="login">
	<legend>用户注册</legend>
	<form action="${pageContext.request.contextPath }/registe" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName"></td>
				<td></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"></td>
				<td></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password"></td>
				<td></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<input type="radio" name="gender" value="1">男
					<input type="radio" name="gender" value="0">女
					<input type="radio" name="gender" value="2" checked>保密
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="注册">
					<input type="button" value="取消">
				</td>
			</tr>
		</table>
	</form>
</fieldset>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/project.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/registe.js"></script>
<script type="text/javascript">
webroot = "${pageContext.request.contextPath}";

$("[name='userName']").bind("blur", function(){
	
	/*
	 	ajax的常见使用格式3种:
	 		1. 基础格式
	 			语法: $.ajax({
	 					url:"需要访问的后台方法的地址",
	 					type:"post", //数据传递的格式, post或get
	 					data: {}, //需要携带到后台的请求参数
	 					dataType: "", //参数的数据格式, 例如"json"
	 					success:fucntion(data){ //后台响应成功后需要执行的回调函数
	 						
	 					}
	 				  });
	 		2. post格式(常用)
	 		
	 		3. get格式
	*/
	
	//获取数据
	var userName = $("[name='userName']").val().trim();
	
	var flag = true;
	
	//关闭异步
	$.ajaxSettings.async = false;
	
	//使用ajax访问后台, 查询用户名是否存在
	//ajax post格式
	$.post(
		"${pageContext.request.contextPath }/checkUserName", //地址
		{
			userName:userName
		},
		//"userName="+userName, //参数
		//"${pageContext.request.contextPath }/checkUserName?userName="+userName,
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
	
	//ajax get格式
	/* $.get(
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
	); */
	
	//开启异步
	$.ajaxSettings.async = true;
	
	alert(flag);
	//ajax基础格式
	/* $.ajax({
		url:"${pageContext.request.contextPath }/checkUserName",
		type:"post",
		data:{
			userName:userName,
			password:"9999"
		},
		dataType:"json",
		success:function(data){
			alert(data);
		}
	}); */
	
});

</script>
</html>









