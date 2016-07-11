package java_lessons.lesson21_jdbc;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * This class uses prepared statements which allow use of placeholders rather than concatenate data together to build
 * our SQL. Create the prepared statement as a String. Then call the prepareStatement method of the Connection object
 * with that String to build a prepared statement. Then use a set method to call on your preparedStatement object. Then
 * once all the data values are set then call executeUpdate method.
 */
//
public class PreparedStatements {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ConnectToDB conn = new ConnectToDB();
        Connection connection = conn.getConnection();

        try {
            Statement stmt; // use to formulate SQL
            ResultSet result;
            String ps = "update books set title = ? where isbn = ?";

            PreparedStatement ptst = connection.prepareStatement(ps);
            // prepare data to be put in place of the placeholders.
            ptst.setString(1, "Effective Java Eighth Edition");
            ptst.setString(2,"032135668");
            ptst.executeUpdate();

            conn.closeConnection(connection);
        } catch (Exception e) {
            System.out.println("Error updating record");
        }
    }
}
