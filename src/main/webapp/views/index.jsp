<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Contact Info</title>
</head>
<body>
	<h1 id="mydesc">Phone Book</h1>
	<h4 style="color:green;">${successMsg}</h4>
	<h4 style="color:red;">${errMsg}</h4>
	<form:form action="saveContact" method="POST" modelAttribute="contact">
		<table aria-describedby="mydesc">
			<tr>
				<td>Name :</td>
				<td><form:input path="name"></form:input> </td>
				<form:hidden path="contactId"/>
				<form:errors path="name" class="error" />
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email"></form:input> </td>
				<form:errors path="email" class="error" />
			</tr>
			<tr>
				<td>Phno :</td>
				<td><form:input path="phno"></form:input></td> 
				<form:errors path="phno" class="error" />
			</tr>
			<tr>
				<td><input type="submit" value="Save"/></td>
			</tr>
		</table>
	</form:form>
	<a href="viewContacts">View All Contacts</a>
</body>
</html>