<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="AdminHomePage.jsp">Back to Home</a>
<input name="errMsg" id="errMsg" value="<c:out value='${RverrorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="revokeForm" action="RevokeController?action=revoke" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> User Name (*): </td>
    <td> <input name="username" id="username" value="<c:out value='${revoke.username}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="user_nameError" id="user_nameError" value="<c:out value='${RverrorMsgs.user_nameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Reason (*): </td>
    <td> <input name="reason" id="reason" value="<c:out value='${revoke.reason}'/>" type="text" maxlength="100">  </td>
 	<td> <input name="reasonError" id="reasonError" value="<c:out value='${RverrorMsgs.reasonError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
     </table>
    <input name="action" value="saveRevoke" type="hidden">
    <input type="submit" value="Revoke User" name="action" value="revoke" id="revoke">
    &nbsp;
    &nbsp;
    </form>
    <br>
    
     
    
    
</table>

</body>
</html>