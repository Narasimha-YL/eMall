<%@ page import ="java.io.*"%>
<%@ page import ="java.io.File.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>


<html>
    <head>
    <style>
    #date,#daysDiv,#bannerSpace,#atriumDiv{
    display:none;
    }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
     <!--jQuery-->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
   
    
     <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
     
    
     
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	
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
	 

</script>



</head>
    <title>Booking</title>
<body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    


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
 
 <script src = "shopBook.js"></script>
 </body>
</html>