<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Request en formularios inicio</title>
</head>
<body>
	<h1>Ejemplo 6: Uso del objeto request en un formulario</h1>
	<h2>Aquí se piden los datos</h2>
	<p>Hola, por favor introduce la información</p>
	<form action="paginaDestino6.jsp" method="post">
		<table border="2">
			<tr>
				<td align="right">Nombre:</td>
				<td><input type="text" name="nombre"/></td>
			</tr>
			<tr>
				<td align="right">Color favorito:</td>
				<td><input type="text" name="color"/></td>
			</tr>
			<tr>
				<td align="right">Correo</td>
				<td><input type="text" name="correo"/></td>
			</tr>
		</table>
		<p>
			<input type="reset" value="Borrar" />
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<a href="../index.html">volver</a>
</body>
</html>