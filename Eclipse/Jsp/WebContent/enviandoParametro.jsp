<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enviando parametros</title>
</head>
<body>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a><hr/>");
	%>
	<form action="recebendoParametro.jsp" method="post">
		<input type="text" name="pr1" required="required" />
		<input type="text" name="pr2" required="required" /> 
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>