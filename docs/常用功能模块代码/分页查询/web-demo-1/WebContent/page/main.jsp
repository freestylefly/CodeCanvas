<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>

<!-- 使用外联框架拼接页面
	属性:	rows: 表示将页面横向切割的格式.
				例如: rows="50,*", 表示, 页面横向分为2份, 上部高度为50像素, 其它为下部
					  rows="50,*,50", 
					  	表示, 横向分为上中下3部分, 上下为50像素, 其它为中部
			cols: 表示页面的纵向分割格式
 -->
<frameset rows="50,*,50" border="0" frameborder="no">
	<!-- frame代表具体的显示窗口 -->
	<frame src="top.jsp" scrolling="no">
	<!-- 将中部继续切分成左右两个窗口 -->
	<frameset cols="200,*">
		<frame src="left.jsp"  scrolling="no">
		<!-- 主显示区 -->
		<frame src="index.jsp" name="mainframe">
	</frameset>
	<frame src="bottom.jsp"  scrolling="no">
</frameset>

<noframes>
<body>
</body>
</noframes>
</html>