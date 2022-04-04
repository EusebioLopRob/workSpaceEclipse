<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<h1>ELIMINAR USUARIO POR ID</h1>

	<form action="../Controlador_EliminaUsuario" method="post">
		<table>
			<tr>
				<td align="right">ID Usuario:</td>
				<td><input type="number" name="txtIdUsuario" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Eliminar"/></td>
			</tr>
			
		</table>

	</form>


</body>
</html>