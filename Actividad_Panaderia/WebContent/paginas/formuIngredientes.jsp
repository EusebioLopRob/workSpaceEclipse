<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Controlador" method="get">
		<table>
			<tr>
				<td>Titulo de la receta: </td>
				<td><input type="text" name="titulo"/></td>
			</tr>
			<tr>
				<td>Tipos de harina: </td>
				<td>
					<select  name=harina>
						<option value="Trigo" selected >Trigo </option>
        				<option value="Espelta">Espelta </option>
        				<option value="Centeno">Centeno </option>
					</select>
				</td>
				<td><input type="text" name="harinagramos"/> gramos</td>
			</tr>
			<tr>
				<td>Liquidos: </td>
				<td>
				<label><input type="checkbox" name="liquidos" value="Agua"> Agua <input type="text" name="aguaml"/> ml</label><br>
				<label><input type="checkbox" name="liquidos" value="Aceite"> Aceite <input type="text" name="aceiteml"/> ml</label><br>
				<label><input type="checkbox" name="liquidos" value="Leche"> Leche <input type="text" name="lecheml"/> ml</label><br>
				</td>
			</tr>
			<tr>
				<td>Levadura</td>
				<td><input type="text" name="levaduragramos"/> gramos</td>
			</tr>
			<tr>
				<td>Azucar</td>
				<td><input type="text" name="azucargramos"/> gramos</td>
			</tr>
			<tr>
				<td>Sal</td>
				<td><input type="text" name="salgramos"/> gramos</td>
			</tr>
			<tr>
				<td>Preparacion:</td>
				<td>
					<textarea name="preparacion" rows="10" cols="50"></textarea>
				</td>
			</tr>
			<tr>
			<td><input name="instruccion" type="submit" value="Crear"></td>
			</tr>
		</table>
	</form>
	<a href="${pageContext.request.contextPath}/index.html">Inicio</a>
</body>
</html>