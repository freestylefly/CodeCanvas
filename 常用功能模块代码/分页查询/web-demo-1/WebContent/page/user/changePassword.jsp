<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
<fieldset class="changePassword">
	<legend>修改密码</legend>
	<form action="${pageContext.request.contextPath }/changePassword" method="post">
		<table>
			<tr>
				<td>新密码</td>
				<td>
					<input type="password" name="newPassword"></input>
				</td>
			</tr>
			<tr>
				<td>再输一遍新密码</td>
				<td>
					<input type="password"></input>
				</td>
			</tr>
			<tr>
				<td style="color:red">
				${succsize}
				<c:remove var="succsize" scope="session"/>
				</td>
				<td>
					<input type="submit" value="提交" onclick="if(!confirm('确认修改吗？')) return false"></input>
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