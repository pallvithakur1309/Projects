<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<center><h2>Welcome to Compose Mail </h2>
<form action="composeData" method="post">
<pre>
<!-- From: <input type="text" name="From"><br> -->
<h3 style="font-size:150%;">To:<input type="text" name="To" required><br>
Subject:<input type="text" name="Subject" ><br>
Message: <input type="text" name="Message" required><br>
<input type="submit" value="SendMail">
</pre>
</form>
</center>
</body>
</html>