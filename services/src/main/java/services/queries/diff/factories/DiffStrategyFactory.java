package services.queries.diff.factories;

import org.springframework.stereotype.Component;
import services.queries.diff.strategies.*;

@Component
public class DiffStrategyFactory {

    public DiffStrategyFactory() {
    }

    public DiffStrategy createDiffStrategy(String dbShortName) {
        switch (dbShortName) {
            case "POSTGRESQL":
                return new PostgreSQLStrategy();
            case "MYSQL":
                return new MySQLStrategy();
            case "DB2":
                return new DB2Strategy();
            case "MSSQL":
                return new MSSQLStrategy();
            case "Oracle":
                return new OracleStrategy();
            default:
                return new PostgreSQLStrategy();
        }
    }
}
