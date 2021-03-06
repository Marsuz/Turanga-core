package wrappers;

import java.util.List;
import java.util.Map;


public class QueryResult {

    private Boolean correct;
    private List<Map<String, String>> results;
    private String errorMessage;

    public QueryResult(Boolean correct, List<Map<String, String>> results, String errorMessage) {
        this.correct = correct;
        this.results = results;
        this.errorMessage = errorMessage;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public List<Map<String, String>> getResults() {
        return results;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
