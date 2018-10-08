<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Panel</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

	<%@include file="navBar.jsp"%>
	<h2>Admin Panel</h2>
	<table class="table table-striped">
		<Tr>
			<th colspan=4>${organizationModel.organizationName}</th>
		</Tr>
		<tr>
			<th>Administrator</th>
			<td>${organizationModel.adminFame}
				${organizationModel.adminLame}</td>
			<th>Organization Margin</th>
			<th>${organizationModel.organizationMargin}</th>
		</tr>

		<tr>
			<th>Total Share Amount</th>
			<c:if test="${shareService.getTotalShare() != null}">
				<td>${shareService.getTotalShare()}</td>
			</c:if>
			<th>Shareholders Margin</th>
			<td>${100-(organizationModel.organizationMargin)}</td>
		</tr>
		<tr>
		<td colspan = "2"><a href = "editContent"><Button class="btn btn-default" >Edit</Button> </a></td>
		</tr>
	</table>
	

	<h2>Shareholder's Details</h2>
	<c:if test="${!empty shareHoldersTotal}">
		<Table class="table table-striped">
			<Tr>
				<Th>ShareholdersName</Th>
				<Th>Share Percent</Th>
			</Tr>
			<c:forEach items="${shareHoldersTotal}" var="shareHoldersTotal">
				<tr>
					<td><c:out value="${shareHoldersTotal.getShareHolder()}"></c:out></td>
					<c:if test="${shareService.getTotalShare() != null}">
						<td><fmt:formatNumber
								value="${shareHoldersTotal.getInvestment() * 100/shareService.getTotalShare()}"
								minFractionDigits="0" maxFractionDigits="2" /></td>
					</c:if>
				</tr>

			</c:forEach>
		</Table>
	</c:if>
	<H2>Monthly Profits and Loss</H2>
	<c:if test="${!empty monthlyProfits}">
		<Table class="table table-striped">
			<Tr>
				<Th>Month</Th>
				<Th>Credit Amount</Th>
				<Th>Debit Amount</Th>
				<Th>Profit</Th>
				<Th>Loss</Th>
				<th></th>

			</Tr>
			<c:forEach items="${monthlyProfits}" var="monthlyProfits">
				
				<tr>
					
					<td><c:out value="${monthlyProfits.getMonth()}"></c:out></td>
					<td><c:out value="${monthlyProfits.getCreditTotal()}"></c:out></td>
					<td><c:out value="${monthlyProfits.getDebitTotal()}"></c:out></td>
					<c:choose>
						<c:when test="${profit} > 0">
							<td><c:out value="${monthlyProfits.getProfit()}"></c:out></td>
							<td><c:out value=""></c:out></td>
						</c:when>
						<c:otherwise>
							<td><c:out value=""></c:out></td>
							<td><c:out value="${monthlyProfits.getProfit()}"></c:out></td>
						</c:otherwise>

					</c:choose>
					
					<td><a href = "viewMonthlyTransaction?month=${monthlyProfits.getMonth()}">
					<button class = "btn btn-default">View</button></a></td>
				</tr>
				

			</c:forEach>
		</Table>
	</c:if>

</body>
</html>