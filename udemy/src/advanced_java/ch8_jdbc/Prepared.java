package advanced_java.ch8_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

// Prepared statements allow use of placeholders
public class Prepared {
    public static void main(String[] args) {
        ConnectToDB conn = new ConnectToDB();
        Connection connection = conn.getConnection();
        try {
            Statement stmt; // use to formulate SQL
            ResultSet result;
            String ps = "update books set title = ? where isbn = ?";
            PreparedStatement ptst = connection.prepareStatement(ps);
            ptst.setString(1, "Effective Java Eighth Edition");
            ptst.setString(2,"032135668");
            ptst.executeUpdate();
            stmt = connection.createStatement();
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
