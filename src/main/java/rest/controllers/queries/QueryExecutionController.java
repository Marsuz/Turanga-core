package rest.controllers.queries;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.wrappers.QueryResult;
import services.queries.QueryService;

/**
 * Created by Marcin on 2016-08-20.
 */
@RestController
@RequestMapping(value = "/query", consumes="application/json")
public class QueryExecutionController {

    @Autowired
    QueryService queryService;

    @RequestMapping(value = "/exec", method = RequestMethod.POST)
    public QueryResult executeQuery(@RequestBody String jsonBody) {
        JSONObject jsonObject = new JSONObject(jsonBody);
        return queryService.processQuery(jsonObject.getString("query"));
    }

    @RequestMapping(value = "/check/{id}", method = RequestMethod.POST)
    public QueryResult checkIfQueryIsCorrect(@RequestBody String jsonBody, @PathVariable Long id) {
        JSONObject jsonObject = new JSONObject(jsonBody);
        return queryService.processQuery(jsonObject.getString("query"), id);
    }
}
