function validate() {
	var flag = true;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if(username == "") {
		alert("User Name can't be empty");
		flag = false;
	}
	else {
		if(password == "") {
			alert("Passwords can't be empty");
			flag = false;
		}
	}
	return flag;
}
