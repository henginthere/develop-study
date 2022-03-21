<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 관리</title>
<style>
</style>
</head>
<body>
	<%-- header.jsp를 include해서 재사용하기 --%>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<ul>
			<li>
				<a href="${root }/regist">게시물 등록</a>
			<li>
				<a href="${root }/list">게시물 목록</a>
		</ul>
	</div>
</body>
</html>