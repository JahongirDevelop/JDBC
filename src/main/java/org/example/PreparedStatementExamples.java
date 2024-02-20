package org.example;

import java.sql.*;
import java.time.LocalDate;

public class PreparedStatementExamples {
    public static void main(String[] args) {
//        createTable();
        insert("Odam", "pda", 21, "ada99", LocalDate.of(2021,02,21));
    }

    public static void createTable() {
        try {
            Connection connection = DBUtil.getConnection();

            String sql = "create table if not exists employee(" +
                    " id serial primary key, " +
                    " name varchar, " +
                    " surname varchar, " +
                    " age int, " +
                    " phone varchar, " +
                    " birth_day date" + ")";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void insert(String name, String surname, int age, String phone, LocalDate brith_day) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "insert into employee(name, surname, age, phone, birth_day) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, phone);
            preparedStatement.setDate(5, Date.valueOf(brith_day));
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
