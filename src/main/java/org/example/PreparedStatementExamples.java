package org.example;

import java.sql.*;
import java.time.LocalDate;

public class PreparedStatementExamples {
    public static void main(String[] args) {
//        createTable();
//        insert("pdsdsads", "kdks", 21, "fdsfs", LocalDate.of(2021,02,21));
//        selectBySurname("da");
        update("1234", 3);
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

    public static void selectBySurname(String sur_name){
        try {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from employee where surname like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + sur_name + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            int age = resultSet.getInt("age");
            String phone = resultSet.getString("phone");
            LocalDate brithDay = resultSet.getDate("birth_day").toLocalDate();

            System.out.println(id + " " + name + " " + surname + " " + age + " " + phone + " " + brithDay);
        }
        connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(String phone, Integer empId){
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "update employee set phone = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, empId);
            preparedStatement.executeUpdate();
            System.out.println("Updated");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
