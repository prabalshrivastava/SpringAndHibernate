package demo01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBUtil {
    public static final String DB_DRIVER;
    public static final String DB_URL;
    public static final String DB_USER;
    public static final String DB_PASSWORD;

    static {
        InputStream inputStream = DBUtil.class.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DB_DRIVER = properties.getProperty("db.driver");
        DB_URL = properties.getProperty("db.url");
        DB_USER = properties.getProperty("db.user");
        DB_PASSWORD = properties.getProperty("db.password");
        System.out.println(DB_DRIVER);
        System.out.println(DB_URL);
        System.out.println(DB_USER);
        System.out.println(DB_PASSWORD);
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
