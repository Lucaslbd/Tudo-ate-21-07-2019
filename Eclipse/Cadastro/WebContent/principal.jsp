<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela principal</title>
</head>
<body>
	<%
		out.println("<a href='index.jsp'><img alt='Voltar' title='Voltar' src='resources/imagens/voltar.png'></a><hr/>");
	%>
	<a href="salvarUsuario?redirect=2"><img src="resources/imagens/tela_usuario.png"></a>
	<a href="CadastroProduto?redirect=2"><img src="resources/imagens/tela_produto.png"></a>
</body>
</html>