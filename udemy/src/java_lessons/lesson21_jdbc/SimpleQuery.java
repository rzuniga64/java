package java_lessons.lesson21_jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class SimpleQuery {
    public static void main(String[] args) {
        ConnectToDB conn = new ConnectToDB();
        Connection connection = conn.getConnection();
        try {
            Statement stmt; // use to formulate SQL
            ResultSet result; // stores data from SQL query
            stmt = connection.createStatement();
            result = stmt.executeQuery("select * from film");
            while (result.next()) {
                String title = result.getString("title");
                int year = result.getInt("release_year");
                System.out.print("Title: " + title);
                System.out.println(" Year: " + year);
            }
            result.close();
            conn.closeConnection(connection);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
