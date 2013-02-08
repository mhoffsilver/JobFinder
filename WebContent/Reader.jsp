<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dk.aersoe.jobfinder.crud.helpers.*" %> 
<%@ page import="dk.aersoe.jobfinder.model.*" %>
<%@ page import="java.util.*" %>   
<!DOCTYPE html>
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
Title:<br /> <a href="<%=entry.getUrl() %>" ><%=entry.getTitle() %></a><br /> <br />

</body>
</html>