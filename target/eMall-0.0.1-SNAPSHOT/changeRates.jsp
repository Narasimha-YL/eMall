<%@ page import ="java.io.*"%>
<%@ page import ="java.io.File.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>


<html>
    <head>
    <style>
    #date,#daysDiv,#bannerSpace,#atriumDiv,#other,#theatreDiv{
    display:none;
    }
    .center {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
     <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
     
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>



</head>
    <title>Booking</title>
<body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    

<form action="ChangeRates" method="post">
<div class = "center">

	 <p>Select Space Type:
        <select id="spaceType" name="spaceType">
        	  <option value="" disabled selected>Select Type</option>
            <option value="shop" >Shop</option>
            <option value="atrium">Atrium</option>
            <option value="theatre">Theatre</option>
            <option value="banner">Marketing Banners</option>
        </select>
 
 <div id = "spaceDiv">
 Select Bussiness Space :
 <select id = "space" name = "space">
  <option value="" disabled selected>Select Type</option>
 </select>
 </div>
 <br>
 <div id = "theatreDiv">
 Current rate is <span id = "theatre_rate"></span>, enter new rate <input type="text" id="new_theatre" name="new_theatre"/><br>
 </div>
<div id= "other">
Weekday current rate is <span id = "weekday_rate"></span>, enter new rate <input type="text" id="new_weekday" name="new_weekday"/><br>
Weekend current rate is <span id = "weekend_rate"></span>, enter new rate <input type="text" id="new_weekend" name="new_weekend"/><br>
Holiday current rate is <span id = "holiday_rate"></span>, enter new rate <input type="text" id="new_holiday" name="new_holiday"/>
</div>
 <br><br>
 <input type="submit" name="Update rate" value="Update rate">
</div>
 </form>
<script>
$(document).ready(function() {
$(document).on("change", "#spaceType", function(){

	$.ajax({
		url : 'getSpaces',
		data : {
			type : $('#spaceType').val()
		},
		success : function(responseText) {
				
			$('#space').html(responseText);
			
		}
	});
 });
 
$(document).on("change", "#space", function(){
	var e = document.getElementById("spaceType");
	var sh = e.options[e.selectedIndex].value;
	
	if(sh == "theatre")
		{
		document.getElementById("other").style.display='none';
		document.getElementById("theatreDiv").style.display='block';
		document.getElementById("new_weekday").required = false;
		document.getElementById("new_weekend").required = false;
		document.getElementById("new_holiday").required = false;
		document.getElementById("new_theatre").required = true;
		$.ajax({
			url : 'GetRates',
			data : {
				space : $('#space').val(),
				type : sh
			},
			success : function(responseText) {
				var re = responseText;
				$('#theatre_rate').html(re);
			}
		});
		}
	else
		{
		document.getElementById("other").style.display='block';
		document.getElementById("theatreDiv").style.display='none';
		document.getElementById("new_weekday").required = true;
		document.getElementById("new_weekend").required = true;
		document.getElementById("new_holiday").required = true;
		document.getElementById("new_theatre").required = false;
		$.ajax({
			url : 'GetRates',
			data : {
				space : $('#space').val(),
				type : sh
			},
			success : function(responseText) {
				arr=responseText.split(', ');	
				$('#weekday_rate').html(arr[0]);
				$('#weekend_rate').html(arr[1]);
				$('#holiday_rate').html(arr[2]);
			}
		});
		}
 });
});

</script>
 </body>
</html>