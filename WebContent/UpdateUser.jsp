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
<body>
<center>
<a href="http://localhost:8079/First_Project/AdminHomePage.jsp">Back to Home</a>
<h2>Edit User</h2>
<form name="registerForm" action="SearchUser?action=UpdateUser" method="post">
	<input name="errMsg"  value="${errorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<table class="regtable" >
	
		<c:forEach items="${user}" var="item">
		<tr>
  			<td> First Name: </td>
  			<td><input name="firstname" id="firstname" type="text" value="${item.firstname}"></td>
  			<td> <input name="firstnameError"  value="<c:out value='${errorMsgs.firstnameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		</tr>
  		<tr>
  			<td> Last Name: </td>
  			<td><input name="lastname" id="lastname" type="text" value="${item.lastname}"></td>
  			<td> <input name="lastnameError"  value="<c:out value='${errorMsgs.lastnameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		</tr>
  	
  		<tr>
  			<td> Username: </td>
  			<td><input name="username" id="username" type="text" value="${item.username}"></td>
  			<td> <input name="user_nameError"  value="<c:out value='${errorMsgs.user_nameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		</tr>
  		<tr>
  			<td> Email: </td>
  			<td><input name="email" id="email" type="text" value="${item.email}"></td>
  			<td> <input name="emailError"  value="<c:out value='${errorMsgs.emailError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		</tr>
  
  		<tr>
  			<td> Password: </td>
  			<td><input name="password" id="password" type="password" value="${item.password}"></td>
  			<td> <input name="passwordError"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		
  		</tr>
  		
  		<tr>
  			<td> Phone: </td>
  			<td><input name="phone" id="phone" type="number" placeholder="1234567890"  value="${item.phone}"></td>
  			<td> <input name="phoneError"  value="<c:out value='${errorMsgs.phoneError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		
  		</tr>
  		
  		
  		
  		<tr>
  			<td> Address: </td>
  			<td><input name="address" id="address" type="text" value="${item.address}"></td>
  			<td> <input name="addressError"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		
  		</tr>
  	
  	
  		<tr>
  			<td> License Number: </td>
  			<td><input name="licensenumber" id="licensenumber" type="text" value="${item.licensenumber}"></td>
  			<td> <input name="licensenumber"  value="<c:out value='${errorMsgs.licensenumberError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		
  		</tr>
  
  
  		  		 <tr>
  			<td> Uta Id</td>
  			<td><input name="licensenumber" id="licensenumber" type="text" value="${item.utaid}"></td>
  			<td> <input name="licensenumber"  value="<c:out value='${errorMsgs.licensenumberError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
  		
  		</tr>
  		<tr>
  			<td> Permit Type: </td>
  			<td>
  				<input type="radio" name="usertype" id="usertype" value="basic" checked="checked">Basic
  				<input type="radio" name="usertype" id="usertype" value="premium">Premium
  				<input type="radio" name="usertype" id="usertype" value="midrange">Mid-Range
  				<input type="radio" name="usertype" id="usertype" value="access">Access
  			</td>
  		</tr>
  		<tr>
  			<td> User Role: </td>
  			<td>
				<select name="userrole" id="userrole" value="${item.role}">
<option value="${item.role}" ${item.role == item.role ? 'selected="selected"' : ''}>${item.role}</option>				
			<option value="Manager">Manager</option>
					<option value="User">User</option>
					<option value="Admin">Admin</option>
					
			
				</select>
			</td>
			 		
  		</tr>
  		</c:forEach>
  		<tr>
  			<td></td>
  			<td><input name="status" id="status" type="hidden" value="Enabled"></td>
  		</tr>
  		<tr>
    		<td colspan="2"></td>
		</tr>
		<tr>
    		<td colspan="2"></td>
		</tr>
  		<tr>
  			<td id="registerbutton"></td>
  		</tr>
  	</table>
  	<input name="action" value="saveUser" type="hidden">
  	<input type="submit" value="Update">
  	</form>
</body>
</html>