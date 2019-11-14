<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h1>Hello World</h1>
	<p>Current time: <%
		out.println(new Date());
	%></p>
	
	<ul>
		<li>Java</li>
		<li>Python</li>
		<li>.NET</li>
	</ul>
	<button>Click Me</button>
</body>




</html>