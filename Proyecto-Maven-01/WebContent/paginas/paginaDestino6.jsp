<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Request en formularios destino</title>
</head>
<body>
	<h1>Ejemplo 6: Esta es la página de destino</h1>
	<h2>Aquí se reciben los datos</h2>
	<p>Tus datos</p>

	<%
		String nombre = request.getParameter("nombre");
	String color = request.getParameter("color");
	String correo = request.getParameter("correo");
	%>
	<table border="2">
		<tr>
			<td align="right">Te llamas:</td>
			<td><%=nombre%></td>
		</tr>
		<tr>
			<td align="right">Tu color favorito es:</td>
			<td><%=color%></td>
		</tr>
		<tr>
			<td align="right">Tu correo es:</td>
			<td><%=correo%></td>
		</tr>
	</table>
	<a href="./ejemplo6.jsp">volver</a>
</body>
</html>