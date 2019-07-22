<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Principal</title>
</head>
<body>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a><hr/>");
	%>
	<jsp:include page="cabecalho.jsp"/>
	<jsp:include page="rodape.jsp"/>
</body>
</html>