package sqlite;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The type LoginModel.
 */
public class LoginModel {

    private Connection connection;

    /**
     * Instantiates a new LoginModel.
     */
    public LoginModel() {
        connection = SqliteConnection.Connector();
        if (connection == null)
            System.exit(1);
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
