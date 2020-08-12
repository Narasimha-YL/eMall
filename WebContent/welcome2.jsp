<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="welcome.css">


 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 
 

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<br>
<div id = "got">

</div>
<table id="tbl_id" class="table table-hover">
     <thead>
          <tr>
              <th>Total income in past 10 days</th>
              <th>Total income in past 1 month</th>
              <th>Total income in past 1 Year</th>
              <th>Total income</th>
          </tr>
          <tr>
          	  <td id = "tenIncome"></td>
          	  <td id = "monIncome"></td>
          	  <td id="yearIncome"></td>
          	  <td id="totIncome"></td>
          </tr>
     </thead>
</table>
<br><br>

<% 
if(session.getAttribute("role")==null); 
else if(session.getAttribute("role").equals("admin")){
	%>
<div id="complaintsDiv">

</div>
<%
}
%>
<br><br>
<div id="freeSpaces">
</div>
<form action="newbook.jsp">
<input type="submit" value="Book A Shop">
</form>
<form action="register.jsp" method="post">
<input type="submit" value="Register">
</form>

<form action="createSpace.jsp" method="post">
<input type="submit" value="Create new Bussiness Space">
</form>

<div id ="complaintDiv" style="display:none;">
<form action="Complaint" method="post">
Enter your complaint: <input type="text" id ="complaint" name="complaint"/>
<input type="submit" value="Submit Complaint">
</form>
</div>
<input type="button" onClick="comp()" value="Complaint">
<br><br>

<form action="changeRates.jsp" method="post">
<input type="submit" value="Change Rates">
</form>

<form action="Logout" method="post">
<input type="submit" value="Logout">
</form>


<script>
//global
var arr;
var result

$(document).ready(function(){
	$.ajax({
		
		url : 'GetIncome',
		success : function(responseText) {
			arr=responseText.split(',');
			document.getElementById("tenIncome").innerHTML = arr[0];
			document.getElementById("monIncome").innerHTML = arr[1];
			document.getElementById("yearIncome").innerHTML = arr[2];
			document.getElementById("totIncome").innerHTML =arr[3];
			
		}
	});
	$.ajax({
		url : 'GetInfo',
		success : function(responseText) {
			document.getElementById("freeSpaces").innerHTML = responseText;
			
		}
	});
$.ajax({	
		url : 'GetComplaints',
		success : function(responseText) {
			document.getElementById("complaintsDiv").innerHTML = responseText;
		}
	});
	
});

function comp()
{
	document.getElementById("complaintDiv").style.display='block';	
}
</script>
</body>
</html>