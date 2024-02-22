package org.example;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
    @SneakyThrows
    public static Connection getConnection() {
        Class.forName("org.postgresql.Driver"); // 1 - step (Register Driver -> driverni ro'yxatdan o'tkazish) Buni yozmasa ham bo'laveradi
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/learn_java_jdbc", "postgres", "1"); // 2 - step (Get connection -> db blan connection o'rnatish)
    }
}
