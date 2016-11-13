package controllers.tasks;

import model.tasks.ExerciseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.queries.QueryService;
import services.tasks.ExerciseTaskService;

import java.util.List;

/**
 * Created by Marcin on 2016-08-30.
 */
@RestController
@RequestMapping(value = "/tasks")
@CrossOrigin(origins="http://localhost:3000")
public class ExerciseTaskController {

    @Autowired
    ExerciseTaskService exerciseTaskService;

    @Autowired
    QueryService queryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ExerciseTask> getAllExerciseTasks() {
        return exerciseTaskService.getAllExerciseTasks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExerciseTask getSingleExerciseTask(@PathVariable Long id) {
        return exerciseTaskService.getExerciseTaskById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addExerciseTask(@RequestBody ExerciseTask exerciseTask) {
        exerciseTaskService.saveExerciseTask(exerciseTask);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public List<ExerciseTask> getAllTasksForGivenCategory(@PathVariable Long id) {
        return exerciseTaskService.getExerciseTasksForGivenCategory(id);
    }
}
