package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StoringImage {
    public static void main(String[] args) {
//        createTable();


        try {
        File file = new File("D:/Users/HP/java G23/Images/image_1.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);

        Connection connection = DBUtil.getConnection();
        String sql = "insert into image_attach (f_name,f_type,f_data) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"image_1");
        preparedStatement.setString(2,"jpg");
        preparedStatement.setBinaryStream(3, fileInputStream);

        preparedStatement.executeUpdate();
        connection.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createTable() {
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();

            String sql = "create table if not exists image_attach(" +
                    " id serial primary key, " +
                    " f_name varchar, " +
                    " f_type text, " +
                    " f_data bytea" + ")";
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
