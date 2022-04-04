<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" import="empleados.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Formulario JSTL</title>
</head>
<body>
	<h1>Formulario JSTL</h1>
	<form action="proceso.jsp" method="post">
		<table border="2">
			<tr>
				<td>Nombre:</td><td><input type="text" name="nombre"/></td>
			</tr>
			<tr>
				<td>Apellido:</td><td><input type="text" name="apellido"/></td>
			</tr>
			<tr>
				<td>Edad:</td><td><input type="text" name="edad"/></td>
			</tr>
		</table>
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>