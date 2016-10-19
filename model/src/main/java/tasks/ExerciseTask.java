package tasks;

import common.EntityWithId;

import javax.persistence.Entity;

/**
 * Created by Marcin on 2016-08-30.
 */

@Entity
public class ExerciseTask extends EntityWithId implements Task {

    private String description;
    private String exampleCorrectQuery;
    private String category;

    public ExerciseTask() {
    }

    public ExerciseTask(String description, String exampleCorrectQuery, String category) {
        this.description = description;
        this.exampleCorrectQuery = exampleCorrectQuery;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExampleCorrectQuery() {
        return exampleCorrectQuery;
    }

    public void setExampleCorrectQuery(String exampleCorrectQuery) {
        this.exampleCorrectQuery = exampleCorrectQuery;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
