<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/index.css" />
</head>
<body>
	<div id="caixa">
		<div id="caixa2">
		   Login de acesso
		</div>
		<img src="resources/imagens/usuario.png" />
        <form action="salvarUsuario?crud=5" method="post">
		    <input type="email" size="30" maxlength="60" required="required" placeholder="Digite seu email" id="email" name="email" />      
            <input type="password" size="30" maxlength="60" required="required" placeholder="Digite aqui sua senha" id="senha" name="senha" />      
            <a href="cadastro_usuario.jsp?crud=1" target="_self">N�o tenho cadastro</a>
            <input type="submit" value="Acessar" />            
		</form>
		<div id="msg">
		   <h3><%if(request.getAttribute("msg") != null){out.println(request.getAttribute("msg"));}%></h3>
		</div>
	</div>
</body>
</html>