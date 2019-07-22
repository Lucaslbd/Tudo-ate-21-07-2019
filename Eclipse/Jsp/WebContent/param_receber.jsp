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
	<jsp:setProperty property="*" name="calcula" />
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a><hr/>");
	%>
	Estado: ${param.estado}
	<br /> Cidade: ${param.cidade}
	<br /> Bairro: ${param.bairro}
	<br /> Rua: ${param.rua}
	<br /> Pessoa: ${sessionScope.nome}
</body>
</html>