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
<title>View User</title>
</head>
<a href="ManagerHome.jsp">Back to Home</a>
<body>	
	
	<h1>List of Users </h1>
   <div class="mainbar"><div class="submb"></div></div>
<table class="myTable">
		<tr class="myTableRow">
			<th class="myTableHead">User ID</th>
			<th class="myTableHead">Password</th>
			<th class="myTableHead">First Name</th>
			<th class="myTableHead">Last Name</th>
			<th class="myTableHead">Email</th>
			<th class="myTableHead">Role</th>	
			<th class="myTableHead">Parking Permit Type</th>			
			<th class="myTableHead">License Number</th>
			<th class="myTableHead">status</th>
			<th class="myTableHead">UtaId</th>
				
		</tr>
			<c:forEach items="${COMPANIES}" var="item">
			<tr class="myTableRow">
				
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.username}" /></td>
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.password}" /></td>
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.firstname}" /></td>
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.lastname}" /></td>
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.email}" /></td>
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.role}" /></td>
		
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.parkingpermittype}" /></td>
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.licensenumber}" /></td>
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.status}" /></td>
				<td class="myTableCell" style="width: 105px; "><c:out value="${item.utaid}" /></td>
				
			</c:forEach>			
			</table>
	
<form action="SearchUser" method="get">				
	<input type="submit" value="Find" name="submit" id="searchUser"> 			
	</form>

</body>
</html>