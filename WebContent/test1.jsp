<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="dk.aersoe.jobfinder.crud.helpers.*" %> 
<%@ page import="dk.aersoe.jobfinder.model.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testfile to test if everything works as expected</title>
</head>
<body>
Starting <br />
<%
DataReader reader = new DataReader();
JobEntry entry = reader.getEntry(1);
%>

Extrated <%=entry.getTitle() %> and <%=entry.getCompany() %> from the database <br />
Finished
</body>
</html>