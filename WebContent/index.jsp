<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<div>
		<h1 style="margin-left: 30%;">Registration Form</h1>
	</div>
	<form action = "<%= request.getContextPath() %>/Register" name="form" id ="main-form" method="POST">
	<label style="margin-left: 30%;">Select your title:</label>
	<select name = "title" id = "title" required>
		<option value= "Sir">Sir</option>
		<option value= "Mr">Mr</option>
		<option value= "Ms">Ms</option>
		<option value= "Mrs">Mrs</option>
		<option value= "Miss">Miss</option>
		<option value= "Maam">Ma'am</option>
		<option value= "Madam">Madam</option>
	</select><br></br>
	<label style="margin-left: 30%;">Enter your name:*</label><div style="color: #FF0000;margin-left: 30%;">${firstNameError}</div>
	<input style="margin-left: 30%;" type="text" id="firstname" name="firstname" value="${firstname}"><br></br>
	
	<label style="margin-left: 30%;">Enter your surname:*</label><div style="color: #FF0000;margin-left: 30%;">${surnameError}</div>
	<input style="margin-left: 30%;" type="text" id="surname" name="surname" required value="${surname}"><br></br>
	
	<label style="margin-left: 30%;" for="email">Enter your e-mail address:*</label><div style="color: #FF0000;margin-left: 30%;">${emailError}</div>
	<input style="margin-left: 30%;" type="text" id="email" name="email" required value="${email}" placeholder="Enter email">
	<small style="margin-left: 30%;" id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	
	<label style="margin-left: 30%;">Enter your Address:*</label><div style="color: #FF0000;margin-left: 30%;">${addressError}</div>
	<input style="margin-left: 30%;" type="text" id="address" name="address" required value="${address}"><br></br>
	
	<label style="margin-left: 30%;">Enter your Address 2:</label><div style="color: #FF0000;margin-left: 30%;">${addressTwoError}</div>
	<input style="margin-left: 30%;" type="text" id="address-two" name="address-two" value="${addressTwo}"><br></br>
	
	<label style="margin-left: 30%;">Enter your City:*</label><div style="color: #FF0000;margin-left: 30%;">${cityError}</div>
	<input style="margin-left: 30%;" type="text" id="city" name="city" required value="${city}"><br></br>
	
	<label style="margin-left: 30%;">Enter your Postcode:*</label><div style="color: #FF0000;margin-left: 30%;">${postCodeError}</div>
	<input style="margin-left: 30%;" type="text" id="postcode" name="postcode" required value="${postcode}"><br></br>
	
	<label style="margin-left: 30%;">Enter your Telephone number:</label><div style="color: #FF0000;margin-left: 30%;">${phoneError}</div>
	<input style="margin-left: 30%;" type="text" id="telephone" name="telephone" value="${telephone}"><br></br>
	
	<input style="margin-left: 35%;" type="submit" name="Submit" id="submit" value="Submit" disabled = "disabled" class="btn btn-primary">
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
                //console.log("Test Passed!")
            }else{
                $('#submit').attr('disabled', 'disabled');
                //console.log("Test Failed!")
            }
        });
    })()
	</script>
</body>


</html>