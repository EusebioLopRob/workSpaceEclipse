<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%!
		String titulo="Segunda página JSP";
		Integer contador=0;
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><%=titulo %></title>

</head>

<body>
	<h1><%=titulo %></h1>
	<hr />
	<p>
		<%
			contador++;
			out.println("<font color=red><b>Número de veces que se ha entrado a esta página desde que se inició el sevidor: "+contador);
		%>
		
	</p>
</body>

</html>