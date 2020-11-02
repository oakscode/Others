<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.0/axios.min.js" integrity="sha512-DZqqY3PiOvTP9HkjIWgjO6ouCbq+dxqWoJZ/Q+zPYNHmlnI2dQnbJ5bxAHpAMw+LXRm4D72EIRXzvcHQtE8/VQ==" crossorigin="anonymous"></script>
</head>
<body>
Account : ${name}



<h3>Add Payee</h3>
	<form action="addpayee" method="post">
		<table style="width: 50%">

			<tr>
				<th>Enter mobile no :</th>
				<td><input type="text" id="mobile"></td>
			</tr>
			<tr>
				<th>Search</th>
				<td><input type="button" value="click" onclick="search()"></td>
			</tr>
			<tr>
				<th>Firstname</th>
				<td><input type="text" name="firstname" id="firstname"></td>
			</tr>
			<tr>
				<th>Lastname</th>
				<td><input type="text" name="lastname" id="lastname"></td>
			</tr>

			<input type="hidden" name="toid"  id="toid" value="">
			<input type="hidden" name="id"  id="id" value="${id}">

		</table>
		<input type="submit" value="submit">
	</form>
	<a href="transfer?id=<c:out value="${sessionScope.id}"/>">Money Transer</a>
	<br>
	<a href="profile">profile</a>
	<br>
	<a href="logout">logout</a>
</body>
</html>
<script>
function search(){
	mobile=document.querySelector('#mobile').value;
	document.querySelector('#firstname').value='';
	document.querySelector('#lastname').value='';
	axios.get("/accounts?mobile="+mobile,{mobile:mobile}).then(res=>{

		if(res.data.firstname!=undefined){
			//console.log(typeof res.data)
			document.querySelector('#firstname').value=res.data.firstname;
			document.querySelector('#lastname').value=res.data.lastname;
			document.querySelector('#toid').value=res.data.id;
			}
						
				});
}


</script>