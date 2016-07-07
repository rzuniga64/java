package java_lessons.lesson21_jdbc;

import java.sql.*;

public class TestDriver {
    public static void main(String args[]) {
        try {
            Driver driver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Connection works.");

        } catch (Exception e) {
            System.out.println("Connection failed.");
        }
    }
}
