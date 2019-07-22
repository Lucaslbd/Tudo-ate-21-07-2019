<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl</title>
</head>
<body>
	<%
		out.println("<a href='index.jsp'><button>Tela principal</button></a><hr/>");
	%>
	<c:out value="${'Bem vindo(a) ao jstl'}" />
	<!-- Imprime na tela -->
	<hr />
	<!--<c:import var="data" url="http://www.google.com.br"/> <!-- Pega o codigo do caminho -->
	<c:set scope="page" var="data" value="${500 * 6}" />
	<c:remove var="data" />
	<c:out value="${data}" />
	<hr />
	<c:catch var="erro">
		<%
			int i = 200 / 0;
		%>
	</c:catch>
	<c:if test="${erro != null }">
		<c:out value="${erro.message}" />
	</c:if>
	<hr />
	<c:set scope="page" var="numero" value="50" />
	<c:choose>
		<c:when test="${numero > 50 }">
			<c:out value="O numero é maior que 50"></c:out>
		</c:when>
		<c:when test="${numero < 50 }">
			<c:out value="O numero é menor 50"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="Nenhuma opção foi satisfeita"></c:out>
		</c:otherwise>
	</c:choose>
	<hr />
	<c:forEach var="i" begin="1" end="10">
		<c:out value="${i }" />
		<br />
	</c:forEach>
	<hr />
	<c:forTokens items="Lucas Bertoldi Dias" delims=" " var="nome">
		<c:out value="${nome }" />
		<br />
	</c:forTokens>
	<hr />
	<c:url value="index.jsp" var="principal">
		<c:param name="parametro1" value="1234" />
		<c:param name="parametro1" value="4567" />
	</c:url>
	<c:set scope="page" var="mudar" value="2" />
	<c:if test="${mudar == 1 }">
		<c:redirect url="${principal}" />
	</c:if>

</body>
</html>












