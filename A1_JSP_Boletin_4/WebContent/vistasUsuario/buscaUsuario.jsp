<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Busqueda de usuario</title>
</head>
<body>
	<h1>Búsqueda por clave por usuario:</h1>
	<form action="../Controlador_BuscaUsuario" method="post">
		<label for="txtIDUsuario">ID_Usuario:</label> <input type="text"
			name="txtIDUsuario" />

		<p>
			<input type="submit" value="Busca Usuario"></input>
		</p>
	</form>
	<p>
		<a href="../tratarUsuarios.html">Volver al menú.</a>
	</p>

</body>
</html>