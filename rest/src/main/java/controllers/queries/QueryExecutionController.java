package controllers.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.queries.QueryService;
import wrappers.QueryResult;

import java.util.Map;

/**
 * Created by Marcin on 2016-08-20.
 */
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value = "/query", consumes="application/json")
public class QueryExecutionController {

    @Autowired
    QueryService queryService;

    @RequestMapping(method = RequestMethod.POST)
    public QueryResult executeQuery(@RequestBody Map<String, String> jsonBody) {
        return queryService.processQuery(jsonBody.get("query"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public QueryResult checkIfQueryIsCorrect(@RequestBody Map<String, String> jsonBody, @PathVariable Long id) {
        return queryService.processQuery(jsonBody.get("query"), id);
    }
}
