package rest.controllers.tasks;

import model.tasks.ExerciseTask;
import model.tasks.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.wrappers.QueryResult;
import services.queries.QueryService;
import services.tasks.ExerciseTaskService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2016-08-30.
 */
@RestController
@RequestMapping(value = "/tasks")
public class ExerciseTaskController {

    @Autowired
    ExerciseTaskService exerciseTaskService;

    @Autowired
    QueryService queryService;

    @RequestMapping(value = "/ex", method = RequestMethod.GET)
    public List<ExerciseTask> getAllExerciseTasks() {
        return exerciseTaskService.getAllExerciseTasks();
    }

    @RequestMapping(value = "/ex/single", method = RequestMethod.GET)
    public ExerciseTask getSingleExerciseTask(@RequestParam("id") Long id) {
        return exerciseTaskService.getExerciseTyskById(id);
    }

    @RequestMapping(value = "/ex/add", method = RequestMethod.POST)
    public void addExerciseTask(@RequestParam("desc") String description, @RequestParam("query") String query, @RequestParam("category") String category) {
        exerciseTaskService.saveExerciseTask(new ExerciseTask(description, query, category));
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public QueryResult checkIfQueryIsCorrect(@RequestParam("query") String query, @RequestParam("taskid") Long id) {
        List<Map<String, String>> result = null;
        boolean ifCorrect = true;
        try {
            result = queryService.processSelectQuery(query);
        } catch (SQLException e) {
            return new QueryResult(false, null);
        }

        Task chosenTask = exerciseTaskService.getExerciseTyskById(id);
        String checkingQuery = queryService.buildResultsComparingQuery(query, chosenTask.getExampleCorrectQuery());
        try {
            List<Map<String, String>> diff = queryService.processSelectQuery(checkingQuery);
            if (diff.size() == 0) ifCorrect = true;
        } catch (SQLException e) {
            ifCorrect = false;
        }
        return new QueryResult(ifCorrect, result);
    }
}
