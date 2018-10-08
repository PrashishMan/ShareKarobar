<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.:: Edit Content ::.</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"> 
<link href = "webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel = "stylesheet"/>
</head>
<body>
	<h2>Edit Organization Content</h2>
	<table class="table table-striped">
		<form:form method = "POST" action = "updateOrganization">
		
			<tr>
				<Th><form:label path = "organizationName" >Organization Name: </form:label></Th>
				<Td><form:input path = "organizationName" value = "${organizationModel.organizationName}"/></Td>
			</tr>
			
			<tr>
				<Th><form:label path = "adminFame" >Admin Firstname: </form:label></Th>
				<Td><form:input path = "adminFame" value = "${organizationModel.adminFame}"/></Td>
			</tr>
			
			<tr>
				<Th><form:label path = "adminLame" >Admin Lastname: </form:label></Th>
				<Td><form:input path = "adminLame" value = "${organizationModel.adminLame}"/></Td>
			</tr>
			
			<tr>
				<Th><form:label path = "adminUsername" >Admin Username: </form:label></Th>
				<Td><form:input path = "adminUsername" value = "${organizationModel.adminUsername}"/></Td>

								
			</tr>
			
			<tr>
				<Th><form:label path = "adminPassword" >Admin Password: </form:label></Th>
				<Td><form:input path = "adminPassword" value = "${organizationModel.adminPassword}"/></Td>
			</tr>
			
			<tr>
				<Th><form:label path = "organizationMargin" >Organization Margin: </form:label></Th>
				<Td><form:input path = "organizationMargin" value = "${organizationModel.organizationMargin}"/></Td>
			</tr>
			<tr>
				<td colspan = "2"><form:button action = "submit">Done</form:button></td>
			</tr>
			
		</form:form>
	</table>
</body>
</html>