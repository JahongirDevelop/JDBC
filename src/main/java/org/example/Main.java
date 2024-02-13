package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> allMovie = getAllMovie();
        for (Movie movie : allMovie) {
            System.out.println(movie);
        }
    }
    public static List<Movie> getAllMovie(){
        List<Movie> movieList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from movie");

            while (resultSet.next()) {
                Movie movie = Movie.builder()
                        .id(resultSet.getInt("id"))
                        .title(resultSet.getString("title"))
                        .duration(resultSet.getLong("duration"))
                        .createdDate(resultSet.getTimestamp("created_date").toLocalDateTime())
                        .publishDate(resultSet.getDate("publish_date").toLocalDate())
                        .rating(resultSet.getDouble("rating"))
                        .build();
                movieList.add(movie);

            }
        } catch (SQLException e){
            throw new RuntimeException();
        } finally {
            try {
                if (connection != null) connection.close(); // close
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return movieList;
    }
}
