<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuário</title>
<link rel="stylesheet" type="text/css" href="resources/css/cadastro_usuario.css" />
<script type="text/javascript" src="resources/js/jquery.js"></script>  
<script type="text/javascript" src="resources/js/mascaras.js"></script>  
</head>
<body>
	<%		
	if(request.getParameter("crud").equals("1")){
	   out.println("<a href='index.jsp'><button>Voltar</button></a><hr/>");		
	}else{
	   out.println("<a href='salvarUsuario?redirect=2'><button>Voltar</button></a><hr/>");	
	}
	%>
  <fieldset>
		<legend>Cadastro de usuário</legend>
		<form action="salvarUsuario" method="post">
		    <input type="hidden" name="codigo" value="${usuario.codigo}"> 
		    <input type="hidden" name="crud" value="<%=request.getParameter("crud") %>"> 
		    <input type="text" maxlength="60" required="required" placeholder="Digite seu nome" title="Digite seu nome"	name="nome" value="${usuario.nome }" />
		    <input type="tel" maxlength="17" required="required" autocomplete="off" placeholder="Digite seu telefone" title="Digite seu telefone" name="telefone" value="${usuario.telefone }" onkeyup="maskTel(this);"/>
			<input type="email" maxlength="60" required="required" placeholder="Digite seu e-mail" title="Digite seu email"	name="email" value="${usuario.email }" />
			<input type="password" maxlength="60" required="required" placeholder="Digite sua senha" title="Digite sua senha" name="senha" value="${usuario.senha }" />
			<input type="submit" value="Finalzar" title="Deseja registrar?" />
		</form>
		<div id="msg">
		   <h3><%if(request.getAttribute("msg") != null){out.println(request.getAttribute("msg"));}%></h3>
		</div>
	</fieldset>
  </body>
</html>