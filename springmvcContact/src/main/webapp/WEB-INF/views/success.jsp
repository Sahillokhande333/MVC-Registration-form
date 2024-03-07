<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 class=text-ceneter>${Header }</h1>
<p class=text-center>${desc }</p>

<h1 style="color:green">${msg }</h1>

<h1> Welcome, ${user.userName }</h1>
<h1>Your email is: ${user.email }</h1>
<h1>Password is: ${user.password } </h1>

</body>
</html>