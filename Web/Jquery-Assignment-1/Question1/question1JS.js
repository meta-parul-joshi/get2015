function toggle()
{
	var s = document.getElementById('spn');
	var dis = s.style.display;
	var btnclick = document.getElementById('btn');
	if(dis == 'block')
	{
		s.style.display = 'none';
		btnclick.innerHTML = 'SHOW';
	}
	else
	{
		s.style.display = 'block';
		btnclick.innerHTML = 'HIDE';
	}
}

function button2Action()
{
	var s = document.getElementById('spn');
	var dis = s.style.display;
	var btnclick = document.getElementById('btn');
	if(dis == 'none')
	{
		s.style.display = 'block';
		btnclick.innerHTML = 'HIDE';
	}
}
function button1Action()
{
	var s = document.getElementById('spn');
	var dis = s.style.display;
	var btnclick = document.getElementById('btn');
	if(dis == 'block')
	{
		s.style.display = 'none';
		btnclick.innerHTML = 'SHOW';
	}
}