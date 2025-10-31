package com.foodapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.foodapp.dbconnection;

public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String name = (String) session.getAttribute("name");  // set in login
        List<String[]> cart = (List<String[]>) session.getAttribute("cart");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // ✅ Validate session and cart
        if (session == null || name == null) {
            out.println("<h3>Session expired! Please log in again.</h3>");
            out.println("<a href='Login.jsp'>Go to Login</a>");
            return;
        }
        if (cart == null || cart.isEmpty()) {
            out.println("<h3>Your cart is empty!</h3>");
            out.println("<a href='Menu.jsp'>Go back to Menu</a>");
            return;
        }

        try (Connection con = dbconnection.getConnection()) {
            if (con == null) {
                out.println("<h3>Database connection failed!</h3>");
                return;
            }

            for (String[] item : cart) {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO orders(name, item_name, price) VALUES (?, ?, ?)"
                );
                ps.setString(1, name);
                ps.setString(2, item[0]);
                ps.setDouble(3, Double.parseDouble(item[1]));
                ps.executeUpdate();
            }

            // ✅ Clear cart after placing order
            cart.clear();
            session.setAttribute("cart", cart);

            out.println("<h3>Order placed successfully!</h3>");
            out.println("<a href='Menu.jsp'>Continue Shopping</a>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
