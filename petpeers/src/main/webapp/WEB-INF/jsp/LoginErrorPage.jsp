<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Error</title>
<style>
.head{color:white}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
     <h4 class="head">PET SHOP</h4>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="nav navbar-navnavbar-right" id="navbarSupportedContent">

		<li class="nav-item active"><a class="nav-link"
			href="<c:url value='/'/>">SignUp <span class="sr-only">(current)</span></a></li>
	</div>
</nav>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous">
</script>

</head>
<body>
<br/>
	<h3>Login</h3>
	<font color="red"><h5>${message }<br/></h5></font>	
	<c:url var="loginAction" value="/authenticateUser" />
	<form:form action="${loginAction }" method="post" modelAttribute="loginForm">
		<table>
		<tr>
				<td>Name:</td>
				<td><form:input type="text" path="userName" auto-complete="off" required="true" /></td>
		</tr>
		<tr>
				<td>Password:</td>
				<td><form:input type="text" path="password" auto-complete="off" required="true"/></td>
		</tr>
		<tr>
				<td><input type="submit" value="login" /></td>
			
		</table>
	</form:form>
</body>
</html>