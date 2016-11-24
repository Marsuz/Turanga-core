package model.tasks;

import model.categories.Category;


public interface Task {

    public String getDescription();
    public void setDescription(String description);

    public String getExampleCorrectQuery();
    public void setExampleCorrectQuery(String query);

    public Category getCategory();
    public void setCategory(Category category);
}
