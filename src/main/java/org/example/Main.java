package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // 1 - step
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/learn_java_jdbc", "postgres", "1"); // 2 - step

    }
}