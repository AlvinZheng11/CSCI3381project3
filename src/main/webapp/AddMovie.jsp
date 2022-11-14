<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Movie Netflix</title>
</head>
<body>
<%
		String name = (String) request.getAttribute("userName");
	%>
	<%=name%> 
<form>
Add a Movie:
		<br>Week
		<br><input type="text" name="Week"> 
		<br>Category
		<br><input type="text" name="Category"> 
		<br>Rank
		<br><input type="text" name="Rank"> 
		<br>Show Title
		<br><input type="text" name="ShowTitle"> 
		<br>Season Title
		<br><input type="text" name="SeasonTitle"> 
		<br>Hours Viewed
		<br><input type="text" name="HrsViewed"> 
		<br>Weeks Top 10
		<br><input type="text" name="WeeksTop10"> 
		<br><input type="submit" value="Add Movie" name="newMain">
</form>
</body>
</html>