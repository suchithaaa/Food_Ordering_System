package com.foodapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        List<String[]> cart = (List<String[]>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        String item = request.getParameter("item");
        String price = request.getParameter("price");

        if (item != null && price != null) {
            cart.add(new String[]{item, price});
            session.setAttribute("cart", cart);
        }

        response.sendRedirect("Cart.jsp");
    }
}
