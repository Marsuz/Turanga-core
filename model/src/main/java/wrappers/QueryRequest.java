package wrappers;

public class QueryRequest {

    private String query;
    private String correctQuery;
    private DBDetails dbDetails;

    public QueryRequest() {
    }

    public QueryRequest(String query, String correctQuery, DBDetails dbDetails) {
        this.query = query;
        this.correctQuery = correctQuery;
        this.dbDetails = dbDetails;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCorrectQuery() {
        return correctQuery;
    }

    public void setCorrectQuery(String correctQuery) {
        this.correctQuery = correctQuery;
    }

    public DBDetails getDbDetails() {
        return dbDetails;
    }

    public void setDbDetails(DBDetails dbDetails) {
        this.dbDetails = dbDetails;
    }
}
