<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/resources/css/tabla.css"
	rel="stylesheet" type="text/css" />
<title>CARRO DE LA COMPRA</title>
</head>
<body>
	<div id="tabla">
		<table border="2">
			<tr>
				<th>CODPROD</th>
				<th>SECCIÓN</th>
				<th>NOMBREPROD</th>
				<th>PRECIO</th>
				<th>FECHA</th>
				<th>IMPORTADO</th>
				<th>PAÍS</th>
				<th>ACCIÓN</th>
				<th>STOCK</th>
			</tr>
			<c:forEach var="producto" items="${productos}">

				<!-- LINK PARA CADA PRODUCTO POR SU CAMPO CLAVE: -->

				<c:url var="linkTempE" value="/Controlador_ProductosSwitch">
					<c:param name="instruccion" value="eliminar" />
					<c:param name="hidCodProd" value="${producto.codprod}" />
				</c:url>

				<tr>
					<td>${producto.codprod}</td>
					<td>${producto.seccion}</td>
					<td>${producto.nombreprod}</td>
					<td>${producto.precio}</td>
					<td>${producto.fecha}</td>
					<td>${producto.importado}</td>
					<td>${producto.paisorigen}</td>
					<td><a href="${linkTempE}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form id="botonesCompra">
		<input id="botonCompra" type="submit" name="btnCompraTodo"
			value="Comprar Todo" />
	</form>

	<p id="enlace">
		<br /> <br /> <a
			href="${pageContext.request.contextPath}/Controlador_ProductosSwitch">Volver
			al menú de compras.</a>
	</p>
</body>
</html>