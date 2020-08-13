<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1" name="viewport" />    
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome</title>

<style>

.effect-16{border: 0; padding: 4px 0; border-bottom: 1px solid #ccc; background-color: transparent;}


.effect-16 ~ .focus-border{position: absolute; bottom: 0; left: 0; width: 0; height: 2px; background-color: #3399FF; transition: 0.4s;}
.effect-16:focus ~ .focus-border,
.has-content.effect-16 ~ .focus-border{width: 100%; transition: 0.4s;}
.effect-16 ~ label{position: absolute; left: 0; width: 100%; top: 9px; color: #aaa; transition: 0.3s; z-index: -1; letter-spacing: 0.5px;}
.effect-16:focus ~ label, .has-content.effect-16 ~ label{top: -16px; font-size: 12px; color: #3399FF; transition: 0.3s;}

</style>

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
	 
 
//JavaScript for label effects only
$(window).load(function(){
	$(".col-3 input").val("");
	
	$(".input-effect input").focusout(function(){
		if($(this).val() != ""){
			$(this).addClass("has-content");
		}else{
			$(this).removeClass("has-content");
		}
	})
});
</script>

<style>
    #date,#daysDiv,#daisDiv,#bannerSpace,#atriumDiv,#shopDiv,#other,#theatreDiv,#ban,#rateTheatreDiv,#rateOther{
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
<h4 id="titl">
A B C Entertainment and Real Estate Pvt Ltd.
 </h4>
<div id="formlogout">
<form action="Logout" id="Logoutsection" method="post">
<button class="btn" type="submit" value="Logout">Logout <i class="fa fa-sign-out" aria-hidden="true"></i></button>
</form>
</div>
</div>

</div>

<div id="sidandmain">
<div class="sidenav">
  <button onclick="location.reload();"> Home </button>
	
  <button class="sidnav-buttons" value="shopBookingdiv" id="book_a_shop"> Book A Shop </button>
  
  <button class="sidnav-buttons" value="reg_comp_div" id="reg_a_comp"> Register A Complaint </button>
  
  <button class="sidnav-buttons" value="inc_rep_div" id="inc_rep"> Income Report</button>
  
   <% if(session.getAttribute("role")==null); 
   else if(session.getAttribute("role").equals("admin")){%>
  <button class="sidnav-buttons" value="reg_new_space" id="create_space"> Create New Bussiness Space</button>
  
  <button class="sidnav-buttons" value="change_prices" id="change_price"> Change Space Cost </button>
  
  <button class="sidnav-buttons" value="create_users" id="create_user"> Create User </button>
  <%}%>
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
		<h4 class="headingfortables">Free Spaces in upcoming days</h4>
		<div id="freespaces">
		
		
		
		<div id="freespaces">
		</div>
		
		</div>
	
		
	 </div>
	 <!--END OF INITIAL LOADING  -->
	 
	 
	 
	<div class="main" id="shopBookingdiv" style="display:none;">
	<center>
		<form action="ShopBook" method="post" autocomplete="off">
		<div>
		
		
     	
     	<div class="row">
     	<p >
     		<span>Enter customer name:</span>
     	</p>
     	
     	<p>	
        	<input class="effect-2" type="text" name="customer" placeholder="Customer Name" required>
            <!-- <span class="focus-border"></span> -->
          </p>  
        </div>
        
		<div class="row">	 
		<p>
			 <span>Select Space Type:</span>
		</p>	
			  <p>
		        <select id="spaceType" name="spaceType"  class="btn">
		        	  <option value="" disabled selected>Select Type</option>
		            <option value="shop" >Shop</option>
		            <option value="atrium">Atrium</option>
		            <option value="theatre">Theatre</option>
		            <option value="banner">Marketing Banners</option>
		        </select>
		       </p>
		 </div>
		 
			<div class="row">			 
					<p>	<span> Select Bussiness Space:</span></p>
					<p>
						  <select class="btn" id = "space" name = "space">
						  <option value="" disabled selected>Select Type</option>
						 </select>
					</p>
			</div>	
			<div class="row" id = "date">
			<p><span>Select Date:</span></p>
				
				 <p>
				 <input type="text" id ="sdate" name="sdp" onChange="dateChange()" autocomplete="off" />
				 </p>
				
			</div>
			<div class="row" id = "daysDiv">
		 	<p><span>Select No of days:</span></p>

			  <p>
			 <input id = "days" type = "number" name="days" max="30" placeholder="max days">
			</p>

			 </div>
			 <div class="row" id="daisDiv"> 
			 <p><span>Maximum days to be selected:</span></p>
					 <p id="dais"></p>
			 </div>
			 
			 <div class="row" id="atriumDiv">
				
			<p><span>select slot:</span></p>
				<p>
				<select id = "slot" name = "slot" class="btn">
				  <option value="" disabled selected>Select Slot</option>
				 </select>
				 </p>	
			</div>
			 <div class="row" id ="bannerSpace">
			<p><span>Select Sqrft :</span> </p>
			<p>
				<input id = "sqrft" type = "number" name="sqrft" max="30">
				 		<br>Maximum Sqrft to be selected:
						 <div id="sqrftDiv">
						 </div>
			</div>
				<input class="btn btn-outline-success" type="submit" name="Book" value="Book">
			 </div>
			 
	 </form>
	</center>
	</div>  
	
	
	<div class="main" id="reg_comp_div" style="display:none;">
	<center>
		<div class="row">
		<p><span>Enter your complaint:</span></p>
		
		<form id="compf" action="Complaint" method="post">
		<p>
		 <input type="text" id ="complaint" name="complaint"/>
		 </p>
		 
		</form>
		
		</div>
		<br>
		<input form="compf"  type="submit" value="Submit Complaint">
		
	</center>	
	</div>
	
	
	
	<div class="main" id="inc_rep_div" style="display:none;">
	<center>
	<div class="row">
	<p><span>
		Select start date:</span>
		</p>
		<p>
		<input type="text" id ="inc_rep_sdate" name="sdp" autocomplete="off" />
		</p>
	</div>
	<div class="row">
	<p><span>
		Select end date:
		</span>
		</p>
		<p>
		<input type="text" id ="inc_rep_edate" name="edp" autocomplete="off" />
		</p>
		</div>
		<br>
		<button class="btn" onclick="details()" >Get Details</button>
		<br>
		
	<div class="row">
		<p>
		<span>
		Total income earned in given dates:
		</span>
		</p>
		<p>
		 <span id="total_income"></span>
		 
		 </p>
		</div>
		
		<br><br>
		<b id="normalfont">Information about Bussiness Spaces booked between given dates</b>
	
		<div id="shops">
		</div>
		
		</center>
	</div>
	 
	 <% if(session.getAttribute("role")==null); 
   else if(session.getAttribute("role").equals("admin")){%>
	<!-- ADMIN -->
	<div class="main" id="reg_new_space" style="display:none;">
		<center>
		<form action="CreateSpace" method="post">
		
		<div>
					
					 
					 Enter Bussiness Space name: <input type="text" id = "newSpace" name="newSpace"/>
					<br>
					 Select Bussiness Space you want to create:
					 <select id="newSpaceType" name="newSpaceType" class="btn" onChange="newSpaceFun()">
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
					<td>rent type:<select id="weekdaySType" name="weekdaySType" class="btn">
					<option value="" disabled selected>Select Rent Type</option>
					<option value="hour" >Hour</option>
					<option value="day">Day</option>            
					</select></td>
					<td>cost:<input type="number" id="weekdaySCost" name="weekdaySCost"/></td></tr>
					
					<tr>
					<td>Weekend:</td>
					<td>rent type:<select id="weekendSType" name="weekendSType" class="btn">
					<option value="" disabled selected>Select Rent Type</option>
					<option value="hour" >Hour</option>
					<option value="day">Day</option>            
					</select></td>
					<td>cost:<input type="number" id="weekendSCost" name="weekendSCost"/></td></tr>
					
					<tr>
					<td>Holiday:</td>
					<td>rent type:<select id="holidaySType" name="holidaySType" class="btn">
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
	</center>			
	</div>  

	
	
	<div class="main" id="change_prices" style="display:none;">
				<form action="ChangeRates" method="post">
			<div class = "center">
			
				 <p>Select Space Type:
			        <select id="rateSpaceType" name="rateSpaceType" class="btn">
			        	  <option value="" disabled selected>Select Type</option>
			            <option value="shop" >Shop</option>
			            <option value="atrium">Atrium</option>
			            <option value="theatre">Theatre</option>
			            <option value="banner">Marketing Banners</option>
			        </select>
			 
			 <div id = "rateSpaceDiv">
			 Select Bussiness Space :
			 <select id = "rateSpace" name = "rateSpace" class="btn">
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
		<div class="row">
		<p><span>Name:</span></p>
		<p><input type="text" name="name" placeholder="Enter name" required>	 </p>
		</div>
		<div class="row">
		 <p><span>Type:</span></p>
		 <p> <select id="userType" name="userType" class="btn">
			        	  <option value="" disabled selected>Select Type</option>
			            <option value="employee" >Employee</option>
			            <option value="admin">Adminstrator</option>
			  </select>

		</p>
		</div>
		<div class="row">
		<p><span>Email ID:</span></p>
		<p> <input type="text" name="mailid" placeholder="Email ID" required/>	 </p>
		</div>
		<div class="row">
		<p><span>
		Password:
		</span></p>
		<p> <input type="text" name="pass" placeholder="Password" required>	</p>
		</div>
		<div class="row">
		<p><span>
		Phone:
		</span></p>
		<p>
		 <input type="text" name="phone" placeholder="Phone number" required>
		</p>
		</div>
		<div class="row">
		<p><span>
		What is your favourite city / place?
		</span></p>
		<p>
		 <input type="text" name="question_city" placeholder="Security Question" required></p>
		 </div>
		<div class="row">
		<p><span>
		What is your favourite pet name?
		</span></p>
		<p>
		<input type="text" name="question_pet" placeholder="Security Question" required>
		</p>
		</div>
		
		<div id = "exists"></div>
		<br>
		
		<input type="submit"  name="Register" value="Register" >
		</form>
		
	</div> 
	<%} %>  
	</div>
	</div>
	
 
<!-- SCRIPT -->
<script src = "js/shopBook.js"></script>
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


<%-- <% String uid=String.valueOf(session.getAttribute("uid")); %>
<script>
const uid = '${uid}';

</script>
 --%>
</body>
</html> 