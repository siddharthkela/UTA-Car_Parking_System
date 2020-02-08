<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<form action="LogoutController" method="post">
<input type="submit" id="logout" value="Logout">
</form>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<a href="ManagerHome.jsp">Back to Home</a>
<body>

<table>
  <tr>
   <td>
<form name="UnrevokeForm" action="ReservationController?action=delete" method="post">    <table style="width: 1200px; ">
    <tr>
    <td> Reservation ID (*): </td>
    <td> <input name="reservationid" id="reservationid" value="<c:out value='${revoke.username}'/>" type="text" maxlength="16"> </td>
  	
    </tr>

    
    
     </table>
    <input name="action" value="delete" type="hidden">
    <input type="submit" value="Delete Reservation" name="action" value="unrevoke" id="deleteButton">
    &nbsp;
    &nbsp;
    </form>
    <br>
    
    
    
    
</table>


</body>
</html>