package services.tasks;

import db.repositories.ExerciseTaskRepository;
import model.tasks.ExerciseTask;
import model.tasks.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marcin on 2016-08-30.
 */

@Service
public class ExerciseTaskService {

    @Autowired
    private ExerciseTaskRepository exerciseTaskRepository;

    public List<ExerciseTask> getAllExercieTasks() {
        return (List<ExerciseTask>) exerciseTaskRepository.findAll();
    }

    public void saveExerciseTask(ExerciseTask task) {
        exerciseTaskRepository.save(task);
    }
}
