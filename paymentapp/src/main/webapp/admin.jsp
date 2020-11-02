<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>

</head>
<body>

	

	<h3>Add New Account</h3>
	<form action="addaccount" method="post">
		<table style="width: 50%">

			<tr>
				<th>Firstname</th>
				<td><input type="text" name="firstname"></td>
			</tr>
			<tr>
				<th>Lastname</th>
				<td><input type="text" name="lastname"></td>
			</tr>
			<tr>
				<th>Mobile</th>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email"></td>
			</tr>


		</table>
		<input type="submit" value="submit">
	</form>

	<a href="logout">logout</a>

</body>
</html>