package com.tej.librarymanagement.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection{

    private static final String url = "jdbc:mysql://aivencloud.com";
    private static final String username = "tej";
    private static final String password = "AVNS_nEihUTiiWi-LoG2FyUT";

    public DatabaseConnection() {
        try {
           Connection connection = DriverManager.getConnection(url, username, password);
           
   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    

}