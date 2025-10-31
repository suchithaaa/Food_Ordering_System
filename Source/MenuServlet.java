package com.foodapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MenuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a simple static menu (you can later fetch this from DB)
        List<String[]> menu = new ArrayList<>();
        menu.add(new String[]{"Margherita Pizza", "180"});
        menu.add(new String[]{"Veg Burger", "120"});
        menu.add(new String[]{"Chicken Biryani", "200"});
        menu.add(new String[]{"Paneer Butter Masala", "150"});
        menu.add(new String[]{"Cold Coffee", "80"});
        menu.add(new String[]{"Chocolate Cake", "100"});

        // Store the menu in request scope
        request.setAttribute("menu", menu);

        // Forward to menu.jsp for display
        RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
        dispatcher.forward(request, response);
    }
}
