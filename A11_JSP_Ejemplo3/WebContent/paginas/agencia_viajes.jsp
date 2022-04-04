<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Agencia de viajes</title>
</head>
<body>
	<h1 style="text-align: center">Agencia de viajes</h1>
	<%
		//valor por defecto, por si no se selecciona ciudad o no llego a esta página desde recibe_peticion.jsp
		String ciudad_favorita = "Sevilla";
		
		//Lee la cookie de la petición del navegador
		//Paquete de javaee HttpServletRequest
		Cookie[] lasCookies = request.getCookies();
		//Buscar las preferencias, osea, ciudad favorita.
		//Antes hay que comprobar que hay cookie
		if(lasCookies != null)
			for(Cookie c:lasCookies){
				if("agencia_viajes.ciudadF".equals(c.getName())){
					ciudad_favorita = c.getValue();
					break;
				}
			}
		if(lasCookies != null)
			for(int i=0;i < lasCookies.length; i++){
				if("agencia_viajes.ciudadF".equals(lasCookies[i].getName())){
					System.out.println("***"+lasCookies[i].getValue());
					out.println("***"+lasCookies[i].getValue());
				}
			}
	%>
	
</body>
</html>