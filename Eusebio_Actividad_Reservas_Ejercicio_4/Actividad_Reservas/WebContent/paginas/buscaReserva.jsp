<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
		
		<title>Busqueda de Hotel</title>
	</head>
<body>
	<!-- Optional JavaScript; -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
	
    <h1 class="bg-primary text-white mx-2 my-2 px-1 py-1">Reserva.com</h1>
	
	<div class="container-fluid mx-4 px-4 py-2 contenedorPrincipal">
        <h5 class="fw-bold">Buscar</h5>
        <div id="formulario">
            <form action="BuscaReservaController">
                <div class="w-25 bg-white">
                    <label for="nombre" class="pt-3 pb-1 px-2">Destino/Nombre del alojamiento *</label>
                    <hr>
                    <div class="form-control w-75 border-0">
                    	<input type="text" id="nombre" class="form-control" name="nombre" class="w-75"/>
                    </div>
                    <hr>
                    <p class="text-danger fw-bold pt-1 pb-1 px-2"><c:out value="${ErrorNombre}"></c:out></p>
                    <hr>
                    <label for="fecha"class="pt-1 pb-1 px-2">Fecha de entrada *</label>
                    <hr>
                    <div class="form-control w-75 border-0">
                    	<input type="date" id="fecha" name="fecha" />
                    </div>
                    <hr>
                    <p class="text-danger fw-bold pt-1 pb-4 px-2"><c:out value="${ErrorFecha}"></c:out></p>
                </div>
                <input type="submit" name="instruccion" value="Buscar" class="btn-primary rounded"/>
            </form>
        </div>

        <div id="resultado">
            <table class="table table-stripped bg-white mt-2">
                <tr>
                    <th>Nombre del alojamiento</th>
                    <th>Categoria</th>
                    <th>Direccion</th>
                    <th>Provincia</th>
                    <th>Ver mas datos</th>
                </tr>
                <c:choose>
                <c:when test="${hoteles==null || hoteles.isEmpty()}">
                <tr>
                	<td colspan="5">No records Found</td>
                <tr>
                </c:when>
                <c:otherwise>
                <c:forEach var="hotel" items="${hoteles}">
				<c:url var="linkHotel" value="BuscaReservaController">
					<c:param name="instruccion" value="VermasDatos"></c:param>
   					<c:param name="cod_hotel" value="${hotel.cod_hotel }"></c:param>
    			</c:url>	

                <tr>
                    <td>${hotel.nombre}</td>
                    <td>${hotel.categoria }</td>
                    <td>${hotel.direccion }</td>
                    <td>${hotel.provincia }</td>
                    <td>
                       <a class="bg-primary text-white fw-bold px-2 py-2 rounded text-decoration-none" href="${linkHotel }">Ver mas Datos</a>
                    </td>
                </tr>
                </c:forEach>
                </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
</body>
</html>