<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
    .center {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
#shopDiv,#other,#theatreDiv,#ban{
    display:none;
    }
</style>
<title>Create Space</title>
</head>
<body>
<form action="CreateSpace" method="post">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <div class = "center">
 <h1>Create new bussiness space</h1>
 Enter Bussiness Space name: <input type="text" id = "space" name="space"/><br><br>
 Select Bussiness Space you want to create:
 <select id="spaceType" name="spaceType" onChange="spaceFun()">
        	  <option value="" disabled selected>Select Type</option>
            <option value="shop" >Shop</option>
            <option value="atrium">Atrium</option>
            <option value="theatre">Theatre</option>
            <option value="banner">Marketing Banners</option>
</select>
<div id = "shopDiv">
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
<br><br>
<a href="welcome.jsp">Home</a>
</div>
<script>
function spaceFun()
{
	var e = document.getElementById("spaceType");
	var sh = e.options[e.selectedIndex].value;
	if(sh == "shop")
		{
			document.getElementById("shopDiv").style.display='block';
			document.getElementById("other").style.display='none';
			document.getElementById("theatreDiv").style.display='none';
			document.getElementById("ban").style.display='none';
		}
	else if(sh == "theatre")
		{
			document.getElementById("theatreDiv").style.display='block';
			document.getElementById("shopDiv").style.display='none';
			document.getElementById("other").style.display='none';
			document.getElementById("ban").style.display='none';
		}
	else if (sh == "banner")
		{
		document.getElementById("theatreDiv").style.display='none';
		document.getElementById("shopDiv").style.display='none';
		document.getElementById("other").style.display='block';
		document.getElementById("ban").style.display='block';
		
		}
	else
		{
			document.getElementById("theatreDiv").style.display='none';
			document.getElementById("shopDiv").style.display='none';
			document.getElementById("ban").style.display='none';
			document.getElementById("other").style.display='block';
		}
}
</script>
</form>
</body>
</html>