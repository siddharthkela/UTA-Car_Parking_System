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
<input name="errMsg" id="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="parkingForm" action="ParkingController" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Parking Area Name (*): </td>
    <td> <input name="parking_area" id="parking_area" value="<c:out value='${parking.parking_area}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="parking_areaError" id="parking_areaError"  value="<c:out value='${errorMsgs.parking_areaError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Capacity (*): </td>
    <td> <input name="capacity" id="capacity" value="<c:out value='${parking.capacity}'/>" type="text" maxlength="45">  </td>
 	<td> <input name="capacityError" id="capacityError"  value="<c:out value='${errorMsgs.capacityError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Floor(*): </td>
    <td> <input name="floor" id="floor" value="<c:out value='${parking.floor}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="floorError" id="floorError"  value="<c:out value='${errorMsgs.floorError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Type (*): </td>
    <td> <input name="type" id="type" value="<c:out value='${parking.type}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="typeError" id="typeError"  value="<c:out value='${errorMsgs.typeError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Cart (*): </td>
    <td> <input name="cart" id="cart" value="<c:out value='${parking.cart}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="cartError" id="cartError"  value="<c:out value='${errorMsgs.cartError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Camera (*): </td>
    <td> <input name="camera" id="camera" value="<c:out value='${parking.camera}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="cameraError" id="cameraError"  value="<c:out value='${errorMsgs.cameraError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> History (*): </td>
    <td> <input name="history" id="history" value="<c:out value='${parking.history}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="historyError" id="historyError"  value="<c:out value='${errorMsgs.historyError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    </table>
    <input name="action" value="saveParking" type="hidden">
    <input type="submit" value="Insert Parking" id="insertParking">
    </form>
</td>
</tr>
</table>
</body>

</html>