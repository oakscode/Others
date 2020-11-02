<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="moneytransfer" method="post">
	<table>
		<tr>
			<td>Select Payee</td>
			<td>
			<select name="toid">
					<c:forEach items="${payee}" var="item">
						<option value="${item.toid}" >${item.fullname}</option>
					</c:forEach>
			</select>
	
			</td>
			<td>Amount : <input type="text"  name="amount"></td>
			
			
		</tr>
		
	</table>
	<input type="submit"  value="Transfer">
	</form>
	<br>
<a href="logout">logout</a>
</body>
</html>