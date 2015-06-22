package learn_java.ch24_database_programming;

import java.sql.*;

public class SimpleQuery {
   public static void main(String[] args) {
      try {
         String userName = "root";
         String password = "aggies92";
         String url = "jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull";
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         Connection conn = DriverManager.getConnection(url, userName, password);
         Statement stmt = conn.createStatement();
         ResultSet rset = stmt.executeQuery("select * from actor");
         while (rset.next()) {
            int actorID = rset.getInt("actor_ID");
            String fname = rset.getString("first_name");
            String lname = rset.getString("last_name");            
            System.out.print("Actor ID: " + actorID + " ");
            System.out.print("First Name: " + fname + "\t");
            System.out.println("Last Name " + lname);
         }
         rset.close();
         conn.close();
      }
      catch (Exception e) {
         System.out.print("Error: " + e.toString());
      }
   }
}