package services.queries;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import wrappers.QueryResult;

import static org.junit.Assert.*;

/**
 * Created by mzajda on 24/11/2016.
 */
public class QueryServiceTest {

    QueryService queryService;

    @BeforeClass
    public void beforeClass() {
        //queryService = new QueryService();
    }

    @org.junit.Test
    public void shouldProcessQuery() throws Exception {
        String query = "selecy * from actor";

        QueryResult result = queryService.processQuery(query);

    }

    @org.junit.Test
    public void processQuery1() throws Exception {

    }

    @org.junit.Test
    public void processQuery2() throws Exception {

    }

}