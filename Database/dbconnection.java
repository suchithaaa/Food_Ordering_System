package com.foodapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/foodie?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Root@123"
                );
                System.out.println("✅ Database connected successfully!");
            }
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
}
