<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acesso liberado</title>
<link rel="stylesheet" type="text/css" href="resources/css/tabela.css" />
<link rel="stylesheet" type="text/css" href="resources/css/acesso_liberado.css" />
<script type="text/javascript" src="resources/js/pesquisas.js"></script>  
</head>
<body onload="focar('pesq')">
	<%
		out.println("<a href='principal.jsp'><img alt='Voltar' title='Voltar' src='resources/imagens/voltar.png'></a><hr/>");
	%>
	<div>
	   <form action="salvarUsuario?crud=4" method="post" >
	      <input type="text" size="30" id="pesq" name="pesquisa" autocomplete="off" value="<%if(request.getAttribute("pesq") != null){out.println(request.getAttribute("pesq"));} %>">
	      <input type="submit" value="Pesquisar">	      
	   </form>
	</div>
	<table>
		<th>codigo</th>
		<th>Nome</th>
		<th>Telefone</th>
		<th>Email</th>
		<th>Senha</th>
		<th>Op��es</th>
		<c:forEach items="${usuarios}" var="user">
			<tr>
				<td><c:out value="${user.codigo}" /></td>
				<td><c:out value="${user.nome}" /></td>
				<td><c:out value="${user.telefone}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.senha}" /></td>
				<td>
				    <a href="salvarUsuario?crud=3&codigo=${user.codigo}"><img alt="Excluir" title="Excluir" src="resources/imagens/remover.png"></a>
					<a href="salvarUsuario?redirect=1&crud=2&codigo=${user.codigo}"><img alt="Alterar" title="Alterar" src="resources/imagens/alterar.png"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>