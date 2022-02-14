<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
	<h1>글 목록</h1>
	<a href="/?action=insert-form">글쓰기</a>
	<br />
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록자</th>
			<th>등록일</th>
		</tr>

		<!-- EL: ${ expr } -->
		<c:forEach items="${ requestScope.list }" var="board">
			<tr>
				<td>${ board.no }</td>
				<td>${ board.title }</td>
				<td>${ board.writer }</td>
				<td>${ board.reqDate }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
