$(document).ready(function()
{
    $("#btn2").on('click',showTxt);
	
	$("#btn1").on('click',hideTxt);
	
	$("#btn").on('click',toggleButten);
		
});

function showTxt()
{
	$("#spn").show();
	$("#btn").html("HIDE");
}

function hideTxt()
{
	$("#spn").hide();
	$("#btn").html("SHOW");
}

function toggleButten()
{
	if($("#spn").css("display") == "block")
	{  $("#spn").hide();
		$("#btn").html("SHOW");
	}
	else
	{
		$("#spn").show();
		$("#btn").html("HIDE");
	}
}