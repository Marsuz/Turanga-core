package services.queries.diff;


public class PostgreSQLStrategy implements DiffStrategy  {
    public String buildResultsComparingQuery(String query1, String query2) {
        return query1 + " EXCEPT ALL " + query2;
    }
}
