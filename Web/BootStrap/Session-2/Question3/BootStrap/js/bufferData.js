/**
 * 
 */

function loadData(){
	
var contentArray=[];


var movie1 = {Title:"2States", Genere:"Romantic", Director:"Parul", Review  : "Best", Rating : "Best ever"};

var movie2 = {Title:"Yeh jawani hai deewani", Genere:"Romantic", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie3 = {Title:"Golmaal", Genere:"Comedy", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie4 = {Title:"Golmaal returns", Genere:"Comedy", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie5 = {Title:"Sholey", Genere:"Thriller", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie6 = {Title:"Pyar ka Panchnama", Genere:"Drama", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie7 = {Title:"DDLJ", Genere:"Romantic", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie8 = {Title:"MP3", Genere:"Romantic", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie9 = {Title:"Wanted", Genere:"Action", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie10 = {Title:"Ready", Genere:"Comedy-Action", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie11 = {Title:"PK", Genere:"Drama", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie12 = {Title:"Dhoom", Genere:"Action", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie13 = {Title:"Dhoom2", Genere:"Action", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie14 = {Title:"Dhoom3", Genere:"Action", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie15 = {Title:"Don", Genere:"Action", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie16 = {Title:"Don2", Genere:"Action", Director:"Parul", Review  : "Good", Rating : "Best ever"};

var movie17 = {Title:"Golmaal3", Genere:"Action", Director:"Parul", Review  : "Good", Rating : "Best ever"};

contentArray.push(movie1);
contentArray.push(movie2);
contentArray.push(movie3);
contentArray.push(movie4);
contentArray.push(movie5);
contentArray.push(movie6);
contentArray.push(movie7);
contentArray.push(movie8);
contentArray.push(movie9);
contentArray.push(movie10);
contentArray.push(movie11);
contentArray.push(movie12);
contentArray.push(movie13);
contentArray.push(movie14);
contentArray.push(movie15);
contentArray.push(movie16);
contentArray.push(movie17);
	
var tbody = document.getElementById('mytableTbody');
for (var i = 0; i < contentArray.length; i++) {
	var tr = "<tr>";
	tr += "<td>" + contentArray[i].Title + "</td>" + "<td>" + contentArray[i].Genere + "</td>" + "<td>" + contentArray[i].Director + "</td>" + "<td>" + contentArray[i].Review + "</td>" + "<td>" + contentArray[i].Rating + "</td>" + "</tr>";
	tbody.innerHTML += tr;
}
}