<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<h3><a href="inbox">Inbox</a>|

<a href="sentitem">Sent items</a>|
<a href="deleteitem">Delete items</a>|
<a href="draft">Draft Mails</a>|
<a href="composemail">Compose Mail</a>|
<a href="logout">Logout</a><br>
${msg }
<center><h1>Draft Mails</h1></center>
<table border="1px" style="text-align:center;" align="center">
    <tr>
      <th>Subject</th>
      <th>Delete Mail</th>
      </tr>
      <c:forEach var="alist" items="${From_id }">
      <tr>
       <td><a href="composeDraft?id=+${alist.getId() }+" ><c:out value="${alist.getSubject() }"/></a></td>
          <td><a href="draftdelete?id=+${alist.getId() }+">Delete</a></td>
        </tr>
        </c:forEach>
        </table>
</body>
</html>