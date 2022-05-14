<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-16x16.png" />
<title>Insureity Portal | Insure Policy</title>
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
<link rel="stylesheet" type="text/css" href="style/policy.css">
</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1>Insure Policy</h1>
			</div>
		</div>
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
		<div class="form-group">
			<form action="issuepolicy" modelAttribute="consumerPolicy"
				method="post" name="Issue Policy Form">
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="businessId">Business Id</label> <input type="text"
							class="form-control" id="businessId" name="businessId">
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="policyId">Policy Id</label> <input type="text"
							class="form-control" id="policyId" name="policyId">
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="consumerId">Consumer Id</label> <input type="text"
							class="form-control" id="consumerId" name="consumerId">
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="paymentDetails">Payment Details</label> <select
							class="form-control" id="paymentDetails" name="paymentDetails">
							<option value="UPI" selected>UPI</option>
							<option value="Credit Card">Credit Card</option>
							<option value="Debit Card">Debit Card</option>
							<option value="Net Banking">Net Banking</option>
						</select>
					</div>

				</div>
				<br>


				<div class="row">
					<div class="col-lg-3 col-sm-12">
						<label for="acceptance_status">Acceptance Status</label> <select
							class="form-control" id="acceptanceStatus"
							name="acceptanceStatus">
							<option value="1" selected>Sucessful</option>
							<option value="0">Failed</option>


						</select>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-12 col-sm-12">
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</div>
			</form>

		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
