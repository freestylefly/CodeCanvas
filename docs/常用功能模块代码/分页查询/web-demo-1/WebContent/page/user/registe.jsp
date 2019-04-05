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
	<form action="${pageContext.request.contextPath }/register" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password"></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<input type="radio" name="gender" value="1">男
					<input type="radio" name="gender" value="0">女
					<input type="radio" name="gender" value="2" checked>保密
				</td>
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
</script>
</html>