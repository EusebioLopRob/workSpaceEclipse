<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Recetas de sesion</h1>
<ul>
<c:forEach var="receta" items="${recetasSesion}">
					<li>${receta}</li>
</c:forEach>
</ul>
<a href="${pageContext.request.contextPath}/index.html">Inicio</a>
</body>
</html>