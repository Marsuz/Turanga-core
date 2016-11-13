package services.tasks;

import model.categories.Category;
import model.tasks.ExerciseTask;
import repositories.CategoryRepository;
import repositories.ExerciseTaskRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    public ExerciseTask getExerciseTaskById(Long id) {
        return exerciseTaskRepository.findOne(id);
    }

    public List<ExerciseTask> getAllExerciseTasks() {
        return (List<ExerciseTask>) exerciseTaskRepository.findAll();
    }

    public void saveExerciseTask(ExerciseTask task) {
        exerciseTaskRepository.save(task);
    }

    public List<ExerciseTask> getExerciseTasksForGivenCategory(Long catId) {
        Category category = categoryRepository.findOne(catId);
        return exerciseTaskRepository.findByCategory(category);
    }
}
