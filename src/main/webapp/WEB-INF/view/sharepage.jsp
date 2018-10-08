<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Share Panel</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	
	<%@include file = "navBar.jsp" %>
	<h2>Share Panel</h2>
	<h5>${message}</h5>
	<form:form action="issueshare" method= "POST">

		<table class="table table-striped">
		
			<tr>
				<td>Issue Date:</td>
				<td><form:input path="issueDate"/></td>
			</tr>

			<tr>
				<td>Issued Amount:</td>
				<td><form:input path= "issuedAmount"/></td>
			</tr>
			
			<tr>
				<td colspan = 2><input type = "submit" value = "Add Share"/></td>
			</tr>			
		</table>
	</form:form>
	
	<c:if test = "${!empty shareList}">
	
		<table class="table table-striped">
			<tr>
				<th>Issue Id</th>
				<th>Issue Date</th>
				<th>Issued Amount</th>
			</tr>		
			
			<c:forEach items = "${shareList}" var = "shares">
				<tr>
					<td>${shares.issueID}</td>
					<td><fmt:formatDate value = "${shares.issueDate}" type = "both" pattern = "yyyy-MM-dd"/></td>
					<td>${shares.issuedAmount}</td>
				</tr>
			</c:forEach>
			
		</table>
		</c:if>
		
		

</body>
</html>