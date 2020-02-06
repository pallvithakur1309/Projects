<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<center><h1>Welcome To ForgotPassword </h1>
${msg1 }
<form action="forgotdata" method="post">
Email:<input type="text" name="email">

<h3>Security Question!!!!!!!!</h3><br>
<select name="Questions">
<option value="Questions">Questions</option>
<option value="What is your DOB?">What is your DOB?</option>
<option value="What is your nick name?">What is your nick name?</option>
<option value="How old are you?">How old are you?</option>
<option value="What is you favorite Country">What is you favorite Country?</option>
</select>
<h3>Answer</h3><br>
<input type="answer" name="answer" required><br><br>
<input type="submit" value="submit">
<br><br>
<a href="login">Login</a>
</pre>
</form>
</center>
</body>
</html>