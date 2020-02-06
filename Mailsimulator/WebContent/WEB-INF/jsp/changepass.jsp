<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">;
<center><h1>Welcome To Change Password</h1>
${msg }
<hr>
	<form action="changePass" align="center" method="post">
			
			<div >	<label for="email">
			
				Email</label> <br> <input type="text"name="email" id="username" required>
					
			</div>

			<div ><label for="password">
				 
					Confirm Password</label> <br><input type="password" name="confirmpassword" required>
			</div>
			<div ><label for="password">
				 
					New Password</label> <br><input type="text" name="newpassword" required>
			</div>
			
			
			<div>
				<br><button type="submit">Reset Password</button>
			</div>
			</form>
			</center>
</body>
</html>