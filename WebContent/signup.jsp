<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up Form</title>
<script type="text/javascript">
function validate(){
	var name=document.fr1.uname.value;
	if(name.length==0){
		alert("Please enter your name");
		return false;
	}
	var pwd=document.fr1.pass.value;
	if(pwd.length<8){
		alert("Password shuold be 8 character long.")
		return false;
	}
	var cpwd=document.fr1.cpass.value;
	if(cpwd!=pwd){
		alert("Password do not matching.");
		return false;
	}
	var em=document.fr1.mail.value;
	if(em.length==0){
		alert("Please enter your email address.");
		return false;
	}
}
</script>
</head>
<body>
	<%@include file="header.html" %>
	<br/>
	<form action="register" method="post" name="fr1" onsubmit="return validate()">
	<center>
		<h1>User Registration Form</h1>
		<br/>
	</center>
		<table align="center" cellpadding="8" cellspacing="8" bgcolor="lightblue">
			<tr>
				<td>Username: </td>
				<td><input type="text" name="uname"></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass"></td>
			</tr>
			
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="cpass"></td>
			</tr>
			
			<tr>
				<td>Email ID</td>
				<td><input type="text" name="mail"></td>
			</tr>
			
			<tr>
				<td>Security Question</td>
				<td><select name="ques">
					<option>What is your father last name?</option>
					<option>What is your mother name?</option>
					<option>Color you like most is?</option>
					<option>What is your car number?</option>
					<option>Who is your best friend?</option>
				</select></td>				
			</tr>
			
			<tr>
				<td>Answer</td>
				<td><input type="text" name="ans"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Sign up"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>			
			
		</table>
	</form>
	<br/>
	<br/>
	<%@include file="footer.html"%><br/>
	</body>
	</html>
	