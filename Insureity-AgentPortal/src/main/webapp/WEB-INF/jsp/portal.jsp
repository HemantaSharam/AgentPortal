<!DOCTYPE html>
<%@page import="com.pod8.portal.model.PolicyMaster" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-16x16.png" />
<title>Insureity Portal | Home</title>
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
			<h1>Policy Master Table</h1>
			<c:if test="${plist !=null}">
				<table class="table">
					<tr class="heading">
						<th>Id</th>
						<th>Property Type</th>
						<th>Consumer Type</th>
						<th>Assured Sum</th>
						<th>Tenure</th>
						<th>Business Value</th>
						<th>Property Value</th>
						<th>Base location</th>
						<th>Type</th>
					</tr>
					<c:forEach items="${plist}" var="policy">
						<tr>
							<td><c:out value="${policy.id}" /></td>
							<td><c:out value="${policy.propertyType}" /></td>
							<td><c:out value="${policy.consumerType}" /></td>
							<td><c:out value="${policy.assuredSum}" /></td>
							<td><c:out value="${policy.tenure}" /></td>
							<td><c:out value="${policy.businessValue}" /></td>
							<td><c:out value="${policy.propertyValue}" /></td>
							<td><c:out value="${policy.baseLocation}" /></td>
							<td><c:out value="${policy.type}" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
	
	  <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>
