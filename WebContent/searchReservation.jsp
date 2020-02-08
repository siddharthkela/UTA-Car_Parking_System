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
<title>View Specific Reservation</title>
  <a href="ManagerHome.jsp">Back to Home</a>
</head>

<body>
     <div class="logo"><h1>Parking Management Application</a></h1></div>
      <div class="menu_nav">
  </div>

<input name="erMsg" id="erMsg" value="<c:out value='${RerrorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
<tr>
	<td>
	<form action="ReservationController?action=searchReservation" method="post">
	<table style="width: 1200px; ">
	<tr>
    <tr>
    <td> Reservation ID: </td>
    <td> <input name="reservationid" id="reservationid" value="<c:out value='${reservation.reservationid}'/>" type="text" maxlength="16"> </td>
  	<%-- <td> <input name="reservationidError"  value="<c:out value='${errorMsgs.reservationidError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td> --%>
	<td> <input name="reservationidError" id="reservationidError" value="<c:out value='${RerrorMsgs.reservationidError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
</table>
  <input type="submit" value="Submit" id="searchreservation">
	</form>      
</td>
</tr>
</table>
</body>
</html>