<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ACTUALIZA USUARIO</title>
</head>
<body>
<h1>Teclee nombre de usuario y contraseña para actualizar</h1>
<form action="${pageContext.request.contextPath}/Controlador_ActualizaUsuario" method="post">
		<label for="usuario">Usuario:</label> <input type="text"
			name="usUsuario" /><br />
		<br /> <label for="contrasena">Contraseña:</label> <input
			type="password" name="usContrasena" /><br />
		<br />

		<p>
			<input type="submit" value="Busca Usuario" name="botonBusca"></input>
		</p>
		<label for="idUsuario">id_usuario:</label> <input type="text"
			name="txtidUsuario" value="${usuario.id_usuario}" readonly/><br />		
		<br /><label for="nombre">Nombre:</label> <input type="text"
			name="txtNombre" value="${usuario.nombre}"/><br />
		<br /> <label for="apellidos">Apellidos:</label> <input type="text"
			name="txtApellidos" value="${usuario.apellidos}"></input><br />
		<br /> <label for="usuario">Usuario:</label> <input type="text"
			name="txtUsuario" value="${usuario.usuario}"/><br />
		<br /> <label for="contrasena">Contraseña:</label> <input
			type="text" name="txtContrasena" value="${usuario.contrasena}"/><br />
		<br /> <label for="pais">País:</label> <input type="text"
			name="txtPais" value="${usuario.pais}"/><br />
		<br /> <label for="tecnologia">Tecnología:</label> <input type="text"
			name="txtTecnologia" value="${usuario.tecnologia}"/><br />
		<br />
		<p>
			<input type="submit" value="Actualiza Usuario" name="botonActualiza"></input>
		</p>		
		
	</form>
	<p>
		<a href="../tratarUsuarios.html">Volver al menú.</a>
	</p>

</body>
</html>