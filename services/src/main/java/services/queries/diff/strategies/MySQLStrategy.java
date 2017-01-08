package services.queries.diff.strategies;

public class MySQLStrategy implements DiffStrategy {
    @Override
    public String buildResultsComparingQuery(String query1, String query2) {
        return query1 + " EXCEPT ALL " + query2;
    }
}
