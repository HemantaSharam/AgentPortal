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
<title>Insureity Portal | Quote</title>
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
	<jsp:include page="navbar.jsp"></jsp:include>
	<br>

	<c:if test="${failMessage !=null}">
		<div class="alert alert-danger value-show">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>${failMessage}</strong><br />
		</div>
	</c:if>
	<c:if test="${sucMessage !=null}">
		<div class="alert alert-success value-show">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>${sucMessage}</strong><br />
		</div>
	</c:if>

	<h2 class="idheader">Get Quote</h2>
	<form action="quotevalue" class="form" method="get">
		<div class="form-group">
			Business Value<input type="number" class="form-control"
				value="${bval }" id="businessValue" name="businessValue">
			Property Value<input type="number" class="form-control"
				value="${pval }" id="propertyValue" name="propertyValue">
			Property Type<select class="form-control" id="propertyType"
				name="propertyType">
				<option value="Land">Land</option>
				<option value="Building" selected>Building</option>
			</select><br />

			<button type="submit" class="btn btn-primary">Get Quote</button>
		</div>
	</form>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
