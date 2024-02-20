package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class StatementExamples {
    public static void main(String[] args) {
//        createTable();
        insertQuery("","","", LocalDate.of(2024,02,20));
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
            String sql = "insert into article(title, content, author_name, publish_date) values ('Java', 'Java lessons', 'Big-man','2024-02-20')";
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
