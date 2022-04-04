<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar</title>
</head>
<body>
	
	<h1>ACTUALIZAR USUARIO</h1>

	<form action="${pageContext.request.contextPath}/Controlador_ActualizaUsuario" method="get">
		<table>
			<tr>
				<td align="right">Usuario</td>
				<td><input type="text" name="conUsuario" value=${ datos_usuario.usuario}></input></td>
			</tr>
			<tr>
				<td align="right">Contraseña</td>
				<td><input type="password" name="conContrasena" value=${ datos_usuario.contrasena}></input></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Consultar" name="Consultar"/></td>
			</tr>
			<tr></tr>
			<tr>
				<td align="right">ID:</td>
				<td><input type="text" name="txtIdUsuario" readonly value=${ datos_usuario.id_usuario}></td>
			</tr>
			<tr>
				<td align="right">Nombre:</td>
				<td><input type="text" name="txtNombre" value=${ datos_usuario.nombre}></input></td>
			</tr>
			<tr>
				<td align="right">Apellido:</td>
				<td><input type="text" name="txtApellido" value=${ datos_usuario.apellidos}></input></td>
			</tr>
			<tr>
				<td align="right">Usuario:</td>
				<td><input type="text" name="txtUsuario" value=${ datos_usuario.usuario}></input></td>
			</tr>
			<tr>
				<td align="right">Contraseña:</td>
				<td><input type="text" name="txtContrasena" value=${ datos_usuario.contrasena}></input></td>
			</tr>
			<tr>
				<td align="right">Pais:</td>
				<td><input type="text" name="txtPais" value=${ datos_usuario.pais}></input></td>
			</tr>
			<tr>
				<td align="right">Tecnología:</td>
				<td><input type="text" name="txtTecnologia" value=${ datos_usuario.tecnologia}></input></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Actualizar" name="Actualizar"/></td>
			</tr>
		</table>
		
	</form>


</body>
</html>