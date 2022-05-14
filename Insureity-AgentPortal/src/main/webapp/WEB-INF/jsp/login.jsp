<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 shrink-to-fit=no">
<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-16x16.png" />
<title>Insureity Portal | Login Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="style/Login.css">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style/login.css">

</head>
<body>
	<nav class="navbar bg-success navbar-dark">
		<a class="navbar-brand" href=""> Insureity Agent Portal </a>

	</nav>
	<br>

	<div class="container-fluid bg">
		<div class="row justify-content-center">
			<div class="col-12 col-sm-6 col-md">
				<div class="container">
					<h1>Agent Login</h1>
					<c:if test="${error !=null}">
						<p class="id_error">${error}</p>
					</c:if>
					<form name="Login Form" action="login" method="post"
						modelAttribute="credential">
						<div class="form-group">
							<label for="agentId">Agent Id</label> <input type="text"
								class="form-control" id="agentId" name="agentId" required>
							<p class="id_error" id="id_error"></p>
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" name="password" required>
							<p class="pass_error" id="pass_error"></p>
						</div>
						<br>
						<button type="submit" class="btn btn-primary btn-block ">Login</button>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
