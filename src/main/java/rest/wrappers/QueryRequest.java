package rest.wrappers;

/**
 * Created by mzajda on 17/09/2016.
 */
public class QueryRequest {
    private String query;

    public QueryRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
