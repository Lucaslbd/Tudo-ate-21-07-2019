<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Directivas</title>
</head>
<body>
	<%@ page import="java.util.Date"%>
	<%@ page errorPage="pagina_erro.jsp"%>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a><hr/>");
		out.println(new Date());
	%>
</body>
</html>