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

        <title>Ejercicio de barcos</title>
    </head>

    <body>
        <!-- Modal -->
		<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		    	<form action="${pageContext.request.contextPath}/BarcosController" method="post" id="editBarco">
			      <div class="modal-header">
			        <h5 class="modal-title" id="editModallLabel">Editar barco</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      
			      <div class="modal-body">
			      	<table>
			      		<tr>
			      			<td>Nombre</td>
			      			<td><input type="text" name="nombre_editar" id="nombre_editar" required></td>
			      		</tr>
			      		<tr>
			      			<td>Tipo</td>
			      			<td>
			      				<select name="tipo_editar" id="tipo_editar">
			                    	<c:forEach var="tipo" items="${tipos}">
			                    		<option value="${tipo.idTipo}">${tipo.nombreTipo}</option>
			                    	</c:forEach>
			                    </select>
			      			</td>
			      		</tr>
			      		<tr>
			      			<td>Clase</td>
			      			<td>
			      				<select name="clase_editar" id="clase_editar">                  		
			                    	<c:forEach var="clase" items="${clases}">
			                    		<option value="${clase.idClase}">${clase.nombreClase}</option>
			                    	</c:forEach>
			                    </select>
			      			</td>
			      		</tr>
			      		<tr>
			      			<td>Fecha de botado</td>
			      			<td><input type="date" name="fechaBotado_editar" id="fechaBotado_editar" required/></td>
			      		</tr>
			      	</table>   
			      	<input type="hidden" name="id_editar" id="id_editar" required/>    
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
			        <input type="submit" class="btn btn-success" name="instruccion" value="Actualizar">
			      </div>
		      	</form>
		    </div>
		  </div>
		</div>  
        <h1 class="bg-primary my-2 text-white fw-bold py-2 text-center">LISTA DE BARCOS</h1>
        <div class="row px-4 py-4 mb-2">
	        <div class="col-2">
	        	<button id="addBtn" class="btn btn-primary">Añadir barco</button>
	        </div>
	        <div class="col-5">
	        	<button id="addTypeBtn" class="btn btn-primary">Añadir Tipo</button>
	        	<form action="${pageContext.request.contextPath}/BarcosController" method="post" id="addType" class="my-4">
	        		<label for="nombre_tipo">Nombre del tipo</label>
	        		<input type="text" name="nombre_tipo" id="nombre_tipo" required>
	        		<br>
	        		<input type="submit" name="instruccion" value="Guardar Tipo" class="btn btn-success my-4" id="guardarTipo"/>
	        	</form>
	        </div>
	        <div class="col-5">
	        	<button id="addClassBtn" class="btn btn-primary">Añadir Clase</button>
	        	<form action="${pageContext.request.contextPath}/BarcosController" method="post" id="addClass" class="my-4">
	        		<label for="nombre_clase">Nombre de la clase</label>
	        		<input type="text" name="nombre_clase" id="nombre_clase" required>
	        		<br>
	        		<input type="submit" name="instruccion" value="Guardar Clase" class="btn btn-success my-4" id="guardarClase"/>
	        	</form>
	        </div>
		</div>
        <table class="table table-stripped text-center">
	        	<tr class="row">
	                <th class="col-2">Nombre</th>
	                <th class="col-2">Tipo</th>
	                <th class="col-2">Clase</th>
	                <th class="col-3">Fecha de botado</th>
	                <th class="col-3">Acciones</th>
	            </tr>
	            <c:forEach var="barco" items="${barcos}">
					<c:url var="linkEliminarBarco" value="BarcosController">
						<c:param name="instruccion" value="eliminarBarco"></c:param>
	   					<c:param name="id_barco" value="${barco.idBarco}"></c:param>
	    			</c:url>	

	                <tr class="row">
	                	<td class="col-2">${barco.nombre}</td>
	                    <td class="col-2">${barco.tipo.nombreTipo}</td>
	                    <td class="col-2">${barco.clase.nombreClase }</td>
	                    <td class="col-3">${barco.fechaBotado }</td>
	                    <td class="col-3">
	                       	<a class="bg-danger text-white fw-bold px-2 py-2 rounded text-decoration-none btn-eliminar" 
	                       	  href="${linkEliminarBarco}">Eliminar</a>
	                       	<button type="button" class="btn btn-primary botonEditar" 
	                       		data-bs-toggle="modal" data-bs-target="#editModal"
	                       		value="${barco}">
  								Editar
						   	</button>
	                    </td>
	                </tr>
	             </c:forEach>
		</table>
		<form  action="${pageContext.request.contextPath}/BarcosController" method="post" id="formulario">
			<table class="table table-stripped text-center">
				<tr class="row">
	             	<th class="col-2">Nombre</th>
	                <th class="col-2">Tipo</th>
	                <th class="col-2">Clase</th>
	                <th class="col-3">Fecha de botado</th>
	                <th class="col-3">Acción</th>
	             </tr>
	             <tr class="row">
	             	<td class="col-2"><input type="text" name="nombre" required></td>
	                <td class="col-2">
	                	<select name="tipo">
                    		<c:forEach var="tipo" items="${tipos}">
                    			<option value="${tipo.idTipo}">${tipo.nombreTipo}</option>
                    	    </c:forEach>
                    	</select>
	                </td>
	                <td class="col-2">
	                	<select name="clase">                    		
                    		<c:forEach var="clase" items="${clases}">
                    			<option value="${clase.idClase}">${clase.nombreClase}</option>
                    	    </c:forEach>
                    	</select>
                    </td>
	                <td class="col-3"><input type="date" name="fechaBotado" required/></td>
	                <td class="col-3"><input type="submit" name="instruccion" value="Guardar" class="btn btn-success rounded" id="guardar"/></td>
	             </tr>
			</table>
		</form>
    </body>

</html>