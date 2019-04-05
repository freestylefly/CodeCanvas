<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录页</title>
	<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<fieldset class="login">
	<legend>用户登录</legend>
	<form action="login" method="post">
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
				<td></td>
				<td>
					<input type="submit" value="登录">
					<input type="button" value="注册">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>${errMsg }</td>
				<c:remove var="errMsg" scope="session"/>
			</tr>
		</table>
	</form>
</fieldset>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/project.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/registe.js"></script>
<script >
webroot = "${pageContext.request.contextPath}";
</script>
</html>