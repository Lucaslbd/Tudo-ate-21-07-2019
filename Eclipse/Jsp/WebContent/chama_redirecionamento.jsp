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
		out.println("<a href='index.jsp'><button>Tela principal</button></a><hr/>");
	%>
	<form action="redirecionamento.jsp" method="post">
		<button value="http://www.google.com" name="pagina">Google</button>
	</form>
	<form action="redirecionamento.jsp" method="post">
		<button value="http://www.youtube.com" name="pagina">YouTube</button>
	</form>
</body>
</html>