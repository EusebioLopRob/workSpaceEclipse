<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" import="empleados.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Recorre empleados</title>
</head>
<body>
	<%
	List <Empleado> emp = new ArrayList<Empleado>();
	try{
		request.setCharacterEncoding("UTF-8");
		//Nos conectamos a la BBDD
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		//Compruebo que conecta:
		System.out.println("Conectando con la base de datos...");

		//Conecto con Tomcat con la clase estática java.sql.Connection (no necesito instanciarlo):
		java.sql.Connection miConexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectojsp",
				"usuario", "usuario");

		//Si llega aquí es que se ha conectado bien:
		System.out.println("Éxito al conectar con la base de datos");
		
		//Consulta a la base de datos
		PreparedStatement c_preparada=miConexion.prepareStatement("SELECT NOMBRE,APELLIDO,PUESTO,SALARIO FROM EMPLEADOS;");
		
		//Recogemos los datos en un objeto ResultSet
		ResultSet rs = c_preparada.executeQuery();
		
		//Metemos todos los empleados en la lista
		while(rs.next()){
			emp.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		rs.close();
		miConexion.close();
	} catch (SQLException e1){
		System.out.println("Error en la base de datos: "+e1);
	} catch(Exception e2){
		System.out.println("Error: "+e2);
	}
	session.setAttribute("MisEmpleados", emp);
	
	%>
	<h1>Uso del c:forEach en JSTL</h1>
	<table border="2">
		<tr><td>NOMBRE</td><td>APELLIDO</td><td>PUESTO</td><td>SALARIO</td></tr>
		<c:forEach var="emp" items="${MisEmpleados}">
			<tr><td>${emp.name}</td><td>${emp.surname}</td><td>${emp.post}</td><td>${emp.salary}</td></tr>
		</c:forEach>
	</table>
</body>
</html>