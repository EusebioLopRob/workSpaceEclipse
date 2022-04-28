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
        
        <!-- Custom Javascript -->
        <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>

        <title>Login de cliente</title>
    </head>
    <body>
    	<h1 class="bg-primary my-2 px-2 py-2 text-white">Alquier de maquinaria de jardineria</h1>
    	<div class="container px-4 py-2">
    		<h3>Lista de clientes</h3>
    		<button id="addBtn" class="btn btn-primary">Añadir Cliente</button>
    		<table class="table table-stripped text-center">
	        	<tr>
	                <th>Código</th>
	                <th>Nombre</th>
	                <th>Contraseña</th>
	                <th>Dirección</th>
	                <th>Acciones</th>
	            </tr>
	            <c:forEach var="cliente" items="${clientes}">
					<c:url var="linkEliminarCliente" value="ClienteController">
						<c:param name="instruccion" value="eliminarCliente"></c:param>
	   					<c:param name="id_barco" value="${cliente.codCliente}"></c:param>
	    			</c:url>	

	                <tr>
	                	<td>${cliente.codCliente}</td>
	                    <td>${cliente.nombre}</td>
	                    <td>${cliente.contrasena }</td>
	                    <td>${cliente.direccion }</td>
	                    <td>
	                    	<!--  
	                       	<a class="bg-danger text-white fw-bold px-2 py-2 rounded text-decoration-none btn-eliminar" 
	                       	  href="${linkEliminarCliente}">Eliminar</a>
	                       	-->
	                       	<button type="button" class="btn btn-primary botonEditar"
	                       		value="${cliente}">
  								Editar
						   	</button>
	                    </td>
	                </tr>
	             </c:forEach>
			</table>
    		<form  action="${pageContext.request.contextPath}/ClienteController" method="post" id="formularioAdd">
			<table class="table table-stripped text-center">
				<tr>
	                <th>Código</th>
	                <th>Nombre</th>
	                <th>Contraseña</th>
	                <th>Dirección</th>
	                <th>Acciones</th>
	            </tr>
	             <tr>
	             	<td><input type="text" name="codClienteAdd"></td>
	                <td><input type="text" name="nombreAdd"></td>
	                <td><input type="text" name="contrasenaAdd"></td>
	                <td><input type="text" name="direccionAdd"></td>
	                <td class="col-3">
	                	<input type="submit" name="instruccion" 
	                		value="Guardar" class="btn btn-success" id="guardar"/>
	                </td>
	             </tr>
			</table>
			</form>
			<form  action="${pageContext.request.contextPath}/ClienteController" method="post" id="formularioEdit">
			<table class="table table-stripped text-center">
				<tr>
	                <th>Código</th>
	                <th>Nombre</th>
	                <th>Contraseña</th>
	                <th>Dirección</th>
	                <th>Acciones</th>
	            </tr>
	             <tr>
	             	<td><input type="text" name="codClienteEdit" id="codClienteEdit" disabled></td>
	                <td><input type="text" name="nombreEdit" id="nombreEdit"></td>
	                <td><input type="text" name="contrasenaEdit" id="contrasenaEdit"></td>
	                <td><input type="text" name="direccionEdit" id="direccionEdit"></td>
	                <td class="col-3">
	                	<input type="submit" name="instruccion" 
	                		value="Actualizar" class="btn btn-success" id="actualizar"/>
	                </td>
	             </tr>
			</table>
			</form>
    	</div>
    </body>
</html>