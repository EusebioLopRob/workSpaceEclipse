<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>MOSTRAR USUARIO</title>
</head>
<body>

	<table border="2">
		<tr>
			<th>ID_USUARIO</th>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>USUARIO</th>
			<th>CONTRASEÑA</th>
			<th>TECNOLOGÍA</th>
			<th>PAÍS</th>
		</tr>
		<tr>
			<td>${datos_usuario.id_usuario}</td>
			<td>${datos_usuario.nombre}</td>
			<td>${datos_usuario.apellidos}</td>
			<td>${datos_usuario.usuario}</td>
			<td>${datos_usuario.contrasena}</td>
			<td>${datos_usuario.tecnologia}</td>
			<td>${datos_usuario.pais}</td>
		</tr>
	</table>
	<p>
		<a href="../tratarUsuarios.html">Volver al menú.</a>
	</p>


</body>
</html>