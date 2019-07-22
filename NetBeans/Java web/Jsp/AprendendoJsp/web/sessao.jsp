<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sessão</h1>
        <%
         session.setAttribute("primeira sessao", "12345");
         response.sendRedirect("pegarSessao.jsp");
        %>
    </body>
</html>
