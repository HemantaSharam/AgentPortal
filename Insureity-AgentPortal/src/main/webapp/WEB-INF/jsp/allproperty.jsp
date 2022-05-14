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
<title>Insureity Portal | All Property</title>
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

	<div class="container-fluid">
		<c:if test="${empty plist}">
			<br>
			<br>
			<br>
			<h2 style="text-align: center;">No Property Available</h2>
		</c:if>


		<c:if test="${plist !=null}">

			<div class="row">

				<c:forEach items="${plist}" var="property">

					<div class="col-lg-4 col-md-6 col-custom">
						<div class="card">
							<img class="card-img-top"
								src="https://images.unsplash.com/photo-1560518883-ce09059eeffa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=966&q=80"
								alt="Sandwich">
							<div class="card-body">
								<h5 class="card-title">
									&#x20B9;
									<c:out value="${property.costOfAsset}" />
									(
									<c:out value="${property.pid}" />
									)
								</h5>

								<p class="card-text details">
									<strong>Building Area : </strong>
									<c:out value="${property.buildingArea}" />
								</p>
								<p class="card-text details">
									<strong>Building Storey : </strong>
									<c:out value="${property.buildingStorey}" />
								</p>
								<p class="card-text details">
									<strong>Building Age : </strong>
									<c:out value="${property.buildingAge}" />
								</p>
								<p class="card-text details">
									<strong>Salvage Value : </strong>
									<c:out value="${property.salvageValue}" />
								</p>
								<p class="card-text details">
									<strong>Useful Life : </strong>
									<c:out value="${property.usefulLife}" />
								</p>

								<a
									href='/getquote?bid=<c:out value="${property.bid}"/>&pid=<c:out value="${property.pid}"></c:out>'
									class="btn btn-info left-button">Get Quote</a> <a
									href='/updatebusinessproperty?bid=<c:out value="${property.bid}"/>&pid=<c:out value="${property.pid}"></c:out>'
									class="btn btn-primary right-button">Update Property</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>

	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
