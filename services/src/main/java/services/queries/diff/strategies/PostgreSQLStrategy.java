package services.queries.diff.strategies;


public class PostgreSQLStrategy implements DiffStrategy  {
    public String buildResultsComparingQuery(String query1, String query2) {
        String firstPart = "(select * from (" + query1 + ") as q1 EXCEPT ALL " + "select * from (" + query2 + ") as q2)";
        String unionPart = " UNION ALL ";
        String lastPart = "(select * from (" + query2 + ") as q3 EXCEPT ALL " + "select * from (" + query1 + ") as q4)";
        return firstPart + unionPart + lastPart;
    }
}
