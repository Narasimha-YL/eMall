<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<form action ="Register" method="post">
Name: <input type="text" name="name" placeholder="Enter name" required>	<br>
Email ID: <input type="text" name="mailid" placeholder="Email ID" required>	<br>
Password: <input type="text" name="pass" placeholder="Password" required>	<br>
Phone: <input type="text" name="phone" placeholder="Phone number" required>	<br>
What is your favourite city / place? <input type="text" name="question_city" placeholder="Security Question" required><br>
What is your favourite dish? <input type="text" name="question_dish" placeholder="Security Question" required><br>
<div id = "exists"></div>
<input type="submit"  form = "" name="Register" value="Register" onclick="return mail()">
</form>
<script>
function mail()
{
	$(function(){ 
		alert("function called");
		$.ajax({
			url : 'CheckMail',
			data : {
				mail : $('#mailid').val()
			},
			success : function(responseText) {
				var res = responseText;	
			}
		});
	 });
	if(res === "true")
		{
			document.getElementById("exists").innerHTML = "User already exists with given email";
			return false;
		}
	else
		{
			return true;
		}
}
</script>
</body>
</html>