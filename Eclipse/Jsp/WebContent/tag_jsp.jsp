<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="recebendoParametro.jsp">
		<jsp:param value="10" name="pr1" />
		<jsp:param value="20" name="pr2" />
	</jsp:forward>
</body>
</html>