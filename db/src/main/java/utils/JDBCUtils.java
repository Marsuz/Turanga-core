package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import wrappers.DBDetails;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class JDBCUtils {

    private static String DB_NAME = "POSTGRESQL";
    private static DBDetails DB_DETAILS;

    final static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);

    static {
        Properties properties = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("../db/src/main/resources/defconfig.properties");
            properties.load(input);

            String JDBC_DRIVER = properties.getProperty(DB_NAME);
            String DB_URL = properties.getProperty("db_url");
            String USER = properties.getProperty("db_user");
            String PASSWORD = properties.getProperty("db_password");
            DB_DETAILS = new DBDetails(DB_NAME, DB_URL, USER, PASSWORD);
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

    public static Set<String> getDBNames() {
        Properties properties = new Properties();
        Set<String> dbNames = new HashSet<>();
        FileInputStream input = null;
        try {
            input = new FileInputStream("../db/src/main/resources/dbdrivers.properties");
            properties.load(input);
            dbNames = properties.stringPropertyNames();
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

        return dbNames;
    }

    public static Connection getDBConnection() throws SQLException {
        return getDBConnection(DB_DETAILS);
    }

    public static Connection getDBConnection(DBDetails dbDetails) throws SQLException{
        String jdbcDriver = null;
        Properties properties = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("../db/src/main/resources/dbdrivers.properties");
            properties.load(input);
            jdbcDriver = properties.getProperty(dbDetails.getDb());
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
            connection = DriverManager.getConnection(dbDetails.getUrl(), dbDetails.getUser(), dbDetails.getPassword());
        } catch (SQLException e) {
            logger.info("Could not establish connection with database");
            e.printStackTrace();
            throw e;
        }

        return connection;
    }

}
