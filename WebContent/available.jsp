<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<center>
<h2>Set Parking Spots</h2>
<form name="statusForm" action="ParkingspotsController?action=setStatus" method="post">
	<input name="errMsg" id="errMsg" value="${pserrorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<table class="regtable">
		
		<tr>
    		<td> Parking Area Name (*): </td>
    		<td> <input id="parking_Area" name="parking_Area" value="<c:out value='${parkingspots.parking_Area}'/>" type="text" maxlength="50"> </td>
  			<td> <input id="parking_AreaError" name="parking_AreaError"  value="<c:out value='${pserrorMsgs.parking_AreaError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    	</tr>
		
		<tr>
  			<td> Parking Number(*): </td>
  			<td><input name="parking_Number" id="parking_Number" type="text" value="${parkingspots.parking_Number}"></td>
  			<td> <input name="parking_NumberError" id="parking_NumberError" value="<c:out value='${pserrorMsgs.parking_NumberError}'/>"type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		
  		</tr>
  		
  		<tr>
    		<td> Type (*): </td>
    		<td> <input name="membership_type" id="membership_type" value="<c:out value='${parkingspots.membership_type}'/>" type="text" maxlength="45">  </td>
  			<td> <input name="membership_typeError" id="membership_typeError" value="<c:out value='${pserrorMsgs.membership_typeError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    	</tr>		
  		<tr>
  			<td></td>
  			<td><input name="status" id="status" type="hidden" value="Enabled"></td>
  		</tr>
  		
  		<tr>
  			<td id="setUnavailablebutton"></td>
  		</tr>
  	</table>
  	<input name="action" value="setStatus" type="hidden">
  	<input type="submit" value="Set Status" id="setunavailable">
  	</form>

</body>
</html>