package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Marcin on 2016-08-20.
 */
public class JDBCUtils {
    private static String JDBC_DRIVER;
    private static String DB_URL;
    private static String user;
    private static String password;

    final static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);

    static {
        Properties properties = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("db/src/main/resources/classdb.properties");
            properties.load(input);

            JDBC_DRIVER = properties.getProperty("jdbc_driver");
            DB_URL = properties.getProperty("db_url");
            user = properties.getProperty("db_user");
            password = properties.getProperty("db_password");
        } catch (IOException ex) {
            logger.info("Could not read properties file for jdbc initialization");
            System.exit(-1);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Connection getDBConnection() {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.info("JDBC driver not found");
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, user, password);
        } catch (SQLException e) {
            logger.info("Could not establish connection with database");
        }

        return connection;
    }

}
