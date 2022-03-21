<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- DTO를 참조하기 위해서 import 처리가 필요하다. -->
<%@ page import="com.ssafy.ws.dto.*"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록 결과</title>
<style>
td:nth-child(3) {
	width: 150px;
}

#cover {
	width: 150px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>게시물 등록 결과</h1>
		<%-- c:if 태그를 이용해 request 영역에 board가 있다면 내용을 출력한다. --%>
		<c:if test="${!empty board }">
			<table class="table">
				<thead>
					<tr>
						<th>항목</th>
						<th colspan="2">내용</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>글 번호</td>
						<td>${board.no }</td>
						<td rowspan="5"><img id="cover"></td>
					</tr>
					<tr>
						<td>글 제목</td>
						<td>${board.title }</td>
					</tr>
					<tr>
						<td>글 내용</td>
						<td colspan="2">${board.content }</td>
					</tr>
					<tr>
						<td>글 작성자</td>
						<td>${board.writer }</td>
					</tr>
				</tbody>
			</table>
		</c:if>
		<%-- c:if 태그를 이용해 request 영역에 board이 없다면 정보가 없음을 출력한다. --%>
		<c:if test="${empty board }">
			<p>등록된 게시물이 없습니다.</p>
		</c:if>
		<!-- 다시 도서를 등록할 수 있는 링크를 제공한다. -->
		<a href="${root }/regist" class="stretched-link">[추가등록]</a>
		<a href="${root }/list" class="stretched-link">[목록보기]</a>
	</div>
</body>
</html>