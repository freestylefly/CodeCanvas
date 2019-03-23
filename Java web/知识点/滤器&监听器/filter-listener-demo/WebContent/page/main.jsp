<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="page">
<div class="top">
	<div>欢迎您用户${loginInfo.userName }</div>
	<div>
		<a href="javascript:toJump('queryOne','id=${loginInfo.id }')">个人中心</a>
		|
		<a href="${pageContext.request.contextPath }/logoff"
			onclick="return confirm('确定退出吗?')">退出</a>
	</div>
</div>

<div class="middle">
	
	<div class="left">
		<ul>
			<li>个人中心</li>
			<li>修改密码</li>
			<li>用户查询</li>
			<li>退出</li>
		</ul>
	</div>
	
	<div id="main" class="main">
		<div class="welcome">
			欢迎您使用XXX系统
		</div>
	</div>
</div>

<div class="bottom">&copy;版权所有 JT35 2019 - 1 - 16</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/project.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/menu.js"></script>
<script type="text/javascript">
webroot = "${pageContext.request.contextPath }/";
loginId = "${loginInfo.id}";
</script>
</html>