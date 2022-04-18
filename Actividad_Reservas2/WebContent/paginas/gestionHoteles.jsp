<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotel ${hotel.nombre }</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/archivo2.css">
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>
<body>
	<div id="header">
        	<h1 >Reserva.com</h1>
	</div>
	<div id="body">
	<p>Gestion de Hotel</p>
		 <div id="resultado">
            <table>
                <tr>
                	<th>Codigo del Hotel</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Provincia</th>
                    <th>Nombre de la cadena</th>
                    <th>Categoria</th>
                    <th>Eliminar</th>
                </tr>
                <c:forEach var="hotel" items="${hoteles}">
				<c:url var="linkHotel" value="GestionHotelController">
					<c:param name="instruccion" value="eliminarHotel"></c:param>
   					<c:param name="cod_hotel" value="${hotel.cod_hotel }"></c:param>
    			</c:url>	

                <tr>
                	<td>${hotel.cod_hotel}</td>
                    <td>${hotel.nombre}</td>
                    <td>${hotel.direccion }</td>
                    <td>${hotel.provincia }</td>
                    <td>${hotel.getNombreCadena() }</td>
                    <td>${hotel.categoria }</td>
                    <td>
                       <a href="${linkHotel }">Eliminar</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        
    	<!--<button id="anadir" value="anadir" onclick="window.location.href = 'GestionHotelController?instruccion=anadir'">+ Añadir nuevo hotel</button>
    	-->
    	<button id="anadir"  >+ Añadir nuevo hotel</button>
    	<button id="guardar" >Guardar</button>
    	
    	<div id="error">
    		<c:out value="${error }"></c:out>
    	</div>
    	<div id="exito">
    		<c:out value="${exito }"></c:out>
    	</div>
<%--     <c:choose> --%>
<%-- 		<c:when test="${anadir=='anadir'}"> --%>
	

    	<div id="tablaNuevoHotel" style="display:none">
    	<form  action="${pageContext.request.contextPath}/GestionHotelController" method="post">
    	<table>
                	<tr>
                		<th>Codigo del Hotel</th>
                    	<th>Nombre</th>
                    	<th>Direccion</th>
                    	<th>Provincia</th>
                    	<th>Nombre de la cadena</th>
                    	<th>Categoria</th>
                	</tr>
                	<tr>
                		<td><input type="text" name="codigo" ></td>
                    	<td><input type="text" name="nombre" ></td>
                    	<td><input type="text" name="direccion"></td>
                    	<td><input type="text" name="provincia"></td>
                    	<td>
                    		<select name="nombreCadena" >
                    			<option>Selecciona</option>
                    			<c:forEach var="nombre" items="${nombreCadenas}">
                    			<option value="${nombre}">${nombre}</option>
                    	    	</c:forEach>
                    
                    		</select>
                    	</td>
                    	<td><input type="text" name="categoria"></td>
                	</tr>
                <input type="hidden" name="instruccion" value="insertarHotel">
    	</table>
        </form>  
    	</div>
    	
<%--     	</c:when> --%>
<%--     	</c:choose> --%>
    	
 
	</div>
	<div id="footer">
	<p>!Ahorra tiempor y dinero!</p>
	<p>Registrate y te enviaremos las mejores ofertas para ti</p>
	</div>
</body>
</html>