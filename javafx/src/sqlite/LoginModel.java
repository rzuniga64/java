package sqlite;

import com.sun.istack.internal.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type LoginModel.
 */
class LoginModel {

    private Connection connection;

    /**
     * Instantiates a new LoginModel.
     */
    LoginModel() {
        connection = SqliteConnection.Connector();
        if (connection == null)
            System.exit(1);
    }

    boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLogin(String username, String password) throws SQLException, NullPointerException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from employee where username=? and password=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            return false;
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
