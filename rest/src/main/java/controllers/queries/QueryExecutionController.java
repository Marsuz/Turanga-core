package controllers.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.queries.QueryService;
import utils.JDBCUtils;
import wrappers.QueryRequest;
import wrappers.QueryResult;

import java.util.Set;


@RestController
//@CrossOrigin(origins="http://localhost:8081")
public class QueryExecutionController {

    @Autowired
    QueryService queryService;

    @RequestMapping(value = "/query", consumes="application/json", method = RequestMethod.POST)
    public QueryResult executeQuery(@RequestBody QueryRequest queryRequest) {
        return queryService.processQuery(queryRequest);
    }

    @RequestMapping(value = "/dbs", method = RequestMethod.GET)
    public Set<String> getDBNames() {
        return JDBCUtils.getDBNames();
    }

}
