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
	<br/><hr/>
	<form action="param_receber.jsp" method="post">	
		<input type="text" size="30" maxlength="60" required="required" autocomplete="off" placeholder="Digite seu estado" name="estado"/><br/><br/>
		<input type="text" size="30" maxlength="60" required="required" autocomplete="off" placeholder="Digite sua cidade" name="cidade"/><br/><br/>
		<input type="text" size="30" maxlength="60" required="required" autocomplete="off" placeholder="Digite eu bairro" name="bairro"/><br/><br/>
		<input type="text" size="30" maxlength="60" required="required" autocomplete="off" placeholder="Digite sua rua" name="rua"/><br/><br/>
		<input type="submit" value="Enviar"> 
	</form>
</body>
</html>