function generateForm() 
{
	var input = document.getElementById("number").value;
	if( input <= 0) 
	{
		alert("Input a valid number");
	}
	else 
	{
		var body = document.getElementById("body");
		var table = document.createElement("table");
		var tableBody = document.createElement("tbody");
	  
		var row = document.createElement("tr");
		var column = document.createElement("th");
		var cellText = document.createTextNode("Name");
		column.appendChild(cellText);
		row.appendChild(column);
		
		var column = document.createElement("th");
		var cellText = document.createTextNode("Min");
		column.appendChild(cellText);
		row.appendChild(column);
		
		var column = document.createElement("th");
		var cellText = document.createTextNode("Max");
		column.appendChild(cellText);
		row.appendChild(column);
		tableBody.appendChild(row);
		for(var i = 0; i < input; i++) 
		{
			var row = document.createElement("tr");
			var column = document.createElement("td");
			var cell = document.createElement("input");
			cell.setAttribute("type", "text");
			cell.setAttribute("class", "text");
			cell.setAttribute("placeholder", "Enter name");
			cell.setAttribute("id", ("name"+(i+1)));
			column.appendChild(cell);
			row.appendChild(column);
			
			var column = document.createElement("td");
			var cell = document.createElement("input");
			cell.setAttribute("type", "number");
			cell.setAttribute("class", "min");
			cell.setAttribute("id", ("min"+(i+1)));
			cell.setAttribute("placeholder", "Enter min");
			cell.setAttribute("min","1");
			cell.setAttribute("max", "10");
			column.appendChild(cell);
			row.appendChild(column);
			
			var column = document.createElement("td");
			var cell = document.createElement("input");
			cell.setAttribute("type", "number");
			cell.setAttribute("class", "max");
			cell.setAttribute("id", ("max"+(i+1)));
			cell.setAttribute("placeholder", "Enter max");
			cell.setAttribute("min" ,"1");
			cell.setAttribute("max", "10");
			column.appendChild(cell);
			row.appendChild(column);
			tableBody.appendChild(row);
		}
		var row = document.createElement("tr");
		var column = document.createElement("td");
		row.appendChild(column);
		
		var column = document.createElement("td");
		var cell = document.createElement("input");
		cell.setAttribute("name", "output");
		cell.setAttribute("id", "output");
		cell.setAttribute("type", "submit");
		cell.setAttribute("value", "Click Me");
		cell.setAttribute("onclick","showOutput()");
		column.appendChild(cell);
		
		var cell = document.createElement("input");
		cell.setAttribute("name", "reset");
		cell.setAttribute("id", "resetOutput");
		cell.setAttribute("type", "submit");
		cell.setAttribute("value", "Reset Output");
		cell.setAttribute("onclick","resetOutput()");
		cell.setAttribute("disabled", "disabled");
		column.appendChild(cell);
		row.appendChild(column);
		
		var column = document.createElement("td");
		row.appendChild(column);
		tableBody.appendChild(row);
		table.appendChild(tableBody);
		resultTable.appendChild(table);
		document.getElementById("resultTable").style.border = "3px solid black";
		table.setAttribute("width", "600px");
		table.setAttribute("align", "center");
		document.getElementById("submit").disabled = true;
		document.getElementById("number").disabled = true;
		document.getElementById("reset").disabled = false;
	}
}

function reset() 
{
	resultTable.innerHTML = "";
	outputDiv.innerHTML = "";
	document.getElementById("number").disabled = false;
	document.getElementById("submit").disabled = false;
    document.getElementById("reset").disabled = true;
    document.getElementById("resultTable").style.border = "0px";
}

function showOutput() 
{
	var input = document.getElementById("number").value;
	var flag = false;
	var checkName = /^[a-zA-Z]+$/
	for(var i = 0; i < input; i++) 
	{
		var name = document.getElementById(("name"+(i+1))).value;
		var min = document.getElementById(("min"+(i+1))).value;
		var max = document.getElementById(("max"+(i+1))).value;
		if(name.length == 0 || min <=0 || max <=0 || (checkName.test(name) == false) ) 
		{
			flag = true;
			break;
		}
		else if(max < min+1 || min > 10 || max > 10) 
		{
				flag = true;
				break;	
		}
	}
	
	if(flag) 
	{
		alert("Specify complete valid details")
	}
	else 
	{
		var table = document.createElement("table");
		table.setAttribute("id", "outputTable");
		var tableBody = document.createElement("tbody");
		for(var i = 0; i < input; i++) 
		{
			var row = document.createElement("tr");
			row.setAttribute("class", "outputRow");
			
			var columnName = document.createElement("td");
			columnName.setAttribute("class", "tdName");
			
			var name = document.getElementById(("name"+(i+1))).value;
			var cellText = document.createTextNode(name);
			columnName.appendChild(cellText);
			row.appendChild(columnName);
			
			var min = document.getElementById(("min"+(i+1))).value;
			var max = document.getElementById(("max"+(i+1))).value;
			for(var j = 0; j < 10; j++) 
			{
				var column = document.createElement("td");
				column.setAttribute("class","tData");
				if(j >= min && j <= max) 
				{
					column.setAttribute("id", "red");
				}
				
				row.appendChild(column);
			}
			
			tableBody.appendChild(row);
		}
		
		document.getElementById("output").disabled = true;
		table.appendChild(tableBody);
		table.setAttribute("align", "center");
		
		var outputDiv = document.getElementById("outputDiv");
		outputDiv.appendChild(table);
		document.getElementById("resetOutput").disabled = false;
	}
}

function resetOutput() 
{
	outputDiv.innerHTML = "";
	document.getElementById("output").disabled = false;
	document.getElementById("resetOutput").disabled = true;
}