<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>	
$(function() {
	 $("#sdate").datepicker({
	     todayHighlight: 1,
	     dateFormat: "yy-mm-dd",
	   });
	 });

$(function() {
	 $("#edate").datepicker({
	     todayHighlight: 1,
	     dateFormat: "yy-mm-dd",
	   });
	 });
</script>
</head>
<body>



Select start date:<input type="text" id ="sdate" name="sdp" autocomplete="off" />
Select end date:<input type="text" id ="edate" name="edp" autocomplete="off" />
<button onclick="details()" >Get Details</button>
<br><br>


Total income earned in given dates: <span id="total_income"></span>
<br>
<b>Information about Bussiness Spaces booked between given dates</b>
<br>
<div id="shops">

</div>




<script>
function details()
{
	$(document).ready(function(){
		$.ajax({
			
			url : 'InfoBetween',
			data : {
				type : "income",
				start_date : $('#sdate').val(),
				end_date : $('#edate').val()
			},
			success : function(responseText) {
				var a = responseText;
				document.getElementById("total_income").innerHTML = a;
				
			}
		});
		$.ajax({
			url : 'InfoBetween',
			data : {
				type : "info",
				start_date : $('#sdate').val(),
				end_date : $('#edate').val()
			},
			success : function(responseText) {
				document.getElementById("shops").innerHTML = responseText;
				
			}
		});
		
	});

}
</script>
</body>
</html>