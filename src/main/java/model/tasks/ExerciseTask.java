package model.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Marcin on 2016-08-30.
 */

@Entity
public class ExerciseTask implements Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    @JsonIgnore
    private String exampleCorrectQuery;
    private String category;

    public ExerciseTask() {
    }

    public ExerciseTask(String description, String exampleCorrectQuery, String category) {
        this.description = description;
        this.exampleCorrectQuery = exampleCorrectQuery;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
