package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExamples {
    public static void main(String[] args) {
        createTable();
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
}
