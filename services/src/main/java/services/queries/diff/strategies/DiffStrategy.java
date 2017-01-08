package services.queries.diff.strategies;


public interface DiffStrategy {

    public String buildResultsComparingQuery(String query1, String query2);
}
