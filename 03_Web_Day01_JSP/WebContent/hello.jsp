<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
String name;
public void init(){
	name = "�ȳ��ϼ��� SSAFY ������!";
}
    %>
<%
	name = "�̸� ���� ���� ����Ǿ��׿�.";
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
	<h2>�ȳ� ���� !!<%= name %></h2>
</body>
</html>