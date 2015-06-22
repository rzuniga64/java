package learn_java.ch24_database_programming;

public class TestDriver {
   public static void main(String[] args) {
      try {
        // This will load the MySQL server, each DB has its own server
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        System.out.println("Database connection successful.");
      }
      catch (Exception e) {
        System.out.println("Cannot connect to database.");
      }
   }
}