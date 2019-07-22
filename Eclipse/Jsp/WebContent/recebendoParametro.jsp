<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recebendo parametro</title>
</head>
<body>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a><hr/>");
		String p1 = request.getParameter("pr1");
		String p2 = request.getParameter("pr2");
		int num1 = 0;
		int num2 = 0;
		boolean somar = false;
		try {
			num1 = Integer.parseInt(p1);
			out.println("<p>O parametro 1  é o numero: " + num1 + "</p><hr/>");
			somar = true;
		} catch (Exception ex) {
			out.println("<p>O parametro 1  é o texto: " + p1 + "</p><hr/>");
			somar = false;
		}
		try {
			num2 = Integer.parseInt(p2);
			out.println("<p>O parametro 2  é o numero: " + num2 + "</p><hr/>");
		} catch (Exception ex) {
			out.println("<p>O parametro 2  é o texto: " + p2 + "</p><hr/>");
			somar = false;
		}
		if (somar) {
			out.println("A soma dos numero é: " + retorna(num1, num2));
		}
	%>

	<%!public int retorna(int num1, int num2) {
		return num1 + num2;
	}	
	%>	


</body>
</html>