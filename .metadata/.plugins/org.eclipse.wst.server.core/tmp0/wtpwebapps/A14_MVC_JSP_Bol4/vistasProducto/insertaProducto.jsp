<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
	#main {
		text-align: center; 
		color: blue; 
		background-color: skyblue;
	}
	#aux{
		width: 40%; 
		text-align: center; 
		margin: auto;
	}
	#botonInsertar {
		margin-top: 20px; 
		width: 200px;
		height: 40px;
		background-color: blue;
		color: white;
		font-size: 20px;
		font-weight: bold;
		cursor: pointer;
		border-style: solid;
		border-radius: 5px;
	}	
	#botonInsertar:hover {				
		background-color: skyblue;
		color: black;
		border-color: blue;
	}
	a{
		margin-top: 50px;
		margin-left: 20px;
	}
</style>
<title>Insertar Producto</title>
</head>
<body>
	<h2>Insertar Producto</h2>
	<form action="${pageContext.request.contextPath}/Controlador_TodosProductos" method="post">
		<!-- Guardo la información que voy a necesitar -->
		<input type="hidden" name="instruccion" value="insertar"/>
		<table id="main" border="2">
			<tr>
				<td>Código de producto:</td>
				<td><input type="text" name="insCodProd"/></td>
			</tr>
			<tr>
				<td>Sección:</td>
				<td><input type="text" name="insSeccion"/></td>
			</tr>
			<tr>
				<td>Nombre de producto:</td>
				<td><input type="text" name="insNombre"/></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><input type="text" name="insPrecio"/></td>
			</tr>
			<tr>
				<td>fecha:</td>
				<td><input type="text" name="insFecha"/></td>
			</tr>
			<tr>
				<td>Importado:</td>
				<td>
					<table id="aux">
						<tr>
							<td>Sí</td>
							<td><input type="radio" id="si" name="insImportado" value="true"/></td>
						</tr>
						<tr>
							<td>No</td>
							<td><input type="radio" id="no" name="insImportado" value="false" checked/></td>
						</tr>
					</table>
    			</td>
			</tr>
			<tr>
				<td>País de origen:</td>
				<td><input type="text" name="insPais"/></td>
			</tr>
		</table>
		<input type="submit" value="Insertar Producto" id="botonInsertar"/>
	</form>
	<a href="${pageContext.request.contextPath}/Controlador_TodosProductos.java">Volver</a>
</body>
</html>