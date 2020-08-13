<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>AeroParker Registration</title>
</head>
<body>
	
	<div>
		<h1>Registration Form</h1>
	</div>
	<form action = "<%= request.getContextPath() %>/UserRegister" name="form" id = "main-form" method = "POST">
	<label>Select your title:</label>
	
	<select name = "title" id = "title" required>
		<option value= "Sir">Sir</option>
		<option value= "Mr">Mr</option>
		<option value= "Ms">Ms</option>
		<option value= "Mrs">Mrs</option>
		<option value= "Miss">Miss</option>
		<option value= "Maam">Ma'am</option>
		<option value= "Madam">Madam</option>
	</select>
	<div class="form-group-row">
	<label>Enter your name:*</label><div style="color: #FF0000;">${firstNameError}</div>
	<input type="text" id="firstname" name="firstname" value="${firstname}"><br></br>
	</div>
	
	<div class="form-group-row">
	<label>Enter your surname:*</label><div style="color: #FF0000;">${surnameError}</div>
	<input type="text" id="surname" name="surname" required value="${surname}"><br></br>
	</div>
	
	<div class="form-group">
	<label for="email">Enter your e-mail address:*</label><div style="color: #FF0000;">${emailError}</div>
	<input type="text" id="email" name="email" required value="${email}" placeholder="Enter email">
	<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	</div>
	
	<label>Enter your Address:*</label><div style="color: #FF0000;">${addressError}</div>
	<input type="text" id="address" name="address" required value="${address}"><br></br>
	
	<label>Enter your Address 2:</label><div style="color: #FF0000;">${addressTwoError}</div>
	<input type="text" id="address-two" name="address-two" value="${addressTwo}"><br></br>
	
	<label>Enter your City:*</label><div style="color: #FF0000;">${cityError}</div>
	<input type="text" id="city" name="city" required value="${city}"><br></br>
	
	<label>Enter your Postcode:*</label><div style="color: #FF0000;">${postCodeError}</div>
	<input type="text" id="postcode" name="postcode" required value="${postcode}"><br></br>
	
	<label>Enter your Telephone number:</label><div style="color: #FF0000;">${phoneError}</div>
	<input type="number" id="telephone" name="telephone" value="${telephone}"><br></br>
	
	<input type="submit" name="Submit" id="submit" value="Submit" disabled = "disabled" class="btn btn-primary">
	</form>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript">
    (function (){
        $('form > input').keyup(function() {
            var name = document.getElementById("firstname").value
            var surname = document.getElementById("surname").value
            var email = document.getElementById("email").value
            var address = document.getElementById("address").value
            var city = document.getElementById("city").value
            var postcode = document.getElementById("postcode").value

            if(name !== "" && surname !== "" && email !== "" && address !== "" && city !== "" && postcode !== ""){
                $('#submit').removeAttr('disabled');
                console.log("Test Passed!")
            }else{
                $('#submit').attr('disabled', 'disabled');
                console.log("Test Failed!")
            }
        });
    })()
	</script>
</body>


</html>