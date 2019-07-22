<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de produto</title>
<link rel="stylesheet" type="text/css" href="resources/css/cadastro_usuario.css" />
<script type="text/javascript" src="resources/js/jquery.js"></script>  
<script type="text/javascript" src="resources/js/mascaras.js"></script>  
</head>
<body>
	<%
		   out.println("<a href='CadastroProduto?redirect=2'><button>Voltar</button></a><hr/>");	
	%>
  <fieldset>
		<legend>Cadastro de produto</legend>
		<form action="CadastroProduto" method="post">
		    <input type="hidden" name="id" value="${produto.id}"> 
		    <input type="hidden" name="crud" value="<%=request.getParameter("crud") %>"> 
		    <input type="text" maxlength="13" autocomplete="off" required="required" placeholder="Digite o codigo do produto" title="Digite o codigo do produto" name="codigo" value="${produto.codigo}" onkeyup="numInt(this)"/>
		    <input type="text" maxlength="60" required="required" placeholder="Digite o nome do produto" title="Digite o nome do produto" name="nome" value="${produto.nome}" />
			<input type="text" maxlength="7" required="required" placeholder="Digite o estoque do produto" title="Digite o estoque do produto"	name="estoque" value="${produto.estoque}" onkeyup="numInt(this)" />
			<input type="text" maxlength="11" required="required" placeholder="Digite o valor do produto" title="Digite o valor do produto" name="valor" value="${produto.valor}" autocomplete="off" onkeyup=" numDouble(this)"/>
			<input type="submit" value="Finalzar" title="Deseja registrar?"/>
		</form>
		<div id="msg">
		   <h3><%if(request.getAttribute("msg") != null){out.println(request.getAttribute("msg"));}%></h3>
		</div>
	</fieldset>
  </body>
</html>