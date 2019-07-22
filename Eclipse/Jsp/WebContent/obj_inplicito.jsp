<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Obj Implicito</title>
</head>
<body>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a>");
		out.println("<hr/>Endereço do contexto: " + request.getContextPath());
		out.println("<hr/>Endereço local: " + request.getLocalAddr());
		out.println("<hr/>Porta: " + request.getLocalPort());
		out.println("<hr/>Url do contexto: " + request.getRequestURI());
		out.println("<hr/>Protocolo: " + request.getProtocol());
		out.println("<hr/>Id de sessão: " + request.getSession());
		out.println("<hr/>Parametro do web xml: " + application.getInitParameter("Estado"));
	%>
</body>
</html>