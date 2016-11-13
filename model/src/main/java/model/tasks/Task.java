package model.tasks;

import model.categories.Category;

/**
 * Created by Marcin on 2016-08-30.
 */
public interface Task {

    public String getDescription();
    public void setDescription(String description);

    public String getExampleCorrectQuery();
    public void setExampleCorrectQuery(String query);

    public Category getCategory();
    public void setCategory(Category category);
}
