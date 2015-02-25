<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@include file="header1.html" %>
<br/>
<br/>
<h1 style="color: green;">Congratulation!</h1>
<hr/>
<br/>
<h3 style="color: red">We are very thankful <%=session.getAttribute("key") %>. Enjoy our valuable services.</h3>


<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<%@include file="footer.html" %>
</body>
</html>