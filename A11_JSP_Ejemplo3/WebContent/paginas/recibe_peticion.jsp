<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ejemplo Select recepcion</title>
</head>
<body>
	<%
		//Leemos los datos del formulario
		String ciudad_favorita = request.getParameter("ciudad_favorita");
		
		//Creamos la cookie: clase Cookie en el paquete java.servlet.http Cookie(nombre,valor)
		Cookie c = new Cookie("agencia_viajes_ciudadF", ciudad_favorita);
		
		//establecemos la vida de la Cookie (segundos)
		c.setMaxAge(365*24*60*60); //1 año de vida, con dos pelotas
		
		//enviar al usuario agrega la cookie a la respuesta del servidor
		response.addCookie(c);
	%>
	<p>Gracias por indicar sus preferencias</p>
	<a href="agencia_viajes.jsp">Ir a la agencia de viajes</a>
</body>
</html>