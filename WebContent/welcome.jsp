<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome</title>

   <!--jQuery-->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
   <!-- DATE PICKER PURPOSE CSS -->
     <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!--AJAX -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<!-- BOOTSTRAP -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <!-- Font Awesome -->
    <script src="https://use.fontawesome.com/bae75bb48f.js"></script>
   
<link rel="stylesheet" type="text/css" href="welcome.css">    


<!--DATE PICKER  -->
<script>
var sd;
var endD='1M';
//var sd = "2020-08-08";

$(function() {
	 $("#sdate").datepicker({
	     minDate : 0,
	     maxDate : '1Y' ,
	     todayHighlight: 1,
	     dateFormat: "yy-mm-dd",
	     beforeShowDay: function (date) {
	         var dateStr = jQuery.datepicker.formatDate('yy-mm-dd', date);
	             return [arr.indexOf(dateStr) == -1];
	     },
	   });
	 });
	 
$(function() {
	 $("#inc_rep_sdate").datepicker({
	     todayHighlight: 1,
	     dateFormat: "yy-mm-dd",
	   });
	 });

$(function() {
	 $("#inc_rep_edate").datepicker({
	     todayHighlight: 1,
	     dateFormat: "yy-mm-dd",
	   });
	 });
</script>

<style>
    #date,#daysDiv,#bannerSpace,#atriumDiv,#shopDiv,#other,#theatreDiv,#ban,#rateTheatreDiv,#rateOther{
    display:none;
    }
</style>


 
</head>
<body>
<!-- JQUERY DATE PICKER -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>










<div class="nav">
<div id="titlename">
<h4>
A B C Entertainment and Real Estate Pvt Ltd  
</h4>
</div>

<div id="logoutsection">

<form action="Logout" method="post">
<button type="submit" value="Logout">Logout <i class="fa fa-sign-out" aria-hidden="true"></i></button>
</form>

</div>



</div>


<div class="sidenav">
	<button onclick="location.reload();"> Home </button>
	
  <button class="sidnav-buttons" value="shopBookingdiv" id="book_a_shop"> Book A Shop </button>
  
  <button class="sidnav-buttons" value="reg_comp_div" id="reg_a_comp"> Register A Complaint </button>
  
  <button class="sidnav-buttons" value="inc_rep_div" id="inc_rep"> Income Report</button>
  
  <button class="sidnav-buttons" value="reg_new_space" id="create_space"> Create New Bussiness Space</button>
  
  <button class="sidnav-buttons" value="change_prices" id="change_price"> Change Space Cost </button>
  
  <button class="sidnav-buttons" value="create_users" id="create_user"> Create User </button>
  
</div>

<div id="changable" class="canchange">
	<!--Initial Loading  -->
	<div class="main" id="initial">
	
		<!-- div FOR INCOME OVERVIEW -->
		
		<div id="incoverview">
		
		<h4 class="headingfortables">Income Overview</h4>
		
		<table id="tbl_id" class="table table-hover">
		          <tr>
		              <th scope="col">Total income in past 10 days</th>
		              <th scope="col">Total income in past 1 month</th>
		              <th scope="col">Total income in past 1 Year</th>
		              <th scope="col">Total income</th>
		          </tr>
		          <tr>
		          	  <td id = "tenIncome"></td>
		          	  <td id = "monIncome"> </td>
		          	  <td id="yearIncome"> </td>
		          	  <td id="totIncome"></td>
		          </tr>
		     
		</table>
		</div>
		
		<!-- DIV FOR Free SPACES OVERVIEW -->
		<h4 class="headingdfortables">Free Spaces in upcoming days</h4>
		<div id="freespaces">
		
		
		
		<div id="freespaces">
		</div>
		
		</div>
	
		
	 </div>
	 <!--END OF INITIAL LOADING  -->
	 
	 
	 
	<div class="main" id="shopBookingdiv" style="display:none;">
	
		<form action="ShopBook" method="post">
		<div>
			Enter customer name: <input type="text" name="customer" required/>
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
						 <div id = "date">
						 Select Date: <input type="text" id ="sdate" name="sdp" onChange="dateChange()" autocomplete="off" />
						 </div>
		
		 <br>
		 
			  <div id = "daysDiv">
			 Select No of days:<input id = "days" type = "number" name="days" max="30">
			 <br>Maximum days to be selected:
					 <div id="dais">
					 </div>
			 </div>
			 
				<div id="atriumDiv">
				select slot:
				<select id = "slot" name = "slot">
				  <option value="" disabled selected>Select Slot</option>
				 </select>
				</div>
		
			<div id ="bannerSpace">
				Select Sqrft:<input id = "sqrft" type = "number" name="sqrft" max="30">
				 		<br>Maximum Sqrft to be selected:
						 <div id="sqrftDiv">
						 </div>
				</div>
				<input type="submit" name="Book" value="Book">
			 </div>
	 </form>
	
	</div>  
	
	
	<div class="main" id="reg_comp_div" style="display:none;">
	
		<form action="Complaint" method="post">
	
		Enter your complaint: <input type="text" id ="complaint" name="complaint"/>
	
		<input type="submit" value="Submit Complaint">
	
		</form>
		
	</div>
	
	
	</div>  
	
	<div class="main" id="inc_rep_div" style="display:none;">
	
		Select start date:<input type="text" id ="inc_rep_sdate" name="sdp" autocomplete="off" />
		
		Select end date:<input type="text" id ="inc_rep_edate" name="edp" autocomplete="off" />
		
		<button onclick="details()" >Get Details</button>
		
		<br><br>
		
		Total income earned in given dates: <span id="total_income"></span>
		
		<br>
		
		<b>Information about Bussiness Spaces booked between given dates</b>
		
		<br>
		
		<div id="shops">
		</div>
	
	</div>  
	
	<!-- ADMIN -->
	<div class="main" id="reg_new_space" style="display:none;">
		
		<form action="CreateSpace" method="post">
					 <div class = "center">
					 <h1>Create new bussiness space</h1>
					 Enter Bussiness Space name: <input type="text" id = "newSpace" name="newSpace"/><br><br>
					 Select Bussiness Space you want to create:
					 <select id="newSpaceType" name="newSpaceType" onChange="newSpaceFun()">
					        	  <option value="" disabled selected>Select Type</option>
					            <option value="shop" >Shop</option>
					            <option value="atrium">Atrium</option>
					            <option value="theatre">Theatre</option>
					            <option value="banner">Marketing Banners</option>
					</select>
					<div id = "newShopDiv">
					<table>
					<tr>
					<td>Weekday:</td>
					<td>rent type:<select id="weekdaySType" name="weekdaySType">
					<option value="" disabled selected>Select Rent Type</option>
					<option value="hour" >Hour</option>
					<option value="day">Day</option>            
					</select></td>
					<td>cost:<input type="number" id="weekdaySCost" name="weekdaySCost"/></td></tr>
					
					<tr>
					<td>Weekend:</td>
					<td>rent type:<select id="weekendSType" name="weekendSType">
					<option value="" disabled selected>Select Rent Type</option>
					<option value="hour" >Hour</option>
					<option value="day">Day</option>            
					</select></td>
					<td>cost:<input type="number" id="weekendSCost" name="weekendSCost"/></td></tr>
					
					<tr>
					<td>Holiday:</td>
					<td>rent type:<select id="holidaySType" name="holidaySType">
					<option value="" disabled selected>Select Rent Type</option>
					<option value="hour" >Hour</option>
					<option value="day">Day</option>            
					</select></td>
					<td>cost:<input type="number" id="holidaySCost" name="holidaySCost"/></td></tr>
					</table>
					</div>
					<div id="other">
					<table>
					<tr>
					<td>Weekday:</td>
					<td>cost:<input type="number" id="weekdayCost" name="weekdayCost"/></td>
					</tr>
					<tr>
					<td>Weekend:</td>
					<td>cost:<input type="number" id="weekendCost" name="weekendCost"/></td>
					</tr>
					<tr>
					<td>Holiday:</td>
					<td>cost:<input type="number" id="holidayCost" name="holidayCost"/></td>
					</tr>
					</table>
					</div>
					<div id="theatreDiv">
					Enter cost: <input type="number" id="tCost" name="tCost"/>
					</div>
					<div id="ban">
					Enter SQRFT for banner: <input type="number" id="sqrft" name="sqrft"/>
					</div>
					
					<input type="submit" value="create">
					
					</div>
				</form>
	</div>  
	
		
	
	<div class="main" id="change_prices" style="display:none;">
				<form action="ChangeRates" method="post">
			<div class = "center">
			
				 <p>Select Space Type:
			        <select id="rateSpaceType" name="rateSpaceType">
			        	  <option value="" disabled selected>Select Type</option>
			            <option value="shop" >Shop</option>
			            <option value="atrium">Atrium</option>
			            <option value="theatre">Theatre</option>
			            <option value="banner">Marketing Banners</option>
			        </select>
			 
			 <div id = "rateSpaceDiv">
			 Select Bussiness Space :
			 <select id = "rateSpace" name = "rateSpace">
			  <option value="" disabled selected>Select Type</option>
			 </select>
			 </div>
			 <br>
			 <div id = "rateTheatreDiv">
			 Current rate is <span id = "theatre_rate"></span>, enter new rate <input type="text" id="new_theatre" name="new_theatre"/><br>
			 </div>
			<div id= "rateOther">
			Weekday current rate is <span id = "weekday_rate"></span>, enter new rate <input type="text" id="new_weekday" name="new_weekday"/><br>
			Weekend current rate is <span id = "weekend_rate"></span>, enter new rate <input type="text" id="new_weekend" name="new_weekend"/><br>
			Holiday current rate is <span id = "holiday_rate"></span>, enter new rate <input type="text" id="new_holiday" name="new_holiday"/>
			</div>
			 <br><br>
			 <input type="submit" name="Update rate" value="Update rate">
			</div>
			 </form>
	</div> 
	
	
	<div class="main" id="create_users" style="display:none;">
		<form action ="Register" method="post">
		Name: <input type="text" name="name" placeholder="Enter name" required>	<br>
		Type: <select id="userType" name="userType">
			        	  <option value="" disabled selected>Select Type</option>
			            <option value="employee" >Employee</option>
			            <option value="admin">Adminstrator</option>
			  </select><br>
		Email ID: <input type="text" name="mailid" placeholder="Email ID" required>	<br>
		Password: <input type="text" name="pass" placeholder="Password" required>	<br>
		Phone: <input type="text" name="phone" placeholder="Phone number" required>	<br>
		What is your favourite city / place? <input type="text" name="question_city" placeholder="Security Question" required><br>
		What is your favourite pet name? <input type="text" name="question_pet" placeholder="Security Question" required><br>
		<div id = "exists"></div>
		<input type="submit"  name="Register" value="Register" >
		</form>
	</div>   
	
 
<!-- SCRIPT -->
<script src = "shopBook.js"></script>
<script src = "js/app.js"></script>
<script src = "createSpace.js"></script>
<script>
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
			document.getElementById("freespaces").innerHTML = responseText;
			
		}
	});
$.ajax({	
		url : 'GetComplaints',
		success : function(responseText) {
			document.getElementById("complaintsDiv").innerHTML = responseText;
		}
	});
	
});
</script>
</body>
</html> 