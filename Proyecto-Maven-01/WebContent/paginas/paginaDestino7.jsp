<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="clase.com.negocio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Request en formularios con validación destino</title>
</head>
<body>
	<h1>Ejemplo 6: Esta es la página de destino</h1>
	<h2>Aquí se reciben los datos</h2>
	<p>Tus datos</p>

	<%
		request.setCharacterEncoding("UTF-8");
		String nombre = request.getParameter("nombre");
		String tInicial = request.getParameter("tInicial");
		String tFinal = request.getParameter("tFinal");
		String distancia = request.getParameter("distancia");
		Double tTotal = 0.0;
		Double velocidad = 0.0;
		String errMsg = "";
		try{
			if(nombre.isEmpty() || tInicial.isEmpty() || tFinal.isEmpty() || distancia.isEmpty()){
				throw new CampoVacioException("Faltan campos por rellenar");
			}
			Double tIni = Double.parseDouble(tInicial);
			Double tFin = Double.parseDouble(tFinal);
			Double dist = Double.parseDouble(distancia);
			Calculo c = new Calculo(tIni, tFin, dist);
			tTotal = c.tiempoTotal();
			velocidad = c.velocidad();
		}catch(CampoVacioException e1){
			errMsg = e1.getMessage();
		}catch(ValorNoNumericoException e2){
			errMsg = "Debe introducir valores numéricos en los campos de tiempo y distancia";
		}catch(Exception e3){
			errMsg = e3.getMessage();
		}
		
	%>
	<table border="2">
		<tr>
			<td align="right">Tu tiempo total fue:</td>
			<td><%= tTotal.toString()%></td>
		</tr>
		<tr>
			<td align="right">Y tu velocidad:</td>
			<td><%= velocidad.toString() %></td>
		</tr>
		<p><%="<font color=red><p>"+errMsg+"</p>"%></p>
	</table>
	<a href="./ejemplo7.jsp">volver</a>
</body>
</html>