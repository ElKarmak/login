package com.example.login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDb {

    private static final String URL = "jdbc:mysql://<host>:<3306>/<login>";
    private static final String USERNAME = "<victor>";
    private static final String PASSWORD = "<manuel123>";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
