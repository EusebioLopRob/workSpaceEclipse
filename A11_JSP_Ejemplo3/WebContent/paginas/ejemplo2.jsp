<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Formulario de registro</title>
</head>
<body>
	<h1>Registro</h1>
	<form action="recoge_datos.jsp" method="post">
		<div style="float: left">
			<p><label for="nombre">Nombre: </label><input type="text" name="nombre" id="nombre"/></p>
			<p><label for="apellidos">Apellidos: </label><input type="text" name="apellidos" id="apellidos"/></p>
			<p><label for="usuario">Usuario: </label><input type="text" name="usuario" id="usuario"/></p>
			<p><label for="contra">Contraseña: </label><input type="text" name="contra" id="contra"/></p>
			<p>
				<label for="contra">Pais: </label>
				<select name="pais">
					<option value="España">España</option>
					<option value="Francia">Francia</option>
					<option value="Alemania">Alemania</option>
				</select>
			</p>
		</div>
		<div style="float: left">
			<p>
				Tecnologías<br />
				<label for="java">JAVA</label><input type="radio" name="tecnologias" value="Java" checked="checked"/><br />	
				<label for="php">PHP</label><input type="radio" name="tecnologias" value="PHP" /><br />	
				<label for="js">JavaScript</label><input type="radio" name="tecnologias" value="javaScript" /><br />	
			</p>
		</div>
		<p style=""><input type="submit" value="Enviar"/><input type="reset" value="Borrar"/></p>
	</form>
</body>
</html>