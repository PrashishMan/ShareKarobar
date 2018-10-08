
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transaction</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<%@include file="navBar.jsp"%>
	<h2>Transaction Panel</h2>
	<h1>${message}</h1>

	<form:form action="addtransaction" method="POST">
		<Table class="table table-striped">

			<c:if test="${!empty job}">
				<tr>
					<Th>Bill No:</Th>
					<td><form:input path="billNo" />
				</tr>

				<tr>
					<Th>Name of the Party:</Th>
					<td><form:input path="partyName" />
				</tr>

				<tr>
					<Th>Transaction Purpose:</Th>
					<td><form:input path="transactionPurpose" />
				</tr>

				<tr>
					<Th>Transaction Type:</Th>
					<td><form:select path="transactionType"
							cssStyle="width: 150px">
							<option value="-1"></option>
							<option value="Debit">Debit</option>
							<option value="Credit">Credit</option>
						</form:select>
				</tr>

				<tr>
					<Th>Bill Amount:</Th>
					<td><form:input path="amount" />
				</tr>

				<tr>
					<Th>Payment Mode:</Th>
					<td><form:select path="paymentType" cssStyle="width: 150px">
							<option value="-1"></option>
							<option value="Cash">Cash</option>
							<option value="Cheque">Cheque</option>
						</form:select>
				</tr>

				<tr>
					<td colspan=2><input type="Submit" value="Done" /></td>
				</tr>
			</c:if>
		</Table>
	</form:form>

	<c:if test="${!empty transactionList}">

		<Table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Date</th>
				<th>Bill no</th>
				<th>Party Name</th>
				<th>Purpose</th>
				<th>Debit</th>
				<th>Credit</th>
				<th>Payment Mode</th>
			</tr>

			<c:forEach items="${transactionList}" var="transactions">
				<tr>
					<td><c:out value="${transactions.getTransactionId()}" /></td>
					<td><fmt:formatDate value="${transactions.getDate()}"
							type="both" pattern="dd-MM-YYYY" /></td>
					<td><c:out value="${transactions.getBillNo()}" /></td>
					<td><c:out value="${transactions.getPartyName()}" /></td>
					<td><c:out value="${transactions.getTransactionPurpose()}" /></td>
					<c:choose>
						<c:when test="${transactions.getTransactionType() == 'Debit'}">
							<td><c:out value="${transactions.getAmount()}" /></td>
							<td></td>
						</c:when>
						<c:otherwise>
							<td></td>
							<td><c:out value="${transactions.getAmount()}" /></td>
						</c:otherwise>
					</c:choose>
					<td><c:out value="${transactions.getPaymentType()}" /></td>
				</tr>
			</c:forEach>
			<c:if test="${empty job}">
				<Tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><h5>Total</h5></td>
					<td><c:out value="${total.getDebitTotal()}" /></td>
					<td><c:out value="${total.getCreditTotal()}" /></td>
				
				<c:choose>
						<c:when test="${profit} > 0">
							<td><h5>Profit : <c:out value="${total.getProfit()}" /></h5></td>
						</c:when>
						<c:otherwise>
							<td><h5>Loss : <c:out value="${total.getProfit() * -1}" /></h5></td>
						</c:otherwise>

					</c:choose>
				
				</Tr>
				
			</c:if>
		</Table>
	</c:if>

</body>
</html>