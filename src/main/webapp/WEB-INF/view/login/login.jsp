<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<h3> ${message}</h3>

<form:form action = "/ShareKarobar/login" commandName = "organizationModel" >
<table>
	<tr>
	<td>login</td>
	</tr>
	<tr>
		<td>Username: <form:errors path = "adminUsername"/></td>
		<td><form:input path = "adminUsername"/> </td>
	</tr>
	
	<tr>
		<td>Password: <form:errors path = "adminPassword"/></td>
		<td><form:password path = "adminPassword"/> </td>
	</tr>

	<tr><td colspan = 2><input type = "submit" value = "Done"/></td></tr>
</table>
</form:form>
<H1> This is a login page</H1>
</body>
</html>