<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login del usuario</title>
</head>
<body>
	<form action="../Controlador_Login" method="post">
		<label for="usuario">Usuario:</label> <input type="text"
			name="txtUsuario" /><br />
		<br /> <label for="contrasena">Contraseña:</label> <input
			type="password" name="txtContrasena" /><br />
		<br />

		<p>
			<input type="submit" value="login"></input>
		</p>
	</form>
	<p>
		<a href="../tratarUsuarios.html">Volver al menú.</a>
	</p>

</body>
</html>