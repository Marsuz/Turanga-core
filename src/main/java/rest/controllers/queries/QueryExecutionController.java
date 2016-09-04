package rest.controllers.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.wrappers.QueryResult;
import services.queries.QueryService;

/**
 * Created by Marcin on 2016-08-20.
 */
@RestController
@RequestMapping(value = "/query")
public class QueryExecutionController {

    @Autowired
    QueryService queryService;

    @RequestMapping(value = "/exec", method = RequestMethod.POST)
    public QueryResult executeQuery(@RequestParam("query") String query) {
        return queryService.processQuery(query);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public QueryResult checkIfQueryIsCorrect(@RequestParam("query") String query, @RequestParam("taskid") Long id) {
        return queryService.processQuery(query, id);
    }
}
