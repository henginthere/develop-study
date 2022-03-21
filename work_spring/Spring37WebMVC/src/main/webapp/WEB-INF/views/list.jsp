<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>게시물 목록</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>글 번호</th>
					<th>글 제목</th>
					<th>글 내용</th>
					<th>글 작성자</th>
				</tr>
			</thead>
			<tbody>
				<%-- request 영역에 boards로 등록된 자료를 반복문을 이용해 출력한다. --%>
				<c:forEach items="${boards }" var="board">
					<tr>
						<td>${board.no }</td>
						<td>${board.title }</td>
						<td>${board.content }</td>
						<td>${board.writer }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<br> <a href="${root }/regist">도서 등록</a>
	</div>
</body>
</html>