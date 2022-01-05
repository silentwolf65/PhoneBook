<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Contacts</title>

<script>
	function deleteConfirmation(){
		return confirm("are you sure, you want to delete?");
	}
</script>

</head>
<body>
	<h1 id="mydesc">Contacts</h1>
	<a href="/addContact">Add new contact</a>
	<table class="table table-striped" aria-describedby="mydesc">
		<thead>
			<tr>
				<th scope="col">Sr No</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Phone Number</th>
				<th scope="col">Action</th>
			</tr>
		</thead>

		<c:forEach items="${contacts}" var="contact">
			<tr>	
					<td>${contact.contactId}</td>
				
					<td>${contact.name}</td>
					
					<td>${contact.email}</td>
					
					<td>${contact.phno}</td>
					
					<td>
						<a href="editContact?cid=${contact.contactId}">Edit</a>
						<a href="deleteContact?cid=${contact.contactId}" 
							onclick="return deleteConfirmation()">Delete</a>
					</td>
			</tr>
			
		</c:forEach>
	</table>

	
</body>
</html>