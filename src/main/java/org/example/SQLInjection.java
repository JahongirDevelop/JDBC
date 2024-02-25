package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjection {
    public static void main(String[] args) {
        Profile profile = authorization("alish", "kalish");
        System.out.println(profile);
    }

    public static Profile authorization(String login, String password){
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from profile where login = '%s' and password = '%s' ";
            statement.executeQuery(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
