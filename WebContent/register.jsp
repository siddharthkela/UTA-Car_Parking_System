<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<h2>Registering</h2>
	<form action="SearchUser?action=saveUser" method="post">
		<table>
			<tr>
				<td>First Name*</td>
				<td><input type="text" name="firstname" id="firstname" type="text" value="${user.firstname}"></td>
			</tr>
			<tr>
				<td>Last Name*</td>
				<td><input type="text" name="lastname" id="lastname" type="text" value="${user.lastname}"></td>
			</tr>
			<tr>
				<td>U.T.A MAV Id*</td>
				<td><input type="text" name="utaid" id="utaid" type="text"  value="${user.utaid}"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" id="address" type="text" value="${user.address}"></td>
			</tr>
			<tr>
				<td>Username*</td>
				<td><input type="text" name="username" id="username" type="text" value="${user.username}"></td>
			</tr>
			<tr>
				<td>Email*</td>
				<td><input type="text" name="email"  id="email" type="text" value="${user.email}" ></td>
			</tr>
			<tr>
				<td>Password*</td>
				<td><input type="password" name="password" id="password" type="password" value="${user.password}"></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="phone" id="phone" value="${user.phone}"></td>
			</tr>
			<tr>
				<td>Driving License Number*</td>
				<td><input type="text" name="dlnumber" id="dlnumber" type="text" value="${user.licensenumber}"></td>
			</tr>
			<tr>
				<td>Vehicle Number*</td>	
				<td><input type="text" name="vnumber" id="dlnumber" type="text" value="${user.vehiclenumber}"></td>
			</tr>
			<tr>
			<td>Select Permit Type</td>
			
			<td><select name="permit">
					<option>U.T.A</option>
					<option>Mid-range</option>
					<option>Premium</option>
					<option>Access</option>
			</select></td>
			</tr>
			<tr>
				<td> User Role: </td>
  			<td>
				<select name="userrole" id="userrole"    value="${userrole}">
					<option value="User">User</option>
					<option value="Manager">Manager</option>
					<option value="Admin">Admin</option>
				</select>
			</td>
			</tr>
			<tr>
				<td><input type="submit" value="submit">
				</td>
			</tr>

		</table>
	</form>


</body>
</html>
