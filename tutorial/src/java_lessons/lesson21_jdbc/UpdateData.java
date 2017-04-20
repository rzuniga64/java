package java_lessons.lesson21_jdbc;

import java.sql.Connection;
import java.sql.Statement;

/**
 * The type UpdateData.
 */
public class UpdateData {
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

            stmt = connection.createStatement();
            stmt.executeUpdate("update books set author = 'Raul Zuniga' where ISBN = '032135668'");
            System.out.println("Record updated");

            conn.closeConnection(connection);
        } catch (Exception e) {
            System.out.println("Error updating record");
        }
    }
}
