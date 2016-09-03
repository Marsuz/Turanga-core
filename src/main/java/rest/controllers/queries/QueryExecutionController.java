package rest.controllers.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.queries.QueryService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Marcin on 2016-08-20.
 */
@RestController
public class QueryExecutionController {

    @Autowired
    QueryService queryService;

    @RequestMapping(value="/query", method = RequestMethod.POST)
    public List executeQuery(@RequestParam("query") String query) {
        try {
            return queryService.processSelectQuery(query);
        } catch (SQLException e) {
            return null;
        }
    }
}
