<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a>");
	%>
	<h3>O index foi incluido nesta págian</h3>
	<%@ include file="index.jsp"%>
</body>
</html>