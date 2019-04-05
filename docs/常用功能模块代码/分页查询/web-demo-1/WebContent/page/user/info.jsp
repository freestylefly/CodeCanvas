<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>个人中心</title>
	<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<fieldset class="info">
	<legend>个人中心</legend>
	<form>
		<table>
			<tr>
				<td>用户名:</td>
				<td>
					<span>${loginInfo.userName }</span>
					<!-- <input type="text" name="userName"> -->
				</td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<span>${loginInfo.gender==1 ? "男" : (loginInfo.gender==0 ? "女" : "保密") }</span>
				</td>
			</tr>
			<tr>
				<td>注册时间:</td>
				<td>
					<span>${loginInfo.registeTime }</span>
				</td>
			</tr>
		</table>
	</form>
</fieldset>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/project.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/registe.js"></script>
<script>
webroot="${pageContext.request.contextPath }";
</script>
</html>