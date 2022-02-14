<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
String name;
public void init(){
	name = "안녕하세요 SSAFY 여러분!";
}
    %>
<%
	name = "이름 변수 값이 변경되었네요.";
	response.setContentType("text/html; charset=UTF-8");
	out.print(name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Servlet !!</h1><br>
	<h2>안녕 서블릿 !!<%= name %></h2>
</body>
</html>