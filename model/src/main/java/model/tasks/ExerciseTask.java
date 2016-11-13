package model.tasks;

import model.categories.Category;
import model.common.EntityWithId;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ExerciseTask extends EntityWithId implements Task {

    private String description;
    private String exampleCorrectQuery;

    @ManyToOne
    private Category category;

    public ExerciseTask() {
    }

    public ExerciseTask(String description, String exampleCorrectQuery, Category category) {
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

    @Override
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isOverdue() { return false; }
}
