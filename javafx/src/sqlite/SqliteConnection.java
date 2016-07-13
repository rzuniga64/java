package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The type SqliteLonnection. This class creates an SQLite connection to our project.
 */
class SqliteConnection {

    /**
     * Connector connection that creates a connection to the database from this project.
     *
     * @return the connection
     */
    static Connection Connector() {
        Connection conn;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:javafx\\src\\sqlite\\EmployeeDb.db");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return conn;
    }
}
