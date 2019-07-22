<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a><hr/>");
	%>
	<form action="LoginServlet" method="post">
		<label for="email">Email:</label>
        <input type="email" size="30" maxlength="60" required="required" autocomplete="off" placeholder="Digite seu email" id="email" name="email" />
        <br/>
        <br/>
        <label for="senha">Senha:</label>
        <input type="password" size="30" maxlength="60" required="required" placeholder="Digite aqui sua senha" id="senha" name="senha" />      
        <input type="submit" value="Acessar" />
        <input type="reset" value="Limpar" />
   	</form>
</body>
</html>