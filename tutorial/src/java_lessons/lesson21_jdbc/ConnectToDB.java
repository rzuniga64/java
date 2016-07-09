package java_lessons.lesson21_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    // authentication details for the database
    private static final String username ="root";
    private static final String password = "aggies92";
    private static final String dbName = "test";

    /*
        getConnection returns a reference to the Connection object
        for the database
     */
    public static Connection getConnection() {
        // Create a connection object with global scope
        Connection connection = null;
        try {
            // Load MySQL Connector/J driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Get the MySQL connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, username, password);
            System.out.println("Database connection successful");
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
        } catch (Exception e) {
            System.out.println("Connection failed.");
        }
    return connection;
    }

    static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed");
            } catch (Exception e) {
                System.out.println("Database Connection cannot be closed");
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        closeConnection(connection);
    }
}
