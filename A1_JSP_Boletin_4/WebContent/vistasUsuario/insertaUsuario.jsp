<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Crear Usuario</title>
</head>
<body>
	<h1>Registro del usuario</h1>

	<form action="../Controlador_InsertaUsuario" method="post">

		<label for="nombre">Nombre:</label> <input type="text"
			name="txtNombre" /><br />
		<br /> <label for="apellidos">Apellidos:</label> <input type="text"
			name="txtApellidos" /><br />
		<br /> <label for="usuario">Usuario:</label> <input type="text"
			name="txtUsuario" /><br />
		<br /> <label for="contrasena">Contraseña:</label> <input
			type="password" name="txtContrasena" /><br />
		<br /> <label for="pais">País:</label> <input type="text"
			name="txtPais" /><br />
		<br /> <label for="tecnologia">Tecnología:</label> <input type="text"
			name="txtTecnologia" /><br />
		<br />
		<p>
			<input type="submit" value="Crear Usuario"></input>
		</p>
	</form>
	<p>
		<a href="../tratarUsuarios.html">Volver al menú.</a>
	</p>

</body>
</html>