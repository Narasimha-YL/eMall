$(document).ready(function() {
$(document).on("change", "#spaceType", function(){
	var e = document.getElementById("spaceType");
	var sh = e.options[e.selectedIndex].value;
	if(sh == "shop"){
		document.getElementById("daysDiv").style.display='block';
		document.getElementById("daisDiv").style.display='block';
		document.getElementById("atriumDiv").style.display='none';
		document.getElementById("bannerSpace").style.display='none';}
	else{
		document.getElementById("daysDiv").style.display='none';
		document.getElementById("daisDiv").style.display='none';}
	if(sh == "atrium"){
		document.getElementById("atriumDiv").style.display='block';
		document.getElementById("daysDiv").style.display='none';
		document.getElementById("bannerSpace").style.display='none';
		document.getElementById("daisDiv").style.display='none';}
	else
		document.getElementById("atriumDiv").style.display='none';
	if(sh=="banner"){
		document.getElementById("bannerSpace").style.display='block';
		document.getElementById("atriumDiv").style.display='none';
		document.getElementById("daysDiv").style.display='none';
		document.getElementById("daisDiv").style.display='none';}
	else
		document.getElementById("bannerSpace").style.display='none';
		
	
	$( "#sdate" ).datepicker();
	
	document.getElementById("date").style.display='block';
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
	$.ajax({
		url : 'GetD',
		data : {
			spaceType: $('#spaceType').val(),
			space : $('#space').val()
		},
		success : function(responseText) {		
			arr=responseText.split(',');
		}
	});
 });
});

function dateChange()
{
	var space = document.getElementById("spaceType").value;
 if(space == "shop"){
$(function(){
	$.ajax({
		url : 'GetED',
		data : {
			dt : $('#sdate').val(),
			type :  $('#space').val()
		},
		success : function(responseText) {
			day=responseText;
			$('#dais').html(day);
			var input = document.getElementById("days");
			input.setAttribute("max",day);			
		}
	});
 }); 
}
if(space == "atrium")
	{
	 $(function(){
			$.ajax({
				url : 'Atrium',
				data : {
					date : $('#sdate').val(),
					type :$('#space').val()	
				},
				success : function(responseText) {						
					$('#slot').html(responseText);
				}
			});
		});
	}
if(space == "banner")
	{
	$(function(){
		$.ajax({
			url : 'Banner',
			data : {
				date : $('#sdate').val(),
				type :  $('#space').val()
			},
			success : function(responseText) {
				day=responseText;
				$('#sqrftDiv').html(day);
				var input = document.getElementById("sqrfts");
				input.setAttribute("max",day);			
			}
		});
	 });
	}
}