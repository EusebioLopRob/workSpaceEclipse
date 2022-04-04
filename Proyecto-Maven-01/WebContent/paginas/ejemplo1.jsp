<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Primer ejemplo con JSP</title>
</head>
<body>
	<h1>Expresiones, Scriplets y declaraciones en JSP</h1>
	<%--EXPRESIÓN EN JSP: El resultado de la expresión será un String que pasará a formar parte de la página HTML --%>
	<p>Expresión: la resta de 8 - 2 es <%=8-2 %></p>
	<p>Expresión: Convertir a mayúsculas:<%=new String("Hoy está nublado").toUpperCase() %></p>
	<p>Expresión: 10 es mayor que 100? <%=10>100 %></p>
	<p>Ejemplo de Scriptlet: Fecha <% out.println(LocalDate.now()); %></p>
	<p>Ejemplo de Scriptlet: <% for(int i=1;i<=10;i++){
									if(i==1){
										out.println("<p>Mensaje repetido "+i+" vez </p>"); 
									}else{
										out.println("<p>Mensaje repetido "+i+" veces </p>"); 
									}
								}%></p>
	}
	<p>DECLARACIÓN:</p>
	<%--Variables declaradas con el signo de admiración son de ámbito global mientras el servidor esté arrancado --%>
	<%!
	//Variable global
	private int resultado = 10; 
	
	//Método global
	public int sumar(int num1, int num2){
		return num1 + num2;
	}
	%>
	<p>Resultado de sumar 9 + 10: <%=sumar(9,10) %></p>
	<p>
	<a></a>
	</p>
	
</body>
</html>