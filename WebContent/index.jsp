<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AeroParker Registration</title>
</head>
<body>
	<div>
		<h1>Registration Form</h1>
	</div>
	<form action = "Register" class= "" id = "main-form" method = "POST">
	<label>Select your title:</label>
	<select name = "title" id = "title">
		<option value= "Sir">Sir</option>
		<option value= "Mr">Mr</option>
		<option value= "Ms">Ms</option>
		<option value= "Mrs">Mrs</option>
		<option value= "Miss">Miss</option>
		<option value= "Maam">Ma'am</option>
		<option value= "Madam">Madam</option>
	</select><br></br>
	<label>Enter your name:</label>
	<input type="text" id="first-name" name="first-name"><br></br>
	<label>Enter your surname:</label>
	<input type="text" id="surname" name="surname"><br></br>
	<label>Enter your e-mail address:</label>
	<input type="text" id="e-mail" name="e-mail"><br></br>
	<label>Enter your Address:</label>
	<input type="text" id="address" name="address"><br></br>
	<label>Enter your Address 2:</label>
	<input type="text" id="address-2" name="address-2"><br></br>
	<label>Enter your City:</label>
	<input type="text" id="city" name="city"><br></br>
	<label>Enter your Postcode:</label>
	<input type="text" id="postcode" name="postcode"><br></br>
	<label>Enter your Telephone number:</label>
	<input type="number" id="telephone" name="telephone"><br></br>
	<input type="submit" name="Submit" id="submit" value="Submit">
	</form>
</body>
</html>