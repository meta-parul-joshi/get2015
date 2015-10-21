<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style2.css">
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
	<fieldset>
		<legend> ::Login:: </legend>
		<form id="myform" action="LoginValidation" method="post">
			<table>
				<tr>
					<td>Enter User Name:<span id="span">*</span>
					</td>
					<td><input id="username" class="text" type="text"
						name="username" pattern="[a-zA-Z]{2,}"
						placeholder="Enter Username" /></td>
				</tr>
				<tr>
					<td>EnterPassword:<span id="span">*</span>
					</td>
					<td><input id="password" class="text" type="password"
						name="password" placeholder="Enter Password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Login"
						id="submitbutton" onclick="return validate()" /></td>
				</tr>
			</table>
			<label>${a}</label>
		</form>
		<a href="index.jsp">NewUser...<b>Register</b>
		</a>
	</fieldset>
</body>
</html>