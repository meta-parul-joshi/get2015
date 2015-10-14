function validation()
{
	var alertMessage = "";

	alertMessage = alertMessage.concat(validateFirstName());

	alertMessage = alertMessage.concat(validateLastName());

	alertMessage = alertMessage.concat(validatePassword());

	alertMessage = alertMessage.concat(validateConfirmPassword());

	alertMessage = alertMessage.concat(validateAge());

	if(alertMessage == "")
	{
		alert("User created successfull.");
	}
	else
	{
		alert(alertMessage);
	}	
}

function stateChanged(state)
{
	var citiesMP=["Indore", "Bhopal","Gwalior","Jabalpur"];
	var citiesUP=["Lakhnow", "Agra","Jhansi","Mathura"];
	var citiesRajasthan=["Bhilwara", "Jaipur","Ajmer","Udaipur"];
	var citiesMaharastra=["Mumbai", "Pune","Nagpur","Thane"];
	var selectCity = document.getElementById('cities');
	var length = selectCity.length - 1;
	while(length > 0)
	{
		selectCity.remove(1);
		length--;
	}
	var citiesArray;

	switch(state)
	{
	case "MP":
		citiesArray=citiesMP
		break;
	case "UP":
		citiesArray=citiesUP
		break;
	case "Rajasthan":
		citiesArray=citiesRajasthan
		break;
	case "Maharastra":
		citiesArray=citiesMaharastra
		break;
	default:
	}

	for (i = 0; i < citiesArray.length; i++)
	{
		var option = document.createElement('option');
		option.text = citiesArray[i];
		option.value = citiesArray[i];
		selectCity.add(option);
	}
}
function enableButton()
{
	var submitButton = document.getElementById("submitButton");
	var acceptCondition = document.getElementById("acceptCondition");
	if (acceptCondition.checked == true)
	{
		submitButton.disabled = false;
	}
	else
	{
		submitButton.disabled = true;
	}
}

function validateFirstName()
{
	var message = "";
	var checkName =  /^[A-Za-z]+$/;
	var firstName = document.getElementById("txtFirstName").value;
	if(firstName.length==0)
	{
		message = message.concat("Please specify first name of person.\n");		
	}
	else if(checkName.test(firstName) == false )
	{
		message = message.concat("First name can only contain characters.\n");
	}

	return message;
}

function validateLastName()
{
	var message = "";
	var checkName =  /^[A-Za-z]+$/;
	var lastName = document.getElementById("txtLastName").value;
	if(lastName.length==0)
	{
		message = message.concat("Please specify last name of person.\n");	
	}
	else if(checkName.test(lastName) == false)
	{
		message = message.concat("Last name can only contain characters.\n");
	}

	return message;
}

function validatePassword()
{
	var message = "";
	var password = document.getElementById("password").value;
	if(password.length==0)
	{
		message = message.concat("Please provide password.\n");	
	}
	else if(password.length < 8)
	{
		message = message.concat("Password should have minimum 8 characters.\n");		
	}

	return message;
}

function validateConfirmPassword()
{
	var message = "";
	var password = document.getElementById("password").value;
	var reTypePassword = document.getElementById("ConfirmPassword").value;
	if(reTypePassword.length==0)
	{
		message = message.concat("Please confirm password.\n");		
	}
	else if((password==reTypePassword) == false)
	{
		message = message.concat("Confirm password does not match.\n");
	}
	return message;
}

function validateAge()
{ 
	var message = "";
	var checkAge =  /^[0-9.]/;
	var age = document.getElementById("txtAge").value;
	if(age.length==0)
	{
		message = message.concat("Please specify age of person.\n");		
	}
	else if(checkAge.test(age) == false)
	{
		message = message.concat("Age contains only numbers and decimal.\n");		
	}
	return message;
}

function showHidePassword(value)
{
	var password = document.getElementById('password');
	if(value.checked == true)
	{
		password.type = 'text' ;
	} 
	else
	{
		password.type = 'password';
	}
}
