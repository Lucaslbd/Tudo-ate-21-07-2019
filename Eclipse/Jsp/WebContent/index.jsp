<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Principal</title>
<link rel="stylesheet" type="text/css" href="resources/css/stylo.css">
</head>
<body>
	<%
		out.println("<h1>Bem vindo ao curso de jsp | A sessão está como: "+session.getAttribute("nome")+"</h1>");
		out.println("<p>Confira os conteudos que serão aprendidos no curso</p><hr/>");		
		out.println("<a href='enviandoParametro.jsp'><button>Aula 1) Passando parâmetros</button></a><hr/>");
		out.println("<a href='obj_inplicito.jsp'><button>Aula 2) Parâmetros implicitos</button></a><hr/>");
		out.println("<a href='chama_redirecionamento.jsp'><button>Aula 3) Direcionamento</button></a><hr/>");
		out.println("<a href='criar_sessao.jsp'><button>Aula 4)Criar sessão</button></a><hr/>");
		out.println("<a href='remover_sessao.jsp'><button>Aula 5)Remover sessão</button></a><hr/>");
		out.println("<a href='directivas.jsp'><button>Aula 6)Directivas</button></a><hr/>");
		out.println("<a href='include.jsp'><button>Aula 7)Include</button></a><hr/>");
		out.println("<a href='tag_jsp.jsp'><button>Aula 8)Tag Jsp Forwords</button></a><hr/>");
		out.println("<a href='principal.jsp'><button>Aula 9)Tag Jsp include</button></a><hr/>");
		out.println("<a href='chamar_bean.jsp'><button>Aula 10)Chamar bean</button></a><hr/>");
		out.println("<a href='param_enviar.jsp'><button>Aula 11)Expression language</button></a><hr/>");
		out.println("<a href='simulando_login.jsp'><button>Aula 12)Simulando login</button></a><hr/>");
		out.println("<a href='jstl.jsp'><button>Aula 13)Jstl</button></a><hr/>");
	%>
</body>
</html>