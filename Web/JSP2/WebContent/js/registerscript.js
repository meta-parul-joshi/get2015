
function validate() {
	var resultvalidation = false;
	var username = document.getElementById("username").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	if(username == "") {
		alert("Username can't be empty")
	}
	else {
		if(email == "") {
			alert("Email can't be empty");
		}
		else {
			if(password == "") {
				alert("Passwords can't be empty");
			}
			else if(password.length < 8) {
				alert("password must be at least 8 characters long");
			}
			else {
				if(confirmpassword == "") {
					alert("Re-type Password");
				}
				else {
					if(password != confirmpassword) {
						alert("Password Doesn't match");
					}
					else {
						alert("user Created Successfully");
						resultvalidation = true;
					}
				}
			}
		}
	}
	
	return resultvalidation;
}	

