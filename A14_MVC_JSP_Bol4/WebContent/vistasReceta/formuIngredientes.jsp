<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Receta</title>
</head>
<body>
<h1>Nueva receta de panadería</h1>
	<form action="${pageContext.request.contextPath}/" method="post">
		<table>
			<tr>
				<td align="right">Título de la receta</td>
				<td><input type="text" name="titulo" /></td>
			</tr>
			<tr>
				<td align="right">Apellidos</td>
				<td><input type="text" name="txtApellidos" /></td>
			</tr>
			<tr>
				<td align="right">Usuario</td>
				<td><input type="text" name="txtUsuario" /></td>
			</tr>
			<tr>
				<td align="right">Contraseña</td>
				<td><input type="text" name="txtContrasena" /></td>
			</tr>
			<tr>
				<td align="right">Pais</td>
				<td><input type="text" name="txtPais" /></td>
			</tr>		
			<tr>
				<td align="right">Tecnología</td>
				<td><input type="text" name="txtTecnologia" /></td>
			</tr>
			
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Confirmar receta" /></td>			
			</tr>		
		</table>

	</form>	


</body>
</html>