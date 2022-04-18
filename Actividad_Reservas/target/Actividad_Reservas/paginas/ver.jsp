<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotel ${hotel.nombre }</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/archivo2.css">
</head>
<body>
	<div id="header">
        	<h1 >Reserva.com</h1>
	</div>
	<div id="body">
		<h1>Los datos del Hotel seleccionado son:</h1>
		<label for="cod_hotel" >Codigo de Hotel:</label>
		<input type="text" value="${hotel.cod_hotel }" readonly name="cod_hotel" />
		<br>
		<label for="nombre" >Nombre:</label>
		<input type="text" value="${hotel.nombre }" readonly name="nombre" />
		<br>
		<label for="direccion" >Direccion:</label>
		<input type="text" value="${hotel.direccion }" readonly name="direccion" />
		<br>
		<label for="categoria" >Categoria:</label>
		<input type="text" value="${hotel.categoria }" readonly name="categoria" />
		<br>
		<label for="cod_cadena" >Codigo de Cadena:</label>
		<input type="text" value="${hotel.cod_cadena }" readonly name="cod_cadena" />
		<br>
		<label for="provincia" >Provincia:</label>
		<input type="text" value="${hotel.provincia }" readonly name="provincia" />
		<br>
	</div>
</body>
</html>