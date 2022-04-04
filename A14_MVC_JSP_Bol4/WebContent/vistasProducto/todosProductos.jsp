<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link href="${pageContext.request.contextPath}/resources/css/tablaProd.css" rel="stylesheet"/>

<title>Todos los productos</title>
</head>
<body>
	<h1>Todos los productos</h1>
	<table border="2">
		<tr>
			<th>Código de producto</th>
			<th>Sección</th>
			<th>Nombre de Producto</th>
			<th>Precio</th>
			<th>Fecha</th>
			<th>Importado</th>
			<th>Pais de Origen</th>
			<th>Acción Admin</th>
			<th>Compra</th>
		</tr>
		<c:forEach var="producto" items="${datos_productos}">
			
			<!-- LINKS PARA CADA PRODUCTO POR SU CAMPO CLAVE -->
			<c:url var="linkTempAct" value="/Controlador_ProductosSwitch">
				<c:param name="instruccion" value="cargaActualiza"/>
				<c:param name="hidCodProd" value="${producto.codprod}"/>			
			</c:url>
			
			<c:url var="linkTempElim" value="/Controlador_ProductosSwitch">
				<c:param name="instruccion" value="eliminar"/>
				<c:param name="hidCodProd" value="${producto.codprod}"/>			
			</c:url>
			
			<c:url var="linkTempCarr" value="/Controlador_ProductosSwitch">
				<c:param name="instruccion" value="carrito"/>
				<c:param name="hidCodProd" value="${producto.codprod}"/>			
			</c:url>
			
			<c:url var="linkTempComp" value="/Controlador_ProductosSwitch">
				<c:param name="instruccion" value="compra"/>
				<c:param name="hidCodProd" value="${producto.codprod}"/>			
			</c:url>
			
			<tr>
				<td>${producto.getCodprod()}</td>
				<td>${producto.getSeccion()}</td>
				<td>${producto.getNombreprod()}</td>
				<td>${producto.getPrecio()}</td>
				<td>${producto.getFecha().toString()}</td>
				<c:choose>
					<c:when test="${producto.getImportado()}">
						<td>Sí</td>
					</c:when>
					<c:otherwise>
						<td>No</td>
					</c:otherwise>
				</c:choose>				
				<td>${producto.getPaisorigen()}</td>
				<td>
					<p><a href="${linkTempAct}">Actualizar</a></p>
					<p><a href="${linkTempElim}">Eliminar</a></p>
				</td>
				<td>
					<p><a href="${linkTempCarr}">Añadir al carrito</a></p>
					<p><a href="${linkTempComp}">Compra directa</a></p>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<input type="button" value="Insertar Producto" name="insert" onclick="window.location.href='vistasProducto/insertaProducto.jsp'"/>
	<div id="volver">
		<a href="${pageContext.request.contextPath}/index.html">Volver al index</a>
	</div>
</body>
</html>