package rest.wrappers;

import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2016-09-03.
 */
public class QueryResult {

    private boolean correct;
    private List<Map<String, String>> results;

    public QueryResult(boolean correct, List<Map<String, String>> results) {
        this.correct = correct;
        this.results = results;
    }

    public boolean isCorrect() {
        return correct;
    }

    public List<Map<String, String>> getResults() {
        return results;
    }
}
