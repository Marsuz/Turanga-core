package services.queries.diff;

import org.springframework.stereotype.Component;

@Component
public class DiffStrategyFactory {

    public DiffStrategy createDiffStrategy(String dbShortName) {
        switch (dbShortName) {
            case "POSTGRESQL":
                return new PostgreSQLStrategy();
            default:
                return new PostgreSQLStrategy();
        }
    }
}
