package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

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
    private static String USER;
    private static String PASSWORD;

    final static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);

    static {
        Properties properties = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("db/src/main/resources/classdb.properties");
            properties.load(input);

            JDBC_DRIVER = properties.getProperty("jdbc_driver");
            DB_URL = properties.getProperty("db_url");
            USER = properties.getProperty("db_user");
            PASSWORD = properties.getProperty("db_password");
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
        return getDBConnection(JDBC_DRIVER, DB_URL, USER, PASSWORD);
    }

    public static Connection getDBConnection(String jdbcDriverShortName, String dbUrl, String user, String password) {
        String jdbcDriver = null;
        Properties properties = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("db/src/main/resources/dbdrivers.properties");
            properties.load(input);
            jdbcDriver = properties.getProperty(jdbcDriverShortName);
        } catch (IOException ex) {
            logger.info("Could not read properties file for jdbc initialization");
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        Assert.notNull(jdbcDriver);
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            logger.info("JDBC driver not found");
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            logger.info("Could not establish connection with database");
        }

        return connection;
    }

}
