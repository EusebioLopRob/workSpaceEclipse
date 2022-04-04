<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insertar Producto</title>
</head>
<body>
	<h1>Registro de producto</h1>
	
	

	<form action="${pageContext.request.contextPath}/Controlador_ProductosSwitch" method="post">
	
	<!-- OJO!! este campo hidden sirve para hacer el switch en el controlador definitivo -->
	<input type="hidden" name="instruccion" value="insertar"/>
	
		<table>
			<tr>
				<td align="left" width="200px"><label for="txtCodProd">CodProd:</label>
				</td>
				<td><input type="text" name="txtCodProd" /></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtSeccion">Sección:</label>
				</td>
				<td><select name="txtSeccion">
						<option value="" selected="selected">-selecciona-</option>
						<option value="Confección">Confección</option>
						<option value="Ferretería">Ferretería</option>
						<option value="Deportes">Deportes</option>
				</select></td>
			</tr>

			<tr>
				<td align="left" width="200px"><label for="txtNombreArticulo">Nombre
						Artículo:</label></td>
				<td><input type="text" name="txtNombreArticulo" /></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtPrecio">Precio:</label>
				</td>
				<td><input type="text" name="txtPrecio" /></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtFecha">Fecha:</label>
				</td>
				<td><input type="text" name="txtFecha" /></td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtImportado">Importado:</label>
				</td>
				<td><input type="radio" name="txtImportado" value="true" />Si <input
					type="radio" name="txtImportado" value="flase" />No</td>
			</tr>
			<tr>
				<td align="left" width="200px"><label for="txtPais">País:</label>
				</td>
				<td><input type="text" name="txtPais" /></td>
			</tr>

			<tr>
				<td align="left"><input type="submit" name="btnEnviar"
					value="Enviar" /></td>
				<td align="left"><input type="reset" value="Restablecer" /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="${pageContext.request.contextPath}/index.html">Volver al menú.</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/Controlador_ProductosSwitch">Volver a productos.</a>
	</p>

</body>
</html>