package org.example;
import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
    public static String dbUrl = System.getenv("DB_URL");
    public static String dbUser = System.getenv("DB_USER");
   public static String dbPassword = System.getenv("DB_PASSWORD");
    @SneakyThrows
    public static Connection getConnection() {
        Class.forName("org.postgresql.Driver"); // 1 - step (Register Driver -> driverni ro'yxatdan o'tkazish) Buni yozmasa ham bo'laveradi
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword); // 2 - step (Get connection -> db blan connection o'rnatish)
    }
}
