package org.example;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConnectIntroduction {
    public static void main(String[] args)  {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver"); // 1 - step (Register Driver -> driverni ro'yxatdan o'tkazish) Buni yozmasa ham bo'laveradi
             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learn_java_jdbc", "postgres", "1"); // 2 - step (Get connection -> db blan connection o'rnatish)
            Statement statement = connection.createStatement(); // 3 - step (Create Statement -> statement yaratish)
            ResultSet resultSet = statement.executeQuery("select * from movie");     // 4 - step (Execute Query -> db ga SQL ni jo'natish)

            while (resultSet.next()) {

//            System.out.println(resultSet.getInt("id") + " -> " + resultSet.getString("name"));
                Integer id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                Long duration = resultSet.getLong("duration");
                LocalDateTime createdDate = resultSet.getTimestamp("created_date").toLocalDateTime();
                LocalDate publishDate = resultSet.getDate("publish_date").toLocalDate();
                Double rating = resultSet.getDouble("rating");
                System.out.println(id + " " + title + " " + duration + " " + createdDate + " " + publishDate + " " + rating);
            }
           // connection.close(); // 5 - step (Colose Connection -> db bilan yaratilgan connectionni uzish)

        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException();
        } finally {
            try {
                if (connection != null) connection.close(); // close
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}