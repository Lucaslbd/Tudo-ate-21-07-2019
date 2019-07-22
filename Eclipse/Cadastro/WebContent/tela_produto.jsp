<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de produtos</title>
<link rel="stylesheet" type="text/css" href="resources/css/tabela.css" />
<link rel="stylesheet" type="text/css"href="resources/css/acesso_liberado.css" />
<script type="text/javascript" src="resources/js/pesquisas.js"></script>  
</head>
<body onload="focar('pesq')">
	<%
		out.println("<a href='principal.jsp'><img alt='Voltar' title='Voltar' src='resources/imagens/voltar.png'></a>");
	    out.println("<a href='cadastro_produto.jsp?crud=1'><img alt='Cadastrar produto' title='Cadastrar produto' src='resources/imagens/gravar_registro.gif'></a><hr/>");
	%>
	<div>
	   <form action="CadastroProduto?crud=4" method="post" >
	      <input type="text" id="pesq" size="30" name="pesquisa" autocomplete="off" value="<%if(request.getAttribute("pesq") != null){out.println(request.getAttribute("pesq"));} %>">
	      <input type="submit" value="Pesquisar">	      
	   </form>
	</div>
	<table>
		<th>Id</th>
		<th>Codigo</th>
		<th>Nome</th>
		<th>Estoque</th>
		<th>Valor</th>
		<th>Op��es</th>
		<c:forEach items="${produtos}" var="item">
			<tr>
			    <td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.codigo}" /></td>
				<td><c:out value="${item.nome}" /></td>
				<td><c:out value="${item.estoque}" /></td>
				<td><%="R$ " %><c:out value="${item.valor}" /></td>				
				<td>
				    <a href="CadastroProduto?crud=3&id=${item.id}"><img alt="Excluir" title="Excluir" src="resources/imagens/remover.png"></a>
					<a href="CadastroProduto?redirect=1&crud=2&id=${item.id}"><img alt="Alterar" title="Alterar" src="resources/imagens/alterar.png"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>