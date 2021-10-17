<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyPets Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
   <font color="white"><h5>PET SHOP</h5></font>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="nav navbar-navnavbar-right" id="navbarSupportedContent">
	<li class="nav-item active"><a class="nav-link"
			href="<c:url value="/homepage"/>">Home <span class="sr-only">(current)</span></a></li>
		<li class="nav-item active"><a class="nav-link"
			href="<c:url value="/mypets"/>">My Pets <span class="sr-only">(current)</span></a></li>
			<li class="nav-item active"><a class="nav-link"
			href="<c:url value="/addpet"/>">Add Pet <span class="sr-only">(current)</span></a></li>	
			<li class="nav-item active"><a class="nav-link"
			href="<c:url value="/"/>">Sign Out </a></li>			
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
<body>
<br><br>
<h5><b>Buy Pet</b></h5>
<table border="1">
<tr>
<td>Pet Id</td>
<td>Pet Name</td>
<td>Pet Age</td>
<td>Pet Place</td>
</tr>

<c:forEach items="${mypets}" var="pet">
<tr>
<td>${pet.petId}</td>
<td>${pet.petName}</td>
<td>${pet.petAge}</td>
<td>${pet.petPlace}</td>
</tr>
</c:forEach>
</table>

</body>
</html>