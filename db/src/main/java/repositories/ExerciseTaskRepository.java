package repositories;

import tasks.ExerciseTask;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Marcin on 2016-08-30.
 */
public interface ExerciseTaskRepository extends CrudRepository<ExerciseTask, Long> {
}
