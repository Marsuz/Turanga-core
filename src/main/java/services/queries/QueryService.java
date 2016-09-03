package services.queries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static db.utils.JDBCUtils.*;

/**
 * Created by Marcin on 2016-08-20.
 */

@Service
public class QueryService {

    final static Logger logger = LoggerFactory.getLogger(QueryService.class);

    public List<Map<String, String>> processSelectQuery(String query) {

        Connection connection = null;
        Statement statement = null;


        try {
            connection = getDBConnection();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            return convertResultSetToJsonApplicableFormat(resultSet);

        } catch (SQLException e) {

            logger.info("Problem while establishing connection with DB");
            return null;

        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {

                logger.info("Problem while closing statement/connection!");

            }

        }

    }

    private List<Map<String, String>> convertResultSetToJsonApplicableFormat(ResultSet rs) {
        List<Map<String, String>> resList = new ArrayList<Map<String, String>>();
        try {
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCnt = rsMeta.getColumnCount();
            List<String> columnNames = new ArrayList<String>();
            for (int i = 1; i <= columnCnt; i++) {
                columnNames.add(rsMeta.getColumnName(i).toUpperCase());
            }

            while (rs.next()) { // convert each object to an human readable JSON object
                Map<String, String> currMap = new HashMap<String, String>();
                for (int i = 1; i <= columnCnt; i++) {
                    currMap.put(columnNames.get(i - 1), rs.getString(i));
                }
                resList.add(currMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resList;
    }

}
