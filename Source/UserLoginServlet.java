package com.foodapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.foodapp.dbconnection;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE name=? AND password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                
                response.sendRedirect("Menu.jsp");
            } else {
                out.println("<h3>Invalid username or password!</h3>");
                out.println("<a href='Login.jsp'>Try Again</a>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
