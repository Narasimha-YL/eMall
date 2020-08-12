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