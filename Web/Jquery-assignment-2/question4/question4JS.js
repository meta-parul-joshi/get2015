$(document).ready(init);


function init()
{
	
	$('#txtName').focus(applyFocus);
	
    $('#txtName').blur(blurControl);
	
	$('#txtAge').focus(applyFocus);
	
    $('#txtAge').blur(blurControl);
	
	$('#address').focus(applyFocus);
	
    $('#address').blur(blurControl);
}

function applyFocus()
{
	$(this).addClass("red");
}

function blurControl()
{
	$(this).removeClass("red");
	$(this).css({'background-color': 'yellow'}).animate({opacity: 1}, 'slow', normal );
	$('#displayDiv').html($(this).prop("name")+": "+$(this).val());
}

function normal() 
	{
	$(this).css({'background-color': 'white'});
	}