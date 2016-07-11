package java_lessons.lesson21_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The type InsertData. Inserts data into table 'books' of database 'test'
 */
public class InsertData {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ConnectToDB conn = new ConnectToDB();
        Connection connection = conn.getConnection();
        try {
            Statement stmt; // use to formulate SQL
            stmt = connection.createStatement();
            stmt.executeUpdate("insert into books(isbn, title, author, publisher) values" +
                                "('007160630', 'Java-The Complete Reference','Herbert Schildt', 'Oracle Press')," +
                                "('032135668', 'Effective Java', 'Joshua Bloch', 'Addison-Wesley')");
            System.out.println("Record added");

            conn.closeConnection(connection);
        } catch (Exception e) {
            System.out.println("Error inserting record");
        }
    }
}
