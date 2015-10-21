<!DOCTYPE html>
<html>
	<head>
		<title> Registration </title>
		<link rel = "stylesheet" type = "text/css" href = "css/style2.css" >
		<script type = "text/javascript" src = "js/registerscript.js"></script>
	</head>
	<body>
		<fieldset>
			<legend> :: Registration :: </legend>
			<form id = "myform" action = "Registration" method = "post">	
				<table>
					<tr>
						<td>
							Enter UserName:<span>*</span>
						</td>
						<td>
							<input id = "username" class = "text" type = "text" name = "username" pattern = "[a-z|A-Z|0-9]*" placeholder = "Enter Username"/>
						</td>
					</tr>
					<tr>
						<td>
							Enter Email:<span>*</span>
						</td>
						<td>
							<input id = "email" class = "text" type = "email" name = "email" placeholder = "Enter Email"/>
						</td>
					</tr>
					<tr>
						<td>
							Enter Password:<span>*</span>
						</td>
						<td>
							<input id = "password" class = "text" type = "password" name = "password" placeholder = "Enter Password"/>
						</td>
					</tr>
					<tr>
						<td>
							Re-Enter Password:<span>*</span>
						</td>
						<td>
							<input id = "confirmPassword" class = "text" type = "password" name = "confirmPassword" placeholder = "Re-Enter Password"/>
						</td>
					</tr>
					<tr>
					<td colspan = "2">
						<input type = "submit" value = "Submit" id = "submitbutton" onclick = "return validate()"/>
					</td>
					</tr>
				</table>
				<label>
					${a}
				</label>
			</form>
			<a href = "login.jsp">Already Registered...<b>Log In</b></a>
		</fieldset>
	</body>
</html>
