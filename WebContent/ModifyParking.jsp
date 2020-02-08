<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<a href="http://localhost:8079/First_Project/ManagerHome.jsp">Back to Home</a>
<body>

<h2>Set Parking Spots</h2>
<form name="statusForm" action="ParkingspotsController?action=ModifyParking" method="post">
	<input name="errMsg"  value="${errorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<table class="regtable">
		
		<tr>
    		<td> Parking Id(*): </td>
    		<td> <input name="parking_Area" value="<c:out value='${parkingspots.parking_Area}'/>" type="text" maxlength="50"> </td>
  			<td> <input name="parking_AreaError"  value="<c:out value='${errorMsgs.parking_AreaError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    	</tr>
    	
    	<tr>
    		<td> Capacity (*): </td>
    		<td> <input name="capacity" value="<c:out value='${parkingspots.capacity}'/>" type="text" maxlength="45">  </td>
  			<td> <input name="capacityError"  value="<c:out value='${errorMsgs.capacityError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    	</tr>	
		
  		
  		<tr>
  			<td id="ModifyParkingbutton"></td>
  		</tr>
  	</table>
  	<input name="action" value="setStatus" type="hidden">
  	<input type="submit" value="Set Capacity">
  	</form>



</body>
</html>