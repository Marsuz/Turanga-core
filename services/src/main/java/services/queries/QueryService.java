package services.queries;

import services.queries.diff.DiffStrategy;
import services.queries.diff.DiffStrategyFactory;
import services.queries.diff.PostgreSQLStrategy;
import services.tasks.ExerciseTaskService;
import model.tasks.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wrappers.QueryResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.JDBCUtils.getDBConnection;


@Service
public class QueryService {

    private final static Logger logger = LoggerFactory.getLogger(QueryService.class);

    @Autowired
    ExerciseTaskService exerciseTaskService;

    @Autowired
    DiffStrategyFactory diffStrategyFactory;

    DiffStrategy strategy = new PostgreSQLStrategy();

    public QueryResult processQuery(String query) {
        return processQuery(query, null);
    }

    public QueryResult processQuery(String query, Long taskId) {
        return processQuery(query, taskId, null, null, null, null);
    }

    public QueryResult processQuery(String query, Long taskId, String jdbcDriverId, String dbUrl, String user, String password) {
        Connection connection = null;
        if (jdbcDriverId == null || dbUrl == null || user == null || password == null) {
            connection = getDBConnection();
        } else {
            connection = getDBConnection(jdbcDriverId, dbUrl, user, password);
        }
        Statement statement = null;
        List<Map<String, String>> results = null;

        try {
            statement = connection.createStatement();

        } catch (SQLException e) {
            logger.info("DB connection could not be established");
            e.printStackTrace();
        }

        try {
            ResultSet resultSet = statement.executeQuery(query);
            results = convertResultSetToJsonApplicableFormat(resultSet);
            boolean ifCorrect = true;
            if (taskId != null) {
                ifCorrect = checkIfQueryOutputMatchesRequirements(query, taskId);
            }
            return new QueryResult(ifCorrect, results, "");
        } catch (SQLException e) {
            logger.info("Error occured executing query");
            return new QueryResult(false, results, e.getMessage());
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }

                connection.close();
            } catch (SQLException e) {

                logger.info("Statement or connection could not be closed");
                e.printStackTrace();
            }
        }
    }


    private boolean checkIfQueryOutputMatchesRequirements(String query, Long taskId) {
        Task chosenTask = exerciseTaskService.getExerciseTaskById(taskId);
        String checkingQuery = strategy.buildResultsComparingQuery(query, chosenTask.getExampleCorrectQuery());
        QueryResult diff = processQuery(checkingQuery);
        return "".equals(diff.getErrorMessage()) && diff.getResults().size() == 0;
    }

    private void updateStrategy(String dbEngineShortName) {
        strategy = diffStrategyFactory.createDiffStrategy(dbEngineShortName);
    }

    private List<Map<String, String>> convertResultSetToJsonApplicableFormat(ResultSet rs) {
        List<Map<String, String>> resList = new ArrayList<>();
        try {
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCnt = rsMeta.getColumnCount();
            List<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= columnCnt; i++) {
                columnNames.add(rsMeta.getColumnName(i).toUpperCase());
            }

            while (rs.next()) { // convert each object to a human readable JSON object
                Map<String, String> currMap = new HashMap<>();
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
