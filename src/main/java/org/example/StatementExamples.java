package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class StatementExamples {
    public static void main(String[] args) {
//        createTable();
//        insertQuery("Learn","JDBC","Alish", LocalDate.of(2021,03,23));
        selectById(2);
    }
    public static void createTable(){
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();

            String sql = "create table if not exists article(" +
                    " id serial primary key, " +
                    " title varchar, " +
                    " content text, " +
                    " author_name varchar, " +
                    " publish_date date" +  ")";
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertQuery(String title, String content, String author_name, LocalDate publishDate){
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "insert into article(title, content, author_name, publish_date) values ('%s', '%s', '%s', '%s')";
            sql =  String.format(sql, title, content, author_name, publishDate.toString());
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectById(Integer ide){
        try {
        Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from article where id = " + ide + "; ";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                int idd = resultSet.getInt("id");
                System.out.println("id: " + idd);

            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
