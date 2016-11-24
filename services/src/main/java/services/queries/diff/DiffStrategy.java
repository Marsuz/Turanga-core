package services.queries.diff;


public interface DiffStrategy {

    public String buildResultsComparingQuery(String query1, String query2);
}
