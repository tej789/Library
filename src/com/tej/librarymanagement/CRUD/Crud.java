package com.tej.librarymanagement.CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud {

    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String username = "root";
    private static final String password = "mysql";



      public static void create(int id ,String title, String writer, double price) {
     
        String sql = "insert into books (id,title,writer,price) values (?,?,?,?)";

        try(Connection connection = DriverManager.getConnection(url,username,password);
           PreparedStatement ps = connection.prepareStatement(sql)){
           ps.setInt(1, id);
           ps.setString(2, title);
           ps.setString(3, writer);
           ps.setDouble(4, price);
           ps.executeUpdate();
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

     }

     public static void read(int id) {
        String sql = "select * from books where id = ?";

        try(Connection connection = DriverManager.getConnection(url,username,password);
              PreparedStatement ps = connection.prepareStatement(sql)){
          
         
           ps.setInt(1, id);

           try(ResultSet rs = ps.executeQuery()){
           while(rs.next()){
                System.out.println(rs.getString("title"));
                System.out.println(rs.getString("writer"));
                System.out.println(rs.getDouble("price"));

           }}
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

     }
    

   public static void update(int id,String title,String writer,double price){
String sql = "update books set title = ?,writer = ?,price = ?where id =?";

try(
    Connection conn = DriverManager.getConnection(url,username,password);
   PreparedStatement ps = conn.prepareStatement(sql)){
ps.setInt(4, id);
   ps.setString(1, title);
   ps.setString(2, writer);
    ps.setDouble(3, price);
    ps.executeUpdate();

}catch(SQLException e){
    throw new RuntimeException(e); 
   }
   }


   public static void delete(int id){

    String sql = "delete from books where id = ?";

    try( Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement ps = connection.prepareStatement(sql) ){
        ps.setInt(1,id);
        ps.executeUpdate();


   }catch(SQLException e){
throw new RuntimeException(e);
   }
}

    public static void main(String[] args) {

    
//    create(2,"Book 2","Writer 2",20.0);
   read(1);
update(1,"Book_1_new","writer_1_new",15);
read(1);
delete(1);


}
}
 