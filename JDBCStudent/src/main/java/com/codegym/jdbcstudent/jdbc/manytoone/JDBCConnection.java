package com.codegym.jdbcstudent.jdbc.manytoone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static String user = "root";
    private static String password = "01666553995";
    private static String url = "jdbc:mysql://localhost:3306/manytoone";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    public static Connection getConnection(){
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver for jdbc connection!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not find database!");
            e.printStackTrace();
        }
        return null;
    }
}
