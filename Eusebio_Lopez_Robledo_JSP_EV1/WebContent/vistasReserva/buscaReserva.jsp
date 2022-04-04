<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Busca Reserva</title>
</head>
<body>
	<h1>Reserva.com</h1>
	<div id="contenido">
		<form action="${pageContext.request.contextPath}/BuscaReservaController" method="post">
		<table>
			<tr><td>Destino/Nombre del alojamiento: *</td></tr>
			<tr><td><input type="text" name="claveNomDes"/></td></tr>
			<tr><td>Fecha de entrada: *</td></tr>
			<tr><td><input type="text" name="fechaEntrada"/></td></tr>
		</table>
		<input type="submit" name="buscar" value="Buscar"/>
		</form>
		<c:when test="${empty param.hoteles}">
			<table>
				<tr>
					<th>Nombre del alojamiento</th>
					<th>Categoría</th>
					<th>Dirección</th>
					<th>Provincia</th>
					<th>Ver más datos</th>
				</tr>
			</table>
			<p>No records found</p>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Nombre del alojamiento</th>
					<th>Categoría</th>
					<th>Dirección</th>
					<th>Provincia</th>
					<th>Ver más datos</th>
				</tr>
				<c:forEach var="hotel" items="${hoteles}">
					<!-- LINK PARA CADA PRODUCTO POR SU CAMPO CLAVE: -->
					<c:url var="linkVer" value="/BuscaReservaController">
						<c:param name="instruccion" value="ver"/>
						<c:param name="codHotel" value="${hotel.codigo}"/>			
					</c:url>
					<tr>
						<td>${hotel.nombre}</td>
						<td>${hotel.categoria}</td>
						<td>${hotel.direccion}</td>
						<td>${hotel.nombre}</td>
						<td>${hotel.provincia}</td>
						<td>
							<a href="${linkVer}">Ver más datos</a><br/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</div>	
</body>
</html>