package controllers.tasks;

import tasks.ExerciseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import queries.QueryService;
import tasks.ExerciseTaskService;

import java.util.List;

/**
 * Created by Marcin on 2016-08-30.
 */
@RestController
@RequestMapping(value = "/tasks/ex")
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
        return exerciseTaskService.getExerciseTyskById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addExerciseTask(@RequestBody ExerciseTask exerciseTask) {
        exerciseTaskService.saveExerciseTask(exerciseTask);
    }
}
