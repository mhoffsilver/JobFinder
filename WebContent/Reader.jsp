<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dk.aersoe.jobfinder.crud.helpers.*" %> 
<%@ page import="dk.aersoe.jobfinder.model.*" %>
<%@ page import="java.util.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ReaderPage</title>
</head>
<body>
<%
String id = "";
id = request.getParameter("id");
DataReader reader = new DataReader();
JobEntry entry = null;
if (id != null && (!id.equals("") || !id.equals("null"))){
	entry = reader.getEntry(Integer.parseInt(id));
	out.print("We received id: " + id + "<br />");
}
else{
	// We have no idea of whet the first record is - therefore we get all and use the first. FOR TEST PURPOSES ONLY	
	Set<JobEntry> results = reader.getEntries();
	Iterator<JobEntry> it = results.iterator();
	if (it.hasNext()){
		entry = it.next();
	}
}
// NullGuard the otherway around - temporary fix!!!
if (entry == null){
	entry = new JobEntry();
}
%>
ID:<br /> <%=entry.getId() %><br /><br /> 
Foreign Date:<br /> <%=entry.getForeignDate() %><br /><br /> 
Category:<br /> <%=entry.getCategory() %><br /> <br />
Company:<br /> <%=entry.getCompany() %><br /> <br />
Title:<br /> <%=entry.getTitle() %><br /> <br />
description:<br /><div><%=entry.getDescription() %></div>

</body>
</html>