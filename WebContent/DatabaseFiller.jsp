<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dk.aersoe.jobfinder.crud.helpers.*" %> 
<%@ page import="dk.aersoe.jobfinder.model.*" %> 
<%@ page import="dk.aersoe.jobfinder.workers.*" %>
<%@page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Filler</title>
</head>
<body>
<%
String result = "Nothing Inserted";
String function = "";
String company = "";
function = request.getParameter("function");
if (function != null && (!function.equals("") || !function.equals("null"))){
	UrlBasedFetcher fetcher = new UrlBasedFetcher();
	String fetcherUrl = "http://www.jobindex.dk/cgi/jobsearch.cgi?q=java&regionid=20&regionid=21&xml=true&output=rss";
	Set<JobEntry> entries = fetcher.getEntries(fetcherUrl);
	BatchLoader loader = new BatchLoader();
	int entryNumber = loader.storeSet(entries);
	if (entryNumber > 0){
		result = "Number of inserted records: " + entryNumber;
	}
}
%>

<h1><%=result %></h1>
</body>
</html>