<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-16x16.png" />
<title>Insureity Portal | Update Business Property</title>
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
				<h1>Update Business Properties</h1>
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
			<form action="updateproperty" name="Property Form" method="post"
				modelAttribute="propertyModel" onsubmit="return validateProperty()">
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="pid">Property Id</label> <input type="text"
							class="form-control" id="pid" name="pid"
							value="${propertyModel.pid}" readonly="readonly">
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="buildingArea">Building Area (in SQ.FT.)</label> <input
							type="number" class="form-control" id="buildingArea"
							value="${propertyModel.buildingArea}" name="buildingArea"
							required>
						<div class="buildingArea_error" id="buildingArea_error"></div>
					</div>

				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="buildingType">Building Type</label> <select
							class="form-control" id="buildingType" name="buildingType">
							<option value="Owner" selected>Own</option>
							<option value="Rent">Rent</option>
							<option value="Lease">Lease</option>
						</select>
					</div>

				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="buildingStorey">Building Storey</label> <input
							type="number" class="form-control" id="buildingStorey"
							value="${propertyModel.buildingStorey}" name="buildingStorey"
							required>
						<div class="buildingStorey_error" id="buildingStorey_error"></div>
					</div>

				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="buildingAge">Building Age</label> <input type="number"
							value="${propertyModel.buildingAge}" class="form-control"
							id="buildingAge" name="buildingAge" required>
						<div class="buildingAge_error" id="buildingAge_error"></div>
					</div>

				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="costOfAsset">Cost Of Asset</label> <input
							type="number" class="form-control" id="costOfAsset"
							value="${propertyModel.costOfAsset}" name="costOfAsset" required>
						<div class="COA_error" id="COA_error"></div>
					</div>

				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="salvageValue">Salvage Value</label> <input
							type="number" class="form-control" id="salvageValue"
							value="${propertyModel.salvageValue}" name="salvageValue"
							required>
						<div class="SV_error" id="SV_error"></div>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="usefulLife">Useful Life</label> <input type="number"
							value="${propertyModel.usefulLife}" class="form-control"
							id="usefulLife" name="usefulLife" required>
						<div class="UL_error" id="UL_error"></div>
					</div>
				</div>
				<br>


				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<label for="bid">Business Id</label> <input type="text"
							class="form-control" id="bid" value="${propertyModel.bid}"
							name="bid" readonly="readonly">
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
