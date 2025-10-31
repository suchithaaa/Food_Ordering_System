<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register|Food Ordering System</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<h2>Register</h2>
<form action="UserRegisterServlet" method="post">
<label>Username:</label>
<input type="text" name="name" required><br><br>
<label>Email:</label>
<input type="text" name="email" required><br><br>
<label>password:</label>
<input type="text" name="password" required><br><br>
<button type="submit">Submit</button>
</form>
</body>
</html>