package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // 1 - step
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learn_java_jdbc", "postgres", "1"); // 2 - step
        Statement statement = connection.createStatement(); // 3 - step
        ResultSet resultSet = statement.executeQuery("select * from students"); // 4 - step

        while (resultSet.next()){
            System.out.println(resultSet.getInt("id") + " -> " + resultSet.getString("name"));
        }


    }
}