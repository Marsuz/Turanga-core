package rest.controllers.tasks;

import model.tasks.ExerciseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.queries.QueryService;
import services.tasks.ExerciseTaskService;

import java.util.List;

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
}
