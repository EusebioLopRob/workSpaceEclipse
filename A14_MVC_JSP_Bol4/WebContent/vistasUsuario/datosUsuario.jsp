<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DATOS DEL USUARIO</title>
</head>
<body>
	<p>Datos del usuario</p>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Usuario</th>
			<th>Contraseña</th>
			<th>País</th>
			<th>Tecnología</th>
		</tr>
		<tr>
			<c:forEach var="usuario" items="${datos_usuario}">
				<td>${usuario}</td>
			</c:forEach>
		</tr>
	</table>
	<p><a href="vistasUsuario/consultaUsuario.jsp">Ir a consulta de usuario</a>
</body>
</html>