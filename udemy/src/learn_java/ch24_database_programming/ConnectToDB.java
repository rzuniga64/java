package learn_java.ch24_database_programming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectToDB {
   public static void main(String[] args) {
      Connection conn = null;
      ResultSet rs = null;
      try {
        // This will load the MySQL server, each DB has its own server
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // Setup the connection with the database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "aggies92");
        // Statements allow to issue SQL queries to the database
        Statement st = conn.createStatement();
        String query = "select first_name from actor;";
        rs = st.executeQuery(query);
         while(rs.next()) {
            String fname = rs.getString("first_name");
            System.out.println(fname);
        }
        System.out.println("Database connection successful.");
      } catch (Exception e) {
        System.out.println("Cannot connect to database.");
      }
      finally {
         if ((conn != null) && (rs != null)) {
            try {
                rs.close();
                conn.close();
                System.out.println("Database connection closed.");
            } catch (Exception e) {
                System.out.println("Database connection cannot be closed.");
            }
         }
      }
   }
}