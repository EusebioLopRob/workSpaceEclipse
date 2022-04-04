<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
<h1>Registro de usuario</h1>
	<form action="../Controlador_InsertaUsuario" method="post">
		<table>
			<tr>
				<td align="right">Nombre</td>
				<td><input type="text" name="txtNombre" /></td>
			</tr>
			<tr>
				<td align="right">Apellidos</td>
				<td><input type="text" name="txtApellidos" /></td>
			</tr>
			<tr>
				<td align="right">Usuario</td>
				<td><input type="text" name="txtUsuario" /></td>
			</tr>
			<tr>
				<td align="right">Contraseña</td>
				<td><input type="text" name="txtContrasena" /></td>
			</tr>
			<tr>
				<td align="right">Pais</td>
				<td><input type="text" name="txtPais" /></td>
			</tr>		
			<tr>
				<td align="right">Tecnología</td>
				<td><input type="text" name="txtTecnologia" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Crear usuario" /></td>			
			</tr>		
		</table>

	</form>	


</body>
</html>