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
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
        

        <title>Login de cliente</title>
    </head>
    <body>
    	<h1 class="bg-primary my-2 px-2 py-2 text-white">Alquier de maquinaria de jardineria</h1>
    	<div class="container contenido px-4 py-2">
    		<p>Inicio de sesión</p>
    		<form action="${pageContext.request.contextPath}/ClienteController" 
    			method="post" 
    			id="formulario">
    			<div class="bg-white px-2 py-4">
    				<label for="nombre">Nombre del cliente *</label>
	    			<hr>
	    			<input type="text" name="nombre" id="nombre">
	    			<hr>
	    			<label for="contrasena">Contraseña *</label>
	    			<hr>
	    			<input type="text" name="contrasena" id="contrasena">
	    			<hr>
	    			<p class="text-danger fw-bold">${errorNombre}</p>
	    			<p class="text-danger fw-bold">${errorContrasena}</p>
	    			<p class="text-danger fw-bold">${errorBackend}</p>
	    			<p class="text-success fw-bold">${exito}</p>
    			</div>
    			<input type="submit" class="btn btn-success" name="instruccion" value="Login">
    		</form>
    	</div>
    </body>
</html>
    
    
    
    
    