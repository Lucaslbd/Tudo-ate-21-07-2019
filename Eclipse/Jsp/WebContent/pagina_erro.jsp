<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de erro</title>
</head>
<body>
	<%@ page isErrorPage="true"%>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a>");
	%>
	<h1>Erro</h1>
	<%=exception%>
</body>
</html>