package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.QueryService;

import java.util.List;

/**
 * Created by Marcin on 2016-08-20.
 */
@RestController
public class QueryController {

    @Autowired
    QueryService queryService;

    @RequestMapping(value="/query", method = RequestMethod.POST)
    public List executeQuery(@RequestParam("query") String query) {
        return queryService.processSelectQuery(query);
    }
}
