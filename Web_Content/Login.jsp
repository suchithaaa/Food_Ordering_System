<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login|Food Ordering System</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<h2>Login</h2>

<form action="UserLoginServlet" method="post">
<label>Username:</label>
<input type="text" name="name" required><br><br>
<label>Password:</label>
<input type="text" name="password" required><br><br>
<button type="submit">Login</button>
</form>

<p>Don't have an account? <a=href="register.jsp">Register here</p>

</body>
</html>