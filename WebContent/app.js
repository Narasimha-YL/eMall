//global
var activediv;
var curid;
var unhidediv;
function currentdiv() {
    $(".main").each( function(){
        if($(this).is(':visible')){
           activediv=$(this).attr("id");
        }
});
}

/*Hide unhide Div ELEMENTS IN MAIN CLASS*/
$(document).on("click", ".sidnav-buttons", function() {
		currentdiv();
		curid="#"+activediv;
		$(curid).hide();
		unhidediv="#"+this.value
		$(unhidediv).show();
	
});

/*Function to get Information of spaces and income between given dates*/
function details()
{
	$(document).ready(function(){
		$.ajax({
			
			url : 'InfoBetween',
			data : {
				type : "income",
				start_date : $('#inc_rep_sdate').val(),
				end_date : $('#inc_rep_edate').val()
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
				start_date : $('#inc_rep_sdate').val(),
				end_date : $('#inc_rep_edate').val()
			},
			success : function(responseText) {
				document.getElementById("shops").innerHTML = responseText;
				
			}
		});
		
	});
}


function newSpaceFun()
{
	
	var e = document.getElementById("newSpaceType");
	var sh = e.options[e.selectedIndex].value;
	if(sh == "shop")
		{
			document.getElementById("newShopDiv").style.display='block';
			document.getElementById("other").style.display='none';
			document.getElementById("theatreDiv").style.display='none';
			document.getElementById("ban").style.display='none';
		}
	else if(sh == "theatre")
		{
			document.getElementById("theatreDiv").style.display='block';
			document.getElementById("newShopDiv").style.display='none';
			document.getElementById("other").style.display='none';
			document.getElementById("ban").style.display='none';
		}
	else if (sh == "banner")
		{
		document.getElementById("theatreDiv").style.display='none';
		document.getElementById("newShopDiv").style.display='none';
		document.getElementById("other").style.display='block';
		document.getElementById("ban").style.display='block';
		
		}
	else
		{
			document.getElementById("theatreDiv").style.display='none';
			document.getElementById("newShopDiv").style.display='none';
			document.getElementById("ban").style.display='none';
			document.getElementById("other").style.display='block';
		}
}

$(document).ready(function() {
$(document).on("change", "#rateSpaceType", function(){
	$.ajax({
		url : 'getSpaces',
		data : {
			type : $('#rateSpaceType').val()
		},
		success : function(responseText) {
				
			$('#rateSpace').html(responseText);
			
		}
	});
 });
 
$(document).on("change", "#rateSpace", function(){
	var e = document.getElementById("rateSpaceType");
	var sh = e.options[e.selectedIndex].value;
	
	if(sh == "theatre")
		{
		document.getElementById("rateOther").style.display='none';
		document.getElementById("rateTheatreDiv").style.display='block';
		document.getElementById("new_weekday").required = false;
		document.getElementById("new_weekend").required = false;
		document.getElementById("new_holiday").required = false;
		document.getElementById("new_theatre").required = true;
		$.ajax({
			url : 'GetRates',
			data : {
				space : $('#rateSpace').val(),
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
		document.getElementById("rateOther").style.display='block';
		document.getElementById("rateTheatreDiv").style.display='none';
		document.getElementById("new_weekday").required = true;
		document.getElementById("new_weekend").required = true;
		document.getElementById("new_holiday").required = true;
		document.getElementById("new_theatre").required = false;
		$.ajax({
			url : 'GetRates',
			data : {
				space : $('#rateSpace').val(),
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
