package java_lessons.lesson21_jdbc;

import java.sql.*;

/**
 * The type Test driver. This class is used to test that the Connector/J is installed properly.
 */
public class TestDriver {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        try {
            Driver driver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Connection works.");

        } catch (Exception e) {
            System.out.println("Connection failed.");
        }
    }
}
