package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // 1 - step (Register Driver -> driverni ro'yxatdan o'tkazish)
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learn_java_jdbc", "postgres", "1"); // 2 - step (Get connection -> db blan connection o'rnatish)
        Statement statement = connection.createStatement(); // 3 - step (Create Statement -> statement yaratish)
        ResultSet resultSet = statement.executeQuery("select * from students"); // 4 - step (Execute Query -> db ga SQL ni jo'natish)

        while (resultSet.next()){
            System.out.println(resultSet.getInt("id") + " -> " + resultSet.getString("name"));
        }

        connection.close(); // 5 - step (Colose Connection -> db bilan yaratilgan connectionni uzish)


    }
}