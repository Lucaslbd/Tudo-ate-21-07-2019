<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Template</title>
        <link rel="stylesheet" type="text/css" href="css/estyle.css" />
    </head>
    <body>
        <header id="header">
            <h1>Hello World!</h1>      
        </header>
        <div id="wraper">
            <nav>
                <h1>Menu</h1>
                <ul>
                    <a href="index.jsp"><li>Home</li></a>
                    <a href="getIP.jsp"><li>Pegar ip</li></a>
                    <a href="enviar.jsp"><li>Enviar dados</li></a>
                    <a href="direcionamento.jsp"><li>Direcionamento</li></a>
                    <a href="sessao.jsp"><li>Iniciar sessão</li></a>
                    <a href="include.jsp"><li>Include</li></a>
                    <a href="#"><li>Link 8</li></a>
                    <a href="#"><li>Link 9</li></a>
                    <a href="#"><li>Link 10</li></a>
                </ul>
            </nav>
            <main>
                <div id="content">
                    <h1>Pegando ip do usuário</h1>
                    <%
                        out.print("Seu ip é: " + request.getRemoteAddr() + "<br/>");
                        out.print("Contexto: " + request.getContextPath() + "<br/>");
                        out.print("Porta: " + request.getLocalPort() + "<br/>");
                        out.print("Protocolo: " + request.getProtocol() + "<br/>");
                    %>
                </div>
            </main>           
        </div>
        <footer>

        </footer>
    </body>
</html>
