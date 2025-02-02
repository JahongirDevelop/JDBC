package org.example;

import java.io.*;
import java.sql.*;

public class StoringAndRetrieveAnyType {
    public static void main(String[] args) {
//        createTable();
        insertAnyType();
        retrieveAnyType();
    }
    private static void insertAnyType() {
        try {
        File file = new File("YOUR_LOCAL_STORAGE/FILE-NAME.mp4"); // path oxiriga o'sha saqlamoqchi bo'lgan typeni yozamiz(name.type)
        FileInputStream fileInputStream = new FileInputStream(file);

        Connection connection = DBUtil.getConnection();
        String sql = "insert into image_attach (f_name,f_type,f_data) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"video_2");
        preparedStatement.setString(2,"mp4");
        preparedStatement.setBinaryStream(3, fileInputStream);

        preparedStatement.executeUpdate();
        System.out.println("Saved");
        connection.close();
        } catch (FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void retrieveAnyType(){
        try {
        Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select f_name,f_type,f_data from image_attach");
        while (resultSet.next()){
            String fileName = resultSet.getString("f_name");
            String fileType = resultSet.getString("f_type");
            InputStream inputStream = resultSet.getBinaryStream("f_data");

            byte[] image = new byte[inputStream.available()];
            inputStream.read(image);

            File file = new File("YOUR_LOCAL_STORAGE/" + fileName + "." + fileType);
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(image);
            outputStream.close();
        }
            System.out.println("Retrieved");
            connection.close();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTable() {
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();

            String sql = "create table if not exists media_attach(" +
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
