<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Bootstrap CSS -->
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		
		<!-- Custom CSS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/archivo.css">
		
		<title>Hotel ${hotel.nombre }</title>
	</head>
<body>
	<!-- Optional JavaScript; -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
    <h1 class="bg-primary text-white mx-2 my-2 px-1 py-1">Reserva.com</h1>
	<div class="container-fluid mx-4 px-4 py-2 contenedorPrincipal">
		<h2>Datos del Hotel seleccionado:</h2>
		<table class="table mt-4">
			<tr>
				<td><label for="cod_hotel" >Codigo de Hotel</label></td>
				<td><input type="text" value="${hotel.cod_hotel }" readonly name="cod_hotel" /></td>
			</tr>
			<tr>
				<td><label for="nombre" >Nombre</label></td>
				<td><input type="text" value="${hotel.nombre }" readonly name="nombre" /></td>
			</tr>
			<tr>
				<td><label for="direccion" >Direccion</label></td>
				<td><input type="text" value="${hotel.direccion }" readonly name="direccion" /></td>
			</tr>
			<tr>
				<td><label for="categoria" >Categoria</label></td>
				<td><input type="text" value="${hotel.categoria }" readonly name="categoria" /></td>
			</tr>
			<tr>
				<td><label for="cod_cadena" >Codigo de Cadena</label></td>
				<td><input type="text" value="${hotel.cod_cadena }" readonly name="cod_cadena" /></td>
			</tr>
			<tr>
				<td><label for="provincia" >Provincia</label></td>
				<td><input type="text" value="${hotel.provincia }" readonly name="provincia" /></td>
			</tr>
		</table>
	</div>
</body>
</html>