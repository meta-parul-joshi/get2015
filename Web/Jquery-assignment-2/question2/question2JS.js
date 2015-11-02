$(document).ready(init);

function init()
{
    $("#startBtn").click(leftToRightFloating);
	
	$("#stopBtn").click(stopFloating);
	
	 $("#backBtn").click(rightToLeftFloating);
	
	 $("#leftBtn").click(moveLeft);
	
	 $("#rightBtn").click(moveRight);
	
	 $("#topBtn").click(moveTop);
	
	 $("#bottomBtn").click(moveBottom);
}

function leftToRightFloating()
{
	var box = $("#divBox");
	var position = box.position();
	if(position.left < 950)
	{
		$("#divBox").animate({left: "+=500px"}, "slow");
	}
   else
	{
		$("#divBox").animate({left: "1443px"}, "slow");
	}
}

function stopFloating()
{
	$("#divBox").stop();
}

function rightToLeftFloating()
 {
	var box = $("#divBox");
	var position = box.position();
	if(position.left > 501)
	{
		$("#divBox").animate({left: '-=500px'}, "slow");
	}
	else
	{
		$("#divBox").animate({left: '0px'}, "slow");
	}
}

function moveLeft()
{
	var box = $("#divBox");
	var position = box.position();
	if(position.left > 50)
	{
		$("#divBox").animate({left: '-=50px'} , "slow");
	}
	else
	{
		$("#divBox").animate({left: '0px'}, "slow");
	}
}

function moveRight()
{
	var box = $("#divBox");
	var position = box.position();
	if(position.left < 1390)
	{
		$("#divBox").animate({left: '+=50px'} , "slow");
	}
	else
	{
		$("#divBox").animate({left: '1443px'}, "slow");
	}
	
}

function moveTop()
{
	var box = $("#divBox");
	var position = box.position();
	if(position.top > 224)
	{
		$("#divBox").animate({top: '-=50px'}, "slow");
	}
	else
	{
		$("#divBox").animate({top:'0px'}, "slow");
	}
}

function moveBottom()
{
	var box = $("#divBox");
	var position = box.position();
	if(position.top < 740)
	{
		$("#divBox").animate({top: '+=50px'}, "slow");
	}
	else
	{
		$("#divBox").animate({top: '573px'}, "slow");
	}
}