<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<a href="http://localhost:8079/First_Project/AdminHomePage.jsp">Back to Home</a>
<h1>Search User</h1>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
<tr>
	<td>
	<form action="SearchUser?action=searchCompany" method="post">
	<table style="width: 1200px; ">
	<tr>
	<tr>
  	<td> User name: </td>
 	<td> <input name="user_name" value="<c:out value=''/>" type="text" maxlength="45">  </td>
  	<td> <input name="user_nameError"  value="<c:out value='${bigerror}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
  	
	</tr>
    
</table>
<input type="submit" value="Submit">
	     
		</form>      
</td>
</tr>
</table>
</body>
</html>