<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="login.jsp" method="post">
		<p>
			<label for="usuario">Usuario: </label>
			<input type="text" name="usuario" id="usuario"/>
		</p>
		<p>
			<label for="contrasena">Contraseña: </label>
			<input type="text" name="contrasena" id="contrasena"/>
		</p>
		<input type="submit" value="Login"/>
	</form>
	<p><a href="../index.html">volver...</a></p>
</body>
</html>