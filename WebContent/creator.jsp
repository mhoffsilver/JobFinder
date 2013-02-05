<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dk.aersoe.jobfinder.crud.helpers.*" %> 
<%@ page import="dk.aersoe.jobfinder.model.*" %> 
<%@page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creator receiver</title>
</head>
<body>
<%
JobEntry entry = new JobEntry();
String title = "";
String company = "";
title = request.getParameter("title");
company = request.getParameter("company");
if (title != null && company != null){
	entry.setTitle(title);
	entry.setCompany(company);
	DataWriter writer = new DataWriter();
	writer.writeJobEntry(entry, false);
}
else{
	// TODO add some debugging here
}
%>

<%= title %> and <%=company %> inserted.

</body>
</html>