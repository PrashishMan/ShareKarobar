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
	<%@include file = "navBar.jsp" %>
	<h2>Shareholders Panel</h2>
	<h5>${message}</h5>

	<form:form action="addPurchase" method="POST">
		<table class="table table-striped">
		<tr>
			<th>Remaining Shares: </th>
			<td><c:out value="${remainingShares}"></c:out></td>
			<th></th>
		</tr>
						
			<tr>
				<td>Shareholder Username</td>
				<td><form:select path="purchaseKey.username.username" cssStyle="width: 150px;">
					<option value = "-1"> Select Shareholder </option>
					<c:forEach items = "${shareholders}" var = "shareholders">
						<option value = "${shareholders.username}">${shareholders.shareholderName}</option>
					</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Purchase Amount:</td>
				<td><form:input path="purchaseAmount" /></td>
			</tr>
			<tr>
				<td colspan = 2><input type = "submit" value = "Done" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty purchaseList}">
		<table class="table table-striped">
			<Tr>
				<Th>Purchase Date</Th>
				<Th>Shareholders Name</Th>
				<Th>Issue ID</Th>
				<Th>Purchase Amount</Th>
			</Tr>
			<c:forEach items = "${purchaseList}" var = "purchaseList">
				<tr>
					<td><fmt:formatDate value="${purchaseList.getPurchaseDate()}" type="both" pattern = "dd-MM-YYYY"/></td>
					<td><c:out value = "${purchaseList.purchaseKey.username.shareholderName}"/></td>
					<td><c:out value = "${purchaseList.purchaseKey.issueID.issueID}"/></td>
					<td><c:out value = "${purchaseList.purchaseAmount}"/></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>

</body>
</html>