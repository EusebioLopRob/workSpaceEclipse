<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="clase.com.negocio.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Confirmacion Login</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	try{
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		if (usuario.isEmpty()||contrasena.isEmpty()){
			throw new CampoVacioException("Hay campos vacíos");
		}
		//Nos conectamos a la BBDD
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		//Compruebo que conecta:
		out.println("<p>Conectando con la base de datos...</p>");
		
		//Conecto con Tomcat con la clase estática java.sql.Connection (no necesito instanciarlo):
		java.sql.Connection 				
		miConexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectojsp","usuario","usuario");
		
		//Si llega aquí es que se ha conectado bien:
		out.println("<p>Éxito al conectar con la base de datos</p>");
		
		PreparedStatement c_preparada=miConexion.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO=? AND CONTRASENA=?");
		c_preparada.setString(1, usuario);
		c_preparada.setString(2, contrasena);
		ResultSet resultado = c_preparada.executeQuery();
		
		if(resultado.next()){
			out.print("Usuario conectado");
		} else {
			out.print("Credenciales incorrectas");
		}
			
		
	}catch(CampoVacioException e1){
		out.print("<p> <font color=red>"+e1.getMessage()+"</font></p>");
	}catch(NullPointerException e2){
		out.print("<p> <font color=red>No estas en el sitio adecuado</font></p>");		
	}catch(NumberFormatException e3){
		out.print("<p> <font color=red>Formato erróneo</font></p>");	
	}catch(SQLException e4){
		out.print("<p> <font color=red>Error en base de datos</font></p>");
		out.print(e4.getMessage());
	}catch(Exception e5){
		out.print("<p> <font color=red>Fallo desconocido</font></p>");
	}
	%>
</body>
</html>