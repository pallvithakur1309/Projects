<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<center><h1>Welcome To ComposeDraft</h1></center>
<center><form action="composeDraftMail" method="post">
<pre>
<table border="1px" style="text-align:center;" align="center">
<input type="hidden" name="Id" value="${From_id.getId() }">
To:<input type="text" name="To" value="${From_id.getSentto() }" required><br>
Subject:<input type="text"  name="Subject" value="${From_id.getSubject() }" required><br>
Message:<input type="text" name="Message" value="${From_id.getMessage() }" required><br><br>
<input type="submit" value="Send">
</table>
</pre>
</center>
</form>
</body>
</html>