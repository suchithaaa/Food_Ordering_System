package com.foodapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.foodapp.dbconnection;

public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       

        try {
            Connection con =dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO user(name, email,password) VALUES (?, ?, ?)");
           
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
           

            int result = ps.executeUpdate();
            if (result > 0) {
                out.println("<h3>Registration successful!</h3>");
                out.println("<a href='Login.jsp'>Login Now</a>");
            } else {
                out.println("<h3>Registration failed!</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error occurred: " + e.getMessage() + "</h3>");
        }
    }
}
