<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-16x16.png" />
<title>Insureity Portal | Update Consumer Business</title>
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
<script type="text/javascript" src="js/validation.js"></script>
</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1>Update Consumer Business</h1>
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
			<form action="updatebusiness" method="post" name="Business Form"
				modelAttribute="businessModel"
				onsubmit="return validateCreateBusiness()">
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="bid">Business Id</label> <input type="text"
							class="form-control" id="bid" name="bid"
							value="${businessModel.bid}" readonly="readonly">
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="businessType">Business Type</label> <input type="text"
							value="${businessModel.businessType}" class="form-control"
							id="businessType" name="businessType" required>
					</div>

				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="turnOver">Turnover</label> <input type="number"
							value="${businessModel.turnOver}" class="form-control"
							id="turnOver" name="turnOver" required>
						<div class="turnover_error" id="turnover_error"></div>
					</div>

				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="capitalInvested">Capital Invested</label> <input
							type="number" class="form-control" id="capitalInvested"
							value="${businessModel.capitalInvested}" name="capitalInvested"
							required>
						<div class="CI_error" id="CI_error"></div>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="noOfEmployees">Number of Employees</label> <input
							type="number" class="form-control" id="noOfEmployees"
							value="${businessModel.noOfEmployees}" name="noOfEmployees"
							required>
						<div class="NOE_error" id="NOE_error"></div>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="cid">Consumer Id</label> <input type="text"
							class="form-control" id="cid" name="cid"
							value="${businessModel.cid}" readonly="readonly" required>
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
