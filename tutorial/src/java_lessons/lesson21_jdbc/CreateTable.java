package java_lessons.lesson21_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        ConnectToDB conn = new ConnectToDB();
        Connection connection = conn.getConnection();
        try {
            Statement stmt; // use to formulate SQL
            ResultSet result;
            stmt = connection.createStatement();
            stmt.executeUpdate("drop table if exists books");
            stmt.executeUpdate("create table books (isbn char(10), title char(50)," +
                    "author char(50), publisher char(50))");
            result = stmt.executeQuery("show TABLES");
            while (result.next()) {
                String tbl = result.getString("Tables_in_test");
                System.out.println("Table: " + tbl);
            }
            result.close();
            conn.closeConnection(connection);
        } catch (Exception e) {
            System.out.println("Error creating table");
        }
    }
}
