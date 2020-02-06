<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<center><h1>Welcome To Registration Page</h1>
${dto }
<form action="registrationData" method="post">
<pre>
<h3 style="font-size:120%;"><b>User Name: <input type="text" name="User_name" required></h3><b></b><br>
<h3 style="font-size:120%;"><b>Email:<input type="email"pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email" title="Email must contain '@' and '.'" required></h3><b></b><br>
<!-- Email:<input type="email" name="email" required ><br> -->
<h3 style="font-size:120%;">Password:<input type="password" name="password" required></h3><b></b><br>
<h2>Security Question</h2>
<h3 style="font-size:120%;">Questions:<select name="Questions"></h3>
<option value="Questions">Questions</option>
<option value="What is your DOB?">What is your DOB?</option>
<option value="What is your nick name?">What is your nick name?</option>
<option value="How old are you?">How old are you?</option>
<option value="What is you favorite Country">What is you favorite Country?</option>
</select>
<h2>Answers</h2>
<h3 style="font-size:120%;">Answers:<input type="answer" name="answer" required></h3>
<input type="submit" value="Register"><br>
<a href="login">Login</a>
</pre>
</form>
</center>
</body>
</html>