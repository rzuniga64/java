package advanced_java.ch8_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        ConnectToDB conn = new ConnectToDB();
        Connection connection = conn.getConnection();
        try {
            Statement stmt; // use to formulate SQL
            ResultSet result;
            stmt = connection.createStatement();
            stmt.executeUpdate("insert into books(isbn, title, author, publisher)" +
                               " values" +
                                "('007160630', 'Java-The Complete Reference','Herbert Schildt', 'Oracle Press')," +
                                "('032135668', 'Effective Java', 'Joshua Bloch', 'Addison-Wesley')");
            System.out.println("Record added");
            result = stmt.executeQuery("select * from books");
            while (result.next()) {
                String isbn = result.getString("isbn");
                String title = result.getString("title");
                String author = result.getString("author");
                String publisher = result.getString("publisher");
                System.out.print("ISBN: " + isbn);
                System.out.println(" Title: " + title);
                System.out.print("Author: " + author);
                System.out.println(" Publisher: " + publisher);
            }
            result.close();
            conn.closeConnection(connection);
        } catch (Exception e) {
            System.out.println("Error inserting record");
        }
    }
}
