<jsp:useBean id="calcula" class="beans.PrimeiroBeans"
	type="beans.PrimeiroBeans" scope="page" />

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
	<jsp:setProperty property="*" name="calcula" />
	<jsp:getProperty property="estado" name="calcula" />
	<jsp:getProperty property="cidade" name="calcula" />
	<jsp:getProperty property="bairro" name="calcula" />
	<jsp:getProperty property="rua" name="calcula" />
</body>
</html>