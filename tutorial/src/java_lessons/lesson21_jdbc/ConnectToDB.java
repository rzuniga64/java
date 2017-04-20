package java_lessons.lesson21_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connect to db.
 */
public class ConnectToDB {

    // authentication details for the database
    private static final String username ="rzuniga64";
    private static final String password = "aggies92";
    private static final String url = "jdbc:mysql://localhost:3306/OutputFormatting";

    /**
     * This method creates a connection to a database named 'OutputFormatting'.
     *
     * @return the connection
     */
    public static Connection getConnection() {

        // Create a connection object with global scope
        Connection connection = null;
        try {
            // Create an instance of the MySQL Connector/J driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // getConnection returns a reference to the Connection object for the database
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection successful");
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
        } catch (Exception e) {
            System.out.println("Connection failed.");
        } finally {
            //closeConnection(connection);
        }
    return connection;
    }

    /**
     * This method closes the MySQL database connection.
     *
     * @param connection the connection
     */
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

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Connection connection = getConnection();
    }
}
