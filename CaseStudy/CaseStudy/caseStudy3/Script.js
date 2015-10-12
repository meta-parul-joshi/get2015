function searchScript1() {	
	document.getElementById("submitSearch").disabled = true;
	document.getElementById("searchMake").innerHTML = "Make";
	document.getElementById("searchModel").innerHTML = "Model";
	document.getElementById("firstList").innerHTML = "<option value = ''>- - Select Make - -</option><option value = 'hyundai'>Hyundai</option><option value = 'maruti'>Maruti</option><option value = 'ford'>Ford</option>";
	document.getElementById("secondList").innerHTML = "<option value = ''>- - Select Model - -</option><option value = 'verna'>Verna</option><option value = 'ciaz'>Ciaz</option><option value = 'figo'>Figo</option>";
}

function searchScript2() {
	document.getElementById("submitSearch").disabled = true;
	document.getElementById("searchMake").innerHTML = "Min Price";
	document.getElementById("searchModel").innerHTML = "Max Price";
	document.getElementById("firstList").innerHTML = "<option value = ''>- - Select Min Price - -</option><option value = '1Lac'>1 Lac</option><option value = '2Lac'>2 Lac</option><option value = '3Lac'>3 Lac</option>";
	document.getElementById("secondList").innerHTML = "<option value = ''>- - Select Max Price - -</option><option value = '3Lac'>3 Lac</option><option value = '4Lac'>4 Lac</option><option value = '5Lac'>5 Lac</option>";

	}
	
function activeSearch() 
{
	var x = document.getElementById("firstList").value;
	var y = document.getElementById("secondList").value;
	if(x != "" && y != "") 
	{
		document.getElementById("submitSearch").disabled = false;
	}
}

function activeLogin() 
{	
	var x = document.getElementById("username").value;
	var y = document.getElementById("password").value;
	if(x != "" && y != "")
	{
		document.getElementById("submitLogin").disabled = false;
	}
}