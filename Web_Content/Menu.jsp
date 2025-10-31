<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu | Food Ordering System</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<h2>Food Menu</h2>

<table border="1" cellpadding="10">
<tr>
<th>Item Name</th>
<th>Price</th>
<th>Action</th>
</tr>

<tr>
<td>Pizza</td>
<td>₹200</td>
<td>
<form action="CartServlet" method="post">
<input type="hidden" name="item" value="Pizza">
<input type="hidden" name="price" value="200">
<button type="submit">Add to Cart</button>
</form>
</td>
</tr>

<tr>
<td>Burger</td>
<td>₹100</td>
<td>
<form action="CartServlet" method="post">
<input type="hidden" name="item" value="Burger">
<input type="hidden" name="price" value="100">
<button type="submit">Add to Cart</button>
</form>
</td>
</tr>

<tr>
<td>Pasta</td>
<td>₹400</td>
<td>
<form action="CartServlet" method="post">
<input type="hidden" name="item" value="Pasta">
<input type="hidden" name="price" value="400">
<button type="submit">Add to Cart</button>
</form>
</td>
</tr>
</table>

<p><a href="Cart.jsp">Go to Cart</a></p>
</body>
</html>
