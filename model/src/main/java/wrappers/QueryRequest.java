package wrappers;

import java.util.List;

public class QueryRequest {

        private String query;
        private String correctQuery;
        private List<String> forbiddenWords;
        private List<String> requiredWords;
        private DBDetails dbDetails;

    public QueryRequest() {
    }

    public QueryRequest(String query, String correctQuery, List<String> forbiddenWords, List<String> requiredWords, DBDetails dbDetails) {
        this.query = query;
        this.correctQuery = correctQuery;
        this.forbiddenWords = forbiddenWords;
        this.requiredWords = requiredWords;
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

    public List<String> getForbiddenWords() {
        return forbiddenWords;
    }

    public void setForbiddenWords(List<String> forbiddenWords) {
        this.forbiddenWords = forbiddenWords;
    }

    public List<String> getRequiredWords() {
        return requiredWords;
    }

    public void setRequiredWords(List<String> requiredWords) {
        this.requiredWords = requiredWords;
    }

    public DBDetails getDbDetails() {
        return dbDetails;
    }

    public void setDbDetails(DBDetails dbDetails) {
        this.dbDetails = dbDetails;
    }
}
