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
	<c:url var="linkSesion" value="/Controlador">
   		<c:param name="instruccion" value="verTitulosSesion"></c:param>
    </c:url>
    
 	<c:url var="linkBd" value="/Controlador">
   		<c:param name="instruccion" value="verTitulosBd"></c:param>
    </c:url>
	<p><a href="${linkSesion }">Visualizar títulos de recetas de Sesion</a></p>
	<p><a href="${linkBd }">Visualizar títulos de recetas de base de datos</a></p>
	<a href="${pageContext.request.contextPath}/index.html">Inicio</a>
</body>
</html>