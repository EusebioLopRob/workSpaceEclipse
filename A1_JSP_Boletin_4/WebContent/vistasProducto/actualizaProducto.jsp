<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Actualiza producto</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Controlador_ProductosSwitch" method="post">
	<input type="hidden" name="instruccion" value="actualizar"/>
		<table>
			<tr>
				<td align="left" width="200px"><label for="txtCodProd">CodProd:</label>
				</td>
				<td><input type="text" name="txtCodProd"
					value="${producto.codprod}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtSeccion">Sección</label>
				</td>
				<td><select name="txtSeccion">
						<c:choose>
							<c:when test="${producto.seccion == 'Confección'}">
								<option value="Confección" selected="selected">Confección</option>
								<option value="Ferretería">Ferretería</option>
								<option value="Deportes">Deportes</option>
							</c:when>
							<c:when test="${producto.seccion == 'Ferretería'}">
								<option value="Confección">Confección</option>
								<option value="Ferretería" selected="selected">Ferretería</option>
								<option value="Deportes">Deportes</option>
							</c:when>
							<c:when test="${producto.seccion == 'Deportes'}">
								<option value="Confección">Confección</option>
								<option value="Ferretería">Ferretería</option>
								<option value="Deportes" selected="selected">Deportes</option>
							</c:when>
						</c:choose>
				</select></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtNombreArticulo">Nombre
						Artículo:</label></td>
				<td><input type="text" name="txtNombreArticulo"
					value="${producto.nombreprod}" /></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtPrecio">Precio:</label>
				</td>
				<td><input type="text" name="txtPrecio"
					value="${producto.precio}" /></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtFecha">Fecha:</label>
				</td>
				<td><input type="text" name="txtFecha"
					value="${producto.fecha}" /></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtImportado">Importado:</label>
				</td>
				<c:choose>
					<c:when test="${producto.importado}">
						<td><input type="radio" name="txtImportado" value="true"
							checked="checked" />Si <input type="radio" name="txtImportado"
							value="false" />No</td>
					</c:when>
					<c:otherwise>
						<td><input type="radio" name="txtImportado" value="true" />Si
							<input type="radio" name="txtImportado" value="false"
							checked="checked" />No</td>
					</c:otherwise>
				</c:choose>

			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtPais">País:</label>
				</td>
				<td><input type="text" name="txtPais"
					value="${producto.paisorigen}" /></td>
			</tr>

			<tr>
				<td align="left"><input type="submit" name="btnEnviar"
					value="Actualizar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>