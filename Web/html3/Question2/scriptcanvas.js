function myCanvas() 
{
	var c = document.getElementById("myCanvasw");
	var ctx = c.getContext("2d");
	var img = document.getElementById("scream");
	ctx.drawImage(img,10,10);
}
				
function drawCircle()
{
	var c = document.getElementById("circleCanvas");
	var ctx = c.getContext("2d");
	ctx.beginPath();
	ctx.arc(95,50,40,0,2*Math.PI);
	ctx.stroke();
}

function canvasRectangleGradient()
{
	var c = document.getElementById("canvasRectangleGradient");
	var ctx = c.getContext("2d");
	var grd = ctx.createRadialGradient(75,50,5,90,60,100);
	grd.addColorStop(0,"red");
	grd.addColorStop(1,"white");
	ctx.fillStyle = grd;
	ctx.fillRect(10,10,150,80);
}

function canvasRectangle()
{
	var c = document.getElementById("canvasRectangle");
	var ctx = c.getContext("2d");
	ctx.fillStyle = "#FF0000";
	ctx.fillRect(0,0,150,75);	
}

function canvasText()
{
	var c = document.getElementById("canvasText");
	var ctx = c.getContext("2d");
	ctx.font = "30px Arial";
	ctx.fillText("Canvas",10,50);
}