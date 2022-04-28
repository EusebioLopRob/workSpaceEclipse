<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
            
        <!-- Optional JavaScript; -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
            
        <title>Indice</title>
        
    </head>
    <body>
	<h1 class="text-danger fw-bold">ERROR</h1>
		<h3 class="text-danger">${errorBackend}</h3>
		<h3 class="text-danger">${errorCodCliente}</h3>
		<h3 class="text-danger">${errorNombre}</h3>
		<h3 class="text-danger">${errorContrasena}</h3>
		<h3 class="text-danger">${errorDireccion}</h3>
    	<c:url var="linkListarClientes" value="ClienteController">
			<c:param name="instruccion" value="listar"></c:param>
	    </c:url>
    	<a href="${linkListarClientes}">Volver a gestión de clientes</a>
   
	</body>
</html>