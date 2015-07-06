package advanced_java.ch8_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) {
        ConnectToDB conn = new ConnectToDB();
        Connection connection = conn.getConnection();
        try {
            Statement stmt; // use to formulate SQL
            ResultSet result;
            stmt = connection.createStatement();
            stmt.executeUpdate("update books set author = 'Raul Zuniga' where ISBN = '032135668'");
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
            System.out.println("Error updating record");
        }
    }
}
