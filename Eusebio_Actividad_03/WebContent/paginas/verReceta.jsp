<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#estado{
font-weight:bold

}
</style>
</head>
<body>
<table>
			<tr>
				<td>Titulo de la receta: </td>
				<td>${receta.titulo}</td>
			</tr>
			<tr>
				<td>Tipos de harina: </td>
				<td>${receta.harina}</td>
			</tr>
			<tr>
				<td>Liquidos: </td>
				<td>
				<ul>
				<c:forEach var="liquido" items="${receta.liquidos}">
					<li>${liquido}</li>
				</c:forEach>
				</ul>
				</td>
			</tr>
			<tr>
				<td>Levadura</td>
				<td>${receta.levadura}</td>
			</tr>
			<tr>
				<td>Azucar</td>
				<td>${receta.azucar}</td>
			</tr>
			<tr>
				<td>Sal</td>
				<td>${receta.sal}</td>
			</tr>
			<tr>
				<td>Preparacion:</td>
				<td>${receta.preparacion}</td>
			</tr>
			<tr>
			<form action="${pageContext.request.contextPath}/Controlador" method="get">
			<td><input name="instruccion" type="submit" value="Guardar Receta"></td>
			</form>
			</tr>
			<tr>
			<td id="estado"><c:out value="${estado}"></c:out></td>
			</tr>
		</table>
		<a href="${pageContext.request.contextPath}/index.html">Inicio</a>
</body>
</html>