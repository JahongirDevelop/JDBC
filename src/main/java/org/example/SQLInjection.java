package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjection {
    public static void main(String[] args) {

            System.out.println(100 + 100 +"dasturlsh.uz");
            System.out.println("dasturlash.uz" + 100 + 100);
            System.out.println("dasturlash.uz" + 10*5);
            System.out.println(2*5+"dasturlash.uz");

//        Profile profile = authorization("alish", "kalish");
//        System.out.println(profile);
    }

//    public static Profile authorization(String login, String password){
//        try {
//        Connection connection = DBUtil.getConnection();
//        Statement statement = connection.createStatement();
//
//        String sql = "select * from profile where login = '%s' and password = '%s' ";
//        statement.executeQuery(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
