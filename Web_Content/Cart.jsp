<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Cart | Food Ordering System</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<h2>Your Cart</h2>

<%
  HttpSession sessionObj = request.getSession(false);
  List<String[]> cart = (List<String[]>) sessionObj.getAttribute("cart");
  if (cart == null || cart.isEmpty()) {
%>
  <p>Your cart is empty!</p>
<%
  } else {
%>
  <table border="1" cellpadding="10">
    <tr>
      <th>Item</th>
      <th>Price</th>
    </tr>
<%
      double total = 0;
      for (String[] item : cart) {
        total += Double.parseDouble(item[1]);
%>
    <tr>
      <td><%= item[0] %></td>
      <td>₹<%= item[1] %></td>
    </tr>
<%
      }
%>
  </table>
  <h3>Total: ₹<%= total %></h3>
  <form action="OrderServlet" method="post">
    <button type="submit">Place Order</button>
  </form>
<%
  }
%>

<p><a href="Menu.jsp">Back to Menu</a></p>
</body>
</html>
