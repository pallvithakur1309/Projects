<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
<center><h1>Welcome to Login Page</h1>
${msg }
<form action="loginValidation" method="post">
<h3 style="font-size:150%;"><b>Email:<input type="email"pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email" title="Email must contain '@' and '.'" required></h3></b><br>
<h3 style="font-size:150%;">Password:<input type="password" name="password" required></h3><br>
<input type="submit" value="Login"><br> 
<a href="forgotpassword">Forgot Password</a>|
<a href="registration">Registration</a>
</form>
</center>
</body>
</html>