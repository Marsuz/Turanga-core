package controllers.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.queries.QueryService;
import utils.JDBCUtils;
import wrappers.QueryResult;

import java.util.Map;
import java.util.Set;

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
        switch (jsonBody.size()) {
            case 1:
                return queryService.processQuery(jsonBody.get("query"));
            case 2:
                return queryService.processQuery(jsonBody.get("query"), jsonBody.get("correctQuery"));
            default:
                return queryService.processQuery(jsonBody.get("query"), jsonBody.get("correctQuery"), jsonBody.get("db"), jsonBody.get("url"), jsonBody.get("user"), jsonBody.get("pass"));
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<String> getDBNames() {
        return JDBCUtils.getDBNames();
    }

}
