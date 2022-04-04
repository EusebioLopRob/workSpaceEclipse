<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<h1>LOGIN</h1>

	<form action="../Controlador_LoginUsuario" method="post">
		<table>
			<tr>
				<td align="right">Usuario</td>
				<td><input type="text" name="txtUsuario" /></td>
			</tr>
			<tr>
				<td align="right">Contraseña</td>
				<td><input type="password" name="txtContrasena" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Enviar"/></td>
			</tr>
			
		</table>

	</form>


</body>
</html>