<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Welcome to UTA Park</h1>
	<h2>Login</h2>
	<input name="errMsg"  value="<c:out value='${lerrorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<form action="LoginController?action=loginUser" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" id="username" name="username" id="username" value="<c:out value='${Login.username}'/>"></td>
				<td> <input name="userNameError" id="userNameError" value="<c:out value='${lerrorMsgs.userNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="password" name="password" value="<c:out value='${Login.password}'/>"></td>
   				<td> <input name="passwordError" id="passwordError" value="<c:out value='${lerrorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>				
				
					
			</tr>
			<tr>
				<td>Select User Type</td>
				<td><select name="User" id ="User">
						<option>User</option>
						<option>Manager</option>
						<option>Admin</option>
				</select></td>

			</tr>
			<tr>
				<td><input type="submit" value="Login" name="submit" id="loginSubmit"> </td>
			</tr>
	
			<tr>
				<td><a href="register.jsp"> Click here to register</a></td>
			</tr>
		</table>
	</form>


</body>
</html>