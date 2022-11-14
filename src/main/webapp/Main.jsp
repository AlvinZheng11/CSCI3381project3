<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NetFlix</title>
<style>
body {
    background-color: darkgray;
}

div {
  background-color: lightgrey;
  width: 50%;
  padding: 50px;
  border: 3px solid green;
  margin: auto;
  text-align: center;
}
</style>
</head>
<body>
<%
		String name = (String) request.getAttribute("userName");
	%>
	<h1 style="color:black;font-size:50px;">Welcome <%=name%> </h1>      
	 
<form action="/CSCI3381project3/Servlet" method="get">
	    <input type="hidden" value=<%=name%> name="userName">
	    
	    <div>
		<%String selectionText = (String) request.getAttribute("dropDownOptions");%>
		
		Please select a Movie:<br><%=selectionText%><br> 
		<input type="submit" value="Select Movie" name="selectMovie">
		<br>
		<input type="submit" value="Add a Movie" name="addingMovie">
		<br>
		<input type="submit" value="Logout" name="logout">
		</div>
		
</form>
</body>
</html>