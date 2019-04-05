<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户查询</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="list">
	<table>
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>性别</td>
			<td>注册时间</td>
		</tr>
		<c:forEach items="${userList }" var="u" varStatus="i">
		<tr bgcolor="${i.index%2 == 0 ? 'lightblue':'lightgray' }">
			<td>${i.index+1 }</td>
			<td>${u.userName }</td>
			<td>${u.gender==1 ? "男" : (u.gender==0 ? "女" : "保密")}</td>
			<td>${u.registeTime }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="2">
				第&nbsp;${pa.currPage }&nbsp;页&nbsp;
				/ &nbsp;共&nbsp;${pa.totalPage }&nbsp;页
				&nbsp;当前显示第&nbsp;${pa.start+1 }&nbsp;条
				到 第&nbsp;${pa.start+pa.pageSize > pa.count ? pa.count : pa.start+pa.pageSize }&nbsp;条
				每页
				<select>
					<c:forEach begin="5" end="20" step="5" var="n">
					<option value="${n }" <c:if test="${pa.pageSize == n }"> selected  </c:if> >
					${n}
					</option>
					</c:forEach>
				</select>
				条
			</td>
			<td colspan="3">
				<input type="button" value="首页"
					<c:if test="${pa.currPage == 1 }">disabled</c:if>
				>
				<input type="button" value="上一页"
					<c:if test="${pa.currPage == 1 }">disabled</c:if>
				>
				<input type="button" value="下一页"
					<c:if test="${pa.currPage == pa.totalPage }">disabled</c:if>
				>
				<input type="button" value="尾页"
					<c:if test="${pa.currPage == pa.totalPage }">disabled</c:if>
				>
				跳转到
				<select>
					<c:forEach begin="1" end="${pa.totalPage }" step="1" var="n">
					<option value="${n }"
						<c:if test="${pa.currPage == n }">selected</c:if>
					>${n }</option>
					</c:forEach>
				</select>
				页
			</td>
		</tr>
	</table>

</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/project.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/page.js"></script>
<script type="text/javascript">
/* 获取必要的变量数据 */
webroot = "${pageContext.request.contextPath }";
curr = parseInt("${pa.currPage}");
total = parseInt("${pa.totalPage}");
size = parseInt("${pa.pageSize}");
</script>
</html>