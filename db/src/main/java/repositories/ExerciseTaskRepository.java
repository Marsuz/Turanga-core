package repositories;

import model.categories.Category;
import model.tasks.ExerciseTask;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Marcin on 2016-08-30.
 */
public interface ExerciseTaskRepository extends CrudRepository<ExerciseTask, Long> {

    public List<ExerciseTask> findByCategory(Category category);
}
