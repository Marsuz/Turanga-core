package rest.tasks;

import db.repositories.ExerciseTaskRepository;
import model.tasks.ExerciseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/exercises/all", method = RequestMethod.GET)
    public List<ExerciseTask> getAllExerciseTasks() {
        return exerciseTaskService.getAllExercieTasks();
    }

    @RequestMapping(value = "/exercises/add", method = RequestMethod.POST)
    public void addExerciseTask(@RequestParam("descripton") String description, @RequestParam("correctQuery") String query, @RequestParam("category") String category) {
        exerciseTaskService.saveExerciseTask(new ExerciseTask(description, query, category));
    }

}
