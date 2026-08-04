package com.tej.librarymanagement.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection{

private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String username = "root";
    private static final String password = "mysql";

    public void data() {
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement s = con.createStatement();
            ResultSet r= s.executeQuery("select * from books");
            while(r.next()){
                System.out.println(r.getString("title"));
                System.out.println(r.getString("writer"));
                System.out.println(r.getDouble("price"));
            }
          
       
               
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
      DatabaseConnection db = new DatabaseConnection();
      db.data();
    } 
}