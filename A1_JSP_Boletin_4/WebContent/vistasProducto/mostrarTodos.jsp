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
<title>MOSTRAR TODOS</title>
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
				<th>COMPRAS</th>
			</tr>
			<c:forEach var="producto" items="${productos}">
			
			<!-- LINK PARA CADA PRODUCTO POR SU CAMPO CLAVE: -->
			<c:url var="linkTempA" value="/Controlador_ProductosSwitch">
				<c:param name="instruccion" value="cargaActualiza"/>
				<c:param name="hidCodProd" value="${producto.codprod}"/>			
			</c:url>
			
			<c:url var="linkTempE" value="/Controlador_ProductosSwitch">
				<c:param name="instruccion" value="eliminar"/>
				<c:param name="hidCodProd" value="${producto.codprod}"/>			
			</c:url>
			
				<tr>
					<td>${producto.codprod}</td>
					<td>${producto.seccion}</td>
					<td>${producto.nombreprod}</td>
					<td>${producto.precio}</td>
					<td>${producto.fecha}</td>
					<td>${producto.importado}</td>
					<td>${producto.paisorigen}</td>
					<td>
					 	<!--  <a href = "<c:url value = "/Controlador_ProductosSwitch"> <c:param name = "instruccion" value = "eliminar"/> <c:param name = "hidCodProd" value = "${producto.codprod}"/> </c:url>">Elimina</a><br/>-->
						<!--  <a href = "<c:url value = "/Controlador_ProductosSwitch"> <c:param name = "instruccion" value = "actualizar"/> <c:param name = "hidCodProd" value = "${producto.codprod}"/> </c:url>">Actualizar</a>-->
						<a href="${linkTempA}">Actualizar</a><br/>
						<a href="${linkTempE}">Eliminar</a>
					</td>
					<td></td>
					<td>
						<input type="number" min="0" max="10"/>
						<button>Añadir al carrito</button>						
						<button>Comprar ya</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="boton">
		<form
			action="${pageContext.request.contextPath}/vistasProducto/insertaProducto.jsp">
			<input id="botonInserta" type="submit" name="btnInsertaProducto"
				value="Insertar Registro" />
		</form>
		<form
			action="${pageContext.request.contextPath}/vistasProducto/listaCompra.jsp">
			<input id="botonCarro" type="submit" name="btnCarro"
				value="Ir al Carrito" />
		</form>
	</div>

	<p id="enlace">
		<br /> <br /> <a
			href="${pageContext.request.contextPath}/index.html">Volver al
			menú.</a>
	</p>
</body>
</html>