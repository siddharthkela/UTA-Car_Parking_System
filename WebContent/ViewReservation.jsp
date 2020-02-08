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
<title>Insert title here</title>
</head>
<a href="ManagerHome.jsp">Back to Home</a>
<body>

<div class="header_resize">
      <div class="logo"><h1>Parking Management Application</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

     <div class="mainbar"><div class="submb"></div></div>
      
      
       <table class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="width: 105px; ">Reservation ID</th>
				<th class="myTableHead" style="width: 74px; ">Username</th> 
				<th class="myTableHead" style="width: 130px; ">Parking Area</th>
				<th class="myTableHead" style="width: 63px; ">Parking Number</th> 
				<th class="myTableHead" style="width: 63px; ">Start Time Hour</th>
				<th class="myTableHead" style="width: 63px; ">Start Time Minutes</th> 
				<th class="myTableHead" style="width: 63px; ">End Time Hour</th> 
				<th class="myTableHead" style="width: 63px; ">End Time Minutes</th>
				<th class="myTableHead" style="width: 63px; ">Cost</th>
			</tr>

 		<c:forEach items="${RESERVATION}" var="item">
			<tr class="myTableRow">
			<td class="myTableCell" style="width: 105px; "><c:out value="${item.reservationid}" /></td>
			<td class="myTableCell" style="width: 74px; "><c:out value="${item.username}" /></td>
			<td class="myTableCell" style="width: 130px; "><c:out value="${item.parking_Area}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.parking_Number}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.starttime_hour}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.starttime_minutes}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.endtime_hour}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.endtime_minutes}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.cost}" /></td>
			</tr>
		</c:forEach>
 </table>

</body>
</html>