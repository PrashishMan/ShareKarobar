
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shareholder</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<%@include file="navBar.jsp"%>

	<h2>Shareholders Panel</h2>
	<h1>${message}</h1>
	<br />

	<form:form action="addshareholder" method="POST">
		<Table class="table table-striped">
			<tr>
				<Th>Shareholder's Name:</Th>
				<td><form:input path="shareholderName" />
			</tr>

			<tr>
				<Th>Username:</Th>
				<td><form:input path="username" />
			</tr>

			<tr>
				<Th>Password:</Th>
				<td><form:input path="password" />
			</tr>

			<tr>
				<th>Location:</th>
				<td><form:select path="locationId.locationID"
						cssStyle="width: 150px;">
						<option value="-1">Select Location</option>
						<c:forEach items="${locations}" var="location">
							<option value="${location.locationID}">${location.street}</option>
						</c:forEach>
					</form:select></td>
			</tr>

			<%-- <tr>
				<Th>LocationID:</Th>
				<td><form:input path="locationId.locationID" />
			</tr>

			<tr>
				<Th>State:</Th>
				<td><form:input path="state" />
			</tr>

			<tr>
				<Th>Zone:</Th>
				<td><form:input path="zone" />
			</tr>

			<tr>
				<Th>City:</Th>
				<td><form:input path="city" />
			</tr>

			<tr>
				<Th>Street:</Th>
				<td><form:input path="street" />
			</tr>
 --%>
			<tr>
				<td colspan=2><input type="Submit" value="Done" /></td>
			</tr>
		</Table>
	</form:form>

	<c:if test="${!empty shareholders}">

		<Table class="table table-striped">
			<tr>
				<th>Shareholders Name</th>
				<th>Username</th>
				<th>Password</th>
				<th>State</th>
				<th>Zone</th>
				<th>City</th>
				<th>Street</th>
			</tr>

			<c:forEach items="${shareholders}" var="shareholders">
				<tr>
					<td><c:out value="${shareholders.getShareholderName()}" /></td>
					<td><c:out value="${shareholders.getUsername()}" /></td>
					<td><c:out value="${shareholders.getPassword()}" /></td>

					<td><c:out value="${shareholders.getLocationId().getState()}" /></td>
					<td><c:out value="${shareholders.getLocationId().getZone()}" /></td>
					<td><c:out value="${shareholders.getLocationId().getCity()}" /></td>
					<td><c:out value="${shareholders.getLocationId().getStreet()}" /></td>
				</tr>
			</c:forEach>
		</Table>
	</c:if>

</body>
</html>