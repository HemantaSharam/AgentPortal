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
<title>Insureity Portal | All Business</title>
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
	<c:if test="${bval !=null}">
		<c:if test="${pval !=null}">
			<div class="alert alert-success value-show">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Business Value : </strong> ${bval}<br /> <strong>Property
					Value : </strong> ${pval}
			</div>
		</c:if>
	</c:if>
	<c:if test="${failMessage !=null}">
		<div class="alert alert-danger value-show">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>${failMessage}</strong><br />
		</div>
	</c:if>
	<div class="container-fluid">
		<c:if test="${blist !=null}">
			<div class="row">
				<c:forEach items="${blist}" var="business">
					<div class="col-lg-4 col-md-6 col-custom">
						<div class="card">
							<img class="card-img-top"
								src="https://images.unsplash.com/photo-1554224154-26032ffc0d07?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1012&q=80"
								alt="Default Policy image">
							<div class="card-body">
								<h5 class="card-title">
									<c:out value="${business.businessType}" />
									(
									<c:out value="${ business.bid}" />
									)
								</h5>
								<p class="card-text details">
									<strong>Turnover : </strong>
									<c:out value="${business.turnOver}" />
								</p>
								<p class="card-text details">
									<strong>Capital Invested : </strong>
									<c:out value="${business.capitalInvested}" />
								</p>
								<p class="card-text details">
									<strong>No. of Employees : </strong>
									<c:out value="${business.noOfEmployees}" />
								</p>

								<a
									href='showvalue?bId=<c:out value="${business.bid}"></c:out>&cId=<c:out value="${business.cid}"></c:out>'
									class="btn btn-info left-button">Show Values</a> <a
									href='hidevalue?cId=<c:out value="${business.cid}"></c:out>'
									class="btn btn-danger left-button">Hide Values</a> <a
									href='updateconsumerbusiness?cId=<c:out value="${business.cid}"></c:out>&bId=<c:out value="${business.bid}"></c:out>'
									class="btn btn-warning right-button">Update Business</a><br />
								<br /> <a
									href='propertylist?bId=<c:out value="${business.bid}"></c:out>'
									class="btn btn-info left-button">Property List</a> <a
									href='createbusinessproperty?bId=<c:out value="${business.bid}"></c:out>'
									class="btn btn-success right-button">Create Property<span></span></a><br />
								<br />
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
