<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busqueda de Hotel</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/archivo.css">
</head>
<body>
	<div id="header">
        	<h1 >Reserva.com</h1>
	</div>
	<div id="body">
        <p>Buscar</p>
        <div id="formulario">
            <form action="BuscaReservaController">
                <div id="valores">
                    <label for="nombre" >Destino/Nombre del alojamiento</label>
                    <hr>
                    <input type="text" id="nombre" class="form-control" name="nombre" />
                    <hr>
                    <p class="error"><c:out value="${ErrorNombre}"></c:out></p>
                    <hr>
                    <label for="fecha" >Fecha de entrada</label>
                    <hr>
                    <input type="date" id="fecha" name="fecha" />
                    <hr>
                    <p class="error"><c:out value="${ErrorFecha}"></c:out></p>
                </div>
                        <input type="submit" name="instruccion" value="Buscar"/>
                    
                
            </form>
        </div>

        <div id="resultado">
            <table>
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
                       <a href="${linkHotel }">Ver mas Datos</a>
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