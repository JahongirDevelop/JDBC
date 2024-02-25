package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
//        List<Movie> allMovie = getAllMovie();
//        for (Movie movie : allMovie) {
//            System.out.println(movie);
//        }
        String sql = "update students set name = 'Alish' where id = 1; ";
        String sql2 = "select * from students; ";
//        update(sql);
        executeTest(sql2);
    }
    public static List<Movie> getAllMovie() { //  executeQuery method
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
        } catch (SQLException e) {
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

    public static void update(String sql) { // executeUpdate method
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            int effectedRow = statement.executeUpdate(sql);
            System.out.println(effectedRow);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeTest(String sql){
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            boolean hasResult = statement.execute(sql);
            if (hasResult){
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    System.out.println("name :" + resultSet.getString("name"));
                }
            } else {
                System.out.println("there isn't resultSet"); }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
