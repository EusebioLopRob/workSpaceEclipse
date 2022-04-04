<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="clase.com.negocio.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Recoge Datos</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		try{
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String usuario = request.getParameter("usuario");
			String contra = request.getParameter("contra");
			String pais = request.getParameter("pais");
			String tecno = request.getParameter("tecnologias");
			if (nombre.isEmpty()||apellidos.isEmpty()||usuario.isEmpty()||contra.isEmpty()||pais.isEmpty()){
				throw new CampoVacioException("Hay campos vacíos");
			}
			
			//Nos conectamos a la BBDD
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			//Compruebo que conecta:
			out.println("<p>antes de conectarse</p>");
			
			//Conecto con Tomcat con la clase estática java.sql.Connection (no necesito instanciarlo):
			java.sql.Connection 				
			miConexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectojsp","usuario","usuario");
			
			//Si llega aquí es que se ha conectado bien:
			out.println("<p>se conectó con éxito</p>");
			
			PreparedStatement c_preparada=miConexion.prepareStatement("INSERT INTO USUARIOS (nombre,apellido,usuario,contrasena,pais,tecnologia)"
					+"VALUES (?,?,?,?,?,?)");
			c_preparada.setString(1, nombre);
			c_preparada.setString(2, apellidos);
			c_preparada.setString(3, usuario);
			c_preparada.setString(4, contra);
			c_preparada.setString(5, pais);
			c_preparada.setString(6, tecno);
			c_preparada.executeUpdate();
			
			//Si llega aquí es que se ha registrado bien:
			out.println("<p>Se ha registrado con éxito</p>");
			
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