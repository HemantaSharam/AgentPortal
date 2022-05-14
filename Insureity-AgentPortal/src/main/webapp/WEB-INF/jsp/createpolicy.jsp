<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-16x16.png" />
<title>Insureity Portal | Create Policy</title>
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
				<h1>Create New Policy</h1>
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
			<form name="New Policy Form" action="createpolicy"
				modelAttribute="policyMaster" method="post"
				onsubmit="return validateCreatePolicy()">


				<div class="row">
					<div class="col-lg-4 col-sm-12">
						<label for="id">Id</label> <input type="text" class="form-control"
							id="id" name="id" required>

					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="propertyType">Property Type</label> <select
							class="form-control" id="propertyType" name="propertyType">
							<option value="Building" selected>Building</option>
							<option value="Land">Land</option>
						</select>
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="consumerType">Consumer Type</label> <select
							class="form-control" id="consumerType" name="consumerType">
							<option value="Owner" selected>Owner</option>
							<option value="Rent">Rent</option>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="assuredSum">Assured Sum</label> <input type="number"
							class="form-control" id="assuredSum" name="assuredSum" required>
						<div class="sum_error" id="sum_error"></div>
					</div>


				</div>
				<br>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="tenure">Tenure</label> <input type="number"
							class="form-control" id="tenure" name="tenure" required>
						<div class="tenure_error" id="tenure_error"></div>
					</div>


				</div>
				<br>


				<div class="row">
					<div class="col-lg-3 col-sm-12">
						<label for="businessValue">Business Value</label> <select
							class="form-control" id="businessValue" name="businessValue">
							<option value="0" selected>0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
					</div>
					<div class="col-lg-3 col-sm-12">
						<label for="propertyValue">Property value</label> <select
							class="form-control" id="propertyValue" name="propertyValue">
							<option value="0" selected>0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
					</div>

				</div>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="baseLocation">Base Location</label> <input type="text"
							class="form-control" id="baseLocation" name="baseLocation"
							required>
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="type">Type</label> <select class="form-control"
							id="type" name="type">
							<option value="Replacement" selected>Replacement</option>
							<option value="Pay Back">Pay Back</option>
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
