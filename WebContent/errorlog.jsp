<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
	function valid(){
		var name=document.form1.uname.value;
		var pass=document.form1.upass.value;
		
		if(name.length==0){
			alert("Please enter your username.");
			name.focus=true;
			return false;
		}
		
		if(pass.length==0){
			alert("Please enter your password.");
			name.focus=true;
			return false;
		}
	}
</script>
</head>
<body>

	<div id="header">																																																																																			
		<div class="login">
		<h4 style="color: red;">Username or password you have entered is not correct.</h4>
			<form action="Log" method="post" name="form1" onsubmit="return valid()">
			<input type="text" class="input"  name="uname" /> 
			<input type="password" class="input"  name="upass" />																																			
			<div><input type="submit" value="Submit"></div>			
			</form>
		</div>
		<ul id="menu">
			<li><a href="home.jsp">Home page</a></li>
			<li><a href="about.html">About us</a></li>
			<li><a href="Pack.jsp">Packages</a></li>
			<li><a href="hot.jsp">Hot Tours</a></li>
			<li><a href="signup.jsp">Sign up</a></li>
			<li><a href="contact.html">Contact us</a></li>
		</ul>
	</div>
	
	
	
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<%@include file="footer.html" %>
	
</body>
</html>