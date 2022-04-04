<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ejemplo Select</title>
</head>
<body>
	<h1>¿Cuál es tu ciudad favorita?</h1>
	<form action="recibe_peticion.jsp" method="post">
		<select name="ciudad_favorita" id="ciudad_favorita">
			<option>Madrid</option>
			<option>Venecia</option>
			<option>Estambul</option>
			<option>New York</option>
			<option>Sidney</option>
			<option>Sevilla</option>
		</select>
		<br /> <br /> <br />
		<input type="submit" value="Enviar"/>
	</form>
	<p><a href="../index.html">volver</a></p>
</body>
</html>