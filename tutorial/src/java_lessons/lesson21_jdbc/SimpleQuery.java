package java_lessons.lesson21_jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * The type SimpleQuery.
 */
public class SimpleQuery {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ConnectToDB conn = new ConnectToDB();
        Connection connection = conn.getConnection();

        try {
            Statement stmt;     // use to formulate SQL
            ResultSet result;   // stores data from SQL query

            stmt = connection.createStatement();                // instantiate the statement object
            result = stmt.executeQuery("select * from books");  // retrieve result set

            while (result.next()) {
                String isbn = result.getString("isbn");
                String  title = result.getString("title");
                String author = result.getString("author");
                String  publisher = result.getString("publisher");

                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Publisher: " + publisher);
                System.out.println();
            }

            result.close();
            conn.closeConnection(connection);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
