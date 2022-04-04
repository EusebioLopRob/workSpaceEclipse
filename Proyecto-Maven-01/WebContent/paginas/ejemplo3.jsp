<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%!
		int hora = LocalDateTime.now().getHour();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<p>La fecha actual es: <%=LocalDate.now() %>, y son las <%=hora %> horas </p>
	<%
		if(hora>=6 && hora<12)
			out.println("<h2>Buenos días</h2>");
		else if (hora>=12 && hora<21)
			out.println("<h2>Buenas tardes</h2>");
		else
			out.println("<h2>Buenas noches</h2>");
	%>
</body>
</html>