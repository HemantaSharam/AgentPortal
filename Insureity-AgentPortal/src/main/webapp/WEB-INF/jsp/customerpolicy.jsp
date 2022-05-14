<%@page import="com.pod8.portal.model.PolicyMaster" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-16x16.png" />
<title>Insureity Portal | Customer Policy List</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1 shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style/portal.css">
</head>

<body>
	<jsp:include page="navbar.jsp" />
	<br>
	<div class="container">
		<div class="table-responsive">
			<h1>Consumer Policy Table</h1>
			<c:if test="${consumerPolicy !=null}">
				<br>
				<br>
			</c:if>
			<c:if test="${consumerPolicy !=null}">
				<table class="table">
					<tr class="heading">
						<th>Business Id</th>
						<th>Policy Id</th>
						<th>Consumer Id</th>
						<th>Payment Details</th>
						<th>Acceptance Status</th>

					</tr>

					<tr>
						<td><c:out value="${consumerPolicy.businessId}" /></td>
						<td><c:out value="${consumerPolicy.policyId}" /></td>
						<td><c:out value="${consumerPolicy.consumerId}" /></td>
						<td><c:out value="${consumerPolicy.paymentDetails}" /></td>
						<td><c:if test="${consumerPolicy.acceptanceStatus ==true}">
								<b>Accepted</b>
							</c:if> <c:if test="${consumerPolicy.acceptanceStatus ==false}">Pending</c:if></td>
					</tr>

				</table>
			</c:if>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
